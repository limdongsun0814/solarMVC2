<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
var messageStr = "${alert}";
if(messageStr){
	  setTimeout(() => {
		  alert(messageStr);
	}, 100);
}
</script>