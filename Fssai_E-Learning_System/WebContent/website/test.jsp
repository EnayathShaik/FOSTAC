<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cc"%>
    <!-- main body -->
    <section class="main-section-margin-top">
        <div class="container-fluid">
            <div id="wrapper">

                <!-- Sidebar -->
                <div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand">
                        </li> -->
                        <li>
                            <a href="assessment-calendar.html">Assessment Calendar</a>
                        </li>
                        <li>
                            <a href="mark-attendance.html">Mark Attendance</a>
                        </li>
                        <li>
                            <a href="update-result.html">Update Result</a>
                        </li>
                    </ul>
                </div>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">

                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle">
                                    <i class="fa fa-bars"></i> <span class="orange-font">Welcome Mr. Anuj
                                    <label id="nameAfterLogin" ></label>
                                    
                                    </span>
                                </a>
                            </div>
                        </div>

                        <!-- add the content here for main body -->
                        <!-- timeline  -->

                        <div class="container-fluid">
                            <div class="row">

                                <!-- upcoming trainings -->
                                <div class="col-xs-12 collapse in" id="show-result" aria-expanded="true" style="">
                                    <h1>Upcoming Assessment</h1>
                                    <!-- table -->
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <table class="table table-bordered table-responsive">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No</th>
                                                        <th>Traning Course Name</th>
                                                        <th>Training Date</th>
                                                        <th>Training Course Address</th>
                                                        <th>No. Of Participants</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>GHP-GMP</td>
                                                        <td>10/12/2016</td>
                                                        <td>404 test, New Delhi, 110011</td>
                                                        <td>58</td>
                                                    </tr>
                                                    <tr>
                                                        <td>2</td>
                                                        <td>GHP-GMP</td>
                                                        <td>10/12/2016</td>
                                                        <td>404 test, New Delhi, 110011</td>
                                                        <td>58</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3</td>
                                                        <td>GHP-GMP</td>
                                                        <td>10/12/2016</td>
                                                        <td>404 test, New Delhi, 110011</td>
                                                        <td>58</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>





