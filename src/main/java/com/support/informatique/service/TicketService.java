package com.support.informatique.service;

import com.support.informatique.entities.Ticket;
import com.support.informatique.entities.User;

public interface TicketService {

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#save(S)
	 */
	<S extends Ticket> S save(S entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findOne(java.lang.Integer)
	 */
	Ticket findOne(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#exists(java.lang.Integer)
	 */
	boolean exists(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findAll()
	 */
	Iterable<Ticket> findAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#count()
	 */
	long count();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#delete(com.support.informatique.entities.Ticket)
	 */
	void delete(Ticket entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findByuserId(com.support.informatique.entities.User)
	 */
	Ticket findByuserId(User user);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#findById(java.lang.Integer)
	 */
	Ticket findById(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.TicketService#deletebyId(java.lang.Integer)
	 */
	void deletebyId(Integer id);

}