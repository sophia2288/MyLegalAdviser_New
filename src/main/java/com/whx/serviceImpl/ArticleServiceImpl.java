package com.whx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whx.dao.ArticleDao;
import com.whx.entities.Article;
import com.whx.entities.Law;
import com.whx.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	private ArticleDao articleDao;
	
	public ArticleServiceImpl() {
		System.out.println("ArticleServiceImpl()");
	}

	public void addArticle(Article article) {
		if(!exists(article.getArticleId()))
			articleDao.save(article);
	}

	public void deleteArticle(Article article) {
		if(exists(article.getArticleId()))
			articleDao.delete(article);
	}

	public void deleteArticle(int articleId) {
		if(exists(articleId))
			articleDao.delete(articleId);
	}

	public void updateArticle(Article article) {
		if(exists(article.getArticleId()))
			articleDao.update(article);
	}

	public Article getArticleById(int articleId) {
		return articleDao.findById(articleId);
	}

	public List<Article> getArticlesByLaw(Law law) {
		return articleDao.findByLaw(law);
	}

	public List<Article> getArticlesByLawArticle(Law law, String articleNo) {
		return articleDao.findByLawArticle(law,articleNo);
	}

	public Article getArticleByLawArticleBranch(Law law, String articleNo, String branchNo) {
		return articleDao.findByLawArticleBranch(law, articleNo, branchNo);
	}

	public boolean exists(int articleId) {
		return articleDao.exists(articleId);
	}

	public boolean exists(Law law, String articleNo, String branchNo) {
		return articleDao.exists(law, articleNo, branchNo);
	}
	
}
