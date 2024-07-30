<%@page import="com.tenco.model.student.EnrollSearchListDTO"%>
<%@page import="java.awt.Button"%>
<%@page import="java.util.List"%>
<%@page import="com.tenco.model.student.EnrollSearchDTO"%>
<%@page import="com.tenco.model.student.breakappDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
     <%@ include file="../main_head.jsp" %>

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

	<% List<EnrollSearchListDTO> dto =(List<EnrollSearchListDTO>)request.getAttribute("EnrollSearchListDTO"); %>

	<h2 >수강신청 목록 </h2>
	<a href="${pageContext.request.contextPath}/student/enrollSearch"><button type="submit">강의 시간표 조회</button></a>
	<br>
	<table border="1">
					<thead>
						<tr>
							
							<th>학수번호</th>
							<th style="width: 200px;">강의명</th>
							<th>담당교수</th>
							<th>담당교수</th>
							<th>학점</th>
							<th>강의실</th>
						</tr>
					</thead>
					
					<% 
					int i;
					for(i =0; i<dto.size(); i++){
					%>
					<tr>
					<form action="${pageContext.request.contextPath}/student/deleteEnroll" method="post">
					   <td><%= dto.get(i).getS_number()%></td>
					   <td><%= dto.get(i).getName()%></td>
					   <td><%= dto.get(i).getProfessor()%></td>
					   <td><%= dto.get(i).getGrades()%></td>
					   <td><%= dto.get(i).getRoom()%></td>
					   <td><button type="submit">취소하기</button></td>
					   <input type="hidden" name="subjectname" value="<%=dto.get(i).getS_number()%>">
					   <input type="hidden" name="subjectnumber" value="<%= dto.get(i).getS_number()%>">
					</form>
					   
					</tr>
					<%
					}
					%>		
				</table>

<%@ include file="../main_footer.jsp"%>
