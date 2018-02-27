package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice 
public class UserController {

	@Autowired 
	private UserRepository uRepository ; 
	
	public users addNewUser(String uem, int type){ 
		if (uRepository.findOne(uem)!=null) 
			return null;
		else {
			users u = new users(uem,type); 
			uRepository.save(u);
			return u ;
			//return "New Organizer Saved";
			//everything else with setters
		}
	}
	
	
	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<users> getAllUsers() {
		// This returns a JSON or XML with the users
		return uRepository.findAll();
	}
	
	@GetMapping(path = "findOne")
	public @ResponseBody
	users getΑUser(String uem) {
		// This returns a JSON or XML with the user
		if (uRepository.findOne(uem)==null) 
			return null; //something else here
		return uRepository.findOne(uem);
	}

	public int getTypeByEmail(String uem) {
		int type = -1  ; 
		users u= this.getΑUser(uem);
		if (u != null) {
		     type = u.getType(); 
		}
		return type ;
	}
	
	
	
	
}
