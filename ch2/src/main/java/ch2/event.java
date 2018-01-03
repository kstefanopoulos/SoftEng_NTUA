package ch2;

import javax.persistence.*;

import java.util.Set;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class event {
	
	@Id
	public int eventid;
	
	@ManyToOne
    @JoinColumn(name = "organizer_email")
    @JsonIgnore
	public organizer myorganizer;
	public String event_name;
	public String event_date;
	public String start_time;
	public String available_tickets;
	public int event_cost;
	public String street_name;
	public int street_number;
	public String postal_code;
	public String town;
	public String ages;
	public String event_class;
	public String event_description;
	public int evaluation;
	public int isdone;
	
    @OneToMany(mappedBy = "anevent")
    @JsonIgnore
    private Set<consistsof> contained;
    
    @OneToMany(mappedBy = "anevent")
    @JsonIgnore
    private Set<willattend> willbeattented;
    
    @OneToMany(mappedBy = "anevent")
    @JsonIgnore
    private Set<hasattended> hasattended;

	public event() {}
	
	public event (int id, organizer o, String en, String ed, String st, String at, int ec, String sname, int snumber, String pc, String t, String a, String edescr, int ev, int d  ) {
		
		this.eventid= id;
		this.myorganizer =o;
		this.event_name=en;
		this.event_date=ed;
		this.start_time=st;
		this.available_tickets=at;
		this.event_cost=ec;
		this.street_name=sname;
		this.street_number=snumber;
		this.postal_code=pc;
		this.town=t;
		this.ages=a;
		//this.event_class=eclass; 
		this.event_description=edescr;
		this.evaluation=ev;
		this.isdone=d;
	}

	public int getEventId() {
		return eventid;
	}

	public void setEventId(int eventId) {
		this.eventid = eventId;
	}

	
	
	public organizer getMyorganizer() {
		return myorganizer;
	}

	public void setMyorganizer(organizer myorganizer) {
		this.myorganizer = myorganizer;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getAvailable_tickets() {
		return available_tickets;
	}

	public void setAvailable_tickets(String available_tickets) {
		this.available_tickets = available_tickets;
	}

	public int getEvent_cost() {
		return event_cost;
	}

	public void setEvent_cost(int event_cost) {
		this.event_cost = event_cost;
	}

	public String getStreet_name() {
		return street_name;
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

	public String getAges() {
		return ages;
	}

	public void setAges(String ages) {
		this.ages = ages;
	}

	public String getEvent_class() {
		return event_class;
	}

	public void setEvent_class(String event_class) {
		this.event_class = event_class;
	}

	public String getEvent_description() {
		return event_description;
	}

	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public int getIsdone() {
		return isdone;
	}

	public void setIsdone(int isdone) {
		this.isdone = isdone;
	}

	public Set<consistsof> getContained() {
		return contained;
	}

	public void setContained(Set<consistsof> contained) {
		this.contained = contained;
	}

	public Set<willattend> getWillbeattented() {
		return willbeattented;
	}

	public void setWillbeattented(Set<willattend> willbeattented) {
		this.willbeattented = willbeattented;
	}

	public Set<hasattended> getHasattended() {
		return hasattended;
	}

	public void setHasattended(Set<hasattended> hasattended) {
		this.hasattended = hasattended;
	}
	
	

}