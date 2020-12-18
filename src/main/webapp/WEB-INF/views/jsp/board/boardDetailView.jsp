<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>

</head>
<body>
<%@include file="../../include/header.jsp" %> 

<div class="container">
	<div class="card">
		<div class="card-header"><h3>${rtnMap.title}</h3></div>
		<div class="cord-body" style="height:300px">${rtnMap.content}</div>
	</div>	
</div>
</body>
</html>