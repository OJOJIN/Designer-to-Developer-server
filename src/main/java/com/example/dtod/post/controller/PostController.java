package com.example.dtod.post.controller;


import com.example.dtod.post.dto.request.PostCreateRequestDto;
import com.example.dtod.post.dto.request.PostCreateResponseDto;
import com.example.dtod.post.service.PostService;
import com.example.dtod.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping("")
    public BaseResponseDto<PostCreateResponseDto> create (@RequestBody PostCreateRequestDto postCreateRequestDto) {
        PostCreateResponseDto response = postService.create(postCreateRequestDto);

        return new BaseResponseDto<>(response);
    }
}
