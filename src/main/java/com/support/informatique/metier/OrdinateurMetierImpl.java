package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.OrdinateurRepository;
import com.support.informatique.entities.Ordinateur;


@Service
public class OrdinateurMetierImpl implements OrdinateurService {

	@Autowired
	private OrdinateurRepository OrdinateurRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findById(int)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findById(int)
	 */
	@Override
	public Ordinateur findById(int id) {
		return OrdinateurRepository.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#save(S)
	 */
	@Override
	public <S extends Ordinateur> S save(S entity) {
		return OrdinateurRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#save(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#save(java.lang.Iterable)
	 */
	@Override
	public <S extends Ordinateur> Iterable<S> save(Iterable<S> entities) {
		return OrdinateurRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findOne(java.lang.Integer)
	 */
	@Override
	public Ordinateur findOne(Integer id) {
		return OrdinateurRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#exists(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#exists(java.lang.Integer)
	 */
	@Override
	public boolean exists(Integer id) {
		return OrdinateurRepository.exists(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findAll()
	 */
	@Override
	public Iterable<Ordinateur> findAll() {
		return OrdinateurRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findAll(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#findAll(java.lang.Iterable)
	 */
	@Override
	public Iterable<Ordinateur> findAll(Iterable<Integer> ids) {
		return OrdinateurRepository.findAll(ids);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#count()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#count()
	 */
	@Override
	public long count() {
		return OrdinateurRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#delete(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		OrdinateurRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#delete(com.support.informatique.entities.Ordinateur)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#delete(com.support.informatique.entities.Ordinateur)
	 */
	@Override
	public void delete(Ordinateur entity) {
		OrdinateurRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#delete(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<? extends Ordinateur> entities) {
		OrdinateurRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#deleteAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.OrdinateurService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		OrdinateurRepository.deleteAll();
	}


}
