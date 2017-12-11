package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.informatique.dao.MaterielRepository;
import com.support.informatique.entities.Materiel;


@Component
public class MaterielMetierImpl  {

	@Autowired
	private MaterielRepository MaterielRepository;

	public <S extends Materiel> S save(S entity) {
		return MaterielRepository.save(entity);
	}

	public Materiel findOne(Integer id) {
		return MaterielRepository.findOne(id);
	}

	public Iterable<Materiel> findAll() {
		return MaterielRepository.findAll();
	}
	public void delete(Integer id) {
		MaterielRepository.delete(id);
	}

	public void delete(Materiel entity) {
		MaterielRepository.delete(entity);
	}

	public void deletebyId(Integer id) {
		MaterielRepository.deletebyId(id);
	}
	
}

