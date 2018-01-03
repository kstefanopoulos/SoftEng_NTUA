package ch2;

import javax.persistence.*;

@Entity
public class administrator {

	@Id
	private String email;
	
	private String first_name;
	private String last_name;
	private String username;
	private int password;
	private String phone_number;
	private String account;
	
	public administrator() {}
	
	public administrator(String em, String fn, String ln, String un, int pas, String pn) {
		
		this.email=em;
		this.first_name=fn;
		this.last_name=ln;
		this.username=un;
		this.password=pas;
		this.phone_number=pn;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	
}
