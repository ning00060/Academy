<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

 <%@ include file="../main_head.jsp" %>
<head>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
        color: #333;
    }

    h2 {
        text-align: center;
        margin-top: 20px;
        color: #444;
    }

    table {
        width: 90%;
        max-width: 1200px;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table th, table td {
        padding: 15px;
        text-align: left;
        border: 1px solid #ddd;
    }

    table th {
        background-color: #f2f2f2;
    }

    table tr:hover {
        background-color: #f5f5f5;
    }

    button {
        background-color: #007bff;
        color: #fff;
        padding: 5px 10px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #0056b3;
    }

    a {
        display: block;
        text-align: center;
        margin-top: 20px;
        text-decoration: none;
        color: #007bff;
        transition: color 0.3s ease;
    }

    a:hover {
        color: #0056b3;
    }
</style>
</head>
<body>
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