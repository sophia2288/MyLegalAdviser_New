package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whx.dao.GuidecaseDao;
import com.whx.entities.Guidecase;

@Repository("guidecaseDao")
public class GuidecaseDaoImpl implements GuidecaseDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void save(Guidecase guidecase) {
		hibernateTemplate.save(guidecase);
	}

	public void delete(Guidecase guidecase) {
		hibernateTemplate.delete(guidecase);
	}

	public void delete(String guidecaseNo) {
		hibernateTemplate.bulkUpdate("delete Guidecase g where g.guideCaseNo = ?", new Object[] { guidecaseNo });
	}

	public void update(Guidecase guidecase) {
		hibernateTemplate.update(guidecase);
	}

	public Guidecase findById(String guidecaseNo) {
		return (Guidecase) hibernateTemplate.get(Guidecase.class, guidecaseNo);
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String guidecaseNo) {
		List<Guidecase> guidecaseList = new ArrayList<Guidecase>();
		String hql = "from Guidecase g where g.guideCaseNo = :guideCaseNo";
		guidecaseList = (List<Guidecase>) hibernateTemplate.findByNamedParam(hql, "guideCaseNo", guidecaseNo);

		return guidecaseList.size() > 0 ? true : false;
	}

}
