package register;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch2.OrganizerRepository;
import ch2.organizer;

@Service
public class OrganizerService implements IOrganizersService{
	@Autowired
    private OrganizerRepository repository; 
     
    @Transactional
    @Override
    public organizer registerNewUserAccount(OrganizerDTO accountDto) 
      throws EmailExistsException {
         
        if (emailExist(accountDto.getEmail())) {  
            throw new EmailExistsException(
              "There is an account with that email adress: "
              +  accountDto.getEmail());
        }
   
        // the rest of the registration operation
    }
    private boolean emailExist(String email) {
        organizer user = repository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
