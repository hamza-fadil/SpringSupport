package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.informatique.dao.ReparationRepository;
import com.support.informatique.entities.Reparation;


@Component
public class ReparationMetierImpl  {

	@Autowired
	private ReparationRepository ReparationRepository;

	public <S extends Reparation> S save(S entity) {
		return ReparationRepository.save(entity);
	}

	public <S extends Reparation> Iterable<S> save(Iterable<S> entities) {
		return ReparationRepository.save(entities);
	}

	public Reparation findOne(Integer id) {
		return ReparationRepository.findOne(id);
	}

	public boolean exists(Integer id) {
		return ReparationRepository.exists(id);
	}

	public void deletebyId(Integer id) {
		ReparationRepository.deletebyId(id);
	}

	public Reparation findById(int id) {
		return ReparationRepository.findById(id);
	}

	public Iterable<Reparation> findAll() {
		return ReparationRepository.findAll();
	}

	public Iterable<Reparation> findAll(Iterable<Integer> ids) {
		return ReparationRepository.findAll(ids);
	}

	public long count() {
		return ReparationRepository.count();
	}

	public void delete(Integer id) {
		ReparationRepository.delete(id);
	}

	public void delete(Reparation entity) {
		ReparationRepository.delete(entity);
	}

	public void delete(Iterable<? extends Reparation> entities) {
		ReparationRepository.delete(entities);
	}

	public void deleteAll() {
		ReparationRepository.deleteAll();
	}
	
}
