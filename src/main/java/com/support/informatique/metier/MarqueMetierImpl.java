package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.MarqueRepository;
import com.support.informatique.entities.Marque;


@Service
public class MarqueMetierImpl implements MarqueService  {

	@Autowired
	private MarqueRepository MarqueRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#save(S)
	 */
	@Override
	public <S extends Marque> S save(S entity) {
		return MarqueRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#findOne(java.lang.Integer)
	 */
	@Override
	public Marque findOne(Integer id) {
		return MarqueRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#findAll()
	 */
	@Override
	public Iterable<Marque> findAll() {
		return MarqueRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#delete(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		MarqueRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#deletebyId(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#deletebyId(java.lang.Integer)
	 */
	@Override
	public void deletebyId(Integer id) {
		MarqueRepository.deletebyId(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#delete(com.support.informatique.entities.Marque)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.MarqueService#delete(com.support.informatique.entities.Marque)
	 */
	@Override
	public void delete(Marque entity) {
		MarqueRepository.delete(entity);
	}
	
}
