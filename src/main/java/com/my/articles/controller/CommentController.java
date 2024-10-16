package com.my.articles.controller;

import com.my.articles.dto.ArticleDTO;
import com.my.articles.entity.Article;
import com.my.articles.entity.Comment;
import com.my.articles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
    @Autowired
    ArticleService articleService;

    @PostMapping("articles/{id}")
    public String addcomment(@RequestParam Long id, @RequestParam String nickname, @RequestParam String body) {
        Comment comment = new Comment();
        comment.setNickname(nickname);
        comment.setBody(body);

        Article article = articleService.findByIdWithComments(id);
        comment.setArticle(article);
        article.getComments().add(comment);
        articleService.updateArticle(new ArticleDTO());
        return "redirect:/articles/" + id;
    }
}
