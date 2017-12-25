package com.support.informatique.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.informatique.dao.ConversationRepository;
import com.support.informatique.entities.Conversation;


@Service
public class ConversationMetierImpl implements ConversationService  {

	@Autowired
	private ConversationRepository ConversationRepository;

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationService#save(S)
	 */
	@Override
	public <S extends Conversation> S save(S entity) {
		return ConversationRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#findOne(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationService#findOne(java.lang.Integer)
	 */
	@Override
	public Conversation findOne(Integer id) {
		return ConversationRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationService#findAll()
	 */
	@Override
	public Iterable<Conversation> findAll() {
		return ConversationRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#deletebyId(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationService#deletebyId(java.lang.Integer)
	 */
	@Override
	public void deletebyId(Integer id) {
		ConversationRepository.deletebyId(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#delete(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationService#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		ConversationRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#delete(com.support.informatique.entities.Conversation)
	 */
	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationService#delete(com.support.informatique.entities.Conversation)
	 */
	@Override
	public void delete(Conversation entity) {
		ConversationRepository.delete(entity);
	}
	
}
