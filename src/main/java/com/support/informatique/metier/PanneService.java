package com.support.informatique.metier;

import com.support.informatique.entities.Panne;

public interface PanneService {

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#save(S)
	 */
	<S extends Panne> S save(S entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#findOne(java.lang.Integer)
	 */
	Panne findOne(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#findAll()
	 */
	Iterable<Panne> findAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#delete(java.lang.Integer)
	 */
	void delete(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#delete(com.support.informatique.entities.Panne)
	 */
	void delete(Panne entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#deletebyId(java.lang.Integer)
	 */
	void deletebyId(Integer id);

}