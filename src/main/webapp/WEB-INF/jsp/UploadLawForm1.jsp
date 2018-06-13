<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>录入法律法规等规范性文件</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/datepicker/My97DatePicker/WdatePicker.js">
</script>
</head>
<body>
<div id="global">
<form:form commandName="law" action="saveLaw" method="post">
    <fieldset>
        <legend>法律法规录入</legend>
        <p>
            <label for="uploadFile">请选择文件：</label>
            <input type="file" name="file" accept="application/vnd.openxmlformats-officedocument.wordprocessingml.document">
        </p>
        <p>
            <label for="fullName">法律全称：</label>
            <form:input id="fullName" path="fullName" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="organ">发布机关： </label>
            <form:input id="organ" path="organ" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="referenceNo">发文字号：</label>
            <form:input id="referenceNo" path="referenceNo" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="publishDate">发布日期：</label>
            <form:input id="publishDate" path="publishDate" style="width:140px;height:25px" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
        </p>
        <p>
            <label for="effectiveDate">施行日期：</label>
            <form:input id="effectiveDate" path="effectiveDate" style="width:140px;height:25px" onClick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"/>
        </p>
        <p>
            <label for="prescription">时效性：</label>
            <form:select id="prescription" path="prescription" style="height:25px">
                <form:option value="0" selected="selected">现行有效</form:option>
                <form:option value="1">已被修改</form:option>
                <form:option value="2">已废止</form:option>
            </form:select>
        </p>
        <p>
            <label for="hierarchy">效力级别：</label>
            <form:select id="hierarchy" path="hierarchy" style="height:25px">
                <form:option value="0" selected="selected">法律</form:option>
                <form:option value="1">行政法规</form:option>
                <form:option value="2">司法解释</form:option>
                <form:option value="3">省级地方性法规</form:option>
                <form:option value="4">较大市地方性法规</form:option>
                <form:option value="5">部门规章</form:option>
                <form:option value="6">地方政府规章</form:option>
                <form:option value="7">最高法答复和批复</form:option>
            </form:select>
        </p>
        <p>
            <label for="classification">法律分类：</label>
            <form:select id="classification" path="classification" style="height:25px">
                <form:option value="0" selected="selected">实体法</form:option>
                <form:option value="1">程序法</form:option>
                <form:option value="2">实体&程序法</form:option>
            </form:select>
            <form:select id="classification1" path="classification1" style="height:25px">
                <form:option value="0" selected="selected">民商事</form:option>
                <form:option value="1">刑事</form:option>
                <form:option value="2">行政</form:option>
                <form:option value="3">执行</form:option>
            </form:select>
        </p>
        <p>
            <label for="brief">指定案由：</label>
            <form:input id="brief" path="brief.briefId" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="aliases">法律简称：</label>
            <form:textarea id="aliases" path="aliases" rows="5" style="width:160px"/>
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