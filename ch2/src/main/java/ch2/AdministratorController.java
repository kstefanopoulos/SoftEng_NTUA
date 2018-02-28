package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import config.PasswordEncryptionService;

@Controller
@RequestMapping(path = "/administrator")
public class AdministratorController {
	
	@Autowired
	private AdministratorRepository aRepository;
	@Autowired
	private ParentRepository pRepository ;
	@Autowired
	private OrganizerRepository oRepository ; 
	@Autowired
	private RestrictionRepository rRepository; 

	PasswordEncryptionService encryption_service  = new PasswordEncryptionService(); 

	@GetMapping(path = "/add")
	public @ResponseBody
	String addNewAdmin(@RequestParam String aem, @RequestParam String fn,
			@RequestParam String ln, @RequestParam String un,
			@RequestParam String pas, @RequestParam String pn, @RequestParam int res){

		if (aRepository.findOne(aem)!=null) 
			return "Administrator with this Email already exists!";
		else {
			
			byte[] salt = encryption_service.generateSalt();
			String hash_pass = encryption_service.getEncryptedPassword(pas, salt);
			administrator na = new administrator(aem,fn, ln, un, pas, salt, pn,res); 
			aRepository.save(na);
			aRepository.save(na);
			return "New Administrator Created";
			
		}
	}
	


@GetMapping(path = "/alladmins")
public @ResponseBody
Iterable<administrator> getAllAdministrators() {
	// This returns a JSON or XML with the administrators
	return aRepository.findAll();
}


@GetMapping(path="/allparents")
public @ResponseBody 
Iterable<parent> AdmingetAllparents(){
	return pRepository.findAll() ; 
	
}

@GetMapping(path="/allorganizers")
public @ResponseBody 
Iterable<organizer> AdmingetAllorganizers(){
	return oRepository.findAll() ; 
}

@GetMapping(path="/allrestrictions")
public @ResponseBody 
Iterable<restrictions> AdmingetAllrestrictions(){ 
	return rRepository.findAll() ; 
}



@GetMapping(path = "findOneParent")
public @ResponseBody
parent AdmingetΑParent(@RequestParam String pem) {
	// This returns a JSON or XML with the user
	if (pRepository.findOne(pem)==null) 
		return null; //something else here
	return pRepository.findOne(pem);
}


@GetMapping(path = "findOneOrganizer")
public @ResponseBody
organizer AdmingetΑnOrganizer(@RequestParam String oem) {
	// This returns a JSON or XML with the user
	if (oRepository.findOne(oem)==null) 
		return null; //something else here
	return oRepository.findOne(oem);
}

@GetMapping(path = "findOneAdmin")
public @ResponseBody
administrator getΑnAdmin ( @RequestParam String aem) {
	// This returns a JSON or XML with the user
	if (aRepository.findOne(aem)==null) 
		return null; //something else here
	return aRepository.findOne(aem);
}


public administrator getAdministratorByEmailAndPassw (String aem, String passw) {
	
	administrator adm  = this.getΑnAdmin(aem);
	if (adm != null) {
		String encryptedPassword = adm.getPassword();
		if (encryption_service.authenticate(passw, encryptedPassword, adm.getSalt()))
			return adm;
			
	}
	return null;
}	

public administrator createNewAdmin(String email ,String fn, String ln, String un, String pas,String pn,int res) {

		byte[] salt = encryption_service.generateSalt();
		String hash_pass = encryption_service.getEncryptedPassword(pas, salt);
		administrator newad = new administrator(email,fn,ln,un,hash_pass,salt,pn,res);
		System.out.println("new admin ok");
		//System.out.println(email + fn + ln +  un +  pas + pn);
		aRepository.save(newad); 
		System.out.println("Saved new admin ok");
		return newad;
	}


public administrator getAdminByEmail (String aem) {
	
	administrator adm  = this.getΑnAdmin(aem);
	if (adm != null) {
			return adm;
			
	}
	return null;
}

public administrator UpdateAdminRestrictions(String aem,int res){
	
	administrator a = aRepository.findOne(aem);
	a.setRestrictions(res);
	if(a==null) return null ; 
	aRepository.save(a) ; 
	return a ; 
	
}



}


