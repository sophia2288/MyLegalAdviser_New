package com.whx.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.whx.dao.DocDao;
import com.whx.entities.Doc;

@Repository("docDao")
public class DocDaoImpl implements DocDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public DocDaoImpl() {
		System.out.println("DocDaoImpl()");
	}
	
	public void save(Doc doc) {
		hibernateTemplate.save(doc);
	}

	public void delete(Doc doc) {
		hibernateTemplate.delete(doc);
	}

	public void delete(Integer docId) {
		hibernateTemplate.bulkUpdate("delete Doc d where d.docId = ?", new Object[] { docId });
	}

	public void delete(String caseNo) {
		hibernateTemplate.bulkUpdate("delete Doc d where d.caseNo = ?", new Object[] { caseNo });
	}

	public void update(Doc doc) {
		hibernateTemplate.update(doc);
	}

	public void update(Integer docId) {
		hibernateTemplate.bulkUpdate("update Doc d where d.docId = ?", new Object[] { docId });
	}

	public void update(String caseNo) {
		hibernateTemplate.bulkUpdate("update Doc d where d.caseNo = ?", new Object[] { caseNo });
	}

	public Doc findById(Integer docId) {
		return (Doc) hibernateTemplate.get(Doc.class, docId);
	}

	@SuppressWarnings("unchecked")
	public List<Doc> findByCaseNo(String caseNo) {
		List<Doc> docList = new ArrayList<Doc>();
		String hql = "from Doc d where d.caseNo = :caseNo";
		docList = (List<Doc>) hibernateTemplate.findByNamedParam(hql, "caseNo", caseNo);

		return docList;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(Integer docId) {
		List<Doc> docList = new ArrayList<Doc>();
		String hql = "from Doc d where d.docId = :docId";
		docList = (List<Doc>) hibernateTemplate.findByNamedParam(hql, "docId", docId);

		return docList.size() > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	public boolean exists(String caseNo) {
		List<Doc> docList = new ArrayList<Doc>();
		String hql = "from Doc d where d.caseNo = :caseNo";
		docList = (List<Doc>) hibernateTemplate.findByNamedParam(hql, "caseNo", caseNo);

		return docList.size() > 0 ? true : false;
	}

}
