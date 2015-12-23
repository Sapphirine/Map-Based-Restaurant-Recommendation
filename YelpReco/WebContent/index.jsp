<%@ page language="java"
	import="java.io.*,java.util.*,java.sql.*,java.util.HashMap.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="FileControl.*"%>

<!--get the array from servlet -->







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

<title>Come to see our Recommendation and Eat</title>

<!-- Bootstrap core CSS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"> </script>
</head>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAxcCpuCzuIqT7W9Ly04mdUOL9w-Om6Z50&signed_in=true&libraries=visualization"></script>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Welcome to our recommendation
					page! </a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="http://40.124.15.28:8080/">Home
							page</a></li>
				</ul>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>
	<div id="map"></div>
	<div class="jumbotron">

		<div class="container">
			<h1>Welcome to YelpRecom, everyone!</h1>
			<p>Come and find potential restaurant!</p>
		</div>
	</div>



	<div style="font-size: 24px" class="container">
		<form id="form" name="input" action="YelpServlet" method="post">
			Your name please: <input name="user" type="text" /> <input
				type="submit" value="submit" />

		</form>
	</div>

<script>
	var array1 =[];
	var array2 =[];
	var array3 =[];
	var map;
	var eValue3;
	
	var frm = $('#form');
	frm.submit(function (ev) {
	    $.ajax({
	        type: frm.attr('method'),
	        url: frm.attr('action'),
	        data:frm.serializeArray(),
	        success: function (data) {
	        	console.log(data);
	        	//console.log(array1.length);
	        
	        	 var msg = JSON.parse(data);
	        	//#######
	        	var size = msg['size'][0];
	        	var lati = msg['latitude'];
	        	var longi = msg['longitude'];
	        	var name = msg['name'];
	        	console.log(lati); 
	        	//var myLatlng = new google.maps.LatLng();
	        	
// 	        	for(var m=0;m<size;m++){
	        		
// 	        		var eValue1 = lati[m];
// 	        		console.log(eValue1);
// 	        		var eValue2 = longi[m];
// 	        		eValue3=name[m];
// 	        		var myLatlng = new google.maps.LatLng(eValue1,eValue2);
// 	        		myLatlng.set
// 	        	 	console.log(array1.length);
//             		array1.push(myLatlng);
//             		console.log(array1.length);
//             		//drawmarker();
            		
            		
// 	        	}   
	        	
				var marker;
				var infowindow = new google.maps.InfoWindow();
        		for (var i = 0; i < size ; i++) {	        	    
        			console.log(size);
        			marker = new google.maps.Marker({
	    				//position: array1[i],
	            		position: new google.maps.LatLng(lati[i], longi[i]),
	    				map: map
	    			}); 
	    			console.log(lati[i]+" "+longi[i]);
	    			//attachMessage(marker, "Name: "+name[i]);
	    			
	    			google.maps.event.addListener(marker, 'click', (function(marker, i) {
	        	        return function() {
	        	          infowindow.setContent("Name: "+name[i]);
	        	          infowindow.open(map, marker);
	        	        }
	        	      })(marker, i));
	    		} 
	        	
	        	
	        }	    
	    });	
	    ev.preventDefault();
	});

	
	<%-- var longitude = <%=array1%>
	var latitude = <%=array2%>
	var name = <%=array3%>
	var num = <%=size1%> --%> 

// 	var num = array1.length;

    
	function initMap() {

		map = new google.maps.Map(document.getElementById('map'), {
	    zoom: 15,
	    center: {lat: 40.8069, lng: -73.9598}
	  });		
	  
	  
	     }	 
	
	
	google.maps.event.addDomListener(window,'load',initMap);      
	
	function drawmarker(){
		   for (var i = 0; i < array1.length ; i++) 
		    {	        	    	
/* 		    	var elmt1 = array1[i];
		    	var elmt2 = array2[i];
		    	 */
// 		    	var elmt3 = array3[i];
		    	var marker = new google.maps.Marker({
		    		position: array1[i],
		            map: map
		    	}); 
		    	/* var info= '<div id="content">'+
		        '<div id="siteNotice">'+
		        '</div>'+
		        '<h1 id="firstHeading" class="firstHeading">'elmt[0]'</h1>'; */
		    	 /* attachMessage(marker, "name: \'"+elmt[0]+"\'  "+"Category:  \'"+elmt[3]+"\'");  */
		    	attachMessage(marker, "Name: "+eValue3);
		    	}
		   
	}
	/*     for (var i = 0; i < 3; i++) 
		    {   	    	
		   		var marker = new google.maps.Marker({
	              position: rawData[i],
	              map: map
	          	});
	 	   		markers.push(marker); 
	 	    } 
	     attachMessage(marker, point[0]);  */

	  //call the setMarker function, to put the points we want to show on the map
	  


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

	<div class="container">
		<!-- Example row of columns -->
		<hr>
		<footer>
			<p>
				<span style="color: blue;">Big Data Analysis 2015</span>
			</p>
			<p>
				<span style="color: blue;">Columbia University</span>
			</p>
		</footer>
	</div>




</body>
</html>
