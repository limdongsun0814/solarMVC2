<%@page import="com.shinhan.dto.deptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
List<deptDTO> deptList = (List<deptDTO>) request.getAttribute("deptList");
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/project1/static/css/deptList.css">
<title>직원 정보</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
	<table>
		<tr>
			<th>부서 ID</th>
			<th>부서 이름</th>
		</tr>
		<%
		for (deptDTO dept : deptList) {
		%>
		<tr>
			<td><%=dept.get부서_id() %></td>
			<td><%=dept.get부서_이름() %></td>
		</tr>
		<%
		}
		%>
	</table>

	<jsp:include page="goHome.jsp"></jsp:include>
	<jsp:include page="alert.jsp"></jsp:include>
</body>
</html>