package ch2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class restrictions  {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rid ; 

	private String description ;
	
	private int renum ; 
	

	
	public restrictions() {}
	
	
    public restrictions(int renum , String desc){
    	
    	this.description = desc; 
    	this.renum = renum ; 
    	
    	
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	
	
}
