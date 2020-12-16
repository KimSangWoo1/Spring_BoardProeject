<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>first</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
<h2 align="center">게시판 목록</h2>
<style>
    table, th, td {
        border: 1px solid #bcbcbc;
      }
	td {
        text-align: center;
      }

</style>
<table align="left">
	<colgroup>
	<col width="100%" height="100%"/>
	</colgroup>
	<thead>
		<tr>
			<th scope="col"> 기능 </th>
		</tr>
		<tbody>
			<tr>
				<td><a id="go_boardWrite" href="/myapp/boardWrite/">게시글 작성</a></td>
			</tr>
			<tr>
				<td><a id="go_boardList" href="/myapp/boardList/">게시글 목록</a></td>
			</tr>
		</tbody>
</table>
<table align="center" >
    <colgroup>
        <col width="10%"/>
        <col width="*"/>
        <col width="15%"/>
        <col width="20%"/>
    </colgroup>
    <thead>
        <tr>
            <th scope="col">글번호</th>
            <th scope="col">제목</th>
            <th scope="col">조회수</th>
            <th scope="col">작성자</th>
            <th scope="col">작성일</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list }" var="row">
                    <tr>
                        <td><a name="no" href="/myapp/boardUpdateView?no=${row.idx}">${row.idx}</a></td>
                        <td>${row.title }</td>
                        <td>${row.hit_count }</td>
                        <td>${row.create_id }</td>
                        <td>${row.create_time }</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
          
    </tbody>
</table>

<script type="text/javascript">
		$(document).ready(function() {
			$("#go_boardList").on('click', function() {
				GoBoardList();
			})
			$("#go_boardWrite").on('click', function() {
				GoBoardWrite();
			})
		});
		
		function GoBoardList(){
			location.reload();
		}
		
		function GoBoardWrite(){
			window.location.href = "/myapp/boardWrite";
		}
		

</script>
</body>
</html>