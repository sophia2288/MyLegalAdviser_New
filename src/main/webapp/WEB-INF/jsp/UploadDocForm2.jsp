<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>裁判文书录入</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/datepicker/My97DatePicker/WdatePicker.js"></script>
<!-- <link rel="stylesheet" href="jquery-ui.min.css"> -->
<style type="text/css">@import url("<c:url value="/jquery-ui-1.12.1/jquery-ui.min.css"/>");</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-ui-1.12.1/external/jquery/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script>
  $( function() {
    var availableTags = [
    	{ label: "生命权、健康权、身体权纠纷", value: "001001001" },
    	{ label: "姓名权纠纷", value: "001001002" },
    	{ label: "肖像权纠纷", value: "001001003" },
    	{ label: "名誉权纠纷", value: "001001004" },
    	{ label: "荣誉权纠纷", value: "001001005" },
    	{ label: "隐私权纠纷", value: "001001006" },
    	{ label: "婚姻自主权纠纷", value: "001001007" },
    	{ label: "人身自由权纠纷", value: "001001008" },
    	{ label: "一般人格权纠纷", value: "001001009" },
    	{ label: "婚姻家庭纠纷", value: "002001" },
    	{ label: "婚约财产纠纷", value: "002001001" },
    	{ label: "离婚纠纷", value: "002001002" },
    	{ label: "离婚后财产纠纷", value: "002001003" },
    	{ label: "离婚后损害责任纠纷", value: "002001004" },
    	{ label: "婚姻无效纠纷", value: "002001005" },
    	{ label: "撤销婚姻纠纷", value: "002001006" },
    	{ label: "夫妻财产约定纠纷", value: "002001007" },
    	{ label: "同居关系纠纷", value: "002001008" },
    	{ label: "同居关系析产纠纷", value: "002001008001" },
    	{ label: "同居关系子女抚养纠纷", value: "002001008002" },
    	{ label: "抚养纠纷", value: "002001009" },
    	{ label: "抚养费纠纷", value: "002001009001" },
    	{ label: "变更抚养关系纠纷", value: "002001009002" },
    	{ label: "扶养纠纷", value: "002001010" },
    	{ label: "扶养费纠纷", value: "002001010001" },
    	{ label: "变更扶养关系纠纷", value: "002001010002" },
    	{ label: "赡养纠纷", value: "002001011" },
    	{ label: "赡养费纠纷", value: "002001011001" },
    	{ label: "变更赡养关系纠纷", value: "002001011002" },
    	{ label: "收养关系纠纷", value: "002001012" },
    	{ label: "确认收养关系纠纷", value: "002001012001" },
    	{ label: "解除收养关系纠纷", value: "002001012002" },
    	{ label: "监护权纠纷", value: "002001013" },
    	{ label: "探望权纠纷", value: "002001014" },
    	{ label: "分家析产纠纷", value: "002001015" },
    	{ label: "继承纠纷", value: "002002" },
    	{ label: "法定继承纠纷", value: "002002001" },
    	{ label: "转继承纠纷", value: "002002001001" },
    	{ label: "代位继承纠纷", value: "002002001002" },
    	{ label: "遗嘱继承纠纷", value: "002002002" },
    	{ label: "被继承人债务清偿纠纷", value: "002002003" },
    	{ label: "遗赠纠纷", value: "002002004" },
    	{ label: "遗赠扶养协议纠纷", value: "002002005" },
    	{ label: "不动产登记纠纷", value: "003001" },
    	{ label: "异议登记不当损害责任纠纷", value: "003001001" },
    	{ label: "虚假登记损害责任纠纷", value: "003001002" },
    	{ label: "物权保护纠纷", value: "003002" },
    	{ label: "物权确认纠纷", value: "003002001" },
    	{ label: "所有权确认纠纷", value: "003002001001" },
    	{ label: "用益物权确认纠纷", value: "003002001002" },
    	{ label: "担保物权确认纠纷", value: "003002001003" },
    	{ label: "返还原物纠纷", value: "003002002" },
    	{ label: "排除妨害纠纷", value: "003002003" },
    	{ label: "消除危险纠纷", value: "003002004" },
    	{ label: "修理、重作、更换纠纷", value: "003002005" },
    	{ label: "恢复原状纠纷", value: "003002006" },
    	{ label: "财产损害赔偿纠纷", value: "003002007" },
    	{ label: "所有权纠纷", value: "003003" },
    	{ label: "侵害集体经济组织成员权益纠纷", value: "003003001" },
    	{ label: "建筑物区分所有权纠纷", value: "003003002" },
    	{ label: "业主专有权纠纷", value: "003003002001" },
    	{ label: "业主共有权纠纷", value: "003003002002" },
    	{ label: "车位纠纷", value: "003003002003" },
    	{ label: "车库纠纷", value: "003003002004" },
    	{ label: "业主撤销权纠纷", value: "003003003" },
    	{ label: "业主知情权纠纷", value: "003003004" },
    	{ label: "遗失物返还纠纷", value: "003003005" },
    	{ label: "漂流物返还纠纷", value: "003003006" },
    	{ label: "埋藏物返还纠纷", value: "003003007" },
    	{ label: "隐藏物返还纠纷", value: "003003008" },
    	{ label: "相邻关系纠纷", value: "003003009" },
    	{ label: "相邻用水、排水纠纷", value: "003003009001" },
    	{ label: "相邻通行纠纷", value: "003003009002" },
    	{ label: "相邻土地、建筑物利用关系纠纷", value: "003003009003" },
    	{ label: "相邻通风纠纷", value: "003003009004" },
    	{ label: "相邻采光、日照纠纷", value: "003003009005" },
    	{ label: "相邻污染侵害纠纷", value: "003003009006" },
    	{ label: "相邻损害防免关系纠纷", value: "003003009007" },
    	{ label: "共有纠纷", value: "003003010" },
    	{ label: "共有权确认纠纷", value: "003003010001" },
    	{ label: "共有物分割纠纷", value: "003003010002" },
    	{ label: "共有人优先购买权纠纷", value: "003003010003" },
    	{ label: "用益物权纠纷", value: "003004" },
    	{ label: "海域使用权纠纷", value: "003004001" },
    	{ label: "探矿权纠纷", value: "003004002" },
    	{ label: "采矿权纠纷", value: "003004003" },
    	{ label: "取水权纠纷", value: "003004004" },
    	{ label: "养殖权纠纷", value: "003004005" },
    	{ label: "捕捞权纠纷", value: "003004006" },
    	{ label: "土地承包经营权纠纷", value: "003004007" },
    	{ label: "土地承包经营权确认纠纷", value: "003004007001" },
    	{ label: "承包地征收补偿费用分配纠纷", value: "003004007002" },
    	{ label: "土地承包经营权继承纠纷", value: "003004007003" },
    	{ label: "建设用地使用权纠纷", value: "003004008" },
    	{ label: "宅基地使用权纠纷", value: "003004009" },
    	{ label: "地役权纠纷", value: "003004010" },
    	{ label: "担保物权纠纷", value: "003005" },
    	{ label: "抵押权纠纷", value: "003005001" },
    	{ label: "建筑物和其他土地附着物抵押权纠纷", value: "003005001001" },
    	{ label: "在建建筑物抵押权纠纷", value: "003005001002" },
    	{ label: "建设用地使用权抵押权纠纷", value: "003005001003" },
    	{ label: "土地承包经营权抵押权纠纷", value: "003005001004" },
    	{ label: "动产抵押权纠纷", value: "003005001005" },
    	{ label: "在建船舶、航空器抵押权纠纷", value: "003005001006" },
    	{ label: "动产浮动抵押权纠纷", value: "003005001007" },
    	{ label: "最高额抵押权纠纷", value: "003005001008" },
    	{ label: "质权纠纷", value: "003005002" },
    	{ label: "动产质权纠纷", value: "003005002001" },
    	{ label: "转质权纠纷", value: "003005002002" },
    	{ label: "最高额质权纠纷", value: "003005002003" },
    	{ label: "票据质权纠纷", value: "003005002004" },
    	{ label: "债券质权纠纷", value: "003005002005" },
    	{ label: "存单质权纠纷", value: "003005002006" },
    	{ label: "仓单质权纠纷", value: "003005002007" },
    	{ label: "提单质权纠纷", value: "003005002008" },
    	{ label: "股权质权纠纷", value: "003005002009" },
    	{ label: "基金份额质权纠纷", value: "003005002010" },
    	{ label: "知识产权质权纠纷", value: "003005002011" },
    	{ label: "应收账款质权纠纷", value: "003005002012" },
    	{ label: "留置权纠纷", value: "003005003" },
    	{ label: "占有保护纠纷", value: "003006" },
    	{ label: "占有物返还纠纷", value: "003006001" },
    	{ label: "占有排除妨害纠纷", value: "003006002" },
    	{ label: "占有消除危险纠纷", value: "003006003" },
    	{ label: "占有物损害赔偿纠纷", value: "003006004" },
    	{ label: "合同纠纷", value: "004001" },
    	{ label: "缔约过失责任纠纷", value: "004001001" },
    	{ label: "确认合同效力纠纷", value: "004001002" },
    	{ label: "确认合同有效纠纷", value: "004001002001" },
    	{ label: "确认合同无效纠纷", value: "004001002002" },
    	{ label: "债权人代位权纠纷", value: "004001003" },
    	{ label: "债权人撤销权纠纷", value: "004001004" },
    	{ label: "债权转让合同纠纷", value: "004001005" },
    	{ label: "债务转移合同纠纷", value: "004001006" },
    	{ label: "债权债务概括转移合同纠纷", value: "004001007" },
    	{ label: "悬赏广告纠纷", value: "004001008" },
    	{ label: "买卖合同纠纷", value: "004001009" },
    	{ label: "分期付款买卖合同纠纷", value: "004001009001" },
    	{ label: "凭样品买卖合同纠纷", value: "004001009002" },
    	{ label: "试用买卖合同���纷", value: "004001009003" },
    	{ label: "互易纠纷", value: "004001009004" },
    	{ label: "国际货物买卖合同纠纷", value: "004001009005" },
    	{ label: "网络购物合同纠纷", value: "004001009006" },
    	{ label: "电视购物合同纠纷", value: "004001009007" },
    	{ label: "招标投标买卖合同纠纷", value: "004001010" },
    	{ label: "拍卖合同纠纷", value: "004001011" },
    	{ label: "建设用地使用权合同纠纷", value: "004001012" },
    	{ label: "建设用地使用权出让合同纠纷", value: "004001012001" },
    	{ label: "建设用地使用权转让合同纠纷", value: "004001012002" },
    	{ label: "临时用地合同纠纷", value: "004001013" },
    	{ label: "探矿权转让合同纠纷", value: "004001014" },
    	{ label: "采矿权转让合同纠纷", value: "004001015" },
    	{ label: "房地产开发经营合同纠纷", value: "004001016" },
    	{ label: "委托代建合同纠纷", value: "004001016001" },
    	{ label: "合资、合作开发房地产合同纠纷", value: "004001016002" },
    	{ label: "项目转让合同纠纷", value: "004001016003" },
    	{ label: "房屋买卖合同纠纷", value: "004001017" },
    	{ label: "商品房预约合同纠纷", value: "004001017001" },
    	{ label: "商品房预售合同纠纷", value: "004001017002" },
    	{ label: "商品房销售合同纠纷", value: "004001017003" },
    	{ label: "商品房委托代理销售合同纠纷", value: "004001017004" },
    	{ label: "经济适用房转让合同纠纷", value: "004001017005" },
    	{ label: "农村房屋买卖合同纠纷", value: "004001017006" },
    	{ label: "房屋拆迁安置补偿合同纠纷", value: "004001018" },
    	{ label: "供用电合同纠纷", value: "004001019" },
    	{ label: "供用水合同纠纷", value: "004001020" },
    	{ label: "供用气合同纠纷", value: "004001021" },
    	{ label: "供用热力合同纠纷", value: "004001022" },
    	{ label: "赠与合同纠纷", value: "004001023" },
    	{ label: "公益事业捐赠合同纠纷", value: "004001023001" },
    	{ label: "附义务赠与合同纠纷", value: "004001023002" },
    	{ label: "借款合同纠纷", value: "004001024" },
    	{ label: "金融借款合同纠纷", value: "004001024001" },
    	{ label: "同业拆借纠纷", value: "004001024002" },
    	{ label: "企业借贷纠纷", value: "004001024003" },
    	{ label: "民间借贷纠纷", value: "004001024004" },
    	{ label: "小额借款合同纠纷", value: "004001024005" },
    	{ label: "金融不良债权转让合同纠纷", value: "004001024006" },
    	{ label: "金融不良债权追偿纠纷", value: "004001024007" },
    	{ label: "保证合同纠纷", value: "004001025" },
    	{ label: "抵押合同纠纷", value: "004001026" },
    	{ label: "质押合同纠纷", value: "004001027" },
    	{ label: "定金合同纠纷", value: "004001028" },
    	{ label: "进出口押汇纠纷", value: "004001029" },
    	{ label: "储蓄存款合同纠纷", value: "004001030" },
    	{ label: "银行卡纠纷", value: "004001031" },
    	{ label: "借记卡纠纷", value: "004001031001" },
    	{ label: "信用卡纠纷", value: "004001031002" },
    	{ label: "租赁合同纠纷", value: "004001032" },
    	{ label: "土地租赁合同纠纷", value: "004001032001" },
    	{ label: "房屋租赁合同纠纷", value: "004001032002" },
    	{ label: "车辆租赁合同纠纷", value: "004001032003" },
    	{ label: "建筑设备租赁合同纠纷", value: "004001032004" },
    	{ label: "融资租赁合同纠纷", value: "004001033" },
    	{ label: "承揽合同纠纷", value: "004001034" },
    	{ label: "加工合同纠纷", value: "004001034001" },
    	{ label: "定作合同纠纷", value: "004001034002" },
    	{ label: "修理合同纠纷", value: "004001034003" },
    	{ label: "复制合同纠纷", value: "004001034004" },
    	{ label: "测试合同纠纷", value: "004001034005" },
    	{ label: "检验合同纠纷", value: "004001034006" },
    	{ label: "铁路机车、车辆建造合同纠纷", value: "004001034007" },
    	{ label: "建设工程合同纠纷", value: "004001035" },
    	{ label: "建设工程勘察合同纠纷", value: "004001035001" },
    	{ label: "建设工程设计合同纠纷", value: "004001035002" },
    	{ label: "建设工程施工合同纠纷", value: "004001035003" },
    	{ label: "建设工程价款优先受偿权纠纷", value: "004001035004" },
    	{ label: "建设工程分包合同纠纷", value: "004001035005" },
    	{ label: "建设工程监理合同纠纷", value: "004001035006" },
    	{ label: "装饰装修合同纠纷", value: "004001035007" },
    	{ label: "铁路修建合同纠纷", value: "004001035008" },
    	{ label: "农村建房施工合同纠纷", value: "004001035009" },
    	{ label: "运输合同纠纷", value: "004001036" },
    	{ label: "公路旅客运输合同纠纷", value: "004001036001" },
    	{ label: "公路货物运输合同纠纷", value: "004001036002" },
    	{ label: "水路旅客运输合同纠纷", value: "004001036003" },
    	{ label: "水路货物运输合同纠纷", value: "004001036004" },
    	{ label: "航空旅客运输合同纠纷", value: "004001036005" },
    	{ label: "航空货物运输合同纠纷", value: "004001036006" },
    	{ label: "出租汽车运输合同纠纷", value: "004001036007" },
    	{ label: "管道运输合同纠纷", value: "004001036008" },
    	{ label: "城市公交运输合同纠纷", value: "004001036009" },
    	{ label: "联合运输合同纠纷", value: "004001036010" },
    	{ label: "多式联运合同纠纷", value: "004001036011" },
    	{ label: "铁路货物运输合同纠纷", value: "004001036012" },
    	{ label: "铁路旅客运输合同纠纷", value: "004001036013" },
    	{ label: "铁路行李运输合同纠纷", value: "004001036014" },
    	{ label: "铁路包裹运输合同纠纷", value: "004001036015" },
    	{ label: "国际铁路联运合同纠纷", value: "004001036016" },
    	{ label: "保管合同纠纷", value: "004001037" },
    	{ label: "仓储合同纠纷", value: "004001038" },
    	{ label: "委托合同纠纷", value: "004001039" },
    	{ label: "进出口代理合同纠纷", value: "004001039001" },
    	{ label: "货运代理合同纠纷", value: "004001039002" },
    	{ label: "民用航空运输销售代理合同纠纷", value: "004001039003" },
    	{ label: "诉讼、仲裁、人民调解代理合同纠纷", value: "004001039004" },
    	{ label: "委托理财合同纠纷", value: "004001040" },
    	{ label: "金融委托理财合同纠纷", value: "004001040001" },
    	{ label: "民间委托理财合同纠纷", value: "004001040002" },
    	{ label: "行纪合同纠纷", value: "004001041" },
    	{ label: "居间合同纠纷", value: "004001042" },
    	{ label: "补偿贸易纠纷", value: "004001043" },
    	{ label: "借用合同纠纷", value: "004001044" },
    	{ label: "典当纠纷", value: "004001045" },
    	{ label: "合伙协议纠纷", value: "004001046" },
    	{ label: "种植、养殖回收合同纠纷", value: "004001047" },
    	{ label: "彩票、奖券纠纷", value: "004001048" },
    	{ label: "中外合作勘探开发自然资源合同纠纷", value: "004001049" },
    	{ label: "农业承包合同纠纷", value: "004001050" },
    	{ label: "林业承包合同纠纷", value: "004001051" },
    	{ label: "渔业承包合同纠纷", value: "004001052" },
    	{ label: "牧业承包合同纠纷", value: "004001053" },
    	{ label: "农村土地承包合同纠纷", value: "004001054" },
    	{ label: "土地承包经营权转包合同纠纷", value: "004001054001" },
    	{ label: "土地承包经营权转让合同纠纷", value: "004001054002" },
    	{ label: "土地承包经营权互换合同纠纷", value: "004001054003" },
    	{ label: "土地承包经营权入股合同纠纷", value: "004001054004" },
    	{ label: "土地承包经营权抵押合同纠纷", value: "004001054005" },
    	{ label: "土地承包经营权出租合同纠纷", value: "004001054006" },
    	{ label: "服务合同纠纷", value: "004001055" },
    	{ label: "电信服务合同纠纷", value: "004001055001" },
    	{ label: "邮寄服务合同纠纷", value: "004001055002" },
    	{ label: "医疗服务合同纠纷", value: "004001055003" },
    	{ label: "法律服务合同纠纷", value: "004001055004" },
    	{ label: "旅游合同纠纷", value: "004001055005" },
    	{ label: "房地产咨询合同纠纷", value: "004001055006" },
    	{ label: "房地产价格评估合同纠纷", value: "004001055007" },
    	{ label: "旅店服务合同纠纷", value: "004001055008" },
    	{ label: "财会服务合同纠纷", value: "004001055009" },
    	{ label: "餐饮服务合同纠纷", value: "004001055010" },
    	{ label: "娱乐服务合同纠纷", value: "004001055011" },
    	{ label: "有线电视服务合同纠纷", value: "004001055012" },
    	{ label: "网络服务合同纠纷", value: "004001055013" },
    	{ label: "教育培训合同纠纷", value: "004001055014" },
    	{ label: "物业服务合同纠纷", value: "004001055015" },
    	{ label: "家政服务合同纠纷", value: "004001055016" },
    	{ label: "庆典服务合同纠纷", value: "004001055017" },
    	{ label: "殡葬服务合同纠纷", value: "004001055018" },
    	{ label: "农业技术服务合同纠纷", value: "004001055019" },
    	{ label: "农机作业服务合同纠纷", value: "004001055020" },
    	{ label: "保安服务合同纠纷", value: "004001055021" },
    	{ label: "银行结算合同纠纷", value: "004001055022" },
    	{ label: "演出合同纠纷", value: "004001056" },
    	{ label: "劳务合同纠纷", value: "004001057" },
    	{ label: "离退休人员返聘合同纠纷", value: "004001058" },
    	{ label: "广告合同纠纷", value: "004001059" },
    	{ label: "展览合同纠纷", value: "004001060" },
    	{ label: "追偿权纠纷", value: "004001061" },
    	{ label: "请求确认人民调解协议效力", value: "004001062" },
    	{ label: "不当得利纠纷", value: "004002" },
    	{ label: "不当得利纠纷", value: "004002001" },
    	{ label: "无因管理纠纷", value: "004003" },
    	{ label: "无因管理纠纷", value: "004003001" },
    	{ label: "劳动争议", value: "006001" },
    	{ label: "劳动合同纠纷", value: "006001001" },
    	{ label: "确认劳动关系纠纷", value: "006001001001" },
    	{ label: "集体合同纠纷", value: "006001001002" },
    	{ label: "劳务派遣合同纠纷", value: "006001001003" },
    	{ label: "非全日制用工纠纷", value: "006001001004" },
    	{ label: "追索劳动报酬纠纷", value: "006001001005" },
    	{ label: "经济补偿金纠纷", value: "006001001006" },
    	{ label: "竞业限制纠纷", value: "006001001007" },
    	{ label: "社会保险纠纷", value: "006001002" },
    	{ label: "养老保险待遇纠纷", value: "006001002001" },
    	{ label: "工伤保险待遇纠纷", value: "006001002002" },
    	{ label: "医疗保险待遇纠纷", value: "006001002003" },
    	{ label: "生育保险待遇纠纷", value: "006001002004" },
    	{ label: "失业保险待遇纠纷", value: "006001002005" },
    	{ label: "福利待遇纠纷", value: "006001003" },
    	{ label: "人事争议", value: "006002" },
    	{ label: "人事争议", value: "006002001" },
    	{ label: "辞职争议", value: "006002001001" },
    	{ label: "辞退争议", value: "006002001002" },
    	{ label: "聘用合同争议", value: "006002001003" },
    	{ label: "与企业有关的纠纷", value: "008001" },
    	{ label: "企业出资人权益确认纠纷", value: "008001001" },
    	{ label: "侵害企业出资人权益纠纷", value: "008001002" },
    	{ label: "企业公司制改造合同纠纷", value: "008001003" },
    	{ label: "企业股份合作制改造合同纠纷", value: "008001004" },
    	{ label: "企业债权转股权合同纠纷", value: "008001005" },
    	{ label: "企业分立合同纠纷", value: "008001006" },
    	{ label: "企业租赁经营合同纠纷", value: "008001007" },
    	{ label: "企业出售合同纠纷", value: "008001008" },
    	{ label: "挂靠经营合同纠纷", value: "008001009" },
    	{ label: "企业兼并合同纠纷", value: "008001010" },
    	{ label: "联营合同纠纷", value: "008001011" },
    	{ label: "企业承包经营合同纠纷", value: "008001012" },
    	{ label: "中外合资经营企业承包经营合同纠纷", value: "008001012001" },
    	{ label: "中外合作经营企业承包经营合同纠纷", value: "008001012002" },
    	{ label: "外商独资企业承包经营合同纠纷", value: "008001012003" },
    	{ label: "乡镇企业承包经营合同纠纷", value: "008001012004" },
    	{ label: "中外合资经营企业合同纠纷", value: "008001013" },
    	{ label: "中外合作经营企业合同纠纷", value: "008001014" },
    	{ label: "与公司有关的纠纷", value: "008002" },
    	{ label: "股东资格确认纠纷", value: "008002001" },
    	{ label: "股东名册记载纠纷", value: "008002002" },
    	{ label: "请求变更公司登记纠纷", value: "008002003" },
    	{ label: "股东出资纠纷", value: "008002004" },
    	{ label: "新增资本认购纠纷", value: "008002005" },
    	{ label: "股东知情权纠纷", value: "008002006" },
    	{ label: "请求公司收购股份纠纷", value: "008002007" },
    	{ label: "股权转让纠纷", value: "008002008" },
    	{ label: "公司决议纠纷", value: "008002009" },
    	{ label: "公司决议效力确认纠纷", value: "008002009001" },
    	{ label: "公司决议撤销纠纷", value: "008002009002" },
    	{ label: "公司设立纠纷", value: "008002010" },
    	{ label: "公司证照返还纠纷", value: "008002011" },
    	{ label: "发起人责任纠纷", value: "008002012" },
    	{ label: "公司盈余分配纠纷", value: "008002013" },
    	{ label: "损害股东利益责任纠纷", value: "008002014" },
    	{ label: "损害公司利益责任纠纷", value: "008002015" },
    	{ label: "股东损害公司债权人利益责任纠纷", value: "008002016" },
    	{ label: "公司关联交易损害责任纠纷", value: "008002017" },
    	{ label: "公司合并纠纷", value: "008002018" },
    	{ label: "公司分立纠纷", value: "008002019" },
    	{ label: "公司减资纠纷", value: "008002020" },
    	{ label: "公司增资纠纷", value: "008002021" },
    	{ label: "公司解散纠纷", value: "008002022" },
    	{ label: "申请公司清算", value: "008002023" },
    	{ label: "清算责任纠纷", value: "008002024" },
    	{ label: "上市公司收购纠纷", value: "008002025" },
    	{ label: "合伙企业纠纷", value: "008003" },
    	{ label: "入伙纠纷", value: "008003001" },
    	{ label: "退伙纠纷", value: "008003002" },
    	{ label: "合伙企业财产份额转让纠纷", value: "008003003" },
    	{ label: "与破产有关的纠纷", value: "008004" },
    	{ label: "申请破产清算", value: "008004001" },
    	{ label: "申请破产重整", value: "008004002" },
    	{ label: "申请破产和解", value: "008004003" },
    	{ label: "请求撤销个别清偿行为纠纷", value: "008004004" },
    	{ label: "请求确认债务人行为无效纠纷", value: "008004005" },
    	{ label: "对外追收债权纠纷", value: "008004006" },
    	{ label: "追收未缴出资纠纷", value: "008004007" },
    	{ label: "追收抽逃出资纠纷", value: "008004008" },
    	{ label: "追收非正常收入纠纷", value: "008004009" },
    	{ label: "破产债权确认纠纷", value: "008004010" },
    	{ label: "职工破产债权确认纠纷", value: "008004010001" },
    	{ label: "普通破产债权确认纠纷", value: "008004010002" },
    	{ label: "取回权纠纷", value: "008004011" },
    	{ label: "一般取回权纠纷", value: "008004011001" },
    	{ label: "出卖人取回权纠纷", value: "008004011002" },
    	{ label: "破产抵销权纠纷", value: "008004012" },
    	{ label: "别除权纠纷", value: "008004013" },
    	{ label: "破产撤销权纠纷", value: "008004014" },
    	{ label: "损害债务人利益赔偿纠纷", value: "008004015" },
    	{ label: "管理人责任纠纷", value: "008004016" },
    	{ label: "证券纠纷", value: "008005" },
    	{ label: "证券权利确认纠纷", value: "008005001" },
    	{ label: "股票权利确认纠纷", value: "008005001001" },
    	{ label: "公司债券权利确认纠纷", value: "008005001002" },
    	{ label: "国债权利确认纠纷", value: "008005001003" },
    	{ label: "证券投资基金权利确认纠纷", value: "008005001004" },
    	{ label: "证券交易合同纠纷", value: "008005002" },
    	{ label: "股票交易纠纷", value: "008005002001" },
    	{ label: "公司债券交易纠纷", value: "008005002002" },
    	{ label: "国债交易纠纷", value: "008005002003" },
    	{ label: "证券投资基金交易纠纷", value: "008005002004" },
    	{ label: "金融衍生品种交易纠纷", value: "008005003" },
    	{ label: "证券承销合同纠纷", value: "008005004" },
    	{ label: "证券代销合同纠纷", value: "008005004001" },
    	{ label: "证券包销合同纠纷", value: "008005004002" },
    	{ label: "证券投资咨询纠纷", value: "008005005" },
    	{ label: "证券资信评级服务合同纠纷", value: "008005006" },
    	{ label: "证券回购合同纠纷", value: "008005007" },
    	{ label: "股票回购合同纠纷", value: "008005007001" },
    	{ label: "国债回购合同纠纷", value: "008005007002" },
    	{ label: "公司债券回购合同纠纷", value: "008005007003" },
    	{ label: "证券投资基金回购合同纠纷", value: "008005007004" },
    	{ label: "质押式证券回购纠纷", value: "008005007005" },
    	{ label: "证券上市合同纠纷", value: "008005008" },
    	{ label: "证券交易代理合同纠纷", value: "008005009" },
    	{ label: "证券上市保荐合同纠纷", value: "008005010" },
    	{ label: "证券发行纠纷", value: "008005011" },
    	{ label: "证券认购纠纷", value: "008005011001" },
    	{ label: "证券发行失败纠纷", value: "008005011002" },
    	{ label: "证券返还纠纷", value: "008005012" },
    	{ label: "证券欺诈责任纠纷", value: "008005013" },
    	{ label: "证券内幕交易责任纠纷", value: "008005013001" },
    	{ label: "操纵证券交易市场责任纠纷", value: "008005013002" },
    	{ label: "证券虚假陈述责任纠纷", value: "008005013003" },
    	{ label: "欺诈客户责任纠纷", value: "008005013004" },
    	{ label: "证券托管纠纷", value: "008005014" },
    	{ label: "证券登记、存管、结算纠纷", value: "008005015" },
    	{ label: "融资融券交易纠纷", value: "008005016" },
    	{ label: "客户交易结算资金纠纷", value: "008005017" },
    	{ label: "期货交易纠纷", value: "008006" },
    	{ label: "期货经纪合同纠纷", value: "008006001" },
    	{ label: "期货透支交易纠纷", value: "008006002" },
    	{ label: "期货强行平仓纠纷", value: "008006003" },
    	{ label: "期货实物交割纠纷", value: "008006004" },
    	{ label: "期货保证合约纠纷", value: "008006005" },
    	{ label: "期货交易代理合同纠纷", value: "008006006" },
    	{ label: "侵占期货交易保证金纠纷", value: "008006007" },
    	{ label: "期货欺诈责任纠纷", value: "008006008" },
    	{ label: "操纵期货交易市场责任纠纷", value: "008006009" },
    	{ label: "期货内幕交易责任纠纷", value: "008006010" },
    	{ label: "期货虚假信息责任纠纷", value: "008006011" },
    	{ label: "信托纠纷", value: "008007" },
    	{ label: "民事信托纠纷", value: "008007001" },
    	{ label: "营业信托纠纷", value: "008007002" },
    	{ label: "公益信托纠纷", value: "008007003" },
    	{ label: "保险纠纷", value: "008008" },
    	{ label: "财产保险合同纠纷", value: "008008001" },
    	{ label: "财产损失保险合同纠纷", value: "008008001001" },
    	{ label: "责任保险合同纠纷", value: "008008001002" },
    	{ label: "信用保险合同纠纷", value: "008008001003" },
    	{ label: "保证保险合同纠纷", value: "008008001004" },
    	{ label: "保险人代位求偿权纠纷", value: "008008001005" },
    	{ label: "人身保险合同纠纷", value: "008008002" },
    	{ label: "人寿保险合同纠纷", value: "008008002001" },
    	{ label: "意外伤害保险合同纠纷", value: "008008002002" },
    	{ label: "健康保险合同纠纷", value: "008008002003" },
    	{ label: "再保险合同纠纷", value: "008008003" },
    	{ label: "保险经纪合同纠纷", value: "008008004" },
    	{ label: "保险代理合同纠纷", value: "008008005" },
    	{ label: "进出口信用保险合同纠纷", value: "008008006" },
    	{ label: "保险费纠纷", value: "008008007" },
    	{ label: "票据纠纷", value: "008009" },
    	{ label: "票据付款请求权纠纷", value: "008009001" },
    	{ label: "票据追索权纠纷", value: "008009002" },
    	{ label: "票据交付请求权纠纷", value: "008009003" },
    	{ label: "票据返还请求权纠纷", value: "008009004" },
    	{ label: "票据损害责任纠纷", value: "008009005" },
    	{ label: "票据利益返还请求权纠纷", value: "008009006" },
    	{ label: "汇票回单签发请求权纠纷", value: "008009007" },
    	{ label: "票据保证纠纷", value: "008009008" },
    	{ label: "确认票据无效纠纷", value: "008009009" },
    	{ label: "票据代理纠纷", value: "008009010" },
    	{ label: "票据回购纠纷", value: "008009011" },
    	{ label: "信用证纠纷", value: "008010" },
    	{ label: "委托开立信用证纠纷", value: "008010001" },
    	{ label: "信用证开证纠纷", value: "008010002" },
    	{ label: "信用证议付纠纷", value: "008010003" },
    	{ label: "信用证欺诈纠纷", value: "008010004" },
    	{ label: "信用证融资纠纷", value: "008010005" },
    	{ label: "信用证转让纠纷", value: "008010006" },
    	{ label: "侵权责任纠纷", value: "009001" },
    	{ label: "监护人责任纠纷", value: "009001001" },
    	{ label: "用人单位责任纠纷", value: "009001002" },
    	{ label: "劳务派遣工作人员侵权责任纠纷", value: "009001003" },
    	{ label: "提供劳务者致害责任纠纷", value: "009001004" },
    	{ label: "提供劳务者受害责任纠纷", value: "009001005" },
    	{ label: "网络侵权责任纠纷", value: "009001006" },
    	{ label: "违反安全保障义务责任纠纷", value: "009001007" },
    	{ label: "公共场所管理人责任纠纷", value: "009001007001" },
    	{ label: "群众性活动组织者责任纠纷", value: "009001007002" },
    	{ label: "教育机构责任纠纷", value: "009001008" },
    	{ label: "产品责任纠纷", value: "009001009" },
    	{ label: "产品生产者责任纠纷", value: "009001009001" },
    	{ label: "产品销售者责任纠纷", value: "009001009002" },
    	{ label: "产品运输者责任纠纷", value: "009001009003" },
    	{ label: "产品仓储者责任纠纷", value: "009001009004" },
    	{ label: "机动车交通事故责任纠纷", value: "009001010" },
    	{ label: "医疗损害责任纠纷", value: "009001011" },
    	{ label: "侵害患者知情同意权责任纠纷", value: "009001011001" },
    	{ label: "医疗产品责任纠纷", value: "009001011002" },
    	{ label: "环境污染责任纠纷", value: "009001012" },
    	{ label: "大气污染责任纠纷", value: "009001012001" },
    	{ label: "水污染责任纠纷", value: "009001012002" },
    	{ label: "噪声污染责任纠纷", value: "009001012003" },
    	{ label: "放射性污染责任纠纷", value: "009001012004" },
    	{ label: "土壤污染责任纠纷", value: "009001012005" },
    	{ label: "电子废物污染责任纠纷", value: "009001012006" },
    	{ label: "固体废物污染责任纠纷", value: "009001012007" },
    	{ label: "高度危险责任纠纷", value: "009001013" },
    	{ label: "民用核设施损害责任纠纷", value: "009001013001" },
    	{ label: "民用航空器损害责任纠纷", value: "009001013002" },
    	{ label: "占有、使用高度危险物损害责任纠纷", value: "009001013003" },
    	{ label: "高度危险活动损害责任纠纷", value: "009001013004" },
    	{ label: "遗失、抛弃高度危险物损害责任纠纷", value: "009001013005" },
    	{ label: "非法占有高度危险物损害责任纠纷", value: "009001013006" },
    	{ label: "饲养动物损害责任纠纷", value: "009001014" },
    	{ label: "物件损害责任纠纷", value: "009001015" },
    	{ label: "物件脱落、坠落损害责任纠纷", value: "009001015001" },
    	{ label: "建筑物、构筑物倒塌损害责任纠纷", value: "009001015002" },
    	{ label: "不明抛掷物、坠落物损害责任纠纷", value: "009001015003" },
    	{ label: "堆放物倒塌致害责任纠纷", value: "009001015004" },
    	{ label: "公共道路妨碍通行损害责任纠纷", value: "009001015005" },
    	{ label: "林木折断损害责任纠纷", value: "009001015006" },
    	{ label: "地面施工、地下设施损害责任纠纷", value: "009001015007" },
    	{ label: "触电人身损害责任纠纷", value: "009001016" },
    	{ label: "义务帮工人受害责任纠纷", value: "009001017" },
    	{ label: "见义勇为人受害责任纠纷", value: "009001018" },
    	{ label: "公证损害责任纠纷", value: "009001019" },
    	{ label: "防卫过当损害责任纠纷", value: "009001020" },
    	{ label: "紧急避险损害责任纠纷", value: "009001021" },
    	{ label: "铁路运输损害责任纠纷", value: "009001023" },
    	{ label: "铁路运输人身损害责任纠纷", value: "009001023001" },
    	{ label: "铁路运输财产损害责任纠纷", value: "009001023002" },
    	{ label: "水上运输损害责任纠纷", value: "009001024" },
    	{ label: "水上运输人身损害责任纠纷", value: "009001024001" },
    	{ label: "水上运输财产损害责任纠纷", value: "009001024002" },
    	{ label: "航空运输损害责任纠纷", value: "009001025" },
    	{ label: "航空运输人身损害责任纠纷", value: "009001025001" },
    	{ label: "航空运输财产损害责任纠纷", value: "009001025002" },
    	{ label: "因申请诉前财产保全损害责任纠纷", value: "009001026" },
    	{ label: "因申请诉前证据保全损害责任纠纷", value: "009001027" },
    	{ label: "因申请诉中财产保全损害责任纠纷", value: "009001028" },
    	{ label: "因申请诉中证据保全损害责任纠纷", value: "009001029" },
    	{ label: "因申请先予执行损害责任纠纷", value: "009001030" },
    	{ label: "选民资格案件", value: "010001" },
    	{ label: "申请确定选民资格", value: "010001001" },
    	{ label: "宣告失踪、宣告死亡案件", value: "010002" },
    	{ label: "申请宣告公民失踪", value: "010002001" },
    	{ label: "申请撤销宣告失踪", value: "010002002" },
    	{ label: "申请为失踪人财产指定、变更代管人", value: "010002003" },
    	{ label: "失踪人债务支付纠纷", value: "010002004" },
    	{ label: "申请宣告公民死亡", value: "010002005" },
    	{ label: "申请撤销宣告公民死亡", value: "010002006" },
    	{ label: "被撤销死亡宣告人请求返还财产纠纷", value: "010002007" },
    	{ label: "认定公民无民事行为能力、限制民事行为能力案件", value: "010003" },
    	{ label: "申请宣告公民无民事行为能力", value: "010003001" },
    	{ label: "申请宣告公民限制民事行为能力", value: "010003002" },
    	{ label: "申请宣告公民恢复限制民事行为能力", value: "010003003" },
    	{ label: "申请宣告公民恢复完全民事行为能力", value: "010003004" },
    	{ label: "认定财产无主案件", value: "010004" },
    	{ label: "申请认定财产无主", value: "010004001" },
    	{ label: "申请撤销认定财产无主", value: "010004002" },
    	{ label: "监护权特别程序案件", value: "010005" },
    	{ label: "申请确定监护人", value: "010005001" },
    	{ label: "申请变更监护人", value: "010005002" },
    	{ label: "申请撤销监护人资格", value: "010005003" },
    	{ label: "督促程序案件", value: "010006" },
    	{ label: "申请支付令", value: "010006001" },
    	{ label: "公示催告程序案件", value: "010007" },
    	{ label: "申请公示催告", value: "010007001" },
    	{ label: "申请诉前停止侵害知识产权案件", value: "010008" },
    	{ label: "申请诉前停止侵害专利权", value: "010008001" },
    	{ label: "申请诉前停止侵害注册商标专用权", value: "010008002" },
    	{ label: "申请诉前停止侵害著作权", value: "010008003" },
    	{ label: "申请诉前停止侵害植物新品种权", value: "010008004" },
    	{ label: "申请保全案件", value: "010009" },
    	{ label: "申请诉前财产保全", value: "010009001" },
    	{ label: "申请诉中财产保全", value: "010009002" },
    	{ label: "申请诉前证据保全", value: "010009003" },
    	{ label: "申请诉中证据保全", value: "010009004" },
    	{ label: "仲裁程序中的财产保全", value: "010009005" },
    	{ label: "仲裁程序中的证据保全", value: "010009006" },
    	{ label: "申请中止支付信用证项下款项", value: "010009007" },
    	{ label: "申请中止支付保函项下款项", value: "010009008" },
    	{ label: "仲裁程序案件", value: "010010" },
    	{ label: "申请确认仲裁协议效力", value: "010010001" },
    	{ label: "申请撤销仲裁裁决", value: "010010002" },
    	{ label: "执行异议之诉", value: "010013" },
    	{ label: "案外人执行异议之诉", value: "010013001" },
    	{ label: "申请执行人执行异议之诉", value: "010013002" },
    	{ label: "执行分配方案异议之诉", value: "010013003" },
    ];
    $( "#brief" ).autocomplete({
      source: availableTags
    });
  } );
  </script>
