window.onload=init;
function init(){
	document.querySelector("#empInsert").onclick=empInsert;
	document.querySelector("#findID").onclick=findID;
	document.querySelector("#findPassword").onclick=findPassword;
}
function empInsert(){
	location.href="/project1/empInsert.do";
}
function findID(){
	var form = document.createElement("form");
	form.setAttribute("method","post");
	form.setAttribute("action","/project1/empfindID.do");
	var userEmail = prompt("당신의 이메일은 무엇인가요?","");
	var userPhone = prompt("당신의 전화 번호는 무엇인가요?","");
	var obj={"userEmail":userEmail,"userPhone":userPhone};
	for(let key in obj){
		var input = document.createElement("input");
		input.setAttribute("type","hidden");
		input.setAttribute("name",key);
		input.setAttribute("value",obj[key]);
		form.appendChild(input);
	}
	document.body.appendChild(form);
	form.submit()
}
function findPassword(){
	var form = document.createElement("form");
	form.setAttribute("method","post");
	form.setAttribute("action","/project1/empfindPassword.do");
	var userId = prompt("당신의 아이디는 무엇인가요?","");
	var userEmail = prompt("당신의 이메일은 무엇인가요?","");
	var userPhone = prompt("당신의 전화 번호는 무엇인가요?","");
	var obj={"userId":userId,"userEmail":userEmail,"userPhone":userPhone};
	for(let key in obj){
		var input = document.createElement("input");
		input.setAttribute("type","hidden");
		input.setAttribute("name",key);
		input.setAttribute("value",obj[key]);
		form.appendChild(input);
	}
	document.body.appendChild(form);
	form.submit()
}
