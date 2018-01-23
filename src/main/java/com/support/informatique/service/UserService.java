package com.support.informatique.service;

import com.support.informatique.entities.User;

public interface UserService {

	<S extends User> S save(S entity);

	User findOne(Integer id);

	boolean exists(Integer id);

	Iterable<User> findAll();

	long count();

	void delete(User entity);

	String findByEmail(String name);

	User findById(Integer id);

	void deletebyId(Integer id);
	
	String findName(String name);
	
	User findByUsername(String username);
	Iterable<User> findTech(String type);
	User findByConfirmationToken(String confirmationToken);

}