package ch2;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class hasattended implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@ManyToOne
    @JoinColumn(name = "pemail")
	@JsonIgnore
	public parent aparent;
	
	@ManyToOne
    @JoinColumn(name = "eventid")
	public event anevent;
	public int isfavorite;
	
	public hasattended() {}
	
	public hasattended(int id) {
		this.id=id;
	}

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

	public int getIsfavorite() {
		return isfavorite;
	}

	public void setIsfavorite(int isfavorite) {
		this.isfavorite = isfavorite;
	}
	
	

}
