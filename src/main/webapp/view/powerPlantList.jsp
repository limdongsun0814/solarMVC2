<%@page import="com.shinhan.dto.위치_DTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dto.empDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/project1/static/css/jobList.css">

<%
List<위치_DTO> powerPlantList = (List<위치_DTO>) request.getAttribute("powerPlantList");
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
			<th>발전소 ID</th>
			<th>건물 이름</th>
			<th>주소</th>
			<th>최대 발전량</th>
		</tr>
		<%
		for (위치_DTO powerPlant : powerPlantList) {
		%>
		<tr>
			<td><%=powerPlant.get발전소_ID() %></td>
			<td><%=powerPlant.get건물_이름() %></td>
			<td><%=powerPlant.get주소() %></td>
			<td><%=powerPlant.get최대_발전량() %></td>
		</tr>
		<%
		}
		%>
	</table>

	<jsp:include page="goHome.jsp"></jsp:include>
	<jsp:include page="alert.jsp"></jsp:include>
</body>
</html>