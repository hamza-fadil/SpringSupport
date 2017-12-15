package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.UserRepository;
import com.support.informatique.entities.User;

@Service
public class UserMetierImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#save(S)
	 */
	@Override
	public <S extends User> S save(S entity) {
		return userRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findOne(java.lang.Integer)
	 */
	@Override
	public User findOne(Integer id) {
		return userRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#exists(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#exists(java.lang.Integer)
	 */
	@Override
	public boolean exists(Integer id) {
		return userRepository.exists(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findAll()
	 */
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#count()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#count()
	 */
	@Override
	public long count() {
		return userRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#delete(com.support.informatique.entities.User)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#delete(com.support.informatique.entities.User)
	 */
	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findByEmail(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findByEmail(java.lang.String)
	 */
	@Override
	public User findByEmail(String name) {
		return userRepository.findByEmail(name);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findById(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#findById(java.lang.Integer)
	 */
	@Override
	public User findById(Integer id) {
		return userRepository.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#deletebyId(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.UserService#deletebyId(java.lang.Integer)
	 */
	@Override
	public void deletebyId(Integer id) {
		userRepository.deletebyId(id);
	}


}
