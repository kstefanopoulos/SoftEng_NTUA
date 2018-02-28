package ch2;

import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Document;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import register.AdministratorDTO;
import register.BlockedDTO;
import register.CreditsForm;
import register.EventDTO;
import register.OrganizerDTO;
import register.OrganizerToUpdate;
import register.ParentDTO;
import register.ParentToUpdate;
import register.ReservForm;
import register.Row;
import register.Rowlist;

import java.util.Collections;


@Controller
//@RequestMapping("/")
public class MainController {
	
	@Autowired
	private OrganizerController oc;
	@Autowired
    private ParentController pr; 
	@Autowired
    private AdministratorController ad;
	@Autowired 
	private RestrictionController rs ; 
	@Autowired 
	private UserController us ; 	
	private Path path;
    ParentDTO parentdto = new ParentDTO(); 
    OrganizerDTO organizerdto = new OrganizerDTO();
    AdministratorDTO administratordto = new AdministratorDTO(); 
    OrganizerToUpdate orgupdate = new OrganizerToUpdate();
    ParentToUpdate parupdate = new ParentToUpdate(); 
    ChangePasswordForm changepsw = new ChangePasswordForm();
    CreditsForm crform = new CreditsForm();
    SearchDto sdto = new SearchDto();
    UserCredentials userCredentials;
    BlockedDTO blockeddto = new BlockedDTO(); 

    EventDTO eventdto = new EventDTO();
    Rowlist list ;
    Row row;
    event ev;
    ReservForm rform;
    ratedto rdto;
    FileHandler fl;
    
    List<String> categories = Arrays.asList("All", "Theater", "Cinema", "Games", "Music", "Dance", "Sport", "Workshop");
    List<String> startages = Arrays.asList("1","2","3","4","5","6","7","8","9","10");
    List<String> endages = Arrays.asList("15","14","13","12","11","10","9","8","7","6","5","4","3","2");
    List<String> maxcosts = Arrays.asList("60","50","40","30","20","10","5");
    List<String> distances = Arrays.asList("20","15","10","5","2");


    @RequestMapping(value="/littlecherries")
	public String mainindex(Model model) {
		if (userCredentials == null)
			model.addAttribute("user",null);
		else {
			organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			parent par = pr.getParentByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			administrator adm = ad.getAdministratorByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			if (org != null) 
				model.addAttribute("org",org);
			else{
				if(par!=null)
					model.addAttribute("par",par); 
				else{ 
					
					if(adm != null )
						model.addAttribute("adm",adm);
					
				}
			}
		
			}
		
		 List<event> list = new ArrayList<event>();
		 List<event> final_list = new ArrayList<event>();

		 Iterable<organizer> Organizers=oc.getAllOrganizers();
		 for (organizer o: Organizers) {
				Set<event> ev=o.getEvents();
				for (event e: ev) {
					list.add(e);
				}
		}
		Collections.sort(list);
		if (list.size() < 4)
			final_list = list;
		else
			final_list = list.subList(0,2);
		
		model.addAttribute("events",final_list);
		return "mainpage";
  }
  
  @RequestMapping(value = "/littlecherries/contactus")
   public String contactindex(Model model) {
	  if (userCredentials == null)
			model.addAttribute("user",null);
	  else {
		  organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		  parent par = pr.getParentByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		  administrator adm = ad.getAdministratorByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		  if (org != null) 
				model.addAttribute("org",org);
			else{
				if(par!=null)
					model.addAttribute("par",par); 
				else{ 
					
					if(adm != null )
						model.addAttribute("adm",adm);
					
				}
			}
		
			}
    return "CommunicationPage";
  }
  
 @RequestMapping(value = "/littlecherries/aboutus")
  public String aboutusindex(Model model) {
	 if (userCredentials == null)
			model.addAttribute("user",null);
	else {
		organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		parent par = pr.getParentByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		administrator adm = ad.getAdministratorByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		if (org != null) 
			model.addAttribute("org",org);
		else{
			if(par!=null)
				model.addAttribute("par",par); 
			else{ 
				
				if(adm != null )
					model.addAttribute("adm",adm);
				
			}
		}
		}

    return "OurCompanyPage";
  }
 
 @RequestMapping(value = "/littlecherries/events", method= RequestMethod.GET)
 public String eventsindex(Model model) {
	 
	List<event> list = new ArrayList<event>();
	List <String> lat_list = new ArrayList<String>();;
	List <String> long_list = new ArrayList<String>();;

	Iterable<organizer> Organizers=oc.getAllOrganizers();
	for (organizer o: Organizers) {
		Set<event> ev=o.getEvents();
		for (event e: ev) {
			list.add(e);
			lat_list.add(e.getLatitude());
			long_list.add(e.getLongitude());
			}
	}
	model.addAttribute("categories",categories);
	model.addAttribute("startages",startages);
	model.addAttribute("endages",endages);
	model.addAttribute("maxcosts",maxcosts);
	model.addAttribute("distances",distances);

	model.addAttribute("lat", lat_list);
	model.addAttribute("longi",long_list);
    model.addAttribute("events", list);
    model.addAttribute("searchform", sdto);

    if (userCredentials == null)
		model.addAttribute("user",null);
	else {
		organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		parent par = pr.getParentByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		administrator adm = ad.getAdministratorByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		if (org != null) 
			model.addAttribute("org",org);
		else{
			if(par!=null)
				model.addAttribute("par",par); 
			else{ 
				
				if(adm != null )
					model.addAttribute("adm",adm);
				
			}
		}
	
		}
    return "EventPage";
 }
 
