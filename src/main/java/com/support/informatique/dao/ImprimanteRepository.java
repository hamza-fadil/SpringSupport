package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.support.informatique.entities.Imprimante;

@Repository
public interface ImprimanteRepository extends CrudRepository<Imprimante, Integer> {
	@Query("Select u from Imprimante u where u.idMateriel=:x")
	Imprimante findById(@Param("x") int id);
}