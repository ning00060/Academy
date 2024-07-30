<%@page import="com.tenco.model.student.StudentDTO"%>
<%@page import="com.tenco.model.student.breakappDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../main_head.jsp" %>

<style>
/* General Styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.myInfoMainDiv {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px 40px; /* Increase padding for horizontal margins */
    background-color: white;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    margin: 20px auto;
    max-width: 1200px; /* Adjust width as needed */
}

.content {
    display: flex;
    flex-direction: row;
    width: 100%;
    margin-left: 20px; /* Add left margin */
    margin-right: 20px; /* Add right margin */
}

.sidebar, .main-content {
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    background-color: white;
}

.sidebar {
    flex: 1;
    margin-right: 20px;
}

.main-content {
    flex: 3;
}

h1, h2 {
    color: #0056b3;
}

h2 {
    margin-bottom: 10px;
}

h1.info-title {
    color: #0056b3; /* Ensure the heading color is set properly */
    background-color: transparent; /* Ensure background is transparent */
}

.sub--menu--mid {
    margin-bottom: 20px;
}

.sub--menu--table {
    width: 100%;
    margin-bottom: 20px;
    border-collapse: collapse;
}

.sub--menu--table td {
    padding: 10px;
    text-align: center;
    background-color: #f0f0f0;
}

.sub--menu--table td a {
    color: #0056b3;
    text-decoration: none;
}

.sub--menu--table td a:hover, .selected--menu {
    color: black;
    display: block;
    border-radius: 5px;
}

.input--table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

.input--table th, .input--table td {
    padding: 10px;
    text-align: left;
    border: 1px solid #ddd;
}

.input--table th {
    background-color: #f0f0f0;
}

.input--table col.col1, .input--table col.col3 {
    width: 20%;
}

.input--table col.col2, .input--table col.col4 {
    width: 30%;
}

.split--div {
    margin: 20px 0;
    height: 1px;
    background-color: #ddd;
    width: 100%;
}

.update--button {
    background-color: #0056b3;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.update--button:hover {
    background-color: #003d80;
}
</style>

<div class="myInfoMainDiv">
    <div class="content">
        <div class="sidebar">
            <h2>MY</h2>
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
        
    <div class="main-content">
    <%
   
   		 breakappDTO breakappDTO = null;
        if( request.getAttribute("breakappDTO") != null) {
        	StudentDTO studentDTO = (StudentDTO)request.getSession().getAttribute("studentDTO"); 
            breakappDTO = (breakappDTO)request.getAttribute("breakappDTO"); // 속성을 올바르게 캐스팅
    %>
            <h1 class="info-title">휴학 신청 목록입니다.</h1>
            <div class="split--div"></div>
            <table border="1" class="input--table">
                <colgroup>
                    <col class="col1">
                    <col class="col2">
                    <col class="col3">
                    <col class="col4">
                </colgroup>
                <tr>
                    <th>신청일자</th>
                    <td><%= breakappDTO.getApp_date() %></td> <!-- 올바른 변수 이름 사용 -->
                    <th>구분</th>
                    <td><%= breakappDTO.getType() %></td> <!-- 올바른 변수 이름 사용 -->
                </tr>
                <tr>
                    <th>시작학기</th>
                    <td><%= breakappDTO.getFrom_semester() %></td> <!-- 올바른 변수 이름 사용 -->
                    <th>종료학기</th>
                    <td><%= breakappDTO.getTo_semester() %></td> <!-- 올바른 변수 이름 사용 -->
                </tr>
                <tr>
                    <th>처리상태</th>
                    <td colspan="3"><%= breakappDTO.getStatus() %></td> <!-- 올바른 변수 이름 사용 -->
                </tr>
            </table>
        </div>
    </div>
</div>
    <%
        } else {
    %>
        <h1>목록 없음</h1>
    <%
        }
    %>

            

<%@ include file="../main_footer.jsp" %>
