package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whx.dao.JudgepointDao;
import com.whx.entities.Judgepoint;

@Repository("judgepointDao")
public class JudgepointDaoImpl implements JudgepointDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public JudgepointDaoImpl() {
		System.out.println("JudgepointDaoImpl()");
	}

	public void save(Judgepoint judgePoint) {
		hibernateTemplate.save(judgePoint);
	}

	public void delete(Judgepoint judgePoint) {
		hibernateTemplate.delete(judgePoint);
	}

	public void delete(int judgePointId) {
		hibernateTemplate.bulkUpdate("delete Judgepoint j where j.judgePointId = ?", new Object[] { judgePointId });
	}

	public void update(Judgepoint judgePoint) {
		hibernateTemplate.update(judgePoint);
	}

	public Judgepoint findById(int judgePointId) {
		return hibernateTemplate.get(Judgepoint.class, judgePointId);
	}

	@SuppressWarnings("unchecked")
	public List<Judgepoint> findByTitle(String title) {
		List<Judgepoint> judgePointList = new ArrayList<Judgepoint>();
		String hql = "from Judgepoint j where j.title like :title";
		judgePointList = (List<Judgepoint>) hibernateTemplate.findByNamedParam(hql, "title", "%"+title+"%");

		return judgePointList;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(int judgePointId) {
		List<Judgepoint> judgePointList = new ArrayList<Judgepoint>();
		String hql = "from Judgepoint j where j.judgePointId = :judgePointId";
		judgePointList = (List<Judgepoint>) hibernateTemplate.findByNamedParam(hql, "judgePointId", judgePointId);

		return judgePointList.size() > 0 ? true : false;
	}

}
