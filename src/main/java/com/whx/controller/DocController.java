package com.whx.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.whx.entities.Caseclass;
import com.whx.entities.Court;
import com.whx.entities.Doc;
import com.whx.service.CaseclassService;
import com.whx.service.CourtService;
import com.whx.service.DocService;

@Controller
public class DocController {
	@Autowired
	private DocService docService;

	@Autowired
	private CaseclassService caseclassService;

	@Autowired
	private CourtService courtService;

	@RequestMapping(value = "/docInput")
	public String docInput(Model model) {
		model.addAttribute("doc", new Doc());

		return "inputDoc3";
	}

	@RequestMapping(value = "/saveDoc")
	public String saveDoc(@ModelAttribute Doc doc/* , @RequestParam("file") MultipartFile uploadFile, Model model */)
			throws IOException {

		if (doc.getCaseclass() == null || doc.getCaseclass().getClassId() == null) {
			doc.setCaseclass(null);
		} else {
			Integer caseclassId = doc.getCaseclass().getClassId();
			Caseclass caseclass = caseclassService.getCaseclassById(caseclassId);
			doc.setCaseclass(caseclass);
		}

		Court court = courtService.getCourtByCourtName(doc.getCourt().getName());
		if (court == null) {
			return "docError";
		} else {
			doc.setCourt(court);
			docService.addDoc(doc);

			return "docDetails";
		}
	}
}
