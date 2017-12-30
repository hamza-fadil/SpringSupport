package com.support.informatique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.support.informatique.dao.TachesRepository;
import com.support.informatique.entities.Taches;

@Service
public class TachesMetierImpl implements TachesService {

	@Autowired
	private TachesRepository TachesRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#count()
	 */
	@Override
	public long count() {
		return TachesRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer arg0) {
		TachesRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<? extends Taches> arg0) {
		TachesRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#delete(com.support.informatique.entities.Taches)
	 */
	@Override
	public void delete(Taches arg0) {
		TachesRepository.delete(arg0);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		TachesRepository.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#deletebyId(java.lang.Integer)
	 */
	@Override
	public void deletebyId(Integer id) {
		TachesRepository.deletebyId(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#exists(java.lang.Integer)
	 */
	@Override
	public boolean exists(Integer arg0) {
		return TachesRepository.exists(arg0);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#findAll()
	 */
	@Override
	public Iterable<Taches> findAll() {
		return TachesRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#findAll(java.lang.Iterable)
	 */
	@Override
	public Iterable<Taches> findAll(Iterable<Integer> arg0) {
		return TachesRepository.findAll(arg0);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#findOne(java.lang.Integer)
	 */
	@Override
	public Taches findOne(Integer arg0) {
		return TachesRepository.findOne(arg0);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#save(java.lang.Iterable)
	 */
	@Override
	public <S extends Taches> Iterable<S> save(Iterable<S> arg0) {
		return TachesRepository.save(arg0);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.service.TachesService#save(S)
	 */
	@Override
	public <S extends Taches> S save(S arg0) {
		return TachesRepository.save(arg0);
	}



}
