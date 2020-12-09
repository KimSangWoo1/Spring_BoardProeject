<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<title>게시판 테스트</title>
</head>
<body>
	<h2> 게시판 목록 </h2>
	<table>
		<colgroup>
			<col width="100px"/>
			<col width="200px"/>
			<col width="200px"/>
			<col width="100px"/>
		</colgroup>	
		<thead>
			<tr>
				<th scope="col">게시글번호</th>
				<th scope="col">제목</th>
				<th scope="col">게시글 조회수</th>
				<th scope="col">게시일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(list) > 0}">
					<c:forEach items="${list}" var ="row">
						<tr>
							<td>${row.IDX} </td>
							<td>${row.TITLE} </td>
							<td>${row.CLICK_CNT} </td>
							<td>${row.CREATE_DATE} </td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4"> 조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>