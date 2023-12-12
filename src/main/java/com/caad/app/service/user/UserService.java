package com.caad.app.service.user;

import java.util.List;

import com.caad.app.model.UserDTO;

/*
 * Capa de negocio para los requerimientos del controlador de usuarios
 */
public interface UserService {

	UserDTO createUser (final UserDTO theUser);
	
	List<UserDTO> getAll();

}
