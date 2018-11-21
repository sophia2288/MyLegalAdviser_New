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

	/*
	 * court表的name列应用了UNIQUE约束，可以确保“法院名称”是唯一的。
	 * 使用sql语句“SELECT name,count(name) FROM mylaw.court group by name having count(name)>1”
	 * 对数据库court表进行查询，法院名称无重复。
	 * 下列模糊查询，理论情况下应返回多条记录，但具体到本表应该只返回一条记录。
	 */
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
