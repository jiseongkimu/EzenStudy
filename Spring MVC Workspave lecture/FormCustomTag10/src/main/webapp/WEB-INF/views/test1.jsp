<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>test1</h1>
<form action="result" method="post">
	이름 : <input type="text" name="user_name" value="${requestScope.userDataBean.user_name}"><br>
	<button type="submit">확인</button>
	
</form>

</body>
</html>