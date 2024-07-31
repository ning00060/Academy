<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .login--div {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: center;
    }

    .main--logo img {
        width: 100px;
        margin-bottom: 20px;
    }

    .form-group {
        margin-bottom: 15px;
    }

    .form-group label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }

    .form-group input[type="text"],
    .form-group input[type="password"] {
        width: calc(100% - 20px);
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    .btn-primary {
        background-color: #007bff;
        color: #fff;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
        margin-top: 10px;
        transition: background-color 0.3s ease;
    }

    .btn-primary:hover {
        background-color: #0056b3;
    }

    a {
        display: block;
        margin-top: 10px;
        color: #007bff;
        text-decoration: none;
        transition: color 0.3s ease;
    }

    a:hover {
        color: #0056b3;
    }
</style>
</head>
<body>

    <c:if test="${param.error != null}">
        <script>
            alert("${param.error}");
        </script>
    </c:if>

    <div class="login--div">
        <div class="main--logo">
            <a href="#"><img class="logo" alt="Logo" src="resource/logo2.png"></a>
        </div>

        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <div class="form-group">
                <label for="id">학번 :</label>
                <input type="text" id="id" name="id" value="23000001" required>
            </div>
            <div class="form-group">
                <label for="password">비밀번호 :</label>
                <input type="password" id="password" name="password" value="123123" required>
            </div>
            <div class="form-group">
                <input class="btn-primary" type="submit" value="로그인">
            </div>
        </form>

        <a href="user/findId" onclick="window.open(this.href, '_blank', 'width=500, height=300'); return false;">ID 찾기</a>
        <a href="user/findPw" onclick="window.open(this.href, '_blank', 'width=500, height=350'); return false;">비밀번호 찾기</a>
    </div>
    
</body>
</html>
