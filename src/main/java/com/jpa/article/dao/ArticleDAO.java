package com.jpa.article.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.article.entity.Article;
@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return entityManager.createNamedQuery("getAllArticles", Article.class).getResultList();
	}

	@Override
	public Article getArticleById(int articleId) {
		return entityManager.find(Article.class, articleId);
	}

	@Override
	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		entityManager.persist(article);
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		 Article articleToUpdate = getArticleById(article.getArticleId());
		 
		 articleToUpdate.setTitle(article.getTitle());
		 articleToUpdate.setCategory(article.getCategory());
		 
		 entityManager.flush();
	}

	@Override
	public void deleteArticle(int articleId) {
		// TODO Auto-generated method stub
		   entityManager.remove(articleId);
	}

	@Override
	public boolean articleExists(String title, String category) {
		// TODO Auto-generated method stub
		if(entityManager.createNamedQuery("articleExists").setParameter("title",title).setParameter("category",category).getResultList().size()==0)
		return false;
		else
		return true;
	}

	

}
