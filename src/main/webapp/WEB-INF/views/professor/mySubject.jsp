<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 강의 목록</title>
<link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
	<h2>내 강의 목록</h2>
	<%
		ResultSet rs = (ResultSet)request.getAttribute("subjectList");
		if(rs!=null){
	%>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>강의명</th>
			<th></th>
			<th></th>
		</tr>
	</table>
	<%}%>
</body>
</html>