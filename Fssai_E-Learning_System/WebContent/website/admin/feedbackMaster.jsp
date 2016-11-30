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
<script type='text/javascript'>
var feedbackMasterArr=["feedbackTypeID","courseType","catogery","feedback","status"];
function editFeedbackMaster(feedbackTypeID){
	$('#feedbackTypeID').val(feedbackTypeID);
	$('#courseType option:contains(' + $(':hidden#'+feedbackTypeID+'courseType').val() + ')').prop({selected: true});
	$('#catogery option:contains(' + $(':hidden#'+feedbackTypeID+'hiddencatogery').val() + ')').prop({selected: true});
	$('input:radio[name=status]').filter('[value='+$(':hidden#'+feedbackTypeID+'status').val()+']').prop('checked', true);
	$('#feedback').val($(':hidden#'+feedbackTypeID+'feedback').val());
	$('#submit').val('Update');
}

function onFeedbackMasterSearchClick(){
	$.ajax({
		type: 'post',
		url: 'searchFeedbackMaster.jspp',
		async: false, 
		success: function (data){
			var feedbackList=jQuery.parseJSON(data);
			var feedbackCount=feedbackList.length;
			if(feedbackCount>0){
				for(var index=0;index<feedbackCount;index++){
					var trStr="<tr>";
					var feedbackObj=feedbackList[index];
					var fdbkCount=feedbackObj.length
					if(fdbkCount>0){
						trStr=trStr.concat("<td><input type='hidden' id='"+feedbackMasterArr[0]+"' value='"+feedbackObj[0]+"'/>"+feedbackObj[0]+"</td>");
					}
					for(var fbIndex=1;fbIndex<fdbkCount;fbIndex++){
						var hiddenID=feedbackObj[0]+feedbackMasterArr[fbIndex];
						trStr=trStr.concat("<td><input type='hidden' id='"+hiddenID+"' value='"+feedbackObj[fbIndex]+"'/>"+feedbackObj[fbIndex]+"</td>");
					}
					trStr=trStr.concat("<td><a href='#' onClick='editFeedbackMaster("+feedbackObj[0]+");'>edit</a></td></tr>");
					$('#tbody').append(trStr);
				}
				var theDropDown = document.querySelector("#show-result");
				theDropDown.classList.remove("collapse");
			}
		}
		});
	}
function validateFields(){
	if($('#submit').val()==='Create'){
		$('#feedbackTypeID').val(0);
	}
}
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
<!--                         <li> <a href="assessmentSchedule.fssai">Update Assessor</a> </li> -->
                        <li> <a href="manageAssessmentQuestions.fssai">Assessment Questions</a> </li>
                        <li> <a href="updateTrainerAssessment.fssai">TOT Assessment</a> </li>
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
                        <cf:form action="saveFeedbackMaster.fssai" name="myForm" method="POST" commandName="feedbackMaster" onsubmit="return validateFields()">
                              <div class="col-xs-12">
 									<h1>Feedback Master</h1>
 									<span class="style-li error-red">${created}<span id="name_status"></span></span>
 									<div class="row">
 									<div class="col-xs-12">
                                            <!-- left side -->
                                            <div class="col-md-6 col-xs-12">
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>User Type:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                   <cf:select id="courseType" path="courseType" class="form-control">
	                                                   <cf:option value="Trainer" label="Trainer" />
	                                                   <cf:option value="Trainee" label="Trainee" />
                                                    </cf:select>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Feedback Category:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                  <cf:select id="catogery" path="catogery" class="form-control">
		                                                   <cf:option value="Trainer" label="Trainer" />
		                                                   <cf:option value="Trainee" label="Trainee" />
                                                    </cf:select>
                                                </div>
                                            </div> <!-- left side ends -->

                                            <!-- right side -->
                                            <div class="col-md-6 col-xs-12">
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Feedback:</strong></li>
                                                            <li class="style-li error-red"></li>
                                                        </ul>
                                                    </div>
                                                   <cf:input id="feedback" path="feedback" class="form-control" />
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div style="padding-top: 35px;">
                                                        
                                                    </div>
                                                    <cf:radiobutton path="status" label="Active"  class="radio-inline"  value="Active"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <cf:radiobutton path="status" label="Inactive"  class="radio-inline"  value="Inactive"/>
                                                </div>
                                                
                                               <div class="row">
                                                
                                                <!-- create button -->
                                                <div class="col-md-6 col-xs-12">
                                                    <br>
                                                    <cf:hidden path="feedbackTypeID" value="${feedbackID}"/>
                                                    <input id="submit" class="btn login-btn" style="width: 100%;" type='submit' value='Create'/>
                                                    <br>
                                                </div>
                                                <!-- show details -->
                                                <div class="col-md-6 col-xs-12">
                                                    <br>
                                                    <a  class="btn login-btn show-details-vacancy collapsed"  href="#" onclick="onFeedbackMasterSearchClick()" style="width: 100%;">Search</a>
                                                    <br>
                                                </div>
                                                </div>
                                                </div>
                                                </div>
                                                    <!-- search Results -->
                                <div class="col-xs-12 collapse" id="show-result" aria-expanded="true" style="height: 0px;">
                                    
                                    <!-- table -->
                                    <div class="row">
                                        <div class="col-xs-12 table-overflow-responsive">
                                            <fieldset>
                                                <legend>Search Result</legend>
                                                
                                                <table class="table table-bordered table-responsive">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>User Type</th>
                                                        <th>Feedback Category</th>
                                                        <th>Feedback</th>
                                                        <th>Status</th>
                                                        <th>Option</th>
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody id="tbody">
                                                </tbody>
                                            </table>
                                            </fieldset>
                                            
                                        </div>
                                    </div>
                                </div> <!-- search div ends -->
                                            </div> <!-- button row ends -->
                                                
                                            </div> <!-- rigth side ends -->
                                            
                                            <!-- button -->
                            
                            <div class="col-md-2 hidden-xs"></div>
                            </cf:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    
    
                                