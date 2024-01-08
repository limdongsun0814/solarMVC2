<%@page import="com.shinhan.dto.발전DTO"%>
<%@page import="com.shinhan.dto.위치_DTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dto.empDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/project1/static/css/jobList.css">
<%
ArrayList<발전DTO> powerList = (ArrayList<발전DTO>) request.getAttribute("powerList");
%>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
	<form action="/project1/powerList.do" method="post">
		<table>
			<tr>
				<td>확인할 발전소 ID</td>
				<td><input type="number" name="powerId"/></td>
			</tr>
			<tr>
				<td>시작 날짜</td>
				<td><input type="date" name="firstTime"/></td>
			</tr>
			<tr>
				<td>마지막 날짜</td>
				<td><input type="date" name="lastTime"/></td>
			</tr>
		</table>
		<input value="발전량 확인" type="submit" />
	</form>
	<hr>
	<table>
		<%
		if (powerList != null) {
		%>
		<tr>
			<th>발전소 ID</th>
			<th>측정 날짜</th>
			<th>발전량</th>
		</tr>
		<%
		for (발전DTO power : powerList) {
		%>
		<tr>
			<td><%=power.get발전소_ID()%></td>
			<td><%=power.get측정_날짜()%></td>
			<td><%=power.get발전량()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>

	<jsp:include page="goHome.jsp"></jsp:include>
	<jsp:include page="alert.jsp"></jsp:include>
</body>
</html>