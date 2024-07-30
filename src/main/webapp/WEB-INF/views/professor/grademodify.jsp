<%@page import="com.tenco.model.professor.StudentGradeDTO"%>
<%@page
	import="jakarta.security.auth.message.callback.PrivateKeyCallback.SubjectKeyIDRequest"%>

<%@page import="java.util.List"%>
<%@ include file="/WEB-INF/views/main_head.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 수정하기</title>
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
	<h2>학점 수정하기</h2>
	<%
	List<StudentGradeDTO> gradeList = (List<StudentGradeDTO>) request.getAttribute("gradeList");
	if (gradeList.size() != 0) {
	%>
	<form action="${pageContext.request.contextPath}/professor/update-grade" method="GET">
		<table>
			<tr>
				<th>순번</th>
				<th>학번</th>
				<th>성명</th>
				<th>강의코드</th>
				<th>강의명</th>
				<th>중간고사 성적</th>
				<th>기말고사 성적</th>
				<th>환산 점수</th>
				<th>비고</th>
			</tr>
			<%
			int i;
			for (i = 0; i < gradeList.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=gradeList.get(i).getStudentId()%></td>
				<td><%=gradeList.get(i).getStudentName()%></td>
				<td><%=gradeList.get(i).getSubjectId()%></td>
				<td><%=gradeList.get(i).getSubjectName()%></td>
				<td><input type="text" name="midExamScore<%=i+1%>" size="10" value="<%=gradeList.get(i).getMidExam()%>"></td>
				<td><input type="text" name="finalExamScore<%=i+1%>" size="10" value="<%=gradeList.get(i).getFinalExam()%>"></td>
				<td><input type="text" name="grade<%=i+1%>" size="10" value="<%=gradeList.get(i).getConvertedMark()%>"></td>
				<td><input type="hidden" name="studentId<%=i+1%>" value="<%=gradeList.get(i).getStudentId()%>"></td>
			</tr>
			<%
			}
			%>
		</table>
		<input type="hidden" name="studentSize" value="<%=i%>">
		<input type="hidden" name="subjectId" value="<%=request.getAttribute("subjectId")%>">
		<button type="submit">학점 수정</button>
	</form>
	<%
	} else {
	%>
	<p>수정할 학점 정보가 없습니다.</p>
	<a href="${pageContext.request.contextPath}/professor/gohome">홈으로 돌아가기</a>
	<%
	}
	%>
<%@ include file="/WEB-INF/views/main_footer.jsp"%>
</body>
</html>