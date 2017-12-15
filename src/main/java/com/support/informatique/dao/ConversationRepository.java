package com.support.informatique.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.support.informatique.entities.Conversation;



@Repository
public interface ConversationRepository extends CrudRepository<Conversation, Integer> {
	@Query("Select u from Conversation u where u.id=:x")
	Conversation findById(@Param("x") int id);
	@Transactional
	@Modifying
	@Query("Delete Conversation u where u.idConversation=:x")
	void deletebyId(@Param("x") Integer id);
}
