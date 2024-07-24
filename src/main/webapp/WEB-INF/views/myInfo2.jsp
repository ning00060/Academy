<%@page import="com.tenco.model.student.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="main_head.jsp" %>
 
 
 <div class="myInfoMainDiv">
 
 	<div style="flex-direction: row;">
 		
 		<div>
 		<h2>MY</h2>
 		</div>
 

 
 		<div >
 		
 		<div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="/info/student" class="selected--menu">내 정보 조회</a></td>
                </tr>
                <tr>
                    <td><a href="/password">비밀번호 변경</a></td>
                </tr>
                <tr>
                    <td><a href="/break/application">휴학 신청</a></td>
                </tr>
                <tr>
                    <td><a href="/break/list">휴학 내역 조회</a></td>
                </tr>
                <tr>
                    <td><a href="/tuition/list">등록금 내역 조회</a></td>
                </tr>
                <tr>
                    <td><a href="/tuition/payment">등록금 납부 고지서</a></td>
                </tr>
            </table>
        </div>
		
        </div>
        
        
 		
 <%-- --%>	<% StudentDTO student = (StudentDTO)request.getAttribute("studentDTO"); %>
 			<%UserDTO userDTO2 = (UserDTO)request.getSession().getAttribute("verifiedUser"); %>	
 		
 	</div>
 	
 	<!-- ----------------------------------- -->
 	
 	<div>
 	
 	<h1>내 정보 조회</h1>
        <div class="split--div"></div>
       <form action="${pageContext.request.contextPath}/update" method="post">
            <table border="1" class="input--table" >
            <colgroup>
                <col class="col1">
                <col class="col2">
                <col class="col3">
                <col class="col4">
            </colgroup>
                <tr>
                    <th>주소</th>
                    <td> <input type="text" value="<%= student.getAddress()%>"> </td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td> <input type="text" value="<%= student.getTel()%>"> </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td> <input type="text" value="<%= student.getEmail()%>"> </td>
                </tr>
                
                <tr>
                    <th>비밀번호 </th>
                    <td> <input type="text" id =password name ="password"> </td>
                </tr>
                
            </table>
 		<button type="submit">제출</button>
 	</form>
 	</div>
 	
 </div>
 
 
<%@ include file="main_footer.jsp"%>