 @RequestMapping(value = "/littlecherries/events", method= RequestMethod.POST)
 public String SearchEvents(Model model, @ModelAttribute("sdto") SearchDto sdto, 
	      BindingResult result, WebRequest request, Errors errors, final RedirectAttributes redirectAttributes) throws Exception {

	 /* who is the user */
	 if (userCredentials == null)
			model.addAttribute("user",null);
		else {
			organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			parent par = pr.getParentByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			administrator adm = ad.getAdministratorByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			if (org != null) 
				model.addAttribute("org",org);
			else{
				if(par!=null)
					model.addAttribute("par",par); 
				else{ 
					
					if(adm != null )
						model.addAttribute("adm",adm);
					
				}
			}

		
		}
	 /* to begin, get all events */
	 
	 List<event> list = new ArrayList<event>();

		Iterable<organizer> Organizers=oc.getAllOrganizers();
		for (organizer o: Organizers) {
			Set<event> ev=o.getEvents();
			for (event e: ev) {
				list.add(e);
			}
		}
	 
	 /* check filters (4 cases) */
		
	List<event> filteredlist = new ArrayList<event>() ;  // to help us
		
	/* category */
	if (!sdto.getCategory().equals("All")) {
		for (event e: list) 
			if (e.getEvent_class().equals(sdto.getCategory()))
				filteredlist.add(e);
		list = filteredlist;
		
	}
	
	/*ages*/
	int stage, endage;
	stage=Integer.parseInt(sdto.getStartage());
	endage=Integer.parseInt(sdto.getEndage());
		
	filteredlist=new ArrayList<event>() ;
	if (list.size() > 0)
			for (event e: list) {
				if (!(e.getStartage()>endage)  && !(e.getEndage() < stage))
					filteredlist.add(e);
				//return "two";
			}
	list=filteredlist;
	
	/*cost*/
	int cost = Integer.parseInt(sdto.getMaxcost());
	filteredlist=new ArrayList<event>() ;
	if (list.size() > 0)
		for (event e: list) {
			if (cost >= e.getEvent_cost())
				filteredlist.add(e);
			//return "two";
		}
	list=filteredlist;
	
	/* distance */
	
	if (sdto.getStreetname() != "" && sdto.getStreetnumber() != "" && sdto.getTown() != "") {
		String address = sdto.getStreetname() + " " + sdto.getStreetnumber() + " " + sdto.getTown() ;
		FindLocation fl = new FindLocation();
		String center_points[] = fl.getLatLongPositions(address);
		float center_lat = Float.parseFloat(center_points[0]);
		float center_long = Float.parseFloat(center_points[1]);
		float width = (float)(Float.parseFloat(sdto.getWidth()) * 1000.0) ;
		//return center_points[0] + center_points[1];
		
		filteredlist=new ArrayList<event>() ;
		if (list.size() > 0)
			for (event e: list) {
				float distance= fl.distFrom(center_lat, center_long, Float.parseFloat(e.getLatitude()), Float.parseFloat(e.getLongitude()) );
				if (distance <= width)
					filteredlist.add(e);
			} 
		model.addAttribute("addr",address);
	}
		
	
	if (filteredlist.size() > 0) {
		List <String> lat_list = new ArrayList<String>();;
		List <String> long_list = new ArrayList<String>();;
		for (event e: filteredlist) {
			lat_list.add(e.getLatitude());
			long_list.add(e.getLongitude());
		}
		model.addAttribute("categories",categories);
		model.addAttribute("startages",startages);
		model.addAttribute("endages",endages);
		model.addAttribute("maxcosts",maxcosts);
		model.addAttribute("distances",distances);

		model.addAttribute("cat",sdto.getCategory());
		model.addAttribute("sage",sdto.getStartage());
		model.addAttribute("eage",sdto.getEndage());
		model.addAttribute("cost",sdto.getMaxcost());
		model.addAttribute("w",sdto.getWidth());

		
		model.addAttribute("filters","1");
		model.addAttribute("events",filteredlist);
		model.addAttribute("lat", lat_list);
		model.addAttribute("longi",long_list);
		return "EventPage";
	}
	else 
		return "UnsuccessfulSearch";
	
	 
 }
 
 
 @RequestMapping(value = "/littlecherries/events/{eventid}", method = RequestMethod.GET)
 public String viewEvent(Model model, @ModelAttribute("eventid") int eventid) {
	 
	 
	 if (userCredentials == null)
			model.addAttribute("user",null);
		else {
			organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			parent par = pr.getParentByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			administrator adm = ad.getAdministratorByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			if (org != null) 
				model.addAttribute("org",org);
			else{
				if(par!=null) {
					model.addAttribute("par",par); 
					Set<hasattended> ha = par.getHasattended();
					for (hasattended h : ha) {
						if (h.getAnevent().getEventId() == eventid) {
							if (h.getRating() == 0) {
								rdto=new ratedto();
								model.addAttribute("canrate",1);
								model.addAttribute("myrate",rdto);
							}
						}
					}
					bucket b = par.getParentbucket();
					Set<consistsof> bc = b.getContains();
					for (consistsof c : bc) {
						if (c.getAnevent().getEventId() == eventid) {
							if (c.getIsfavourite()==1) 
								model.addAttribute("fav",1);
							model.addAttribute("sav",1); 
							
						}
					}
						
				}
				else{ 
					
					if(adm != null )
						model.addAttribute("adm",adm);
					
				}
			}
		}	
	 event e= null;
	 organizer myorg=null;
	 Iterable<organizer> Organizers=oc.getAllOrganizers();
		for (organizer o: Organizers) {
			e = oc.getAnEvent(o.getOemail(), eventid);
			if (e != null)  {
				myorg=o;
				break; }
		}
	 if (e== null)
		 return "redirect:/littlecherries/events";
	 float lat = Float.parseFloat(e.getLatitude());
	 float longi = Float.parseFloat(e.getLongitude());
	 Set<consistsof> cs = e.getContained();
	 model.addAttribute("lat",lat);
	 model.addAttribute("longi",longi);
	 model.addAttribute("timessaved",cs.size());
	 model.addAttribute("ticketssold", e.getTickets());
	 model.addAttribute("myorg",myorg);
	 model.addAttribute("event",e);
	 return "single_event";
	 
	 
 }
 
 @RequestMapping(value = "/littlecherries/events/{eventid}", method = RequestMethod.POST)
 public String EvaluateEvent(Model model, @ModelAttribute("eventid") int eventid, @ModelAttribute("rdto") @Valid ratedto rdto, 
	      BindingResult result, WebRequest request, Errors errors, final RedirectAttributes redirectAttributes) {
	 
	 
	 event e= null;
	 organizer myorg=null;
	 Iterable<organizer> Organizers=oc.getAllOrganizers();
	 for (organizer o: Organizers) {
				e = oc.getAnEvent(o.getOemail(), eventid);
				if (e != null)  {
					myorg=o;
					break; }
	}
	if (e== null)
			return "redirect:/littlecherries/events";

	 if (userCredentials == null)
			model.addAttribute("user",null);
		else {
			organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			parent par = pr.getParentByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			administrator adm = ad.getAdministratorByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
			if (org != null) 
				model.addAttribute("org",org);
			else{
				if(par!=null) {
					model.addAttribute("par",par); 
					Set<hasattended> ha = par.getHasattended();
					hasattended hi=null;
					for (hasattended h : ha) {
						if (h.getAnevent().getEventId() == eventid) 
							hi=h;
						    hi.setRating(rdto.getRate());
						    pr.UpdateUser(par.getPemail());
					}
					Set<hasattended> he = e.getHasattended();
					int users=0;
					int sum=0;
					for (hasattended h : he) {
						sum+=h.getRating();
						if (h.getRating() > 0) 
							users+=1;
					}
					if (users>0){
						int avg=sum/users;
						e.setEvaluation(avg);
						oc.UpdateUser(myorg.getOemail());
					}
				}
				else{ 
					
					if(adm != null )
						model.addAttribute("adm",adm);
					
				}
			} 
		}
	 model.addAttribute("myorg",myorg);
	 model.addAttribute("event",e);
	 return "single_event";
	} 
 
 
 
