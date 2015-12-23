
<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="java.io.*" %>
<%@ page import="FileControl.*" %>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <style>
      #map {
        height: 500px;
        weight: 400px;
      }
    </style>
    <link rel="icon" href="../../favicon.ico">

    <title>Come to Columbia and Eat</title>

    <!-- Bootstrap core CSS -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" >

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"> </script>


  
  
 
  
  
    <script type="text/javascript">

// function ab(){
// 	var aa=5; 
// }	
// function ac(){
	
// 	var bb=aa;
	
// }
// document.write(bb);

function getss()
{

	
	
// 	var usr1 = document.getElementById("ename").value;
   
	  
   
	
	var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 15,
    center: {lat: 40.8069, lng: -73.9598}
  });
		

	/*   map.data.loadGeoJson({"type": "MultiPoint","coordinates": [ [40.8052826,-73.9623642],[40.8068199,-73.9610596],[40.8056478,-73.9652628],[40.809742,-73.9598312],[40.8055649,-73.9653549],[40.8082466,-73.9634018],[40.8075483888388,-73.9640372246504],[40.802639,-73.9645004],[40.8068614740139,-73.9636992277863],[40.8022957,-73.9645309],[40.8061059500982,-73.9656401287098],[40.8084415644407,-73.9598026871681],[40.8033524,-73.9637756],[40.805419921875,-73.9643325805664],[40.8057975769043,-73.9656753540039],[40.8058346,-73.9658004],[40.803581,-73.96386],[40.8067777197635,-73.9639025505402],[40.8080586,-73.9640084],[40.8060225608803,-73.9656521669528],[40.8058379705299,-73.9656817540526],[40.8079033,-73.9642944],[40.806572,-73.9652634],[40.8064211,-73.9609312],[40.8079748,-73.9620565],[40.8073006,-73.9642868],[40.807905,-73.9642966],[40.8044472,-73.9661713],[40.8099709,-73.962353],[40.8032455,-73.9638519],[40.8034592,-73.9637527],[40.8068550378084,-73.9650799334049],[40.8068199,-73.9610596],[40.8072968,-73.9647293],[40.80757278825519,-73.9641344547272],[40.8064238727093,-73.9642866700888],[40.8053548,-73.9621317],[40.8073002845049,-73.96429002285],[40.8093296,-73.9636611],[40.805477,-73.965225],[40.807362,-73.960673],[40.8074417,-73.9652328],[40.80442,-73.966056],[40.80548,-73.965248],[40.8027077,-73.964241],[40.8056679,-73.965275],[40.8058426,-73.9624179]]}
); */
  /* setMarkers(map); */
  
   /* var marker = new google.maps.Marker({  
        position: temp,
        map: map
      }); */
  
     for (var i = 0; i < dSize; i++) 
    {	 
    	 if (usr1==tom){
    	var elmt = rawData[i];
    	 }
    	var marker = new google.maps.Marker({
    		
    		
    		position: {lat: elmt[1],lng:elmt[2]},
            map: map
            /* label: elmt[0] */ 
    	});
    	/* var info= '<div id="content">'+
        '<div id="siteNotice">'+
        '</div>'+
        '<h1 id="firstHeading" class="firstHeading">'elmt[0]'</h1>'; */
    	 /* attachMessage(marker, "name: \'"+elmt[0]+"\'  "+"Category:  \'"+elmt[3]+"\'");  */
    	attachMessage(marker, "Name: "+elmt[0]+" "+"Category:  "+elmt[3]);
    	}
    	 
      
	
}
  
  
  
function attachMessage(marker, message) {
	  var infowindow = new google.maps.InfoWindow({
	    content: message,
	    maxWidth: 100
	  });

	  marker.addListener('click', function() {
	    infowindow.open(marker.get('map'), marker);
	  });
	}  
</script>  



  </head>
  


<body>




<form id="form1" name="form1" method="post" action="">
  <input name="ename" type="text" id="ename" value="" />

  <input name="获取" type="button" onclick="javascript:getss();" value="获取" />
<!-- 	<input name="获取" type="button" onclick=function(){fun1();fun2();} value="获取" /> -->

</form>

<form id="form1" name="form1" method="post" action="">	
	<input type="hidden" name="id" value="<%=request.getAttribute("id") %>"/>
</form>




<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Have a good meal :)</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active">
              <a href="http://40.124.15.28:8080/">Home</a>
            </li>
           </ul>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
   <div class="jumbotron">
      
      <div class="container">
        <h1>Hello, everyone!</h1>
        <p>Come and see the most popular restaurants near Columbia University</p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-5">
        


				<form action="/example/html/form_action.asp" method="get"
					target="_blank">
					First name: <input type="text" name="fname" /><br /> Last name: <input
						type="text" name="lname" /><br /> <input type="submit"
						value="Submit" />
				</form>

				<p>请单击确认按钮，输入会发送到服务器上名为 "form_action.asp" 的页面。</p>

			</div>
        
        
	</div>
      <hr>

      <footer>
        <p>NGN 2015</p>
      </footer>
    </div> 



</body>
</html>
