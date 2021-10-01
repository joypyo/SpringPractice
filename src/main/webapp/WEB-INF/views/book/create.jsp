<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 생성하기</title>
</head>
<link rel="stylesheet" href="resources/css/common.css" />
<body>
	<%@ include file="main_top.jsp"%>
	<div class="content">
		<div class="title">
			<h2>도서 등록</h2>
		</div>
		<form method="post">
			<table>
				<tr>
					<th>도서명</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>	
					<th>카테고리</th>
					<td><input type="text" name="category"></td>
				</tr>
				<tr>
					<th>가 격</th>
					<td><input type="text" name="price"></td>
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