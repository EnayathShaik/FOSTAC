<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
            <%
	System.out.print("trainee home page jsp");
%>

                <section>
                    <%@include file="../roles/top-menu.jsp"%>
                </section>
                <script>
                    var rollNo = '${roll}';

                    if (rollNo != undefined && rollNo != "") {
                        alert("Unique student ID is :" + rollNo);
                    }

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
                                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font"> Welcome ${userName}</span>
                                                </a>
                                            </div>
                                        </div>

                                        <!-- add the content here for main body -->
                                        <!-- timeline  -->
                                        <%@include file="../commonjsp/trainee-steps.jsp"%>
                                    </div>
                                </div>
                        </div>
                    </div>
                </section>
                <!-- <script>
                    var id = localStorage.getItem('activeID');
                    document.getElementById(id).className = "active";

                </script> -->
