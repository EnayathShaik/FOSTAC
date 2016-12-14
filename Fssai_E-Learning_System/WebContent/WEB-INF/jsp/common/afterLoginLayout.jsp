<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content=" ">
    <title> Fotest </title>

    <!-- stylesheet -->
    <link href="website/afterLogin/css/bootstrap.css" rel="stylesheet" />
    <link href="website/afterLogin/css/custom.css" rel="stylesheet" />
    <link href="website/afterLogin/css/font-awesome.css" rel="stylesheet" />
    <link href="website/afterLogin/css/aos.css" rel="stylesheet" />
    <link href="website/afterLogin/css/owl.carousel.css" rel="stylesheet" />
    <link href="website/afterLogin/css/owl.transitions.css" rel="stylesheet" />
    <link href="website/afterLogin/css/swipebox.css" rel="stylesheet" />
    <link href="website/css/visibility.css" rel="stylesheet" />
    
    <style>
        #news .item img {
            display: block;
            width: 100%;
            height: auto;
        }
    </style>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
		<div><tiles:insertAttribute name="header" /></div>
		
		<div style="width:100%; float:left;padding:0px; height:100px;">
		
		<tiles:insertAttribute name="body" /></div>
		
    	<div style="clear:both; float:left;"><tiles:insertAttribute name="footer" /></div>
</body>

<script src="website/js/jquery.js"></script> 
<script src="website/js/bootstrap.min.js"></script> 
<script src="website/js/jquery.isotope.min.js"></script> 
<script src="website/js/main.js"></script> 
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
<script type="text/javascript">
$('#trainingDate').datepicker( {
	defaultDate: new Date(),
	minDate: 0,
    changeMonth: true,
    changeYear: true,
    showButtonPanel: true,
   
});
</script>

</html>
