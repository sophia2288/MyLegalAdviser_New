package com.whx.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.whx.entities.Doc;
import com.whx.service.DocService;

@Controller
public class DocController {
	@Autowired
	private DocService docService;
	
	
	@RequestMapping(value = "/docInput")
	public String docInput(Model model) {
		model.addAttribute("doc", new Doc());
		
		
		return "UploadDocForm_bootstrap";
	}
	
	@RequestMapping(value = "/saveDoc")
	public String saveDoc(@ModelAttribute Doc doc/*, @RequestParam("file") MultipartFile uploadFile, Model model*/)
			throws IOException {
		
		docService.addDoc(doc);
		
		return "docDetails";
	}
}
