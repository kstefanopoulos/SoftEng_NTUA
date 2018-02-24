package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping(path = "/add")
	public @ResponseBody
	String addNewAdmin(@RequestParam String aem, @RequestParam String fn,
			@RequestParam String ln, @RequestParam String un,
			@RequestParam String pas, @RequestParam String pn){

		if (aRepository.findOne(aem)!=null) 
			return "Administrator with this Email already exists!";
		else {
			administrator na = new administrator(aem, fn, ln, un, pas, pn); 
			aRepository.save(na);
			aRepository.save(na);
			return "New Administrator Created";
			//everything else with setters
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
Iterable<restriction> AdmingetAllrestrictions(){ 
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
administrator getΑnAdmin( @RequestParam String aem) {
	// This returns a JSON or XML with the user
	if (aRepository.findOne(aem)==null) 
		return null; //something else here
	return aRepository.findOne(aem);
}


public administrator getAdministratorByEmailAndPassw (String aem, String passw) {
	
	administrator adm  = this.getΑnAdmin(aem);
	if (adm != null) {
		if (adm.getPassword().equals(passw))
			return adm;
			
	}
	return null;
}




}


