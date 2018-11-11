package com.whx.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.whx.entities.Court;
import com.whx.service.CourtService;

@Component
public class CourtCodeToCourtConverter implements Converter<String, Court> {// 本类暂时没有派上用场
	@Autowired
	private CourtService courtService;
	public Court convert(String courtCode) {
		
		Court court= courtService.getCourt(courtCode);
		
		return court;
	}
}
