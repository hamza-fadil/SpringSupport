package com.support.informatique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.UserRepository;
import com.support.informatique.entities.User;
@Service
public class UserMetierImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public <S extends User> S save(S entity) {
		return userRepository.save(entity);
	}

	@Override
	public User findOne(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	public boolean exists(Integer id) {
		return userRepository.exists(id);
	}

	@Override
	public Iterable<User> findTech(String type) {
		return userRepository.findTech(type);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public String findByEmail(String name) {
		return userRepository.findByEmail(name);
	}

	@Override
	public User findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public void deletebyId(Integer id) {
		userRepository.deletebyId(id);
	}
	
	@Override
	public String findName(String name) {
		return userRepository.findName(name);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}





}
