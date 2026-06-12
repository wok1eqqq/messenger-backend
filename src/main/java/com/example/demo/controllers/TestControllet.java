package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.dto.Greeting;
import com.example.demo.dto.HelloMessage;
import com.example.demo.repositories.MessageRepository;
import com.example.demo.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class TestControllet {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/rest")
    public String test(HttpSession x) {
        return "testStomp";
    }

    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("Hello");
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        System.out.println("Hello");
        Greeting greeting = new Greeting("Hello, " + HtmlUtils.htmlEscape("message.getName()") + "!");
        messagingTemplate.convertAndSend(
                "/topic/greetings",
                greeting
        );
    }

}
