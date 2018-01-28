package ch2;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/")
public class MainController {
	
	@Autowired
	private OrganizerController oc;

	@RequestMapping(value="/littlecherries")
	public String mainindex() {
    return "mainpage";
  }
  
  @RequestMapping(value = "/contactus")
   public String contactindex() {
    return "CommunicationPage";
  }
  
 @RequestMapping(value = "/aboutus")
  public String aboutusindex() {
    return "OurCompanyPage";
  }
 
 @RequestMapping(value = "/events")
 public String eventsindex(Model model) {
	 
	List<event> list = new ArrayList<event>();

	Iterable<organizer> Organizers=oc.getAllOrganizers();
	for (organizer o: Organizers) {
		Set<event> ev=o.getEvents();
		for (event e: ev) {
			list.add(e);
		}
	}
    model.addAttribute("events", list);

    return "EventPage";
 }

 @RequestMapping(value = "/register")
 	public String viewRegister(Model model) {
	 return "registration";
 }
 
 /*
 @RequestMapping(value = "/register", method = RequestMethod.POST)
 public String saveRegister(Model model, 
       @ModelAttribute("organizer") @Validated organizer orgForm, 
       BindingResult result, final RedirectAttributes redirectAttributes) {
	 
	 		organizer org=null; } */
	 		
}

