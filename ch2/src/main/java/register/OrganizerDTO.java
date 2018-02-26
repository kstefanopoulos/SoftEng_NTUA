package register;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class OrganizerDTO {

	  @NotNull
	  @NotEmpty
	  private String companyname ;
	
	  @NotNull
	  @NotEmpty
	  private String firstname ;


	  @NotNull
	  @NotEmpty
	  private String lastname ;
	     

	  @NotNull
	  @NotEmpty
	  private String streetname;
	  
	  @NotNull
	  @NotEmpty
	  private String town;
	  
	  @NotNull
	  @NotEmpty 
	  private String streetnumber;
	  
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
	  private String afm;
	  
	  @NotNull
	  @NotEmpty
	  private String bankacount;
	  
	  @NotNull
	  @NotEmpty
	  private String username;
	  
	  @NotNull
	  @NotEmpty
	  private String password;

	  // Getters - Setters 
	  
	  
	  
	public String getFirstname() {
		return firstname;
	}

	public String getCompanyname() {
		return companyname;
	}
	  

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
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

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public String getBankacount() {
		return bankacount;
	}

	public void setBankacount(String bankacount) {
		this.bankacount = bankacount;
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

	public  String getStreetnumber() {
		return streetnumber;
	}

	public void setStreetnumber(String streetnumber) {
		this.streetnumber = streetnumber;
	}
	  
	

	

}
