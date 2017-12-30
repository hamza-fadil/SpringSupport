package com.support.informatique.service;

import com.support.informatique.entities.Taches;

public interface TachesService {

	long count();

	void delete(Integer arg0);

	void delete(Iterable<? extends Taches> arg0);

	void delete(Taches arg0);

	void deleteAll();

	void deletebyId(Integer id);

	boolean exists(Integer arg0);

	Iterable<Taches> findAll();

	Iterable<Taches> findAll(Iterable<Integer> arg0);

	Taches findOne(Integer arg0);

	<S extends Taches> Iterable<S> save(Iterable<S> arg0);

	<S extends Taches> S save(S arg0);

}