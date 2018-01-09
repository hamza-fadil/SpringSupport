package com.support.informatique.dao;

import org.springframework.data.repository.CrudRepository;

import com.support.informatique.entities.Rapport;

public interface RapportRepository extends CrudRepository<Rapport, Integer> {

}
