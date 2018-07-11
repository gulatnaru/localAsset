<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
   #main_center{
      width:1280px;
      height:700px;
      background-size:100%;
      background-image:url('img/a1.jpg');
      text-align: center;
      
   }

   #w{
      position:relative;
      left: 670px;
      width:200px;
      height:100px;
      float:left;
      color:white;

   }
   #f{
      width:200px;
      height:100px;
      float:left;
      color:white;
   }
   #day{
   	  width:34px;
      height:19px;
   }
    #high{
   	  width:18px;
      height:19px;
   }
    #text{
   	  width:111px;
      height:38px;
   }
   .row{
   	  margin: 0 auto;
 	  background:black;
 	  opacity:0.5;
 	  position:relative;
 	  left:250px;
 	  top:400px;
 	  color:white;
   }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maps.google.com/maps/api/js?sensor=false"></script>
<script>
function wdisplay(data){
   var w = $(data).find('yweather\\:condition,condition');
   var code = w.attr('code');//attribute를 가져와서
   var date = w.attr('date');
   var temp = w.attr('temp');
   var text = w.attr('text');
   var result = '';
   
   result += '<img src="http://l.yimg.com/a/i/us/we/52/'+code+'.gif"/>';
   //result += '<h3>'+code+'</h3>';//화면에 뿌려라
   result += '<h3>'+date+'</h3>';
   result += '<h3>'+temp+'</h3>';
   result += '<h3>'+text+'</h3>';
   $('#w').html(result);
};

function fdisplay(data){
   var f = $(data).find('yweather\\:forecast,forecast');
   
   

      $(f).each(function(index,item){
    	    var code = $(item).attr('code'); 
            var day = $(item).attr('day');
            var high = $(item).attr('high');
            var text = $(item).attr('text');
            if(index < 9){
            var result='';
          	result+='<table><tbody>';
             result += '<tr><td><img src="http://l.yimg.com/a/i/us/we/52/'+code+'.gif"/></td>';
             result += '<td id="day"><h6>'+day+'</h6></td>';
            result += '<td id="high"><h6>'+high+'</h6></td>';
            result += '<td id="text"><h6>'+text+'</h6></td></tr>';
            result+='</tbody></table>';
            }    
         
   

      
      $('#weather'+index).html(result);
   });

   
};




$(document).ready(function(){
   var wurl = 'https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22seoul%22)%20%20and%20u%3D%27c%27&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys';
   

   $.ajax({
      url:wurl,
      success:function(data){
         wdisplay(data);
         fdisplay(data);
      },
      error:function(){
         alert('error');
      }
   });
});

</script>
<div id="main_center">
<div id="total">

<div class="row">
<div class="col-md-2" id="weather1"></div>&nbsp;&nbsp;&nbsp;&nbsp;
<div class="col-md-2" id="weather2"></div>&nbsp;&nbsp;&nbsp;&nbsp;
<div class="col-md-2" id="weather3"></div>&nbsp;&nbsp;&nbsp;&nbsp;
<div class="col-md-2" id="weather4"></div>&nbsp;&nbsp;&nbsp;&nbsp;

</div>
<div class="row">
<div class="col-md-2" id="weather5"></div>&nbsp;&nbsp;&nbsp;&nbsp;
<div class="col-md-2" id="weather6"></div>&nbsp;&nbsp;&nbsp;&nbsp;
<div class="col-md-2" id="weather7"></div>&nbsp;&nbsp;&nbsp;&nbsp;
<div class="col-md-2" id="weather8"></div>&nbsp;&nbsp;&nbsp;&nbsp;


</div>

<div id="w"></div>
<div id="f"></div>
</div>
</div>