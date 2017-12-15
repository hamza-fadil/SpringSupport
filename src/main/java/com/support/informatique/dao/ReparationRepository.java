package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.support.informatique.entities.Reparation;




@Repository
public interface ReparationRepository extends CrudRepository<Reparation, Integer> {
	@Query("Select u from Reparation u where u.id=:x")
	Reparation findById(@Param("x") int id);
	@Transactional
	@Modifying
	@Query("Delete User u where u.idUser=:x")
	void deletebyId(@Param("x") Integer id);
}
