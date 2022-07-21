package com.example.random_chat.model;

import lombok.Value;

@Value
public class ResponseMessage {

    String chatUUID;
    String senderUUID;
    Integer eventCode;
    String serviceContent;

    String content;
}
