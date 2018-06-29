package com.whx.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuildJSonString {
	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		String regexStr = "^([\\u4e00-\\u9fa5]{1,25})\\s*((\\d{3}){1,4})\\s*$";
		Pattern pattern = Pattern.compile(regexStr);

		try {
			in = new BufferedReader(new InputStreamReader(
					new FileInputStream("F:\\JavaDev\\SpringWorkspace\\MyLegalAdviser\\Briefs4.txt"), "UTF-8"));
			String s="";
			String jsonStr="";
			while ((s = in.readLine()) != null) {
				Matcher matcher = pattern.matcher(s);
				if (matcher.find()) {
					//格式：{ label: "人格权纠纷", value: "001001" },
					String temp = "{ label: " + "\"" + matcher.group(1) + "\", value: " + "\"" + matcher.group(2) +"\" },\r\n";
					jsonStr += temp;
				}
			}
			System.out.print(jsonStr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
	}

}
