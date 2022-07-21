package com.example.random_chat.model;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@ToString
@RequiredArgsConstructor
public class UserPool {
    private final Map<String, User> users = new HashMap<>();
    @ToString.Exclude
    private final PartnerSearcher<User> partnerSearcher;

    public boolean isEmpty() {
        return users.isEmpty();
    }

    public int size() {
        return users.size();
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    public Optional<Pair<User, User>> addUser(User user) {
        Optional<Pair<User, User>> pair = buildPairs(user);
        if (pair.isEmpty()) {
            users.put(user.getSessionId(), user);
        }
        return pair;
    }

    private Optional<Pair<User, User>> buildPairs(User user) {
        Optional<User> partner = partnerSearcher.search(users.values(), user);
        if (partner.isPresent()) {
            users.remove(partner.get().getSessionId());
            return Optional.of(Pair.of(user, partner.get()));
        }
        return Optional.empty();
    }
}
