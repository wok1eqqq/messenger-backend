package com.example.demo.models;

import java.security.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.ToString;

@ToString
@Entity
@Table(name = "messages")

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "message", length = 255, nullable = false)
    public String message;

    @Column(name = "time_send")
    public LocalDateTime createdAt;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, referencedColumnName = "username")
    public User user;
    
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_chat", nullable = false, referencedColumnName = "id")
    public Chat chat;


}