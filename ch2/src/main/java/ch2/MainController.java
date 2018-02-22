package ch2;


import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import register.AdministratorDTO;
import register.CreditsForm;
import register.EventDTO;
import register.OrganizerDTO;
import register.OrganizerToUpdate;
import register.ParentDTO;
import register.ParentToUpdate;
import register.Row;
import register.Rowlist;


@Controller
//@RequestMapping("/")
public class MainController {
	
	@Autowired
	private OrganizerController oc;
	@Autowired
    private ParentController pr; 
	/*@Autowired 
	private SmtpEmailSender sender; */ 
	@Autowired 
    private AdministratorController ad; 

    ParentDTO parentdto = new ParentDTO(); 
    OrganizerDTO organizerdto = new OrganizerDTO();
    AdministratorDTO administratordto = new AdministratorDTO(); 
    OrganizerToUpdate orgupdate = new OrganizerToUpdate();
    ParentToUpdate parupdate = new ParentToUpdate(); 
    ChangePasswordForm changepsw = new ChangePasswordForm();
    CreditsForm crform = new CreditsForm();
    UserCredentials userCredentials;

    EventDTO eventdto = new EventDTO();
    Rowlist list ;
    Row row;
    event ev;

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
						model.addAttribute("user",adm);
					
				}
			}
		
			}
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
						model.addAttribute("user",adm);
					
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
					model.addAttribute("user",adm);
				
			}
		}
		}
    return "OurCompanyPage";
  }

 
 ///  RDF SERVICE ///
 
 
 @RequestMapping(value="/littlecherries/pdfservice")
 public String createPDF() throws FileNotFoundException, MalformedURLException {
	 String dest = "C:\\Users\\vasil\\Desktop\\hello.pdf";       
     PdfWriter writer = new PdfWriter(dest);           
     
     // Creating a PdfDocument       
     PdfDocument pdf = new PdfDocument(writer); 
    // Creating a Document       
     Document document = new Document(pdf);  
     String imFile = "C:\\Users\\vasil\\Downloads\\ch2\\ch2\\src\\main\\resources\\static\\logo.png";       
     ImageData data = ImageDataFactory.create(imFile);              
     
     // Creating an Image object        
     Image image = new Image(data);                        
     
     // Adding image to the document       
     document.add(image);              
     
     String para1 = "Hello World !" ; 
     String para2 = "Hello Little Cherries !"; 
     
     // Creating Paragraphs       
     Paragraph paragraph1 = new Paragraph(para1);             
     Paragraph paragraph2 = new Paragraph(para2);              
     
     // Adding paragraphs to document       
     document.add(paragraph1);       
     document.add(paragraph2);           
     
     // Closing the document       
     document.close();       
     
     return "pdfservice" ;
     
  } 
 
 
 /// EMAIL SERVICE /// 
 /*
 @RequestMapping(value="/littlecherries/pdfservice/emailit", method=RequestMethod.POST)
 public String SendByEmail() throws MessagingException{
	 
	   String Subject = "LittleCherries Ticket!"; 
	   String Text = "Hello Cherry!! " ; 
	   try{ 
		   sender.send("tassopoulouvasiliki@gmail.com",Subject,Text); }
	  catch(MessagingException e){
		  
		  e.printStackTrace();
	  }
	   
	   return "emailservice"; 
 }
 
*/ 
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
		parent par = pr.getParentByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		administrator adm = ad.getAdministratorByEmailAndPassw(userCredentials.getEmail(), userCredentials.getPassword());
		if (org != null) 
			model.addAttribute("org",org);
		else{
			if(par!=null)
				model.addAttribute("par",par); 
			else{ 
				
				if(adm != null )
					model.addAttribute("user",adm);
				
			}
		}
	
		}
    return "EventPage";
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



//////// PARENT ////////////////////

