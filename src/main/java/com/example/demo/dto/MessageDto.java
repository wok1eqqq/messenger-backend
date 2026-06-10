package com.example.demo.dto;

import com.example.demo.models.Message;
import lombok.ToString;

@ToString
public class MessageDto {
    public String author;
    public String message;
    public MessageDto(Message message) {
        this.author = message.user.userName;
        this.message = message.message;
    }
}