package com.support.informatique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.TicketRepository;
import com.support.informatique.entities.Ticket;
import com.support.informatique.entities.User;

@Service
public class TicketMetierImpl implements TicketService {

	@Autowired
	private TicketRepository TicketRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#save(S)
	 */
	@Override
	public <S extends Ticket> S save(S entity) {
		return TicketRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findOne(java.lang.Integer)
	 */
	@Override
	public Ticket findOne(Integer id) {
		return TicketRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#exists(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#exists(java.lang.Integer)
	 */
	@Override
	public boolean exists(Integer id) {
		return TicketRepository.exists(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findAll()
	 */
	@Override
	public Iterable<Ticket> findAll() {
		return TicketRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#count()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#count()
	 */
	@Override
	public long count() {
		return TicketRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#delete(com.support.informatique.entities.Ticket)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#delete(com.support.informatique.entities.Ticket)
	 */
	@Override
	public void delete(Ticket entity) {
		TicketRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findByuserId(com.support.informatique.entities.User)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findByuserId(com.support.informatique.entities.User)
	 */


	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findById(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findById(java.lang.Integer)
	 */
	@Override
	public Ticket findById(Integer id) {
		return TicketRepository.findById(id);
	}

	@Override
	public List<Ticket> findByuserId(User integer) {
		return TicketRepository.findByuserId(integer);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#deletebyId(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#deletebyId(java.lang.Integer)
	 */
	@Override
	public void deletebyId(Integer id) {
		TicketRepository.deletebyId(id);
	}

	@Override
	public Ticket findByUser(User username) {
		return TicketRepository.findByUser(username);
	}

	
}
