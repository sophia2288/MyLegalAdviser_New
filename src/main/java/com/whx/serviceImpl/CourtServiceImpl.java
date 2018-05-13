package com.whx.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whx.dao.CourtDao;
import com.whx.entities.Court;
import com.whx.service.CourtService;

@Service
public class CourtServiceImpl implements CourtService {

	@Autowired
    private CourtDao courtDao;
	
	public CourtServiceImpl() {
		System.out.println("CourtServiceImpl()");
	}
	
	public void addCourt(Court court) {
		if(!exists(court.getCourtCode()))
			courtDao.save(court);
	}

	public void deleteCourt(Court court) {
		if(exists(court.getCourtCode()))
			courtDao.delete(court);
	}

	public void deleteCourt(String courtCode) {
		if(exists(courtCode))
			courtDao.deleteI(courtCode);
	}

	public void updateCourt(Court court) {
		if(exists(court.getCourtCode()))
			courtDao.update(court);
	}

	public Court getCourt(String courtCode) {
		return courtDao.findById(courtCode);
	}

	public boolean exists(String courtCode) {
		return courtDao.exists(courtCode);
	}

	public boolean existsN(String name) {
		return courtDao.existsN(name);
	}

}
