package com.caad.app.controller;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.List;

import org.aspectj.weaver.IUnwovenClassFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.caad.app.entity.User;
import com.caad.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Create new User
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	// Read User
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		Optional<User> optionalUser = userService.finById(id);

		// Si user no esta presente retornamos un notFound y con build construimos
		if (!optionalUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		// Return ok y el usuario
		return ResponseEntity.ok(optionalUser);

	}

	// Update User
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userUpdate, @PathVariable Long id) {

		Optional<User> optionalUSer = userService.finById(id);
		if (!optionalUSer.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		optionalUSer.get().setName(userUpdate.getName());
		optionalUSer.get().setSurname(userUpdate.getSurname());
		optionalUSer.get().setEmail(userUpdate.getEmail());
		optionalUSer.get().setEnabled(userUpdate.getEnabled());

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(optionalUSer.get()));
	}

	// Delete User
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		if (!userService.finById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	// Read all Users
	@GetMapping("")
	public List<User> readAll() {
		//Transformar Iterable en una lista
		List<User> listUsers = StreamSupport
				.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return listUsers;
	}

}
