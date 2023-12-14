package com.caad.app.service.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.caad.app.entity.User;
import com.caad.app.model.UserDTO;
import com.caad.app.model.UserSinIdDTO;
import com.caad.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
		this.userMapper = userMapper;
		this.userRepository = userRepository;
	}

	// Service Crear Usuario
	@Override
	public UserDTO createUser(UserSinIdDTO theUser) {

		try {
			User toCreate = userMapper.mapUser(theUser);
			User create = userRepository.save(toCreate);
			return userMapper.mapUser(create);
		} catch (Exception e) {
			throw new UserServiceException("Error al crear usuario", e);
		}

	}

	// Service Listar Usuarios
	@Override
	public List<UserDTO> getAll() {
		try {
			Iterable<User> usersIterable = userRepository.findAll();
			Iterator<User> iterable = usersIterable.iterator();
			List<UserDTO> response = new ArrayList<>();

			while (iterable.hasNext()) {
				response.add(userMapper.mapUser(iterable.next()));

			}
			return response;

		} catch (Exception e) {
			throw new UserServiceException("Error al listar usuarios", e);
		}

	}

	// Service Get Usuario por Username
	@Override
	public Optional<UserDTO> getUsername(String username) {
		try {
			Optional<User> userOptional = userRepository.findByUsername(username);
			User user = userOptional.get();
			return Optional.ofNullable(userMapper.mapUser(user));

		} catch (Exception e) {
			throw new UserServiceException("Error al buscar usuario por username", e);
		}

	}

	// Service get Usuario por ID
	@Override
	public Optional<UserDTO> getUserId(Long id) {
		try {
			Optional<User> userOptional = userRepository.findById(id);
			User user = userOptional.get();
			return Optional.ofNullable(userMapper.mapUser(user));

		} catch (Exception e) {
			throw new UserServiceException("Error al buscar usuario por id", e);
		}

	}

	@Override
	public UserDTO updateUser(UserDTO theUser) {

		try {
			Optional<User> userOptional = userRepository.findById(theUser.getId());
			User user = userOptional.get();
			User userFill = userMapper.fill(theUser, user);
			User userSaved = userRepository.save(userFill);
			return userMapper.mapUser(userSaved);

		} catch (Exception e) {
			throw new UserServiceException("Error al editar usuario por id", e);
		}

	}

}
