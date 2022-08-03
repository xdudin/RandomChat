package com.example.random_chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chat")
public class ChatEntity {

    @Id
    private Long id;

    @Column("type_id")
    private Short typeId;

    @MappedCollection(idColumn = "chat_id")
    private Set<UserEntityRef> users = new HashSet<>();

    public void addParticipant(UserEntity user) {
        users.add(new UserEntityRef(user.getId()));
    }

    public void addAllParticipants(Collection<UserEntity> users) {
        users.forEach(userEntity -> this.users.add(new UserEntityRef(userEntity.getId())));
    }
}
