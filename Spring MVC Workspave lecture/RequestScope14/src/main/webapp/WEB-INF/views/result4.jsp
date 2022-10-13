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

	<h1>result4</h1>
	<hr>
	<br>
	<b>bean1.getData1()</b> : ${bean1.getData1()} , ${bean1.getData2()}<hr>
	<b>requestScope.bean1.getData1()</b> : ${requestScope.bean1.getData1() } ,   ${requestScope.bean1.getData2() }

</body>
</html>
