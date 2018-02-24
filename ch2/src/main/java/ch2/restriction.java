package ch2;

import org.springframework.data.annotation.Id;

public class restriction  {
	
	@Id 
	private int id ; 

	private String description ;
	
	public restriction() {}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	
	
}
