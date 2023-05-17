package com.example.dtod.post.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostUpdateRequestDto {

    private Long id;

    private String title;

    private String content;

    private String category;
}
