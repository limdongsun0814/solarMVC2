<%@page import="com.shinhan.dto.위치_DTO"%>
<%@page import="com.shinhan.dto.deptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/project1/static/css/jobList.css">

<%
List<위치_DTO> powerPlantList = (List<위치_DTO>) request.getAttribute("powerPlant");
%>
<html>
<head>
<meta charset="UTF-8">
<title>발전소 정보</title>
</head>
<body>
	<table>
		<tr>
			<th>발전소 ID</th>
			<th>건물 이름</th>
			<th>최대 발전량</th>
			<th>주소</th>
		</tr>
		<%
		for (위치_DTO powerPlant : powerPlantList) {
		%>
		<tr>
			<form action="/project1/powerPlantUpdate.do" method="post">
			<td><input type="number" name="powerPlantId" value="<%=powerPlant.get발전소_ID() %>"/></td>
			<td><input name="powerPlantName" value="<%=powerPlant.get건물_이름() %>"/></td>
			<td><input type="number" name="powerPlantMax" value="<%=powerPlant.get최대_발전량() %>"/></td>
			<td><input name="powerPlantWhere" value="<%=powerPlant.get주소() %>"/></td>
			<td><input type="submit" value="발전소 수정"/></td>
			</form>
		</tr>
		<%
		}
		%>
	</table>
	<h1>${alert}</h1>
	<jsp:include page="goHome.jsp"></jsp:include>
</body>
</html>