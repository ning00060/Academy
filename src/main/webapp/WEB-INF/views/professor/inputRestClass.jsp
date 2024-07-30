<%@page import="com.tenco.model.subject.SubjectDTO"%>
<%@page import="java.util.List"%>
<%@page
    import="jakarta.security.auth.message.callback.PrivateKeyCallback.SubjectKeyIDRequest"%>
<%@ include file="/WEB-INF/views/main_head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>휴강일정 입력하기</title>
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
    form {
        width: 50%;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }
    label {
        display: block;
        margin: 10px 0 5px;
        font-weight: bold;
    }
    select, textarea, input[type="text"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    button {
        background-color: #00539B;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 5px;
        width: 100%;
        font-size: 16px;
    }
    button:hover {
        background-color: #012169;
    }
    p {
        text-align: center;
        color: #00539B;
    }
    a {
        display: block;
        text-align: center;
        margin: 20px 0;
        color: #00539B;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <h2>휴강일정 입력하기</h2>
    <%
    List<SubjectDTO> subjectList = (List<SubjectDTO>) request.getAttribute("subjectList");
    if (subjectList != null) {
    %>
    <form action="${pageContext.request.contextPath}/professor/inputRestClass" method="GET">
        <input type="hidden" name="professorId" value="<%=request.getParameter("professorId")%>"> 
        <input type="hidden" name="year" value="<%=request.getParameter("year")%>"> 
        <input type="hidden" name="semester" value="<%=request.getParameter("semester")%>"> 

        <label for="subjectId">과목 선택</label>
        <select id="selectSub" name="selectSub">
        <% int i=0;
        for (i = 0; i < subjectList.size(); i++) {%>
            <option value="<%=i%>">과목코드 : <%=subjectList.get(i).getId()%>, 강의명 : <%=subjectList.get(i).getName()%></option>
        <%}%>
        </select>        

        <label for="restDay">휴강 일정 및 사유:</label>
        <textarea id="restDay" name="restDay" rows="4" cols="50" required></textarea><br><br>

        <label for="supplement">보강 계획:</label>
        <textarea id="supplement" name="supplement" rows="4" cols="50" required></textarea><br><br>

        <button type="submit">입력</button>
    </form>
    <%
    } else {
    %>
    <p>이번 학기에 개설하신 강좌가 없습니다.</p>
    <%
    }
    %>
    <a href="${pageContext.request.contextPath}/professor/gohome">홈으로 돌아가기</a>
<%@ include file="/WEB-INF/views/main_footer.jsp"%>
</body>
</html>