 ////// REGISTRATION ///////////
 

 @RequestMapping(value = "/littlecherries/register")
 	public String viewRegister(Model model) {
	 return "registration";
 }
 
 @RequestMapping(value = "/littlecherries/registerSuccessful")
 public String viewRegisterSuccessful(Model model) {

    return "registerSuccessfulPage";
 }
 
 //////// ORGANIZER /////////////
 
@RequestMapping(value = "/littlecherries/organizers/register", method = RequestMethod.GET)
	public String showRegistrationFormOrganizer(WebRequest request, Model model) {
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
	        registered = oc.createOrganizerAccount(accountDto, result);
	     
	    if (registered==null)
	    	return "UnsuccessfulRegistrationPage";
	    redirectAttributes.addFlashAttribute("flashUser", registered);

	    return "redirect:/littlecherries/organizers/registerSuccessful"; }
	    // rest of the implementation
	}


//////// PARENT ////////////////////



@RequestMapping(value = "/littlecherries/parents/register", method = RequestMethod.GET)
	public String showRegistrationFormParent(WebRequest request, Model model ) {
	 model.addAttribute("parent", parentdto);
	    return "register-gonea";
}


@RequestMapping(value = "/littlecherries/parents/register", method = RequestMethod.POST)
public String registerUserAccount(Model model, @ModelAttribute("parentdto") @Valid ParentDTO accountDto, 
      BindingResult result, WebRequest request, Errors errors, final RedirectAttributes redirectAttributes) {    
       parent registered = new parent(); 
    //System.out.print("enter registerUserAccount");
    /* if (result.hasErrors()) {
    	model.addAttribute("parent", parentdto);
    	return "register-gonea";
    }*/
   
        registered = pr.createParentAccount(accountDto, result);
     
    if (registered==null)
    	return "UnsuccessfulRegistrationPage";
    redirectAttributes.addFlashAttribute("flashUser", registered);
    return "redirect:/littlecherries/registerSuccessful"; 
}

	
//////// LOGIN ///////////////////


@RequestMapping(value ="/littlecherries/login" ,method=RequestMethod.GET)
public String loginPage(Model model){
		model.addAttribute("userCredential", new UserCredentials());
		return "login"; }



///// ORGANIZER AND PARENT AND ADMIN LOGIN //////

@RequestMapping(value ="/littlecherries/login" ,method=RequestMethod.POST)
public String loginSuccess(Model model, @Valid @ModelAttribute("userCredential") UserCredentials myuserCredentials,
		BindingResult bindingResult,
		final RedirectAttributes redirectAttributes){
	if(bindingResult.hasErrors()){
		return "registration";
	}
	//ModelAndView modelAndView = new ModelAndView("welcome");
	organizer org = oc.getOrganizerByEmailAndPassw(myuserCredentials.getEmail(), myuserCredentials.getPassword());
	parent par = pr.getParentByEmailAndPassw(myuserCredentials.getEmail(), myuserCredentials.getPassword());
	administrator adm = ad.getAdministratorByEmailAndPassw(myuserCredentials.getEmail(), myuserCredentials.getPassword());
	 if(org!= null){
		if (org.getRestrictions() != 7) {
			redirectAttributes.addFlashAttribute("user", org);
			userCredentials=myuserCredentials;
			userCredentials.setType(0);
			return "redirect:/littlecherries/organizers/showprofile";
		}
		return "UserLocked";
	}else if(par!=null){
		if (par.getRestrictions() == 7)
			return "UserLocked";
		Set<willattend> toremove = new HashSet<willattend>();
		Set<willattend> wa= par.getWillattend();
	    Set<hasattended> ha= par.getHasattended();
	    Date today= new Date();
	    if (wa.size() > 0) {
		    for (willattend i : wa) {
		    	if (i.getValid()==1) {
		    		Date evday= i.getDate();
		    		if (today.after(evday))    {             //if the event date has passed 
		    			toremove.add(i);
		    			i.setValid(0);
		    		}
		    	}
		    }
		    HelpMethods hm = new HelpMethods();
			hm.check_and_remove(toremove,par,wa,ha,oc);
		    wa.removeAll(toremove);
		    par.setHasattended(ha);
		    par.setWillattend(wa);
		    pr.UpdateUser(par.getPemail());
		}
		redirectAttributes.addFlashAttribute("user", par);
		userCredentials=myuserCredentials;
		userCredentials.setType(1);
		return "redirect:/littlecherries/parents/showprofile";
		}else if(adm!=null){
			if (adm.getRestrictions() == 7)
				return "UserLocked";
			redirectAttributes.addFlashAttribute("user", adm);
			userCredentials=myuserCredentials;
			userCredentials.setType(2);
			return "redirect:/littlecherries/administrators/showprofile";
		}
	
		return "registration";
	}
	

////////  PROFILE AND ACTION STUFF  ///////////////


//// ORGANIZERS /////

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
		return "change_password_organizer";
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
			  	  model.addAttribute("par",null);
			  	  model.addAttribute("org",org);
			  	  return "SuccessfulPasswordChange";
			  }
			  else {
					model.addAttribute("user",org);
					return "redirect:/littlecherries/organizers/changepassword";
			  }
		  }
		  return "registration";
	}

@RequestMapping(value = "/littlecherries/organizers/viewmyevents", method = RequestMethod.GET) 
public String OrganizerViewEvents(Model model) {
	if (userCredentials == null)
		return "registration";
	organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
	if (org != null) {
		model.addAttribute("user",org);
		Set<event> ev=org.getEvents();
	    model.addAttribute("events", ev);
		return "company_events"; }
	return "registration";
	}

