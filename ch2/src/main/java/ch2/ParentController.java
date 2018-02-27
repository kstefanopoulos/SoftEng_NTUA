package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import register.ParentDTO;

import java.util.Date;

//to do: insert with some of the fields, update with some of the fields, try-catch

@Controller
@RequestMapping(path = "/parents")

public class ParentController {
	@Autowired
	private ParentRepository pRepository;

	public parent createParent(String pem,String fn,
			 String ln,  String un,
			 String pas,  String pn,
			 String sname,  int snumber,
			 String pc,  String t, int res) {

		if (pRepository.findOne(pem)!=null) 
			return null;
		else {
			parent pa = new parent(pem, fn, ln, un, pas, pn, sname, snumber,pc,t, res);
			pRepository.save(pa);
			bucket b= new bucket(pa,0,0);
			b.setPemail(pem);
			//b.setBucketId(12);
		    pa.setParentbucket(b);
			pRepository.save(pa);
			return pa;
		}
	}
	
	public parent createParentAccount(ParentDTO accountDto, BindingResult result) {
	    parent registered = null;
	    registered = createParent(accountDto.getEmail(),accountDto.getFirstname(),accountDto.getLastname(),accountDto.getUsername(),accountDto.getPassword(),accountDto.getPhonenumber(),accountDto.getStreetname(),
	    		accountDto.getStreetnumber(),accountDto.getTown(),accountDto.getPostalcode(),0);
	    
	    return registered;
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
		
		parent par= this.getΑParent(pem);
		if (par != null) {
			if (par.getPassword().equals(passw))
				return par;
				
		}
		return null;
	}
	
	public parent getParentByEmail(String pem) {
		
		parent par = this.getΑParent(pem);
		if (par!=null){
		    return par ; 	
		}
			
		return null; 
		
	} 
	
	public parent UpdateParentRestrictions(String pem,int res){
		
		parent p=pRepository.findOne(pem);
		if (p==null) 
			return null ; 
		p.setRestrictions(res);
		pRepository.save(p) ; 
		return p ; 
		
	}


	
	
}

