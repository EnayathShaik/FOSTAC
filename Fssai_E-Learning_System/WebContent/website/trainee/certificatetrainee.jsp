        <%@page import="java.text.SimpleDateFormat"%>
    <%@page import="java.util.Date"%>
        <html xmlns="http://www.w3.org/1999/xhtml">
        <%
String strNewDate = null;
String strNewDateExpiry= null; 
try{

	strNewDate=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	strNewDateExpiry = strNewDate.split("/")[0]+"/"+strNewDate.split("/")[1]+"/"+(Integer.parseInt(strNewDate.split("/")[2])+2);
}catch(Exception e){
}
%>
            <head>
                <title></title>
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
						                                    <div class="col-xs-12"><img src="website/images/competencenew.jpg" class="img-responsive"></div>
						            							
<div class="col-xs-12 this-certify">
                                        <h3 class="text-center th-pos" style="margin-top:-40px;">This is to certify that</h3>
                                        <p class="text-center for-p"><span><strong></strong></span></p>
                                        <hr class="nam-hr">
                                        <div class=" text-center">
                                            <p>has successfully completed training  </p>
                                            
                                        </div>
                                          <div class=" text-center">
                                            <p>in</p>
                                            
                                        </div>
                                         <div class=" text-center">
                                            <p><span><strong>${courseName}</strong></span></p>
                                            
                                        </div>
                                          <div class=" text-center">
                                            <p>held at</p>
                                            
                                        </div>
                                         <div class=" text-center">
                                            <p>${trainingAddress}</p>
                                            
                                        </div>
                                        <div class=" text-center">
                                            <p>& is awarded this certificate.    </p>
                                            
                                        </div>
                                    </div>

                              
<br><br><br><br>
                                    <div class="col-xs-12 cert-btm-general" style="margin-top:35px;">
                                    <p class="btm-p">_______________</p>
                                        <p class="btm-p">Training Coordinator</p>
                                        
                                        <p class="btm-p">Training Conducted by: ${trainingPartner}</p>
                                        <p class="btm-p">ID of Training Partner :  ${trainingPartnerId}</p>
                                        <br><br>
                                         <p class="btm-p">Certificate number:  ${certificateID}</p>
                                          <p class="btm-p">Date of Issue : <%=strNewDate%></p>
                                          <br><br>
                                           
                                    </div>                     
						                      <div class="col-xs-12 sign-pos-general" style="margin-top:-30px;">
                                        <div class="col-md-6 col-xs-6">
                                     
                                            <p class="left-p" style="margin-left:-57px;">Refresher Due on: <%=strNewDateExpiry%></p>
                                        </div>
                                        <div class="col-md-6 col-xs-6" style="margin-top:-25px;">
                                         <img src="website/images/fostac-logo.png" width="150px" class="img-responsive sign-train-p">
                                           
                                        </div>
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