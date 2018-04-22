package com.whx.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.whx.dao.ArticleDao;
import com.whx.entities.Article;
import com.whx.entities.Law;

@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao{
	/***** 注入 *****/
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public void save(Article article) {
		// TODO Auto-generated method stub
		
	}

	public boolean delete(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int articleId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Article article) {
		// TODO Auto-generated method stub
		return false;
	}

	public Article findById(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Article> findByLaw(Law law) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Article> findByLawArticle(Law law, String articleNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Article findByLawArticleBranch(Law law, String articleNo, String branchNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean exists(int articleId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean exists(Law law, String articleNo, String branchNo) {
		// TODO Auto-generated method stub
		return false;
	}

}
