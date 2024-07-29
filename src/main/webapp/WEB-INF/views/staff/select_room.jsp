<%@page import="com.tenco.model.temp.DepartmentDTO"%>
<%@page import="com.tenco.Repo.interfaces.temp.DepartmentRepository"%>
<%@page import="com.tenco.Repo.temp.DepartmentRepositoryImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../main_head.jsp"%>

<%@ page import="java.util.List, java.util.ArrayList"%>



<!-- 검색 폼 -->
<form action="staff/selectRoom" method="post">
	<input type="text" name="search" placeholder="단과대 번호를 입력하세요"  />
	<button type="submit">검색</button>
</form>

<!-- 검색 결과 표시 -->
<c:if test="${not empty roomList}">
	<h2>검색 결과:</h2>
	<c:choose>
		<c:when test="${empty roomList.id}">
			<p>검색 결과가 없습니다.</p>
		</c:when>
		<c:otherwise>
    	<c:forEach var="DTO" items="${roomList}">
			<ul>
				<li>${DTO.id}</li>
				<li>${DTO.collegeId}</li>
				<li>
					<form action="${pageContext.request.contextPath}/staff/room" method="get">
		                <input type="hidden" name="id" value="${DTO.id}" />
		                <button type="submit">수정하기</button>
		            </form>
				</li>		        	
			</ul>
		</c:forEach>
		</c:otherwise>
	</c:choose>
</c:if>

<%@ include file="../main_footer.jsp"%>
