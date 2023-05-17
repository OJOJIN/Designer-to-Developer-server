package com.example.dtod.post.controller;


import com.example.dtod.post.dto.request.PostCreateRequestDto;
import com.example.dtod.post.dto.request.PostCreateResponseDto;
import com.example.dtod.post.dto.request.PostUpdateRequestDto;
import com.example.dtod.post.dto.response.PostSearchResponseDto;
import com.example.dtod.post.dto.response.PostUpdateResponseDto;
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

    // 포스트 제작
    @PostMapping("")
    public BaseResponseDto<PostCreateResponseDto> create (@RequestPart PostCreateRequestDto postCreateRequestDto,
                                                          @RequestPart MultipartFile file) throws IOException {
        PostCreateResponseDto response = postService.create(postCreateRequestDto, file);

        return new BaseResponseDto<>(response);
    }

    // 포스트 전체 가져오기
    @GetMapping("")
    public PageResponseDto<PostSearchResponseDto> findAll(Pageable pageable) {
        return new PageResponseDto<>(postService.findAll(pageable));
    }
    
    // 포스트 업데이트
    @PatchMapping("")
    public BaseResponseDto<PostUpdateResponseDto> update(@RequestPart PostUpdateRequestDto postUpdateRequestDto,
                                         @RequestPart MultipartFile file) throws IOException {
        return new BaseResponseDto<>(postService.update(postUpdateRequestDto, file));
    }

    @DeleteMapping("{id}")
    public BaseResponseDto<Boolean> delete(@PathVariable Long id){
        return new BaseResponseDto<>(postService.delete(id));
    }

    //포스트 카테고리로 가져오기
    @GetMapping("/category/{category}")
    public PageResponseDto<PostSearchResponseDto> findByCategory(@PathVariable String category, Pageable pageable) {
        return new PageResponseDto<>(postService.findByCategory(category, pageable));
    }


    // 포스트 제목으로 가져오기
    @GetMapping("/title/{title}")
    public PageResponseDto<PostSearchResponseDto> findByTitle(@PathVariable String title, Pageable pageable) {
        return new PageResponseDto<>(postService.findByTitle(title, pageable));
    }
}
