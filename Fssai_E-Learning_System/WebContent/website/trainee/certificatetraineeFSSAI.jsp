<%@page import="java.text.SimpleDateFormat"%>
    <%@page import="java.util.Date"%>
        <html xmlns="http://www.w3.org/1999/xhtml">
        <%
String strNewDate = null;
try{

	strNewDate=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
}catch(Exception e){
}
%>

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
                                            <!-- timeline  -->
                                            <div id="dvContainer">
                                                <div class="container-fluid">
                                                    <div class="row">
                                                        <!-- html code to add from here -->
                                                        <div class="col-xs-12 certi-a-width">
						                                    <div class="col-xs-12"><img src="website/img/competence.jpg" class="img-responsive im-zoo"></div>
						                                    <div class="col-xs-12 th-certificate">
						                                        <h3>This is to certify that</h3>
						                                        <p class="nam-print">${traineeCertificateName}</p>
						                                        <hr class="na-per">
						                                        <p class="has-p">has received necessary training required to be a <strong>Master</strong></p>
						                                        <p class="has-p"><strong>Trainer</strong> for <strong>Project Clean Street Food .</strong></p>
						                                        <p class="has-p">The training was held on <span><strong>${trainingDate}</strong></span></p>
						                                        <hr class="on-hr-dashed">
						                                        <p class="has-p-at">at <span><strong> ${trainingAddress}</strong></span></p>
						                                        <hr class="at-hr-dashed">
						
						                                    </div>
						
						                                    <div class="col-xs-12 sign-pos-general">
						                                        <div class="col-md-6 col-xs-6">
						
						                                        </div>
						                                        <div class="col-md-6 col-xs-6 train-sign-pos">
						                                            <img src="website/img/training-coordinator-fssai.png" width="150px" class="img-responsive sign-train-p">
						                                            <hr class="train-ng-dashed">
						                                            <p class="text-center adju">Training Coordinator
						                                                <br><span>FSSAI</span></p>
						                                        </div>
						                                    </div>
						
						                                    <div class="col-xs-12 cert-btm-general-ce">
						                                        <p class="btm-p-sign">Certificate Number : ${certificateID}</p>
						                                        <p class="btm-p-sign">Date Issued : <%=strNewDate%></p>
						                                        <p class="btm-p-sign">Refresher Due : 2 years from date of issue.</p>
						                                    </div>
						
						                                    <div class="row">
						                                        <div class="col-md-4 col-xs-12"></div>
						                                        <div class="col-md-4 col-xs-12" style="position: relative; top: -30em;">
						                                            <a href="#" onclick="window.print()" class="btn login-btn" style="width: 100%;">Print</a>
						                                        </div>
						                                        <div class="col-md-4 col-xs-12"></div>
						                                    </div>
						
						                                </div>
                                                        <!-- html code ends here -->
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