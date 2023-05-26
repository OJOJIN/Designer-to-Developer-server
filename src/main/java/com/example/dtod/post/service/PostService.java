package com.example.dtod.post.service;


import com.example.dtod.exception.BusinessException;
import com.example.dtod.fileUpload.S3Service;
import com.example.dtod.post.dto.request.PostCreateRequestDto;
import com.example.dtod.post.dto.request.PostCreateResponseDto;
import com.example.dtod.post.dto.request.PostUpdateRequestDto;
import com.example.dtod.post.dto.response.PostSearchResponseDto;
import com.example.dtod.post.dto.response.PostUpdateResponseDto;
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
import java.util.Optional;



@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final S3Service s3Uploader;

    // 게시물 업로드
    public PostCreateResponseDto create (PostCreateRequestDto postCreateRequestDto,
                                         MultipartFile file) throws IOException {
        log.info(postCreateRequestDto.getTitle(), postCreateRequestDto.getContent(), postCreateRequestDto.getCategory(), postCreateRequestDto.getUserId());
        log.info(String.valueOf(file));

        String imgUrl = s3Uploader.upload(file);

        User user = userRepository.getReferenceById(postCreateRequestDto.getUserId());
        if(user == null){
            throw new BusinessException(ErrorMessage.USER_NOT_FOUND);
        }
        Post post = Post.builder()
                .title(postCreateRequestDto.getTitle())
                .content(postCreateRequestDto.getContent())
                .category(postCreateRequestDto.getCategory())
                .user(user)
                .image(imgUrl)
                .build();

        postRepository.save(post);

        return new PostCreateResponseDto(post.getId());
    }

    public PostSearchResponseDto findById(Long id){
        if(!postRepository.existsById(id))
            throw new BusinessException(ErrorMessage.POST_NOT_FOUND);

        Post post = postRepository.findById(id).get();

        return  new PostSearchResponseDto(
                post.getId(),
                post.getUser().getId(),
                post.getUser().getNickname(),
                post.getUser().getProfileImg(),
                post.getUser().getCategory(),
                post.getTitle(),
                post.getContent(),
                post.getCategory(),
                post.getImage(),
                post.getCreatedDate()
        );
    }

    // 게시물 전체 검색
    public Page<PostSearchResponseDto> findAll(Pageable pageable) {
        Page<Post> posts = postRepository.findAllByUserNotNullOrderByCreatedDateDesc(pageable);
        if(posts.isEmpty())
            throw new BusinessException(ErrorMessage.POST_NOT_FOUND);
        return posts.map(PostSearchResponseDto::new);
    }

    
    // 게시물 수정
    public PostUpdateResponseDto update(PostUpdateRequestDto postUpdateRequestDto,
                                        MultipartFile file) throws IOException {

        Post post = postRepository.findById(postUpdateRequestDto.getId()).get();

        String imgUrl = s3Uploader.upload(file);

        post.update(postUpdateRequestDto.getTitle(), post.getContent(), postUpdateRequestDto.getCategory(), imgUrl);

        return new PostUpdateResponseDto(post.getId());
    }


    // 게시물 삭제
    public Boolean delete (Long id) {
        if(!postRepository.existsById(id))
            throw new BusinessException(ErrorMessage.POST_NOT_FOUND);

        Post post = postRepository.findById(id).get();
        postRepository.delete(post);

        return true;
    }

    // 카테고리로 게시물 가져오기
    public Page<PostSearchResponseDto> findByCategory(String category, Pageable pageable) {
        Page<Post> posts = postRepository.findAllByCategoryOrderByCreatedDateDesc(category, pageable);
        if(posts.isEmpty())
            throw new BusinessException(ErrorMessage.POST_NOT_FOUND);
        return posts.map(PostSearchResponseDto::new);
    }

    // 제목 게시물 가져오기
    public Page<PostSearchResponseDto> findByTitle(String title, Pageable pageable) {
        Page<Post> posts = postRepository.findAllByTitleContainingOrderByCreatedDateDesc(title, pageable);
        if(posts.isEmpty())
            throw new BusinessException(ErrorMessage.POST_NOT_FOUND);
        return posts.map(PostSearchResponseDto::new);
    }
}
