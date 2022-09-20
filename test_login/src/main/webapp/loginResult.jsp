<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("id");
%>

<%=id%>님 ㅎㅇ<br>
<a href="index.jsp">처음으로</a>
</body>
</html>