<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
background-color: #f0f0f0;
display: flex;
flex-direction: column;
align-items: center;

}
header{
background-color: black;
color: white;
display: flex;
justify-content: space-between;
align-items: center;
width: 100%;

}

h2{
margin-left: 20px;
}

ul{
list-style-type: none;
display: flex;
}

li{
margin-right: 20px;
}
	
footer{
	background-color: #f0f0f0;
	display:flex;
	padding: 20px;
	border-radius: 8px;
	height:70vh;
	justify-content:center;
	width: 100%;
	
	}
.cm{

	align-content:flex-end;
	width: 300px;	
	
}
.homeMainDiv{
	
	display: flex;
	width: 1500px;
	flex-direction: column;

}
.homeChildDiv{
	display: flex;
	
}


</style>
</head>
<body>
	<header>
			<h2>  </h2>
			
				
			
			<%request.getSession().getAttribute("verifiedUser");%>
			<!-- permissionLevel (학생, 교수, 직원)에 따라 홈페이지의 헤더 부분의 카테고리의 내용이 달라진다. -->
			
			<c:if test="${verifiedUser.permissionLevel == 1}"> 
				<!-- 학생 카테고리 -->
				<h2> <a href="${pageContext.request.contextPath}/user/My">My</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/@@@@/subjectList">수강신청</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/@@@@/Semester">성적</a> </h2>
			</c:if>
			
			<c:if test="${verifiedUser.permissionLevel == 2}">
				<!-- 교수 카테고리   -->
				<h2> <a href="${pageContext.request.contextPath}/test/My">My</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/test/subjectList">수업</a> </h2>
			</c:if>
			
			<c:if test="${verifiedUser.permissionLevel == 3}">
				<!-- 관리직 카테고리   -->
				<h2> <a href="${pageContext.request.contextPath}/test/My">My</a> </h2>
				<h2> <a href="${pageContext.request.contextPath}/test/subjectList">학사관리</a> </h2>
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
	