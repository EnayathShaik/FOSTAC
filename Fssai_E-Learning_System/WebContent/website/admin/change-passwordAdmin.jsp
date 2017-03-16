<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
function OnStart(){
	//alert('kk');
	BlankFields();
}
window.onload=OnStart;
</script>
<script>
function BlankFields(){
	document.getElementById("oldPassword").value='';
	document.getElementById("newPassword").value='';
	document.getElementById("confirmPwd").value='';
}
</script>


<script>
function pwdConfirm(){
	var pwd1 = document.getElementById("newPassword").value;
	var pwd2 = document.getElementById("confirmPwd").value;
	if(pwd1 == pwd2){
		//alert('ggg');
	}else{
		document.getElementById("confirmPwd").value="";
		alert('Passwords does not match');
	}
}
</script>
<script>
function pwd(){
	var pwd3 = document.getElementById("loginid").value;
	var pwd4 = document.getElementById("loginidd").value;
	//alert(pwd3 + "  " + pwd4)
	if(pwd3 == pwd4){
		//document.getElementById("password").value="";
		alert('Old passwords does not match');
	}else{
		//alert('kjkj');
	}
}
</script>
<cf:form action="changePasswordAdminSave.fssai" commandName="changePasswordForm" name="myForm" method="POST" onsubmit="pwdConfirm();" >
    <!-- horizontal navigation -->
    <section>
        <div class="container-fluid">
            <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li></li>
                            <li class="active hori"><a href="index.html">Home</a></li>
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
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <section class="section-form-margin-top">
                            <div class="container">
                                <!-- login form -->
                                <div class="row btm-margin">
                                    <div class="col-md-6  col-xs-12">
                                        <h3 class="text-capitalize heading-3-padding">Change Password</h3> </div>
                                    <div class="col-md-2 hidden-xs"></div>
                                </div>
                            </div>
                        </section>
                        <section class="section-form-margin-top">
                            <div class="container">
                                <!-- login form -->
                                <div class="row">
                                    <div class="col-xs-12">
                                        <form>
                                            <!-- left side -->
                                            <div class="col-md-6 col-xs-12">
                                                <!-- residential address -->
                                                <div class="form-group">
                                                    <label>Current Password</label>
                                                   <cf:errors path="oldPassword" cssclass="error" /><h4 style="color: Red">${created }</h4>
                       						 <cf:input type="text" path="oldPassword" class="form-control" placeholder="Current Password"/>
                                                <div class="form-group">
                                                    <label>New Password</label>
                                                   <cf:errors path="newPassword" cssclass="error" />
                    						    <cf:input type="text" path="newPassword" class="form-control" placeholder="Current Password"/>
                                                <div class="form-group">
                                                    <label>Confirm Password</label>
                                                    <cf:errors path="confirmPwd" cssclass="error" />
                       						 <cf:input type="text" path="confirmPwd" class="form-control" placeholder="Current Password"/>
                                                <div class="form-group">
                                                    <input type="submit" class="form-control login-btn" value="Confirm Password" /> </div>
                                            </div>
                                            <!-- right side -->
                                        </form>
                                    </div>
                                    <div class="col-md-6  col-xs-12" style="float:left;">
                                        <p><strong>Password Policy</strong></p>
                                        <ol>
                                            <li>Minimum Password length should be 7 charecters</li>
                                            <li>Maximum Password length should not exceed 15 charecters</li>
                                            <li>Password must contain one alphabet and one number</li>
                                        </ol>
                                    </div>
                                    <div class="col-md-2 hidden-xs"></div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </section>
    </cf:form>
    <!-- scripts -->
   