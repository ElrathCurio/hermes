package com.docta.ai.hermes.controller;

import com.docta.ai.hermes.model.Conversation;
import com.docta.ai.hermes.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ConversationTestController {
    @Autowired
    private ConversationRepository conversationRepository;


    //create a new conversation
    @PostMapping("/conversation")
    public Conversation createConversation(@RequestBody Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    //get all conversations
    @GetMapping("/conversations")
    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

    //get a single conversation
    @GetMapping("/conversation/{id}")
    public Conversation getConversationById(@PathVariable(value = "id") Long conversationId) {
        return conversationRepository.findById(conversationId).orElseThrow(() -> new RuntimeException("Conversation not found with id " + conversationId));
    }

    //update a conversation
    @PutMapping("/conversation/{id}")
    public Conversation updateConversation(@PathVariable(value = "id") Long conversationId, @RequestBody Conversation conversationDetails) {
        Conversation conversation = conversationRepository.findById(conversationId).orElseThrow(() -> new RuntimeException("Conversation not found with id " + conversationId));
        conversation.setTitle(conversationDetails.getTitle());
        conversation.setDate(conversationDetails.getDate());
        conversation.setMessages(conversationDetails.getMessages());
        return conversationRepository.save(conversation);
    }

    //append a message to a conversation
    @PatchMapping("/conversation/{id}")
    public Conversation appendMessage(@PathVariable(value = "id") Long conversationId, @RequestBody Conversation conversationDetails) {
        Conversation conversation = conversationRepository.findById(conversationId).orElseThrow(() -> new RuntimeException("Conversation not found with id " + conversationId));
        conversation.getMessages().addAll(conversationDetails.getMessages());
        return conversationRepository.save(conversation);
    }

    //delete a conversation
    @DeleteMapping("/conversation/{id}")
    public void deleteConversation(@PathVariable(value = "id") Long conversationId) {
        Conversation conversation = conversationRepository.findById(conversationId).orElseThrow(() -> new RuntimeException("Conversation not found with id " + conversationId));
        conversation.setIsDeleted(true);
        conversationRepository.save(conversation);
    }


}
