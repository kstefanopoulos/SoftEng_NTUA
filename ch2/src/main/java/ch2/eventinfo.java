package ch2;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.Set;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class eventinfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eventinfoId")
	public int eventinfoId;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "eventid")
    @JsonIgnore
	public event myevent;
	
	public Date eventdate;
	
	public int availabletickets;
	
	public Date starttime;
	
	public eventinfo () {}
	
	public eventinfo(Date eventdate, int availabletickets, Date starttime) {
		
		this.eventdate = eventdate;
		this.availabletickets = availabletickets;
		this.starttime = starttime;
	}

	public int getEventinfoId() {
		return eventinfoId;
	}

	public void setEventinfoId(int eventinfoId) {
		this.eventinfoId = eventinfoId;
	}

	public event getMyevent() {
		return myevent;
	}

	public void setMyevent(event myevent) {
		this.myevent = myevent;
	}

	public Date getEventdate() {
		return eventdate;
	}

	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}

	public int getAvailabletickets() {
		return availabletickets;
	}

	public void setAvailabletickets(int availabletickets) {
		this.availabletickets = availabletickets;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	
	
	

}
