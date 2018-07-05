<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SB Admin - Start Bootstrap Template</title>
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="index.html">Start Bootstrap</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
					<a class="nav-link" href="main.cacao?page=userAdd"> 
						<i class="fa fa-fw fa-dashboard"></i> 
						<span class="nav-link-text">
							User ADD
						</span>
					</a>
				</li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
					<a class="nav-link" href="user.cacao?cmd=list"> 
						<i class="fa fa-fw fa-area-chart"></i> 
						<span class="nav-link-text">
							User LIST
						</span>
					</a>
				</li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
					<a class="nav-link" href="main.cacao?page=productAdd"> 
						<i class="fa fa-fw fa-table"></i> 
						<span class="nav-link-text">
							Product ADD
						</span>
					</a>
				</li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
					<a class="nav-link" href="product.cacao?cmd=list"> 
						<i class="fa fa-fw fa-table"></i> 
						<span class="nav-link-text">
							Product LIST
						</span>
					</a>
				</li>
			</ul>
		</div>
	</nav>

	<nav>
		<c:choose>
			<c:when test="${nav != null }">
				${nav }
			</c:when>
			<c:otherwise>
				<a href="main.cacao">home</a>
			</c:otherwise>
		</c:choose>
	</nav>
	<section>
		<c:choose>
			<c:when test="${center != null }">
				<jsp:include page="${center }.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="center.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
	</section>




</body>

</html>
