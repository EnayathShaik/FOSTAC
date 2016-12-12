<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function OnStart(){
	searchTrainingPartnameList();
	searchAssessmentAgencyList();
}
window.onload = OnStart;
</script>
<script type="text/javascript">
function searchTrainingPartnameList(){
		var result="";
		$.ajax({
		type: 'post',
		url: 'searchTrainingPartnameList.jspp?',
		async: false, 
		success: function (data){
		$('#newTable').show();
		//var mainData = JSON.stringify(data);
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Training Partner Name</th><th>Number of Training Center IDs</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[1]+'</td><td><a href="" onClick="onLoadTrainingPartnerCenterId.fssai?id='+obj[0]+'">'+obj[2]+'</a></td></tr>');
			
		});
		}
		});
	return result;
}
</script>
<script type="text/javascript">
function searchAssessmentAgencyList(){
		var result="";
		$.ajax({
		type: 'post',
		url: 'searchAssessmentAgencyList.jspp?',
		async: false, 
		success: function (data){
		$('#newTable1').show();
		//var mainData = JSON.stringify(data);
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable1 tr').remove();
		$('#newTable1').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Number of Assessor IDs</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable1').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[1]+'</td><td><a href="onLoadAssessmentAgencyCenterId.jspp?"'+obj[0]+'>'+obj[2]+'</a></td></tr>');
			
		});
		}
		});
	return result;
}
</script>

<script>
function onLoadTrainingPartnerCenterId(){
	var  id = document.getElementById("idHiddenTrainingPartner").value;
	var result="";
	$('#newTable').hide();
	$('#newTable1').hide();
	$.ajax({
	type: 'post',
	url: 'onLoadTrainingPartnerCenterId.jspp?'+ id,
	async: false, 
	success: function (data){
	$('#newTable2').show();
	//var mainData = JSON.stringify(data);
	var mainData1 = jQuery.parseJSON(data);
	var j=1;
	$('#newTable2 tr').remove();
	$('#newTable2').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Training Partner Name</th><th>Training Center Id</th><th>Option</th></tr>')
	$.each(mainData1 , function(i , obj)
	{
		$('#newTable2').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[1]+'</td><td>'+obj[2]+'</td></tr>');
		
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
                                    <li class="active hori"><a href="adminHomepage.fssai">Home</a></li>
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
                <div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand"></li> -->
                        <li><a href="manageCourse.fssai">Manage Course</a></li>
                        <li><a href="manageCourseContent.fssai">Manage Course Content</a></li>
                        <li> <a href="trainingCalendarForm.fssai">Training Calendar</a> </li>
                        <li> <a href="assessmentSchedule.fssai">Update Assessor</a> </li>
                        <li> <a href="manageAssessmentQuestions.fssai">Assessment Questions</a> </li>
                        <li> <a href="updateTrainerAssessmentForm.fssai">TOT Assessment</a> </li>
                        <li> <a href="feedbackMaster.fssai">Feedback Master</a> </li>
                    </ul>
                </div>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> 
                                <span class="orange-font">Welcome Admin </span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">
                             <div class="col-xs-12">
                            <fieldset>
                                <legend>Pending Training Center ID Activation</legend>
                               
                                <table class="table-bordered table table-hover table-responsive"  id="newTable">
                                <thead>
                                            <tr class="background-open-vacancies">
                                                <td>S. No.</td>
                                                <td>Training Partner Name</td>
                                                <td>Number of Training Centers IDs</td>
                                            </tr>
                                        </thead>                                    
                                </table>                               
                            </fieldset>
                                 <br><br>
                            </div> <!-- col xs ends -->
                            
                            
                            <!-- second table -->
                            
                            
                            <div class="col-xs-12">
                               <fieldset>
                                    <legend>Pending Assessor ID Activation</legend> 
                                   
                                    <table class="table-bordered table table-responsive table-hover" id="newTable1">
                                        <thead>
                                            <tr class="background-open-vacancies">
                                                <td>S. No.</td>
                                                <td>Assessment Agency Name</td>
                                                <td>Number of Assessor IDs</td>
                                            </tr>
                                        </thead>
                                    </table>
                               </fieldset>                                    
                            </div>
                            
                            
                            <!-- add the content here for main body -->
                        <!-- timeline  -->
                     
                            <div class="col-xs-12">
                                
                                <fieldset>
                                    <legend>List of Pending Training Center ID Activation</legend>
                                     <table id="newTable2" class="table-bordered table-hover table table-responsive">
                                    <thead>
                                        <tr class="background-open-vacancies">
                                            <td>S. No.</td>
                                            <td>Training Partner Name</td>
                                            <td>Training Center ID</td>
                                            <td>Option</td>
                                        </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                               
                                </fieldset>
                                </div>
                            
                            <div class="col-md-2 hidden-xs"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    
    
                                