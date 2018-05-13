package com.whx.service;

import com.whx.entities.Law;

public interface LawService {

	public void addLaw(Law law);

	public void deleteLaw(Law law);

	public void deleteLaw(int lawId);

	public void updateLaw(Law law);
	
	public Law getLaw(int lawId);
	
	public boolean exists(int lawId);

	public boolean exists(String fullName);
	
}
