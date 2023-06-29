package com.example.dtod.article.controller;

import com.example.dtod.article.dto.ArticleFindAllByCompanyNameResponseDto;
import com.example.dtod.article.dto.ArticleRequestDto;
import com.example.dtod.article.dto.ArticleResponseDto;
import com.example.dtod.article.entity.Article;
import com.example.dtod.article.repository.ArticleRepository;
import com.example.dtod.company.dto.CompanyResponseDto;
import com.example.dtod.exception.BusinessException;
import com.example.dtod.response.BaseResponseDto;
import com.example.dtod.response.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.dtod.response.ErrorMessage.ALREADY_EXISTED_ARTICLE;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleRepository articleRepository;

    @PostMapping("")
    public BaseResponseDto<ArticleResponseDto> create(@RequestBody ArticleRequestDto articleRequestDto){
        Article article = Article.builder()
                .companyName(articleRequestDto.getCompanyName())
                .title(articleRequestDto.getTitle())
                .keyWord(articleRequestDto.getKeyWord())
                .summary(articleRequestDto.getSummary())
                .url(articleRequestDto.getUrl())
                .build();

        articleRepository.save(article);
        if(article.getId() == -1) return new BaseResponseDto(ALREADY_EXISTED_ARTICLE);
        else return new BaseResponseDto(new CompanyResponseDto(article.getId()));
    }

    @GetMapping("/{companyName}")
    public BaseResponseDto<Stream<ArticleFindAllByCompanyNameResponseDto>> findByCompanyName(@PathVariable String companyName){
        List<Article> articles = articleRepository.findAllByCompanyName(companyName);
        if(articles.isEmpty())
            throw new BusinessException(ErrorMessage.ARTICLE_NOT_FOUND);

        //articles.stream().map(ArticleFindAllByCompanyNameResponseDto::new);

        return new BaseResponseDto<>(articles.stream().map(ArticleFindAllByCompanyNameResponseDto::new));
    }

}