@RequestMapping(value = "/littlecherries/organizers/addevent", method = RequestMethod.GET) 
public String OrganizerAddsEvent(Model model) {
	if (userCredentials == null)
		return "registration";
	organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
	if (org==null)
		return "registration";
	else {
		model.addAttribute("user",org);
		if (org.getRestrictions() == 4)
			return "cannotCreateEvents";
		model.addAttribute("categories",categories);
		model.addAttribute("event", eventdto);
		return "event_creation";
	}
}

@RequestMapping(value = "/littlecherries/organizers/addevent", method = RequestMethod.POST) 
public String OrganizerCreatesEvent(Model model, @ModelAttribute("eventdto") @Valid EventDTO eventDto, 
	      BindingResult result, WebRequest request, Errors errors) throws Exception {    
	
		if (userCredentials == null)
			return "registration";
	    //check this!!!!
		/*if(result.hasErrors()){
			return "registration";
		}*/
		organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
		if (org==null)
			return "registration";
   
		event e = oc.createNewEvent(org.getOemail(), eventDto.getTitle(), eventDto.getPrice(), eventDto.getStreetname(),
				eventDto.getStreetnumber(), eventDto.getPostalcode(), eventDto.getTown(), eventDto.getStartage(),
				eventDto.getEndage(),eventDto.getDuration(),eventDto.getCategory());
		if (e==null)
			return "redirect:/littlecherries/organizers/addevent";
	    ev=e;
	    String postcode = eventDto.getStreetname() + ' ' +  eventDto.getStreetnumber() + ' ' + eventDto.getTown() + ' ' + eventDto.getPostalcode() ;
	    FindLocation fg = new FindLocation();
	    String latLongs[] = fg.getLatLongPositions(postcode);
	    ev.setLatitude(latLongs[0]);
	    ev.setLongitude(latLongs[1]);
	    list = new Rowlist();
	    model.addAttribute("event", e);
		return "redirect:/littlecherries/organizers/addevent/edit";  
	}

@RequestMapping(value = "/littlecherries/organizers/addevent/edit", method = RequestMethod.GET) 
public String SaveDates(Model model) {
	if (userCredentials == null)
		return "registration";
	organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
	if (org==null)
		return "registration";
	else {
		List<Row> rl = new ArrayList<Row>();
		list.setMyRows(rl);
		model.addAttribute("list",null);
		model.addAttribute("row",row);
		model.addAttribute("user",org);
		return "SelectDates";
	}
}

@RequestMapping(value = "/littlecherries/organizers/addevent/edit", method = RequestMethod.POST) 
public String SaveDatesEdit (Model model, @ModelAttribute("row") @Valid Row row, 
	      BindingResult result, WebRequest request, Errors errors) throws ParseException{
	
			if (userCredentials == null)
				return "registration";
			organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
			if (org==null)
				return "registration";
			if (ev == null) {
				model.addAttribute("event", eventdto);
				model.addAttribute("user",org);
				return "event_creation";
			}
			else {
				SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
				String mytime = localDateFormat.format(row.getTime().getTime());
				Date ttime = (Date)localDateFormat.parse(mytime);
				row.setTime(ttime);
				list.getMyRows().add(row);
				model.addAttribute("list",list.getMyRows());
				model.addAttribute("row",row);
				model.addAttribute("user",org);
				return "SelectDates";
				
			} 
				
	      }

@RequestMapping(value = "/littlecherries/organizers/addevent/save", method = RequestMethod.GET) 
public String SaveΕvent (Model model) throws ParseException {
	if (userCredentials == null)
		return "registration";
	organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
	if (org==null)
		return "registration";
	if (ev == null) {
		model.addAttribute("event", eventdto);
		model.addAttribute("user",org);
		return "event_creation";
	}
	else {
		Set<eventinfo> newset= new HashSet<eventinfo>();
		for (Row r : list.getMyRows()) {
			eventinfo ei = new eventinfo(r.getDate(),r.getTickets(), r.getTime());
			newset.add(ei); }
			ev.createdat = new Date();
			oc.saveNewEvent(org.getOemail(), ev, newset);
			model.addAttribute("user",org);
			Set<event> ev=org.getEvents();
			model.addAttribute("events", ev); 
		return "redirect:/littlecherries/organizers/viewmyevents"; }
}

@RequestMapping(value="/littlecherries/organizers/viewstatistics", method= RequestMethod.GET)
public String ViewStatistics(Model model) {
	if (userCredentials == null)
		return "registration";
	organizer org= oc.getΑnOrganizer(userCredentials.getEmail());
	if (org==null)
		return "registration";
	Date now = new Date();
	Calendar cal = new GregorianCalendar();
	cal.setTime(now);
	cal.add(Calendar.DAY_OF_MONTH, -30);
	Date startdate = cal.getTime();
	//return startdate.toString();
	
	Set<event> myev = org.getEvents();
	List<statistics> toshow = new ArrayList<statistics>();
	for (event e: myev) {
		int f=0;                               //0-> passed, 1-> not passed
		Set<eventinfo> evinfos = e.getEventinfos();
		for (eventinfo ei: evinfos) {
			if (startdate.before(ei.getEventdate())) {
				f=1;                           //found one!
				break; }
			
		}
		if (f==1)  {     			//organizer will view statistics about it
			Set<willattend> evattend = e.getWillbeattented();
			List<willattend> evattend_list = new ArrayList<willattend>();
			for (willattend w: evattend)
				evattend_list.add(w);
			int mytickets = 0;
			for (willattend wi: evattend_list) {
				if (startdate.before(wi.getDate()) || startdate.equals(wi.getDate())) 
					mytickets += wi.getTickets();
			}
			double credits= e.getEvent_cost() * mytickets * 0.9 ;
			statistics new_stat = new statistics(e.getEvent_name(),e.getEvent_cost(),mytickets, credits, credits);
			toshow.add(new_stat);
		}
	}
		
	model.addAttribute("myevents",toshow);
	model.addAttribute("user",org);
	return "view_statistics"; 
}

/////////////////////  PARENT'S STUFF   ////////////////////////  

@RequestMapping(value ="/littlecherries/parents/showprofile" ,method=RequestMethod.GET)
public String ParentshowProfile(Model model) {
	if (userCredentials == null)
		return "registration";
	parent par = pr.getParentByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
	if (par!= null) {	    
		model.addAttribute("user",par);
		return "profile-gonea";  
	}
	return "registration";
}

