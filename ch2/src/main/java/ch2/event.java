package ch2;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class event implements Comparable<event> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eventid")
	public int eventid;
	
	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "oemail")
    @JsonIgnore
	public organizer myorganizer;
	
	@OneToMany(mappedBy = "myevent", cascade = CascadeType.ALL)
    private Set<eventinfo> eventinfos;
    
	public String organizer_name;
	public String event_name;
	public int event_cost;
	public String street_name;
	public int street_number;
	public String postal_code;
	public String town;
	public int startage;
	public int endage;
	public String event_class;
	public String event_description;
	public String longitude; 
	public String latitude; 
	public int evaluation;
	public int isdone;
	public int duration;
	public int tickets;
	public Date createdat;
	
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
	
	public event (String en, int ec, String sname, int snumber, String pc, String t, int sa, int ea, int d,String cat) {
		
		//this.myorganizer =o;
		this.event_name=en;
		this.event_cost=ec;
		this.street_name=sname;
		this.street_number=snumber;
		this.postal_code=pc;
		this.town=t;
		this.startage=sa;
		this.endage=ea;
		this.evaluation=0;
		this.isdone=0;
		this.eventinfos= new HashSet<eventinfo>();
		this.duration=d;
		this.tickets=0;
		this.event_class = cat;
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

	public int getStartage() {
		return startage;
	}

	public void setStartage(int startage) {
		this.startage = startage;
	}

	public int getEndage() {
		return endage;
	}

	public void setEndage(int endage) {
		this.endage = endage;
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
	
	public String getOrganizer_name() {
		return organizer_name;
	}

	public void setOrganizer_name(String organizer_name) {
		this.organizer_name = organizer_name;
	}

	public Set<eventinfo> getEventinfos() {
		return eventinfos;
	}

	public void setEventinfos(Set<eventinfo> eventinfos) {
		this.eventinfos = eventinfos;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public int compareTo(event o) {
		// TODO Auto-generated method stub
		return this.createdat.compareTo(o.createdat);
	}
	
	

		
	
}
