<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:choose>
<c:when test="${empty id}">
		<script>
			alert("로그인부터 하세요.");
			location.href = "login";
		</script>
	</c:when>
</c:choose>
<%-- 메시지(msg) 있으면 출력 --%>
<c:set var="msg" value="${msg}"/>
<c:choose>
	<c:when test="${not empty msg}">
		<script>alert("${msg}");</script>
	</c:when>
</c:choose>
<%-- //메시지(msg) 있으면 출력 --%>
 
 
<html>
<head>
  <link rel="stylesheet" href="resources/css/home.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
	$(function(){
		var point = Number("${point}");
		$("#logout").click(function(){
			location.href ="logout";			
		});
		$("#java").click(function(){
		if(500000 > point){
			alert("포인트가 부족합니다.광고를 클릭하세요.");
		}else{
			$.ajax({
				type:'post',
				url:'ajax_buy_coding_class',
				data:JSON.stringify({
					"point":point-500000
				}),
				contentType:"application/json; charset=utf-8",
				success:function(data){
					alert("컨텐츠(java)를 구입하였습니다.");
					$("#point").text("포인트:"+data);
					point = Number(data);
					
				},
				error:function(data){
					
				}
			});
		}
		});
	$("#intro").click(function(){
		if(100000 > point){
			alert("포인트가 부족합니다.광고를 클릭하세요.");
		}else{
			$.ajax({
				type:'post',
				url:'ajax_buy_coding_class',
				data:JSON.stringify({
					"point":point-100000
				}),
				contentType:"application/json; charset=utf-8",
				success:function(data){
					alert("컨텐츠(intro)를 구입하였습니다.");
					$("#point").text("포인트:"+data);
					point = Number(data);
					
				},
				error:function(data){
					
				}
			});
		}
		});
		$("#cpp").click(function(){
			if(300000 > point){
				alert("포인트가 부족합니다.광고를 클릭하세요.");
			}else{
				$.ajax({
					type:'post',
					url:'ajax_buy_coding_class',
					data:JSON.stringify({
						"point":point-300000
					}),
					contentType:"application/json; charset=utf-8",
					success:function(data){
						alert("컨텐츠(cpp)를 구입하였습니다.");
						$("#point").text("포인트:"+data);
						point = Number(data);
					},
					error:function(data){
					}
				});
			}
		}); 
		$("#adverticement").click(function(){
			$.ajax({
				type:'post',
				url:'ajax_point_pp',
				data:JSON.stringify({
				}),
				contentType:"application/json; charset=utf-8",
				success:function(data){
					alert(data.plus+"점이 적립되었습니다");
					$("#point").text("포인트:"+data.point);
					point = Number(data.plus);
					location.href = "https://www.koreaisacademy.com";
				},
				error:function(data){
				}
			}); 
		}); 
	});
</script>

</head>
<body>
		<div id ="main_page">
				<div id = "titles">
					<div style = "margin-left:20px;font-size:25px;font-weight:bold">메인페이지</div>
					<div id = "user_info">
						<div>${name}(${id})님 안녕하세요
						<button id = "logout">로그아웃</button>
						</div>
					<div id = "point">포인트: ${point}점</div>
					</div>
				</div>
					<span style = "font-size:15px;font-weight:bold;margin-left:20px">구매할 컨텐츠를 선택하세요.</span>
				<div id = "main_content">
					<div id = "intro" style = "margin-left:5px">
						<img src = "resources/img/Intro_350_408.png"/>
						<div>100,000포인트</div>		
					</div>
					<div id = "java" style = "margin-left:5px">
						<img src = "resources/img/Java_350_408.png"/>
						<div>500,000포인트</div>		
					</div>
					<div id = "cpp" style = "margin-left:5px">
						<img src = "resources/img/Cpp_350_408.png"/>
						<div>300,000포인트</div>		
					</div>
				</div>
		
				<div id = "adverticement">
				<img src = "resources/img/korea_it.png"/>
				</div>
		</div>


	
</body>
</html>
