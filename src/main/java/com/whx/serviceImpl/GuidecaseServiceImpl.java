package com.whx.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whx.dao.GuidecaseDao;
import com.whx.entities.Guidecase;
import com.whx.service.GuidecaseService;

@Service
public class GuidecaseServiceImpl implements GuidecaseService{

	@Autowired
	private GuidecaseDao guidecaseDao;
	
	public GuidecaseServiceImpl() {
		System.out.println("GuidecaseServiceImpl()");
	}

	public void addGuidecase(Guidecase guidecase) {
		if(!exists(guidecase.getGuideCaseNo()))
			guidecaseDao.save(guidecase);
	}

	public void deleteGuidecase(Guidecase guidecase) {
		if(exists(guidecase.getGuideCaseNo()))
			guidecaseDao.delete(guidecase);
	}

	public void deleteGuidecase(String guidecaseNo) {
		if(exists(guidecaseNo))
			guidecaseDao.delete(guidecaseNo);
	}

	public void updateGuidecase(Guidecase guidecase) {
		if(exists(guidecase.getGuideCaseNo()))
			guidecaseDao.update(guidecase);
	}

	public Guidecase getGuidecaseById(String guidecaseNo) {
		return guidecaseDao.findById(guidecaseNo);
	}

	public boolean exists(String guidecaseNo) {
		return guidecaseDao.exists(guidecaseNo);
	}
}
