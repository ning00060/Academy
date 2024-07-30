<%@page import="com.tenco.model.professor.EvaluationResultDTO"%>
<%@page import="com.tenco.model.subject.SubjectDTO"%>
<%@page import="java.util.List"%>
<%@page
    import="jakarta.security.auth.message.callback.PrivateKeyCallback.SubjectKeyIDRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 평가 결과창</title>
<style>
    body {
        background-color: #FFFFFF;
        font-family: 'Arial', sans-serif;
        color: #000000;
    }
    h2 {
        color: #012169;
        border-bottom: 2px solid #00539B;
        padding-bottom: 10px;
    }
    label {
        color: #012169;
        font-weight: bold;
    }
    textarea {
        width: 100%;
        border: 1px solid #00539B;
        padding: 10px;
        box-sizing: border-box;
        border-radius: 5px;
    }
    p {
        color: #00539B;
        font-style: italic;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        color: #FFFFFF;
        background-color: #00539B;
        text-decoration: none;
        border-radius: 5px;
    }
    a:hover {
        background-color: #012169;
    }
</style>
</head>
<body>
    <h2>강의 평가 결과창</h2>
    <%
	List<EvaluationResultDTO> erList = (List<EvaluationResultDTO>) request.getAttribute("erList");

	if (erList.size() != 0) {

	%>
        <% int i;
        float sumAvgScore = 0;
        for (i = 0; i < erList.size(); i++) {%>
        <label>평점 : <%=erList.get(i).getAvgScore()%></label> <br><br>
		<label>학생측 건의 사항</label>
        <textarea rows="4" cols="50" ><%=erList.get(i).getImprovements()%></textarea><br><br>
        <%sumAvgScore = sumAvgScore + erList.get(i).getAvgScore();
        }%>
        
        <label>토탈 평균 점수 : <%=sumAvgScore/(float)erList.size()%></label>
        
		
		

	<%}else{ %>
	<p>조회된 강의평가 결과가 없습니다.</p>
	<%} %>
	
	<a href="${pageContext.request.contextPath}/professor/gohome">홈으로 돌아가기</a>
	
</body>
</html>