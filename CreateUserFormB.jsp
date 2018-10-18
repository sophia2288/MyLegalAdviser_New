<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
<form action="saveUser" method="post">
    <fieldset>
        <legend>用户注册</legend>
        <p>
            <label for="account">用户名:</label>
            <input type="text" id="account" name="account" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="category">类别:</label>
            <select id="category" name="category" style="height:25px">
                <option value="普通用户" selected="selected">普通用户</option>
                <option value="律师">律师</option>
                <option value="公检法工作人员">公检法工作人员</option>
                <option value="高校教师">高校教师</option>
            </select>
        </p>
        <p>
            <label for="phone">电话: </label>
            <input type="text" id="phone" name="phone" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="email">e-mail: </label>
            <input type="email" id="email" name="email" style="width:140px;height:25px"/>
        </p>
        <p>
            <label for="concerns">兴趣点: </label>
            <textarea id="concerns" name="concerns" rows="5" style="width:160px"></textarea>
        </p>
        
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4" value="重新填写">&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="submit" type="submit" tabindex="5" value="注册用户">
        </p>
    </fieldset>
</form>
</div>
</body>
</html>