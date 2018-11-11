package com.whx.converter;

//import java.io.IOException;
//import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CnDate2Date {
	
	/*
	public static void main(String[] args) throws IOException {
		testConvertZwrq();
	}

	private static void testConvertZwrq() {
		String[] list = new String[] { "二〇一二年十一月二十二日", "二〇〇九年四月三十日", "〇九年四月三十日", "二〇〇九年十二月三十一日", "一九九九年八月三十一日",
				"二零零九年十二月三十一日" };
		for (String s : list) {
			Date d = convertCnDate(s);
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d));
		}
	}
	*/
	
	public static Date convertCnDate(String cprq) {
		int yearPos = cprq.indexOf("年");
		int monthPos = cprq.indexOf("月");
		String cnYear = cprq.substring(0, yearPos);
		String cnMonth = cprq.substring(yearPos + 1, monthPos);
		String cnDay = cprq.substring(monthPos + 1, cprq.length() - 1);
		String year = ConvertCnYear(cnYear);
		String month = ConvertCnDateNumber(cnMonth);
		String day = ConvertCnDateNumber(cnDay);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, Integer.parseInt(year));
		c.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
		return c.getTime();
	}

	private static String ConvertCnYear(String cnYear) {
		if (cnYear.length() == 2)
			return "20" + ConvertCnNumberChar(cnYear);
		else
			return ConvertCnNumberChar(cnYear);
	}

	private static String ConvertCnDateNumber(String cnNumber) {
		if (cnNumber.length() == 1) {
			if (cnNumber.equals("十"))
				return "10";
			else
				return ConvertCnNumberChar(cnNumber);
		} else if (cnNumber.length() == 2) {
			if (cnNumber.startsWith("十")) {
				return "1" + ConvertCnNumberChar(cnNumber.substring(1, 2));
			} else if (cnNumber.endsWith("十")) {
				return ConvertCnNumberChar(cnNumber.substring(0, 1)) + "0";
			} else {
				return ConvertCnNumberChar(cnNumber);
			}
		} else if (cnNumber.length() == 3) {
			return ConvertCnNumberChar(cnNumber.substring(0, 1) + cnNumber.substring(2, 3));
		}
		return null;
	}

	private static String ConvertCnNumberChar(String cnNumberStr) {
		String ALL_CN_NUMBER = "〇零一二三四五六七八九";
		String ALL_NUMBER = "00123456789";
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < cnNumberStr.length(); i++) {
			char c = cnNumberStr.charAt(i);
			int index = ALL_CN_NUMBER.indexOf(c);
			if (index != -1) {
				buf.append(ALL_NUMBER.charAt(index));
			} else {
				buf.append(cnNumberStr.charAt(i));
			}
		}
		return buf.toString();
	}
}
