package com.caad.app.service.user;

import com.caad.app.entity.User;
import com.caad.app.model.UserDTO;
import com.caad.app.model.UserSinIdDTO;

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
	public User mapUser(final UserSinIdDTO theUser) {
		User response =  new User();
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

	@Override
	public User fill(UserDTO source, User target) {
		target.setName(source.getName());
		target.setUsername(source.getUsername());
		target.setPassword(source.getPassword());
		target.setEmail(source.getEmail());
		target.setUserStatus(source.getUserStatus());
		return target;
	}

}
