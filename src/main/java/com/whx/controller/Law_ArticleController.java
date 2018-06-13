package com.whx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whx.entities.Law;
import com.whx.entities.User;
import com.whx.service.ArticleService;
import com.whx.service.LawService;

@Controller
public class Law_ArticleController {
	@Autowired
	private LawService lawService;
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "/lawInput")
	public String lawInput(Model model) {
		model.addAttribute("law", new Law());
		
		List<String> prescription= new ArrayList<String>();
		prescription.add("现行有效");
		prescription.add("已被修改");
		prescription.add("已废止");
		
		model.addAttribute("prescriptions", prescription);
		
		return "UploadLawForm";
	}
	
	@RequestMapping(value = "/saveLaw")
	public String saveLaw(@ModelAttribute Law law,Model model) {
		
		lawService.addLaw(law);
		
		
		return "LawDetails";
	}
}
