package com.example.random_chat.model;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class ChatPool {

    private final Map<Long, Chat> chats = new HashMap<>();

    public void addChat(Chat chat) {
        chats.put(chat.getId(), chat);
    }

    public Chat getById(Long id) {
        return chats.get(id);
    }

    public void remove(Long id) {
        chats.remove(id);
    }

    public int size() {
        return chats.size();
    }
}
