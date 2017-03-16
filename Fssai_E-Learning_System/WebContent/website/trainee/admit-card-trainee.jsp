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

                                                <!-- new admit card -->

                                                <table align="center" width="856" border="0" style="border:1px solid #CCC;">
                                                    <tr>
                                                        <td width="35%">
                                                            <table border="0">
                                                                <tr>
                                                                    <td width="50%" align="center" class="logo-admit"><img src="/Fssai_E-Learning_System/website/img/admit-card-fssai-logo.png" alt="" /></td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="50%" align="center" style="position: relative; top: 1.5em;" class="logo-admit" style="border-bottom:0px;"><img src="/Fssai_E-Learning_System/website/img/admit-card-fostac-logo.png" alt="" /></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                        <td width="50%">
                                                            <table width="100%" border="0">
                                                                <tr>
                                                                    <td align="center" class="heading">Food Safety Training & Certificate</td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="center" style="font-size: 14px;">
                                                                        <Strong>Training Center Address:</Strong> ${admitCardForm.trainingCenterName },
                                                                        <br> ${admitCardForm.address }
                                                                        <br> Mob. No : ${admitCardForm.mobile }
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="center" class="sub-heading" style="padding-top:20px; font-size: 16px; font-weight: 100;"></td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="center"><img id = "rollNumberBarcode" ></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td width="35%" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Roll Number : ${admitCardForm.rollNo }</td>
                                                        <td width="50%" style="border-top: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Course Code: ${admitCardForm.courseCode }</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="35%" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Candidate Name: ${admitCardForm.name } </td>
                                                        <td width="50%">
                                                            <table width="100%" border="0">
                                                                <tr>
                                                                    <td width="52%" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold; margin:0px;">Course Name: ${admitCardForm.courseName }</td>

                                                                </tr>
                                                                <tr>
                                                                    <td width="52%" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold; margin:0px;">Course Duration: ${admitCardForm.courseDuration }</td>

                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td width="35%" style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Father's Name: ${admitCardForm.fatherName }</td>
                                                        <td width="50%" style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; padding: 10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;"><strong>Examination Center: ${admitCardForm.trainingCenterName} </strong>
                                                            <p style="font-weight:normal;"><strong>Centre Code:  ${admitCardForm.trainingCenterCode}</strong>
                                                                <br>
                                                            </p>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Gender: ${admitCardForm.gender} </td>

                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Course Duration: ${admitCardForm.courseDuration}</td>
                                                    </tr>
                                                    <tr>
                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">State: ${admitCardForm.state}</td>

                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Start Date: ${admitCardForm.trainingStartDate}</td>
                                                    </tr>
                                                    <tr>
                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">District: ${admitCardForm.district}</td>

                                                        <td style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">End Date: ${admitCardForm.trainingEndDate}</td>
                                                    </tr>

                                                    <tr>
                                                        <td>
                                                            <table width="100%" border="0" style="border-top: 1px solid #CCC;">
                                                                <tr>
                                                                    <td style="padding:10px; border-right: 1px solid #CCC; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold; border-top: 1px solid transparent;">

                                                                        City: ${admitCardForm.city}
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td align="center" style="border-top: 1px solid #CCC;border-right: 1px solid #CCC;padding: 10px;font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif;font-size:14px;font-weight:bold;position: relative;top: -1em;border-bottom: 1px solid #ccc;padding-top: 5em;">
                                                                        <br>
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


                                            <!-- new admit card ends -->

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
            
            <script>
            
          
            	var rollnumber =' ${admitCardForm.rollNo }';
        			
        			JsBarcode("#rollNumberBarcode", rollnumber, {
        				width:1,
            			height:30,
            			quite: 10,
        				  displayValue: false
        				});
        			
              </script>
