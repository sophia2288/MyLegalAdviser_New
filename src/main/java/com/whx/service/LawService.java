package com.whx.service;

import com.whx.entities.Law;

public interface LawService {

	public void addLaw(Law law);

	public void deleteLaw(Law law);

	public void deleteLaw(Integer lawId);

	public void updateLaw(Law law);
	
	public Law getLaw(Integer lawId);
	
	public Law getLawByFullName(String fullName);
	
	public boolean exists(Integer lawId);

	public boolean exists(String fullName);
	
}
