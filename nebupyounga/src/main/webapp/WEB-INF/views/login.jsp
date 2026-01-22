<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="msg" value="${msg}"/>
<c:choose>
	<c:when test="${not empty msg}">
		<script>alert("${msg}");</script>
	</c:when>
</c:choose>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

  <link rel="stylesheet" href="resources/css/login.css">
 <script>
    $(function(){
        $("#loginBtn").click(function(){
            location.href = "loginCheck";
        }); 

        $("#signUpBtn").click(function(){
            alert("회원가입 버튼 눌림!");
        });
    });
</script>
</head>
<body>
	<div id = "login">
		<div>로그인</div><br/>
		<form action ="loginCheck" method="post">
		<div>
		ID:		<input type = "text" name = "id" id = "id"/><br/>
		PW: <input type = "password" name = "pw" id = "pw"/>
		</div>
		<button id = "loginBtn">로그인</button><br/>
		</form>
		<form action = "signUp">
		<button id = "signUpBtn">회원가입</button><br/>
		</form>
	</div>

</body>
</html>