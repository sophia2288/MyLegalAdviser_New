package com.whx.dao;

import java.util.List;

import com.whx.entities.Article;
import com.whx.entities.Law;

public interface ArticleDao {

	public void save(Article article);

	public boolean delete(Article article);

	public boolean delete(int articleId);

	public boolean update(Article article);

	public Article findById(int articleId);
	
	public List<Article> findByLaw(Law law);
	
	public List<Article> findByLawArticle(Law law,String articleNo);
	
	public Article findByLawArticleBranch(Law law,String articleNo,String branchNo);
	
	public boolean exists(int articleId);// 检测指定编号的法律条（款）是否存在
	
	public boolean exists(Law law,String articleNo,String branchNo);// 检测指定的法律条（款）是否存在
}
