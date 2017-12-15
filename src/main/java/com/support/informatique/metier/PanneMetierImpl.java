package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.PanneRepository;
import com.support.informatique.entities.Panne;


@Service
public class PanneMetierImpl implements PanneService  {

	@Autowired
	private PanneRepository PanneRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#save(S)
	 */
	@Override
	public <S extends Panne> S save(S entity) {
		return PanneRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#findOne(java.lang.Integer)
	 */
	@Override
	public Panne findOne(Integer id) {
		return PanneRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#findAll()
	 */
	@Override
	public Iterable<Panne> findAll() {
		return PanneRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#delete(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		PanneRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#delete(com.support.informatique.entities.Panne)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#delete(com.support.informatique.entities.Panne)
	 */
	@Override
	public void delete(Panne entity) {
		PanneRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#deletebyId(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.PanneService#deletebyId(java.lang.Integer)
	 */
	@Override
	public void deletebyId(Integer id) {
		PanneRepository.deletebyId(id);
	}
	
}
