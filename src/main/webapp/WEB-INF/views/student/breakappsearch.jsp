<%@page import="com.tenco.model.student.StudentDTO"%>
<%@page import="com.tenco.model.student.breakappDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../main_head.jsp" %>

<% StudentDTO studentDTO = (StudentDTO)request.getSession().getAttribute("studentDTO"); %>
<% breakappDTO breakappDTO = (breakappDTO)request.getAttribute("breakappDTO"); %>

<h1>휴학 신청 목록 입니다.</h1>

<div >
 		
 		<div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="/Academy/user/myInfo" class="selected--menu">내 정보 조회 및 수정</a></td>
                </tr>
                <tr>
                    <td><a href="/Academy/student/breakApp">휴학 신청</a></td>
                </tr>
                <tr>
                    <td><a href="/Academy/student/breakSearch">휴학 내역 조회</a></td>
                </tr>
                <tr>
                    <td><a href="/tuition/list">등록금 내역 조회</a></td>
                </tr>
                <tr>
                    <td><a href="/tuition/payment">등록금 납부 고지서</a></td>
                </tr>
            </table>
        </div>
		
        </div>


<div>
<table border="1">

<th>신청일자</th>
<td> <%= breakappDTO.getApp_date()%></td>

<th>구분</th>
<td> <%= breakappDTO.getType()%></td>

<th>시작학기</th>
<td> <%= breakappDTO.getFrom_semester()%></td>


<th>종료학기</th>
<td> <%= breakappDTO.getTo_semester()%></td>


<th>처리상태</th>
<td> <%= breakappDTO.getStatus() %></td>
</div>

<%@ include file="../main_footer.jsp"%>