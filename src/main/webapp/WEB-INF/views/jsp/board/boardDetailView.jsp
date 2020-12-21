<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<%@include file="../../include/header.jsp" %> 

<div class="container">
	<div class="card">
		<div class="card-header"><h3>${boardVO.title}</h3></div>
		<div class="cord-body" style="height:300px">${boardVO.content}</div>
	</div>	
</div>

	  <input type="button" class="btn btn-info" id="go_list" value="목록" />
	  <c:choose>
	  	  <c:when test="${edit}">
		 	 <input type="button" class="btn btn-primary" id="go_update" value="수정"/>
		 	 <input type="button" class="btn btn-danger" id="go_delete" value="삭제"/>
		  </c:when>
	  </c:choose>
</body>
<script type="text/javascript">
		$(document).ready(function() {
			$("#go_list").on('click', function() {
				location.href = "${pageContext.request.contextPath}/board/boardPagingList.do?curPage=${curPage}";
			})
			$("#go_update").on('click', function() {
				location.href = "${pageContext.request.contextPath}/board/boardUpdateView.do?idx=${idx}&curPage=${curPage}";
			})
			$("#go_delete").on('click', function() {
				location.href = "${pageContext.request.contextPath}/board/boardDelete.do?idx=${idx}&curPage=${curPage}";
			})
		});

		function login_Click() {
			var loginForm = document.loginForm;
			var userid = loginForm.id.value;
			var userpw = loginForm.pw.value;
			if (!userid || !userpw) {
				alert("아이디와 비밀번호를 입력하세요");
			} else {
				loginCheck();
			}
		}
		function goSignUp() {
			location.href = "${pageContext.request.contextPath}/signup.do/";
		}
</script>
</html>