package com.example.dtod.post.dto.response;

import com.example.dtod.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchResponseDto {

    private Long id;

    private Long user_id;

    private String user_nickname;

    private String user_profileImg;

    private String user_category;

    private String title;

    private String content;

    private String category;

    private String postImg;

    private LocalDateTime created_date;

    public PostSearchResponseDto(Post post) {
        this.id = post.getId();
        this.user_id = post.getUser().getId();
        this.user_nickname = post.getUser().getNickname();
        this.user_profileImg = post.getUser().getProfileImg();
        this.user_category = post.getUser().getCategory();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.category = post.getCategory();
        this.created_date = post.getCreatedDate();
        this.postImg = post.getImage();
    }

}
