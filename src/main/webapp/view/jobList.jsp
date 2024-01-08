<%@page import="com.shinhan.dto.JobDTO"%>
<%@page import="com.shinhan.dto.deptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/project1/static/css/jobList.css">
<%
List<JobDTO> jobList = (List<JobDTO>) request.getAttribute("jobList");
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
			<th>직무 ID</th>
			<th>직무 이름</th>
			<th>직무 내용</th>
		</tr>
		<%
		for (JobDTO job : jobList) {
		%>
		<tr>
			<td><%=job.get직무_ID() %></td>
			<td><%=job.get직무_이름() %></td>
			<td><%=job.get직무_내용() %></td>
			
			<%-- <td>${job.직무_내용}</td> --%>
		</tr>
		<%
		}
		%>
	</table>

	<jsp:include page="goHome.jsp"></jsp:include>
	<jsp:include page="alert.jsp"></jsp:include>
</body>
</html>