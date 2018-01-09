package com.support.informatique.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.RapportRepository;
import com.support.informatique.entities.Rapport;

@Service
public class RapportMetierImpl implements RapportService {
@Autowired
private RapportRepository RapportRepository;

@Override
public long count() {
	return RapportRepository.count();
}

@Override
public void delete(Integer arg0) {
	RapportRepository.delete(arg0);
}

@Override
public void delete(Iterable<? extends Rapport> arg0) {
	RapportRepository.delete(arg0);
}

@Override
public void delete(Rapport arg0) {
	RapportRepository.delete(arg0);
}

@Override
public void deleteAll() {
	RapportRepository.deleteAll();
}

@Override
public boolean exists(Integer arg0) {
	return RapportRepository.exists(arg0);
}

@Override
public Iterable<Rapport> findAll() {
	return RapportRepository.findAll();
}

@Override
public Iterable<Rapport> findAll(Iterable<Integer> arg0) {
	return RapportRepository.findAll(arg0);
}

@Override
public Rapport findOne(Integer arg0) {
	return RapportRepository.findOne(arg0);
}

@Override
public <S extends Rapport> Iterable<S> save(Iterable<S> arg0) {
	return RapportRepository.save(arg0);
}

@Override
public <S extends Rapport> S save(S arg0) {
	return RapportRepository.save(arg0);
}

}
