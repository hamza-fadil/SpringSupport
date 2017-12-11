package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.informatique.dao.FichierRepository;
import com.support.informatique.entities.Fichier;


@Component
public class FichierMetierImpl  {

	@Autowired
	private FichierRepository FichierRepository;

	public <S extends Fichier> S save(S entity) {
		return FichierRepository.save(entity);
	}

	public <S extends Fichier> Iterable<S> save(Iterable<S> entities) {
		return FichierRepository.save(entities);
	}

	public Fichier findOne(Integer id) {
		return FichierRepository.findOne(id);
	}

	public boolean exists(Integer id) {
		return FichierRepository.exists(id);
	}

	public Iterable<Fichier> findAll() {
		return FichierRepository.findAll();
	}

	public Iterable<Fichier> findAll(Iterable<Integer> ids) {
		return FichierRepository.findAll(ids);
	}

	public long count() {
		return FichierRepository.count();
	}

	public void delete(Integer id) {
		FichierRepository.delete(id);
	}

	public void delete(Fichier entity) {
		FichierRepository.delete(entity);
	}

	public void delete(Iterable<? extends Fichier> entities) {
		FichierRepository.delete(entities);
	}

	public void deleteAll() {
		FichierRepository.deleteAll();
	}

	public void deletebyId(Integer id) {
		FichierRepository.deletebyId(id);
	}


}
