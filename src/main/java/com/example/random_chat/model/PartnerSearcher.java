package com.example.random_chat.model;

import java.util.Collection;
import java.util.Optional;

public interface PartnerSearcher<T> {

    Optional<T> search(Collection<T> objects, T candidate);
}
