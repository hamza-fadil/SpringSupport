package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.MaterielRepository;
import com.support.informatique.entities.Materiel;


@Service
public class MaterielMetierImpl implements MaterielService  {

	@Autowired
	private MaterielRepository MaterielRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielMetier#save(S)
	 */
	@Override
	public <S extends Materiel> S save(S entity) {
		return MaterielRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielMetier#findOne(java.lang.Integer)
	 */
	@Override
	public Materiel findOne(Integer id) {
		return MaterielRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielMetier#findAll()
	 */
	@Override
	public Iterable<Materiel> findAll() {
		return MaterielRepository.findAll();
	}
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#delete(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielMetier#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		MaterielRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#delete(com.support.informatique.entities.Materiel)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielMetier#delete(com.support.informatique.entities.Materiel)
	 */
	@Override
	public void delete(Materiel entity) {
		MaterielRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielService#deletebyId(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MaterielMetier#deletebyId(java.lang.Integer)
	 */
	@Override
	public void deletebyId(Integer id) {
		MaterielRepository.deletebyId(id);
	}
	
}

