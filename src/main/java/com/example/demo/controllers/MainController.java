package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.MessageDto;
import com.example.demo.dto.PostMessageBody;
import com.example.demo.models.Chat;
import com.example.demo.models.Message;
import com.example.demo.models.User;
import com.example.demo.repositories.ChatRepository;
// import com.example.demo.repositories.ChatRepository;
import com.example.demo.repositories.MessageRepository;
import com.example.demo.repositories.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller

public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("/message-get")
    public String hello(HttpSession x, Model model) {

        String author;

        if (x.getAttribute("author") != null) {
            author = ((User) x.getAttribute("author")).userName;
            System.out.println("hello " + ((User) x.getAttribute("author")).userName);
        } else {
            return "login";
        }
        User user = userRepository.findByUserName(author).getFirst();
        // List<Message> messages = user.messages;

        // LinkedList<MessageDto> messageDtos = new LinkedList<MessageDto>();
        // for (int i = 0; i < messages.size(); i++) {
        // MessageDto messageDto = new MessageDto(messages.get(i));
        // messageDtos.add(messageDto);
        // }
        model.addAttribute("user", user);
        // model.addAttribute("messages", messageDtos);
        return "index";

    }

    @GetMapping("/message-get/{chatId}")
    public String getChat(@PathVariable int chatId, HttpSession x, Model model) {
        System.out.println(chatId);

        String author;

        if (x.getAttribute("author") != null) {
            author = ((User) x.getAttribute("author")).userName;
            System.out.println("hello " + ((User) x.getAttribute("author")).userName);
        } else {
            return "login";
        }
        User user = userRepository.findByUserName(author).getFirst();
        model.addAttribute("user", user);
        Chat chat = chatRepository.findById(chatId).get();
        if (chat == null) {
            return "index";
        }
        List<Message> messages = chat.messages;

        LinkedList<MessageDto> messageDtos = new LinkedList<MessageDto>();
        for (int i = 0; i < messages.size(); i++) {
            MessageDto messageDto = new MessageDto(messages.get(i));
            messageDtos.add(messageDto);
        }
        model.addAttribute("messages", messageDtos);
        model.addAttribute("chatName", chat.name);

        return "index";
    }

    @PostMapping("/message-get/{chatId}/send")
    @ResponseBody
    public MessageDto addNewMessage(@PathVariable int chatId,
            @RequestBody PostMessageBody backLog,
            HttpSession session) {

        String text = backLog.getMessage();

        if (text == null || text.trim().isEmpty()) {
            return null;
        }

        User author = (User) session.getAttribute("author");
        Chat chat = chatRepository.findById(chatId).get();

        Message m = new Message();
        m.user = author;
        m.chat = chat;
        m.createdAt = LocalDateTime.now();
        m.message = text.trim();

        messageRepository.save(m);

        return new MessageDto(m);
    }

}
