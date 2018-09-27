package com.whx.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AjaxController {

	@RequestMapping(value = "/ajaxTest", method = RequestMethod.POST)
	public @ResponseBody void ajaxTest(@RequestParam(value = "wordfile", required = false) MultipartFile file,
			HttpServletResponse response) throws IOException {
		String wordText = "";
		InputStream stream = null;
		XWPFDocument xwpf = null;
		XWPFWordExtractor we = null;
		try {
			//String fileName = file.getOriginalFilename();
			stream = file.getInputStream();
			xwpf = new XWPFDocument(stream);// 得到word文档的信息
			we = new XWPFWordExtractor(xwpf);
			wordText = we.getText();
			//System.out.println("Reading File:" + fileName);
			//System.out.println(wordText);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			we.close();
			xwpf.close();
			stream.close();
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		response.getWriter().print(wordText);
		response.getWriter().close();
	}
}
