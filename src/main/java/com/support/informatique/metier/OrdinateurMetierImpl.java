package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.informatique.dao.OrdinateurRepository;
import com.support.informatique.entities.Ordinateur;


@Component
public class OrdinateurMetierImpl  {

	@Autowired
	private OrdinateurRepository OrdinateurRepository;

	public Ordinateur findById(int id) {
		return OrdinateurRepository.findById(id);
	}

	public <S extends Ordinateur> S save(S entity) {
		return OrdinateurRepository.save(entity);
	}

	public <S extends Ordinateur> Iterable<S> save(Iterable<S> entities) {
		return OrdinateurRepository.save(entities);
	}

	public Ordinateur findOne(Integer id) {
		return OrdinateurRepository.findOne(id);
	}

	public boolean exists(Integer id) {
		return OrdinateurRepository.exists(id);
	}

	public Iterable<Ordinateur> findAll() {
		return OrdinateurRepository.findAll();
	}

	public Iterable<Ordinateur> findAll(Iterable<Integer> ids) {
		return OrdinateurRepository.findAll(ids);
	}

	public long count() {
		return OrdinateurRepository.count();
	}

	public void delete(Integer id) {
		OrdinateurRepository.delete(id);
	}

	public void delete(Ordinateur entity) {
		OrdinateurRepository.delete(entity);
	}

	public void delete(Iterable<? extends Ordinateur> entities) {
		OrdinateurRepository.delete(entities);
	}

	public void deleteAll() {
		OrdinateurRepository.deleteAll();
	}


}
