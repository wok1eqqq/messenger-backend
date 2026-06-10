package com.example.demo.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.PostMessageBody;
import com.example.demo.models.Chat;
import com.example.demo.models.Message;
import com.example.demo.models.User;
import com.example.demo.repositories.ChatRepository;
import com.example.demo.repositories.MessageRepository;
import com.example.demo.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@RestController
public class PostMessages {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;

}