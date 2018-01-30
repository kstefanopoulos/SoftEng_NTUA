package register;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import ch2.organizer;

public class ORegisterController {

	
	@RequestMapping(value = "/organizer/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
	    OrganizerDTO organizerdto = new OrganizerDTO();
	    model.addAttribute("organizer", organizerdto);
	    return "registration";
	}
	
	
	@RequestMapping(value = "/organizer/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid OrganizerDTO accountDto, 
	      BindingResult result, WebRequest request, Errors errors) {    
	    organizer registered = new organizer();
	    if (!result.hasErrors()) {
	        registered = createOrganizerAccount(accountDto, result);
	    }
	    if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
	    // rest of the implementation
	}
	private organizer createOrganizerAccount(OrganizerDTO accountDto, BindingResult result) {
	    organizer registered = null;
	    try {
	        registered = service.registerNewUserAccount(accountDto);
	    } catch (EmailExistsException e) {
	        return null;
	    }    
	    return registered;
	}
	
	
}
