
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.tenco.model.student.StudentDTO"%>
<%@page import="com.tenco.model.temp.EnrollDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.tenco.model.student.EnrollSearchDTO"%>
<%@page import="com.tenco.model.student.breakappDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../main_head.jsp"%>

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

<h2 style="margin-top: 100px">강의 시간표 조회</h2>

<div style="flex-direction: row;">
	<form action="${pageContext.request.contextPath}/student/enrollSearchList" method="post">
		<button type="submit">수강신청 강의 목록 보기</button>
	</form>
</div>


<form action="${pageContext.request.contextPath}/student/enrollSearch" method="POST">


	<div style="display: flex;">
		<div style="flex-direction: row">
			<p>강의 구분</p>
			<select id="subject" name="subject">
				<option value='%'>전체</option>
				<option value="전공">전공</option>
				<option value="교양">교양</option>
			</select>
		</div>

		<div style="flex-direction: row">
			<p>&nbsp; 개설학과</p>
			<select id="department" name="department">
				<option value='%'>전체</option>
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

		<div style="flex-direction: row">
			<p>강의명</p>
			<select id="subjectname" name="subjectname">
				<option value='%'>전체</option>
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
		<button type="submit" style="margin-top: 50px">조회</button>
	</div>
</form>
<br>

<table border="1">
	<thead>
		<tr>
			<th>단과대학</th>
			<th>개설학과</th>
			<th>학수번호</th>
			<th>강의구분</th>
			<th style="width: 200px;">강의명</th>
			<th>담당교수</th>
			<th>학점</th>
			<th>요일시간 (강의실)</th>
			<th>현재인원</th>
		</tr>
	</thead>



	<%
	List<EnrollSearchDTO> dto = null;
	List<EnrollDTO> dto2 = null;
	if (request.getAttribute("subjectList") != null && request.getAttribute("enrollSearchDTO") != null) {
		dto = (List<EnrollSearchDTO>) request.getAttribute("subjectList");
		dto2 = (List<EnrollDTO>)request.getAttribute("enrollSearchDTO");
		
		int i;
		for (i = 0; i < dto.size(); i++) {
			
			boolean isEnrolled = false;
            for (EnrollDTO enroll : dto2) {
                if (Integer.valueOf(enroll.getSubjectId()).equals(Integer.valueOf(dto.get(i).getS_number()))) {
                    isEnrolled = true;
                    break;
                }
            }	
	%>

	<tr>
		<form action="${pageContext.request.contextPath}/student/enrolment" method="post">
			<td><%=dto.get(i).getC_name()%></td>
			<td><%=dto.get(i).getD_name()%></td>
			<td><%=dto.get(i).getS_number()%></td>
			<td><%=dto.get(i).getS_major_type()%></td>
			<td><%=dto.get(i).getS_name()%></td>
			<td><%=dto.get(i).getP_name()%></td>
			<td><%=dto.get(i).getS_grade()%></td>
			<td><%=dto.get(i).getS_room_id()%></td>
			<td>
			 <%
					if(isEnrolled == true){ %>
						 <button type="button" disabled="disabled">신청완료</button>
		                 
					<%} else {%>
						<button type="submit">신청하기</button>
						<input type="hidden" name="subjectname" value="<%=dto.get(i).getS_name()%>">
		                <input type="hidden" name="subjectnumber" value="<%=dto.get(i).getS_number()%>">
					<%}%>
			</td>
			
		</form>

	</tr>

		<%}%>

	<%}%>


</table>

<%@ include file="../main_footer.jsp"%>
