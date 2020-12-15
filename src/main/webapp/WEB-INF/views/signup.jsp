<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<title>게시글 작성</title>
</head>
<body>
   <form id="form" name="signupform" action="${pageContext.request.contextPath}/boardInsert/" method="post" >
      <table>
         <colgroup>
            <col width="100px"/>
            <col width="200px"/>
         </colgroup>
         <caption>회원가입</caption>
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
   
      <input type="button" id="signup_submit"  value="회원가입" form="form">
      <input type="button" id="go_login"   value="취소">
   <script type="text/javascript">
	   $(document).ready(function(){
		   $("#signup_submit").on('click', function() {
			   DuplicatedUserCheck();
			})
			   $("#go_login").on('click', function() {
				   goLogin();
			})
	   });
	     function signup_click(){
	    	 var signupform = document.signupform;
	    	 var userid = signupform.id.value;
	    	 var userpw = signupform.pw.value;
	    	 if(!userid || !userpw){
	    		 alert("아이디와 비밀번호를 입력하세요");
	    	 }else{
	    		 //loginForm.submit();
	    		 DuplicatedUserCheck();
	    	 }    
         }
         function goLogin(){
          	location.href ="${pageContext.request.contextPath}/";
         }
         
         function DuplicatedUserCheck(){
          	 $.ajax({
          		 url:"/myapp/signUpChk",
          		 type:"POST",
          		 data:{
          			 id:$("#id").val(),
          			 pw:$("#pw").val()       			 
          		},
          		success: function(data){
          			alert(data.Msg);
          			if(data.Code==0){
          				goLogin();	
          			}else{
          				//location.reload();
          			}       			
          		},
          		error: function(request,status,error){
          		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

          		}        		 
          	 });
           } 
   </script>
</body>
</html>
