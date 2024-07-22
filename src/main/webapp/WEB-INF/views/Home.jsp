<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="main_head.jsp"%>
	
<div class="homeMainDiv">

	<div style=" align-items: center;	">
		<img alt="" src="../resource/main_img.png">
	</div>
	
	<div class="homeChildDiv" style="height: 400px">
	
		<div style="flex-grow: 2">
		
		</div>

		<div style="flex-grow: 2">
		
		</div>

		<div style="flex-grow: 1">
		
		<div><p>${verifiedUser.name}님, 환영합니다.</p></div>
		<div><p>이메일: ${verifiedUser.email}</p> </div>
		<div><p>소속:</p> </div>
		<div><p>학기:</p> </div>
		<div><p>학번: ${verifiedUser.id}</p></div>
		
		
		</div>
	
	</div>

</div>



<%@ include file="main_footer.jsp"%>  