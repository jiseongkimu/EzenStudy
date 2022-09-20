<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Join" method="post">
	아이디 : <input type="text" name="id">
	<br>
	비밀번호 : <input type="password" name="pw">
	<br>
	<input type="submit" value="확인">
	<input type="reset" value="다시 작성">
	<input type="button" onClick="href='javascript:window.history.go(-1);'" value="뒤로 가기">
</form>
</body>
</html>