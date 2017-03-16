<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

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
                                    <li></li>
                                    <li class="active hori"><a href="index.html">Home</a></li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Management<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="trainee-user-management.html" class="clr">Trainee</a></li>
                                            <li><a href="trainer-user-management.html" class="clr">Trainer</a></li>
                                            <li><a href="training-center--user-management.html" class="clr">Training Center</a></li>
                                            <li><a href="assessor-user-management.html" class="clr">Assessor</a></li>
                                            <li><a href="admin--user-management.html" class="clr">Admin</a></li>
                                        </ul>
                                    </li>
                                   <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Master Data<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="state-master.html" class="clr">State</a></li>
                                            <li><a href="district-master.html" class="clr">District</a></li>
                                            <li><a href="city-master.html" class="clr">City</a></li>                                            
                                            <li><a href="region-mapping-master.html" class="clr">Region Mapping</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="manage-training-partner.html">Manage Training Partner</a></li>
                                    <li><a href="manage-assessment-agency.html">Manage Assessment Agency</a></li>
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
                <!-- Sidebar -->
                  <%@include file="../roles/slider.jsp" %>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Trainee Mr. Lorem </span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">
                            <div class="col-xs-12 table-overflow-responsive">
                                
                                <fieldset>
                                    <legend>List of Pending Training Center ID Activation</legend>
                                     <table class="table-bordered table-hover table table-responsive">
                                    <thead>
                                        <tr class="background-open-vacancies">
                                            <td>S. No.</td>
                                            <td>Training Partner Name</td>
                                            <td>Training Center Name</td>
                                            <td>Training Center ID</td>
                                        </tr>
                                    </thead>
                                    <tr>
                                        <td>1
                                            <input name="" type="checkbox" value="">
                                        </td>
                                        <td>Skilled India, New Delhi</td>
                                        <td>Karol Bagh</td>
                                        <td>KarolBagh123</td>
                                        <td><a href="training-partner-registration.html">Open</a></td>
                                    </tr>
                                    <tr>
                                        <td>2
                                            <input name="" type="checkbox" value="">
                                        </td>
                                        <td>Skilled India, New Delhi</td>
                                        <td>Karol Bagh</td>
                                        <td>KarolBagh123</td>
                                        <td><a href="training-partner-registration.html">Open</a></td>
                                    </tr>
                                </table>
                               
                                </fieldset>
                                
                                
                                
                              
                                <div class="col-xs-12 pull-right">
                                    <input style="margin-top:20px; width:100px;" type="button" class="form-control login-btn btn" value="Activate" /> </div>
                            </div>
                            <div class="col-md-2 hidden-xs"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>