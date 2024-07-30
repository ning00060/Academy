
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../main_head.jsp"%>

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