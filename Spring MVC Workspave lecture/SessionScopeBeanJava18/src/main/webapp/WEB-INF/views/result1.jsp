<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result1</h1>
	sessionBean1.data1 : ${requestScope.sessionBean1.getData1() }<br>
	sessionBean1.data2 : ${requestScope.sessionBean1.data2 }<br>
	sessionBean2.data3 : ${requestScope.sessionBean2.data3 }<br>
	sessionBean2.data4 : ${requestScope.sessionBean2.data4 }<br>
</body>
</html>