<%@page import="com.tenco.model.temp.DepartmentDTO"%>
<%@page import="com.tenco.Repo.interfaces.temp.DepartmentRepository"%>
<%@page import="com.tenco.Repo.temp.DepartmentRepositoryImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../main_head.jsp"%>

<%@ page import="java.util.List, java.util.ArrayList"%>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa;
    margin: 0;
    padding: 0;
}

form {
    margin: 20px 0;
}

input[type="text"] {
    padding: 10px;
    width: 300px;
    margin-right: 10px;
    border: 1px solid #ced4da;
    border-radius: 4px;
}

button {
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}

/* 검색 결과 스타일 */
h2 {
    color: #343a40;
}

ul {
    list-style-type: none;
    padding: 0;
}

li {
    background-color: #ffffff;
    margin: 5px 0;
    padding: 10px;
    border: 1px solid #ced4da;
    border-radius: 4px;
}

/* 테이블 스타일 */
table {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
}

th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

th {
    background-color: #007bff;
    color: white;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

tr:hover {
    background-color: #e9ecef;
}

input[type="hidden"] {
    display: none;
}
</style>


<!-- 검색 폼 -->
<form action="selectDepart" method="post">
	<input type="text" name="search" placeholder="대학 번호 입력하세요" value="${departmentDTO.id}" />
	<button type="submit">검색</button>
</form>

<!-- 검색 결과 표시 -->
<c:if test="${not empty departmentDTO}">
	<h2>검색 결과:</h2>
	<c:choose>
		<c:when test="${empty departmentDTO.id}">
			<p>검색 결과가 없습니다.</p>
		</c:when>
		<c:otherwise>
		
		
		<table class="">
				<tr>
					<th>학과번호</th>
					<th>학과이름</th>
					<th>대학번호</th>
				</tr>
				<tr>
					<td>${departmentDTO.id}</td>
					<td>${departmentDTO.name}</td>
					<td>${departmentDTO.collegeId}</td>
					<td>					
						<form action="${pageContext.request.contextPath}/staff/depart" method="get">
		                <input type="hidden" name="id" value="${departmentDTO.id}" />
		                <button type="submit">수정하기</button>
		            	</form>
		             </td>
				</tr>

			</table>
		</c:otherwise>
	</c:choose>
</c:if>

<%@ include file="../main_footer.jsp"%>
