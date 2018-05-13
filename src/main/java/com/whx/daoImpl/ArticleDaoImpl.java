package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whx.dao.ArticleDao;
import com.whx.entities.Article;
import com.whx.entities.Law;

@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public ArticleDaoImpl() {
		System.out.println("ArticleDaoImpl()");
	}

	public void save(Article article) {
		hibernateTemplate.save(article);
	}

	public void delete(Article article) {
		hibernateTemplate.delete(article);
	}

	public void delete(int articleId) {
		hibernateTemplate.bulkUpdate("delete Article a where a.articleId = ?", new Object[] { articleId });
	}

	public void update(Article article) {
		hibernateTemplate.update(article);
	}

	public Article findById(int articleId) {
		return (Article) hibernateTemplate.get(Article.class, articleId);
	}

	@SuppressWarnings("unchecked")
	public List<Article> findByLaw(Law law) {
		List<Article> articleList = new ArrayList<Article>();
		String hql = "from Article a where a.law = :law";
		articleList = (List<Article>) hibernateTemplate.findByNamedParam(hql, "law", law);

		return articleList;
	}

	@SuppressWarnings("unchecked")
	public List<Article> findByLawArticle(Law law, String articleNo) {
		List<Article> articleList = new ArrayList<Article>();
		String hql = "from Article a where a.law = :law and a.articleNo = :articleNo";
		articleList = (List<Article>) hibernateTemplate.findByNamedParam(hql, new String[] { "law", "articleNo" },
				new Object[] { law, articleNo });

		return articleList;
	}

	@SuppressWarnings("unchecked")
	public Article findByLawArticleBranch(Law law, String articleNo, String branchNo) {
		List<Article> articleList = new ArrayList<Article>();
		String hql = "from Article a where a.law = :law and a.articleNo = :articleNo and a.branchNo = :branchNo";
		articleList = (List<Article>) hibernateTemplate.findByNamedParam(hql,
				new String[] { "law", "articleNo", "branchNo" }, new Object[] { law, articleNo, branchNo });

		return articleList.get(0);
	}

	@SuppressWarnings("unchecked")
	public boolean exists(int articleId) {
		List<Article> articleList = new ArrayList<Article>();
		String hql = "from Article a where a.articleId = :articleId";
		articleList = (List<Article>) hibernateTemplate.findByNamedParam(hql, "articleId", articleId);

		return articleList.size() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(Law law, String articleNo, String branchNo) {
		List<Article> articleList = new ArrayList<Article>();
		String hql = "from Article a where a.law = :law and a.articleNo = :articleNo and a.branchNo = :branchNo";
		articleList = (List<Article>) hibernateTemplate.findByNamedParam(hql,
				new String[] { "law", "articleNo", "branchNo" }, new Object[] { law, articleNo, branchNo });

		return articleList.size() > 0 ? true : false;
	}

}
