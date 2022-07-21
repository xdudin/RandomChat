package com.example.random_chat.model;


import lombok.Builder;
import lombok.Value;


@Builder
@Value
public class UserAttributes {

    String gender;
    String age;
}
