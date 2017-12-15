package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.FichierRepository;
import com.support.informatique.entities.Fichier;


@Service
public class FichierMetierImpl implements FichierService {

	@Autowired
	private FichierRepository FichierRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#save(S)
	 */
	@Override
	public <S extends Fichier> S save(S entity) {
		return FichierRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#save(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#save(java.lang.Iterable)
	 */
	@Override
	public <S extends Fichier> Iterable<S> save(Iterable<S> entities) {
		return FichierRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#findOne(java.lang.Integer)
	 */
	@Override
	public Fichier findOne(Integer id) {
		return FichierRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#exists(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#exists(java.lang.Integer)
	 */
	@Override
	public boolean exists(Integer id) {
		return FichierRepository.exists(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#findAll()
	 */
	@Override
	public Iterable<Fichier> findAll() {
		return FichierRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#findAll(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#findAll(java.lang.Iterable)
	 */
	@Override
	public Iterable<Fichier> findAll(Iterable<Integer> ids) {
		return FichierRepository.findAll(ids);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#count()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#count()
	 */
	@Override
	public long count() {
		return FichierRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#delete(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		FichierRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#delete(com.support.informatique.entities.Fichier)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#delete(com.support.informatique.entities.Fichier)
	 */
	@Override
	public void delete(Fichier entity) {
		FichierRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#delete(java.lang.Iterable)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<? extends Fichier> entities) {
		FichierRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#deleteAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#deleteAll()
	 */
	@Override
	public void deleteAll() {
		FichierRepository.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#deletebyId(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.FichierService#deletebyId(java.lang.Integer)
	 */
	@Override
	public void deletebyId(Integer id) {
		FichierRepository.deletebyId(id);
	}


}
