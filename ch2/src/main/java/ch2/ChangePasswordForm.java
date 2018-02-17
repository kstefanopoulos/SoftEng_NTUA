package ch2;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePasswordForm {

	  @NotNull
	  @NotEmpty
	  private String email;
	
	  @NotNull
	  @NotEmpty
	  private String old;
	  
	  @NotNull
	  @NotEmpty
	  private String first;
	  
	  @NotNull
	  @NotEmpty
	  private String second;

	  
	  
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}
	  
	  
	
}
