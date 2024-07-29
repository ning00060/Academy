<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <%@ include file="../main_head.jsp" %>
		<h1>등록금 등록</h1>
		<form action="${pageContext.request.contextPath}/staff/tuition" method="post">
			<table class="table--container">
				<tr>
					<td><label for="id">학번</label></td>
					<td><input type="text" name="id" id="id" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="tuiYear">년도</label></td>
					<td><input type="text" name="tuiYear" id="tuiYear" class="input--box"></td>
				</tr>

				<tr>
					<td><label for="semester">학기</label></td>
					<td><input type="text" name="semester" id="semester" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="tuiId">등록학과</label></td>
					<td><input type="text" name="tuiId" id="tuiId" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="schType">장학금</label></td>
					<td><input type="text" name="schType" id="schType" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="status">납부</label></td>
					<td><input type="text" name="status" id="status" class="input--box"></td>
				</tr>
			</table>
			<div class="button--container">
				<input type="submit" value="입력">
			</div>
		</form>
		<hr>
		<h1>등록금 수정</h1>
		<form action="${pageContext.request.contextPath}/staff/tuitionModify" method="post">
			<table class="table--container">
				<tr>
					<td><label for="id">학번</label></td>
					<td><input type="text" name="id" id="id" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="id2">변경할 학번</label></td>
					<td><input type="text" name="id2" id="id2" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="tuiYear">년도</label></td>
					<td><input type="text" name="tuiYear" id="tuiYear" class="input--box"></td>
				</tr>

				<tr>
					<td><label for="semester">학기</label></td>
					<td><input type="text" name="semester" id="semester" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="tuiId">등록학과</label></td>
					<td><input type="text" name="tuiId" id="tuiId" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="schType">장학금</label></td>
					<td><input type="text" name="schType" id="schType" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="status">납부</label></td>
					<td><input type="text" name="status" id="status" class="input--box"></td>
				</tr>
			</table>
			<div class="button--container">
				<input type="submit" value="입력">
			</div>
		</form>
		
		<h1>등록금 삭제</h1>
		<form action="${pageContext.request.contextPath}/staff/tuition" method="post">
			<table class="table--container">
				<tr>
					<td><label for="id">학번</label></td>
					<td><input type="text" name="id" id="id" class="input--box"></td>
				</tr>
			</table>
			<div class="button--container">
				<input type="submit" value="입력">
			</div>
		</form>
 <%@ include file="../main_footer.jsp"%>