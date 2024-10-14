package com.my.articles.service;

import com.my.articles.dao.ArticleDAO;
import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private EntityManager em;

    private ArticleDAO articleDAO;

    public Article findById(Long id) {
        return em.find(Article.class, id);
    }

    public List<Article> findAll() {
        return em.createQuery("SELECT a FROM Article a", Article.class).getResultList();
    }

}
