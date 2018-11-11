package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whx.dao.LawDao;
import com.whx.entities.Law;

@Repository("lawDao")
public class LawDaoImpl implements LawDao{
	/***** 注入 *****/
	//@Autowired
	//@Qualifier("sessionFactory")
	//private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public LawDaoImpl() {
		System.out.println("LawDaoImpl()");
	}

	public void save(Law law) {
		//sessionFactory.getCurrentSession().saveOrUpdate(law);
		hibernateTemplate.saveOrUpdate(law);
	}

	public void delete(Law law) {
		//String hql = "delete Law l where l.lawId=?";
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//query.setLong(0, law.getLawId());
		//return (query.executeUpdate() > 0);
		hibernateTemplate.delete(law);
	}
	
	public void delete(Integer lawId) {
		hibernateTemplate.bulkUpdate("delete Law l where l.lawId = ?", new Object[]{lawId});
	}

	public void delete(String fullName) {
		//String hql = "delete Law l where l.fullName=?";
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//query.setString(0, fullName);
		//return (query.executeUpdate() > 0);
		hibernateTemplate.bulkUpdate("delete Law l where l.fullName = ?", new Object[]{fullName});
	}

	public void update(Law law) {
		/*
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
		*/
		hibernateTemplate.update(law);
	}

	public Law findById(Integer lawId) {
		return (Law) hibernateTemplate.get(Law.class, lawId);
	}

	@SuppressWarnings("unchecked")
	public Law findByFullName(String fullName) {
		List<Law> lawList = new ArrayList<Law>();
		String hql = "from Law l where l.fullName = :fullName";
		lawList = (List<Law>) hibernateTemplate.findByNamedParam(hql, "fullName", fullName);
		
		return lawList.get(0);
	}

	/*
	public Set<Article> getArticles(Law law) {
		return law.getArticles();
	}
	*/

	@SuppressWarnings("unchecked")
	public boolean exists(Integer lawId) {
		List<Law> lawList = new ArrayList<Law>();
		String hql = "from Law l where l.lawId = :lawId";
		lawList = (List<Law>) hibernateTemplate.findByNamedParam(hql, "lawId", lawId);
		
		return lawList.size() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String fullName) {
		List<Law> lawList = new ArrayList<Law>();
		String hql = "from Law l where l.fullName = :fullName";
		lawList = (List<Law>) hibernateTemplate.findByNamedParam(hql, "fullName", fullName);
		
		return lawList.size() > 0 ? true : false;
	}
	
}
