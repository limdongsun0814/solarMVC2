<%@page import="com.shinhan.dto.empDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
empDTO emp = (empDTO) session.getAttribute("empInfo");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/project1/static/css/jobList.css">
</head>
<body>
	<h1>개인 정보</h1>
	<form action="/project1/correction.do" method="post">
	<table >
		<tr>
			<td>이름</td>
			<td><input name="이름" value="<%=emp.get이름()%>"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" name="이메일" value="<%=emp.get이메일()%>"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input title="형식 010-0000-0000입니다."  pattern="[0-1]{3}-[0-9]{4}-[0-9]{4}" name="전화번호" value="<%=emp.get전화번호()%>"></td>
		</tr>
		<tr>
			<td>부서 ID</td>
			<td><input name="부서_ID" value="<%=emp.get부서_이름()%>"></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input name="아이디" value="${empInfo.login_ID}"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input name="비밀번호" value="${empInfo.login_password}"></td>
		</tr>
		<tr>
			<td>직무 ID</td>
			<td><input name="직무ID" value="<%=emp.get직무_이름()%>"></td>
		</tr>
		<tr>
			<td>퇴직유무 ID</td>
			<td><input name="퇴직유무" title="Y or N 입니다."  pattern="[Y,N]{1}" value="<%=emp.get퇴직유무()%>"></td>
		</tr>
	</table>
	<input type="submit"  value="정보 수정"/>
	</form>
	<jsp:include page="goHome.jsp"></jsp:include>
	<jsp:include page="alert.jsp"></jsp:include>
</body>
</html>