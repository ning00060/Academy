<%@page import="com.tenco.model.user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resource/style.css" rel="stylesheet" type="text/css">
<style>
    body {
        font-family: 'Arial', sans-serif;
        color: #000000;
        margin: 0;
        padding: 0;
    }
    header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #00AEEF;
        padding: 10px 20px;
    }
    header img {
        height: 60px; /* 로고 이미지 높이 조정 */
    }
    .header-links {
        display: flex;
        justify-content: center;
        flex-grow: 1;
        margin-left: 20px;
    }
    h3 a{
    	margin: 10px 50px;
    	
    }
    .header-links h3 {
        margin: 0 15px;
        color: #FFFFFF;
    }
    .header-links a {
        text-decoration: none;
        color: inherit;
    }
    nav ul {
        list-style: none;
        padding: 0;
        margin: 0;
        display: flex;
    }
    nav ul li {
        margin-left: 20px;
        color: #FFFFFF;
    }
    nav ul li a {
        color: #FFFFFF;
        text-decoration: none;
    }
</style>
</head>
<body>
    <header>
        <% UserDTO userDTO = (UserDTO) request.getSession().getAttribute("verifiedUser"); %>
        <a href="${pageContext.request.contextPath}/user/home"> 
            <img alt="로고" src="../resource/favicon.ico">
        </a>
        <div class="header-links">
            <c:if test="${verifiedUser.permissionLevel == 1}">
                <h3><a href="${pageContext.request.contextPath}/user/home">홈@</a></h3>
                <h3><a href="${pageContext.request.contextPath}/user/myInfo">My</a></h3>
                <h3><a href="${pageContext.request.contextPath}/test/subjectList">수업</a></h3>
                <h3><a href="${pageContext.request.contextPath}/student/enrollSearch">수강신청</a></h3>
                <h3><a href="${pageContext.request.contextPath}/student/restClassList">휴/보강 조회</a></h3>
                <h3><a href="${pageContext.request.contextPath}/@@@@/Semester">성적</a></h3>
                <h3><a href="${pageContext.request.contextPath}/@@@@/Semester">학사정보</a></h3>
            </c:if>
            <c:if test="${verifiedUser.permissionLevel == 2}">
                <h3><a href="${pageContext.request.contextPath}/professor/123123"></a></h3>
                <h3><a href="${pageContext.request.contextPath}/professor/readHopeClassList">개설 강좌 관리</a></h3>
                <h3><a href="${pageContext.request.contextPath}/professor/clickERMenu">강의 평가 조회</a></h3>
                <h3><a href="${pageContext.request.contextPath}/professor/goinputpage">학생 성적 관리</a></h3>
                <h3><a href="${pageContext.request.contextPath}/professor/restclassmanagement">휴/보강 관리</a></h3>
            </c:if>
            <c:if test="${verifiedUser.permissionLevel == 3}">
                <h3><a href="${pageContext.request.contextPath}/user/home">홈@</a></h3>
                <h3><a href="${pageContext.request.contextPath}/test/My">My</a></h3>
                <div class="dropdown">
                    <button class="dropbtn">관리</button>
                    <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/staff/tuition">등록금</a>
                        <a href="${pageContext.request.contextPath}/staff/scholarship">장학금</a>
                        <a href="${pageContext.request.contextPath}/staff/subjectList">학사관리</a>
                    </div>
                </div>
                <div class="dropdown">
                    <h3>유저관리</h3>
                    <div class="dropdown-content">
                        <h3>등록</h3>
                        <a href="${pageContext.request.contextPath}/staff/registPro">교수</a>
                        <a href="${pageContext.request.contextPath}/staff/registStaff">직원</a>
                        <a href="${pageContext.request.contextPath}/staff/registStu">학생</a>
                    </div>
                    <div class="dropdown-content">
                        <h3>수정</h3>
                        <a href="${pageContext.request.contextPath}/staff/updatePro">교수</a>
                        <a href="${pageContext.request.contextPath}/staff/updateStaff">직원</a>
                        <a href="${pageContext.request.contextPath}/staff/updateStu">학생</a>
                    </div>
                </div>
                <div class="dropdown">
                    <h3>관리</h3>
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
            <ul>
                <li><%=userDTO.getId()%> <%=userDTO.getName()%></li>
                <li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
            </ul>
        </nav>
    </header>
</body>
</html>