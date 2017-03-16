<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" -->
<!-- "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content=" ">
    <title> Fostac </title>

    <!-- stylesheet -->
    <link href="website/afterLogin/css/bootstrap.css" rel="stylesheet" />
    <link href="website/afterLogin/css/custom.css" rel="stylesheet" />
    <link href="website/afterLogin/css/font-awesome.css" rel="stylesheet" />
    <link href="website/afterLogin/css/aos.css" rel="stylesheet" />
    <link href="website/afterLogin/css/owl.carousel.css" rel="stylesheet" />
    <link href="website/afterLogin/css/owl.transitions.css" rel="stylesheet" />
    <link href="website/afterLogin/css/swipebox.css" rel="stylesheet" />
    <link href="website/css/visibility.css" rel="stylesheet" />
    <link href="website/css/flatpickr.css" rel="stylesheet" />
    <script src="website/js/flatpickr.js"></script>
    <script src="website/js/JsBarcode.code128.min.js"></script>
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
<script type="text/javascript">window.PROFILEID = ${profileId} </script>
		<div><tiles:insertAttribute name="header" /></div>
		
		<div style="width:100%; float:left;padding:0px; height:100px;">
		
		<tiles:insertAttribute name="body" /></div>
		
    	<div style="clear:both; float:left;"><tiles:insertAttribute name="footer" /></div>
</body>
<script src="website/js/validation.js"></script>

</html>
