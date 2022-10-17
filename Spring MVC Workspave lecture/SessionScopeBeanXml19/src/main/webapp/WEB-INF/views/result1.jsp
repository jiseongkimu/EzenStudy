<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>

	<h1>result1</h1>
	<hr>
	<br>
	sessionScope.sessionBean1.data1 : ${sessionScope.sessionBean1.data1}<br>
	sessionScope.sessionBean1.getData1() : ${sessionScope.sessionBean1.getData1()}<br>
	requestScope.sessionBean1.data1 : ${requestScope.sessionBean1.data1}<br>
	requestScope.sessionBean1.getData1() : ${requestScope.sessionBean1.getData1()}<br>
	requestScope.sessionBean2.data3 : ${requestScope.sessionBean2.data3}<br>
	requestScope.sessionBean2.getData3() : ${requestScope.sessionBean2.getData3()}<br>
	sessionScope.sessionBean2.data3 : ${sessionScope.sessionBean2.data3}<br>
	sessionScope.sessionBean2.getData3() : ${sessionScope.sessionBean2.getData3()}<br>

</body>
</html>
