package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import config.PasswordEncryptionService;

import java.util.Date;

//to do: insert with some of the fields, update with some of the fields, try-catch

@Controller
@RequestMapping(path = "/parents")

public class ParentController {
	@Autowired
	private ParentRepository pRepository;

	public parent createParent(String pem,String fn,
			 String ln,  String un,
			 String pas, byte[] salt,  String pn,
			 String sname,  int snumber,
			 String pc,  String t) {

		if (pRepository.findOne(pem)!=null) 
			return null;
		else {
			parent pa = new parent(pem, fn, ln, un, pas, salt,  pn, sname, snumber,pc,t);
			pRepository.save(pa);
			bucket b= new bucket(pa,0,0);
			b.setPemail(pem);
			//b.setBucketId(12);
		    pa.setParentbucket(b);
			pRepository.save(pa);
			return pa;
		}
	}
	
	@GetMapping(path = "/add")
	public @ResponseBody
	String addNewUser(@RequestParam String pem, @RequestParam String fn,
			@RequestParam String ln, @RequestParam String un,
			@RequestParam String pas,@RequestParam byte[] salt, @RequestParam String pn,
			@RequestParam String sname, @RequestParam int snumber,
			@RequestParam String t, @RequestParam String pc) {

		if (pRepository.findOne(pem)!=null) 
			return "Parent with this Email already exists!";
		else {
			parent np = new parent(pem, fn, ln, un, pas, salt, pn, sname, snumber, t, pc);
			pRepository.save(np);
			bucket b= new bucket(np,0,0);
			b.setPemail(pem);
			//b.setBucketId(12);
		    np.setParentbucket(b);
			pRepository.save(np);
			return "New Parent Saved";
			//everything else with setters
		}
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
		// This returns a JSON or XML with the user
		if (pRepository.findOne(pem)==null) 
			return null; //something else here
		return pRepository.findOne(pem);
	}
	
	@GetMapping(path = "/delete")
	public @ResponseBody
	String DeleteUser(@RequestParam String pem) {
		parent p = pRepository.findOne(pem);
	    if (p==null) 
			return "Parent not found!";
	    int id=p.getParentbucket().bucketid;
	    p.setParentbucket(null);
	    pRepository.delete(pem);
		return "Delete this";
	}

	
	public parent UpdateUser(String pem) {
		parent p = pRepository.findOne(pem);
		if (p==null)
			return null;
		pRepository.save(p);
		return p;
	}
	
	public parent getParentByEmailAndPassw (String pem, String passw) {
		
		PasswordEncryptionService encryption_service = new PasswordEncryptionService(); 
		parent par= this.getΑParent(pem);
		
		if (par != null) {
			String encryptedPassword = par.getPassword();
			if (/*par.getPassword().equals(passw)*/ encryption_service.authenticate(passw, encryptedPassword, par.getSalt()))
				return par;
				
		}
		return null;
	}
	
	
	
	
}

