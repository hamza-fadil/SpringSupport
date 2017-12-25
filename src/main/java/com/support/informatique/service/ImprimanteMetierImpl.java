package com.support.informatique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.ImprimanteRepository;
import com.support.informatique.entities.Imprimante;


@Service
public class ImprimanteMetierImpl implements ImprimanteService  {

	@Autowired
	private ImprimanteRepository ImprimanteRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#save(S)
	 */
	@Override
	public <S extends Imprimante> S save(S entity) {
		return ImprimanteRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#save(java.lang.Iterable)
	 */
	@Override
	public <S extends Imprimante> Iterable<S> save(Iterable<S> entities) {
		return ImprimanteRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#findOne(java.lang.Integer)
	 */
	@Override
	public Imprimante findOne(Integer id) {
		return ImprimanteRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#exists(java.lang.Integer)
	 */
	@Override
	public boolean exists(Integer id) {
		return ImprimanteRepository.exists(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#findAll()
	 */
	@Override
	public Iterable<Imprimante> findAll() {
		return ImprimanteRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#findAll(java.lang.Iterable)
	 */
	@Override
	public Iterable<Imprimante> findAll(Iterable<Integer> ids) {
		return ImprimanteRepository.findAll(ids);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#count()
	 */
	@Override
	public long count() {
		return ImprimanteRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		ImprimanteRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#delete(com.support.informatique.entities.Imprimante)
	 */
	@Override
	public void delete(Imprimante entity) {
		ImprimanteRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<? extends Imprimante> entities) {
		ImprimanteRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		ImprimanteRepository.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ImprimanteService#findById(java.lang.Integer)
	 */
	@Override
	public Imprimante findById(Integer id) {
		return ImprimanteRepository.findById(id);
	}



}
