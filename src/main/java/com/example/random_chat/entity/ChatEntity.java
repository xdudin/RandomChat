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

    public void addParticipantById(Long userId) {
        users.add(new UserEntityRef(userId));
    }

    public void addAllParticipantsByIds(Collection<Long> usersIds) {
        usersIds.forEach(id -> this.users.add(new UserEntityRef(id)));
    }
}
