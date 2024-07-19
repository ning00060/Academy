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
			<th>과목ID:</th>
			<th>강의명:</th>
			<th>담당교수:</th>
			<th>강의실:</th>
			<th>계열/학과:</th>
			<th>강의유형:</th>
			<th>개설 년도:</th>
			<th>학기:</th>
			<th>학점:</th>
			<th><th>
		</tr>
		<%
		while(rs.next()){
		%>
		<tr>
		<%--
			<td><%=rs.getId%></td>
			<td><%=rs.getName%></td>
			<td><%=rs.getProfessorName%></td>
			<td><%=rs.getRoomId%></td> 
			<td><%=rs.getDepartmentName%></td>
			<td><%=rs.getMajorType%></td>
			<td><%=rs.getYear%></td>
			<td><%=rs.getSemester%></td>
			<td><%=rs.getGrades%></td>
		 --%>
			<form actiron="input-grade" method="GET">
				<button type="submit">성적 기입</button>
			</form>
		</tr>
		
		<%}%>
		
	</table>
	<%
		}else{
	%>
	<p>해당 학기에 개설된 강좌가 없습니다.</p>
	<%
	}
	%>
</body>
</html>