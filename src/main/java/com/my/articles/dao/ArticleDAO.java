package com.my.articles.dao;

import com.my.articles.CRUDInterface.CRUDInterface;
import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ArticleDAO implements CRUDInterface {
    @Autowired
    EntityManager em;

    @Override
    public List<Article> findAll() {
        return List.of();
    }

    @Override
    public int insert(Article article) {
        return 0;
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.ofNullable(em.find(Article.class, id));
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(Article article) {
        return 0;
    }
}
