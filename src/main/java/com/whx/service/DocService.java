package com.whx.service;

import java.util.List;

import com.whx.entities.Doc;

public interface DocService {
	
	public void addDoc(Doc doc);

	public void deleteDoc(Doc doc);
	
	public void deleteDoc(Integer docId);

	public void deleteDoc(String caseNo);

	public void updateDoc(Doc doc);
	
	public void updateDoc(Integer docId);
	
	public void updateDoc(String caseNo);

	public Doc getDocById(Integer docId);

	public List<Doc> getDocsByCaseNo(String caseNo);

	public boolean exists(Integer docId);

	public boolean exists(String caseNo);
	
	public String getFullPath(Doc doc);
}
