<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" -->
<!-- "http://www.w3.org/TR/html4/loose.dtd"> -->

<html>
<!-- core CSS -->
<link  href="website/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="website/css/font-awesome.min.css" rel="stylesheet" />
<link href="website/css/animate.min.css" rel="stylesheet" />
<link href="website/css/main.css" rel="stylesheet" />
<link href="website/css/responsive.css" rel="stylesheet" />

<link href="website/css/jquery-ui.css" rel="stylesheet">
<link href="website/css/jquery-ui.structure.css" rel="stylesheet">
<link href="website/css/jquery-ui.theme.css" rel="stylesheet">
   
<link href="website/css/custom.css" rel="stylesheet" />
<link href="website/css/aos.css" rel="stylesheet" />
<link href="website/css/owl.carousel.css" rel="stylesheet">
<link href="website/css/owl.transitions.css" rel="stylesheet">
<link href="website/css/visibility.css" rel="stylesheet" />

<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

<style>
#news .item img {
	display: block;
	width: 100%;
	height: auto;
}

</style>
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
		<div><tiles:insertAttribute name="header" /></div>
		
		<div style="float:left;padding:0px;width:100%;">
		<tiles:insertAttribute name="body" /></div>

		
    	<div style="clear:both"><tiles:insertAttribute name="footer" /></div>

<!--/#footer--> 

<script src="website/js/jquery.js"></script> 
<!--  <script src="website/afterLogin/js/jquery-2.1.0.min.js"></script> -->
<script src="website/js/bootstrap.min.js"></script> 
<script src="website/js/jquery.isotope.min.js"></script> 
<!-- <script src="website/js/main.js"></script>  -->
<script src="website/js/wow.min.js"></script>
<script src="website/js/validation.js"></script>

<script src="website/js/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#accordion").accordion();
        });
    </script> 
<script src="website/js/owl.carousel.js"></script> 
<script src="website/js/monthly.js"></script> 
<script src="website/js/jquery.swipebox.js"></script> 
<script>
        $(document).ready(function () {

        	/* $(function() {
      		  $( "#dateP" ).datepicker({  maxDate: 0 });
      		}); */
        	
        	$('#dateP').datepicker( {
        		defaultDate: new Date(),
        		yearRange: "-70:-1",
        		maxDate: 0,
                changeMonth: true,
                changeYear: true,
                showButtonPanel: true,
               
            });
        	
      		
      		
            $("#news").owlCarousel({

                navigation: false, // Show next and prev buttons
                slideSpeed: 300,
                paginationSpeed: 400,
                singleItem: true,
                autoPlay: true,
				responsive: true

                // "singleItem:true" is a shortcut for:
                // items : 1, 
                // itemsDesktop : false,
                // itemsDesktopSmall : false,
                // itemsTablet: false,
                // itemsMobile : false

            });

        });
    </script>
</body>
</html>
