package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.support.informatique.entities.Panne;
import com.support.informatique.entities.Reparation;



@Repository
public interface PanneRepository extends CrudRepository<Panne, Integer> {
	@Query("Select u from Panne u where u.id=:x")
	Reparation findById(@Param("x") int id);
	
	@Transactional
	@Modifying
	@Query("Delete Panne u where u.idPanne=:x")
	void deletebyId(@Param("x") Integer id);
}
