<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <%@ include file="../main_head.jsp" %>
<h1>강의 등록</h1>
		<form action="${pageContext.request.contextPath}/staff/subject" method="post">
			<table class="table--container">
				<tr>
					<td><label for="id">학과 번호</label></td>
					<td><input type="text" name="id" id="id" class="input--box"></td>
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
					<td><label for="professorId">교수번호</label></td>
					<td><input type="text" name="professorId" id="professorId" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="roomId">강의실번호</label></td>
					<td><input type="text" name="roomId" id="roomId" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="deptId">학과번호</label></td>
					<td><input type="text" name="deptId" id="deptId" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="majorType">전공타입</label></td>
					<td><input type="text" name="majorType" id="majorType" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="year">생성년도</label></td>
					<td><input type="text" name="year" id="year" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="semester">학기</label></td>
					<td><input type="text" name="semester" id="semester" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="grades">학년</label></td>
					<td><input type="text" name="grades" id="grades" class="input--box"></td>
				</tr>
			</table>
			<div class="button--container">
				<input type="submit" value="입력">
			</div>
		</form>
		<hr>
		<h1>학과 수정</h1>
		<form action="${pageContext.request.contextPath}/staff/subjectModify" method="post">
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
					<td><label for="professorId">교수번호</label></td>
					<td><input type="text" name="professorId" id="professorId" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="roomId">강의실번호</label></td>
					<td><input type="text" name="roomId" id="roomId" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="deptId">학과번호</label></td>
					<td><input type="text" name="deptId" id="deptId" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="majorType">전공타입</label></td>
					<td><input type="text" name="majorType" id="majorType" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="year">생성년도</label></td>
					<td><input type="text" name="year" id="year" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="semester">학기</label></td>
					<td><input type="text" name="semester" id="semester" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="grades">학년</label></td>
					<td><input type="text" name="grades" id="grades" class="input--box"></td>
				</tr>
			</table>
			<div class="button--container">
				<input type="submit" value="입력">
			</div>
		</form>
		
		<h1>학과 삭제</h1>
		<form action="${pageContext.request.contextPath}/staff/subjectDelete" method="post">
			<table class="table--container">
				<tr>
					<td><label for="id">학과 번호</label></td>
					<td><input type="text" name="id" id="id" class="input--box" value="${id}]"></td>
				</tr>
			</table>
			<div class="button--container">
				<input type="submit" value="입력">
			</div>
		</form>
 <%@ include file="../main_footer.jsp"%>