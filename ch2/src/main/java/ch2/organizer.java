package ch2;
import java.util.Date;

import javax.persistence.*;
import java.util.Set;


@Entity
public class organizer {
	
	@Id
	private String oemail;
	
	private String company_name;
	private String bank_account;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private String  phone_number;
	private float balance;  //starts from 0
	private String street_name;
	private String street_number;
	private String postal_code;
	private String town;
	private String afm;
	private Date registration_date;
	private int evaluation; //starts from 0
	private int restrictions; 
	


	@OneToMany(mappedBy = "myorganizer", cascade = CascadeType.ALL)
    private Set<event> events;
	
	public organizer() {}
	
	public organizer(String oem, String cn, String ba, String fn, String ln, String u, String p, String pn, String sname, String snumber, String pc, String t, String afm,int res ) {
		
		this.oemail=oem;
		this.company_name=cn;
		this.bank_account=ba;
		this.first_name=fn;
		this.last_name=ln;
		this.username=u;
		this.password=p;
		this.phone_number=pn;
		this.balance=0;
		this.street_name=sname;
		this.street_number=snumber;
		this.postal_code=pc;
		this.town=t;
		this.afm=afm;
		this.registration_date=new Date();
		this.evaluation=0;
		this.restrictions = res  ; 
	
	}
	
    public int getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(int restrictions) {
		this.restrictions = restrictions;
	}
	
	
	public String getOemail() {
		return oemail;
	}

	public void setOemail(String oemail) {
		this.oemail = oemail;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	
    public Set<event> getEvents() {
		return events;
	}

	public void setEvents(Set<event> events) {
		this.events = events;
	}
	
	
	

}
