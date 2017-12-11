package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.informatique.dao.MarqueRepository;
import com.support.informatique.entities.Marque;


@Component
public class MarqueMetierImpl  {

	@Autowired
	private MarqueRepository MarqueRepository;

	public <S extends Marque> S save(S entity) {
		return MarqueRepository.save(entity);
	}

	public Marque findOne(Integer id) {
		return MarqueRepository.findOne(id);
	}

	public Iterable<Marque> findAll() {
		return MarqueRepository.findAll();
	}

	public void delete(Integer id) {
		MarqueRepository.delete(id);
	}

	public void deletebyId(Integer id) {
		MarqueRepository.deletebyId(id);
	}

	public void delete(Marque entity) {
		MarqueRepository.delete(entity);
	}
	
}
