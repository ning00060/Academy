<%@page import="com.tenco.model.professor.RestClassDTO"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.apache.tomcat.jakartaee.commons.lang3.ArrayUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tenco.model.subject.SubjectDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ include file="/WEB-INF/views/main_head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    body {
        font-family: 'Arial', sans-serif;
        color: #333;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    h2 {
        color: #012169;
        text-align: center;
        padding: 20px 0;
        border-bottom: 2px solid #00539B;
        margin-bottom: 20px;
    }
    table {
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 12px;
        text-align: center;
    }
    th {
        background-color: #00539B;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    button {
        background-color: #00539B;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 5px;
    }
    button:hover {
        background-color: #012169;
    }
    form {
        display: inline;
    }
    p {
        text-align: center;
        color: #00539B;
    }
    .actions {
        text-align: center;
        margin-top: 20px;
    }
    .actions a, .actions button {
        margin: 0 10px;
    }
</style>
<meta charset="UTF-8">
<title>휴/보강 목록</title>
</head>
<body>
	<h2>휴/보강 목록</h2>
	<%
	List<RestClassDTO> restClassList = (List<RestClassDTO>) request.getAttribute("restClassList");
	if (restClassList != null) {
	%>
	<table border="1">
		
		<tr>
			<th>번호</th>
			<th>강의코드</th>
			<th>강의명</th>
			<th>휴강일 및 사유</th>
			<th>강의실</th>
			<th>보강 계획</th>
			<th></th>
		</tr>
		<%
		for (int i = 0; i < restClassList.size(); i++) {
		%>
		<tr>
			<td><%=i + 1%></td>
			<td><%=restClassList.get(i).getSubjectId()%></td>
			<td><%=restClassList.get(i).getSubjectName()%></td>
			<td><%=restClassList.get(i).getRestDay()%></td>
			<td><%=restClassList.get(i).getRoomId()%></td>
			<td><%=restClassList.get(i).getSupplement()%></td>
			<td>
				<form action="${pageContext.request.contextPath}/professor/updateRC" method="get">
				<input type="hidden" name="id" value="<%=restClassList.get(i).getId()%>">
				<button type="submit">수정하기</button></form>  
				
				<form action="${pageContext.request.contextPath}/professor/deleteRC" method="get">
				<input type="hidden" name="year" value="<%=request.getAttribute("year")%>">
				<input type="hidden" name="semester" value="<%=request.getAttribute("semester")%>">
				<input type="hidden" name="professorId" value="<%=request.getAttribute("professorId")%>">
				<input type="hidden" name="id" value="<%=restClassList.get(i).getId()%>">
				<button type="submit">삭제하기</button></form>
			</td>
		</tr>
		
		<%
		}
		%>
	</table>
	<%
	} else {
	%>
	<p>휴 보강 일정이 없습니다.</p>
	<%
	}
	%>
	<form
		action="${pageContext.request.contextPath}/professor/addRestClass"
		method="GET">
		<input type="hidden" name="year" value="<%=request.getParameter("year")%>">
		<input type="hidden" name="semester" value="<%=request.getParameter("semester")%>">
		<input type="hidden" name="professorId" value="<%=request.getParameter("professorId")%>">
		<button type="submit">휴강 일정 추가하기</button>
	</form>
	
	<a href="${pageContext.request.contextPath}/professor/gohome">홈으로 돌아가기</a>
<%@ include file="/WEB-INF/views/main_footer.jsp"%>