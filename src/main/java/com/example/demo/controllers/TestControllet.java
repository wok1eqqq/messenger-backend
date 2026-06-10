package com.example.demo.controllers;

import java.util.LinkedList;
import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.dto.Greeting;
import com.example.demo.dto.HelloMessage;
import com.example.demo.dto.MessageDto;
import com.example.demo.models.Message;
import com.example.demo.models.User;
import com.example.demo.repositories.MessageRepository;
import com.example.demo.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class TestControllet {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @GetMapping("/rest")
    public String test(HttpSession x) {

        return "testStomp";
    }

}
