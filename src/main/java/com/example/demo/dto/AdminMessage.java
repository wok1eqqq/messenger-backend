package com.example.demo.dto;

import lombok.ToString;

@ToString
public class AdminMessage {
    public String message;
    public AdminMessage(String message) {
        this.message = message;
    }
}
