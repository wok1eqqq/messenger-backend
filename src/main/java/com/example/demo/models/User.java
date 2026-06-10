package com.example.demo.models;

import jakarta.persistence.Entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.ToString;

@ToString
@Entity
@Table(name = "user")
public class User {

    @Id
    
    @Column(name = "username")
    public String userName;

    @Column(name = "create_time")
    public LocalDateTime createdAt;

    @ToString.Exclude
    @OneToMany(mappedBy="user")
    public List<Message> messages;
    
    @ToString.Exclude
    @ManyToMany(mappedBy = "users")
    public List<Chat> chats;
}