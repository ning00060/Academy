<%@page import="com.tenco.model.user.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.tenco.model.temp.EnrollDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../main_head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시간표</title>
<style type="text/css">
    body {
        display: flex;
        flex-direction: column;
        align-items: center;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        background-color: #f4f4f4;
    }
    .front {
        margin-top: 20px;
        font-size: 24px;
        font-weight: bold;
    }
    .information {
        margin: 20px 0;
        text-align: center;
    }
    .information p {
        margin: 5px 0;
        font-weight: bold;
    }
    .information input {
        border: 1px solid #ccc;
        padding: 5px;
        margin: 5px 0;
        width: 200px;
        text-align: center;
    }
    .schedule {
        margin: 20px 0;
        width: 80%;
    }
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
        font-weight: bold;
    }
    td.true {
        font-weight: bold;
        background-color: #007bff;
        color: white;
    }
    td.empty {
        background-color: #606060;
    }
</style>
</head>
<body>
    <% List<EnrollDTO> enrollList = (List<EnrollDTO>) request.getAttribute("enrollList"); %>
    <% UserDTO userDTO2 = (UserDTO) session.getAttribute("verifiedUser"); %>

    <h1 class="front">대학 수업 시간표</h1>

    <div class="information">
        <p>학번/성명</p>
        <input type="text" readonly value="<%= userDTO2.getId() %>">
        <input type="text" readonly value="<%= userDTO2.getName() %>">
    </div>

    <div class="schedule">
        <table>
            <tr>
                <th>시간</th>
                <th>월요일</th>
                <th>화요일</th>
                <th>수요일</th>
                <th>목요일</th>
                <th>금요일</th>
            </tr>

            <% String[] timeSelection  = {
                "", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", 
                "12:00 - 13:00", "13:00 - 14:00", "14:00 - 15:00", 
                "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00"
            }; %>  

            <% for (int i = 1; i < 10; i++) { %>
                <tr>
                    <td><%= timeSelection[i] %></td>
                    <% for (int j = 1; j < 6; j++) { 
                        boolean isClassScheduled = false; %>
                        <% for (EnrollDTO enroll : enrollList) { 
                            if (enroll.getDay() == j && enroll.getPeriod() == i) { 
                                isClassScheduled = true; %>
                                <td class="true"><%= enroll.getSubjectName() %></td>
                            <% } 
                        } %>
                        <% if (!isClassScheduled) { %>
                            <td class="empty"></td>
                        <% } %>
                    <% } %>
                </tr>
            <% } %>
        </table>
    </div>
    <%@ include file="../main_footer.jsp"%>
</body>
</html>
