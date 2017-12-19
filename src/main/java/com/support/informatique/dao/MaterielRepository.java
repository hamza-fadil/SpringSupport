package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.support.informatique.entities.Materiel;


@Repository
public interface MaterielRepository extends CrudRepository<Materiel, Integer> {
	@Transactional
	@Modifying
	@Query("Delete Materiel u where u.idMateriel=:x")
	void deletebyId(@Param("x") Integer id);
}
