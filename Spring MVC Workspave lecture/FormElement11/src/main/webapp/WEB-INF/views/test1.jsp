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

	<h1>test1</h1>
	<hr><br>
	<!-- path는 id로, action은 post -->
	<form:form modelAttribute="dataBean" action="result">
		text :	<form:input path="a1" /><br>	
		text(hidden) :	<form:hidden path="a1" />
		<form:button disable="true">확인버튼</form:button>
	</form:form>

</body>
</html>