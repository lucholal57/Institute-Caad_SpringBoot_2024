package com.caad.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caad.app.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	

}
