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

input[type="text"] {
    width: 100%;
    padding: 10px;
    margin: 5px 0;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
}

input[type="submit"] {
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

input[type="submit"]:hover {
    background-color: #45a049;
}

.table--container {
    width: 100%;
}

.button--container {
    text-align: right;
    margin-top: 10px;
}
</style>
 
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