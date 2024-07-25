<%@page import="com.tenco.model.user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="../resource/style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
			<h2>  </h2>
			
				
			
			<% UserDTO userDTO= (UserDTO) request.getSession().getAttribute("verifiedUser");%>
			<P><%=userDTO.getName() %> </P>
			<!-- permissionLevel (학생, 교수, 직원)에 따라 홈페이지의 헤더 부분의 카테고리의 내용이 달라진다. -->
				
			<c:if test="${verifiedUser.permissionLevel == 1}"> 
				<!-- 학생 카테고리 -->
				<h2> <a href="${pageContext.request.contextPath}/user/myInfo">My</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/@@@@/subjectList">수강신청</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/@@@@/Semester">성적</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/user/evaluation">강의평가</a> </h2>
			</c:if>
			
			<c:if test="${verifiedUser.permissionLevel == 2}">
				<!-- 교수 카테고리   -->
				<h2> <a href="${pageContext.request.contextPath}/professor/123123"></a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/professor/clickERMenu">강의 평가 조회</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/professor/goinputpage">학생 성적 관리</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/professor/restclassmanagement">휴/보강 관리</a> </h2>
			</c:if>
			
			<c:if test="${verifiedUser.permissionLevel == 3}">
				<!-- 관리직 카테고리   -->
				<h2> <a href="${pageContext.request.contextPath}/test/My">My</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/staff/subjectList">학사관리</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/test/Semester">등록</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/test/notice">학사정보</a> </h2>
			</c:if>
			
			
			<c:if test="@@">
				<!-- 혹시 위에서 없어지면 여기서 가져오면 된다.(백업용) -->
			<h2> <a href="${pageContext.request.contextPath}/test/home">홈@</a> </h2>
			<h2> <a href="${pageContext.request.contextPath}/test/My">My@</a> </h2>
			<h2> <a href="${pageContext.request.contextPath}/test/subjectList">수강신청@</a> </h2>
			<h2> <a href="${pageContext.request.contextPath}/test/Semester">성적@</a> </h2>
			<h2> <a href="${pageContext.request.contextPath}/test/notice">학사정보@</a> </h2>
			</c:if>
			
			<nav>
				<ul>
					<li>홈</li>
					<li>로그인</li>
				</ul>
			</nav>
		
	</header>
	