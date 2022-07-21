package com.example.random_chat.model;

import java.util.Collection;

public interface Chat {

    Collection<User> getUsers();

    String getUUID();
}
