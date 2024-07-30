<%@page import="com.tenco.model.professor.ProfessorDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/main_head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강좌 개설 신청</title>
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
    input[type="text"], select {
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
	<h2>강좌 개설 신청하기</h2>
    <form action="${pageContext.request.contextPath}/professor/inputHopeClass" method="GET">
        <input type="hidden" name="professorId" value="<%=request.getParameter("professorId")%>"> 
        <input type="hidden" name="deptId" value="<%=request.getParameter("deptId")%>"> 
         
    	<label>강좌명</label>
    	<input type="text" name="subjectName" required="required" value="test강좌">
    	     
    	<label>희망 강의실</label>
    	<input type="text" name="roomId" required="required" value="E101">     

		<label>강의 유형</label>
		<select id="majorType" name="majorType">
			<option value="전공">전공</option>
			<option value="교양">교양</option>
		</select>
		
    	<label>배정 학점</label>
    	<input type="text" name="grades" value="3">     
    	
    	<label>개설 년도</label>
    	<select id="year" name="year">
			<option value="2015">2015</option>
			<option value="2016">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
			<option value="2020">2020</option>
			<option value="2021">2021</option>
			<option value="2022">2022</option>
			<option value="2023">2023</option>
			<option value="2024">2024</option>
			<option value="2025">2025</option>
			<option value="2026">2026</option>
			<option value="2027">2027</option>
			<option value="2028">2028</option>
			<option value="2029">2029</option>
			<option value="2030">2030</option>
		</select> 

		<label>학기</label>
		<select id="semester" name="semester">
			<option value="1">1학기</option>
			<option value="2">2학기</option>
		</select>

        <button type="submit">신청하기</button>
    </form>
	
	
	<a href="${pageContext.request.contextPath}/professor/gohome">홈으로 돌아가기</a>
<%@ include file="/WEB-INF/views/main_footer.jsp"%>
</body>
</html>