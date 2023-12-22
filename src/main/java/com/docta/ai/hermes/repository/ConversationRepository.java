package com.docta.ai.hermes.repository;

import com.docta.ai.hermes.model.Conversation;
import com.docta.ai.hermes.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long>{

}