</head>
<body>
<div id="global">
<form:form commandName="doc" action="saveDoc" enctype="multipart/form-data" method="post">
    <fieldset>
        <legend>裁判文书录入</legend>
        <p>
            <label for="uploadFile">请选择裁判文书<span class="star">*</span></label>
            <input type="file" name="file" accept="application/vnd.openxmlformats-officedocument.wordprocessingml.document" style="width:210px;height:25px">
        </p>
        <p>
            <label for="title">案件名称<span class="star">*</span></label>
            <form:input id="title" path="title" placeholder="示例：张三与李四民间借贷纠纷" style="width:200px;height:25px"/>
        </p>
        <p>
            <label for="source">裁判文书来源 </label>
            <form:input id="source" path="source" placeholder="示例：中国裁判文书网" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="caseNo">案号<span class="star">*</span></label>
            <form:input id="caseNo" path="caseNo" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="brief">案由代码<span class="star">*</span></label>
            <form:input id="brief" path="brief.briefId" placeholder="已启用输入提示功能" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="category">案件类型<span class="star">*</span></label>
            <form:select id="category" path="category" style="width:80px;height:28px">
                <form:option value="民事" selected="selected" style="width:80px">民事</form:option>
                <form:option value="商事" style="width:80px">商事</form:option>
                <form:option value="刑事" style="width:80px">刑事</form:option>
                <form:option value="行政" style="width:80px">行政</form:option>
                <form:option value="执行" style="width:80px">执行</form:option>
            </form:select>
        </p>
        <p>
            <label for="caseclass">案件子类型</label>
            <form:input id="caseclass" path="caseclass.classId" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="isImportant">是否重要裁判文书<span class="star">*</span></label>
            <form:checkbox id="isImportant" path="isImportant"/>
        </p>
        <p>
            <label for="docCategory">文书类型<span class="star">*</span></label>
            <form:radiobutton path="docCategory" value="判决" checked="checked"/>判决
            <form:radiobutton path="docCategory" value="裁定"/>裁定
        </p>
        <p>
            <label for="proceeding">诉讼程序<span class="star">*</span></label>
            <form:radiobutton path="proceeding" value="一审" checked="checked"/>一审
            <form:radiobutton path="proceeding" value="二审"/>二审
            <form:radiobutton path="proceeding" value="再审"/>再审
            <form:radiobutton path="proceeding" value="特别程序"/>特别程序
            <form:radiobutton path="proceeding" value="执行"/>执行
        </p>
        <p>
            <label for="court">审理法院<span class="star">*</span></label>
            <form:input id="court" path="court.courtCode" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="judge">审判员</label>
            <form:input id="judge" path="judge" placeholder="审判员之间用逗号隔开" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="judgeDate">裁判日期<span class="star">*</span></label>
            <form:input id="judgeDate" path="judgeDate" style="width:140px;height:25px" onClick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"/>
        </p>
        <p>
            <label for="litigant">当事人</label>
            <form:input id="litigant" path="litigant" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="attorney">委托诉讼代理人</label>
            <form:input id="attorney" path="attorney" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="keywords">关键字（词）</label>
            <form:textarea id="keywords" path="keywords" placeholder="最能体现案件特征的关键字词" cols="30" rows="10"/>
        </p>
        <p>
            <label for="abbrevation">裁判要点</label>
            <form:textarea id="abbrevation" path="abbrevation" cols="30" rows="10"/>
        </p>
        <p>
            <label for="fullPathName">文书保存路径<span class="star">*</span></label>
            <form:input id="fullPathName" path="fullPathName" placeholder="文件全路径名称" style="width:240px;height:25px"/>
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4" value="重新填写">&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="submit" type="submit" tabindex="5" value="保存文件">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>