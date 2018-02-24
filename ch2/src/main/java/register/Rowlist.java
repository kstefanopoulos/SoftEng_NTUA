package register;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

public class Rowlist {
	
	@Valid
	private List<Row> myRows ; 

	public Rowlist () {} 
	
	public Rowlist(List<Row> myRows) {
		this.myRows = myRows;
	}

	public List<Row> getMyRows() {
		return myRows;
	}

	public void setMyRows(List<Row> myRows) {
		this.myRows = myRows;
	}
	
	
	

}
