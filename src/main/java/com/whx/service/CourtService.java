package com.whx.service;

import com.whx.entities.Court;

public interface CourtService {
	
	public void addCourt(Court court);

	public void deleteCourt(Court court);

	public void deleteCourt(String courtCode);

	public void updateCourt(Court court);
	
	public Court getCourt(String courtCode);
	
	public Court getCourtByCourtName(String courtName);
	
	public boolean exists(String courtCode);

	public boolean existsN(String name);

}
