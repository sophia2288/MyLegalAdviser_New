<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>录入法律法规等规范性文件</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/datepicker/My97DatePicker/WdatePicker.js"></script>
<!-- <link rel="stylesheet" href="jquery-ui.min.css"> -->
<style type="text/css">@import url("<c:url value="/jquery-ui-1.12.1/jquery-ui.min.css"/>");</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-ui-1.12.1/external/jquery/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script>
  $( function() {
    var availableTags = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "合同法",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    $( "#brief" ).autocomplete({
      source: availableTags
    });
  } );
  </script>
</head>
<body>
<div id="global">
<form:form commandName="law" action="saveLaw" enctype="multipart/form-data" method="post">
    <fieldset>
        <legend>法律法规录入</legend>
        <p>
            <label for="uploadFile">请选择文件<span id="star">*</span>：</label>
            <input type="file" name="file" accept="application/vnd.openxmlformats-officedocument.wordprocessingml.document" style="width:210px;height:25px">
        </p>
        <p>
            <label for="fullName">法律全称<span id="star">*</span>：</label>
            <form:input id="fullName" path="fullName" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="organ">发布机关<span id="star">*</span>： </label>
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
            <label for="effectiveDate">施行日期<span id="star">*</span>：</label>
            <form:input id="effectiveDate" path="effectiveDate" style="width:140px;height:25px" onClick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"/>
        </p>
        <p>
            <label for="prescription">时效性<span id="star">*</span>：</label>
            <!--  
            <div id="prescription">
                  <form:radiobuttons id="prescription" path="prescription" items="${prescriptions1}" delimiter="&nbsp;" /><br/>
            </div>
            -->
            
            <form:radiobutton path="prescription" value="现行有效" checked="checked"/>现行有效
            <form:radiobutton path="prescription" value="已被修改"/>已被修改
            <form:radiobutton path="prescription" value="已废止"/>已废止
            
            <!-- 
            <form:radiobuttons id="prescription" path="prescription" items="${prescriptions}" delimiter="&nbsp;" style="height:25px" /> 
           
            
            <form:select id="prescription" path="prescription" style="height:25px">
                <form:option value="现行有效" selected="selected">现行有效</form:option>
                <form:option value="已被修改">已被修改</form:option>
                <form:option value="已废止">已废止</form:option>
            </form:select>
            -->
        </p>
        <p>
            <label for="hierarchy">效力级别<span id="star">*</span>：</label>
            <form:select id="hierarchy" path="hierarchy" style="height:28px">
                <form:option value="法律" selected="selected">法律</form:option>
                <form:option value="行政法规">行政法规</form:option>
                <form:option value="省地方性法规">省地方性法规</form:option>
                <form:option value="较大市地方性法规">较大市地方性法规</form:option>
                <form:option value="司法解释">司法解释</form:option>
                <form:option value="部门规章">部门规章</form:option>
                <form:option value="地方政府规章">地方政府规章</form:option>
                <form:option value="最高人民法院的答复批复">最高法答复和批复</form:option>
            </form:select>
        </p>
        <p>
            <label for="classification">法律分类<span id="star">*</span>：</label>
            <form:select id="classification" path="classification" style="height:28px">
                <form:option value="实体" selected="selected">实体法</form:option>
                <form:option value="程序">程序法</form:option>
                <form:option value="实体&程序">实体&程序法</form:option>
            </form:select>&nbsp;&nbsp;
            <form:select id="classification1" path="classification1" style="height:28px">
                <form:option value="民商事" selected="selected">民商事</form:option>
                <form:option value="刑事">刑事</form:option>
                <form:option value="行政">行政</form:option>
                <form:option value="执行">执行</form:option>
            </form:select>
        </p>
        <p>
            <label for="brief">指定案由：</label>
            <form:input id="brief" path="brief.briefId" placeholder="已启用输入提示功能" style="width:140px;height:25px"/>
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