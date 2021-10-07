<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<link rel="stylesheet" href="resources/css/common.css" />
<body>
<%@ include file="../main_top.jsp" %>
	<div class="content">
		<div class="title">
		<h2>로그인</h2>
		</div>
		<form method="post" >
			<table>
				<tr>	
					<th>ID</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<div class="btn">			
				<button type="submit">로그인</button>
				<button type="button" onclick="loaction.href='join.jsp'"> 회원가입</button>
			</div>
			
		</form>
	</div>

</body>
</html>