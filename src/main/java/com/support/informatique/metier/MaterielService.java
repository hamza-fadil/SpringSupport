package com.support.informatique.metier;

import com.support.informatique.entities.Materiel;

public interface MaterielService {

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#save(S)
	 */
	<S extends Materiel> S save(S entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#findOne(java.lang.Integer)
	 */
	Materiel findOne(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#findAll()
	 */
	Iterable<Materiel> findAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#delete(java.lang.Integer)
	 */
	void delete(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#delete(com.support.informatique.entities.Materiel)
	 */
	void delete(Materiel entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#deletebyId(java.lang.Integer)
	 */
	void deletebyId(Integer id);

}