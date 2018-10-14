package com.whx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whx.entities.Doc;
import com.whx.service.DocService;

@Controller
public class DocController {
	@Autowired
	private DocService docService;
	
	
	@RequestMapping(value = "/docInput")
	public String docInput(Model model) {
		model.addAttribute("doc", new Doc());
		
		
		return "UploadDocForm4";
	}
}
