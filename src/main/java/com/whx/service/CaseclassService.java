package com.whx.service;

import com.whx.entities.Caseclass;

public interface CaseclassService {
	
	public void addCaseclass(Caseclass caseclass);

	public void deleteCaseclass(Caseclass caseclass);

	public void deleteCaseclass(Integer classId);

	public void updateCaseclass(Caseclass caseclass);

	public Caseclass getCaseclassById(Integer classId);
	
	public boolean exists(Integer classId);
}
