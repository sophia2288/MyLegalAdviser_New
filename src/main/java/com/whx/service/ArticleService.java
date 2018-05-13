package com.whx.service;

import java.util.List;

import com.whx.entities.Article;
import com.whx.entities.Law;

public interface ArticleService {

	public void addArticle(Article article);

	public void deleteArticle(Article article);

	public void deleteArticle(int articleId);

	public void updateArticle(Article article);

	public Article getArticleById(int articleId);

	public List<Article> getArticlesByLaw(Law law);

	public List<Article> getArticlesByLawArticle(Law law, String articleNo);

	public Article getArticleByLawArticleBranch(Law law, String articleNo, String branchNo);

	public boolean exists(int articleId);

	public boolean exists(Law law, String articleNo, String branchNo);

}
