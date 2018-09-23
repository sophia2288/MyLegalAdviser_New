<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Create User Form</title>
<link rel="stylesheet" href="/bootstrap-4.1.3-dist/css/bootstrap.min.css">
</head>
<body>
<div id="global">
<form:form commandName="user" action="saveUser" method="post">
    <fieldset>
        <legend>用户注册</legend>
        <p>
            <label for="account">用户名: </label>
            <form:input id="account" path="account" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码: </label>
            <form:password id="password" path="password" style="width:140px;height:25px"/>
            
        </p>
        <p>
            <label for="category">类&nbsp;&nbsp;&nbsp;&nbsp;别: </label>
            <form:select id="category" path="category" style="height:25px">
                <form:option value="普通用户" selected="selected">普通用户</form:option>
                <form:option value="律师">律师</form:option>
                <form:option value="公检法工作人员">公检法工作人员</form:option>
                <form:option value="高校教师">高校教师</form:option>
                <form:option value="其他">其他</form:option>
            </form:select>
        </p>
        <p>
            <label for="phone">电&nbsp;&nbsp;&nbsp;&nbsp;话: </label>
            <form:input id="phone" path="phone" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="email">E-&nbsp;mail: </label>
            <form:input id="email" path="email" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="concerns">兴趣点: </label>
            <form:textarea id="concerns" path="concerns" rows="5" style="width:160px"/>
        </p>
        
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4" value="重新填写">&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="submit" type="submit" tabindex="5" value="注册用户">
        </p>
    </fieldset>
</form:form>
</div>
<script type="text/javascript" src="/jquery/jquery-3.3.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>