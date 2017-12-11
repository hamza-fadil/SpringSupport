package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.informatique.dao.TelephoneRepository;
import com.support.informatique.entities.Telephone;



@Component
public class TelephoneMetierImpl  {

	@Autowired
	private TelephoneRepository TelephoneRepository;

	public Telephone findById(int id) {
		return TelephoneRepository.findById(id);
	}

	public <S extends Telephone> S save(S entity) {
		return TelephoneRepository.save(entity);
	}

	public <S extends Telephone> Iterable<S> save(Iterable<S> entities) {
		return TelephoneRepository.save(entities);
	}

	public Telephone findOne(Integer id) {
		return TelephoneRepository.findOne(id);
	}

	public boolean exists(Integer id) {
		return TelephoneRepository.exists(id);
	}

	public Iterable<Telephone> findAll() {
		return TelephoneRepository.findAll();
	}

	public Iterable<Telephone> findAll(Iterable<Integer> ids) {
		return TelephoneRepository.findAll(ids);
	}

	public long count() {
		return TelephoneRepository.count();
	}

	public void delete(Integer id) {
		TelephoneRepository.delete(id);
	}

	public void delete(Telephone entity) {
		TelephoneRepository.delete(entity);
	}

	public void delete(Iterable<? extends Telephone> entities) {
		TelephoneRepository.delete(entities);
	}

	public void deleteAll() {
		TelephoneRepository.deleteAll();
	}

}
