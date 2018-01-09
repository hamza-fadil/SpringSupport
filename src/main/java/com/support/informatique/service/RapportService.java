package com.support.informatique.service;

import com.support.informatique.entities.Rapport;

public interface RapportService {

	long count();

	void delete(Integer arg0);

	void delete(Iterable<? extends Rapport> arg0);

	void delete(Rapport arg0);

	void deleteAll();

	boolean exists(Integer arg0);

	Iterable<Rapport> findAll();

	Iterable<Rapport> findAll(Iterable<Integer> arg0);

	Rapport findOne(Integer arg0);

	<S extends Rapport> Iterable<S> save(Iterable<S> arg0);

	<S extends Rapport> S save(S arg0);

}