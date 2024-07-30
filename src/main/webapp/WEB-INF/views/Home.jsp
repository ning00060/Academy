<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="main_head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Title</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
  <body class="bg-gray-100 font-sans">
    <div class="container mx-auto p-6">
        <div class="flex justify-center mb-6">
            <img alt="" src="../resource/main_img.png" class="max-w-full h-auto">
        </div>
        
        <div class="flex flex-wrap -mx-2">
            <div class="w-full md:w-1/3 p-2">
                <div class="bg-white p-6 rounded-lg shadow-lg">
                    <h3 class="text-xl font-semibold mb-4"><a href="${pageContext.request.contextPath}/user/notice" class="text-blue-600 hover:underline">공지사항</a></h3>
                    <table class="w-full">
                        <c:forEach var="notice" items="${noticeList}">
                            <tr class="border-b">
                                <td class="py-2"><a href="#" class="text-blue-600 hover:underline">${notice.category}&nbsp;${notice.title}</a></td>
                                <td class="py-2"><fmt:formatDate value="${notice.createdTime}" type="date"/></td>
                            </tr>                        
                        </c:forEach>
                    </table>
                </div>
            </div>

            <div class="w-full md:w-1/3 p-2">
                <div class="bg-white p-6 rounded-lg shadow-lg">
                    <h3 class="text-xl font-semibold mb-4"><a href="${pageContext.request.contextPath}/user/plan" class="text-blue-600 hover:underline">학사일정</a></h3>
                    <table class="w-full">
                        <c:forEach var="schedule" items="${scheduleList}">
                            <tr class="border-b">
                                <td class="py-2"><fmt:formatDate value="${schedule.startDay}" pattern="MM-dd"/>&nbsp;-&nbsp;<fmt:formatDate value="${schedule.endDay}" pattern="MM-dd"/></td>
                                <td class="py-2"><a href="#" class="text-blue-600 hover:underline">${schedule.information}</a></td>
                            </tr>                        
                        </c:forEach>
                    </table>
                </div>
            </div>

            <div class="w-full md:w-1/4 p-2">
                <div class="bg-white p-6 rounded-lg shadow-lg text-center">
                    <!-- 학생 -->
                    <c:if test="${verifiedUser.permissionLevel == 1}">
                        <p class="text-lg mb-2">${verifiedUser.name}님, 환영합니다.</p>
                        <p>이메일: ${studentDTO.email}</p>
                        <p>소속: ${studentDTO.d_name}</p>
                        <p>학기: ${studentDTO.grade}</p>
                        <p>학번: ${studentDTO.u_number}</p>
                    </c:if>
                    
                    <!-- 관리자 -->
                    <c:if test="${verifiedUser.permissionLevel == 3}">
                        <p class="text-lg mb-2">${verifiedUser.name}님, 환영합니다.</p>
                        <p>이메일: ${verifiedUser.email}</p>
                        <p>학번: ${verifiedUser.id}</p>
                    </c:if>
                    
                    <!-- 교수 -->
                    <c:if test="${verifiedUser.permissionLevel == 2}">
                        <p class="text-lg mb-2">${verifiedUser.name}님, 환영합니다.</p>
                        <p>이메일: ${verifiedUser.email}</p>
                        <p>학번: ${verifiedUser.id}</p>
                    </c:if>

                    <div class="mt-4">
                        <c:if test="${verifiedUser.permissionLevel == 1}">
                            <a href="${pageContext.request.contextPath}/user/myInfo" class="inline-block bg-blue-500 text-white py-2 px-4 rounded-lg hover:bg-blue-700">마이페이지</a>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/user/logout" class="inline-block bg-red-500 text-white py-2 px-4 rounded-lg hover:bg-red-700 mt-2 md:mt-0">로그아웃</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="main_footer.jsp"%>
</body>
