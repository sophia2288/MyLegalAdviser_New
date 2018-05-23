package com.whx.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.whx.entities.Brief;
import com.whx.service.BriefService;

@Controller
public class BriefController {

	@Autowired
	private BriefService briefService;

	@RequestMapping(value = "/briefInput")
	public String welcome() {
		return "uploadBriefForm";
	}

	// 上传文件会自动绑定到MultipartFile中
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	// public String upload(HttpServletRequest request, @RequestParam("description")
	// String description,@RequestParam("file") MultipartFile file) throws Exception
	// {
	public String upload(@RequestParam("file") MultipartFile uploadFile) throws Exception {
		if (uploadFile.getSize() > 0) {
			String fileName = uploadFile.getOriginalFilename();
			if (fileName.endsWith("txt")) {
				BufferedReader in = null;
				String regexStr = "^(第[一二三四五六七八九十]部分\\s?|([一二三四五六七八九])?十?([一二三四五六七八九])?、|\\d{1,3}、|（\\d{1,2}）\\s?)(([\\u4e00-\\u9fa5]{1,25}、?)+)\\s((\\d{3}){1,4})\\s*$";
				Pattern pattern = Pattern.compile(regexStr);

				in = new BufferedReader(new InputStreamReader(uploadFile.getInputStream(), "UTF-8"));
				String s = "";
				while ((s = in.readLine()) != null) {
					Matcher matcher = pattern.matcher(s);
					if (matcher.find()) {
						Brief brief = new Brief();
						brief.setBriefId(matcher.group(6));
						brief.setBriefName(matcher.group(4));

						briefService.addBrief(brief);
					}
				}
				in.close();
				return "success";
			}
		}
		return "error";
	}
}
