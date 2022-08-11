package com.example.random_chat.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Dialog extends Chat {

    private final List<User> users;

    public Dialog(List<User> users) {
        if (users.size() != 2) {
            throw new IllegalArgumentException("dialog may contain only 2 users");
        }
        this.users = new ArrayList<>(users);
    }

    @Override
    public Collection<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}
