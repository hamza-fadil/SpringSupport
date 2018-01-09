package com.support.informatique.service;

import java.util.List;

import com.support.informatique.entities.Ticket;
import com.support.informatique.entities.User;

public interface TicketService {

	<S extends Ticket> S save(S entity);

	Ticket findOne(Integer id);

	boolean exists(Integer id);

	Iterable<Ticket> findAll();

	long count();

	void delete(Ticket entity);

	List<Ticket> findByuserId(User user);

	Ticket findById(Integer id);

	void deletebyId(Integer id);

	Ticket findByUser(User user);
}