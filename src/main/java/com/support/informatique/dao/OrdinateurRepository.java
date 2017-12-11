package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.support.informatique.entities.Ordinateur;

@Component
public interface OrdinateurRepository extends CrudRepository<Ordinateur, Integer> {
	@Query("Select u from Ordinateur u where u.idMateriel=:x")
	Ordinateur findById(@Param("x") int id);
}