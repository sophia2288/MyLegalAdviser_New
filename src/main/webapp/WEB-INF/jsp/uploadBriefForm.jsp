<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>文件上传（案由--上传之前确保文件格式正确）</h2>
	<form action="uploadBrief" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td>文件描述:</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>请选择文件:</td><!-- application/msword -->
				<td><input type="file" name="file" accept="text/plain"></td>
			</tr>
			<tr>
				<td><input type="submit" value="上传"></td>
			</tr>
		</table>
	</form>
</body>
</html>