@RequestMapping(value ="/littlecherries/parents/showinfo" ,method=RequestMethod.GET)
public String Parentshowinfo(Model model) {
	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("user",par);
		return "parent-info";
	}
	return "registration";
	
}

@RequestMapping(value ="/littlecherries/parents/editprofile" ,method=RequestMethod.GET)
public String Parenteditprofile(WebRequest request, Model model) {
	if (userCredentials == null)
		return "redirect:/littlecherries/register";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("user",par);
	    model.addAttribute("parent", parupdate);
		return "epeksergasia_profile_gonea";
	}
	return "redirect:littlecherries/register";

}

/* check this !!!!!!!!!!!!!!!!!!!!!! */
@RequestMapping(value = "/littlecherries/parents/editprofile", method = RequestMethod.POST)
public String Parentedit_profile(Model model, @ModelAttribute("parupdate") @Valid ParentToUpdate accountDto, 
      BindingResult result, WebRequest request, Errors errors) {    
	parent par= pr.getΑParent(userCredentials.getEmail());
    	
		par = ParentCheckAndUpdate(par,accountDto);
    	pr.UpdateUser(par.getPemail());
    	model.addAttribute("user",par);
		return "redirect:/littlecherries/parents/showinfo";}
    // rest of the implementation

public parent ParentCheckAndUpdate (parent par, ParentToUpdate Dto) {
	if (Dto.getFirstname() != "") par.setFirst_name(Dto.getFirstname());
	if (Dto.getLastname() != "") par.setLast_name(Dto.getLastname());
	if (Dto.getStreetname() != "") par.setStreet_name(Dto.getStreetname());
	//if (Dto.getStreetnumber() != -1) org.setStreet_number(Dto.getStreetnumber()); ???
	if (Dto.getTown() != "") par.setTown(Dto.getTown());
	if (Dto.getPostalcode() != "") par.setPostal_code(Dto.getPostalcode());
	if (Dto.getPhonenumber() != "") par.setPhone_number(Dto.getPhonenumber());
	return par;
}

@RequestMapping(value = "/littlecherries/parents/logout", method = RequestMethod.GET) 
public String Parentlogout() {
	userCredentials=null;
	return "redirect:/littlecherries";
}

@RequestMapping(value = "/littlecherries/parents/changepassword", method = RequestMethod.GET) 
public String ParentChangePassw(WebRequest request, Model model) {
	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("user",par);
	    model.addAttribute("password", changepsw);
		return "change_password_parent";
	}
return "registration";
}

@RequestMapping(value = "/littlecherries/parents/changepassword", method = RequestMethod.POST) 
public String ParentChangePassword(Model model, @ModelAttribute("changepsw") @Valid ChangePasswordForm accountDto, 
	      BindingResult result, WebRequest request, Errors errors) {    
		  parent par = pr.getΑParent(userCredentials.getEmail());
	    	
		  if (par!= null && par.getPemail().equals(accountDto.getEmail())) {
			  if (accountDto.getOld().equals(par.getPassword()) && accountDto.getFirst().equals(accountDto.getSecond())) {
				  userCredentials.setPassword(accountDto.getFirst());
				  par.setPassword(accountDto.getFirst());
			  	  pr.UpdateUser(par.getPemail());
			  	  model.addAttribute("par",par);
			  	  model.addAttribute("org",null);

			  	  return "SuccessfulPasswordChange";
			  }
			  else {
					model.addAttribute("user",par);
					return "redirect:/littlecherries/parents/changepassword";
			  }
		  }
		  return "registration";
	}


@RequestMapping(value = "/littlecherries/parents/loadcredits", method = RequestMethod.GET) 
public String ParentLoadCreditsGetPage(Model model){
	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("user",par);
		if (par.getRestrictions() == 2 || par.getRestrictions() == 3)
			return "cannotLoadCreditsRes";
		model.addAttribute("card",crform);
		return "load_credits";
	}
	return "registration";

}

@RequestMapping(value = "/littlecherries/parents/loadcredits", method = RequestMethod.POST) 
public String ParentLoadCreditsPost(Model model, @ModelAttribute("crform") @Valid CreditsForm crform, 
	      BindingResult result, WebRequest request, Errors errors) throws ParseException {    
			parent par= pr.getΑParent(userCredentials.getEmail());
	    	if (par==null)
	    		return "registration";
	    	float prev=par.getBalance();
	    	float curr=prev + crform.getPoints() ;
	    	par.setBalance(curr);
	    	SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String mydate = localDateFormat.format(new Date());
			Date tdate = (Date)localDateFormat.parse(mydate);
	    	par.setLast_transaction_date(tdate);
		  	pr.UpdateUser(par.getPemail());
	    	model.addAttribute("user",par);
			return "redirect:/littlecherries/parents/showinfo"; 
}

@RequestMapping(value = "/littlecherries/parents/deleteprofile", method = RequestMethod.GET) 
	public String ParentDeleteProfile(Model model){
		if (userCredentials == null)
			return "registration";
		parent par= pr.getΑParent(userCredentials.getEmail());
		if (par != null) {
			pr.DeleteUser(par.getPemail());
			userCredentials=null;
			return "redirect:/littlecherries";
		}
		return "registration";
}

@RequestMapping(value = "/littlecherries/parents/{eventid}/buyticket", method = RequestMethod.GET)
public String ParentBuyTicketsFirst(Model model, @ModelAttribute("eventid") int eventid) {
	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("par",par);
		if (par.getRestrictions() == 1 || par.getRestrictions() == 3)
			return "cannotbuyRes";
		event e= null;
		Iterable<organizer> Organizers=oc.getAllOrganizers();
		for (organizer o: Organizers) {
				e = oc.getAnEvent(o.getOemail(), eventid);
				if (e != null)  {
					break; }
			}
		 if (e== null)
			 return "redirect:/littlecherries/events";
		Set<eventinfo> ei = e.getEventinfos();
		List<eventinfo> eil = new ArrayList<eventinfo>();
		for (eventinfo i: ei) {
			i.setActive(false);
			eil.add(i);
		}
		rform= new ReservForm();
		rform.setEi_list(eil);
		model.addAttribute("rform",rform);
		model.addAttribute("event",e);
		model.addAttribute("par",par);
		return "reservation";
	}
	return "registration";
}	

