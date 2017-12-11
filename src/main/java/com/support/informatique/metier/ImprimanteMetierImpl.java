package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.informatique.dao.ImprimanteRepository;
import com.support.informatique.entities.Imprimante;


@Component
public class ImprimanteMetierImpl  {

	@Autowired
	private ImprimanteRepository ImprimanteRepository;

	public <S extends Imprimante> S save(S entity) {
		return ImprimanteRepository.save(entity);
	}

	public <S extends Imprimante> Iterable<S> save(Iterable<S> entities) {
		return ImprimanteRepository.save(entities);
	}

	public Imprimante findOne(Integer id) {
		return ImprimanteRepository.findOne(id);
	}

	public boolean exists(Integer id) {
		return ImprimanteRepository.exists(id);
	}

	public Iterable<Imprimante> findAll() {
		return ImprimanteRepository.findAll();
	}

	public Iterable<Imprimante> findAll(Iterable<Integer> ids) {
		return ImprimanteRepository.findAll(ids);
	}

	public long count() {
		return ImprimanteRepository.count();
	}

	public void delete(Integer id) {
		ImprimanteRepository.delete(id);
	}

	public void delete(Imprimante entity) {
		ImprimanteRepository.delete(entity);
	}

	public void delete(Iterable<? extends Imprimante> entities) {
		ImprimanteRepository.delete(entities);
	}

	public void deleteAll() {
		ImprimanteRepository.deleteAll();
	}

	public Imprimante findById(Integer id) {
		return ImprimanteRepository.findById(id);
	}



}
