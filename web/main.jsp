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

<style>
.modal-body div span{
	display: inline-block;
	width : 100px;
	text-align:left;
}
.modal-body{
	text-align:center;
}
.nav-item{

}

</style>

<script>
$(document).ready(function(){
	$('#alogin').click(function(){
		$('#login_form').attr('method','post');
		$('#login_form').attr('action','loginout.cacao');
		$('#login_form').submit();
	});
});
</script>


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
      		<ul class="navbar-nav ml-auto">
      		<c:choose>
				<c:when test="${user.id == null}">
      		 	<li class="nav-item">
        			<a class="nav-link" data-toggle="modal" data-target="#exampleModal1">
       				<i class="fa fa-fw fa-sign-in"></i>Login</a>
        		</li>
        		</c:when>
        		<c:otherwise>
		        <li class="nav-item">
        			<a class="nav-link" data-toggle="modal" data-target="#exampleModal2">
       				${user.name }님 환영합니다. <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        		</li>
        	    </c:otherwise>
			</c:choose>
      		</ul>
    	</div>
		
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
				<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
					<a class="nav-link" href="main.cacao?page=weather"> 
						<i class="fa fa-fw fa-table"></i> 
						<span class="nav-link-text">
							Weather
						</span>
					</a>
				</li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
					<a class="nav-link" href="main.cacao?page=chart"> 
						<i class="fa fa-fw fa-table"></i> 
						<span class="nav-link-text">
							Chart
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

<!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Login Modal-->
    <div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">login</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true"></span>
            </button>
	      </div>
	      <form id="login_form">
	        <div class="modal-body">
	          	<div>
					<span>ID</span><input type="text" name="id"><br>
				</div>
				<div>
					<span>PWD</span><input type="password" name="pwd"><br>
				</div>
	        </div>         		
	        <div class="modal-footer">
            	<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            	<a class="btn btn-primary" id="alogin">Login</a>
          	</div>
          </form>
        </div>
      </div>
    </div>
    
     <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true"></span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="loginout.cacao">Logout</a>
          </div>
        </div>
      </div>
    </div>


    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="js/sb-admin-charts.min.js"></script>
  </div>


</body>

</html>
