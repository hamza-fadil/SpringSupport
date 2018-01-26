package com.support.informatique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.FichierRepository;
import com.support.informatique.entities.Fichier;


@Service
public class FichierMetierImpl implements FichierService {

	@Autowired
	private FichierRepository FichierRepository;

	
	@Override
	public <S extends Fichier> S save(S entity) {
		return FichierRepository.save(entity);
	}

	
	@Override
	public <S extends Fichier> Iterable<S> save(Iterable<S> entities) {
		return FichierRepository.save(entities);
	}


	@Override
	public Fichier findOne(Integer id) {
		return FichierRepository.findOne(id);
	}

	
	@Override
	public boolean exists(Integer id) {
		return FichierRepository.exists(id);
	}

	
	@Override
	public Iterable<Fichier> findAll() {
		return FichierRepository.findAll();
	}


	
	
	@Override
	public Iterable<Fichier> findAll(Iterable<Integer> ids) {
		return FichierRepository.findAll(ids);
	}

	
	@Override
	public long count() {
		return FichierRepository.count();
	}

	
	@Override
	public void delete(Integer id) {
		FichierRepository.delete(id);
	}

	
	@Override
	public void delete(Fichier entity) {
		FichierRepository.delete(entity);
	}

	
	@Override
	public void delete(Iterable<? extends Fichier> entities) {
		FichierRepository.delete(entities);
	}

	
	@Override
	public void deleteAll() {
		FichierRepository.deleteAll();
	}

	
	@Override
	public void deletebyId(Integer id) {
		FichierRepository.deletebyId(id);
	}


	@Override
	public byte[] findByFichier(int id) {
		return FichierRepository.findByFichier(id);
	}






}
