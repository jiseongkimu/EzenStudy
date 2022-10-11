<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index</h1>
	
	<a href="test1?data1=100&data2=200&data3=300&data3=400">test1</a>
	<hr>
	
	<form action="test2" method="post">
		data1 : <input type="text" name="data1"><br>
		data2 : <input type="text" name="data2"><br>
		data3 : <input type="checkbox" name="data3" value="100">data3 100
				<input type="checkbox" name="data3" value="200">data3 200<br>
		<button type="submit">test2 post</button>
	</form>
	
	<!-- WebRequest -->
	<a href="test3?data1=100&data2=200&data3=300&data3=400">test3</a>
	<hr>
	
	<!-- @PathVariable -->
	<a href="test4/100/200/300">test4</a>
	<hr>
	
	<!-- @RequestParam -->
	<a href="test5?data1=100&data2=200&data3=300&data3=400">test5</a>
	<hr>
	<!-- @RequestParam(value="")  -->
	<a href="test6?data1=100&data2=200&data3=300&data3=400">test6</a>
	<hr>
	
	<a href="test7?data1=100">test7</a>
</body>
</html>