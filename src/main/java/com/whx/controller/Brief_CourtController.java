package com.whx.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.whx.entities.Brief;
import com.whx.entities.Court;
import com.whx.service.BriefService;
import com.whx.service.CourtService;

@Controller
public class Brief_CourtController {

	@Autowired
	private BriefService briefService;

	@Autowired
	private CourtService courtService;

	@RequestMapping(value = "/briefInput")
	public String briefInput() {
		return "uploadBriefForm";
	}

	@RequestMapping(value = "/courtInput")
	public String courtInput() {
		return "uploadCourtForm";
	}

	// 上传的文件会被自动绑定到MultipartFile中
	@RequestMapping(value = "/uploadBrief", method = RequestMethod.POST)
	// public String upload(HttpServletRequest request, @RequestParam("description")
	// String description,@RequestParam("file") MultipartFile file) throws Exception
	// {
	public String uploadBrief(@RequestParam("file") MultipartFile uploadFile) throws Exception {
		if (uploadFile.getSize() > 0) {
			String fileName = uploadFile.getOriginalFilename();
			fileName = fileName.toLowerCase();
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

	// 上传的文件会被自动绑定到MultipartFile中
	@RequestMapping(value = "/uploadCourt", method = RequestMethod.POST)
	public String uploadCourt(@RequestParam("file") MultipartFile uploadFile) throws Exception {
		uploadHigherCourt(uploadFile);
		uploadLowerCourt(uploadFile);
		return "success";
	}

	// 本方法把最高人民法院、省高级人民法院和市中级人民法院写入数据库
	private void uploadHigherCourt(MultipartFile uploadFile) throws IOException {
		if (uploadFile.getSize() > 0) {
			String fileName = uploadFile.getOriginalFilename();
			InputStream in = uploadFile.getInputStream();// 载入文档
			if (fileName.toLowerCase().endsWith("docx")) {
				XWPFDocument xwpf = new XWPFDocument(in);// 得到word文档的信息
				Iterator<XWPFTable> it = xwpf.getTablesIterator();// 得到word中的表格
				while (it.hasNext()) {
					XWPFTable table = it.next();
					List<XWPFTableRow> rows = table.getRows();
					// 读取每一行数据
					for (int i = 0; i < rows.size(); i++) {
						XWPFTableRow row = rows.get(i);// 读取当前行

						List<XWPFTableCell> cells = row.getTableCells();// 当前行所有的列
						assert (cells.size() >= 2);// 列数必须是2及以上
						XWPFTableCell courtName = cells.get(0);// 读取法院名称
						XWPFTableCell courtCode = cells.get(1);// 读取法院代字
						String regexStr = "^(最高法)|(([京津冀晋内辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川黔云藏陕甘青宁新兵])(\\d{2})?)$";
						Pattern pattern = Pattern.compile(regexStr);
						Matcher matcher = pattern.matcher(courtCode.getText());

						if (matcher.find()) {
							if ((matcher.group(1) != null) && (matcher.group(1).equals("最高法"))) {// 最高人民法院
								Court court = new Court();
								court.setCourtCode(courtCode.getText());
								court.setName(courtName.getText());

								courtService.addCourt(court);
							}
							if ((matcher.group(3) != null) && (matcher.group(4) == null)) {// 省高级人民法院
								Court court = new Court();
								court.setCourtCode(courtCode.getText());
								court.setName(courtName.getText());
								court.setCourt(courtService.getCourt("最高法"));

								courtService.addCourt(court);
							}
							if ((matcher.group(3) != null) && (matcher.group(4) != null)) {// 市中级人民法院
								Court court = new Court();
								court.setCourtCode(courtCode.getText());
								court.setName(courtName.getText());
								court.setCourt(courtService.getCourt(matcher.group(3)));

								courtService.addCourt(court);
							}
						}
					}// for loop end.
				} // while loop end.
				xwpf.close();
			}
		}
	}

	// 本方法把基层人民法院写入数据库
	private void uploadLowerCourt(MultipartFile uploadFile) throws IOException {
		if (uploadFile.getSize() > 0) {
			String fileName = uploadFile.getOriginalFilename();
			InputStream in = uploadFile.getInputStream();// 载入文档
			if (fileName.toLowerCase().endsWith("docx")) {
				XWPFDocument xwpf = new XWPFDocument(in);// 得到word文档的信息
				Iterator<XWPFTable> it = xwpf.getTablesIterator();// 得到word中的表格
				while (it.hasNext()) {
					XWPFTable table = it.next();
					List<XWPFTableRow> rows = table.getRows();
					int i = 0;
					while (i < rows.size()) {
						XWPFTableRow row = rows.get(i);// 读取当前行

						List<XWPFTableCell> cells = row.getTableCells();// 得到当前行所有的列
						assert (cells.size() >= 2);// 确保列数必须是2及以上

						XWPFTableCell courtCode = cells.get(1);// 读取法院代字
						String regexStr = "^[京津冀晋内辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川黔云藏陕甘青宁新兵]\\d{2}$";
						Pattern pattern = Pattern.compile(regexStr);
						Matcher matcher = pattern.matcher(courtCode.getText());
						if (matcher.find()) {// 定位到中院
							while (i < (rows.size() - 1)) {// 防止边界溢出
								XWPFTableRow rowL = rows.get(++i);// 获取中院下面的一行
								List<XWPFTableCell> cellsL = rowL.getTableCells();

								assert (cellsL.size() >= 2);// 确保列数必须是2及以上
								XWPFTableCell courtNameL = cellsL.get(0);// 读取法院名称
								XWPFTableCell courtCodeL = cellsL.get(1);// 读取法院代字
								String regexStrL = "^[京津冀晋内辽吉黑沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川黔云藏陕甘青宁新兵]\\d{4}$";
								Pattern patternL = Pattern.compile(regexStrL);
								Matcher matcherL = patternL.matcher(courtCodeL.getText());
								if (matcherL.find()) {
									Court court = new Court();
									court.setCourtCode(courtCodeL.getText());
									court.setName(courtNameL.getText());
									court.setCourt(courtService.getCourt(courtCode.getText()));

									courtService.addCourt(court);
								} else
									break;
							}
						} else
							i++;
					} // inner while loop end.
				} // outer while loop end.
				xwpf.close();
			}
		}
	}
}
