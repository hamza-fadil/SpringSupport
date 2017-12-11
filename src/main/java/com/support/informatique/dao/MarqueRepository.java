package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.support.informatique.entities.Marque;
import com.support.informatique.entities.Reparation;



@Component
public interface MarqueRepository extends CrudRepository<Marque, Integer> {
	@Query("Select u from Marque u where u.id=:x")
	Reparation findById(@Param("x") int id);
	
	@Transactional
	@Modifying
	@Query("Delete Marque u where u.idMarque=:x")
	void deletebyId(@Param("x") Integer id);
}
