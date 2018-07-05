<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	<h1>USER ADD</h1>
	<form action="user.cacao?cmd=add" method="post">
		id<input type="text" name="id"><br>
		pwd<input type="password" name="pwd"><br>
		name<input type="text" name="name"><br>
		<input type="submit" name="REGISTER"><br>
	</form>
</div>