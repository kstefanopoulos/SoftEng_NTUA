package register;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class EventDTO {
	
	  @NotNull
	  @NotEmpty
	  private String title ;
	  
	  @NotNull
	  private int price ;
	  
	  @NotNull
	  private int startage ;
	  
	  @NotNull
	  private int endage ;
	  
	  @NotNull
	  @NotEmpty
	  private String town ;
	  
	  @NotNull
	  @NotEmpty
	  private String category ;
	 
	  
	  @NotNull
	  @NotEmpty
	  private String streetname;
	  
	  @NotNull
	  private int streetnumber;
	  
	  @NotNull
	  @NotEmpty
	  private String postalcode;
	  
	  @NotNull
	  private int duration;	  
	  
	  @NotNull
	  @NotEmpty
	  private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public int getStreetnumber() {
		return streetnumber;
	}

	public void setStreetnumber(int streetnumber) {
		this.streetnumber = streetnumber;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
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


	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	  
	
	  
}
