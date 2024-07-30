<%@page import="com.tenco.model.professor.EvaluationResultDTO"%>
<%@page import="com.tenco.model.subject.SubjectDTO"%>
<%@page import="java.util.List"%>

<%@ include file="/WEB-INF/views/main_head.jsp"%>
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
    .content {
        width: 60%;
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
    textarea {
        width: 100%;
        padding: 10px;
        margin: 5px 0 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .average-score {
        font-size: 18px;
        color: #00539B;
        margin-top: 20px;
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
    <h2>강의 평가 결과창</h2>
    <div class="content">
        <%
        List<EvaluationResultDTO> erList = (List<EvaluationResultDTO>) request.getAttribute("erList");

        if (erList.size() != 0) {
        %>
            <% int i;
            float sumAvgScore = 0;
            for (i = 0; i < erList.size(); i++) {%>
            <label>평점 : <%=erList.get(i).getAvgScore()%></label> <br><br>
            <label>학생측 건의 사항</label>
            <textarea rows="4" cols="50" readonly><%=erList.get(i).getImprovements()%></textarea><br><br>
            <%sumAvgScore = sumAvgScore + erList.get(i).getAvgScore();
            }%>
            
            <div class="average-score">
                <label>토탈 평균 점수 : <%=sumAvgScore/(float)erList.size()%></label>
            </div>
        <%}else{ %>
        <p>조회된 강의평가 결과가 없습니다.</p>
        <%} %>
        
        <a href="${pageContext.request.contextPath}/professor/gohome">홈으로 돌아가기</a>
    </div>
<%@ include file="/WEB-INF/views/main_footer.jsp"%>
</body>
</html>