<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 수정</title>
</head>
<link rel= "stylesheet" href="resources/css/common.css" />
<body>
<%@ include file="../main_top.jsp"%>
	<div class="content">
		<div class="title">
			<h1>도서 수정</h1>
		</div>
	<form method="post">
	<table>
				<tr>
					<th>도서명</th>
					<td><input type="text" name="title" value="${data.title }"></td>
				</tr>
				<tr>	
					<th>카테고리</th>
					<td><input type="text" name="category" value="${data.category }"></td>
				</tr>
				<tr>
					<th>가 격</th>
					<td><input type="text" name="price" value="${data.price }"></td>
				</tr>
			</table>
			<div class="btn">			
				<button type="submit">저장</button>
				<button type="reset"> 초기화</button>
			</div>
			
		</form>
	</div>
</body>
</html>