package com.support.informatique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.ReparationRepository;
import com.support.informatique.entities.Reparation;


@Service
public class ReparationMetierImpl implements ReparationService  {

	@Autowired
	private ReparationRepository ReparationRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#save(S)
	 */
	@Override
	public <S extends Reparation> S save(S entity) {
		return ReparationRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#save(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#save(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#save(java.lang.Iterable)
	 */
	@Override
	public <S extends Reparation> Iterable<S> save(Iterable<S> entities) {
		return ReparationRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#findOne(java.lang.Integer)
	 */
	@Override
	public Reparation findOne(Integer id) {
		return ReparationRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#exists(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#exists(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#exists(java.lang.Integer)
	 */
	@Override
	public boolean exists(Integer id) {
		return ReparationRepository.exists(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#deletebyId(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#deletebyId(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#deletebyId(java.lang.Integer)
	 */
	@Override
	public void deletebyId(Integer id) {
		ReparationRepository.deletebyId(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findById(int)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findById(int)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#findById(int)
	 */
	@Override
	public Reparation findById(int id) {
		return ReparationRepository.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#findAll()
	 */
	@Override
	public Iterable<Reparation> findAll() {
		return ReparationRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findAll(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#findAll(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#findAll(java.lang.Iterable)
	 */
	@Override
	public Iterable<Reparation> findAll(Iterable<Integer> ids) {
		return ReparationRepository.findAll(ids);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#count()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#count()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#count()
	 */
	@Override
	public long count() {
		return ReparationRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#delete(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#delete(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		ReparationRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#delete(com.support.informatique.entities.Reparation)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#delete(com.support.informatique.entities.Reparation)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#delete(com.support.informatique.entities.Reparation)
	 */
	@Override
	public void delete(Reparation entity) {
		ReparationRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#delete(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#delete(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<? extends Reparation> entities) {
		ReparationRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#deleteAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ReparationService#deleteAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.service.RapportService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		ReparationRepository.deleteAll();
	}
	
}
