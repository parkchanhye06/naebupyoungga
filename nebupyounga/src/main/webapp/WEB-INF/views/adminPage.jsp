<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 메시지(msg) 있으면 출력 --%>
<c:set var="msg" value="${msg}"/>
<c:choose>
	<c:when test="${not empty msg}">
		<script>alert("${msg}");</script>
	</c:when>
</c:choose>
<%-- //메시지(msg) 있으면 출력 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <link rel="stylesheet" href="resources/css/adminPage.css">
  <script>
  $(function(){
		$(".btn-edit").click(function(){
			var  id= $(this).closest("tr").find(".id").text().trim();
			var pw = $(this).closest("tr").find(".pw").text().trim();
			var name = $(this).closest("tr").find(".name").text().trim();
			var point = $(this).closest("tr").find(".point").text().trim();
	
			location.href = "idEdit?id=" + id 
            + "&name=" + encodeURIComponent(name) 
            + "&pw=" + encodeURIComponent(pw) 
            + "&point=" + point;
			
		});
		  $(".btn-delete").click(function(){
			var thisID = $(this);
			  $.ajax({
					type:'post',
					url:'ajax_id_delete',
					data:JSON.stringify({
					"id":thisID.closest("tr").find(".id").text().trim()
					}),
					contentType:"application/json; charset=utf-8",
					success:function(data){
						alert("삭제성공");
						thisID.closest("tr").remove();						
					},
					error:function(data){
						
					}
				});
	  });
  
	  
	  
  });
  
  
  </script>
</head>
<body>
	<div class="container">
    <h2>회원관리</h2>
    
    <table class="member-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>PW</th>
                <th>Name</th>
                <th>Point</th>
                <th>수정</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
		      <c:forEach var="mDto" items="${mDtoList}">
		            <tr>
				            <td class="id">${mDto.id}</td>
			                <td class = "pw">${mDto.pw}</td>
			                <td class= "name">${mDto.name}</td>
			                <td class = "point">${mDto.point}</td>
			                <td><button class="btn-edit">수정</button></td>
		                <td><button class="btn-delete">삭제</button></td>
		            </tr>
		      </c:forEach>
            </tbody>
    </table>

    <div class="scheduler-section">
        <h2>스케줄러관리</h2>
        <form action = "startScheduler" method = "post">
        <button class="btn-control">스케줄러(20초마다 포인트1 증가) 실행 시작</button>
        </form>
        <form action="stopPlan" method="post">
        <button class="btn-control">스케줄러 실행 종료</button>
        </form>
    </div>
</div>



</body>
</html>