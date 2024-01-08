/**
 * 
 */
window.onload=init;
	console.log("test1");
function init(){
	document.querySelector("#correction").onclick=correction;
	document.querySelector("#logout").onclick=logout;
}
function correction(){
	location.href="/project1/correction.do";
}
function logout(){
	console.log("test");
	location.href="/project1/logout.do";
}
