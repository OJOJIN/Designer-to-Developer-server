package com.example.dtod.post.dto.request;

import lombok.Getter;

@Getter
public class PostCreateRequestDto {

    private Long userId;

    private String title;

    private String contents;

    private String category;

}
