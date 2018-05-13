package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whx.dao.BriefDao;
import com.whx.entities.Brief;


@Repository("briefDao")
public class BriefDaoImpl implements BriefDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public BriefDaoImpl() {
		System.out.println("BriefDaoImpl()");
	}
	
	public void save(Brief brief) {
		hibernateTemplate.save(brief);
	}

	public void update(Brief brief) {
		hibernateTemplate.update(brief);
	}

	public void delete(Brief brief) {
		hibernateTemplate.delete(brief);
	}
	
	public void deleteI(String briefId) {
		hibernateTemplate.bulkUpdate("delete Brief bf where bf.briefId = ?", new Object[]{briefId});
	}

	public void delete(String briefName) {
		hibernateTemplate.bulkUpdate("delete Brief bf where bf.briefName = ?", new Object[]{briefName});
	}

	public Brief findById(String briefId) {
		return (Brief) hibernateTemplate.get(Brief.class, briefId);
	}

	@SuppressWarnings("unchecked")
	public Brief findByBriefName(String briefName) {
		List<Brief> briefList = new ArrayList<Brief>();
		String hql = "from Brief bf where bf.briefName = :briefName";
		briefList = (List<Brief>) hibernateTemplate.findByNamedParam(hql, "briefName", briefName);
		return briefList.get(0);
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String briefId) {
		List<Brief> briefList = new ArrayList<Brief>();
		String hql = "from Brief bf where bf.briefId = :briefId";
		briefList = (List<Brief>) hibernateTemplate.findByNamedParam(hql, "briefId", briefId);
		
		return briefList.size() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	public boolean existsN(String briefName) {
		List<Brief> briefList = new ArrayList<Brief>();
		String hql = "from Brief bf where bf.briefName = :briefName";
		briefList = (List<Brief>) hibernateTemplate.findByNamedParam(hql, "briefName", briefName);
		
		return briefList.size() > 0 ? true : false;
	}

}
