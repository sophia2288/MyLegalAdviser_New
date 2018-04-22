<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>您好，欢迎光临本站点。以下是刚创建的用户信息：</h3>
	用户名：${userN.account}<br />
	密&nbsp;&nbsp;&nbsp;&nbsp;码：${userN.password}<br />
	类&nbsp;&nbsp;&nbsp;&nbsp;别：${userN.category}<br /> 
	电&nbsp;&nbsp;&nbsp;&nbsp;话：${userN.phone}<br /> 
	E-&nbsp;mail：${userN.email}<br /> 
	兴趣点：${userN.concerns}<br /> 
	资料贡献数量：${userN.contributions}<br /> 
	
</body>
</html>