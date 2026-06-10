package com.example.demo.models;

import java.util.List;

import org.thymeleaf.expression.Messages;

import jakarta.persistence.*;
import lombok.ToString;

@ToString
@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "name")
    public String name;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "chats_to_users", 
    inverseJoinColumns = @JoinColumn(name = "user_id", table = "user", columnDefinition="varchar(255)"), 
    joinColumns =   @JoinColumn(name = "chat_id", table="chats"))
    List<User> users;

    @ToString.Exclude
    @OneToMany(mappedBy = "chat")
    public List<Message> messages;
}
