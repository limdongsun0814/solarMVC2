<%@page import="com.shinhan.dto.deptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/project1/static/css/jobList.css">

<%
List<deptDTO> deptList = (List<deptDTO>) request.getAttribute("deptList");
%>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보</title>
</head>
<body>
	<table>
		<tr>
			<th>부서 ID</th>
			<th>부서 이름</th>
		</tr>
		<%
		for (deptDTO dept : deptList) {
		%>
		<tr>
			<form action="/project1/deptUpdata.do" method="post">
			<td><input type="number" name="deptId" value="<%=dept.get부서_id() %>"/></td>
			<td><input name="deptName" value="<%=dept.get부서_이름() %>"/></td>
			<td><input type="submit" value="부서 수정"/></td>
			</form>
		</tr>
		<%
		}
		%>
	</table>
	<h1>${alert}</h1>
	<jsp:include page="goHome.jsp"></jsp:include>
	<jsp:include page="alert.jsp"></jsp:include>
</body>
</html>