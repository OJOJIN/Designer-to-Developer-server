package com.example.dtod.article.dto;

import com.example.dtod.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleFindAllByCompanyNameResponseDto {
    private String companyName;

    private String title;

    private String keyWord;

    private String summary;

    private String url;

    public ArticleFindAllByCompanyNameResponseDto(Article article){
        this.companyName = article.getCompanyName();
        this.title = article.getTitle();
        this.keyWord = article.getKeyWord();
        this.summary = article.getSummary();
        this.url = article.getUrl();
    }
}
