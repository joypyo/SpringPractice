<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록</title>
</head>
<link rel= "stylesheet" href="resources/css/common.css" />
<body>
<%@ include file="../main_top.jsp"  %>
<div class="content">
	<div class="title">
		<h2>책 목록</h2>
	</div>
<table>
	<thead>
		<tr>
			<th>제목</th>
			<th>카테고리</th>
			<th>가격</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${data }" >
		<tr>
			<td>
				<a style="color:black;" href="detail?bookId=${row.book_id }">${row.title }</a>
			</td>
			<td>${row.category }</td>
			<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${row.price }" />&nbsp;원</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

	<form>
		<input type="text" placeholder="도서명 입력" size = "40" name="keyword" value="${keyword }" />
		<button type="submit">도서검색</button>
		<button type=button onclick="location.href='/create'">도서등록</button>
	</form> 
</div>
</body>
</html>