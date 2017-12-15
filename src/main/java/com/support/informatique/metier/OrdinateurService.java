package com.support.informatique.metier;

import com.support.informatique.entities.Ordinateur;

public interface OrdinateurService {

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findById(int)
	 */
	Ordinateur findById(int id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#save(S)
	 */
	<S extends Ordinateur> S save(S entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#save(java.lang.Iterable)
	 */
	<S extends Ordinateur> Iterable<S> save(Iterable<S> entities);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findOne(java.lang.Integer)
	 */
	Ordinateur findOne(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#exists(java.lang.Integer)
	 */
	boolean exists(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findAll()
	 */
	Iterable<Ordinateur> findAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findAll(java.lang.Iterable)
	 */
	Iterable<Ordinateur> findAll(Iterable<Integer> ids);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#count()
	 */
	long count();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#delete(java.lang.Integer)
	 */
	void delete(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#delete(com.support.informatique.entities.Ordinateur)
	 */
	void delete(Ordinateur entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#delete(java.lang.Iterable)
	 */
	void delete(Iterable<? extends Ordinateur> entities);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#deleteAll()
	 */
	void deleteAll();

}