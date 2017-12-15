package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.support.informatique.entities.Ordinateur;

@Repository
public interface OrdinateurRepository extends CrudRepository<Ordinateur, Integer> {
	@Query("Select u from Ordinateur u where u.idMateriel=:x")
	Ordinateur findById(@Param("x") int id);
}