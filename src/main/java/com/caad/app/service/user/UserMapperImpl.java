package com.caad.app.service.user;

import com.caad.app.entity.User;
import com.caad.app.model.UserDTO;

public class UserMapperImpl implements UserMapper {

	@Override
	public User mapUser(final UserDTO theUser) {
		User response =  new User();
		response.setId(theUser.getId());
		response.setName(theUser.getName());
		response.setUsername(theUser.getUsername());
		response.setEmail(theUser.getEmail());
		response.setPassword(theUser.getPassword());
		response.setUserStatus(theUser.getUserStatus());
		return response;
	}

	@Override
	public UserDTO mapUser(final User theUser) {
		UserDTO response =  new UserDTO();
		response.setId(theUser.getId());
		response.setName(theUser.getName());
		response.setUsername(theUser.getUsername());
		response.setEmail(theUser.getEmail());
		response.setPassword(theUser.getPassword());
		response.setUserStatus(theUser.getUserStatus());
		return response;
	}

}
