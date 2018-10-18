package com.whx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

@Controller
public class AjaxController {

	@RequestMapping(value = "/ajaxTest", method = RequestMethod.POST, produces = "html/text;charset=UTF-8")
	public @ResponseBody String ajaxTest(@RequestParam(value = "wordfile", required = false) MultipartFile file,
			HttpServletResponse response) throws IOException {
		String wordText = "";
		String rtnStr = "";

		InputStream stream = null;
		XWPFDocument xwpf = null;
		XWPFWordExtractor we = null;

		try {
			stream = file.getInputStream();
			xwpf = new XWPFDocument(stream);// 得到word文档的信息
			we = new XWPFWordExtractor(xwpf);
			wordText = we.getText();

			Map<String, String> map = new HashMap<String, String>();
			map.put("caseNo", "（2018）鄂01民再128号");
			map.put("source", "中国裁判文书网");
			map.put("court", wordText);

			rtnStr = JSON.toJSONString(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			we.close();
			xwpf.close();
			stream.close();
		}

		return rtnStr;
	}
}
