<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" -->
<!-- "http://www.w3.org/TR/html4/loose.dtd"> -->

<html>
<!-- core CSS -->
<link  href="website/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="website/css/font-awesome.min.css" rel="stylesheet" />
<link href="website/css/animate.min.css" rel="stylesheet" />
<link href="website/accordion/main.css" rel="stylesheet" />
<link href="website/css/responsive.css" rel="stylesheet" />

<link href="website/css/jquery-ui.css" rel="stylesheet">
<link href="website/css/jquery-ui.structure.css" rel="stylesheet">
<link href="website/css/jquery-ui.theme.css" rel="stylesheet">
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

<!-- <script src="website/js/jquery.js"></script>  -->
<script src="website/js/bootstrap.min.js"></script> 
<script src="website/js/jquery.isotope.min.js"></script> 

<script src="website/js/wow.min.js"></script>
<script src="website/js/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#accordion").accordion();
        });
    </script> 

</body>
</html>
