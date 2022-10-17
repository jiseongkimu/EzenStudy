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
	applicationBean1.data1 : ${applicationScope.applicationBean1.getData1() }<br>
	applicationBean1.data2 : ${applicationScope.applicationBean1.data2 }<br>
	applicationBean2.data3 : ${applicationScope.applicationBean2.data3 }<br>
	applicationBean2.data4 : ${applicationScope.applicationBean2.data4 }<br>
</body>
</html>