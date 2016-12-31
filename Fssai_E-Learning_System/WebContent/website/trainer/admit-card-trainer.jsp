<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
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
         <%@include file="topMenuTrainer.jspf" %>
    </section>
    <!-- main body -->
    <section class="main-section-margin-top">
        <div class="container-fluid">
            <div id="wrapper">
                <!-- Sidebar -->
                 <%@include file="leftMenuTrainer.jspf" %>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Mr. ${loginUr.firstName}</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="page-header">
                                        <h1 id="timeline">Generate Admit Card</h1> </div>
                                    <!-- admit card starts -->
                                    <div id="dvContainer">
                                    <table align="center" width="856" border="0" style="border:1px solid #CCC;">
                                        <tr>
                                            <td width="35%">
                                                <table border="0">
                                                    <tr>
                                                        <td width="50%" align="center" class="border-bottom-logo"><img src="${pageContext.request.contextPath}/website/img/admit-card-fssai-logo.png" alt="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td width="50%" align="center" class="border-bottom-logo" style="border-bottom:0px;"><img src="${pageContext.request.contextPath}/website/img/admit-card-fostac-logo.png" alt="" /></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td width="50%">
                                                <table width="100%" border="0">
                                                    <tr>
                                                        <td align="center" class="heading">Food Safety Training & Certificate</td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center" class="sub-heading">FDA Bhavan, Kotla Road, Delhi ITO - 2016 - 2017</td>
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
                                                        <td width="48%" style="border-top: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold; margin:0px;">Gender: ${admitCardForm.gender }</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="52%" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold; margin:0px;">&nbsp;</td>
                                                        <td width="48%" style="border-top: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold; margin:0px;">City: ${admitCardForm.city }</td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td width="35%" style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Father's Name:${admitCardForm.fatherName }</td>
                                            <td width="50%" style="border-top: 1px solid #CCC; border-bottom: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;"></td>
                                        </tr>
                                        <tr>
                                            <td width="35%" style="padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">Course Content:
                                                <ol type="i" style="font-weight:normal; line-height:22px;">
                                                  <ct:forEach items="${admitCardForm.courseContent}" var="coursContentName">
       												<li>${coursContentName}</li>
       												</ct:forEach>
                                                </ol>
                                            </td>
                                            <td width="50%" style="padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;"></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" style="border-top: 1px solid #CCC;">
                                                    <tr>
                                                        <td align="center" style="padding:10px; border-right: 1px solid #CCC; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;"><strong>Centre of Examination:</strong>
                                                            <p style="font-weight:normal;">Centre Code: 1104,
                                                                <br> FDA Bhavan, ITO Bhvan</p>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center" style="border-top: 1px solid #CCC; border-right: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;"><img src="${pageContext.request.contextPath}/website/img/authorize-signature.png" width="58" height="30" alt="" />
                                                            <br> <strong>Authorize Signatory</strong></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td align="center" style="border-top: 1px solid #CCC; padding:10px; font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif; font-size:14px; font-weight:bold;">
                                                <table width="100%" border="0">
                                                    <tr>
                                                        <td width="61%" align="center"><img src="${pageContext.request.contextPath}/website/img/admit-card-candidate-photo.png" width="76" height="93" alt="" />
                                                            <br> <strong>Candidate Photo</strong></td>
                                                        <td width="39%"><img src="${pageContext.request.contextPath}/website/img/admit-card-candidate-signature.png" width="108" height="55" alt="" />
                                                            <br> <strong>Canditate Signature</strong></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                    </div>
                                    <!-- admit card ends -->
                                    
                                    <!-- button -->
                                    <div class="col-md-6 col-xs-12"></div>
                                    <div class="col-md-6 col-xs-12">
                                        <br><br>
                                     <input type="button" value="Download AdmitCard" id="btnPrint" />
                                    </div>
                                </div>
                            </div>
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
    
    