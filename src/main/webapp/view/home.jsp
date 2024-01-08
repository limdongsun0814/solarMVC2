<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/project1/static/css/home.css">
<script src="/project1/static/js/home.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<br>
	<div id="home">
		<div id="emp">
			<label>직원</label>
			<ul>
				<li><button id="empList" name="empList">직원 확인</button></li>
			</ul>
		</div>
		<div id="dept">
			<label>부서</label>
			<ul>
				<li><button id="deptList" name="deptList">부서 확인</button></li>
				<li><button id="deptUpdate" name="deptUpdate">부서 수정</button></li>
				<li><button id="deptInsert" name="deptInsert">부서 추가</button></li>
			</ul>
		</div>
		<div id="jop">
			<label>직무</label>
			<ul>
				<li><button id="jopList" name="jopList">직무 확인</button></li>
				<li><button id="jopUpdate" name="jopUpdate">직무 수정</button></li>
				<li><button id="jopInsert" name="jopInsert">직무 추가</button></li>
			</ul>
		</div>
		<div id="power">
			<label>발전소</label>
			<ul>
				<li><button id="powerPlantList" name="powerPlantList">발전소
						확인</button></li>
				<li><button id="powerPlantUpdate" name="powerPlantUpdate">발전소
						수정</button></li>
				<li><button id="powerPlantInsert" name="powerPlantInsert">발전소
						추가</button></li>
				<!-- <button>발전소 제거</button> -->
				<li><button id="powerList" name="powerList">발전소 생산 전력
						확인</button></li>
			</ul>
		</div>
	</div>
	<%-- <h1>${alert}</h1> --%>
	<jsp:include page="alert.jsp"></jsp:include>
</body>
</html>