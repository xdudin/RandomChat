package com.example.random_chat.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Table(name = "dialog")
@JsonIgnoreProperties({"id", "new"})
public class ChatDao implements Persistable<UUID> {

    @Id
    private UUID uuid;

    @Column("type_id")
    private Short typeId;

    @MappedCollection(idColumn = "dialog_uuid")
    private Set<UserDaoRef> users = new HashSet<>();

    public void addParticipant(UserDao user) {
        users.add(new UserDaoRef(user.getUuid()));
    }

    public void addAllParticipants(Collection<UserDao> users) {
        users.forEach(userDao -> this.users.add(new UserDaoRef(userDao.getUuid())));
    }

    @Override
    public UUID getId() {
        return uuid;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
