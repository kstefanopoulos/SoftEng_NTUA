package ch2;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import register.OrganizerDTO;
import register.OrganizerToUpdate;
import register.ParentDTO;

@Controller
//@RequestMapping("/")
public class MainController {
	
	@Autowired
	private OrganizerController oc;
    OrganizerDTO organizerdto = new OrganizerDTO();
    OrganizerToUpdate orgupdate = new OrganizerToUpdate();
    ChangePasswordForm changepsw = new ChangePasswordForm();
    UserCredentials userCredentials;


	@RequestMapping(value="/littlecherries")
	public String mainindex(Model model) {
		if (userCredentials == null)
			model.addAttribute("user",null);
		else {
			organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			if (org != null) 
				model.addAttribute("user",org); }
		return "mainpage";
  }
  
  @RequestMapping(value = "/littlecherries/contactus")
   public String contactindex(Model model) {
	  if (userCredentials == null)
			model.addAttribute("user",null);
	  else {
			organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			if (org != null) 
				model.addAttribute("user",org); }
    return "CommunicationPage";
  }
  
 @RequestMapping(value = "/littlecherries/aboutus")
  public String aboutusindex(Model model) {
	 if (userCredentials == null)
			model.addAttribute("user",null);
	else {
		organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		if (org != null) 
			model.addAttribute("user",org); } 
	 
    return "OurCompanyPage";
  }
 
 @RequestMapping(value = "/littlecherries/events")
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

    if (userCredentials == null)
		model.addAttribute("user",null);
	else {
		organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		if (org != null) 
			model.addAttribute("user",org); }
    
    return "EventPage";
 }

 @RequestMapping(value = "/littlecherries/register")
 	public String viewRegister(Model model) {
	 return "registration";
 }
 
 @RequestMapping("/littlecherries/organizers/registerSuccessful")
 public String viewRegisterSuccessful(Model model) {

    return "registerSuccessfulPage";
 }

@RequestMapping(value = "/littlecherries/organizers/register", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
	    model.addAttribute("organizer", organizerdto);
	    return "register-paroxou";
	}
	

@RequestMapping(value = "/littlecherries/organizers/register", method = RequestMethod.POST)
	public String registerUserAccount(Model model, @ModelAttribute("organizerdto") @Valid OrganizerDTO accountDto, 
	      BindingResult result, WebRequest request, Errors errors, final RedirectAttributes redirectAttributes) {    
	    organizer registered = new organizer();
	    //System.out.print("enter registerUserAccount");
	    if (result.hasErrors()) {
	    	model.addAttribute("organizer", organizerdto);
	    	return "register-paroxou";
	    }
	    else {
	        registered = createOrganizerAccount(accountDto, result);
	     
	    if (registered==null)
	    	return "UnsuccessfulRegistrationPage";
	    redirectAttributes.addFlashAttribute("flashUser", registered);

	    return "redirect:/littlecherries/organizers/registerSuccessful"; }
	    // rest of the implementation
	}

	private organizer createOrganizerAccount(OrganizerDTO accountDto, BindingResult result) {
	    organizer registered = null;
	    registered=oc.addNewOrganizer(accountDto.getEmail(),accountDto.getCompanyname(),accountDto.getBankacount(),accountDto.getFirstname(),accountDto.getLastname(),accountDto.getUsername(),accountDto.getPassword(),
	    		accountDto.getPhonenumber(),accountDto.getStreetname(),accountDto.getStreetnumber(),accountDto.getPostalcode(),accountDto.getTown(),accountDto.getAfm());
	    
	    return registered;
	}
	
@RequestMapping(value ="/littlecherries/login" ,method=RequestMethod.GET)
public String loginPage(Model model){
		model.addAttribute("userCredential", new UserCredentials());
		return "login"; }



@RequestMapping(value ="/littlecherries/login" ,method=RequestMethod.POST)
public String loginSuccess(Model model, @Valid @ModelAttribute("userCredential") UserCredentials myuserCredentials,
		BindingResult bindingResult,
		final RedirectAttributes redirectAttributes){
	if(bindingResult.hasErrors()){
		return "registration";
	}
	
	//ModelAndView modelAndView = new ModelAndView("welcome");
	organizer org = oc.getOrganizerByEmailAndPassw(myuserCredentials.getEmail(), myuserCredentials.getPassword());
	if(org!= null){
		redirectAttributes.addFlashAttribute("user", org);
		userCredentials=myuserCredentials;
		return "redirect:/littlecherries/organizers/showprofile";
	}else
		return "registration";
}

