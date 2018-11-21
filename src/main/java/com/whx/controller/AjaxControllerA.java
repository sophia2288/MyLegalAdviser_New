package com.whx.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.whx.converter.CnDate2Date;

@Controller
public class AjaxControllerA {
	
	@RequestMapping(value = "/ajaxTestA", method = RequestMethod.POST, produces = "html/text;charset=UTF-8")
	public @ResponseBody String ajaxTest(@RequestParam(value = "wordfile", required = false) MultipartFile file,
			HttpServletResponse response) throws IOException {
		String wordText = "";
		String noSpaceDocStr = "";
		String rtnStr = "";

		InputStream inStream = null;
		XWPFDocument xwpf = null;
		XWPFWordExtractor we = null;

		String strOfBrief = "";// 用于存放从文本中提取出的类似“原告张三因与被告李四民间借贷纠纷一案”这一句，里面包含有案由

		try {
			// String fileName = file.getOriginalFilename();
			inStream = file.getInputStream();
			xwpf = new XWPFDocument(inStream);// 得到word文档的信息
			we = new XWPFWordExtractor(xwpf);
			wordText = we.getText();// 取得文档中所有的文本
			// 取得文本后，要对其进行简单的全局替换：
			// 1.将英文小括号替换为中文小括号，即将“(”替换为“（”，将“)”替换为“）”；
			// 2.将“[”、“【”统一替换为“（”，将“]”、“】”统一替换为“）”；
			// 3.将“,”替换为“，”；
			// 4.将“:”替换为“：”；
			// 5.将“;”替换为“；”；
			// 6.去掉空格。
			// 作上述替换后，方可应用正则表达式对文本进行处理。
			noSpaceDocStr = wordText.replaceAll(" ", "");// 去掉文本中的空格（按下Space键产生的一般空格）
			noSpaceDocStr = noSpaceDocStr.replaceAll("　", "");// 去掉文本中的空格（特殊空格，较一般空格宽）
			// noSpaceStr = noSpaceStr.replaceAll("【", "（");// 替换
			// noSpaceStr = noSpaceStr.replaceAll("】", "）");// 替换

			Map<String, String> mapOfDocInfo = new HashMap<String, String>();
			mapOfDocInfo.put("source", "中国裁判文书网");

			String regexStrOfBrief = "(原告|被告|上诉人|被上诉人|再审申请人|申请再审人|被申请人|原审原告|原审被告|申诉人|被申诉人|申请人)?(([\\u4e00-\\u9fa5][a-zA-Z（）Ｘ\"“”]*[、,，]?)+)(与|诉)(原告|被告|上诉人|被上诉人|再审申请人|申请再审人|被申请人|原审原告|原审被告|申诉人|被申诉人|申请人)(([\\u4e00-\\u9fa5][a-zA-Z（）Ｘ\"“”]*[、,，]?)+)([,，、](原审)?第三人(([\\u4e00-\\u9fa5][a-zA-Z（）Ｘ\"“”]*[、,，]?)+))?([\\u4e00-\\u9fa5]{4,40})一案";
			Pattern pattern = Pattern.compile(regexStrOfBrief);
			Matcher matcher = pattern.matcher(noSpaceDocStr);

			int startOfBriefMatcher = noSpaceDocStr.length() - 1;
			if (matcher.find()) {
				startOfBriefMatcher = matcher.start();// 取得文书中类似于“原告张三因与被告李四民间借贷纠纷一案”这句话的第一个字符在整个文本中的位置
				strOfBrief = matcher.group();
			}

			String regexStrOfcourt_caseNo = "^((北京市|上海市|天津市|重庆市|河北省|黑龙江省|吉林省|辽宁省|内蒙古自治区|山西省|江苏省|浙江省|安徽省|福建省|江西省|山东省|河南省|湖北省|湖南省|广东省|广西壮族自治区|海南省|四川省|贵州省|云南省|西藏自治区|陕西省|甘肃省|青海省|宁夏回族自治区|新疆维吾尔自治区|新疆建设兵团)?[\\u4e00-\\u9fa5]{1,20}人民法院)\\n+(([民]\\s*事\\s*)(判\\s*决\\s*书|裁\\s*定\\s*书))\\n+((([\\[〔（]19\\d{2}[\\]）〕]|[\\[〔（]20\\d{2}[\\]）〕])[\\u4e00-\\u9fa5]{1,8}[民商][一二三四外]?[初重]字第\\d{1,5}(-\\d{1})?号)|(（201[56789]）[京津冀黑吉辽内晋沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川黔云藏陕甘青宁新兵]((\\d{2})|(\\d{4}))?民初\\d{1,5}号))";
			matcher.usePattern(Pattern.compile(regexStrOfcourt_caseNo));
			matcher.region(0, startOfBriefMatcher);// 将提取法院名称、案号等操作的匹配范围限定在文本的开头至startOfBriefMatcher范围内，但不包括startOfBriefMatcher处的字符。裁判文书的格式（结构）决定了应该这样处理。
			if (matcher.find()) { // 匹配一审民事案件
				mapOfDocInfo.put("court", matcher.group(1)); // 提取法院名称
				mapOfDocInfo.put("proceeding", "一审"); // 提取诉讼程序
				mapOfDocInfo.put("caseNo", matcher.group(6)); // 提取案号
				//map.put("category", matcher.group(4).replaceAll("\\s*", ""));// 提取案件类型
				if("民事".equals(matcher.group(4).replaceAll("\\s*", ""))) {
					mapOfDocInfo.put("category", "民商事");// 提取案件类型
				}
				
				mapOfDocInfo.put("docCategory", matcher.group(5).replaceAll("\\s*", ""));// 提取文书类型

				// 以下代码用于提取一审案件中的当事人
				String regexStrOfLitigant = "(原告([\\(（]反诉被告[）\\)])?|被告([\\(（]反诉原告[）\\)])?|第三人)[：:]?(([\\u4e00-\\u9fa5][a-zA-Z（）()Ｘ]*){1,60})[,，。]?";
				matcher.usePattern(Pattern.compile(regexStrOfLitigant));
				// matcher.reset();
				matcher.region(0, startOfBriefMatcher);// 将提取当事人的匹配范围限定在文本的开头至startOfBriefMatcher范围内，但不包括startOfBriefMatcher处的字符。限定匹配范围对正确提取当事人信息很有必要。
				String dangShiRen = "", yuanGao = "", beiGao = "", diSanRen = "";
				String title = "";// 案件名称
				while (matcher.find()) {
					if (matcher.group(4).contains("代理"))
						continue;
					if (yuanGao.contains(matcher.group(4)) || beiGao.contains(matcher.group(4)) || diSanRen.contains(matcher.group(4)))
						continue;
					if (matcher.group(1).contains("原告")) {
						yuanGao = yuanGao + matcher.group(4) + "、";
						strOfBrief = strOfBrief.replaceAll(matcher.group(4), "@");
						continue;
					}
					if (matcher.group(1).contains("被告")) {
						beiGao = beiGao + matcher.group(4) + "、";
						strOfBrief = strOfBrief.replaceAll(matcher.group(4), "@");
						continue;
					}
					if (matcher.group(1).contains("第三人")) {
						diSanRen = diSanRen + matcher.group(4) + "、";
						strOfBrief = strOfBrief.replaceAll(matcher.group(4), "@");
						continue;
					}
				}
				
				dangShiRen = yuanGao + beiGao + diSanRen;
				mapOfDocInfo.put("litigant", dangShiRen.substring(0, dangShiRen.length() - 1));

				// 以下代码提取案由，仔细琢磨
				strOfBrief = strOfBrief.replaceAll("[\\(\\[（]((以下)?简称|下称)(([\\u4e00-\\u9fa5]?[0-9a-zA-ZＸ\"“”]*){1,30})[\\)\\]）]", "");
				int indexOfBriefBegin = strOfBrief.lastIndexOf("@");
				int indexOfBriefEnd = strOfBrief.lastIndexOf("一案");
				strOfBrief = strOfBrief.substring(indexOfBriefBegin + 1, indexOfBriefEnd);
				mapOfDocInfo.put("brief", strOfBrief);
				
				// 当事人加案由就构成了案件名称
				title = yuanGao.substring(0, yuanGao.length()-1) + "与" + beiGao.substring(0, beiGao.length()-1) + strOfBrief;
				mapOfDocInfo.put("title", title);
				
				// 以下代码提取裁判日期。一般情况下，文书中有很多日期，以下代码确保只提取文书的裁判日期。
				String regexStrOfJudge_JudgeDate = "((((([代助]理)?审判[长员]|人民陪审员)([\\u4e00-\\u9fa5]{2,6}))\\n+)+)(((一九|二〇)[一二三四五六七八九〇]{2})年([一二三四五六七八九十]|十一|十二)月([一二三四五六七八九十]{1,3})日)\\n+(代?书记员([\\u4e00-\\u9fa5]{2,6}))";
				matcher.usePattern(Pattern.compile(regexStrOfJudge_JudgeDate));
				matcher.reset();// 将匹配范围重新设置为整个文本
				if(matcher.find()) {
					Date cpDate = CnDate2Date.convertCnDate(matcher.group(7));
					mapOfDocInfo.put("judgeDate", new SimpleDateFormat("yyyy-MM-dd").format(cpDate));
					
					// 以下代码提取审判员
					String judges = "";
					int startPos = matcher.regionStart();
					int endPos = matcher.regionEnd();
					String regexStrOfJudge = "((([代助]理)?审判[长员]|人民陪审员)([\\u4e00-\\u9fa5]{2,6}))\\n+";
					matcher.usePattern(Pattern.compile(regexStrOfJudge));
					matcher.region(startPos, endPos);//
					while(matcher.find()) {
						judges = judges + matcher.group(4) + "（" + matcher.group(2) + "）" + "，";
					}
					mapOfDocInfo.put("judge", judges.substring(0, judges.length() - 1));
				}
			}

			regexStrOfcourt_caseNo = "^((北京市|上海市|天津市|重庆市|河北省|黑龙江省|吉林省|辽宁省|内蒙古自治区|山西省|江苏省|浙江省|安徽省|福建省|江西省|山东省|河南省|湖北省|湖南省|广东省|广西壮族自治区|海南省|四川省|贵州省|云南省|西藏自治区|陕西省|甘肃省|青海省|宁夏回族自治区|新疆维吾尔自治区|新疆建设兵团)?[\\u4e00-\\u9fa5]{1,20}人民法院)\\n+(([民]\\s*事\\s*)(判\\s*决\\s*书|裁\\s*定\\s*书))\\n+((([\\[〔（]19\\d{2}[\\]）〕]|[\\[〔（]20\\d{2}[\\]）〕])[\\u4e00-\\u9fa5]{0,7}[民商][一二三四]?终字第\\d{1,5}(-\\d{1})?号)|(（201[56789]）[京津冀黑吉辽内晋沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川黔云藏陕甘青宁新兵]((\\d{2})|(\\d{4}))?民终\\d{1,5}号))";
			matcher.usePattern(Pattern.compile(regexStrOfcourt_caseNo));
			matcher.region(0, startOfBriefMatcher);// 将提取法院名称、案号等操作的匹配范围限定在文本的开头至startOfMatch范围内，但不包括startOfMatch处的字符
			if (matcher.find()) {// 匹配二审民事案件

			}

			regexStrOfcourt_caseNo = "^((北京市|上海市|天津市|重庆市|河北省|黑龙江省|吉林省|辽宁省|内蒙古自治区|山西省|江苏省|浙江省|安徽省|福建省|江西省|山东省|河南省|湖北省|湖南省|广东省|广西壮族自治区|海南省|四川省|贵州省|云南省|西藏自治区|陕西省|甘肃省|青海省|宁夏回族自治区|新疆维吾尔自治区|新疆建设兵团)?[\\u4e00-\\u9fa5]{1,20}人民法院)\\n+(([民]\\s*事\\s*)(判\\s*决\\s*书|裁\\s*定\\s*书))\\n+((([\\[〔（]19\\d{2}[\\]）〕]|[\\[〔（]20\\d{2}[\\]）〕])[\\u4e00-\\u9fa5]{0,7}[民商][一二三四]?((再[初终]?)|抗|提)字第\\d{1,5}(-\\d{1})?号)|(（201[56789]）[京津冀黑吉辽内晋沪苏浙皖闽赣鲁豫鄂湘粤桂琼渝川黔云藏陕甘青宁新兵]((\\d{2})|(\\d{4}))?民[再抗]\\d{1,5}号))";
			matcher.usePattern(Pattern.compile(regexStrOfcourt_caseNo));
			// matcher.reset();
			matcher.region(0, startOfBriefMatcher);// 将提取法院名称、案号等操作的匹配范围限定在文本的开头至startOfMatch范围内，但不包括startOfMatch处的字符
			if (matcher.find()) { // 匹配再审民事案件
				mapOfDocInfo.put("court", matcher.group(1));// 提取法院名称
				mapOfDocInfo.put("proceeding", "再审");// 提取诉讼程序
				mapOfDocInfo.put("caseNo", matcher.group(6));// 提取案号
				if("民事".equals(matcher.group(4).replaceAll("\\s*", ""))) {
					mapOfDocInfo.put("category", "民商事");// 提取案件类型
				}
				mapOfDocInfo.put("docCategory", matcher.group(5).replaceAll("\\s*", ""));// 提取文书类型
			}

			rtnStr = JSON.toJSONString(mapOfDocInfo);
			mapOfDocInfo.clear();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			we.close();
			xwpf.close();
			inStream.close();
		}

		return rtnStr;
	}
}
