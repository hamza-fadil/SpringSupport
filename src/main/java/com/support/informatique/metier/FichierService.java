package com.support.informatique.metier;

import com.support.informatique.entities.Fichier;

public interface FichierService {

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#save(S)
	 */
	<S extends Fichier> S save(S entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#save(java.lang.Iterable)
	 */
	<S extends Fichier> Iterable<S> save(Iterable<S> entities);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#findOne(java.lang.Integer)
	 */
	Fichier findOne(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#exists(java.lang.Integer)
	 */
	boolean exists(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#findAll()
	 */
	Iterable<Fichier> findAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#findAll(java.lang.Iterable)
	 */
	Iterable<Fichier> findAll(Iterable<Integer> ids);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#count()
	 */
	long count();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#delete(java.lang.Integer)
	 */
	void delete(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#delete(com.support.informatique.entities.Fichier)
	 */
	void delete(Fichier entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#delete(java.lang.Iterable)
	 */
	void delete(Iterable<? extends Fichier> entities);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#deleteAll()
	 */
	void deleteAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#deletebyId(java.lang.Integer)
	 */
	void deletebyId(Integer id);

}