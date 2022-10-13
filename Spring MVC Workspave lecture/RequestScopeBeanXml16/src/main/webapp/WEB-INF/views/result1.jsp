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
	<b>requestScope.requestBean1.data : </b>${requestScope.requestBean1.data1},
	${requestScope.requestBean1.data2 }
	<hr>
	<b>requestScope.requestBean2.data : </b>${requestScope.requestBean2.data3},
	${requestScope.requestBean2.data4 }
	<hr>
	<b>requestScope.requestBean3.data : </b>${requestScope.requestBean3.data5},
	${requestScope.requestBean3.data6 }
	<hr>
	<b>requestScope.requestBean4.data : </b>${requestScope.requestBean4.data7},
	${requestScope.requestBean4.data8 }

</body>
</html>
