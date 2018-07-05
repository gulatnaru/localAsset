<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#main_center{
		width: 600px;
		height: 400px;
		margin: 0 auto;
		background: white;
		text-align: center;
	}
</style>

<div id="main_center">
	<h1>User Update</h1>
<form action="user.cacao?cmd=updateimpl" method="post">
	ID: ${userupdate.id }<br>
	<input type="hidden" name="id" value="${userupdate.id }">
	PWD<input type="password" name="pwd" value="${userupdate.pwd }"><br>
	NAME<input type="text" name="name" value="${userupdate.name }"><br>
	<input type="submit" value="update">
</form>
</div>

