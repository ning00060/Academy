<%@page import="com.tenco.model.professor.ProfessorDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강좌 개설 신청</title>
</head>
<body>
	<H2>강좌 개설 신청하기</H2>
    <form action="${pageContext.request.contextPath}/professor/inputHopeClass" method="GET">
        <input type="hidden" name="professorId" value="<%=request.getParameter("professorId")%>"> 
        <input type="hidden" name="deptId" value="<%=request.getParameter("deptId")%>"> 
        <%System.out.println(request.getAttribute("professorId")); %>
        <%System.out.println(request.getParameter("deptId")); %>
         
    	
    	<label>강좌명</label>
    	<input type="text" name="subjectName" size="10" style="width: 20vh" required="required" value="test강좌">
    	     
    	<label>희망 강의실</label>
    	<input type="text" name="roomId" size="10" style="width: 20vh" required="required" value="E101">     

    	<label>강좌 타입</label>
    	<input type="text" name="majorType" size="10" style="width: 20vh" placeholder="전공 또는 교양">     

    	<label>배정 학점</label>
    	<input type="text" name="grades" size="10" style="width: 20vh" value ="3">     
    	
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
			<option value="2024">2025</option>
			<option value="2024">2026</option>
			<option value="2024">2027</option>
			<option value="2024">2028</option>
			<option value="2024">2029</option>
			<option value="2024">2030</option>
		</select> 
		<select id="semester" name="semester">
			<option value="1">1학기</option>
			<option value="2">2학기</option>
		</select>

        <button type="submit">신청하기</button>
    </form>
	
	
	<a href="${pageContext.request.contextPath}/temp/home.jsp">홈으로 돌아가기</a>
	
</body>
</html>