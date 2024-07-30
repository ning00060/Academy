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
<form action="${pageContext.request.contextPath}/staff/subject" method="post">
	<input type="text" name="search" placeholder="강의 번호 입력하세요" value="${staffSubjectDTO.id}" />
	<button type="submit">검색</button>
</form>

<!-- 검색 결과 표시 -->
<c:if test="${not empty staffSubjectDTO}">
	<h2>검색 결과:</h2>
	<c:choose>
		<c:when test="${empty staffSubjectDTO.id}">
			<p>검색 결과가 없습니다.</p>
		</c:when>
		<c:otherwise>
			<ul>
				<li>${staffSubjectDTO.id}</li>
				<li>${staffSubjectDTO.name}</li>
				<li>${staffSubjectDTO.professorId}</li>
				<li>${staffSubjectDTO.roomId}</li>
				<li>${staffSubjectDTO.deptId}</li>
				<li>${staffSubjectDTO.majorType}</li>
				<li>${staffSubjectDTO.year}</li>
				<li>${staffSubjectDTO.semester}</li>
				<li>${staffSubjectDTO.grades}</li>
				<li>
					<form action="${pageContext.request.contextPath}/staff/subject" method="get">
		                <input type="hidden" name="id" value="${staffSubjectDTO.id}" />
		                <button type="submit">수정하기</button>
		            </form>
				</li>		        	
			</ul>
		</c:otherwise>
	</c:choose>
</c:if>
<h2>강의 요청</h2>
 <table >

    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>교수</th>
        <th>강의실</th>
        <th>학과</th>
        <th>전공</th>
        <th>년도</th>
        <th>학기</th>
        <th>학년</th>
        <th>요청</th>
    </tr>
		
    <c:forEach  var="DTO" items="${hopeList}" >
    <tr>
        <td>${DTO.id}</td>
        <td>${DTO.name}</td>
        <td>${DTO.professorId}</td>
        <td>${DTO.roomId}</td>
        <td>${DTO.deptId}</td>
        <td>${DTO.majorType}</td>
        <td>${DTO.year}</td>
        <td>${DTO.semester}</td>
        <td>${DTO.grades}</td>
        <td><form action="${pageContext.request.contextPath}/staff/subject" method="get">
		        <input type="hidden" name="id" value="${DTO.id}" />
		        <input type="hidden" name="name" value="${DTO.name}" />
		        <input type="hidden" name="professorId" value="${DTO.professorId}" />
		        <input type="hidden" name="roomId" value="${DTO.roomId}" />
		        <input type="hidden" name="deptId" value="${DTO.deptId}" />
		        <input type="hidden" name="majorType" value="${DTO.majorType}" />
		        <input type="hidden" name="year" value="${DTO.year}" />
		        <input type="hidden" name="semester" value="${DTO.semester}" />
		        <input type="hidden" name="grades" value="${DTO.grades}" />
		        <button type="submit">등록하기</button>
		    </form>
		</td>
    </tr>
     </c:forEach>

</table>
	

<%@ include file="../main_footer.jsp"%>
