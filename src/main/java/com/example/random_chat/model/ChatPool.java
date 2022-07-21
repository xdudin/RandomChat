package com.example.random_chat.model;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class ChatPool {

    private final Map<String, Chat> chats = new HashMap<>();

    public void addChat(Chat chat) {
        chats.put(chat.getUUID(), chat);
    }

    public Chat getByUUID(String uuid) {
        return chats.get(uuid);
    }

    public void remove(String uuid) {
        chats.remove(uuid);
    }

    public int size() {
        return chats.size();
    }
}
