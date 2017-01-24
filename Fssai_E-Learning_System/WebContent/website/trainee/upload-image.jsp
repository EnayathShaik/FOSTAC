<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
            <!-- horizontal navigation -->
            <section>
                <%@include file="../roles/top-menu.jsp"%>
            </section>

            <script src="website/js/jquery.js"></script>
            <script>


            </script>
            <!-- main body -->
            <section class="main-section-margin-top">
                <div class="container-fluid">
                    <div id="wrapper">
                        <!-- Sidebar menu -->
                        <%@include file="../roles/slider.jsp"%>
                            <!-- Sidebar menu -->
                            <!-- /#sidebar-wrapper -->
                            <!-- Page Content -->
                            <div id="page-content-wrapper">
                                <div class="container-fluid">
                                    <!-- vertical button -->
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome</span>
                                            </a>
                                        </div>
                                    </div>

                                    <!-- add the content here for main body -->
                                    <!-- feedback form  -->

                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="table-responsive">
                                                <div class="col-xs-12">
                                                    <fieldset>
                                                        <% 
										String actionName = "";
										String uploadHeader = "";
										if (session.getAttribute("profileId").equals(3)) {
											
											 actionName = "saveImage.fssai";
											 uploadHeader = "Upload Image";
										} else if(session.getAttribute("profileId").equals(4)){ 
											actionName = "saveFile.fssai";
											 uploadHeader = "Upload Profile";
										}
										%>
                                                            <legend>
                                                                <h3><%=uploadHeader%></h3>
                                                            </legend>

                                                            <cf:form method="POST" action="<%=actionName%>" enctype="multipart/form-data">

                                                                <div class="col-md-4 col-xs-12">
                                                                    <span id="preview"></span>
                                                                    <input class="btn login-btn" type="file" id="file" name="file" />
                                                                </div>

                                                                <div class="col-md-4 col-xs-12">
                                                                    <input type="submit" class="btn login-btn" value="Upload">
                                                                </div>
                                                            </cf:form>

                                                    </fieldset>
                                                    <br>

                                                </div>
                                            </div>
                                        </div>
                                        <!-- row ends -->
                                    </div>
                                    <!-- fluid ends -->
                                </div>
                            </div>
                    </div>
                </div>
            </section>
            <script>
                $(document).ready(function() {

                    $("#file").change(function() {
                        $("span").html("");
                        var file = this.files[0];
                        displayPreview(file);
                    });

                });

            </script>
            <!-- scripts -->
