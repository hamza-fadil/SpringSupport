package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.support.informatique.entities.Fichier;
import com.support.informatique.entities.Reparation;



@Component
public interface FichierRepository extends CrudRepository<Fichier, Integer> {
	@Query("Select u from Fichier u where u.id=:x")
	Reparation findById(@Param("x") int id);
	@Transactional
	@Modifying
	@Query("Delete Fichier u where u.idFichier=:x")
	void deletebyId(@Param("x") Integer id);
}
