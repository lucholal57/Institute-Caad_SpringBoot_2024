package com.caad.app.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.caad.app.api.UsersApiDelegate;
import com.caad.app.model.UserDTO;
import com.caad.app.model.UserListResponseDTO;
import com.caad.app.model.UserResponseDTO;
import com.caad.app.model.UserSinIdDTO;
import com.caad.app.service.user.UserService;

public class UserController implements UsersApiDelegate {

	/*
	 * Variable para LOGS
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	// Inyeccion de servicio
	private UserService userService;

	// Contructor del controller para poder declarar en el config donde estan los
	// controller y poder hacer uso del mismo
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/*
	 * Creacion de usuario pasando UserSinIdDTO, ya que se recibe el schema sin id
	 * ya que es un post
	 */
	public ResponseEntity<UserResponseDTO> createUser(UserSinIdDTO userSinIdDTO) {

		LOGGER.trace(String.format("Creacion de usuario : %s", userSinIdDTO.toString()));
		// Creacion de responseDTO para pasar el usuario creado y poder retornar
		UserResponseDTO responseDTO = new UserResponseDTO();
		try {
			// createUser retorna un UserDTO el cual va a ser el que se muestra
			UserDTO response = userService.createUser(userSinIdDTO);
			responseDTO.user(response);
			return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseDTO);
		}

	}

	/*
	 * Listar todos los usuarios
	 */
	public ResponseEntity<UserListResponseDTO> getAllUsers() {

		LOGGER.trace("Listar Usuarios");
		// Creacion de responseDTO de tipo UserListResponseDTO ya que este contiene un
		// array de UserDTO para retornar
		UserListResponseDTO responseDTO = new UserListResponseDTO();
		try {
			// getAll retorna una lista de tipo UserDTO la cual despues se agrega al
			// responseDTO
			List<UserDTO> listUserDTO = userService.getAll();
			responseDTO.users(listUserDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseDTO);

		}

	}

	/*
	 * Buscar usuario por username
	 */
	public ResponseEntity<UserResponseDTO> getUsername(String username) {

		LOGGER.trace("Busqueda por username");
		// Creacion de resṕnseDTO de tipo UserResponseDTO para retornar
		UserResponseDTO responseDTO = new UserResponseDTO();

		try {
			// En este caso se utiliza un Optional ya que el usuario puede existir o no de
			// tipo UserDTO
			Optional<UserDTO> response = userService.getUsername(username);
			// Despues creamos userResponse para poder obtener el usuario que obtuvimos y
			// poder pasarselo a la respuesta para retornar
			if (response.isPresent()) {
				UserDTO userResponse = response.get();
				responseDTO.user(userResponse);
				return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
			} else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseDTO);
		}

	}

	/*
	 * Buscar usuario por Id
	 */
	public ResponseEntity<UserResponseDTO> getUserId(Long userId) {

		LOGGER.trace("Busqueda por id");
		// Creacion de resṕnseDTO de tipo UserResponseDTO para retornar
		UserResponseDTO responseDTO = new UserResponseDTO();

		try {
			Optional<UserDTO> response = userService.getUserId(userId);
			if (response.isPresent()) {
				UserDTO userResponse = response.get();
				responseDTO.user(userResponse);
				return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
			} else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseDTO);
		}

	}

	/*
	 * Actualizar ususario por ID
	 */
	public ResponseEntity<UserResponseDTO> updateUser(Long userId, UserDTO theUser) {

		LOGGER.trace("Buscar usuario por id y editar");
		UserResponseDTO responseDTO = new UserResponseDTO();
		// Validamos que el id que va por url sea igual al id el usuario que queremos
		// modificar
		if (!Objects.equals(userId, theUser.getId())) {
			LOGGER.error("El id que va por path es distinto al usuario que esta intentando actualizar");
		}

		try {
			UserDTO response = userService.updateUser(theUser);
			responseDTO.user(response);
			return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseDTO);
		}
	}

}
