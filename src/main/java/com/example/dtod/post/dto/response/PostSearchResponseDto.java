package com.example.dtod.post.dto.response;

import com.example.dtod.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchResponseDto {



    private Long post_id;

    private Long user_id;

    private String user_nickname;

    private String user_profile_img;

    private String user_category;

    private String title;

    private String contents;

    private String category;

//    private String post_img;

    private LocalDateTime created_date;

    public PostSearchResponseDto(Post post) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.user_nickname = user_nickname;
        this.user_profile_img = user_profile_img;
        this.user_category = user_category;
        this.title = title;
        this.contents = contents;
        this.category = category;
        this.created_date = created_date;
    }

}
