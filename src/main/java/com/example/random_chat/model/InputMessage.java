package com.example.random_chat.model;

import lombok.Value;

@Value
public class InputMessage {

    String chatUUID;
    String senderUUID;
    String content;
}
