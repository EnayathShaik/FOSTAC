<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        $("#btnPrint").live("click", function () {
            var divContents = $("#dvContainer").html();
            var printWindow = window.open('', '', 'height=400,width=800');
            /* printWindow.document.write('<html><head><title>DIV Contents</title>'); */
            printWindow.document.write('</head><body >');
            printWindow.document.write(divContents);
            printWindow.document.write('</body></html>');
            printWindow.document.close();
            printWindow.print();
        });
    </script>
</head>
<body>
<form>
    <!-- horizontal navigation -->
    <section>
        <div class="container-fluid">
            <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                            </div>
                            <div id="navbar" class="navbar-collapse collapse">
                                <ul class="nav navbar-nav">
                                    <li class="hori"><a href="redirectHome.fssai">Home</a></li>
                                    <li class="hori"><a href="update-information.fssai">Update Information</a></li>
                                    <li class="hori"><a href="contactAA.fssai">Contact Us</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="changePasswordAssesAgency.fssai">Change Password</a></li>
                                            <li><a href="#">Logout</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <!--/.nav-collapse -->
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </section>
    <!-- main body -->
    <section class="main-section-margin-top">
        <div class="container-fluid">
            <div id="wrapper">
                <!-- Sidebar menu -->
           <%@include file="leftMenuTrainee.jspf"%>
                <!-- Sidebar menu -->
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${loginUser.firstName }</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="page-header" >
                                        <h1 id="timeline">Your Certificate</h1>
                                     <div id="dvContainer">
                                     <table align="left" width="800" border="0" style="background:url(${pageContext.request.contextPath}/website/img/certificate-bg.jpg) no-repeat; height:461px; border:1px solid #CCC;">
                                        <tr>
                                            <td width="25%">
                                                <table align="center" width="100%" border="0">
                                                    <tr>
                                                        <td class="heading">FOOD HYGIENE RATINGS</td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <table border="0" align="center">
                                                                <tr>
                                                                    <td><img src="${pageContext.request.contextPath}/website/img/yellow-star.png" width="25" height="24" alt="" /></td>
                                                                    <td><img src="${pageContext.request.contextPath}/website/img/yellow-star.png" width="25" height="24" alt="" /></td>
                                                                    <td><img src="${pageContext.request.contextPath}/website/img/yellow-star.png" width="25" height="24" alt="" /></td>
                                                                    <td><img src="${pageContext.request.contextPath}/website/img/gray-star.png" width="25" height="24" alt="" /></td>
                                                                    <td><img src="${pageContext.request.contextPath}/website/img/gray-star.png" width="25" height="24" alt="" /></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td width="60%" valign="top">
                                                <table width="100%" border="0">
                                                    <tr>
                                                        <td align="center"><img src="${pageContext.request.contextPath}/website/img/certificate-logo.png" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" align="center">
                                                            <h2 class="sub-heading">BASIC FOOD SAFETY CERTIFICATION</h2> <img src="${pageContext.request.contextPath}/website/img/top-bar.png" width="360" height="8" alt="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <p>Mr. ${loginUser.firstName }</p>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <p></p>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <table width="100%" border="0" align="center">
                                                                <tr>
                                                                    <td valign="bottom"><img style="padding-left:35px;" src="${pageContext.request.contextPath}/website/img/certificate-fostac-logo.png" alt="" /></td>
                                                                    <td><img src="${pageContext.request.contextPath}/website/img/foodsafety-logo.png" alt="" /></td>
                                                                    <td><img src="${pageContext.request.contextPath}/website/img/fssai.png" alt="" /></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                   </div>
                                   <div class="col-md-4 col-xs-12"></div>
          <!-- <div class="col-md-4 col-xs-12"><br><br><a href="training-timeline.fssai" style="width:100%;" class="login-btn btn">Next</a></div> -->
        </br>
        <div align-items: center> <input type="button" value="Download Certificate" id="btnPrint" />  </div>
                                </div>
                                
                                <!-- <div align-items:center> <input type="button" value="Download Certificate" id="btnPrint" />  </div> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </section>
    <!-- scripts -->
    </form>
</body>
</html>
    
   