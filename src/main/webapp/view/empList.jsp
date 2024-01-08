<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dto.empDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/project1/static/css/empList.css">

<%
List<empDTO> empList = (List<empDTO>) request.getAttribute("empList");
%>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
	<table>
		<tr>
			<th>직원 ID</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서</th>
			<th>직무</th>
			<th>퇴직유무</th>
		</tr>
		<%
		for (empDTO emp : empList) {
		%>
		<tr>
			<td><%=emp.get직원_ID() %></td>
			<td><%=emp.get이름() %></td>
			<td><%=emp.get이메일() %></td>
			<td><%=emp.get전화번호() %></td>
			<td><%=emp.get부서_이름()==null?"미발령":emp.get부서_이름() %></td>
			<td><%=emp.get직무_이름()==null?"미발령":emp.get직무_이름() %></td>
			<td><%=emp.get퇴직유무() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<jsp:include page="goHome.jsp"></jsp:include>
	<jsp:include page="alert.jsp"></jsp:include>
</body>
</html>