package com.example.random_chat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class StompListener {

    private final Logger log = LoggerFactory.getLogger(StompListener.class);

    @EventListener
    public void onSessionConnectEvent (SessionConnectEvent event) {
        StompHeaderAccessor headers = StompHeaderAccessor.wrap(event.getMessage());
        log.debug("User connected: {}", headers.getSessionId());
    }

    @EventListener
    public void onSessionDisconnectEvent(SessionDisconnectEvent event) {
        log.debug("User disconnected: {}", event.getSessionId());
    }
}
