<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result3</h1>
	sessionScope.sessionBean1.data1 : ${sessionScope.sessionBean1.getData1() }<br>
	sessionScope.sessionBean1.data2 : ${sessionScope.sessionBean1.data2 }<br>
	sessionScope.sessionBean2.data1 : ${sessionScope.sessionBean2.data1 }<br>
	sessionScope.sessionBean2.data2 : ${sessionScope.sessionBean2.data2 }<br>
</body>
</html>