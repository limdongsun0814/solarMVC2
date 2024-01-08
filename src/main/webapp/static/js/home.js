window.onload = homeInit;
console.log("testsetes");
function homeInit() {
	console.log("init");
	document.querySelector("#empList").onclick = empList;
	document.querySelector("#deptList").onclick = deptList;
	document.querySelector("#deptUpdate").onclick = deptUpdate;
	document.querySelector("#deptInsert").onclick = deptInsert;
	document.querySelector("#jopList").onclick = jopList;
	document.querySelector("#jopUpdate").onclick = jopUpdate;
	document.querySelector("#jopInsert").onclick = jopInsert;
	document.querySelector("#powerPlantList").onclick = powerPlantList;
	document.querySelector("#powerPlantUpdate").onclick = powerPlantUpdate;
	document.querySelector("#powerPlantInsert").onclick = powerPlantInsert;
	document.querySelector("#powerList").onclick = powerList;
}
function empList() {
	console.log("test");
	location.href = "/project1/empList.do";
}
function deptList() {
	location.href = "/project1/deptList.do";
}
function jopList() {
	location.href = "/project1/jobList.do";
}
function powerPlantList() {
	location.href = "/project1/powerPlantList.do";
}
function deptInsert() {
	var form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", "/project1/deptInsert.do");
	var deptName = prompt("추가할 부서 이름은 무엇인가요?", "");
	var obj = { "deptName": deptName };
	for (let key in obj) {
		var input = document.createElement("input");
		input.setAttribute("type", "hidden");
		input.setAttribute("name", key);
		input.setAttribute("value", obj[key]);
		form.appendChild(input);
	}
	document.body.appendChild(form);
	form.submit();
}

function jopInsert() {
	var form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", "/project1/jobInsert.do");
	var jobName = prompt("추가할 직무 이름은 무엇인가요?", "");
	var jobDetail = prompt("추가할 직무 내용은 무엇인가요?", "");
	var obj = { "jobName": jobName, "jobDetail": jobDetail };
	for (let key in obj) {
		var input = document.createElement("input");
		input.setAttribute("type", "hidden");
		input.setAttribute("name", key);
		input.setAttribute("value", obj[key]);
		form.appendChild(input);
	}
	document.body.appendChild(form);
	form.submit();
}
function powerPlantInsert() {
	var form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", "/project1/powerPlantInsert.do");
	var powerPlantName = prompt("추가할 발전소 이름은 무엇인가요?", "");
	var powerPlantMax = prompt("추가할 최대 발전량은 얼마인가요?", "");
	var powerPlantWhere = prompt("추가할 발전소의 주소는 어디인가요?", "");
	var obj = { "powerPlantName": powerPlantName, "powerPlantMax": powerPlantMax,"powerPlantWhere":powerPlantWhere };
	for (let key in obj) {
		var input = document.createElement("input");
		input.setAttribute("type", "hidden");
		input.setAttribute("name", key);
		input.setAttribute("value", obj[key]);
		form.appendChild(input);
	}
	document.body.appendChild(form);
	form.submit();
}
function deptUpdate() {
	location.href = "/project1/deptUpdata.do";
}


function jopUpdate() {
	location.href = "/project1/jobUpdata.do";
}

function powerPlantUpdate() {
	location.href = "/project1/powerPlantUpdate.do";
}

function powerList() {
	location.href = "/project1/powerList.do";
}