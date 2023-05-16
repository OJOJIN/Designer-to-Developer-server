package com.example.dtod.post.service;


import com.example.dtod.exception.BusinessException;
import com.example.dtod.fileUpload.S3Service;
import com.example.dtod.post.dto.request.PostCreateRequestDto;
import com.example.dtod.post.dto.request.PostCreateResponseDto;
import com.example.dtod.post.dto.response.PostSearchResponseDto;
import com.example.dtod.post.entity.Post;
import com.example.dtod.post.repository.PostRepository;
import com.example.dtod.response.ErrorMessage;
import com.example.dtod.user.entity.User;
import com.example.dtod.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final S3Service s3Uploader;

    public PostCreateResponseDto create (PostCreateRequestDto postCreateRequestDto,
                                         MultipartFile file) throws IOException {

        String imgUrl = s3Uploader.upload(file);

        User user = userRepository.getReferenceById(postCreateRequestDto.getUserId());

        Post post = Post.builder()
                .title(postCreateRequestDto.getTitle())
                .contents(postCreateRequestDto.getContents())
                .category(postCreateRequestDto.getCategory())
                .user(user)
                .image(imgUrl)
                .build();

        postRepository.save(post);

        return new PostCreateResponseDto(post.getId());
    }

    public Page<PostSearchResponseDto> searchAll (Pageable pageable) {
        Page<Post> posts = postRepository.findAllBy(pageable);
        if(posts.isEmpty())
            throw new BusinessException(ErrorMessage.POST_NOT_FOUND);
        return posts.map(PostSearchResponseDto::new);
    }

}
