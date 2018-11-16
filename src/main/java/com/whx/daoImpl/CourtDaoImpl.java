package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whx.dao.CourtDao;
import com.whx.entities.Court;

@Repository("courtDao")
public class CourtDaoImpl implements CourtDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public CourtDaoImpl() {
		System.out.println("CourtDaoImpl()");
	}
	
	public void save(Court court) {
		hibernateTemplate.saveOrUpdate(court);
	}

	public void update(Court court) {
		hibernateTemplate.update(court);
	}

	public void delete(Court court) {
		hibernateTemplate.delete(court);
	}

	public void deleteI(String courtCode) {
		hibernateTemplate.bulkUpdate("delete Court c where c.courtCode = ?", new Object[]{courtCode});
	}

	public void delete(String name) {
		hibernateTemplate.bulkUpdate("delete Court c where c.name = ?", new Object[]{name});
	}

	public Court findById(String courtCode) {
		return (Court) hibernateTemplate.get(Court.class, courtCode);
	}

	@SuppressWarnings("unchecked")
	public Court findByCourtName(String name) {
		List<Court> courtList = new ArrayList<Court>();
		String hql = "from Court c where c.name = :name";
		courtList = (List<Court>) hibernateTemplate.findByNamedParam(hql, "name", name);
		if (courtList.isEmpty()) {
			return null;
		}else {
			return courtList.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String courtCode) {
		List<Court> courtList = new ArrayList<Court>();
		String hql = "from Court c where c.courtCode = :courtCode";
		courtList = (List<Court>) hibernateTemplate.findByNamedParam(hql, "courtCode", courtCode);
		
		return courtList.size() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	public boolean existsN(String name) {
		List<Court> courtList = new ArrayList<Court>();
		String hql = "from Court c where c.name = :name";
		courtList = (List<Court>) hibernateTemplate.findByNamedParam(hql, "name", name);
		
		return courtList.size() > 0 ? true : false;
	}

}
