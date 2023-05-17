package com.example.dtod.post.repository;

import com.example.dtod.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);

    Page<Post> findAllByCategoryOrderByCreatedDateDesc(String category, Pageable pageable);

    Page<Post> findAllByTitleContainingOrderByCreatedDateDesc(String title, Pageable pageable);

    //    findAllByCategoryAndTitleLikeOrderByCreatedDateDesc


}

