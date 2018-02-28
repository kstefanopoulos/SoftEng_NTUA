package config;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordEncryptionService {

 public boolean authenticate(String attemptedPassword, String encryptedPassword, byte[] salt)
  /* throws NoSuchAlgorithmException, InvalidKeySpecException */{
  // Encrypt the clear-text password using the same salt that was used to
  // encrypt the original password
  String encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);
  byte[] encryptedAttemptedPasswordByte = encryptedAttemptedPassword.getBytes();
  byte[] attemptedPasswordByte = attemptedPassword.getBytes();
  // Authentication succeeds if encrypted password that the user entered
  // is equal to the stored hash
  return Arrays.equals(encryptedAttemptedPasswordByte, encryptedAttemptedPasswordByte);
 }

 public String getEncryptedPassword(String password, byte[] salt)
  /* throws NoSuchAlgorithmException, InvalidKeySpecException*/ {
  // PBKDF2 with SHA-1 as the hashing algorithm. Note that the NIST
  // specifically names SHA-1 as an acceptable hashing algorithm for PBKDF2
  String algorithm = "PBKDF2WithHmacSHA1";
  byte[] hashed_bytes = null;
  // SHA-1 generates 160 bit hashes, so that's what makes sense here
  int derivedKeyLength = 160;
  // Pick an iteration count that works for you. The NIST recommends at
  // least 1,000 iterations:
  // http://csrc.nist.gov/publications/nistpubs/800-132/nist-sp800-132.pdf
  // iOS 4.x reportedly uses 10,000:
  // http://blog.crackpassword.com/2010/09/smartphone-forensics-cracking-blackberry-backup-passwords/
  int iterations = 20000;

  KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);

  SecretKeyFactory f = null;
  
  try {
	  f = SecretKeyFactory.getInstance(algorithm);
  }catch(NoSuchAlgorithmException e) {
	  System.out.println("No such algo encrypt");
  }

  try {
	  hashed_bytes = f.generateSecret(spec).getEncoded();
  }catch(InvalidKeySpecException k) {
	  System.out.println("Invalid key salt");
  }
  
  String str = new String(hashed_bytes, StandardCharsets.UTF_8);
  return str;
  //return hashed_bytes;
 }

 public byte[] generateSalt() /*throws NoSuchAlgorithmException*/ {
  // VERY important to use SecureRandom instead of just Random
	 SecureRandom random = null;
  try {
	  random = SecureRandom.getInstance("SHA1PRNG");
  } catch(NoSuchAlgorithmException e) {
		System.out.println("No such algo salt");
  }

  // Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
  byte[] salt = new byte[8];
  
  random.nextBytes(salt);
  //System.out.println("generated salt");
  
//String s = "satl";
 //byte[] salt = s.getBytes();
  return salt;
 }
}


