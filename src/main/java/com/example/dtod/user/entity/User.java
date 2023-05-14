package com.example.dtod.user.entity;


import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(length = 15, nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String profileImg;

    @Builder
    public User(String userId, String password, String nickname, String category) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.category = category;
    }


}