@RequestMapping(value = "/littlecherries/parents/{eventid}/buyticket/{infoid}", method = RequestMethod.GET)
public String ParentBuyTicketsSecond(Model model, @ModelAttribute("eventid") int eventid, @ModelAttribute("infoid") int infoid) {	
	
	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("par",par);
		event e= null;
		Iterable<organizer> Organizers=oc.getAllOrganizers();
		for (organizer o: Organizers) {
				e = oc.getAnEvent(o.getOemail(), eventid);
				if (e != null)  {
					break; }
			}
		 if (e== null)
			 return "redirect:/littlecherries/events";
		eventinfo sel=null;
		Set<eventinfo> ei = e.getEventinfos();
		for (eventinfo i : ei) {
			if (i.getEventinfoid()==infoid)  {
				sel=i;
				break;
			}
		}
		if (sel==null)
			return "redirect:/littlecherries/parents/{eventid}/buyticket";
		model.addAttribute("par",par);
		model.addAttribute("event",e);
		model.addAttribute("info",sel);
		model.addAttribute("rform",rform);
		return "reservation_tickets";

	}
	return "registration";
}

@RequestMapping(value = "/littlecherries/parents/{eventid}/buyticket/{infoid}", method = RequestMethod.POST)
public String ParentBuyTc(Model model, @ModelAttribute("eventid") int eventid,@ModelAttribute("infoid") int infoid, @ModelAttribute("rform") ReservForm rform,
	      BindingResult result, WebRequest request, Errors errors) throws ParseException {
	
	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("par",par);
		event e= null;
		organizer or = null;
		Iterable<organizer> Organizers=oc.getAllOrganizers();
		for (organizer o: Organizers) {
				e = oc.getAnEvent(o.getOemail(), eventid);
				if (e != null)  {
					or = o;
					break; }
			}
		 if (e== null)
			 return "redirect:/littlecherries/events";  

	float totalcost = rform.getNumberoftickets() * e.getEvent_cost();
	if (totalcost > par.getBalance()) {
		model.addAttribute("user",par);
		return "after_reservation_failure"; }
	Set<eventinfo> eil=e.getEventinfos();
	eventinfo sel=null;
	for (eventinfo i : eil) {
		if (i.getEventinfoid()==infoid)  {
			sel=i;
			break;
		}
	}
	if (sel==null)
		return "redirect:/littlecherries/parents/{eventid}/buyticket";
	
	/*******************************************************/
	willattend wa= new willattend();
	wa.setAnevent(e);
	wa.setAparent(par);
	wa.setDate(sel.getEventdate());
	wa.setTime(sel.getStarttime());
	wa.setValid(1);
	wa.setTickets(rform.getNumberoftickets());
	/*******************************************************/
	Set<willattend> pwa = par.getWillattend();
	pwa.add(wa);
	par.setWillattend(pwa);
	par.setBalance(par.getBalance()-totalcost);
	SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String mydate = localDateFormat.format(new Date());
	Date tdate = (Date)localDateFormat.parse(mydate);
	par.setLast_transaction_date(tdate);
	pr.UpdateUser(par.getPemail());
	sel.setAvailabletickets(sel.getAvailabletickets()-rform.getNumberoftickets());
	/******************************************************/
	Set<willattend> ewa = e.getWillbeattented();
	ewa.add(wa);
	e.setWillbeattented(ewa);
	e.setTickets(e.getTickets() + rform.getNumberoftickets());
	float d = (float)(or.getBalance() + totalcost * 0.9);
	or.setBalance(d);
	oc.UpdateUser(or.getOemail());
	model.addAttribute("user",par);
	model.addAttribute("event",e);
	model.addAttribute("date",sel.getEventdate());
	model.addAttribute("time",sel.getStarttime());
    model.addAttribute("tickets",rform.getNumberoftickets());
	return "after_reservation_success";
	}	 
	return "registration";


}

@RequestMapping(value = "/littlecherries/parents/{eventid}/save", method = RequestMethod.GET)
public String ParentSaveEvent(Model model, @ModelAttribute("eventid") int eventid) {

	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("par",par);
		event e= null;
		organizer org= null;
		Iterable<organizer> Organizers=oc.getAllOrganizers();
		for (organizer o: Organizers) {
				e = oc.getAnEvent(o.getOemail(), eventid);
				if (e != null)  {
					org=o;
					break; }
		 }
		 if (e== null)
			 return "redirect:/littlecherries/events";
	
		 bucket b = par.getParentbucket();
		 
		 consistsof con=new consistsof();
		 con.setAbucket(b);
		 con.setAnevent(e);
		 con.setIsfavourite(0);
		 /*****************************************/ 
		 Set<consistsof> bcon = b.getContains();
		 int f=0;
		 for (consistsof co : bcon) {
			 if (co.getAnevent().getEventId() == eventid) { f=1; break; }
		 }
		 if (f==0) {
			 b.setEvent_card(b.getEvent_card()+1);
			 b.setOverall_cost(b.getOverall_cost()+e.getEvent_cost());
			 bcon.add(con);
			 b.setContains(bcon);
			 pr.UpdateUser(par.getPemail());
			 /*****************************************/
			 Set<consistsof> econ = e.getContained();
			 econ.add(con);
			 e.setContained(econ);
			 oc.UpdateUser(org.getOemail());
			 model.addAttribute("user",par); }
	     return "redirect:/littlecherries/parents/events_saved";   //show bucket!!!!!!!!!!!
	}
	return "registration";

 }

@RequestMapping(value = "/littlecherries/parents/{eventid}/saveasfav", method = RequestMethod.GET)
public String ParentSaveEventAsFav(Model model, @ModelAttribute("eventid") int eventid) {

	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("par",par);
		event e= null;
		organizer org= null;
		Iterable<organizer> Organizers=oc.getAllOrganizers();
		for (organizer o: Organizers) {
				e = oc.getAnEvent(o.getOemail(), eventid);
				if (e != null)  {
					org=o;
					break; }
		 }
		 if (e== null)
			 return "redirect:/littlecherries/events";
	
		 bucket b = par.getParentbucket();
		 Set<consistsof> bcon = b.getContains();
		 consistsof con=null;

		 int f=0;
		 for (consistsof co : bcon) {
			 if (co.getAnevent().getEventId() == eventid) { f=1; con=co; break; }
		 }
		 if (f==0) {
			 con = new consistsof();
			 con.setAbucket(b);
			 con.setAnevent(e);  }
		con.setIsfavourite(1);
		/*****************************************/ 
		 if (f==0) {
			 b.setEvent_card(b.getEvent_card()+1);
			 b.setOverall_cost(b.getOverall_cost()+e.getEvent_cost());
			 bcon.add(con); 
			 b.setContains(bcon); }
		pr.UpdateUser(par.getPemail());
		/*****************************************/
		 if (f==0) {
			 Set<consistsof> econ = e.getContained();
			 econ.add(con);
			 e.setContained(econ); 
			 oc.UpdateUser(org.getOemail()); }
			 model.addAttribute("user",par); 
	     return "redirect:/littlecherries/parents/events_saved";   //show bucket!!!!!!!!!!!
	}
	return "registration";

 }

