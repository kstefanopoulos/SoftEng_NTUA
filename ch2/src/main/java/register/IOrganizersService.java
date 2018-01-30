package register;

import ch2.organizer;

public interface IOrganizersService {

    organizer registerNewUserAccount(OrganizerDTO accountDto)     
    	      throws EmailExistsException;
	
}
