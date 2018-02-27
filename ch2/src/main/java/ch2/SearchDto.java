package ch2;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class SearchDto {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startdate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enddate;
	
	private String startage;
	
	private String endage;
	
	private String category ;
	
	
	private String maxcost;
	
	private String town ;
	 
	private String streetname;
	  
	private String streetnumber;
	
	private String width;

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getStartage() {
		return startage;
	}

	public void setStartage(String startage) {
		this.startage = startage;
	}

	public String getEndage() {
		return endage;
	}

	public void setEndage(String endage) {
		this.endage = endage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMaxcost() {
		return maxcost;
	}

	public void setMaxcost(String maxcost) {
		this.maxcost = maxcost;
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

	public String getStreetnumber() {
		return streetnumber;
	}

	public void setStreetnumber(String streetnumber) {
		this.streetnumber = streetnumber;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}
	
	
	

}
