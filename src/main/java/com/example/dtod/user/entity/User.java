package com.example.dtod.user.entity;


import com.example.dtod.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Post> posts = new ArrayList<>();

    @Builder
    public User(String userId, String password, String nickname, String category) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.category = category;
    }

    public void update(String userId, String password, String nickname,String category, String profileImg) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.category = category;
        this.profileImg = profileImg;
    }

}
