<%@page import="com.shinhan.dto.deptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/project1/static/css/home.css">
<title>부서 정보</title>
</head>
<body>
	<form>
		<table>
			<tr>
				<th>부서 이름</th>
			</tr>

			<tr>
				<td><input name="부서이름" /></td>
			</tr>
		</table>
		<input type="submit" value="부서 추가"/>
	</form>
	<jsp:include page="goHome.jsp"></jsp:include>
	<jsp:include page="alert.jsp"></jsp:include>
</body>
</html>