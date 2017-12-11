package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.support.informatique.entities.Imprimante;

@Component
public interface ImprimanteRepository extends CrudRepository<Imprimante, Integer> {
	@Query("Select u from Imprimante u where u.idMateriel=:x")
	Imprimante findById(@Param("x") int id);
}