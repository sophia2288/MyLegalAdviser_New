<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
<style type="text/css">@import url("<c:url value="/jquery-ui-1.12.1/jquery-ui.min.css"/>");</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/datepicker/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-ui-1.12.1/external/jquery/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/CaseBrief.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	function doc_Preview() {
		var fileObj = document.getElementById("uploadFile").files[0];
		var formFile = new FormData();
		formFile.append("wordfile", fileObj);

		$.ajax({
			type : "post",
			url : "ajaxTestA",
			data : formFile,
			async : true,
			dataType : "json",
			cache : false,
			processData : false,
			contentType : false,
			success : function(data) {
	            $("#source").val(data.source);
	            $("#caseNo").val(data.caseNo);
	            $("#court").val(data.court);
	            $("#category").val(data.category);
	            $("#litigant").val(data.litigant);
	            $("#brief").val(data.brief);
	            $("#title").val(data.title);
			},
			error : function() {
				alert("调用ajax向服务端发送请求出错啦！");
			}
		});
	}
</script>
<title>裁判文书录入</title>
</head>
<body>
<div id="global">
<form:form commandName="doc" action="saveDoc" enctype="multipart/form-data" method="post">
    <fieldset>
        <legend>裁判文书录入</legend>
        <p>
            <label for="uploadFile">请选择裁判文书<span class="star">*</span></label>
            <input type="file" id="uploadFile" name="file" accept="application/vnd.openxmlformats-officedocument.wordprocessingml.document" onchange="doc_Preview()" style="width:210px;height:25px">
        </p>
        <p>
            <label for="title">案件名称<span class="star">*</span></label>
            <form:input id="title" path="title" placeholder="示例：张三与李四民间借贷纠纷" style="width:200px;height:25px"/>
        </p>
        <p>
            <label for="source">文书来源 </label>
            <form:input id="source" path="source" placeholder="示例：中国裁判文书网" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="caseNo">案号<span class="star">*</span></label>
            <form:input id="caseNo" path="caseNo" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="brief">案由<span class="star">*</span></label>
            <form:input id="brief" path="brief" placeholder="已启用输入提示功能" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="category">案件类型<span class="star">*</span></label>
            <form:select id="category" path="category" style="width:80px;height:28px">
                <form:option value="民事" style="width:80px">民事</form:option>
                <form:option value="商事" selected="selected" style="width:80px">商事</form:option>
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
            <form:input id="litigant" path="litigant" style="width:255px;height:25px"/>
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