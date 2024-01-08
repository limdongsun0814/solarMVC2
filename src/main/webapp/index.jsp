<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/project1/static/css/index.css">
<script src="/project1/static/js/index.js"></script>
</head>
<body>
	<form method="post" action="/project1/loginCheck.do">
		<div>
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="id" name="id" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="password" name="password" /></td>
				</tr>
			</table>
		</div>
		<button id="submit">로그인</button>
	</form>
	<table>
		<tr>
			<td><button id="empInsert">직원 등록</button></td>
			<td><button id="findID">아이디 찾기</button></td>
			<td><button id="findPassword">비밀번호 찾기</button></td>
		</tr>
	</table>
	
	<jsp:include page="view/alert.jsp"></jsp:include>
</body>
</html>