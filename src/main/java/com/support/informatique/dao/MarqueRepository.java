package com.support.informatique.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.support.informatique.entities.Marque;



@Repository
public interface MarqueRepository extends CrudRepository<Marque, Integer> {
	@Query("Select u from Marque u where u.id=:x")
	Marque findById(@Param("x") int id);
	@Query("Select u.nomMarque from Marque u")
	List<Marque> findName();
	@Transactional
	@Modifying
	@Query("Delete Marque u where u.idMarque=:x")
	void deletebyId(@Param("x") Integer id);
}
