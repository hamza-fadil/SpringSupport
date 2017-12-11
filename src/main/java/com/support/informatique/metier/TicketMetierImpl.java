package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.support.informatique.dao.TicketRepository;
import com.support.informatique.entities.Ticket;
import com.support.informatique.entities.User;

@Component
public class TicketMetierImpl {

	@Autowired
	private TicketRepository TicketRepository;

	public <S extends Ticket> S save(S entity) {
		return TicketRepository.save(entity);
	}

	public Ticket findOne(Integer id) {
		return TicketRepository.findOne(id);
	}

	public boolean exists(Integer id) {
		return TicketRepository.exists(id);
	}

	public Iterable<Ticket> findAll() {
		return TicketRepository.findAll();
	}

	public long count() {
		return TicketRepository.count();
	}

	public void delete(Ticket entity) {
		TicketRepository.delete(entity);
	}

	public Ticket findByuserId(User user) {
		return TicketRepository.findByuserId(user);
	}

	public Ticket findById(Integer id) {
		return TicketRepository.findById(id);
	}

	public void deletebyId(Integer id) {
		TicketRepository.deletebyId(id);
	}




}
