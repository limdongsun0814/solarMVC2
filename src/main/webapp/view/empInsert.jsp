<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/project1/static/css/empInsert.css">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/project1/empInsert.do" method="post">
		이름<input name="이름" /><br> 이메일<input name="이메일"/><br>
		전화번호<input title="형식 010-0000-0000입니다."  pattern="[0-1]{3}-[0-9]{4}-[0-9]{4}" name="전화번호"/><br>
		아이디<input name="서버_id"/><br> 비밀번호<input type="password" name="서버_password"/><br>
		<input type="submit" value="직원 등록"/>
	</form>
	<jsp:include page="alert.jsp"></jsp:include>
</body>
</html>