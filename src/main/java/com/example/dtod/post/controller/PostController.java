package com.example.dtod.post.controller;


import com.example.dtod.post.dto.request.PostCreateRequestDto;
import com.example.dtod.post.dto.request.PostCreateResponseDto;
import com.example.dtod.post.dto.response.PostSearchResponseDto;
import com.example.dtod.post.service.PostService;
import com.example.dtod.response.BaseResponseDto;
import com.example.dtod.response.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping("")
    public BaseResponseDto<PostCreateResponseDto> create (@RequestPart PostCreateRequestDto postCreateRequestDto,
                                                          @RequestPart MultipartFile file) throws IOException {
        PostCreateResponseDto response = postService.create(postCreateRequestDto, file);

        return new BaseResponseDto<>(response);
    }

    @GetMapping("")
    public PageResponseDto<PostSearchResponseDto> searchAll (Pageable pageable) {
        return new PageResponseDto<>(postService.searchAll(pageable));
    }
}
