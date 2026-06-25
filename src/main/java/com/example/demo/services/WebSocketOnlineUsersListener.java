package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketOnlineUsersListener {
    private final List<String> onlineUsers = new ArrayList<String>();

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        System.out.println(event);
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        System.out.println("Disconnected");
    }

}
