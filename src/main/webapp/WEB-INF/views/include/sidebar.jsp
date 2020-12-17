<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<div class ="col-md-3">
	<div class="panel panel-info">
		<h3 class="panel-title">게시글 기능</h3>
	</div>
	
	<ul class="list-group">
		<li class="list-group-item"><a href="/myapp/board/boardWrite.do/">게시글 작성</a>
		<li class="list-group-item"><a href="/myapp/board/boardList.do">게시글 목록</a>
		<li class="list-group-item"><a href="/myapp/logout.do">로그아웃</a>	
	</ul>
</div>

</body>
</html>