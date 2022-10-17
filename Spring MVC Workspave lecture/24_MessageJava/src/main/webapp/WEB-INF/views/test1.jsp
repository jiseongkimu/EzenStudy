<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test1</h1>
<br>
locale : ${locale}<br>
aaa.a1 : <spring:message code="aaa.a1"></spring:message><br>
bbb.b1 : <spring:message code="bbb.b1"></spring:message><br>
aaa.a2 : <spring:message code="aaa.a2" arguments="${args}"></spring:message><br>
aaa.a3 : <spring:message code="aaa.a3"></spring:message><br>
</body>
</html>