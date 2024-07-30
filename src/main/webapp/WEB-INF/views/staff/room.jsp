<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../main_head.jsp" %>
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f4f4f4;
    color: #333;
}

h1, h2 {
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

button, input[type="submit"] {
    background-color: #007bff;
    color: #fff;
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover, input[type="submit"]:hover {
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

.container {
    width: 90%;
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    overflow: hidden;
}

.container h2 {
    margin-top: 0;
}

.submit-btn {
    text-align: center;
    margin-top: 20px;
}
</style>
</head>
<body>
		<h1>강의실 등록</h1>
		<form action="${pageContext.request.contextPath}/staff/room" method="post">
			<table class="">
				<tr>
					<td><label for="id">강의실번호</label></td>
					<td><input type="text" name="id" id="id" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="collegeId">단과대학번호</label></td>
					<td><input type="text" name="collegeId" id="collegeId" class="input--box"></td>
				</tr>
			</table>
			<div class="submit-btn">
				<input type="submit" value="입력">
			</div>
		</form>
		<hr>
		<h1>강의실 수정</h1>
		<form action="${pageContext.request.contextPath}/staff/roomModify" method="post">
			<table class="">
				<tr>
					<td><label for="id">강의실번호</label></td>
					<td><input type="text" name="id" id="id" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="id2">변경할 강의실번호</label></td>
					<td><input type="text" name="id2" id="id2" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="collegeId">단과대학번호</label></td>
					<td><input type="text" name="collegeId" id="collegeId" class="input--box"></td>
				</tr>
			</table>
			<div class="submit-btn">
				<input type="submit" value="입력">
			</div>
		</form>
		
		<h1>강의실 삭제</h1>
		<form action="${pageContext.request.contextPath}/staff/roomDelete" method="post">
			<table class="">
				<tr>
					<td><label for="id">강의실번호</label></td>
					<td><input type="text" name="id" id="id" class="input--box"></td>
				</tr>
			</table>
			<div class="submit-btn">
				<input type="submit" value="입력">
			</div>
		</form>
</body>
</html>