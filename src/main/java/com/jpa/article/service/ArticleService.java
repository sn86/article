package com.jpa.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.article.dao.IArticleDAO;
import com.jpa.article.entity.Article;
@Service
public class ArticleService implements IArticleService {

	@Autowired
	IArticleDAO articleDao;
	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return articleDao.getAllArticles();
	}

	@Override
	public Article getArticleById(int articleId) {
		// TODO Auto-generated method stub
		return articleDao.getArticleById(articleId);
	}

	@Override
	public synchronized boolean addArticle(Article article) {
		// TODO Auto-generated method stub
		if(articleDao.articleExists(article.getTitle(), article.getCategory())) 
			return false;
		else{
		articleDao.addArticle(article);
		return true;
		}
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		articleDao.updateArticle(article);
	}

	@Override
	public void deleteArticle(int articleId) {
		// TODO Auto-generated method stub
		articleDao.deleteArticle(articleId);
	}

	

}
