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
	<hr>
	<br>
	<!-- path는 id로, action은 post -->
	<form:form modelAttribute="dataBean" action="result">
		<form:select path="a1">
			<form:option value="data1">항목1</form:option>
			<form:option value="data2">항목2</form:option>
			<form:option value="data3">항목3</form:option>
		</form:select>
		<hr>
		requestScope.data_list1 : 
		<form:select path="a2">
			<form:options items="${requestScope.data_list1}" />
		</form:select>
		<hr>
		requestScope.data_list2 : 
		<form:select path="a3">
			<form:options items="${requestScope.data_list2}" />
		</form:select>
		<hr>
		ArrayList KeyValueBean : 
		<form:select path="a4">
			<form:options items="${requestScope.data_list3}" itemLabel="key"
				itemValue="value" />
		</form:select>
		<hr>
		keyValue-key(항목1 : data1, 항목3 : data3) : 
		<form:checkbox path="a5" value="data1"></form:checkbox>항목1
		<form:checkbox path="a5" value="data2"></form:checkbox>항목2
		<form:checkbox path="a5" value="data3"></form:checkbox>항목3
		<hr>
		keyValue-value(항목1 : data1, 항목3 : data3) : 
		<br>
		<form:checkboxes path="a6" items="${requestScope.data_list1}"></form:checkboxes>
		<hr>
		ArrayList String
		<br>
		<form:checkboxes path="a7" items="${requestScope.data_list2}"></form:checkboxes>
		<hr>
		ArrayList는 itemLabel, itemValue 속성을 붙여야함
		<br>
		<form:checkboxes path="a8" items="${requestScope.data_list3}"
			itemLabel="key" itemValue="value"></form:checkboxes>
		<hr>
		<form:radiobutton path="a9" value="data1"></form:radiobutton>항목1
		<form:radiobutton path="a9" value="data2"></form:radiobutton>항목2
		<form:radiobutton path="a9" value="data3"></form:radiobutton>항목3
		<hr>
		<form:radiobuttons path="a10" items="${requestScope.data_list1 }"></form:radiobuttons>
		<hr>
		<form:radiobuttons path="a11" items="${requestScope.data_list2 }"></form:radiobuttons>
		<hr>
		<form:radiobuttons path="a12" items="${requestScope.data_list3 }"
			itemLabel="key" itemValue="value"></form:radiobuttons>

	</form:form>

</body>
</html>
