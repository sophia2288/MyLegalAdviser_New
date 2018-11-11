package com.whx.dao;

import com.whx.entities.Caseclass;

public interface CaseclassDao {
	
	public void save(Caseclass caseclass);

	public void delete(Caseclass caseclass);

	public void delete(Integer classId);

	public void update(Caseclass caseclass);

	public Caseclass findById(Integer classId);
	
	public boolean exists(Integer classId);
	
}
