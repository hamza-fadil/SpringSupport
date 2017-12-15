package com.support.informatique.metier;

import com.support.informatique.entities.Imprimante;

public interface ImprimanteService {

	<S extends Imprimante> S save(S entity);

	<S extends Imprimante> Iterable<S> save(Iterable<S> entities);

	Imprimante findOne(Integer id);

	boolean exists(Integer id);

	Iterable<Imprimante> findAll();

	Iterable<Imprimante> findAll(Iterable<Integer> ids);

	long count();

	void delete(Integer id);

	void delete(Imprimante entity);

	void delete(Iterable<? extends Imprimante> entities);

	void deleteAll();

	Imprimante findById(Integer id);

}