package com.whx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whx.dao.DocDao;
import com.whx.entities.Doc;
import com.whx.service.DocService;

@Service
public class DocServiceImpl implements DocService{
	
	@Autowired
	private DocDao docDao;
	
	public DocServiceImpl() {
		System.out.println("DocServiceImpl()");
	}

	public void addDoc(Doc doc) {
		if(!exists(doc.getDocId()))
			docDao.save(doc);
	}

	public void deleteDoc(Doc doc) {
		if(exists(doc.getDocId()))
			docDao.delete(doc);
	}

	public void deleteDoc(int docId) {
		if(exists(docId))
			docDao.delete(docId);
	}

	public void deleteDoc(String caseNo) {
		if(exists(caseNo))
			docDao.delete(caseNo);
	}

	public void updateDoc(Doc doc) {
		if(exists(doc.getDocId()))
			docDao.update(doc);
	}

	public void updateDoc(int docId) {
		if(exists(docId))
			docDao.update(docId);
	}

	public void updateDoc(String caseNo) {
		if(exists(caseNo))
			docDao.update(caseNo);
	}

	public Doc getDocById(int docId) {
		return docDao.findById(docId);
	}

	public List<Doc> getDocsByCaseNo(String caseNo) {
		return docDao.findByCaseNo(caseNo);
	}

	public boolean exists(int docId) {
		return docDao.exists(docId);
	}

	public boolean exists(String caseNo) {
		return docDao.exists(caseNo);
	}

}
