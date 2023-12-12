package com.caad.app.service.user;

import com.caad.app.entity.User;
import com.caad.app.model.UserDTO;

public interface UserMapper {
	
	  /*
    Metodo de mapero de UserDTO a UserEntity
     */
    User mapUser(final UserDTO theUser);
    
    /*
    Metodo de mapero de UserEntity a UserDTO
     */
     UserDTO mapUser(final User theUser);

}
