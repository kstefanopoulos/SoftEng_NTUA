package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import config.PasswordEncryptionService;

import java.util.Date;

//to do: update with some of the fields, try-catch
import java.util.Set;
@Controller
@RequestMapping(path = "/organizers")

public class OrganizerController {
	
	@Autowired
	private OrganizerRepository oRepository;
	
	/*@Bean
	public PasswordEncryptionService encryption_service() {
	    return super.encryption_service();
	}*/
	
	public organizer addNewOrganizer(String oem, String cn, String ba, String fn,
			 String ln,  String un,
			 String pas,  byte[] salt, String pn,
			 String sname,  int snumber,
			 String pc,  String t, String afm) {
		//System.out.println("Pass to be stored by controller " + pas);

		if (oRepository.findOne(oem)!=null) 
			return null;
		else {
			organizer no = new organizer(oem,cn, ba, fn, ln, un, pas, salt,  pn, sname, snumber,pc,t,afm);
			oRepository.save(no);
			no.setEvents(null);
			oRepository.save(no);
			return no;
			//return "New Organizer Saved";
			//everything else with setters
		}
	}


	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<organizer> getAllOrganizers() {
		// This returns a JSON or XML with the users
		return oRepository.findAll();
	}

	@GetMapping(path = "findOne")
	public @ResponseBody
	organizer getΑnOrganizer(String oem) {
		// This returns a JSON or XML with the user
		if (oRepository.findOne(oem)==null) 
			return null; //something else here
		return oRepository.findOne(oem);
	}
	
	@GetMapping(path = "/delete")
	public @ResponseBody
	String DeleteUser(@RequestParam String oem) {
		organizer o = oRepository.findOne(oem);
	    if (o==null) 
			return "Organizer not found!";
	    o.setEvents(null);
	    oRepository.delete(oem);
	    return "Delete this";
	}
	
	

	@GetMapping(path = "/update")
	public @ResponseBody
	String UpdateUser(@RequestParam String oem) {
		organizer o = oRepository.findOne(oem);
		if (o==null)
			return "Organizer not found!";
		oRepository.save(o);
		return "Update this";
	}
	
	public event createNewEvent(String oem, String en, int ec, String sname, int snumber,
			String pc, String t, int sa, int ea, int d) {

			event ne = new event(en,ec,sname, snumber,pc,t,sa,ea, d);
			return ne;
		}
	
	public event saveNewEvent(String oem, event e, Set<eventinfo> es) {
		organizer org=oRepository.findOne(oem);
		if (org==null)
			return null;
		e.setMyorganizer(org);
		for (eventinfo i: es)
			i.setMyevent(e);
	    e.setEventinfos(es);
		e.setOrganizer_name(org.getCompany_name());
		Set<event> MyEvents=org.getEvents();
		MyEvents.add(e);
		org.setEvents(MyEvents); 
		oRepository.save(org);
		return e;
	}
	
	
	
	@GetMapping(path = "/myevents")
	public @ResponseBody Iterable<event> getAllEvents(@RequestParam String oem) {
		// This returns a JSON or XML with the users
		organizer org=oRepository.findOne(oem);
		if (org!=null)
			return org.getEvents();
		else return null;
	}
	
	@GetMapping(path = "/myevents/single")
	public @ResponseBody event getAnEvent(@RequestParam String oem,@RequestParam Integer evid) {
		// This returns a JSON or XML with the users
		organizer org=oRepository.findOne(oem);
		if (org!=null) {
			Set<event> MyEvents=org.getEvents(); 
			for (event e: MyEvents) {
				if (e.getEventId()==evid)
						return e;
			}
		}
		return null;
	}
	
	public organizer getOrganizerByEmailAndPassw (String oem, String passw) {

		PasswordEncryptionService encryption_service = new PasswordEncryptionService(); 
		
		organizer org= this.getΑnOrganizer(oem);
		if (org != null) {
			//System.out.println("found");
			String encryptedPassword = org.getPassword();
			//System.out.println("pass hashed equals to :"+ encryption_service.getEncryptedPassword("pass", encryption_service.generateSalt()));
			//System.out.println("attempted pass hashed equals to :"+ encryption_service.getEncryptedPassword(passw, encryption_service.generateSalt()));
			
			//System.out.println("pass getter:"+ encryptedPassword);
			//System.out.println("email getter:"+ org.getOemail());
			//System.out.println("pass:"+ encryption_service.getEncryptedPassword(passw, org.getSalt()));
			if (/*org.getPassword().equals(passw)*/ encryption_service.authenticate(passw, encryptedPassword, org.getSalt())) {
				//System.out.println("correct pass!!!");	
				return org;
			}
				
		}
		return null;
	}

}



