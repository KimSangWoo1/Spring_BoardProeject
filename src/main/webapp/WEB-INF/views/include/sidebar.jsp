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
		<h3 class="panel-title">�Խñ� ���</h3>
	</div>
	
	<ul class="list-group">
		<li class="list-group-item"><a href="/myapp/board/boardWrite.do/">�Խñ� �ۼ�</a>
		<li class="list-group-item"><a href="/myapp/board/boardList.do">�Խñ� ���</a>
		<li class="list-group-item"><a href="/myapp/logout.do">�α׾ƿ�</a>	
	</ul>
</div>

</body>
</html>