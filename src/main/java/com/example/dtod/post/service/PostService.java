package com.example.dtod.post.service;


import com.example.dtod.post.dto.request.PostCreateRequestDto;
import com.example.dtod.post.dto.request.PostCreateResponseDto;
import com.example.dtod.post.entity.Post;
import com.example.dtod.post.repository.PostRepository;
import com.example.dtod.user.entity.User;
import com.example.dtod.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostCreateResponseDto create (PostCreateRequestDto postCreateRequestDto) {

        User user = userRepository.getReferenceById(postCreateRequestDto.getUserId());

        Post post = Post.builder()
                .title(postCreateRequestDto.getTitle())
                .contents(postCreateRequestDto.getContents())
                .user(user)
                .build();

        postRepository.save(post);

        return new PostCreateResponseDto(post.getId());
    }

}
