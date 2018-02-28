package ch2;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;

public interface MailService {

	
	public void sendMail(MimeMessage message, MimeMessageHelper helper, String To, String Text, String Subject) throws MessagingException  ; 
}
