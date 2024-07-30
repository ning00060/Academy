<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.apache.tomcat.jakartaee.commons.lang3.ArrayUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tenco.model.subject.SubjectDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ include file="/WEB-INF/views/main_head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 강의</title>
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
        margin: 5px 0;
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
	<h2>내 강의</h2>
	<%
	List<SubjectDTO> subjectList = (List<SubjectDTO>)request.getAttribute("subjectList");
	if (subjectList != null) {
	%>
	<table>
		<tr>
			<th>과목코드</th>
			<th>강의명</th>
			<th>강의실</th>
			<th>계열/학과</th>
			<th>강의유형</th>
			<th>개설 년도</th>
			<th>학기</th>
			<th>학점</th>
			<th>액션</th>
		</tr>
		<%
			for(int i = 0; i< subjectList.size(); i++){
		%>
		<tr>
			<td><%=subjectList.get(i).getId()%></td>
			<td><%=subjectList.get(i).getName()%></td>
			<td><%=subjectList.get(i).getRoomId()%></td>
			<td><%=subjectList.get(i).getDepartmentName()%></td>
			<td><%=subjectList.get(i).getMajorType()%></td>
			<td><%=subjectList.get(i).getYear()%></td>
			<td><%=subjectList.get(i).getSemester()%></td>
			<td><%=subjectList.get(i).getGrades()%></td>
			<td>
				<form action="${pageContext.request.contextPath}/professor/selectsubject" method="GET">
					<input type="hidden" name="subjectId" value="<%=subjectList.get(i).getId()%>">
					<button type="submit">성적 입력</button>
				</form>
				<form action="${pageContext.request.contextPath}/professor/modifysubject" method="GET">
					<input type="hidden" name="subjectId" value="<%=subjectList.get(i).getId()%>">
					<button type="submit">성적 수정</button>
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
	<p>해당 학기에 개설된 강좌가 없습니다.</p>
	<%
	}
	%>
	<a href="${pageContext.request.contextPath}/professor/gohome">홈으로 돌아가기</a>
<%@ include file="/WEB-INF/views/main_footer.jsp"%>
</body>
</html>