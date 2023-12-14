package com.caad.app.service.user;

import java.util.List;
import java.util.Optional;

import com.caad.app.model.UserDTO;
import com.caad.app.model.UserSinIdDTO;

/*
 * Capa de negocio para los requerimientos del controlador de usuarios
 */
public interface UserService {

	UserDTO createUser(final UserSinIdDTO theUser);

	List<UserDTO> getAll();

	Optional<UserDTO> getUsername(final String username);
	
	Optional<UserDTO> getUserId(final Long id);
	
	UserDTO updateUser(final UserDTO theUser);

}
