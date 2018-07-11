<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<style class="cp-pen-styles">
#container {
    height: 400px; 
    width: 1500px;
    margin: 0 auto;
}
</style>

<script>
	function drawChart(mydata) {
		console.log(mydata[0]);
		Highcharts.chart('container', {
			chart : {
				type : 'column',
				options3d : {
					enabled : true,
					alpha : 10,
					beta : 25,
					depth : 70
				}
			},
			title : {
				text : '지방 재정 자립도'
			},
			subtitle : {
				text : ''
			},
			plotOptions : {
				column : {
					depth : 25
				}
			},
			xAxis : {
				categories : mydata[0],
				labels : {
					skew3d : true,
					style : {
						fontSize : '16px'
					}
				}
			},
			yAxis : {
				title : {
					text : null
				}
			},
			series : mydata[1]
		});
	}

	$(document).ready(function() {
		//var data = [{data:[10,40,30,50,60]}];
		$.ajax({
			url : 'table.cacao',
			success : function(data) {
				drawChart(data);
			},
			error : function() {
			}
		});
	});

	//# sourceURL=pen.js
</script>
</head>
<body>
   <div id="main_center">
      <h1>Chart</h1>
		<div id="container" style="height: 400px"></div>

   </div>
</body>
</html>