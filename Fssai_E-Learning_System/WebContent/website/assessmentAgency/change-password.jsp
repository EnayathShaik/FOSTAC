
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
	/* 
	alert('jhvjhvjhvjhvjhvjh');
	//var newPassword = document.getElementById("newPassword").value;
	
	var x=document.getElementById("newPassword").value;
	if(x =="" || x.length<12 ) {
		document.getElementById('newPassword').style.borderColor = "red";
    //	document.getElementById("oldPasswordError").style.display = 'block';
    	document.getElementById("newPassword").focus();
    	return false;
	}else{
	    document.getElementById('newPassword').style.borderColor = "#ccc";
	  //  document.getElementById("oldPasswordError").style.display = 'none';
	    }
	} */
/* 
	var paswd=  /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;  
	if(newPassword.value.match(paswd))   
	{   
		alert('Correct  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!1');  
		return true;  	
	}else{   
		alert('Wrong...!')   */
	
	var pwd1 = document.getElementById("newPassword").value;
	var pwd2 = document.getElementById("confirmPwd").value;
	if(pwd1 == pwd2){
	//	alert('password has matched  !!!!!!!!');
		return false;
	}else{
		document.getElementById("confirmPwd").value="";
		alert('Passwords does not match');
	}
	
	return true;
	
	
	}

</script>



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
<!-- <script type="text/javascript">
function checkPassword()   
{   
	alert('jhwadascjhasvjhcv');
	var newPassword = document.getElementById("newPassword").value;

	var paswd=  /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;  
	if(newPassword.value.match(paswd))   
	{   
		alert('Correct  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!1');  
		return true;  	
	}else{   
		alert('Wrong...!')  
		return false;  
	}  
}       



</script> -->





<!-- <script>
function matchPassword(){
	var newPwd1 = document.getElementById("newPassword").value;
	var cnPwd2 = document.getElementById("confirmPwd").value;
	if(newPwd1 == cnPwd2){
		alert('ggg');
	}else{
		document.getElementById("confirmPwd").value="";
		alert('Passwords does not match');
	}
}
</script> -->


    <cf:form action="passwordChangeAssesAgency.fssai"  onsubmit="return checkPass();" name="form1" method="POST" commandName="changePasswordForm" onclick="pwdConfirm();">
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
                        <li><a href="manage-course.html">Manage Course</a></li>
                        <li><a href="manage-course-content.html">Manage Course Content</a></li>
                        <li> <a href="training-calendar.html">Training Calendar</a> </li>
                        <li> <a href="assessment-schedule.html">Assessment Schedule</a> </li>
                        <li> <a href="manage-assessment-questions.html">Assessment Questions</a> </li>
                        <li> <a href="changePasswordAssesAgency.html">Update Assessment</a> </li>
                    </ul>
                </div>
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
                                            <h4 style="color: Red">${changed} </h4>
                                                <!-- residential address -->
                                                <div class="form-group">
                                                    <label>Current Password</label>
                                                   <%--  <cf:input path="id" value="${logId.loginDetails.loginId}"/> --%>
                                                   <label class="error visibility" id="oldPasswordError" style="color:red;">* enter your current password</label> 
                                                    <cf:input type="password" path="password"  class="form-control" placeholder="Current Password"/> </div>
                                                <div class="form-group">
                                                    <label>New Password</label>
                                                     <label class="error visibility" id="newPasswordError" style="color:red;">* enter your new password</label>
                                                    <cf:input type="password" class="form-control" name="newPwd" path="newPassword" placeholder="New Password"/> </div>
                                                <div class="form-group">
                                                    <label>Confirm Password</label>
                                                    <label class="error visibility" id="confirmPwdError" style="color:red;">* confirm password</label>
                                                    <cf:input type="password" class="form-control" path="confirmPwd" placeholder="Confirm Password"   /> </div>
                                                <div class="form-group">
                                                    <input type="submit" class="form-control login-btn" value="Change Password" /> </div>
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
