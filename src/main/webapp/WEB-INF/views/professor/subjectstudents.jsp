<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 입력하기</title>
</head>
<body>
	<h2>학점 입력하기</h2>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("studentList");
	if (rs != null) {
	%>
	<table border="1">
		<tr>
			<th>학번:</th>
			<th>이름:</th>
			<th>중간성적 입력:</th>
			<th>기말성적 입력:</th>
			<th>학점 입력:</th>
			<th></th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("id")%></td>
			<td><%=rs.getString("name")%></td>
			<td><input type="text" name="midExamScore" size="10"
				style="width: 100vh"></td>
			<td><input type="text" name="finalExamScore" size="10"
				style="width: 100vh"></td>
			<td><input type="text" name="grade" size="10"
				style="width: 100vh"></td>
			<td>
				<form
					action="${pageContext.request.contextPath}/professor/input-grade"
					method="POST">
					<input type="hidden" name="studentId" value="<%=rs.getInt("id")%>">
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
	<p>해당 강의에 등록된 학생이 없습니다.</p>
	<%
	}
	%>
</body>
</html>