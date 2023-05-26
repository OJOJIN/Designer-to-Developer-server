package com.example.dtod.message.entity;

import com.example.dtod.post.entity.Post;
import com.example.dtod.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String requestUserId;

    @Column(nullable = false)
    private String responseUserId;

    @Builder
    public Message(String requestUserId, String responseUserId) {
        this.requestUserId = requestUserId;
        this.responseUserId = responseUserId;
    }

}
