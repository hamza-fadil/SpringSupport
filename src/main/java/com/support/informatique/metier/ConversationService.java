package com.support.informatique.metier;

import com.support.informatique.entities.Conversation;

public interface ConversationService {

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#save(S)
	 */
	<S extends Conversation> S save(S entity);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#findOne(java.lang.Integer)
	 */
	Conversation findOne(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#findAll()
	 */
	Iterable<Conversation> findAll();

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#deletebyId(java.lang.Integer)
	 */
	void deletebyId(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#delete(java.lang.Integer)
	 */
	void delete(Integer id);

	/* (non-Javadoc)
	 * @see com.support.informatique.metier.ConversationInterface#delete(com.support.informatique.entities.Conversation)
	 */
	void delete(Conversation entity);

}