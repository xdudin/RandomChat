package com.example.random_chat.model;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StrictPartnerSearcher implements PartnerSearcher<User> {

    @Override
    public Optional<User> search(Collection<User> users, User candidate) {

        for (User user : users) {
            if (match(user, candidate) && match(candidate, user)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    @SuppressWarnings("RedundantIfStatement")
    private boolean match(User target, User user) {

        if (!user.getLanguageCode().equals(target.getLanguageCode())) {
            return false;
        }

        UserAttributes userAttributes = user.getUserAttributes();
        UserAttributes targetAttributes = target.getTargetAttributes();

        if (!(userAttributes.getGender() == null || targetAttributes.getGender() == null ||
                userAttributes.getGender().equals(targetAttributes.getGender()))) {
            return false;
        }
        if (!(userAttributes.getAge() == null || targetAttributes.getAge() == null ||
                userAttributes.getAge().equals(targetAttributes.getAge()))) {
            return false;
        }

        return true;
    }
}
