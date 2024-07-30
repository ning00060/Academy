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
            <c:when test="${not empty staffUserDTO}">
                <div class="">
                	<h3>${staffUserDTO.id}님의 정보입니다</h3>
                	<br>
                	<h3>비밀번호 앞자리 3자 : ${staffUserDTO.password}</h3>
                	<h3>권한 : ${staffUserDTO.permissionLevel}</h3>
                </div>
            </c:when>
        </c:choose>
        </div>
        
		<div class="container">
	        <h2>비밀번호 찾기</h2>
	        <form action="${pageContext.request.contextPath}/user/findPw" method="post">
	            <div class="form-group">
	                <label for="id">아이디:</label>
	                <input type="text" id="id" name="id" required>
	            </div>
	            <div class="form-group">
	                <label for="name">이름:</label>
	                <input type="text" id="name" name="name" required>
	            </div>
	            <button type="submit">찾기</button>
	        </form>
	    </div>
	    
	    <a href="${pageContext.request.contextPath}">홈으로</a>
</body>
</html>