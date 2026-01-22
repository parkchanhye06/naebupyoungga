<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style = "width:280px;border:1px solid lightgrey">
	<form action="idEditAction">
		ID	<input type = "text" name = "id" value="${id}" style = "margin-left: 39px;" readonly/><br/>
		PW	<input type = "text" name = "pw" value="${pw}" style = "margin-left: 32px;"/><br/>
		NAME<input type = "text" name = "name" value="${name}" style = "margin-left: 18px;"/><br/>
		POINT <input type = "text" name = "point" value="${point}" style = "margin-left: 10px;"/><br/>
	<button style = "width:225px;margin-left: 24px;">제출</button>
	</form>
	</div>
	
	
	
</body>
</html>