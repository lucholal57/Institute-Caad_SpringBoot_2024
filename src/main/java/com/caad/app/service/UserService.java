package com.caad.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.caad.app.entity.User;

public interface UserService {

	public Iterable<User> findAll();

	public Page<User> findAll(Pageable pageable);

	public Optional<User> finById(Long id);

	public User save(User user);

	public void deleteById(Long id);

}
