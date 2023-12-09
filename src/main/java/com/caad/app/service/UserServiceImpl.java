package com.caad.app.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caad.app.entity.User;
import com.caad.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	//Inyecccion de servicio para usar el la intefaz de UserRepositoy
	@Autowired
	private UserRepository userRepository;

	/*
	 * Implemetacion de metodos de ionterfaz UserService
	 * @Transaccional efectua si la db tiene modificacion o si es de solo lectura. Si no se usan parametros da por entendido que hace modificaciones en la db.
	 */
	@Override
	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {

		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> finById(Long id) {

		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {

		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

}
