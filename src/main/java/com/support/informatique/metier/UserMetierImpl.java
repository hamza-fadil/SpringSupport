package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.support.informatique.dao.UserRepository;
import com.support.informatique.entities.User;

@Component
public class UserMetierImpl {

	@Autowired
	private UserRepository userRepository;

	public <S extends User> S save(S entity) {
		return userRepository.save(entity);
	}

	public User findOne(Integer id) {
		return userRepository.findOne(id);
	}

	public boolean exists(Integer id) {
		return userRepository.exists(id);
	}

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public long count() {
		return userRepository.count();
	}

	public void delete(User entity) {
		userRepository.delete(entity);
	}

	public User findByEmail(String name) {
		return userRepository.findByEmail(name);
	}

	public User findById(Integer id) {
		return userRepository.findById(id);
	}

	public void deletebyId(Integer id) {
		userRepository.deletebyId(id);
	}


}
