package ch2;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class willattend implements Serializable, Comparable<willattend>{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@ManyToOne
    @JoinColumn(name = "pemail")
	public parent aparent;
	
	@ManyToOne
    @JoinColumn(name = "eventid")
	@JsonIgnore
	public event anevent;
	
	public Date date;
	
	public Date time;
	
	public int valid;
	
	public int tickets;
	
	public willattend() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public parent getAparent() {
		return aparent;
	}

	public void setAparent(parent aparent) {
		this.aparent = aparent;
	}

	
	public event getAnevent() {
		return anevent;
	}

	public void setAnevent(event anevent) {
		this.anevent = anevent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public int compareTo(willattend o) {
		// TODO Auto-generated method stub
		return this.date.compareTo(o.date);

	}

	
	
}
