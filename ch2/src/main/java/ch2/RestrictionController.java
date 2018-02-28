package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestrictionController {

	@Autowired
	private  RestrictionRepository rRepository;
	

	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<restrictions> getAllRestrictions() {
		// This returns a JSON or XML with the users
		return rRepository.findAll();
	}
	
	
}