@RequestMapping(value = "/littlecherries/parents/register", method = RequestMethod.POST)
	public String showRegistrationFormParent(WebRequest request, Model model ) {
	 model.addAttribute("parent", parentdto);
	    return "register-gonea";
}
private parent createParentAccount(ParentDTO accountDto, BindingResult result) {
    parent registered = null;
    registered = pr.createParent(accountDto.getEmail(),accountDto.getFirstname(),accountDto.getLastname(),accountDto.getUsername(),accountDto.getPassword(),accountDto.getPhonenumber(),accountDto.getStreetname(),
    		accountDto.getStreetnumber(),accountDto.getTown(),accountDto.getPostalcode());
    
    return registered;
}

@RequestMapping(value = "/littlecherries/parents/register", method = RequestMethod.GET)
public String registerUserAccount(Model model, @ModelAttribute("parentdto") @Valid ParentDTO accountDto, 
      BindingResult result, WebRequest request, Errors errors, final RedirectAttributes redirectAttributes) {    
       parent registered = new parent(); 
    //System.out.print("enter registerUserAccount");
    if (result.hasErrors()) {
    	model.addAttribute("parent", parentdto);
    	return "register-gonea";
    }
    else {
        registered = createParentAccount(accountDto, result);
     
    if (registered==null)
    	return "UnsuccessfulRegistrationPage";
    redirectAttributes.addFlashAttribute("flashUser", registered);
    return "redirect:/littlecherries/ecessful"; }
}

	
//////// LOGIN ///////////////////


@RequestMapping(value ="/littlecherries/login" ,method=RequestMethod.GET)
public String loginPage(Model model){
		model.addAttribute("userCredential", new UserCredentials());
		return "login"; }



///// ORGANIZER PARENT AND ADMIN LOGIN //////

@RequestMapping(value ="/littlecherries/login" ,method=RequestMethod.POST)
public String loginSuccess(Model model, @Valid @ModelAttribute("userCredential") UserCredentials myuserCredentials,
		BindingResult bindingResult,
		final RedirectAttributes redirectAttributes){
	if(bindingResult.hasErrors()){
		return "login";
	}
	//ModelAndView modelAndView = new ModelAndView("welcome");
	organizer org = oc.getOrganizerByEmailAndPassw(myuserCredentials.getEmail(), myuserCredentials.getPassword());
	parent par = pr.getParentByEmailAndPassw(myuserCredentials.getEmail(), myuserCredentials.getPassword());
	
	 if(org!= null){
		redirectAttributes.addFlashAttribute("user", org);
		userCredentials=myuserCredentials;
		userCredentials.setType(1);
		return "redirect:/littlecherries/organizers/showprofile";
	}else if(par!=null){
			redirectAttributes.addFlashAttribute("user", par);
			userCredentials=myuserCredentials;
			userCredentials.setType(0);
			return "redirect:/littlecherries/parents/showprofile";
		}
	
		return "registration";
	}


	

/////////  PROFILE AND ACTION STUFF  ///////////////


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
		model.addAttribute("event", eventdto);
		model.addAttribute("user",org);
		return "event_creation";
	}
}

@RequestMapping(value = "/littlecherries/organizers/addevent", method = RequestMethod.POST) 
public String OrganizerCreatesEvent(Model model, @ModelAttribute("eventdto") @Valid EventDTO eventDto, 
	      BindingResult result, WebRequest request, Errors errors) throws ParseException {    
	
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
				eventDto.getEndage(),eventDto.getDuration());
		if (e==null)
			return "redirect:/littlecherries/organizers/addevent";
	    ev=e;
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
		Rowlist mylist= new Rowlist();
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
			//SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
			//String mytime = localDateFormat.format(r.getTime().getTime());
			//Date ttime = (Date)localDateFormat.parse(mytime);
			eventinfo ei = new eventinfo(r.getDate(),r.getTickets(), r.getTime());
			newset.add(ei); }
			oc.saveNewEvent(org.getOemail(), ev, newset);
			model.addAttribute("user",org);
			Set<event> ev=org.getEvents();
			model.addAttribute("events", ev); 
		return "redirect:/littlecherries/organizers/viewmyevents"; }
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
	    	int prev=par.getBalance();
	    	int curr=prev + crform.getPoints() ;
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





}