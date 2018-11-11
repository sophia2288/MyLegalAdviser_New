package com.whx.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whx.dao.CaseclassDao;
import com.whx.entities.Caseclass;
import com.whx.service.CaseclassService;

@Service
public class CaseclassServiceImpl implements CaseclassService{
	
	@Autowired
	private CaseclassDao caseclassDao;
	
	public CaseclassServiceImpl() {
		System.out.println("CaseclassServiceImpl()");
	}

	public void addCaseclass(Caseclass caseclass) {
		if(!exists(caseclass.getClassId()))
			caseclassDao.save(caseclass);
	}

	public void deleteCaseclass(Caseclass caseclass) {
		if(exists(caseclass.getClassId()))
			caseclassDao.delete(caseclass);
	}

	public void deleteCaseclass(Integer classId) {
		if(exists(classId))
			caseclassDao.delete(classId);
	}

	public void updateCaseclass(Caseclass caseclass) {
		if(exists(caseclass.getClassId()))
			caseclassDao.update(caseclass);
	}

	public Caseclass getCaseclassById(Integer classId) {
		return caseclassDao.findById(classId);
	}

	public boolean exists(Integer classId) {
		return caseclassDao.exists(classId);
	}

}
