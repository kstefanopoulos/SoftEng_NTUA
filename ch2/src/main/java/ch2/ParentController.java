package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//to do: insert with some of the fields, update with some of the fields, try-catch

@Controller
@RequestMapping(path = "/parents")
public class ParentController {
	@Autowired
	private ParentRepository pRepository;

	@GetMapping(path = "/add")
	// Map ONLY GET Requests
	public @ResponseBody
	String addNewUser(@RequestParam String pem, @RequestParam String fn,
			@RequestParam String ln, @RequestParam String un,
			@RequestParam String pas, @RequestParam String pn,
			@RequestParam String sname, @RequestParam int snumber,
			@RequestParam String t, @RequestParam String pc) {

		parent np = new parent(pem, fn, ln, un, pas, pn, sname, snumber, t, pc);
		bucket b= new bucket(np,0,0);
		b.setPemail(pem);
		np.setParentbucket(b);
		pRepository.save(np);
		return "New Parent Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<parent> getAllParents() {
		// This returns a JSON or XML with the users
		return pRepository.findAll();
	}

	@GetMapping(path = "findOne")
	public @ResponseBody
	parent getΑParent(@RequestParam String pem) {
		// This returns a JSON or XML with the users
		return pRepository.findOne(pem);
	}
	
	@GetMapping(path = "/delete")
	public @ResponseBody
	String DeleteUser(@RequestParam String pem) {
		pRepository.delete(pem);
		return "Delete this";
	}

	@GetMapping(path = "/update")
	public @ResponseBody
	String UpdateUser(@RequestParam String pem, @RequestParam String street) {
		parent p = pRepository.findOne(pem);
		p.setStreet_name(street);
		pRepository.save(p);
		return "Update this";
	}
}

