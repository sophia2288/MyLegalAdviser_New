package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whx.dao.CaseclassDao;
import com.whx.entities.Caseclass;

@Repository("caseclassDao")
public class CaseclassDaoImpl implements CaseclassDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public CaseclassDaoImpl() {
		System.out.println("CaseclassDaoImpl()");
	}

	public void save(Caseclass caseclass) {
		hibernateTemplate.save(caseclass);
	}

	public void delete(Caseclass caseclass) {
		hibernateTemplate.delete(caseclass);
	}

	public void delete(Integer classId) {
		hibernateTemplate.bulkUpdate("delete Caseclass c where c.classId = ?", new Object[] { classId });
	}

	public void update(Caseclass caseclass) {
		hibernateTemplate.update(caseclass);
	}

	public Caseclass findById(Integer classId) {
		return (Caseclass) hibernateTemplate.get(Caseclass.class, classId);
	}

	@SuppressWarnings("unchecked")
	public boolean exists(Integer classId) {
		List<Caseclass> caseclassList = new ArrayList<Caseclass>();
		String hql = "from Caseclass c where c.classId = :classId";
		caseclassList = (List<Caseclass>) hibernateTemplate.findByNamedParam(hql, "classId", classId);

		return caseclassList.size() > 0 ? true : false;
	}

}
