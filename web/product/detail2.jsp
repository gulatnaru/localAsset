<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#main_center {
	width: 600px;
	height: 400px;
	margin: 0 auto;
	background: white;
	text-align: center;
}
</style>
<script>
	$(document).ready(function() {
		$("#pdelete_bt").click(function() {
			var c = confirm('삭제 하시겠습니까');
			if (c == true) {
				location.href = 'product.cacao?cmd=delete&id=${pdetail.id }';
			}
			;
		});
	});
</script>
<body>
	<div id="main_center">
		<h1>Product Detail</h1>
		<img width="200px" src="img/${pdetail.imgname }">
		<h3>${pdetail.id }</h3>
		<h3>${pdetail.name }</h3>
		<h3>${pdetail.price }</h3>
		<h3>${pdetail.regdate }</h3>
		<a id="pdelete_bt" href="#">DELETE</a> <a
			href="product.cacao?cmd=update&id=${pdetail.id }">UPDATE</a>
	</div>
</body>