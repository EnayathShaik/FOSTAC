<%-- <%@page import="java.text.SimpleDateFormat"%>
    <%@page import="java.util.Date"%>
        <html xmlns="http://www.w3.org/1999/xhtml">
        <%
String strNewDate = null;
try{

	strNewDate=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	strNewDateExpiry = strNewDate.split("/")[0]+"/"+strNewDate.split("/")[1]+"/"+(Integer.parseInt(strNewDate.split("/")[2])+2);
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
                                                        <div class="col-xs-12 certi-width">
						                                    <div class="col-xs-12"><img src="website/img/hra-wi1.jpg" class="img-responsive"></div>
						                                    
						                                    <div class="col-xs-12 this-certify">
                                        <h3 class="text-center th-pos">This is to certify that</h3>
                                        <p class="text-center for-p"><span><strong>${traineeCertificateName}</strong></span></p>
                                        <hr class="nam-hr">
                                        <div class="di-msg">
                                            <p>has successfully completed the required competency to be appointed as Trainer for ${courseName} </p>
                                            <p>Supervisor Training, the training was held on
                                                <span class="on-dat">${trainingDate}</span><span><hr class="on-hr"></span></p>
                                            <p>at
                                                <span class="add-pos">${trainingAddress}</span><span><hr class="at-hr"></span><span class="full-stop">.</span></p>
                                        </div>
                                    </div>

                                    <div class="col-xs-12 sign-pos">
                                        <div class="col-md-6 col-xs-6">
                                        <img src="website/img/training-partner.jpg" alt="training partner signature" class="img-responsive sign-partner">
                                            <hr class="left-sign">
                                            <p class="left-p">Training Partner</p>
                                        </div>
                                        <div class="col-md-6 col-xs-6">
                                        <img src="website/img/training-coordinator-fssai1.jpg" alt="training coordinator fssai" class="img-responsive sign-coordinator">
                                            <hr class="right-sign">
                                            <p class="right-p text-center">Training Coordinator
                                                <br><span>FSSAI</span></p>
                                        </div>
                                    </div>

                                    <div class="col-xs-12 cert-btm">
                                        <p class="btm-p">Certificate Number :  ${certificateID}</p>
                                        <p class="btm-p">Date Issued : <%=strNewDate%></p>
                                        <p class="btm-p">Refresher Due : 2 years from date of issue.</p>
                                    </div>
						
						                                    <div class="row">
						                                        <div class="col-md-4 col-xs-12"></div>
						                                        <div class="col-md-4 col-xs-12" style="position: absolute;top: 54em;left: 14px;">
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

        </html> --%>
        
        
        
        
        
        
        
        
        
        
        
<%@page import="java.text.SimpleDateFormat"%>
    <%@page import="java.util.Date"%>
        <html xmlns="http://www.w3.org/1999/xhtml">
        <%
String strNewDate = null;
String strNewDateExpiry  = null;        
try{

	strNewDate=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	strNewDateExpiry = strNewDate.split("/")[0]+"/"+strNewDate.split("/")[1]+"/"+(Integer.parseInt(strNewDate.split("/")[2])+2);
}catch(Exception e){
}
%>

            <head>
                <title></title>
              <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
                <script type="text/javascript">
                    function printDiv() {    
                        var printContents = document.getElementById('dvContainer').innerHTML;
                        var originalContents = document.body.innerHTML;
                         document.body.innerHTML = printContents;
                         window.print();
                         document.body.innerHTML = originalContents;
                        }
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
                                           
                                              <!--  FOR FOOD SAFETY TRAINER -->
                                              <div id="dvContainer">
                                                <div class="container-fluid">
                                                    <div class="row">
                                                        <!-- html code to add from here -->
                                                        <div class="col-xs-12 certi-width">
						                                    <div class="col-xs-12" ><img src="website/images/1.jpg" class="img-responsive" ></div>
						            							
<div class="col-xs-12 this-certify">
<h2 class="text-center th-pos" style="margin-top: -254px;
   font-size: 34px;font-family:calibri;font-weight:bold;color:#365f91;">  Food  Safety Trainer</h2>
    <h2 class="text-center th-pos" style="margin-top: 2px;
    font-size: 34px;font-family:calibri;font-weight:bold;color:#365f91;"> Certificate of Competence</h2>

                                        <h3 class="text-center th-pos" style="margin-top:30px;font-size:18px; font-family: times new roman; font-weight: bold;
    font-size: 20px;">This is to certify that</h3>
                                        <p class="text-center for-p"><span><strong>${traineeCertificateName}</strong></span></p>
                                        <hr class="nam-hr">
                                        <div class=" text-center">
                                            <p style=" font-family: times new roman; font-weight: bold;
    font-size: 20px;margin-top:-10px;">has successfully completed training  </p>
                                            
                                        </div>
                                          <div class=" text-center">
                                            <p style=" font-family: times new roman; font-weight: bold;
    font-size: 20px;margin-top:-10px;">in</p>
                                            
                                        </div>
                                         <div class=" text-center">
                                            <p style="font-family: times new roman; font-weight: bold;
    font-size: 20px;"><span><strong>${courseName} </strong></span></p>
                                            
                                        </div>
                                          <div class=" text-center">
                                            <p style=" font-family: times new roman; font-weight: bold;
    font-size: 20px;">held at</p>
                                            
                                        </div>
                                         <div class=" text-center">
                                            <p style=" font-family: times new roman; font-weight: bold;
    font-size: 20px;">${trainingAddress}</p>
                                            
                                        </div>
                                        <div class=" text-center">
                                            <p style=" font-family: times new roman;
    font-size: 20px; font-weight: bold;">& is awarded this certificate.    </p>
                                            
                                        </div>
                                    </div>

                            
<br><br><br><br>
                                    <div class="col-xs-12 cert-btm-general" style="margin-top:21px;">
                                    <p class="btm-p">_______________</p>
                                        <p class="btm-p" style="font-weight:bold;">Training Coordinator</p>
                                        <p class="btm-p" style="font-weight:bold;">Training Conducted by: ${trainingPartner}</p>
                                        <p class="btm-p" style="font-weight:bold;">ID of Training Partner : ${trainingPartnerId}</p>
                                        <br><br>
                                         <p class="btm-p" style="font-weight:bold;">Certificate number: ${certificateID}</p>
                                          <p class="btm-p" style="font-weight:bold;">Date of Issue :  <%=strNewDate%></p>
                                          <br><br>
                                           
                                    </div>                     
						                      <div class="col-xs-12 sign-pos-general" style="margin-top:-30px;">
                                        <div class="col-md-6 col-xs-6">
                                     
                                            <p class="left-p" style="margin-left:-57px;font-weight:bold;">Refresher Due on: <%=strNewDateExpiry%></p>
                                        </div>
                                        <div class="col-md-6 col-xs-6" style="margin-top:-58px;">
                                         <img src="website/images/fostac-logo.png" width="150px" class="img-responsive sign-train-p">
                                           
                                        </div>
                                    </div>             
						     
						     									<!-- <div class="row">
						                                        <div class="col-md-4 col-xs-12"></div>
						                                        <div class="col-md-4 col-xs-12" style="position: absolute;top: 54em;left: 12px;">
						                                            <a href="#" onclick="window.print()" class="btn login-btn" style="width: 100%;">Print</a>
						                                        </div>
						                                        <div class="col-md-4 col-xs-12"></div>
						                                    </div> -->
						                                </div>
                                                        <!-- html code ends here -->
                                                    </div>
                                                </div>
                                            </div>
                                            <!--  FOOD SAFETY TRAINER ENDS -->
                                                          <div class="row">
						                                        <div class="col-md-4 col-xs-12"></div>
						                                        <div class="col-md-4 col-xs-12" style="position: absolute;top: 54em;left: 12px;margin-top:122px;margin-left:363px;" >
						                                            <a href="#" onclick="printDiv();" class="btn login-btn" style="width: 100%;">Print</a>
						                                        </div>
						                                        <div class="col-md-4 col-xs-12"></div>
						                                    </div>
                                            
                                        </div>
                                    </div>
                    </section>
                    <!-- scripts -->
                </form>
            </body>

        </html> 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        