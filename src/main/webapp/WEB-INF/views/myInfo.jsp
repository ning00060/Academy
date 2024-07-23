<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="main_head.jsp" %>
 
 <div class="myInfoMainDiv">
 
 	<div>
 		
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
        
        
 		
 		</div>
 		
 	</div>
 	
 	<!-- ----------------------------------- -->
 	
 	<div>
 	
 	<h1>내 정보 조회</h1>
        <div class="split--div"></div>
            <table border="1" class="input--table" >
            <colgroup>
                <col class="col1">
                <col class="col2">
                <col class="col3">
                <col class="col4">
            </colgroup>
                <tr>
                    <th>학번</th>
                    <td>${student.id}</td>
                    <th>소속</th>
                    <td>${student.collegeName}&nbsp;${student.deptName}</td>
                </tr>
                <tr>
                    <th>학년</th>
                    <td>${student.grade}</td>
                    <th>학기</th>
                    <td>${student.semester}</td>
                </tr>
                <tr>
                    <th>입학일</th>
                    <td>${student.entranceDate}</td>
                    <th>졸업일(졸업예정일)</th>
                    <td>${student.graduationDate}</td>
                </tr>
            </table>
            <table border="1" class="input--table" >
            <colgroup>
                <col class="col1">
                <col class="col2">
                <col class="col3">
                <col class="col4">
            </colgroup>
                <tr>
                    <th>성명</th>
                    <td>${student.name}</td>
                    <th>생년월일</th>
                    <td>${student.birthDate}</td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>${student.gender}</td>
                    <th>주소</th>
                    <td>${student.address}</td>
                </tr>
                <tr>
                    <th>연락처</th>
                    <td>${student.tel}</td>
                    <th>email</th>
                    <td>${student.email}</td>
                </tr>
            </table>
            <button type="button" onclick="location.href='/update'" class="btn btn-dark update--button">수정하기</button>
 	
 	</div>
 	
 	
 </div>

<%@ include file="main_footer.jsp"%>