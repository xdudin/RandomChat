package com.example.random_chat.repository;

import com.example.random_chat.entity.GenderTypeEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface GenderTypeRepository extends CrudRepository<GenderTypeEntity, Short> {

    @Override
    @Query("select * from messenger_db.gender order by id")
    Iterable<GenderTypeEntity> findAll();
}
