<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <%@ include file="../main_head.jsp" %>

<h1>학과 등록</h1>
		<form action="${pageContext.request.contextPath}/staff/depart" method="post">
			<table class="table--container">
				<tr>
					<td><label for="id">학과 번호</label></td>
					<td><input type="text" name="id" id="id" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="name">학과 이름</label></td>
					<td><input type="text" name="name" id="name" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="collegeId">단과대학번호</label></td>
					<td><input type="text" name="collegeId" id="collegeId" class="input--box"></td>
				</tr>
			</table>
			<div class="button--container">
				<input type="submit" value="입력">
			</div>
		</form>
		<hr>
		<h1>학과 수정</h1>
		<form action="${pageContext.request.contextPath}/staff/departModify" method="post">
			<table class="table--container">
				<tr>
					<td><label for="id">학과 번호</label></td>
					<td><input type="text" name="id" id="id" class="input--box" value="${id}"></td>
				</tr>
				<tr>
					<td><label for="id2">변경할 학과번호</label></td>
					<td><input type="text" name="id2" id="id2" class="input--box"></td>
				</tr>
				
				<tr>
					<td><label for="name">학과 이름</label></td>
					<td><input type="text" name="name" id="name" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="collegeId">단과대학번호</label></td>
					<td><input type="text" name="collegeId" id="collegeId" class="input--box"></td>
				</tr>
			</table>
			<div class="button--container">
				<input type="submit" value="입력">
			</div>
		</form>
		
		<h1>학과 삭제</h1>
		<form action="${pageContext.request.contextPath}/staff/departDelete" method="post">
			<table class="table--container">
				<tr>
					<td><label for="id">학과 번호</label></td>
					<td><input type="text" name="id" id="id" class="input--box" value="${id}"></td>
				</tr>
			</table>
			<div class="button--container">
				<input type="submit" value="입력">
			</div>
		</form>

<%@ include file="../main_footer.jsp"%>  