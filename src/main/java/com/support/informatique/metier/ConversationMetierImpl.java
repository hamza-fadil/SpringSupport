package com.support.informatique.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.support.informatique.dao.ConversationRepository;
import com.support.informatique.entities.Conversation;


@Component
public class ConversationMetierImpl  {

	@Autowired
	private ConversationRepository ConversationRepository;

	public <S extends Conversation> S save(S entity) {
		return ConversationRepository.save(entity);
	}

	public Conversation findOne(Integer id) {
		return ConversationRepository.findOne(id);
	}

	public Iterable<Conversation> findAll() {
		return ConversationRepository.findAll();
	}

	public void deletebyId(Integer id) {
		ConversationRepository.deletebyId(id);
	}

	public void delete(Integer id) {
		ConversationRepository.delete(id);
	}

	public void delete(Conversation entity) {
		ConversationRepository.delete(entity);
	}
	
}
