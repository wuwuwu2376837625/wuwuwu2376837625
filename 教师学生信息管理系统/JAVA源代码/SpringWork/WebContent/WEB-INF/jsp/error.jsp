<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>失败中转站</title>
<meta http-equiv="refresh" content="3;url=TeLogin.jsp">
</head>
<body>
<%String msg = (String)request.getAttribute("msg");%>
<h1 style="text-align: center;margin-top: 200px"><%=msg%></h1>
</body>
</html>