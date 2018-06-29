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
		/*
		if(!exists(law.getFullName()))
			lawDao.save(law);
		else
			lawDao.update(getLawByFullName(law.getFullName()));
		*/
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
	
	@Override
	public Law getLawByFullName(String fullName) {
		return lawDao.findByFullName(fullName);
	}

	@Override
	public boolean exists(int lawId) {
		return lawDao.exists(lawId);
	}

	@Override
	public boolean exists(String fullName) {
		return lawDao.exists(fullName);
	}
	
}
