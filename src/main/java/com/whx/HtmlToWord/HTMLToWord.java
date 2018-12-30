package com.whx.HtmlToWord;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLToWord {
	public static void main(String[] args) {
		//String url = "http://www.court.gov.cn/fabu-xiangqing-14866.html";
		String url = "http://www.court.gov.cn/susongyangshi-xiangqing-27.html";

		new HTMLToWord().jacob_html2word(url);
	}

	public void jacob_html2word(String url) {
		MSOfficeGeneratorUtils officeUtils = new MSOfficeGeneratorUtils(false); // 将生成过程设置为不可见

		try {
			Connection conn = Jsoup.connect(url).timeout(7000);
			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			conn.header("Accept-Encoding", "gzip, deflate, sdch");
			conn.header("Accept-Language", "zh-CN,zh;q=0.8");
			conn.header("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

			Document document = conn.get();

			// 忽略原始html文档中的图片，只提取文本和表格

			// 将html代码写到html文件中
			FileWriter fw = new FileWriter("D:\\template.html");
			fw.write(document.html(), 0, document.html().length());// 写入文件
			fw.flush();
			fw.close();

			String newFileName = "D:\\" + String.valueOf(System.currentTimeMillis()) + ".doc";
			// 这里模板不动，复制了一个副本用于写入数据
			FileUtils.copyFile(new File("D:\\template.doc"), new File(newFileName));
			// html文件转为word
			officeUtils.html2Word("D:\\template.html", newFileName);

			officeUtils.saveAs(newFileName); // 保存文档
			officeUtils.close(); // 关闭Office Word创建的文档
			officeUtils.quit(); // 退出Office Word程序
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}