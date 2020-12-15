<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<form id="form" name="loginForm"
		action="${pageContext.request.contextPath}/login_click/" method="get">
		<table>
			<colgroup>
				<col width="100px" />
				<col width="200px" />
			</colgroup>
			<caption>로그인</caption>
			<tbody>
				<tr>
					<th scope="row">아이디</th>
					<td><input type="text" id="id" name="id"></input></td>
				</tr>
				<tr>
					<th scope="row">비밀번호</th>
					<td><input type="password" id="pw" name="pw"></input></td>
				</tr>
			</tbody>
		</table>
	</form>

	<input type="button" id="login_submit" value="로그인" form="form">
	<input type="button" id="go_signup" value="회원가입">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#login_submit").on('click', function() {
				login_Click();
			})
			$("#go_signup").on('click', function() {
				goSignUp();
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
			location.href = "${pageContext.request.contextPath}/signup/";
		}

		function loginCheck() {
			$.ajax({
				url : "/myapp/loginChk",
				type : "POST",
				data : {
					id : $("#id").val(),
					pw : $("#pw").val()
				},
				success : function(data) {
					alert(data.Msg);
					if(data.Code==0){
						window.location.href = "/myapp/index/";
					}else{
						//location.reload();
					}
				
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "message:"
							+ request.responseText + "\n" + "error:" + error);
				}
			});
		}
	</script>
</body>

</html>