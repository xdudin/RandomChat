package com.example.random_chat.service;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {

    private final Random random = new SecureRandom();

    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = "abcdefghijklmnopqrstuvwxyz";
    private static final String numbers = "0123456789";
    private static final String alphabet = upper + lower + numbers;

    public String genPassword() {
        return genPassword(16);
    }

    public String genPassword(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        return sb.toString();
    }
}
