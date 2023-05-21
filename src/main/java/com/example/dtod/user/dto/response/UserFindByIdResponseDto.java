package com.example.dtod.user.dto.response;


import com.example.dtod.post.entity.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserFindByIdResponseDto {
    private Long id;

    private String userId;

    private String password;

    private String nickname;

    private String category;

    private String profileImg;

    private List<Post> posts;
}
