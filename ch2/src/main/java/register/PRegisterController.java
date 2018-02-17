package register;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

public class PRegisterController {

	
	@RequestMapping(value = "/parent/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
	    ParentDTO parentdto = new ParentDTO();
	    model.addAttribute("parent", parentdto);
	    return "registration";
	}
	
} 