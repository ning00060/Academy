<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 강의</title>
<link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
	<h2>내 강의</h2>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("subjectList");
	if (rs != null) {
	%>
	<table border="1">
		<tr>
			<th>과목코드:</th>
			<th>강의명:</th>
			<th>강의실:</th>
			<th>계열/학과:</th>
			<th>강의유형:</th>
			<th>개설 년도:</th>
			<th>학기:</th>
			<th>학점:</th>
			<th>
			<th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("id")%></td>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getInt("roomId")%></td>
			<td><%=rs.getString("departmentName")%></td>
			<td><%=rs.getString("majorType")%></td>
			<td><%=rs.getString("year")%></td>
			<td><%=rs.getString("semester")%></td>
			<td><%=rs.getString("grades")%></td>
			<td>
				<form
					action="${pageContext.request.contextPath}/professor/input-grade"
					method="GET">
					<input type="hidden" name="subjectId" value="<%=rs.getInt("id")%>">
					<button type="submit">성적 입력</button>
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} else {
	%>
	<p>해당 학기에 개설된 강좌가 없습니다.</p>
	<%
	}
	%>
</body>
</html>