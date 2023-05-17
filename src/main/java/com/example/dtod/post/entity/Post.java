package com.example.dtod.post.entity;

import com.example.dtod.entity.BaseTimeEntity;
import com.example.dtod.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String category;


    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Builder
    public Post(String title, String content, User user, String category, String image) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.category = category;
        this.image = image;
    }

    public void update(String title, String content, String category, String image) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.image = image;
    }
}
