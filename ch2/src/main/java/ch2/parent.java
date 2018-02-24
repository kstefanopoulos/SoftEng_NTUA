package ch2;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.Set;

@Entity
public class parent {
	
	@Id
    private String pemail;
	
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private String phone_number;
	private int balance;
	private Date last_transaction_date;
	private String street_name;
	private int street_number;
	private String town;
	private String postal_code;
	

	@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "bucketid")
	private bucket parentbucket;
	
    @OneToMany(mappedBy = "aparent", cascade = CascadeType.ALL)
	private Set<willattend> willattend;
	
    @OneToMany(mappedBy = "aparent", cascade = CascadeType.ALL)
    private Set<hasattended> hasattended;
	
	public parent () {}

	public parent(String pem, String fn, String ln, String un, String pas, String pn, String sname, int snumber, String t, String pc) {
		
			this.pemail=pem;
			this.first_name = fn;
			this.last_name = ln;
			this.username=un;
			this.password = pas;
			this.phone_number= pn;
			this.street_name = sname;
			this.street_number = snumber;
			this.town = t;
			this.postal_code = pc;
		
	}

	public String getPemail() {
		return pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
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

	public String getStreet_name() {
		return street_name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getLast_transaction_date() {
		return last_transaction_date;
	}

	public void setLast_transaction_date(Date last_transaction_date) {
		this.last_transaction_date = last_transaction_date;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public int getStreet_number() {
		return street_number;
	}

	public void setStreet_number(int street_number) {
		this.street_number = street_number;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public bucket getParentbucket() {
		return parentbucket;
	}

	public void setParentbucket(bucket parentbucket) {
		this.parentbucket = parentbucket;
	}

	public Set<willattend> getWillattend() {
		return willattend;
	}

	public void setWillattend(Set<willattend> willattend) {
		this.willattend = willattend;
	}

	public Set<hasattended> getHasattended() {
		return hasattended;
	}

	public void setHasattended(Set<hasattended> hasattended) {
		this.hasattended = hasattended;
	}

  
	
}


