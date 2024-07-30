<%@page import="com.tenco.model.subject.HopeClassDTO"%>
<%@page import="com.tenco.model.subject.SubjectDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개설 희망 강좌 목록</title>
</head>
<body>
	<h2> 개설 희망 강좌 목록 </h2>
	
	<%
	List<HopeClassDTO> hopeClassList = (List<HopeClassDTO>)request.getAttribute("hopeClassList");
	if (hopeClassList.size() != 0) {
	%>
	<table border="1">
		<tr>
			<th>구분</th>
			<th>개설 강의명:</th>
			<th>희망 강의실:</th>
			<th>계열코드:</th>
			<th>강의유형:</th>
			<th>희망 개설 년도:</th>
			<th>개설 학기:</th>
			<th>배정 학점:</th>
			<th></th>
		</tr>
		<%

			for(int i = 0; i< hopeClassList.size(); i++){
		%>
		<tr>
			<td><%=i+1%></td>
			<td><%=hopeClassList.get(i).getName()%></td>
			<td><%=hopeClassList.get(i).getRoomId()%></td>
			<td><%=hopeClassList.get(i).getDeptId()%></td>
			<td><%=hopeClassList.get(i).getMajorType()%></td>
			<td><%=hopeClassList.get(i).getYear()%></td>
			<td><%=hopeClassList.get(i).getSemester()%></td>
			<td><%=hopeClassList.get(i).getGrades()%></td>
			<td>
				<form action="${pageContext.request.contextPath}/professor/deleteHopeClass" method="GET">
					
					<input type="hidden" name="id" value="<%=hopeClassList.get(i).getId()%>">
					<input type="hidden" name="professorId" value="<%=hopeClassList.get(i).getProfessorId()%>">
					<button type="submit">삭제하기</button>
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
	<p>현재 개설 요청한 강좌가 없습니다.</p>
	<%
	}
	%>
	<form action="${pageContext.request.contextPath}/professor/addHopeClass" method="GET">
	<input type="hidden" name="deptId" value="<%=request.getAttribute("deptId")%>">
	<input type="hidden" name="professorId" value="<%=request.getAttribute("professorId")%>">
	<button type="submit">강좌 개설 요청하기</button>
	</form>
	<a href="${pageContext.request.contextPath}/professor/gohome">홈으로 돌아가기</a>
</body>
</html>