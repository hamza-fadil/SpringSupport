package com.support.informatique.service;

import com.support.informatique.entities.Telephone;

public interface TelephoneService {

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findById(int)
	 */
	Telephone findById(int id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#save(S)
	 */
	<S extends Telephone> S save(S entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#save(java.lang.Iterable)
	 */
	<S extends Telephone> Iterable<S> save(Iterable<S> entities);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findOne(java.lang.Integer)
	 */
	Telephone findOne(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#exists(java.lang.Integer)
	 */
	boolean exists(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findAll()
	 */
	Iterable<Telephone> findAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findAll(java.lang.Iterable)
	 */
	Iterable<Telephone> findAll(Iterable<Integer> ids);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#count()
	 */
	long count();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#delete(java.lang.Integer)
	 */
	void delete(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#delete(com.support.informatique.entities.Telephone)
	 */
	void delete(Telephone entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#delete(java.lang.Iterable)
	 */
	void delete(Iterable<? extends Telephone> entities);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#deleteAll()
	 */
	void deleteAll();

}