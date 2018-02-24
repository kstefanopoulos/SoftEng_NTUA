package ch2;

import javax.persistence.*;

import java.util.Set;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class bucket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bucketid")
	public int bucketid;
	
	public int event_card;
	public int overall_cost;
	
    @OneToOne(mappedBy = "parentbucket", cascade = CascadeType.ALL)
    @JsonIgnore
    public parent myparent;
	public String pemail;
	
    @OneToMany(mappedBy = "abucket", cascade = CascadeType.ALL)
    private Set<consistsof> contains;

    
	public bucket() {}
	
	public bucket(parent mp, int ec, int oc) {
		
		this.myparent=mp;
		this.event_card=ec;
		this.overall_cost=oc;
	}

	public int getBucketId() {
		return bucketid;
	}

	public void setBucketId(int bucketId) {
		this.bucketid = bucketId;
	}


	public int getEvent_card() {
		return event_card;
	}

	public void setEvent_card(int event_card) {
		this.event_card = event_card;
	}

	public int getOverall_cost() {
		return overall_cost;
	}

	public void setOverall_cost(int overall_cost) {
		this.overall_cost = overall_cost;
	}

	 public parent getMyparent() {
		return myparent;
	}

	public void setMyparent(parent myparent) {
		this.myparent = myparent;
	} 

	public Set<consistsof> getContains() {
		return contains;
	}

	public void setContains(Set<consistsof> contains) {
		this.contains = contains;
	}

	public String getPemail() {
		return pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	
	

}
