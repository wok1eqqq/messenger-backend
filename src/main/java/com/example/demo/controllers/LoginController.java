package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> login(@RequestBody String body, HttpSession session) {

        JacksonJsonParser parser = new JacksonJsonParser();
        String author = (String) parser.parseMap(body).get("author");

        List<User> users = userRepository.findByUserName(author);

        if (users.isEmpty()) {
            return Map.of("redirect", "/login");
        }

        session.setAttribute("author", users.getFirst());

        return Map.of("redirect", "/message-get");
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}