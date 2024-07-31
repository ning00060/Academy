<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <%@ include file="../main_head.jsp" %>
 <style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
    background-color: #fff;
    box-shadow: 0 2px 3px rgba(0, 0, 0, 0.1);
}

th, td {
    padding: 12px;
    border: 1px solid #ddd;
    text-align: left;
}

th {
    background-color: #f2f2f2;
    color: #333;
}

tr:nth-child(even) {
    background-color: #f9f9f9;
}

tr:hover {
    background-color: #f1f1f1;
}

button {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 4px 2px;
    cursor: pointer;
    border-radius: 4px;
}

button:hover {
    background-color: #45a049;
}
</style>
 <table >
    <tr>
        <th>학번</th>
        <th>이름</th>
        <th>년도</th>
        <th>학기</th>
        <th>학부</th>
        <th>등록금</th>
        <th>장학금</th>
        <th>장학제도</th>
        <th>납부여부</th>
    </tr>
    
    <c:forEach var="DTO" items="${tuiList}">
    <tr>
        <td>${DTO.id}</td>
        <td>${DTO.studentName}</td>
        <td>${DTO.tuiYear}</td>
        <td>${DTO.semester}</td>
        <td>${DTO.collName}</td>
        <td>${DTO.amount}</td>
        <td>${DTO.schMount}</td>
        <td>${DTO.schName}</td>
        <c:choose>
	        <c:when test="${DTO.status eq 1}">
	        	<td>O</td>
	        </c:when>
	        <c:otherwise>
	        	<td>X</td>
	        	<td><button onclick="#">납부하기</button></td>
	        </c:otherwise>
        </c:choose>
    </tr>
     </c:forEach>

</table>
 
 
 <%@ include file="../main_footer.jsp"%>