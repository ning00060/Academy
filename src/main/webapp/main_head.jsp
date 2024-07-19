<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
}
header{
background-color: black;
color: white;
display: flex;
justify-content: space-between;
align-items: center;

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

</style>
</head>
<body>
	<header>
			<h2>  </h2>
			<h2> <a href="${pageContext.request.contextPath}/test/home">홈</a> </h2>
			
			<h2> <a href="${pageContext.request.contextPath}/test/My">My</a> </h2>
			
			<h2> <a href="${pageContext.request.contextPath}/test/subjectList">수강신청</a> </h2>
			
			<h2> <a href="${pageContext.request.contextPath}/test/Semester">성적</a> </h2>
			
			<h2> <a href="${pageContext.request.contextPath}/test/notice">학사정보</a> </h2>
			
			<nav>
				<ul>
					<li>홈</li>
					<li>로그인</li>
				</ul>
			</nav>
		
	</header>
	