package com.jpa.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpa.article.entity.Article;
import com.jpa.article.service.IArticleService;

@Controller
@RequestMapping("user")
public class RestController {

	@Autowired
	IArticleService articleService;
	
	
	@PostMapping("article")
	public ResponseEntity<Void> addArticle (@RequestBody Article article) throws ArticleException
	{
		boolean flag =articleService.addArticle(article);
		if(!flag)
			 //return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			throw new ArticleException("Article Already Exists");
		else 
		articleService.addArticle(article);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("articles")
	public ResponseEntity<List<Article>> getAllArticles() {
		List<Article> list = articleService.getAllArticles();
		return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
	}
	@PutMapping("article")
	public ResponseEntity<Article> update(@RequestBody Article article){
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
}
