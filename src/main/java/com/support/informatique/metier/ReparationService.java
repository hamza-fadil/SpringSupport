package com.support.informatique.metier;

import com.support.informatique.entities.Reparation;

public interface ReparationService {

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#save(S)
	 */
	<S extends Reparation> S save(S entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#save(java.lang.Iterable)
	 */
	<S extends Reparation> Iterable<S> save(Iterable<S> entities);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findOne(java.lang.Integer)
	 */
	Reparation findOne(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#exists(java.lang.Integer)
	 */
	boolean exists(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#deletebyId(java.lang.Integer)
	 */
	void deletebyId(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findById(int)
	 */
	Reparation findById(int id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findAll()
	 */
	Iterable<Reparation> findAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findAll(java.lang.Iterable)
	 */
	Iterable<Reparation> findAll(Iterable<Integer> ids);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#count()
	 */
	long count();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#delete(java.lang.Integer)
	 */
	void delete(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#delete(com.support.informatique.entities.Reparation)
	 */
	void delete(Reparation entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#delete(java.lang.Iterable)
	 */
	void delete(Iterable<? extends Reparation> entities);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#deleteAll()
	 */
	void deleteAll();

}