package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.informatique.dao.PanneRepository;
import com.support.informatique.entities.Panne;


@Component
public class PanneMetierImpl  {

	@Autowired
	private PanneRepository PanneRepository;

	public <S extends Panne> S save(S entity) {
		return PanneRepository.save(entity);
	}

	public Panne findOne(Integer id) {
		return PanneRepository.findOne(id);
	}

	public Iterable<Panne> findAll() {
		return PanneRepository.findAll();
	}

	public void delete(Integer id) {
		PanneRepository.delete(id);
	}

	public void delete(Panne entity) {
		PanneRepository.delete(entity);
	}

	public void deletebyId(Integer id) {
		PanneRepository.deletebyId(id);
	}
	
}
