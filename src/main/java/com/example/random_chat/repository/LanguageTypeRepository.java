package com.example.random_chat.repository;

import com.example.random_chat.entity.LanguageTypeEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface LanguageTypeRepository extends CrudRepository<LanguageTypeEntity, Short> {

    @Override
    @Query("select * from messenger_db.language order by id")
    Iterable<LanguageTypeEntity> findAll();
}
