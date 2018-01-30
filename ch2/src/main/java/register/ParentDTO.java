package register;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ParentDTO {

	@NotNull
	  @NotEmpty
	  private String firstname ;


	  @NotNull
	  @NotEmpty
	  private String lastname ;
	     
	  
	  @NotNull
	  @NotEmpty
	  private String town ;
	 
	  
	  @NotNull
	  @NotEmpty
	  private String streetname;
	  
	  @NotNull
	  @NotEmpty
	  private int streetnumber;
	  
	  @NotNull
	  @NotEmpty
	  private String postalcode;
	  
	  
	  @NotNull
	  @NotEmpty
	  private String phonenumber;
	  
	  @ValidEmail
	  @NotNull
	  @NotEmpty
	  private String email;
	  
	
	  @NotNull
	  @NotEmpty
	  private String username;
	  
	  @NotNull
	  @NotEmpty
	  private String password;

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

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public int getStreetnumber() {
		return streetnumber;
	}

	public void setStreetnumber(int streetnumber) {
		this.streetnumber = streetnumber;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}