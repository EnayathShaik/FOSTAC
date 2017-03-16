<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
            <script type="text/javascript">
                function OnStart() {
                    searchTrainingPartnameList();
                }
                window.onload = OnStart;

            </script>
            <script type="text/javascript">
                function searchTrainingPartnameList() {
                    var result = "";
                    $.ajax({
                        type: 'post',
                        url: 'onLoadTrainingPartnerCenterId.jspp?',
                        async: false,
                        success: function(data) {
                            $('#newTable').show();
                            //var mainData = JSON.stringify(data);
                            var mainData1 = jQuery.parseJSON(data);
                            alert(mainData1);
                            var j = 1;
                            $('#newTable tr').remove();
                            $('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Training Partner Name</th><th>Training Center Name</th><th>Training Center Id</th><th>Option</th><th>Option</th></tr>')
                            $.each(mainData1, function(i, obj) {
                                $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[1] + '</td><td>' + obj[2] + '</td><td>' + obj[3] + '</td><td></td><td></td></tr>');

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
                                            <li></li>
                                            <li class="hori"><a href="adminHomepage.fssai">Home</a></li>
                                            <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Management<span class="caret"></span></a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="traineeUserManagementForm.fssai" class="clr">Trainee</a></li>
                                                    <li><a href="trainerUserManagementForm.fssai" class="clr">Trainer</a></li>
                                                    <li><a href="trainingCenterUserManagementForm.fssai" class="clr">Training Center</a></li>
                                                    <li><a href="assessorUserManagementForm.fssai" class="clr">Assessor</a></li>
                                                    <li><a href="adminUserManagementForm.fssai" class="clr">Admin</a></li>
                                                </ul>
                                            </li>
                                            <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Master Data<span class="caret"></span></a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="stateMaster.fssai" class="clr">State</a></li>
                                                    <li><a href="districtMaster.fssai" class="clr">District</a></li>
                                                    <li><a href="cityMaster.fssai" class="clr">City</a></li>
                                                    <li><a href="regionMappingMaster.fssai" class="clr">Region Mapping</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="manageTrainingPartnerForm.fssai">Manage Training Partner</a></li>
                                            <li><a href="manageAssessmentAgencyForm.fssai">Manage Assessment Agency</a></li>
                                        </ul>
                                        <ul class="nav navbar-nav navbar-right">
                                            <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="changePasswordAssesAgency.fssai">Change Password</a></li>
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
                       <%@include file="../roles/slider.jsp" %>
                        <!-- /#sidebar-wrapper -->
                        <!-- Page Content -->
                        <div id="page-content-wrapper">
                            <div class="container-fluid">
                                <!-- vertical button -->
                                <div class="row">
                                    <div class="col-lg-12">
                                        <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Admin</span> </a>
                                    </div>
                                </div>
                                <!-- add the content here for main body -->
                                <!-- timeline  -->
                                <div class="row">
                                    <div class="col-xs-12">

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
