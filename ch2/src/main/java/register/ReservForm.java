package register;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import ch2.eventinfo;


public class ReservForm {
	
	  private List<eventinfo> ei_list;
	
	  @NotNull
	  private int numberoftickets ;

	

	public ReservForm() {}

	public int getNumberoftickets() {
		return numberoftickets;
	}

	public void setNumberoftickets(int numberoftickets) {
		this.numberoftickets = numberoftickets;
	}

	public List<eventinfo> getEi_list() {
		return ei_list;
	}

	public void setEi_list(List<eventinfo> ei_list) {
		this.ei_list = ei_list;
	}

	

	
	
	
	
	  
	  

}
