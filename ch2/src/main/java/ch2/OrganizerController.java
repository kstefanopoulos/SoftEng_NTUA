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
	
	public event addNewEvent(String oem, String en, int ec, String sname, int snumber,
			String pc, String t, int sa, int ea, eventinfo i) {

			event ne = new event(en,ec,sname, snumber,pc,t,sa,ea);
			organizer org=oRepository.findOne(oem);
			if (org==null)
				return null;
			ne.setMyorganizer(org);
			i.setMyevent(ne);
			Set<eventinfo> infos= ne.getEventinfos();
		    infos.add(i);
		    ne.setEventinfos(infos);
			ne.setOrganizer_name(org.getCompany_name());
			Set<event> MyEvents=org.getEvents();
			MyEvents.add(ne);
			org.setEvents(MyEvents); 
			oRepository.save(org);
			return ne;
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



