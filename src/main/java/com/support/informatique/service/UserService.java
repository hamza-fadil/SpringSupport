package com.support.informatique.service;

import com.support.informatique.entities.User;

public interface UserService {

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#save(S)
	 */
	<S extends User> S save(S entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findOne(java.lang.Integer)
	 */
	User findOne(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#exists(java.lang.Integer)
	 */
	boolean exists(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findAll()
	 */
	Iterable<User> findAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#count()
	 */
	long count();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#delete(com.support.informatique.entities.User)
	 */
	void delete(User entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findByEmail(java.lang.String)
	 */
	String findByEmail(String name);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findById(java.lang.Integer)
	 */
	User findById(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#deletebyId(java.lang.Integer)
	 */
	void deletebyId(Integer id);
	
	String findName(String name);

}