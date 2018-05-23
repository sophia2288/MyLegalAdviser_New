package com.whx.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.whx.entities.Brief;
import com.whx.service.BriefService;

public class InputBrief {
	
	@Autowired
	private static BriefService briefService;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = null;
		String regexStr = "^(第[一二三四五六七八九十]部分\\s?|([一二三四五六七八九])?十?([一二三四五六七八九])?、|\\d{1,3}、|（\\d{1,2}）\\s?)(([\\u4e00-\\u9fa5]{1,25}、?)+)\\s((\\d{3}){1,4})\\s*$";
		Pattern pattern = Pattern.compile(regexStr);
		try {
			in = new BufferedReader(new InputStreamReader(
					new FileInputStream("F:\\JavaDev\\SpringWorkspace\\MyLegalAdviser\\Briefs2.txt"), "UTF-8"));
			String s="";
			while ((s = in.readLine()) != null) {
				Matcher matcher = pattern.matcher(s);
				if (matcher.find()) {
					Brief brief=new Brief();
					brief.setBriefId(matcher.group(6));
					brief.setBriefName(matcher.group(4));
					
					briefService.addBrief(brief);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}
}