@RequestMapping(value = "/littlecherries/parents/events_saved", method = RequestMethod.GET)
public String ParentViewsSavedEvents (Model model) {
    
	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("user",par);
		List<event> myevents = new ArrayList<event> ();
		bucket b = par.getParentbucket();
		for (consistsof co : b.getContains()) {
			myevents.add(co.getAnevent());
		}
		model.addAttribute("list",myevents);
		return "view_bucket";
	}
	return "registration"; 
}

@RequestMapping(value = "/littlecherries/parents/events_gone", method= RequestMethod.GET)
public String ParentViewsGoneEvents (Model model) {
	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("user",par);
		List<event> myevents = new ArrayList<event> ();
		Set<hasattended> ha = par.getHasattended();
		for (hasattended i : ha) {
			myevents.add(i.getAnevent());
		}
		model.addAttribute("list",myevents);
		model.addAttribute("ha",ha);
		return "view_history"; }

	return "registration";
	}

@RequestMapping(value = "/littlecherries/parents/events_togo", method= RequestMethod.GET)
public String ParentViewsFutureEvents (Model model) {
	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("user",par);
		List<event> myevents = new ArrayList<event> ();
		Set<willattend> wa = par.getWillattend();
		for (willattend i : wa) {
			if (i.getValid() == 1)
				myevents.add(i.getAnevent());
		}
		model.addAttribute("list",myevents);
		return "view_events_to_go"; }

	return "registration";
	}
	
/////////////  ADMINISTRATOR STUFF ///////////////


// ?? 
@RequestMapping(value ="/littlecherries/administrators/showprofile" ,method=RequestMethod.GET)
public String showProfileAdmins(Model model) {
	if (userCredentials == null)
		return "registration";
	administrator adm = ad.getAdministratorByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
	if (adm != null) {
		model.addAttribute("user",adm);
		return "AdminProfile";
	}else{
	return "login";
}}	


// ??
@RequestMapping(value = "/littlecherries/administrators/logout", method = RequestMethod.GET) 
public String Adminlogout() {
	userCredentials=null;
	return "redirect:/littlecherries";
}

// DASHBOARD  

//OK 
@RequestMapping(value="/littlecherries/administrators/viewparents" , method = RequestMethod.GET)
	public String AdministratorViewParents(Model model){
		if (userCredentials == null)
			return "registration";
		administrator adm = ad.getΑnAdmin(userCredentials.getEmail());
		if (adm!=null){
			model.addAttribute("user",adm);
			Iterable<parent> pars = pr.getAllParents(); 
		    model.addAttribute("parents", pars); 
			return "viewparentspage" ; 
		}else{
			
			return "registration"; 
		}
}

// add events of each organizer
@RequestMapping(value="/littlecherries/administrators/vieworganizers" , method = RequestMethod.GET)
		public String AdministratorViewOrganizers(Model model){
			if (userCredentials == null)
				return "registration";
			administrator adm = ad.getΑnAdmin(userCredentials.getEmail());
			if (adm!=null){
				model.addAttribute("user",adm);
				Iterable<organizer> orgs = oc.getAllOrganizers() ;  
				model.addAttribute("organizers", orgs); 
				return "vieworganizers" ; 
		
			}else{
				
				return "registration"; 
			}
			
		}
		
			
			
@RequestMapping(value="/littlecherries/administrators/viewadministrators" , method = RequestMethod.GET)
	public String AdministratorViewAdministrators(Model model){
				if (userCredentials == null)
					return "registration";
				administrator adm = ad.getΑnAdmin(userCredentials.getEmail());
				if (adm!=null){
					

					model.addAttribute("user",adm);
					Iterable<administrator> ads = ad.getAllAdministrators(); 
					model.addAttribute("administrators", ads);
					
					if (adm.getRestrictions()== 6 ){
					   	
						return "viewadminswithoutadding" ; 
						
					}else
					 
						return "viewadministrators" ; 
			
				}else{
					
					return "registration"; 
				}
}
	
@RequestMapping(value="/littlecherries/administrators/viewrestrictions" , method = RequestMethod.GET)
public String AdministratorViewRestriction(Model model){
			if (userCredentials == null)
				return "registration";
			administrator adm = ad.getΑnAdmin(userCredentials.getEmail());
			if (adm!=null){
				model.addAttribute("user",adm);
				Iterable<restrictions> R = rs.getAllRestrictions(); 
				List<restrictions> rlist = new ArrayList<restrictions>();
				for (restrictions r: R)
					rlist.add(r);
				model.addAttribute("restrict", rlist); 
				return "viewrestrictions"; 
		
			}else{
				
				return "registration"; 
			}
}
	
@RequestMapping(value="/littlecherries/administrators/viewevents" , method = RequestMethod.GET)
public String AdministratorViewEvents(Model model){
		
	List<event> list = new ArrayList<event>(); 
	
	Iterable<organizer> Organizers = oc.getAllOrganizers(); 
	for(organizer o:Organizers){
		
		Set<event> ev = o.getEvents();
		for(event e: ev) 
			list.add(e); 
    }
	
	model.addAttribute("events", list);
	
	if(userCredentials == null){
			model.addAttribute("user", null); 
	        return "registration"; }
	else{

		organizer org = oc.getOrganizerByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		parent par = pr.getParentByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		administrator adm = ad.getAdministratorByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		if (org != null){
			model.addAttribute("org",org);
			return "EventPage";}
		else{
			if(par!=null){
				model.addAttribute("par",par); 
				return "EventPage"; }
			else{ 
				
				if(adm != null )
					model.addAttribute("user",adm);
				
			}
		}
	
		}
  
	 return "viewevents"; 
		
	}
@RequestMapping(value = "/littlecherries/administrators/addnewadmin", method = RequestMethod.GET) 
public String AdminAddsAdmin(Model model) {
	if (userCredentials == null)
		return "registration";
	administrator adm = ad.getΑnAdmin(userCredentials.getEmail());

	if (adm==null)
		return "registration";
	else {
		model.addAttribute("user",adm);
		if (adm.getRestrictions() == 6)
			return "cannotAddAdmin";
		model.addAttribute("admin", administratordto);
		return "createadmin";
	}
}

