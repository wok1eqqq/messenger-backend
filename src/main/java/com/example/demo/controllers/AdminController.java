package com.example.demo.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.dto.AdminMessage;
import com.example.demo.dto.Greeting;
import com.example.demo.dto.HelloMessage;


@Controller
public class AdminController {
    @GetMapping("/admin")
    public String getAdminPage() {

        return "adminPanel";
    }
    @MessageMapping("/all")
    @SendTo("/topic/greetings")
    public AdminMessage greeting(AdminMessage message) throws Exception {
      
        System.out.println(message.toString());
        System.out.println(message.getClass().getName());
        // return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        return(message);
    }

}
