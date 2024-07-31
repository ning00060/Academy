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
    padding: 20px;
}

h1 {
    color: #333;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
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

.table--container {
    width: 100%;
}

.button--container {
    text-align: right;
    margin-top: 10px;
}
</style>
 <table>
    <tr>
        <th>학번</th>
        <th>이름</th>
        <th>구분</th>
        <th>년도</th>
        <th>학기</th>
        <th>금액</th>
    </tr>

	<c:forEach var="DTO" items="${studentScholarDTO}">
    <tr>
        <td>${DTO.studentId}</td>
        <td>${DTO.studentName}</td>
        <td>${DTO.schYear}</td>
        <td>${DTO.semester}</td>
        <td>${DTO.schTypeName}</td>
        <td>${DTO.amount}</td>
    </tr>
	</c:forEach>

</table>
 
 
 <%@ include file="../main_footer.jsp"%>