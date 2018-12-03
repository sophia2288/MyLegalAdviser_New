package com.whx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whx.entities.Doc;
import com.whx.entities.Guidecase;
import com.whx.service.CaseclassService;
import com.whx.service.GuidecaseService;

@Controller
public class GuidecaseController {
	@Autowired
	private GuidecaseService guidecaseService;

	@Autowired
	private CaseclassService caseclassService;
	
	@RequestMapping(value = "/guidecaseInput")
	public String docInput(Model model) {
		model.addAttribute("guidecase", new Guidecase());

		return "inputGuidecase";
	}
}
