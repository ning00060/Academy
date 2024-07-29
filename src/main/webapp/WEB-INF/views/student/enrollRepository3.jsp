<%@page import="com.tenco.model.student.EnrollSearchListDTO"%>
<%@page import="java.awt.Button"%>
<%@page import="java.util.List"%>
<%@page import="com.tenco.model.student.EnrollSearchDTO"%>
<%@page import="com.tenco.model.student.breakappDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
     <%@ include file="../main_head.jsp" %>


	<% List<EnrollSearchListDTO> dto =(List<EnrollSearchListDTO>)request.getAttribute("EnrollSearchListDTO"); %>

	<h2 style="margin-top: 100px">수강신청 목록 enrollRepository3.jsp </h2>

	<form action="${pageContext.request.contextPath}/student/enrollSearch" method="POST">
		
	<div style="display: flex;">	
		<div style="flex-direction: row">
		<p>강의 구분</p>
		<select id="subject" name="subject">
			<option value=>=======</option>
			<option value="전공">전공</option>
			<option value="교양">교양</option>
		</select>
		</div>
		
		<div style="flex-direction: row;">	
		<p>&nbsp; 개설학과</p>
		<select id="department" name="department">
			<option value=>=======</option>
			<option value="컴퓨터공학과">컴퓨터공학과</option>
			<option value="전자공학과">전자공학과</option>
			<option value="화학공학과">화학공학과</option>
			<option value="기계공학과">기계공학과</option>
			<option value="신소재공학과">신소재공학과</option>
			<option value="철학과">철학과</option>
			<option value="국사학과">국사학과</option>
			<option value="언어학과">언어학과</option>
			<option value="국어국문학과">국어국문학과</option>
			<option value="영어영문학과">영어영문학과</option>
			<option value="심리학과">심리학과</option>
			<option value="정치외교학과">정치외교학과</option>
			<option value="사회복지학과">사회복지학과</option>
			<option value="언론정보학과">언론정보학과</option>
			<option value="인류학과">인류학과</option>
			<option value="경영학과">경영학과</option>
			<option value="경제학과">경제학과</option>
			<option value="회계학과">회계학과</option>
			<option value="농업경영학과">농업경영학과</option>
			<option value="무역학과">무역학과</option>
		</select>
		</div>
		
		<div style="flex-direction: row;">
		<p>강의명</p>
		<select id="subjectname" name="subjectname">
			<option value=>=======</option>
			<option value="데이터통신">데이터통신</option>
			<option value="무역학과">무역학과</option>
			<option value="딥러닝의 기초">딥러닝의 기초</option>
			<option value="컴퓨터의 개념 및 실습">컴퓨터의 개념 및 실습</option>
			<option value="융합전자연구">융합전자연구</option>
			<option value="기초 전기실험">기초 전기실험</option>
			<option value="사고와 표현">사고와 표현</option>
			<option value="과학과 기술">과학과 기술</option>
			<option value="고체역학">고체역학</option>
			<option value="자유정의진리">자유정의진리</option>
			<option value="정보적 사고">정보적 사고</option>
			<option value="CAD기초">CAD기초</option>
			<option value="에너지재료">에너지재료</option>
			<option value="나노재료합성">나노재료합성</option>	
			<option value="신소재기초실습">신소재기초실습</option>	
		</select>
		</div>
		<br>
		<button type="submit" style= "margin-top: 50px">조회</button>
	</div>	
	</form>
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
