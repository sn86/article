package com.jpa.article.service;

import java.util.List;

import com.jpa.article.entity.Article;

public interface IArticleService {
	    List<Article> getAllArticles();
	    Article getArticleById(int articleId);
	    boolean addArticle(Article article);
	    void updateArticle(Article article);
	    void deleteArticle(int articleId);
}
