<<<<<<< HEAD
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="org.apache.tomcat.jakartaee.commons.lang3.ArrayUtils"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.tenco.model.subject.SubjectDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../main_head.jsp"%>

<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }

        h2 {
            text-align: center;
            margin-top: 20px;
            color: #444;
        }

        table {
            width: 90%;
            max-width: 1200px;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table th, table td {
            padding: 15px;
            text-align: left;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #f5f5f5;
        }

        button {
            background-color: #007bff;
            color: #fff;
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #0056b3;
        }
    </style>
</head>

<body>
    <h2>내 강의 리스트</h2>
    <%
        List<SubjectDTO> subjectList = (List<SubjectDTO>) request.getAttribute("subjectList");
        if (subjectList != null) {
    %>
    <table>
        <thead>
            <tr>
                <th>과목코드</th>
                <th>강의명</th>
                <th>강의실</th>
                <th>계열/학과</th>
                <th>강의유형</th>
                <th>개설 년도</th>
                <th>학기</th>
                <th>학점</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <%
            for (int i = 0; i < subjectList.size(); i++) {
        %>
            <tr>
                <td><%= subjectList.get(i).getId() %></td>
                <td><%= subjectList.get(i).getName() %></td>
                <td><%= subjectList.get(i).getRoomId() %></td>
                <td><%= subjectList.get(i).getDepartmentName() %></td>
                <td><%= subjectList.get(i).getMajorType() %></td>
                <td><%= subjectList.get(i).getYear() %></td>
                <td><%= subjectList.get(i).getSemester() %></td>
                <td><%= subjectList.get(i).getGrades() %></td>
                <td>
                    <form action="${pageContext.request.contextPath}/professor/resultcheck" method="GET">
                        <input type="hidden" name="subjectId" value="<%= subjectList.get(i).getId() %>">
                        <input type="hidden" name="subjectName" value="<%= subjectList.get(i).getName() %>">
                        <button type="submit">강의평가 결과 확인하기</button>
                    </form>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
        } else {
    %>
    <p>해당 학기에 개설된 강좌가 없습니다.</p>
    <%
        }
    %>
    <a href="${pageContext.request.contextPath}/professor/gohome">홈으로 돌아가기</a>
    <%@ include file="../main_footer.jsp"%>
</body>
=======
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
<title>내 강의 리스트</title>
</head>
<body>
	<h2>내 강의 리스트</h2>
	<%
	List<SubjectDTO> subjectList = (List<SubjectDTO>)request.getAttribute("subjectList");
	if (subjectList != null) {
	%>
	<table border="1">
		<tr>
			<th>과목코드:</th>
			<th>강의명:</th>
			<th>강의실:</th>
			<th>계열/학과:</th>
			<th>강의유형:</th>
			<th>개설 년도:</th>
			<th>학기:</th>
			<th>학점:</th>
			<th></th>
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
				<form
					action="${pageContext.request.contextPath}/professor/resultcheck"
					method="GET">
					<input type="hidden" name="subjectId" value="<%=subjectList.get(i).getId()%>">
					<input type="hidden" name="subjectName" value="<%=subjectList.get(i).getName()%>">
					<button type="submit">강의평가 결과 확인하기</button>
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
>>>>>>> dev2
