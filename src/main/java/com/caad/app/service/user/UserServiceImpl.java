package com.caad.app.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caad.app.entity.User;
import com.caad.app.model.UserDTO;
import com.caad.app.model.UserListResponseDTO;
import com.caad.app.model.UserResponseDTO;
import com.caad.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
		this.userMapper=userMapper;
		this.userRepository=userRepository;
	}

	@Override
	public UserDTO createUser(UserDTO theUser) {
		User toCreate = userMapper.mapUser(theUser);
		User create = userRepository.save(toCreate);
		return userMapper.mapUser(create);
	}

	@Override
	public List<UserDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
