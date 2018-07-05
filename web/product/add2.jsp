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
	<h1>Product ADD</h1>
	<form action="product.cacao?cmd=add" method="post" enctype="multipart/form-data">
		name<input type="text" name="name"><br>
		price<input type="number" name="price"><br>
		IMG<input type="file" name="imgname"><br>
		<input type="submit" name="register"><br>
	</form>
</div>