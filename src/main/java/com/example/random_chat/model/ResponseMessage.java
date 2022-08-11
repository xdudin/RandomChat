package com.example.random_chat.model;

import lombok.Value;

@Value
public class ResponseMessage {

    Long chatId;
    Long senderId;
    Integer eventCode;
    String serviceContent;

    String content;
}
