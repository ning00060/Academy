<%@page import="com.tenco.model.subject.HopeClassDTO"%>
<%@page import="com.tenco.model.subject.SubjectDTO"%>
<%@page import="java.util.List"%>
<%@ include file="/WEB-INF/views/main_head.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개설 희망 강좌 목록</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        color: #333;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    h2 {
        color: #012169;
        text-align: center;
        padding: 20px 0;
        border-bottom: 2px solid #00539B;
        margin-bottom: 20px;
    }
    table {
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 12px;
        text-align: center;
    }
    th {
        background-color: #00539B;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    button {
        background-color: #00539B;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 5px;
    }
    button:hover {
        background-color: #012169;
    }
    form {
        display: inline;
    }
    p {
        text-align: center;
        color: #00539B;
    }
    .actions {
        text-align: center;
        margin-top: 20px;
    }
    .actions a, .actions button {
        margin: 0 10px;
    }
</style>
</head>
<body>
    <h2> 개설 희망 강좌 목록 </h2>
    <%
    List<HopeClassDTO> hopeClassList = (List<HopeClassDTO>)request.getAttribute("hopeClassList");
    if (hopeClassList.size() != 0) {
    %>
    <table>
        <tr>
            <th>구분</th>
            <th>개설 강의명</th>
            <th>희망 강의실</th>
            <th>계열코드</th>
            <th>강의유형</th>
            <th>희망 개설 년도</th>
            <th>개설 학기</th>
            <th>배정 학점</th>
            <th>액션</th>
        </tr>
        <%
        for(int i = 0; i < hopeClassList.size(); i++) {
        %>
        <tr>
            <td><%= i + 1 %></td>
            <td><%= hopeClassList.get(i).getName() %></td>
            <td><%= hopeClassList.get(i).getRoomId() %></td>
            <td><%= hopeClassList.get(i).getDeptId() %></td>
            <td><%= hopeClassList.get(i).getMajorType() %></td>
            <td><%= hopeClassList.get(i).getYear() %></td>
            <td><%= hopeClassList.get(i).getSemester() %></td>
            <td><%= hopeClassList.get(i).getGrades() %></td>
            <td>
                <form action="${pageContext.request.contextPath}/professor/deleteHopeClass" method="GET">
                    <input type="hidden" name="id" value="<%= hopeClassList.get(i).getId() %>">
                    <input type="hidden" name="professorId" value="<%= hopeClassList.get(i).getProfessorId() %>">
                    <button type="submit">삭제하기</button>
                </form>
            </td>
        </tr>
        <%
        }
        %>
    </table>
    <%
    } else {
    %>
    <p>현재 개설 요청한 강좌가 없습니다.</p>
    <%
    }
    %>
    <div class="actions">
        <form action="${pageContext.request.contextPath}/professor/addHopeClass" method="GET">
            <input type="hidden" name="deptId" value="<%=request.getAttribute("deptId")%>">
            <input type="hidden" name="professorId" value="<%=request.getAttribute("professorId")%>">
            <button type="submit">강좌 개설 요청하기</button>
        </form>
        <a href="${pageContext.request.contextPath}/professor/gohome">
            <button>홈으로 돌아가기</button>
        </a>
    </div>
<%@ include file="/WEB-INF/views/main_footer.jsp"%>
</body>
</html>