<%@page
	import="jakarta.security.auth.message.callback.PrivateKeyCallback.SubjectKeyIDRequest"%>
<%@page import="com.tenco.model.student.StudentIdNameDTO"%>
<%@page import="java.util.List"%>
<%@ include file="/WEB-INF/views/main_head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 입력하기</title>
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
        width: 80%;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }
    table {
        width: 100%;
        margin: 20px 0;
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
    input[type="text"] {
        width: 90%;
        padding: 5px;
        margin: 5px 0;
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
	<h2>학점 입력하기</h2>
	<%
	List<StudentIdNameDTO> studentList = (List<StudentIdNameDTO>) request.getAttribute("studentList");
	if (studentList != null) {
	%>
	<form action="${pageContext.request.contextPath}/professor/input-grade" method="GET">
		<table>
			<tr>
				<th>순번</th>
				<th>학번</th>
				<th>성명</th>
				<th>중간고사 성적</th>
				<th>기말고사 성적</th>
				<th>환산 점수</th>
				<th>비고</th>
			</tr>
			<%
			int i;
			for (i = 0; i < studentList.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=studentList.get(i).getId()%></td>
				<td><%=studentList.get(i).getName()%></td>
				<td><input type="text" name="midExamScore<%=i+1%>" value="90"></td>
				<td><input type="text" name="finalExamScore<%=i+1%>" value="80"></td>
				<td><input type="text" name="grade<%=i+1%>" value="4.0"></td>
				<td><input type="hidden" name="studentId<%=i+1%>" value="<%=studentList.get(i).getId()%>"></td>
			</tr>
			<%
			}
			%>
		</table>
		<input type="hidden" name="studentSize" value="<%=i%>">
		<input type="hidden" name="subjectId" value="<%=request.getAttribute("subjectId")%>">
		<button type="submit">학점 입력</button>
	</form>
	<%
	} else {
	%>
	<p>해당 강의에 수강중인 학생이 없습니다.</p>
	<%
	}
	%>
	<a href="${pageContext.request.contextPath}/professor/gohome">홈으로 돌아가기</a>
<%@ include file="/WEB-INF/views/main_footer.jsp"%>
</body>
</html>