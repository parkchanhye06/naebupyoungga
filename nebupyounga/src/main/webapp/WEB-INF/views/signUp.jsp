<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

  <link rel="stylesheet" href="resources/css/login.css">
 <script>
    $(function(){
    	
       });
</script>
</head>
<body>
	<div id = "login">
		<div>회원가입</div><br/>
		<form action = "signUpAction">
		<div>
		ID:		<input type = "text" name = "id" id = "id"/><br/>
		PW: <input type = "password" name = "pw" id = "pw"/>
		name: <input type = "text" name = "name" id = "name"/>
		</div>
		<button id = "commit">작성완료</button><br/>
		</form>
	</div>

</body>
</html>