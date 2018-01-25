package ch2;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class consistsof implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@ManyToOne
    @JoinColumn(name = "bucketid")
    @JsonIgnore
	public bucket abucket;
	
	@ManyToOne
    @JoinColumn(name = "eventid")
	@JsonIgnore
	public event anevent;
	
	public consistsof() {}
	
	public consistsof(int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public bucket getAbucket() {
		return abucket;
	}

	public void setAbucket(bucket abucket) {
		this.abucket = abucket;
	}

	
	public event getAnevent() {
		return anevent;
	}

	public void setAnevent(event anevent) {
		this.anevent = anevent;
	}
	
	
}
