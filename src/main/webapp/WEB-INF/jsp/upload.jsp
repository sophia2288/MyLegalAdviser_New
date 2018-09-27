<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BufferedInputStream fileIn = new BufferedInputStream(request.getInputStream());
		String fn = request.getParameter("fileName");

		byte[] buf = new byte[1024];
		File file = new File("d:/" + fn);

		BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(file));

		while (true) {
			// 读取数据
			int bytesIn = fileIn.read(buf, 0, 1024);

			System.out.println(bytesIn);

			if (bytesIn == -1) {
				break;
			} else {
				fileOut.write(buf, 0, bytesIn);
			}
		}

		fileOut.flush();
		fileOut.close();

		out.print(file.getAbsolutePath());
	%>
</body>
</html>