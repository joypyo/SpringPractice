<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 보기</title>
</head>
<link rel="stylesheet" href="resource/css/common.css" />
<body>
<%@ include file="../main_top.jsp" %>
<fmt:requestEncoding value="UTF-8"/>
<div class="content">
	<div class="title">
		<h2>도서 상세 보기</h2>
	</div>
	<table>
	<tr>
		<th>제목</th>
		<td>${data.title }</td>
	</tr>
	<tr>
		<th>카테고리</th>
		<td>${data.category }</td>
	</tr>
	<tr>
		<th>가격</th>
		<td> <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price }" />원</td>
	</tr>
	<tr>
		<th>등록일</th>
		<td><fmt:formatDate  value="${data.insert_date }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
	</tr>
	</table>
	<div class="btn">
	<button onclick="location.href='update?bookId=${bookId }'">수정</button>
	<button onclick="location.href='list'">목록</button>
	<form action="delete" method="post">
	<button type="submit" >삭제</button>
	<input type="hidden" name="bookId" value="${bookId }" />
	</form>

</div>
</div>
</body>
</html>