@RequestMapping(value = "/littlecherries/administrators/addnewadmin", method = RequestMethod.POST) 
public String AdminCreatesAdmin(Model model, @ModelAttribute("administratordto") @Valid AdministratorDTO administratorDto, 
	      BindingResult result, WebRequest request, Errors errors) throws ParseException {    
	
		if (userCredentials == null)
			return "registration";
		//if (result.hasErrors())return "login"; 
		administrator adm = ad.getΑnAdmin(userCredentials.getEmail());
		if (adm==null)
			return "registration";
   
	administrator a = ad.createNewAdmin(administratorDto.getEmail(), administratorDto.getFirstname(), administratorDto.getLastname() , administratorDto.getUsername(),
				administratorDto.getPassword(),administratorDto.getPhonenumber(),6) ; 
		
		//administrator a = ad.createNewAdmin(administratorDto.getEmail() , "", "", "", "", "",6);
		if (a==null)
			return "redirect:/littlecherries/administrators/addnewadmin";
	   
		return "redirect:/littlecherries/administrators/showprofile";  
	}


/// RESTRICTIONS // 

@RequestMapping(value = "/littlecherries/administrators/adminrights", method = RequestMethod.GET) 
public String AdminSetsRestrictions(Model model) {
	if (userCredentials == null)
		return "registration";
	administrator adm = ad.getΑnAdmin(userCredentials.getEmail());
	if (adm==null )
		return "registration";
	else {
		model.addAttribute("user",adm);
		if (adm.getRestrictions() == 5)
			return "cannotAddAdmin";
		model.addAttribute("blocked", blockeddto);
		Iterable<restrictions> R = rs.getAllRestrictions(); 
		model.addAttribute("restrict", R); 
		return "assignrestrictions";
	}
}

@RequestMapping(value = "/littlecherries/administrators/adminrights", method = RequestMethod.POST)
	public String AdminAssignsRestrictions(Model model, @ModelAttribute("blockeddto") @Valid BlockedDTO blockedDto, 
	      BindingResult result, WebRequest request, Errors errors) throws ParseException {    
	
		if (userCredentials == null)
			return "registration";
		//if (result.hasErrors())return "login"; 
		administrator adm = ad.getΑnAdmin(userCredentials.getEmail());
		if (adm==null)
			return "registration";
		else{
			
		    String usermail = blockedDto.getEmail(); 
		    int res = blockedDto.getRenum(); 
		    
		    int type = us.getTypeByEmail(usermail) ;  
			
		    if (type==0 && (res==1 || res ==2 || res == 3 || res == 7) ) {  // parent 
		    	   parent p; 
		    	   p = pr.getParentByEmail(usermail) ; 
		    	   p = pr.UpdateParentRestrictions(usermail,res); 
		    	   model.addAttribute("user",adm); 
		    	   return "successfulrestrictionparents" ;
		    	
		    	
		    }else if(type == 1 && (res==4 || res == 7) ){ //organizer
		     organizer o ;	
		     o = oc.getOrganizerByEmail(usermail); 
		     o = oc.UpdateOrganizerRestrictions(usermail,res) ; 
		     model.addAttribute("user",adm); 
		     return "successfulrestrictionorganizers";
		    	
		    }else if(type==2 && (res == 5 || res == 6 || res == 7) ){  // admin 
		    	
		    	 administrator a; 
			     a = ad.getAdminByEmail(usermail); 
			     a = ad.UpdateAdminRestrictions(usermail,res) ; 
			     model.addAttribute("user",adm); 
			     return "successfulrestrictionadmins";  // mporei kai show profile sthn synexeia 
			    	
		    	
		    }else{
		    	
		    	return "usernotfound" ; 
		    }
			
			
		}
        
}

//Picture Upload


@Bean(name = "multipartResolver")
public CommonsMultipartResolver multipartResolver() {
  CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
  multipartResolver.setMaxUploadSize(100000);
  return multipartResolver;
}

@RequestMapping(value = "/littlecherries/{eventid}/pictureUpload", method= RequestMethod.GET)
public String showUploadForm (Model model, @ModelAttribute("eventid") int eventid) {
/*	if (userCredentials == null)
		return "registration";
	parent par= pr.getΑParent(userCredentials.getEmail());
	if (par != null) {
		model.addAttribute("user",par);
		List<event> myevents = new ArrayList<event> ();
		Set<willattend> wa = par.getWillattend();
		for (willattend i : wa) {
			if (i.getValid() == 1)
				myevents.add(i.getAnevent());
		}
		model.addAttribute("list",myevents);
		return "view_events_to_go"; }
*/
	 event e= null;
	 organizer myorg=null;
	 Iterable<organizer> Organizers=oc.getAllOrganizers();
		for (organizer o: Organizers) {
			e = oc.getAnEvent(o.getOemail(), eventid);
			if (e != null)  {
				myorg=o;
				break; }
		}
	 if (e== null)
		 return "redirect:/littlecherries/events";
	 
	 fl = new FileHandler();
	
	 model.addAttribute("event",e);
	
	model.addAttribute("fl", fl);
	return "uploadForm";
	}

@RequestMapping(value = "/littlecherries/{eventid}/pictureUpload", method= RequestMethod.POST)
public String uploadPicture (Model model, @ModelAttribute("eventid") int eventid, @ModelAttribute("fl") FileHandler fl) throws IOException {
	
	//MultipartFile Image = img.getImage();
	
	if(fl==null) return "BULO";
	if (fl.getImage() == null) return "nullfoto";

	// change any provided image type to png
	// path = Paths.get(rootDirectory + "/WEB-INF/resources/images" +
	// product.getProductId() + ".png");
	path = Paths.get("C:\\Users\\ftstr\\git\\cherries\\ch2\\src\\main\\resources\\static\\images\\event_images\\"
			+ eventid + ".png");

	// check whether image exists or not
	//if (Image != null && !Image.isEmpty()) {
		try {
			// convert the image type to png
				fl.getImage().transferTo(new File(path.toString()));
				//return "registration";
		} catch (IllegalStateException e) {
			// oops! something did not work as expected
			//e.printStackTrace();
			throw new RuntimeException("Saving User image was not successful", e);
			
		}
	
	//if(Image != null) return "geiaa";
	return "registration";
	
}

}

