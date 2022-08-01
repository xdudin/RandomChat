package com.example.random_chat.repository;

import com.example.random_chat.entity.AgeTypeEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface AgeTypeRepository extends CrudRepository<AgeTypeEntity, Short> {

    @Override
    @Query("select * from messenger_db.age_group order by id")
    Iterable<AgeTypeEntity> findAll();
}
