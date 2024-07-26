 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 
 <%@ include file="../main_head.jsp" %>
 
 <h2>게시글 목록</h2>
	<div class="action">
		<a class="btn btn-create" href="${pageContext.request.contextPath}/board/create">새글 작성하기</a>
		<a class="btn btn-back" href="${pageContext.request.contextPath}/user/Home.jsp">홈 화면 </a>
	</div>
	
	
	<!-- board list 생성 예정 -->
	<!-- 반복문 사용예정  -->
	<c:forEach var="notice" items="${noticeList}">
		<div class="board-item">
			<h3><a href="${pageContext.request.contextPath}/board/view?id=${notice.id}">${notice.title}</a></h3>
			<p>${notice.content}</p>
			<p> <fmt:formatDate value="${notice.createdTime}" pattern="yyyy-MM-dd HH:mm"/> </p>
			<!--  게시글에 작성자가 세션 유저와 동일하다면 수정, 삭제 버튼을 보여주자 -->
			<c:if test="${notice.id == verifiedUser.id}">
				<a class="btn btn-edit" href="#">수정</a>
				<a class="btn btn-delete" href="#">삭제</a>
			</c:if>
		</div>
	</c:forEach>
	 
	<div class="board-item">
		
	</div>
	<br>
	<div class="pagination">
		<!-- index for  -->
		<c:forEach begin="1" end="${totalPages}"  var="i" >
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