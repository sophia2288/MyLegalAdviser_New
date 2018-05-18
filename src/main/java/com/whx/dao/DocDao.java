package com.whx.dao;

import java.util.List;

import com.whx.entities.Doc;

public interface DocDao {
	
	public void save(Doc doc);

	public void delete(Doc doc);
	
	public void delete(int docId);

	public void delete(String caseNo);

	public void update(Doc doc);
	
	public void update(int docId);
	
	public void update(String caseNo);

	public Doc findById(int docId);

	public List<Doc> findByCaseNo(String caseNo);

	public boolean exists(int docId);

	public boolean exists(String caseNo);

}
