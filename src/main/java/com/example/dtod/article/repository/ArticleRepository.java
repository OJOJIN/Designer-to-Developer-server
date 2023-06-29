package com.example.dtod.article.repository;

import com.example.dtod.article.entity.Article;
import com.example.dtod.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllByCompanyName(String companyName);

}