@RequestMapping(value ="/littlecherries/organizers/showprofile" ,method=RequestMethod.GET)
public String showProfile(Model model) {
	if (userCredentials == null)
		return "registration";
	organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
	if (org != null) {
		model.addAttribute("user",org);
		return "profil_paroxou";
	}
	return "registration";
}

@RequestMapping(value ="/littlecherries/organizers/showinfo" ,method=RequestMethod.GET)
public String showinfo(Model model) {
	if (userCredentials == null)
		return "registration";
	organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
	if (org != null) {
		model.addAttribute("user",org);
		return "organizer_info";
	}
	return "registration";
	
}

@RequestMapping(value ="/littlecherries/organizers/editprofile" ,method=RequestMethod.GET)
public String editprofile(WebRequest request, Model model) {
	if (userCredentials == null)
		return "redirect:/littlecherries/register";
	organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
	if (org != null) {
		model.addAttribute("user",org);
	    model.addAttribute("organizer", orgupdate);
		return "epeksergasia_profil_paroxou";
	}
	return "redirect:littlecherries/register";

}

/* check this !!!!!!!!!!!!!!!!!!!!!! */
@RequestMapping(value = "/littlecherries/organizers/editprofile", method = RequestMethod.POST)
public String edit_profile(Model model, @ModelAttribute("orgupdate") @Valid OrganizerToUpdate accountDto, 
      BindingResult result, WebRequest request, Errors errors) {    
	organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
    	
		org = CheckAndUpdate(org,accountDto);
    	oc.UpdateUser(org.getOemail());
    	model.addAttribute("user",org);
		return "redirect:/littlecherries/organizers/showinfo";}
    // rest of the implementation

public organizer CheckAndUpdate (organizer org, OrganizerToUpdate Dto) {
	if (Dto.getFirstname() != "") org.setFirst_name(Dto.getFirstname());
	if (Dto.getLastname() != "") org.setLast_name(Dto.getLastname());
	if (Dto.getStreetname() != "") org.setStreet_name(Dto.getStreetname());
	//if (Dto.getStreetnumber() != -1) org.setStreet_number(Dto.getStreetnumber()); ???
	if (Dto.getTown() != "") org.setTown(Dto.getTown());
	if (Dto.getPostalcode() != "") org.setPostal_code(Dto.getPostalcode());
	if (Dto.getPhonenumber() != "") org.setPhone_number(Dto.getPhonenumber());
	return org;
}

@RequestMapping(value = "/littlecherries/organizers/logout", method = RequestMethod.GET) 
public String logout() {
	userCredentials=null;
	return "redirect:/littlecherries";
}

@RequestMapping(value = "/littlecherries/organizers/changepassword", method = RequestMethod.GET) 
public String ChangePassw(WebRequest request, Model model) {
	if (userCredentials == null)
		return "registration";
	organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
	if (org != null) {
		model.addAttribute("user",org);
	    model.addAttribute("password", changepsw);
		return "change_password";
	}
return "registration";
}

@RequestMapping(value = "/littlecherries/organizers/changepassword", method = RequestMethod.POST) 
public String ChangePassword(Model model, @ModelAttribute("changepsw") @Valid ChangePasswordForm accountDto, 
	      BindingResult result, WebRequest request, Errors errors) {    
		  organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
	    	
		  if (org != null && org.getOemail().equals(accountDto.getEmail())) {
			  if (accountDto.getOld().equals(org.getPassword()) && accountDto.getFirst().equals(accountDto.getSecond())) {
				  userCredentials.setPassword(accountDto.getFirst());
				  org.setPassword(accountDto.getFirst());
			  	  oc.UpdateUser(org.getOemail());
			  	  model.addAttribute("user",org);
			  	  return "SuccessfulPasswordChange";
			  }
			  else {
					model.addAttribute("user",org);
					return "redirect:/littlecherries/organizers/changepassword";
			  }
		  }
		  return "registration";
	}
}