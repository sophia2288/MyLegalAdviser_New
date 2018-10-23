package com.whx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.whx.entities.Article;
import com.whx.entities.Law;
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

		List<String> prescription = new ArrayList<String>();
		prescription.add("现行有效");
		prescription.add("已被修改");
		prescription.add("已废止");
		model.addAttribute("prescriptions", prescription);
		
		Map<String,String> prescription1=new HashMap<String,String>();
		prescription1.put("现行有效", "现行有效");
		prescription1.put("已被修改", "已被修改");
		prescription1.put("已废止", "已废止");
		model.addAttribute("prescriptions1", prescription1);

		return "UploadLawForm_JQuery4";
	}

	@RequestMapping(value = "/saveLaw")
	public String saveLaw(@ModelAttribute Law law, @RequestParam("file") MultipartFile uploadFile, Model model)
			throws IOException {
		if("".equals(law.getBrief()/*.getBriefId()*/)||law.getBrief()/*.getBriefId()*/.isEmpty()) {
			//law.setBrief(null);
			law.setBrief("");
		}
		lawService.addLaw(law);
		writeArticles(law,uploadFile);
		
		return "LawDetails";
	}
	
	//向数据库表article写入法律条款
	private void writeArticles(Law law,MultipartFile uploadFile) throws IOException {
		if (uploadFile.getSize() > 0) {
			String fileName = uploadFile.getOriginalFilename();
			InputStream in = uploadFile.getInputStream();// 载入文档
			if (fileName.toLowerCase().endsWith("docx")) {
				String zhang = "", jie = "";
				String tiao = "";
				short kuan = 1;
				XWPFDocument xwpf = new XWPFDocument(in);// 得到word文档的信息
				XWPFWordExtractor we = new XWPFWordExtractor(xwpf);

				String regexStr = "((第[一二三四五六七八九]?十?[一二三四五六七八九]?章\\s*([\\u4e00-\\u9fa5]{0,30})\\n)?(第[一二三四五六七八九]?十?[一二三四五六七八九]?节\\s*([\\u4e00-\\u9fa5]{0,40})\\n)?)((第[一二三四五六七八九]?百?[零一二三四五六七八九]?十?[一二三四五六七八九]?条\\s*)?((([\\u4e00-\\u9fa5]\\d*[、，“”《》〈〉%；。]*)+：\\n(（[一二三四五六七八九]?十?[一二三四五六七八九]?）([\\u4e00-\\u9fa5]\\d*[、，%；。]?)+[；。]\\n)+)|((([\\u4e00-\\u9fa5]*\\d*[、，“”《》〈〉；%：。]*)+)\\n)))";
				Pattern pattern = Pattern.compile(regexStr);
				Matcher matcher = pattern.matcher(we.getText());
				while (matcher.find()) {
					if (matcher.group(0).trim() != "") {
						if ((matcher.group(2) != null) && (matcher.group(2) != "")) {
							zhang = matcher.group(2);
							jie = "";
						}
						if ((matcher.group(4) != null) && (matcher.group(4) != "")) {
							jie = matcher.group(4);
						}
						if ((matcher.group(7) != null) && (matcher.group(7) != "")) {
							tiao = matcher.group(7);
							kuan = 1;
						} else if (matcher.group(7) == null) {
							kuan++;
						}
						if ((matcher.group(8) != null) && (matcher.group(8) != "")) {
							Article article = new Article();
							article.setChapter(zhang);
							article.setSection(jie);
							article.setArticleNo(tiao);
							article.setBranchNo(GetCH(kuan));
							article.setContent(matcher.group(8));
							article.setLaw(law);

							articleService.addArticle(article);
						}
					} // outer if clause.
				} // while loop end.
				we.close();
				xwpf.close();
			}
			in.close();
		}
	}
	
	//工具函数：将数字转换成中文数字
	private String GetCH(int input) {
		String sd = "";
		switch (input) {
		case 1:
			sd = "一";
			break;
		case 2:
			sd = "二";
			break;
		case 3:
			sd = "三";
			break;
		case 4:
			sd = "四";
			break;
		case 5:
			sd = "五";
			break;
		case 6:
			sd = "六";
			break;
		case 7:
			sd = "七";
			break;
		case 8:
			sd = "八";
			break;
		case 9:
			sd = "九";
			break;
		default:
			break;
		}
		return sd;
	}
}
