<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/common.css" />
<body>
	<div class="top">
		<h1><a href="index">Find Books</a></h1>	
	</div>
	<div class="nav">
		<ul>
			<li><a href="create">도서 등록</a></li>
			<li><a href="list">도서 검색</a></li>
			<li><a href="update">도서 수정</a></li>
				<c:if test="${data == null }">
					<li><a href="join">회원가입</a></li>
					<li><a href="login">로그인</a></li>
					
				</c:if>
				<c:if test="${data != null}">
					<li><span>${data.id }님</span>
					<button onclick="location.href='logout'">로그아웃</button>
					</li>
				</c:if>
			
		</ul>
	</div>


</body>
</html>