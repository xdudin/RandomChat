package com.example.random_chat.repository;

import com.example.random_chat.entity.ChatTypeEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ChatTypeRepository extends CrudRepository<ChatTypeEntity, Short> {

    @Override
    @Query("select * from messenger_db.dialog_type order by id")
    Iterable<ChatTypeEntity> findAll();
}
