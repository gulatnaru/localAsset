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
	<h1>Product Update</h1>
	<!-- 
		�ű� �̹����� ���ε�Ǹ� ���� �̹��� ��ü
		�̹����� �������� ������ ���� �̹����� �״�� ���
	 -->
	<form action="product.cacao?cmd=updateimpl" method="post" enctype="multipart/form-data">
		ID: ${pupdate.id }<br>
		<input type="hidden" name="id" value="${pupdate.id }">
		NAME<input type="text" name="name" value="${pupdate.name }"><br>
		PRICE<input type="number" name="price" value="${pupdate.price }"><br>
		
		IMG<input type="file" name="newimgname"><br>
		<input type="hidden" name="imgname" value="${pupdate.imgname }">
		<input type="submit" name="REGISTER"><br>
	</form>
</div>