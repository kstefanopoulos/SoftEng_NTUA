package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//to do: update with some of the fields, try-catch
import java.util.Set;

@Controller
@RequestMapping(path = "/organizers")

public class OrganizerController {
	
	@Autowired
	private OrganizerRepository oRepository;
	
	public organizer addNewOrganizer(String oem, String cn, String ba, String fn,
			 String ln,  String un,
			 String pas,  String pn,
			 String sname,  int snumber,
			 String pc,  String t, String afm) {

		if (oRepository.findOne(oem)!=null) 
			return null;
		else {
			organizer no = new organizer(oem,cn, ba, fn, ln, un, pas, pn, sname, snumber,pc,t,afm);
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
	
	@GetMapping(path = "/addevent")
	public @ResponseBody

	
	String addNewEvent(@RequestParam String oem, @RequestParam String en, @RequestParam String ed, @RequestParam String st, @RequestParam String at,
			@RequestParam int ec, @RequestParam String sname, @RequestParam int snumber,
			@RequestParam String pc, @RequestParam String t, @RequestParam String a,  @RequestParam String eclass,  @RequestParam String edescr,@RequestParam String lo,  @RequestParam String la) {

			event ne = new event(en, ed, st, at, ec,sname, snumber,pc,t,a,eclass,edescr,lo,la);
			organizer org=oRepository.findOne(oem);
			if (org==null)
				return "this organizer does not exist!";
			ne.setMyorganizer(org);
			ne.setOrganizer_name(org.getCompany_name());
			Set<event> MyEvents=org.getEvents();
			MyEvents.add(ne);
			org.setEvents(MyEvents); 
			oRepository.save(org);
			return "New Event Saved";
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
	
		organizer org= this.getΑnOrganizer(oem);
		if (org != null) {
			if (org.getPassword().equals(passw))
				return org;
				
		}
		return null;
	}

}



