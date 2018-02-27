package ch2;

import javax.persistence.*;

@Entity
public class users {

	@Id
	private String email ; 
	private int type; 


	public users() {}
	
	public users( String em, int res ) {
		
		this.email=em ; 
		this.type=res ; 
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	
}

