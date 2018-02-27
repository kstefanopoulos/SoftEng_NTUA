package register;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BlockedDTO {

	@NotNull 
	@NotEmpty 
	private String Email ; 
	@NotNull 
	private int renum ; 
		
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getRenum() {
		return renum;
	}
	public void setRenum(int renum) {
		this.renum = renum;
	}

	
	
	
	
}
