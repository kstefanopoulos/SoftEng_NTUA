package register;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class CreditsForm {
	
	  @NotNull
	  @NotEmpty
	  private String type ;
	  
	  @NotNull
	  @NotEmpty
	  private String card_number ;
	  
	  @NotNull
	  @NotEmpty
	  private String code ;
	  
	  @NotNull
	  @NotEmpty
	  private String name ;
	  
	  @NotNull
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  private Date expdate;
	  
	  @NotNull
	  private int points;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getExpdate() {
		return expdate;
	}

	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	   
	
	  
	  

}
