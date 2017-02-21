<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
            <script type="text/javascript">
                function OnStart() {
                    searchUpcomingTraining();
                    searchCurrentAppliactionStatus();
                }
                window.onload = OnStart;

            </script>
            <script type="text/javascript">
                function searchUpcomingTraining() {
                    var result = "";
                    $.ajax({
                        type: 'post',
                        url: 'searchUpcomingTraining.jspp',
                        async: false,
                        success: function(data) {
                            $('#newTable').show();
                            //var mainData = JSON.stringify(data);
                            var mainData1 = jQuery.parseJSON(data);
                            alert(mainData1);
                            var j = 1;
                            $('#newTable tr').remove();
                            $('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Course Type</th><th>Course Name</th><th>Training Date</th><th>No. Of Seats</th><th>No. Of Enrollments</th><th>Required Seat</th><th>Status</th></tr>')
                            $.each(mainData1, function(i, obj) {
                                var a = null;
                                var statuss = obj[9];
                                if (statuss == "A") {
                                    a = "Confirmed";
                                } else {
                                    a = '<a href="#"  onClick="confirmStatus();" id="confirm" >Confirm</a>';
                                }
                                $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[7] + '</td><td>' + obj[8] + '</td><td>' + obj[2] + '</td><td>' + obj[6] + '</td><td>' + obj[2] + '</td><td>' + obj[6] + '</td><td>' + a + '</td></tr>');

                            });
                        }
                    });
                    return result;
                }

            </script>
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
                                            <li class="hori active"><a href="#">Home</a></li>
                                            <li class="hori"><a href="update-personal-information.fssai">UpdateA Personal Information</a></li>
                                            <li class="hori"><a href="view-feedback-details.html">View Feedback Details</a></li>
                                            <li class="hori"><a href="contactTC.fssai">Contact Us</a></li>
                                        </ul>
                                        <ul class="nav navbar-nav navbar-right">
                                            <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="changePasswordTCentre.fssai">Change Password</a></li>
                                                    <li><a href="fostac.fssai">Logout</a></li>
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
                        <%@include file="leftmenuTrainingPartner.jspf" %>
                            <!-- /#sidebar-wrapper -->
                            <!-- Page Content -->
                            <div id="page-content-wrapper">
                                <div class="container-fluid">

                                    <!-- vertical button -->
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Training Center</span> </a>
                                        </div>
                                    </div>
                                    <!-- add the content here for main body -->
                                    <!-- timeline  -->
                                    <div class="container-fluid">
                                        <div class="row">
                                            <!-- upcoming trainings -->
                                            <div class="col-xs-12 collapse in" id="show-result" aria-expanded="true" style="">
                                                <div class="personel-info">
                                                    <div class="row">
                                                        <div class="col-xs-12 table-overflow-responsive">
                                                            <fieldset>
                                                                <legend>
                                                                    <h3>Upcoming Trainings-</h3>
                                                                </legend>
                                                                <table id="newTable" class="table table-bordered table-responsive table-striped table-hover">
                                                                    <thead>
                                                                        <tr class="background-open-vacancies">
                                                                            <th>S.No</th>
                                                                            <th>Course Type</th>
                                                                            <th>Course Name</th>
                                                                            <th>Training Date</th>
                                                                            <th>No. of Seats</th>
                                                                            <th>No. Of Enrollments</th>
                                                                            <th>Required Seats</th>
                                                                            <th>Confirm Status</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                    </tbody>
                                                                </table>
                                                            </fieldset>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- table -->
                                            </div>

                                            <!-- current upcoming trainings -->
                                            <!-- upcoming trainings -->
                                            <div class="col-xs-12 collapse in table-overflow-responsive" id="show-result" aria-expanded="true" style="">

                                                <!-- table -->
                                                <div class="personel-info">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <fieldset>
                                                                <legend>
                                                                    <h3>Current Application Status</h3>
                                                                </legend>
                                                                <table class="table table-bordered table-responsive table-hover table-striped">
                                                                    <thead>
                                                                        <tr class="background-open-vacancies">
                                                                            <th>S.No</th>
                                                                            <th>Course Type</th>
                                                                            <th>Course Name</th>
                                                                            <th>Training Date</th>
                                                                            <th>No. of Vacancies</th>
                                                                            <th>No. Of Applications</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td>1</td>
                                                                            <td>Basic</td>
                                                                            <td>GHP-GMP</td>
                                                                            <td>12/12/2012</td>
                                                                            <td>58</td>
                                                                            <td><a href="application-status-inner.html">20</a></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>2</td>
                                                                            <td>Advance</td>
                                                                            <td>GHP-GMP</td>
                                                                            <td>12/12/2012</td>
                                                                            <td>58</td>
                                                                            <td><a href="application-status-inner.html">20</a></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>3</td>
                                                                            <td>Special</td>
                                                                            <td>GHP-GMP</td>
                                                                            <td>12/12/2012</td>
                                                                            <td>58</td>
                                                                            <td><a href="application-status-inner.html">20</a></td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </fieldset>
                                                        </div>
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
            <!-- <script>
                var id = localStorage.getItem('activeID');
                document.getElementById(id).className = "active";

            </script> -->
