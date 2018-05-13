package com.whx.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whx.dao.LawDao;
import com.whx.entities.Law;
import com.whx.service.LawService;

@Service
public class LawServiceImpl implements LawService {

	@Autowired
	private LawDao lawDao;
	
	public LawServiceImpl() {
		System.out.println("LawServiceImpl()");
	}

	public void addLaw(Law law) {
		if(!exists(law.getLawId()))
			lawDao.save(law);
	}

	public void deleteLaw(Law law) {
		if(exists(law.getLawId()))
			lawDao.delete(law);
	}

	public void deleteLaw(int lawId) {
		if(exists(lawId))
			lawDao.delete(lawId);
	}

	public void updateLaw(Law law) {
		if(exists(law.getLawId()))
			lawDao.update(law);
	}

	public Law getLaw(int lawId) {
		return lawDao.findById(lawId);
	}

	public boolean exists(int lawId) {
		return lawDao.exists(lawId);
	}

	public boolean exists(String fullName) {
		return lawDao.exists(fullName);
	}
	
}
