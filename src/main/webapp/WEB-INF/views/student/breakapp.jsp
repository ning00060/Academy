<%@page import="com.tenco.model.student.StudentDTO"%>
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
    display: block;
}

.sub--menu--table td a:hover, .selected--menu {
    color: black;
    display: block;
    padding: 10px;
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
    width: 20%; /* Adjust header width */
}

.input--table td {
    width: 30%; /* Adjust data cell width */
}

.input--table .wide-th {
    width: 30%; /* Increase width for period row */
}

.input--table .wide-td {
    width: 70%; /* Increase width for period row */
}

.split--div {
    margin: 20px 0;
    height: 1px;
    background-color: #ddd;
    width: 100%;
}

.submit--button {
    background-color: #0056b3;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.submit--button:hover {
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
            <% StudentDTO student = (StudentDTO)session.getAttribute("studentDTO"); %>    
            <h1 class="info-title">휴학 신청</h1>
            <div class="split--div"></div>
            <form action="${pageContext.request.contextPath}/student/breakPost" method="post">
                <table border="1" class="input--table">
                    <colgroup>
                        <col class="col1">
                        <col class="col2">
                    </colgroup>
                    <tr>
                        <th>학번</th>
                        <td><%= student.getId() %></td>
                        <th>소속</th>
                        <td><%= student.getD_name() %></td>
                    </tr>
                    <tr>
                        <th>학년</th>
                        <td><%= student.getGrade() %></td>
                        <th>학기</th>
                        <td><%= student.getSemester() %></td>
                    </tr>
                    <tr>
                        <th>입학일</th>
                        <td><%= student.getEntrance_date() %></td>
                        <th>졸업일(졸업예정일)</th>
                        <td><%= student.getGraduation_date() == null ? "" : student.getGraduation_date() %></td>
                    </tr>
                </table>
                
                <table border="1" class="input--table">
                    <colgroup>
                        <col class="col1">
                        <col class="col2">
                    </colgroup>
                    <tr>
                        <th>성명</th>
                        <td><%= student.getName() %></td>
                        <th>생년월일</th>
                        <td><%= student.getBirth_date() %></td>
                    </tr>
                    <tr>
                        <th>성별</th>
                        <td><%= student.getGender() %></td>
                        <th>주소</th>
                        <td><%= student.getAddress() %></td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td><%= student.getTel() %></td>
                        <th>email</th>
                        <td><%= student.getEmail() %></td>
                    </tr>
                    <tr>
                        <th class="wide-th">기간</th>
                        <td class="wide-td" colspan="3">
                            <p>
                                <input type="text" readonly name="year0" value="2023">년
                                <input type="text" readonly name="semester0" value="1">학기 부터
                                <select id="year" name="year">
                                    <option value="2023">2023</option>
                                    <option value="2024">2024</option>
                                    <option value="2025">2025</option>
                                </select> 년도
                                <select id="semester" name="semester">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                </select> 학기 까지
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <th>휴학구분</th>
                        <td colspan="3">
                            <select id="bre" name="bre">
                                <option value="일반휴학">일반휴학</option>
                                <option value="육아휴학">육아휴학</option>
                                <option value="질병휴학">질병휴학</option>
                                <option value="창업휴학">창업휴학</option>
                                <option value="군입대휴학">군입대휴학</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <button type="submit" class="submit--button">신청하기</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="../main_footer.jsp" %>
