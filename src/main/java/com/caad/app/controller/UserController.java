package com.caad.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.caad.app.api.UsersApiDelegate;
import com.caad.app.model.UserDTO;
import com.caad.app.model.UserListResponseDTO;
import com.caad.app.model.UserResponseDTO;
import com.caad.app.service.user.UserService;

public class UserController implements UsersApiDelegate {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	public ResponseEntity<UserResponseDTO> createUser(UserDTO userDTO) {

		UserResponseDTO responseDTO = new UserResponseDTO();
		try {

			UserDTO response = userService.createUser(userDTO);
			responseDTO.user(response);
			return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseDTO);
		}

	}

	public ResponseEntity<UserListResponseDTO> getAllUsers() {
		UserListResponseDTO responseDTO = new UserListResponseDTO();
		try {
			List<UserDTO> listUserDTO = userService.getAll();
			responseDTO.users(listUserDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseDTO);

		}

	}
	
}
