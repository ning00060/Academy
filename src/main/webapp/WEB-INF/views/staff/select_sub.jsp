<%@page import="com.tenco.model.temp.DepartmentDTO"%>
<%@page import="com.tenco.Repo.interfaces.temp.DepartmentRepository"%>
<%@page import="com.tenco.Repo.temp.DepartmentRepositoryImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../main_head.jsp"%>

<%@ page import="java.util.List, java.util.ArrayList"%>



<!-- 검색 폼 -->
<form action="staff/selectSubject" method="post">
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

<%@ include file="../main_footer.jsp"%>
