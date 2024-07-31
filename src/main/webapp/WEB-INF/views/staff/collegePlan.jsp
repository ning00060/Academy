
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../main_head.jsp"%>
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

        .action {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        .action .btn {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin: 0 5px;
            transition: background-color 0.3s ease;
        }

        .action .btn:hover {
            background-color: #0056b3;
        }

        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table th, table td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        table th {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #f5f5f5;
        }

        .btn-edit, .btn-delete {
            background-color: #ffc107;
            color: #fff;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 3px;
            margin-right: 5px;
            transition: background-color 0.3s ease;
        }

        .btn-delete {
            background-color: #dc3545;
        }

        .btn-edit:hover {
            background-color: #e0a800;
        }

        .btn-delete:hover {
            background-color: #c82333;
        }

        .pagination {
            text-align: center;
            padding: 20px 0;
        }

        .pagination span {
            margin: 0 5px;
        }

        .pagination .current-page {
            font-weight: bold;
            color: #007bff;
        }

        .pagination a {
            text-decoration: none;
            color: #007bff;
            transition: color 0.3s ease;
        }

        .pagination a:hover {
            color: #0056b3;
        }

        .homeMainDiv {
            padding: 20px;
        }

        .homeChildDiv {
            display: flex;
            justify-content: space-around;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 20px auto;
            width: 90%;
        }

        .main-notice, .main-schedule, .user-info {
            flex-grow: 2;
            margin: 10px;
        }

        .user-info {
            flex-grow: 1;
            background-color: #f9f9f9;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }

        .main-notice h3, .main-schedule h3 {
            margin-bottom: 15px;
        }

        .main-notice table, .main-schedule table {
            width: 100%;
            border-collapse: collapse;
        }

        .main-notice td, .main-schedule td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        .main-notice td a, .main-schedule td a {
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .main-notice td a:hover, .main-schedule td a:hover {
            color: #0056b3;
        }

        .user-info p {
            margin: 10px 0;
        }

        .user-info a {
            text-decoration: none;
            
            
        }

        .user-info a:hover {
            color: #0056b3;
        }

        .user-info button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .user-info button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h2>게시글 목록</h2>
<div class="action">
	<a class="btn btn-create" href="${pageContext.request.contextPath}/board/create">새글 작성하기</a> <a class="btn btn-back" href="${pageContext.request.contextPath}/user/Home.jsp">홈
		화면 </a>
</div>


<!-- board list 생성 예정 -->
<!-- 반복문 사용예정  -->
<table>
	<c:forEach var="schedule" items="${planList}">
		<tr>
			<td><fmt:formatDate value="${schedule.startDay}" pattern="MM-dd"/>&nbsp;-&nbsp;<fmt:formatDate value="${schedule.endDay}" pattern="MM-dd"/></td>
			<td><a href="#">${schedule.information}</a></td>
			<c:if test="${verifiedUser.permissionLevel == 3 }">
				<td><a class="btn-edit" href="#">수정</a></td>
				<td><a class="btn-delete" href="#">삭제</a></td>
			</c:if>
		</tr>
	</c:forEach>
</table>



<div class="board-item"></div>
<br>
<div class="pagination">
	<!-- index for  -->
	<c:forEach begin="1" end="${totalPages}" var="i">
		<c:choose>
			<c:when test="${i == currentPage}">
				<span class="current-page">${i}</span>
			</c:when>
			<c:otherwise>
				<span><a href="${pageContext.request.contextPath}/board/list?page=${i}">${i}</a></span>
			</c:otherwise>
		</c:choose>

	</c:forEach>
</div>

<%@ include file="../main_footer.jsp"%>