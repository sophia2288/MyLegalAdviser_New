package com.whx.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whx.dao.BriefDao;
import com.whx.entities.Brief;
import com.whx.service.BriefService;

@Service
public class BriefServiceImpl implements BriefService{

	@Autowired
	private BriefDao briefDao;
	
	public BriefServiceImpl() {
		System.out.println("BriefServiceImpl()");
	}
	
	public void addBrief(Brief brief) {
		if(!exists(brief.getBriefId()))
			briefDao.save(brief);
	}

	public void deleteBrief(Brief brief) {
		if(exists(brief.getBriefId()))
			briefDao.delete(brief);
	}

	public void deleteBrief(String briefId) {
		if(exists(briefId))
			briefDao.deleteI(briefId);
	}

	public void updateBrief(Brief brief) {
		if(exists(brief.getBriefId()))
			briefDao.update(brief);
	}

	public Brief getBrief(String briefId) {
		return briefDao.findById(briefId);
	}

	public boolean exists(String briefId) {
		return briefDao.exists(briefId);
	}

	public boolean existsN(String briefName) {
		return briefDao.existsN(briefName);
	}

}
