package com.whx.service;

import com.whx.entities.Guidecase;

public interface GuidecaseService {
	
	public void addGuidecase(Guidecase guidecase);

	public void deleteGuidecase(Guidecase guidecase);

	public void deleteGuidecase(String guidecaseNo);

	public void updateGuidecase(Guidecase guidecase);

	public Guidecase getGuidecaseById(String guidecaseNo);

	public boolean exists(String guidecaseNo);
	
}
