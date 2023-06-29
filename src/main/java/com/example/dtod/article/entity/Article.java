package com.example.dtod.article.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String keyWord;

    @Column(nullable = false, length = 500)
    private String summary;

    @Column(nullable = false)
    private String url;

    @Builder
    public Article(String companyName, String title, String keyWord, String summary, String url){
        this.companyName = companyName;
        this.title = title;
        this.keyWord = keyWord;
        this.summary = summary;
        this.url = url;
    }


}
