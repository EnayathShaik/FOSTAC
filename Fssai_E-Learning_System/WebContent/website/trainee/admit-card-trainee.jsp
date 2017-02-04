<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
            <html xmlns="http://www.w3.org/1999/xhtml">

            <head>
                <title></title>
                <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
                <script type="text/javascript">
                    $("#btnPrint").live("click", function() {
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
                    <!-- horizontal navigation -->
                    <section>
                        <%@include file="../roles/top-menu.jsp"%>
                    </section>
                    <!-- main body -->
                    <section class="main-section-margin-top">
                        <div class="container-fluid">
                            <div id="wrapper">
                                <!-- Sidebar menu -->
                                <%@include file="../roles/slider.jsp" %>
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
                                            <!-- feedback form  -->
                                            <div id="dvContainer">
                                                <table align="center" width="856" border="0" style="border:1px solid #CCC;">
                                                    <tr>
                                                        <td width="35%">
                                                            <table border="0">
                                                                <tr>
                                                                    <td width="50%" align="center" class="logo-admit"><img src="${pageContext.request.contextPath}/website/img/admit-card-fssai-logo.png" alt="" /></td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="50%" align="center" class="logo-admit" style="border-bottom:0px;"><img src="${pageContext.request.contextPath}/website/img/admit-card-fostac-logo.png" alt="" /></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <td width="50%">
                                                            <table width="100%" border="0">
                                                                <tr>
                                                                    <td align="center" class="heading">Food Safety Training & Certificate</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="center" class="sub-heading">Cidade De Goa - 2016 - 2017</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="center" class="sub-heading" style="padding-top:20px;">Admit Card for HTET 2016-2017</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="center"><img src="${pageContext.request.contextPath}/website/img/admit-card-barcode.png" width="182" height="41" alt="" /></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td width="35%" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Roll Number: ${admitCardForm.rollNo }</td>
                                                        <td width="50%" style="border-top: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Applied for Course: ${admitCardForm.courseName }</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="35%" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Name: ${admitCardForm.name }</td>
                                                        <td width="50%">
                                                            <table width="100%" border="0">
                                                                <tr>
                                                                    <td width="52%" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold; margin:0px;">Category: ${admitCardForm.category }</td>
                                                                    <td width="48%" style="border-top: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold; margin:0px;">Gender: ${admitCardForm.title }</td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="52%" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold; margin:0px;">Center Name:</td>
                                                                    <td width="48%" style="border-top: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold; margin:0px;">City: ${admitCardForm.city }</td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td width="35%" style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Father's Name:${admitCardForm.fatherName }</td>
                                                        <td width="50%" style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Course Name:</td>
                                                    </tr>
                                                    <tr>
                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Course Code:</td>

                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Course Duration:</td>
                                                    </tr>
                                                    <tr>
                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">State:</td>

                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">District:</td>
                                                    </tr>
                                                    <tr>
                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Start Date:</td>

                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">End Date:</td>
                                                    </tr>

                                                    <tr>
                                                        <td>
                                                            <table width="100%" border="0" style="border-top: 1px solid #CCC;">
                                                                <tr>
                                                                    <td align="center" style="padding:10px; border-right: 1px solid #CCC; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;"><strong>Centre of Examination:</strong>
                                                                        <p style="font-weight:normal;">Centre Code: ${admitCardForm.trainingCenterCode}
                                                                            <br> ${admitCardForm.address}
                                                                        </p>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="center" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;"><img src="${pageContext.request.contextPath}/website/img/authorize-signature.png" width="58" height="30" alt="" />
                                                                        <br>
                                                                        <strong>Authorized Signatory</strong></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <td align="center" style="border-top: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">
                                                            <table width="100%" border="0">
                                                                <tr>
                                                                    <td width="61%" align="center"><img src="${imagePath}" width="76" height="93" alt="" />
                                                                        <br>
                                                                        <strong>Candidate Photo</strong></td>
                                                                    <td width="39%">
                                                                        <br>
                                                                        <br>
                                                                        <span style=" position: relative; top: 1.7em;"><strong>Canditate Signature</strong></span></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                            <!-- fluid ends -->
                                            <div class="col-md-4 col-xs-12"></div>
                                            <!-- <div class="col-md-4 col-xs-12"><br><br><a href="training-timeline.fssai" style="width:100%;" class="login-btn btn">Next</a></div> -->

                                            <div style="margin-top: 2em;" align="center">
                                                <input type="button" class="btn login-btn" value="Download AdmitCard" id="btnPrint" /> </div>
                                            <div class="col-md-4 col-xs-12"></div>
                                        </div>


                                    </div>
                            </div>
                        </div>
                    </section>
                    <!-- scripts -->
                </form>
            </body>

            </html>
