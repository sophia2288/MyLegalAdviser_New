package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.whx.dao.LawDao;
import com.whx.entities.Law;

@Repository("lawDao")
public class LawDaoImpl implements LawDao{
	/***** 注入 *****/
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public LawDaoImpl() {
		System.out.println("LawDaoImpl");
	}

	public void save(Law law) {
		sessionFactory.getCurrentSession().saveOrUpdate(law);
	}

	public boolean delete(Law law) {
		String hql = "delete Law l where l.lawId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setLong(0, law.getLawId());
		return (query.executeUpdate() > 0);
	}

	public boolean delete(String fullName) {
		String hql = "delete Law l where l.fullName=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, fullName);
		return (query.executeUpdate() > 0);
	}

	public boolean update(Law law) {
		String hql = "update Law l set l.fullName=?,l.organ=?,l.referenceNo=?,l.publishDate=?,l.effectiveDate=?,l.prescription=?,l.hierarchy=?,l.classification=?,l.classification1=?,l.aliases=?,l.fullPathName=? where l.lawId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, law.getFullName());
		query.setString(1, law.getOrgan());
		query.setString(2, law.getReferenceNo());
		query.setDate(3, law.getPublishDate());
		query.setDate(4, law.getEffectiveDate());
		query.setString(5, law.getPrescription());
		query.setString(6, law.getHierarchy());
		query.setString(7, law.getClassification());
		query.setString(8, law.getClassification1());
		query.setString(9, law.getAliases());
		query.setString(10, law.getFullPathName());
		query.setLong(11, law.getLawId());

		return (query.executeUpdate() > 0);
	}

	public Law findById(int lawId) {
		return (Law) sessionFactory.getCurrentSession().get(Law.class, lawId);
	}

	@SuppressWarnings("unchecked")
	public Law findByFullName(String fullName) {
		List<Law> lawList = new ArrayList<Law>();
		String hql = "from Law l where l.fullName = :fullName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("fullName", fullName);
		lawList = query.list();
		if(lawList.size()>0)
			return lawList.get(0);
		return null;
	}

	/*
	public Set<Article> getArticles(Law law) {
		return law.getArticles();
	}
	*/

	@SuppressWarnings("unchecked")
	public boolean exists(int lawId) {
		List<Law> lawList = new ArrayList<Law>();
		String hql = "from Law l where l.lawId = :lawId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("lawId", lawId);
		lawList = query.list();
		
		return lawList.size() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String fullName) {
		List<Law> lawList = new ArrayList<Law>();
		String hql = "from Law l where l.fullName = :fullName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("fullName", fullName);
		lawList = query.list();
		
		return lawList.size() > 0 ? true : false;
	}
}
