package com.docta.ai.hermes.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.List;


@Entity
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private ZonedDateTime date;

    private Boolean isDeleted = false;

    // json字段，存储该Conversation的所有消息
    @Column(columnDefinition = "jsonb")
    @Convert(converter = MessageLineConverter.class)
    private List<MessageLine> messages;

    public Conversation() {
    }

    public Conversation(String title, ZonedDateTime date, List<MessageLine> messages, Boolean isDeleted) {
        this.title = title;
        this.date = date;
        this.messages = messages;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public List<MessageLine> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageLine> messages) {
        this.messages = messages;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
