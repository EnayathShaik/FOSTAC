<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

<cf:form action="traineeUserManagementSearch.fssai" name="myForm" method="POST" commandName="traineeUserManagementForm" > 

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
                                    <li class="active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Management<span class="caret"></span></a>
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
                                    <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i>  <span class="caret"></span></a>
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
                <div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand"></li> -->
                        <li><a href="manageCourse.fssai">Manage Course</a></li>
                        <li><a href="manageCourseContent.fssai">Manage Course Content</a></li>
                        <li> <a href="trainingCalendarForm.fssai">Training Calendar</a> </li>
                        <li> <a href="assessmentSchedule.fssai">Update Assessor</a> </li>
                        <li> <a href="manageAssessmentQuestions.fssai">Assessment Questions</a> </li>
                        <li> <a href="updateTrainerAssessment.fssai">TOT Assessment</a> </li><li> <a href="feedback-master.html">Feedback Master</a> </li>
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
                                <i class="fa fa-bars"></i> <span class="orange-font">
                                Welcome Mr.  ${loginUser.loginId} </span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">
                            <section class="section-form-margin-top">
                                <!-- fostac logo -->
                                <!-- login form -->
                             
                                    <div class="col-xs-12">
                                        <h3 class="text-capitalize heading-3-padding">Trainee User Management</h3>
                                        <form>
                                            <!-- personal information -->
                                            <div class="personel-info">
                                                <fieldset>
                                                    <!-- left side -->
                                                    <div class="col-md-6 col-xs-12">
                                                        <div class="form-group">
                                                            <div>
                                                                <ul class="lab-no">
                                                                    <li class="style-li"><strong>First Name:</strong></li>
                                                                    <li class="style-li error-red">
                                                                    <cf:errors path="firstName" cssClass="error" /></li>
                                                                </ul>
                                                            </div>
<cf:input path="firstName"   placeholder="First Name" class="form-control"  /> </div>
                                                        <div class="form-group">
                                                            <div>
                                                                <ul class="lab-no">
                                                                    <li class="style-li"><strong>Middle Name:</strong></li>
                                                                    <li class="style-li error-red"> 
                                                                    <cf:errors path="middleName" cssClass="error" />
                                                                    </li>
                                                                </ul>
                                                            </div>
<cf:input path="middleName"   placeholder="Middle Name" class="form-control"  /> </div>
                                                        <div class="form-group">
                                                            <div>
                                                                <ul class="lab-no">
                                                                    <li class="style-li"><strong>Last Name:</strong></li>
                                                                    <li class="style-li error-red"> 
                                                                     <cf:errors path="lastName" cssClass="error" />
                                                                    </li>
                                                                </ul>
                                                            </div>
<cf:input path="lastName"   placeholder="Last Name" class="form-control"  /></div>
                                                    </div>
                                                    <!-- right side -->
                                                    <div class="col-md-6 col-xs-12">
                                                        <div class="form-group">
                                                            <div>
                                                                <ul class="lab-no">
                                                                    <li class="style-li"><strong>User ID:</strong></li>
                                                                    <li class="style-li error-red">
                                                                     <cf:errors path="userId" cssClass="error" />
                                                                    </li>
                                                                </ul>
                                                            </div>
<cf:input path="userId"   placeholder="UserId" class="form-control"  /></div>
                                                        <div class="form-group">
                                                            <div>
                                                                <ul class="lab-no">
                                                                    <li class="style-li"><strong>Aadhar Number:</strong></li>
                                                                    <li class="style-li error-red">
                                                                    <cf:errors path="aadharNumber" cssClass="error" /></li>
                                                                </ul>
                                                            </div>
<cf:input path="aadharNumber"   placeholder="Aadhar Number" class="form-control"  /></div>
                                                       
                                                        <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Status:</strong></li>
                                                            <li class="style-li error-red"></li>
                                                        </ul>
                                                    </div>
<cf:select path="status" class="form-control">
<cf:option value="A" label="Active" />
<cf:option value="i" label="In-Active" />
</cf:select>
                                               
                                                </div>
                                                    </div>
                                                    <!-- personal information ends -->
                                                </fieldset>
                                            </div>
                                            <!-- personal information ends -->
                                            <!-- Training center Details  -->
                                            <div class="row" style="height: 20px;"></div>
                                            <!-- captcha -->
                                            <!-- buttons -->
                                            <div class="col-md-4 hidden-xs"></div>
                                            <div class="col-md-4 col-xs-12">
                                                <a href="login.html">
                                                    <input type="submit" class="form-control login-btn" value="Search"> </a>
                                            </div>
                                            <div class="col-md-4 hidden-xs"></div>
                                            <!-- training center details ends -->
                                        </form>
                                        <br><br><br>
                                    </div>
                                    <div class="col-md-2 hidden-xs"></div>
                                    
                            </section>
                            <section class="section-form-margin-top">
                                <!-- fostac logo -->
                                <!-- login form -->
                                <div class="row" style="height:20px;"></div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <table class="table table-hover table-bordered table-responsive">
                                            <thead>
                                                <th>User ID</th>
                                                <th>First Name</th>
                                                <th>Middle Name</th>
                                                <th>Last Name</th>
                                                <th>Aadhar Number</th>
                                            </thead>
  <tbody>
                                            
<ct:forEach var="listValue" items="${searchTraineeUsermanagement}" varStatus="loop"><tr>
<td><label><a href="traineeRegistration.fssai" value="${listValue.id }">${listValue.loginDetails.loginId }</a></label></td>
<td><label>${listValue.firstName }</label></td>
<td><label>${listValue.middleName }</label></td>
<td><label>${listValue.lastName }</label></td>
<td><label>${listValue.aadharNumber }</label></td>


</tr>
 </ct:forEach>
  
  
  
  </tbody>              
                                        </table>
                                    </div>
                                    <div class="col-md-2 hidden-xs"></div>
                                </div>
                            </section>
                        </div>
                        <!-- row -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    </cf:form>