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
   <form id="form" action="${pageContext.request.contextPath}/boardInsert/" method="get" >
      <table>
         <colgroup>
            <col width="100px"/>
            <col width="200px"/>
         </colgroup>
         <caption>게시글 작성</caption>
         <tbody>
            <tr>
               <th scope="row">제목</th>
               <td><input type="text" id="title" name="title"></input></td>
            </tr>
            <tr>
               <td colspan="2"><textarea rows="10" cols="50" title="내용" id="content" name="content"></textarea>
            </tr>
         </tbody>
      </table>
   </form>
   
      <input type="button" id="board_write" onclick="boardInsert();" value="작성하기" form="form">
      <input type="submit" id="board_list" onclick="boardList();"  value="목록으로" form="form">
   <script type="text/javascript">
	   $(document).ready(function(){

	   });
	     function boardInsert(){
           $("#form").submit();
         }
         function boardList(){
          	location.href ="${pageContext.request.contextPath}/boardList/";
         }
   </script>
</body>
</html>