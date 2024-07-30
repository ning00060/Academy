<%@page import="com.tenco.model.professor.ProfessorDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@ include file="/WEB-INF/views/main_head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
	color: #333;
}

h2 {
	text-align: center;
	margin-top: 20px;
	color: #444;
}

form {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 20px;
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 50%;
	max-width: 400px;
	margin-left: auto;
	margin-right: auto;
}

.form-group {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-bottom: 15px;
	width: 100%;
}

select, button {
	padding: 10px;
	margin: 5px;
	border-radius: 5px;
	border: 1px solid #ddd;
	width: 100%;
}

button {
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
	transition: background-color 0.3s ease;
	border: none;
}

button:hover {
	background-color: #0056b3;
}

a {
	display: block;
	text-align: center;
	margin-top: 20px;
	text-decoration: none;
	color: #007bff;
	transition: color 0.3s ease;
}

a:hover {
	color: #0056b3;
}

.home-link {
	text-align: center;
	margin-top: 20px;
}
</style>
<meta charset="UTF-8">
<title>휴/보강 목록 조회하기</title>
</head>
<body>
	<h2>휴/보강 목록 조회</h2>
	<form action="${pageContext.request.contextPath}/professor/mysubjectRC"
		method="GET">
		<select id="year" name="year">
			<option value="2014">2014</option>
			<option value="2015">2015</option>
			<option value="2016">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
			<option value="2020">2020</option>
			<option value="2021">2021</option>
			<option value="2022">2022</option>
			<option value="2023">2023</option>
			<option value="2024">2024</option>
		</select> <select id="semester" name="semester">
			<option value="1">1학기</option>
			<option value="2">2학기</option>
		</select>
		<%
		ProfessorDTO professorDTO = (ProfessorDTO) request.getAttribute("professorDTO");
		%>
		<input type="hidden" id="professorId" name="professorId"
			value="<%=professorDTO.getId()%>">
		<button type="submit">조회</button>
	</form>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/professor/gohome">홈으로
		돌아가기</a>
	<%@ include file="/WEB-INF/views/main_footer.jsp"%>