package register;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AdministratorDTO {
	
	 @NotEmpty 
     @NotNull 
	  private String Email ; 

	
	  @NotNull
	  @NotEmpty
	  private String firstname ;

	  @NotNull
	  @NotEmpty
	  private String lastname ;
	     
	  @NotNull
	  @NotEmpty
	  private String username;
	  
	  @NotNull
	  @NotEmpty
	  private String password;
	
	  @NotNull
	  @NotEmpty
	  private String phonenumber;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
