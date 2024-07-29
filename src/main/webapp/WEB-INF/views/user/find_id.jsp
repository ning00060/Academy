<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <c:choose>
           <c:when test="${not empty errorMessage}">
        	<h2>찾기 결과</h2>
                <div class="error-message">${errorMessage}</div>
            </c:when>
            <c:when test="${not empty userDTO}">
                <div class="">
                	<h3>${name}님의 정보입니다</h3>
                	<br>
                	<h3>아이디는 : ${userDTO.id}</h3>
                </div>
            </c:when>
        </c:choose>
        </div>

		<div class="container">
	        <h2>아이디 찾기</h2>
	        <form action="/findId" method="post">
	            <div class="form-group">
	                <label for="name">이름:</label>
	                <input type="text" id="name" name="name" required>
	            </div>
	            <div class="form-group">
	                <label for="email">이메일:</label>
	                <input type="email" id="email" name="email" required>
	            </div>
	            <div class="form-group checkbox-group">
	                <label><input type="radio" name="num" value="1" required> 학생</label>
	                <label><input type="radio" name="num" value="2" required> 교수</label>
	                <label><input type="radio" name="num" value="3" required> 교직원</label>
	            </div>
	            <button type="submit">아이디 찾기</button>
	        </form>
	    </div>
	   <a href="${pageContext.request.contextPath}">홈으로</a>
</body>
</html>