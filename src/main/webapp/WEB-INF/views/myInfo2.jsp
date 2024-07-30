<%@page import="com.tenco.model.student.StudentDTO"%>
<%@page import="com.tenco.model.user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="main_head.jsp" %>

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
    display: block;
    padding: 10px;
    white-space: nowrap; /* Prevent line breaks */
}

.sub--menu--table td a:hover, .selected--menu {
    color: black;
    display: block;
    padding: 10px;
    border-radius: 5px;
}

.sub--menu--table td a.selected--menu {
    width: 100%;
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
    width: 25%; /* Adjust header width */
}

.input--table td {
    width: 75%; /* Adjust data cell width */
    border-left: none; /* Remove vertical line next to input */
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
                        <td><a href="/tuition/list">등록금 내역 조회</td>
                    </tr>
                    <tr>
                        <td><a href="/tuition/payment">등록금 납부 고지서</a></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <div class="main-content">
            <% StudentDTO student = (StudentDTO)request.getAttribute("studentDTO"); %> 
            <h1 class="info-title">내 정보 조회</h1>
            <div class="split--div"></div>
            <form action="${pageContext.request.contextPath}/user/update" method="post">
                <table border="1" class="input--table">
                    <colgroup>
                        <col class="col1">
                        <col class="col2">
                    </colgroup>
                    <tr>
                        <th>주소</th>
                        <td><input type="text" name="address" value="<%= student.getAddress()%>"></td>
                    </tr>
                    <tr>
                        <th>전화번호</th>
                        <td><input type="text" name="tel" value="<%= student.getTel()%>"></td>
                    </tr>
                    <tr>
                        <th>이메일</th>
                        <td><input type="text" name="email" value="<%= student.getEmail()%>"></td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="password" name="password" value="<%= student.getU_password() %>"></td>
                    </tr>
                </table>
                <button type="submit" class="update--button">변경하기</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="main_footer.jsp"%>
