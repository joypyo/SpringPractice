<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<link rel="stylesheet" href="resources/css/common.css" />
<body>
<%@ include file="../main_top.jsp" %>
	<div class="content">
		<div class="title">
		<h2>회원가입</h2>
		</div>
		<form method="post" >
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>	
					<th>ID</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="tel"></td>
				</tr>
			</table>
			<div class="btn">			
				<button type="submit">회원가입</button>
				<button type="reset"> 초기화</button>
			</div>
			
		</form>
	</div>

</body>
</html>