<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form  method="post">
	<div class="container">
		<div class="card">
			<intput type="text" class="card-header" value="${boardVO.title}">
			<input type="text" class="cord-body" style="height:300px"   value="${boardVO.content}">
		</div>	
	</div>
</form>
</body>
</html>