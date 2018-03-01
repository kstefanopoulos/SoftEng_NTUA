package ch2;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserCredentials {

	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String password;

	private int type;				//parent=0; organizer=1; admin=2;
	
	
	public UserCredentials() {}
	
	public UserCredentials(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
