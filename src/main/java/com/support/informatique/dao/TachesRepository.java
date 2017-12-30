package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.support.informatique.entities.Taches;



@Repository
public interface TachesRepository extends CrudRepository<Taches, Integer> {

	@Transactional
	@Modifying
	@Query("Delete Taches u where u.idTaches=:x")
	void deletebyId(@Param("x") Integer id);
	

}
