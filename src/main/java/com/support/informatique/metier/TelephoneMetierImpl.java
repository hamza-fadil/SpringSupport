package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.TelephoneRepository;
import com.support.informatique.entities.Telephone;



@Service
public class TelephoneMetierImpl implements TelephoneService  {

	@Autowired
	private TelephoneRepository TelephoneRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findById(int)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findById(int)
	 */
	@Override
	public Telephone findById(int id) {
		return TelephoneRepository.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#save(S)
	 */
	@Override
	public <S extends Telephone> S save(S entity) {
		return TelephoneRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#save(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#save(java.lang.Iterable)
	 */
	@Override
	public <S extends Telephone> Iterable<S> save(Iterable<S> entities) {
		return TelephoneRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findOne(java.lang.Integer)
	 */
	@Override
	public Telephone findOne(Integer id) {
		return TelephoneRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#exists(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#exists(java.lang.Integer)
	 */
	@Override
	public boolean exists(Integer id) {
		return TelephoneRepository.exists(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findAll()
	 */
	@Override
	public Iterable<Telephone> findAll() {
		return TelephoneRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findAll(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#findAll(java.lang.Iterable)
	 */
	@Override
	public Iterable<Telephone> findAll(Iterable<Integer> ids) {
		return TelephoneRepository.findAll(ids);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#count()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#count()
	 */
	@Override
	public long count() {
		return TelephoneRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#delete(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		TelephoneRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#delete(com.support.informatique.entities.Telephone)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#delete(com.support.informatique.entities.Telephone)
	 */
	@Override
	public void delete(Telephone entity) {
		TelephoneRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#delete(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<? extends Telephone> entities) {
		TelephoneRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#deleteAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TelephoneService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		TelephoneRepository.deleteAll();
	}

}
