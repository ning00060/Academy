<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학교 웹 사이트</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        color: #000000;
    }
    footer {
        background-color: #F8F8F8;
        padding: 20px 0;
        border-top: 1px solid #E7E7E7;
        text-align: center;
    }
    .footer-links {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
        margin-bottom: 10px;
    }
    .footer-links a {
        margin: 0 10px;
        color: #000000;
        text-decoration: none;
        font-size: 14px;
    }
    .footer-info {
        font-size: 12px;
        color: #666666;
    }
    .footer-info p {
        margin: 5px 0;
    }
    .footer-logos {
        display: flex;
        justify-content: center;
        margin-top: 10px;
    }
    .footer-logos img {
        height: 40px;
        margin: 0 10px;
    }
</style>
</head>
<body>
    <footer>
        <div class="footer-links">
            <a href="#">정보공시</a>
            <a href="#">전화번호/사이트 안내</a>
            <a href="#">듀크대포털</a>
            <a href="#">클린행정센터</a>
            <a href="#">개인정보처리방침</a>
            <a href="#">이메일무단수집거부</a>
            <a href="#">복지보조금 부정 신고</a>
            <a href="#">사이트맵</a>
        </div>
        <div class="footer-info">
            <p>미국 27708 노스캐롤라이나 더럼</p>
            <p>TEL. +1 919-684-8111 | FAX. +1 919-684-8111</p>
            <p>Copyright 2024 Duke National University All Rights Reserved.</p>
        </div>
        <div class="footer-logos">
            <img src="../resource/logo1.png" alt="Logo 1">
            <img src="../resource/logo2.png" alt="Logo 2">
        </div>
    </footer>
</body>
</html>