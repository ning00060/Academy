<%@ page import="com.tenco.model.user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
<link href="../resource/style.css" rel="stylesheet" type="text/css">
<style>
 body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #007bff;
        padding: 10px 20px;
        color: white;
        height: 100px; /* Ensures the header has enough height */
    }

    .main--logo {
        display: flex;
        align-items: center;
        height: 100%;
    }

    .main--logo img {
        height: 100%;
    }

    .header-links {
        display: flex;
        align-items: center;
    }

    .header-links h3 {
        margin: 0 10px;
        font-size: 18px;
    }

    .header-links a {
        color: white;
        text-decoration: none;
        font-size: 20px;
        background-color: #0056b3; /* Box background color */
        padding: 10px 15px; /* Padding inside each box */
        border-radius: 5px; /* Rounded corners for each box */
        margin: 0 5px; /* Space between boxes */
        transition: background-color 0.3s ease;
    }

    .header-links a:hover {
        background-color: #003d80; /* Darker background on hover */
    }

    .header-links .dropdown {
        position: relative;
        display: inline-block;
    }

    .header-links .dropbtn {
        background-color: #007bff;
        color: white;
        font-size: 18px;
        border: none;
        cursor: pointer;
    }

    .header-links .dropdown-content {
        display: none;
        position: absolute;
        background-color: white;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    .header-links .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .header-links .dropdown-content a:hover {
        background-color: #ddd;
    }

    .header-links .dropdown:hover .dropdown-content {
        display: block;
    }

    .header-links .dropdown:hover .dropbtn {
        background-color: #0056b3;
    }

    nav ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        display: flex;
        align-items: center;
    }

    nav ul li {
    	color: white;
    	background-color: #0056b3; /* Box background color */
        font-size: 18px;
        text-decoration: none;
         padding: 10px 15px; /* Padding inside each box */
        border-radius: 5px; /* Rounded corners for each box */
        margin: 0 5px; /* Space between boxes */
        
    }

    nav ul li a {
        color: white;
        text-decoration: none;
        background-color: #0056b3; /* Box background color */
        padding: 10px 15px; /* Padding inside each box */
        border-radius: 5px; /* Rounded corners for each box */
        margin: 0 5px; /* Space between boxes */
        
    }

    nav ul li a:hover {
        background-color: #003d80; /* Darker background on hover */
    }

    nav ul li:hover {
        background-color: #003d80; /* Darker background on hover */
    }

    .user-info {
        background-color: #0056b3;
        padding: 10px 20px;
        border-radius: 5px;
        display: flex;
        align-items: center;
    }

    .user-info li {
        margin: 0 10px;
    }

    .user-info .user-id,
    .user-info .user-name {
        margin-right: 20px;
    }
</style>
</head>
<body>
    <header>
        <% UserDTO userDTO = (UserDTO) request.getSession().getAttribute("verifiedUser"); %>
        <div class="main--logo">
            <a href="${pageContext.request.contextPath}/user/home"> 
                <img alt="로고" src="../resource/favicon.ico">
            </a>
        </div>
        <div class="header-links">
            <c:if test="${verifiedUser.permissionLevel == 1}">
                <h3><a href="${pageContext.request.contextPath}/user/home">홈</a></h3>
                <h3><a href="${pageContext.request.contextPath}/user/myInfo">My</a></h3>
                <h3><a href="${pageContext.request.contextPath}/student/subjectList">수업</a></h3>
                <h3><a href="${pageContext.request.contextPath}/student/enrollSearch">수강신청</a></h3>
                <h3><a href="${pageContext.request.contextPath}/student/restClassList">휴/보강 조회</a></h3>
                <h3><a href="${pageContext.request.contextPath}/@@@@/Semester">성적</a></h3>
                <h3><a href="${pageContext.request.contextPath}/@@@@/Semester">학사정보</a></h3>
            </c:if>
            <c:if test="${verifiedUser.permissionLevel == 2}">
                <h3><a href="${pageContext.request.contextPath}/professor/readHopeClassList">개설 강좌 관리</a></h3>
                <h3><a href="${pageContext.request.contextPath}/professor/clickERMenu">강의 평가 조회</a></h3>
                <h3><a href="${pageContext.request.contextPath}/professor/goinputpage">학생 성적 관리</a></h3>
                <h3><a href="${pageContext.request.contextPath}/professor/restclassmanagement">휴/보강 관리</a></h3>
            </c:if>
            <c:if test="${verifiedUser.permissionLevel == 3}">
                <h3><a href="${pageContext.request.contextPath}/user/home">홈</a></h3>
                <div class="dropdown">
                    <button class="dropbtn">관리</button>
                    <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/staff/tuition">등록금</a>
                        <a href="${pageContext.request.contextPath}/staff/tuitionModify">등록금 등록</a>
                        <a href="${pageContext.request.contextPath}/staff/scholarship">장학금</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="dropbtn">유저관리</button>
                    <div class="dropdown-content">
                        <h4>등록</h4>
                        <a href="${pageContext.request.contextPath}/staff/registPro">교수</a>
                        <a href="${pageContext.request.contextPath}/staff/registStaff">직원</a>
                        <a href="${pageContext.request.contextPath}/staff/registStu">학생</a>
                        <h4>수정</h4>
                        <a href="${pageContext.request.contextPath}/staff/updatePro">교수</a>
                        <a href="${pageContext.request.contextPath}/staff/updateStaff">직원</a>
                        <a href="${pageContext.request.contextPath}/staff/updateStu">학생</a>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="dropbtn">관리</button>
                    <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/staff/depart">대학관리</a>
                        <a href="${pageContext.request.contextPath}/staff/selectDepart">대학수정</a>
                        <a href="${pageContext.request.contextPath}/staff/room">강의실관리</a>
                        <a href="${pageContext.request.contextPath}/staff/selectRoom">강의실수정</a>
                        <a href="${pageContext.request.contextPath}/staff/subject">강의관리</a>
                        <a href="${pageContext.request.contextPath}/staff/selectSubject">강의요청</a>
                    </div>
                </div>
            </c:if>
        </div>
        <nav>
            <ul class="user-info">
                <li class="user-id"><%= userDTO.getId() %></li>
                <li class="user-name"><%= userDTO.getName() %></li>
                <li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
            </ul>
        </nav>
    </header>
</body>
</html>
