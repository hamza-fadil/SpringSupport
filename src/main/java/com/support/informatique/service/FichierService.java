package com.support.informatique.service;

import com.support.informatique.entities.Fichier;

public interface FichierService {

	<S extends Fichier> S save(S entity);

	<S extends Fichier> Iterable<S> save(Iterable<S> entities);

	Fichier findOne(Integer id);

	boolean exists(Integer id);

	Iterable<Fichier> findAll();

	Iterable<Fichier> findAll(Iterable<Integer> ids);

	long count();

	void delete(Integer id);

	void delete(Fichier entity);

	void delete(Iterable<? extends Fichier> entities);

	void deleteAll();

	void deletebyId(Integer id);

	byte[] findByFichier(int id);

}