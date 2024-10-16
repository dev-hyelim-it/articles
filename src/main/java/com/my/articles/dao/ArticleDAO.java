package com.my.articles.dao;

import com.my.articles.dto.ArticleDTO;
import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class ArticleDAO {
    @Autowired
    EntityManager em;

    public Article findByIdWithComment(Long id) {
        String sql = "SELECT a FROM Article a LEFT JOIN FETCH a.comments WHERE a.id = :id";
        return em.createQuery(sql, Article.class).setParameter("id",id).getSingleResult();
    }

    public List<Article> getAllArticle() {
        String sql = "SELECT a FROM Article a " +
                "ORDER BY a.id DESC";
        List<Article> articles = em.createQuery(sql).getResultList();
        return articles;
    }

    public Article getOneArticle(Long id) {
        return em.find(Article.class, id);
    }

    public void deleteArticle(Long id) {
        Article article = em.find(Article.class, id);
        em.remove(article);
    }

    public void updateArticle(ArticleDTO dto) {
        Article article = em.find(Article.class, dto.getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
    }

    public void insertArticle(Article article) {
        em.persist(article);
    }
}







