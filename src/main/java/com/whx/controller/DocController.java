package com.whx.controller;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		return "inputDoc8";
	}

	@RequestMapping(value = "/saveDoc")
	public String saveDoc(@ModelAttribute Doc doc, @RequestParam("file") MultipartFile uploadFile/*, Model model */)
			throws IOException {
		
		String fileName = uploadFile.getOriginalFilename();
		File file = new File(docService.getFullPath(doc), fileName);
		try {
			uploadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return "docDetails";
        }
		
		if (doc.getCaseclass() == null || doc.getCaseclass().getClassId() == null) {
			doc.setCaseclass(null);
		} else {
			Integer caseclassId = doc.getCaseclass().getClassId();
			Caseclass caseclass = caseclassService.getCaseclassById(caseclassId);
			doc.setCaseclass(caseclass);
		}

		String courtName = doc.getCourt().getName();
		// String regexStrOfCourt = "(北京市|上海市|天津市|重庆市|河北省|黑龙江省|吉林省|辽宁省|内蒙古自治区|山西省|江苏省|浙江省|安徽省|福建省|江西省|山东省|河南省|湖北省|湖南省|广东省|广西壮族自治区|海南省|四川省|贵州省|云南省|西藏自治区|陕西省|甘肃省|青海省|宁夏回族自治区|新疆维吾尔自治区|新疆建设兵团)?([\\u4e00-\\u9fa5]{1,20}(县|市|旗|区))人民法院";
		String regexStrOfCourt = "(河北省|黑龙江省|吉林省|辽宁省|内蒙古自治区|山西省|江苏省|浙江省|安徽省|福建省|江西省|山东省|河南省|湖北省|湖南省|广东省|广西壮族自治区|海南省|四川省|贵州省|云南省|西藏自治区|陕西省|甘肃省|青海省|宁夏回族自治区|新疆维吾尔自治区|新疆建设兵团)?([\\u4e00-\\u9fa5]{1,20}(县|市|旗|区))人民法院";
		Pattern pattern = Pattern.compile(regexStrOfCourt);
		Matcher matcher = pattern.matcher(courtName);
		if (matcher.matches()) {
			if (matcher.group(1) != null)
				courtName = courtName.replaceAll(matcher.group(1), "");
		}
		Court court = courtService.getCourtByCourtName(courtName);
		if (court == null) {
			return "docError";
		} else {
			doc.setCourt(court);
			docService.addDoc(doc);
			
			return "docDetails";
		}
	}
}