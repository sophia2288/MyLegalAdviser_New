package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	
	public ArticleDaoImpl() {
		System.out.println("ArticleDaoImpl");
	}

	public void save(Article article) {
		sessionFactory.getCurrentSession().saveOrUpdate(article);
	}

	public boolean delete(Article article) {
		//sessionFactory.getCurrentSession().delete(article);
		String hql = "delete Article a where a.articleId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, article.getArticleId());
		return (query.executeUpdate() > 0);
	}

	public boolean delete(int articleId) {
		String hql = "delete Article a where a.articleId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, articleId);
		return (query.executeUpdate() > 0);
	}

	public boolean update(Article article) {
		String hql = "update Article a set a.law=?,a.piece=?,a.chapter=?,a.section=?,a.articleNo=?,a.branchNo=?,a.content=?,a.gist=?where a.articleId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setEntity(0, article.getLaw());
		query.setString(1, article.getPiece());
		query.setString(2, article.getChapter());
		query.setString(3, article.getSection());
		query.setString(4, article.getArticleNo());
		query.setString(5, article.getBranchNo());
		query.setString(6, article.getContent());
		query.setString(7, article.getGist());
		query.setLong(8, article.getArticleId());

		return (query.executeUpdate() > 0);
	}

	public Article findById(int articleId) {
		return (Article) sessionFactory.getCurrentSession().get(Article.class, articleId);
	}

	@SuppressWarnings("unchecked")
	public List<Article> findByLaw(Law law) {
		List<Article> articleList = new ArrayList<Article>();
		String hql = "from Article a where a.law = :law";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setEntity("law", law);
		articleList = query.list();
		return articleList;
	}

	@SuppressWarnings("unchecked")
	public List<Article> findByLawArticle(Law law, String articleNo) {
		List<Article> articleList = new ArrayList<Article>();
		String hql = "from Article a where a.law = :law and a.articleNo = :articleNo";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("law", law);
		query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("articleNo", articleNo);
		articleList = query.list();
		return articleList;
	}

	@SuppressWarnings("unchecked")
	public Article findByLawArticleBranch(Law law, String articleNo, String branchNo) {
		List<Article> articleList = new ArrayList<Article>();
		String hql = "from Article a where a.law = :law and a.articleNo = :articleNo and a.branchNo = :branchNo";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("law", law);
		query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("articleNo", articleNo);
		query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("branchNo", branchNo);
		articleList = query.list();
		
		if(articleList.size()>0)
			return articleList.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(int articleId) {
		List<Article> articleList = new ArrayList<Article>();
		String hql = "from Article a where a.articleId = :articleId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("articleId", articleId);
		articleList = query.list();
		
		return articleList.size() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(Law law, String articleNo, String branchNo) {
		List<Article> articleList = new ArrayList<Article>();
		String hql = "from Article a where a.law = :law and a.articleNo = :articleNo and a.branchNo = :branchNo";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("law", law);
		query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("articleNo", articleNo);
		query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("branchNo", branchNo);
		articleList = query.list();
		
		return articleList.size() > 0 ? true : false;
	}

}
