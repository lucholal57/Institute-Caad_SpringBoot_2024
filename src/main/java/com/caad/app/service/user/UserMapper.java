package com.caad.app.service.user;

import com.caad.app.entity.User;
import com.caad.app.model.UserDTO;
import com.caad.app.model.UserSinIdDTO;

public interface UserMapper {

	/*
	 * Metodo de mapero de UserDTO a UserEntity
	 */
	User mapUser(final UserDTO theUser);

	/*
	 * Metodo de mapero de UserEntity a UserDTO
	 */
	UserDTO mapUser(final User theUser);
	/*
	 * Metodo de mapero de UserSinIdDto a UserEntity
	 */
	User mapUser(final UserSinIdDTO theUser);
	/*
	 * Metodo para pasar un objeto a otro de target a source
	 */
	User fill(final UserDTO source, final User target);

}
