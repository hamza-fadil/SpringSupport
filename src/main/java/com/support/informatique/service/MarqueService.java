package com.support.informatique.service;

import java.util.List;

import com.support.informatique.entities.Marque;

public interface MarqueService {

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#save(S)
	 */
	<S extends Marque> S save(S entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#findOne(java.lang.Integer)
	 */
	Marque findOne(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#findAll()
	 */
	Iterable<Marque> findAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#delete(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#delete(java.lang.Integer)
	 */
	void delete(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#deletebyId(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#deletebyId(java.lang.Integer)
	 */
	void deletebyId(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#delete(com.support.informatique.entities.Marque)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#delete(com.support.informatique.entities.Marque)
	 */
	void delete(Marque entity);

	List<Marque> findName();

}