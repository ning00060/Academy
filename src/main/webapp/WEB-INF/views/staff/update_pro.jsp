<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <%@ include file="../main_head.jsp" %>
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
    display: flex;
    justify-content: center;
    flex-direction: column;
    width: 15%;
    margin-left: 195px;
    }
</style>
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	
	<!-- 메인 div -->
	<main>
		<h1>교수 등록</h1>
		<div class=""></div>
		<form action="${pageContext.request.contextPath}/staff/updatePro" method="post">
		
			<table class="">
				<tr>
					<td><label for="id"> 아이디</label></td>
					<td><input type="text" name="id" id="id" class="input--box" ></td>
				</tr>
				<tr>
					<td><label for="id2">변경할 아이디</label></td>
					<td><input type="text" name="id2" id="id2" class="input--box" ></td>
				</tr>
				<tr>
					<td><label for="name">이름</label></td>
					<td><input type="text" name="name" id="name" class="input--box" ></td>
				</tr>
				<tr>
					<td><label for="level">직군</label></td>
					<td><input type="text" name="level" id="level" class="input--box" ></td>
				</tr>
				<tr>
					<td><label for="birthDate">생년월일</label></td>
					<td><input type="date" name="birthDate" id="birthDate" class="input--box"></td>
				</tr>
				<tr>
					<td style="padding-top: 7px"><label>성별</label></td>
					<td style="padding-top: 7px"><label for="male">남성</label> 
					<input type="radio"  name="gender" value="남성" id="male" checked="checked"> &nbsp;
					<label for="female">여성</label> 
					<input type="radio"  name="gender" value="여성" id="female"></td>
				</tr>
				<tr>
					<td><label for="address">주소</label></td>
					<td><input type="text" name="address" id="address" class="input--box" ></td>
				</tr>
				<tr>
					<td><label for="tel">전화번호</label></td>
					<td><input type="text" name="tel" id="tel" class="input--box" ></td>
				</tr>
				<tr>
					<td><label for="email">이메일</label></td>
					<td><input type="text" name="email" id="email" class="input--box" ></td>
				</tr>
				<tr>
					<td><label for="deptId">과 ID</label></td>
					<td><input type="text" name="deptId" id="deptId" class="input--box" ></td>
				</tr>
				<tr>
					<td><label for="password">비밀번호</label></td>
					<td><input type="text" name="password" id="password" class="input--box"></td>
					
				</tr>
			</table>
			<div class="submit-btn">
				<input type="submit" value="입력">
			</div>
		</form>
	</main>
</div>

<%@ include file="../main_footer.jsp"%>