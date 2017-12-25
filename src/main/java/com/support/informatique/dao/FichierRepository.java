package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.support.informatique.entities.Fichier;



@Repository
public interface FichierRepository extends CrudRepository<Fichier, Integer> {
	@Query("Select u from Fichier u where u.id=:x")
	Fichier findById(@Param("x") int id);
	@Transactional
	@Modifying
	@Query("Delete Fichier u where u.idFichier=:x")
	void deletebyId(@Param("x") Integer id);
	@Query("Select u.fichierJoint from Fichier u where u.idFichier=:x")
	byte[] findFichier(@Param("x")int idFichier);
}
