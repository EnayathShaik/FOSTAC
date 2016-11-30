<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function getCourseName(val)
{
	$.ajax({
	      type: 'post',
	      url: 'loadCourseName.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      alert(mainData1);
	      $('#courseName option').remove();
	      $('#courseName').append('<option value="0" label="Select Course name" />')
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  				$('#courseName').append('<option value='+obj[0]+'>'+obj[1]+'</option>');		
	  		});
	      }
	      });     
}
</script>
<script>
function getTrainingCenter(val)
{
	$.ajax({
	      type: 'post',
	      url: 'loadTrainingCenter.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	        //alert(mainData1);
	      $('#trainingCenter option').remove();
	      $('#trainingCenter').append('<option value="0" label="Select Training Center" />');
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  		
	  				$('#trainingCenter').append('<option value='+obj[0]+' label='+obj[1]+' />');		
	  		});
	      }
	      });     
}
</script>
<script>
function getTrainingCalender(){
	var courseType = $("#courseType").val();
	var courseName = $("#courseName").val();
	var trainingPartner = $("#trainingPartner").val();
	var trainingCenter = $("#trainingCenter").val();
	var trainingDate = $("#trainingDate").val();
	var trainingTime = $("#trainingTime").val();
	var trainerName = $("#trainerName").val();
	var trainingType = $("#trainingType").val();
	var total ="courseType="+courseType+"&courseName="+courseName+"&trainingPartner="+trainingPartner+ 
	"&trainingCenter="+trainingCenter+"&trainingDate="+trainingDate+"&trainingTime="+trainingTime+
	"&trainerName="+trainerName+"&trainingType="+trainingType;
	$.ajax({
	      type: 'post',
	      url: 'getTrainingCalender.jspp?'+ total,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      alert(mainData1);
	      var j = 1;
	      $('#newTable tr').remove();
	      $('#newTable').append('<tr class="background-open-vacancies"><td>S.No.</td><td>Training Type</td><td>Course Type</td><td>Course Name</td><td>Training Partner Name</td><td>Training Center name</td><td>Training Date</td><td>Training Time</td><td>Trainer Name</td><tr>')
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  				$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[9]+'</td><td>'+obj[4]+'</td><td>'+obj[3]+'</td><td>'+obj[1]+'</td><td>'+obj[10]+'</td><td>'+obj[5]+'</td><td>'+obj[6]+'</td><td>'+obj[2]+'</td><tr>');		
	  		});
	      }
	      });  
	$('#newTable').show();
	return result;
}
</script>
<cf:form action="trainingCalenderSave.fssai" name="myForm" method="POST" commandName="trainingCalendarForm" > 


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
                <div> <%@include file="leftMenuAdmin.jspf" %>
                </div>
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
                        <div class="container-fluid">
                            <div class="row">
                                <!-- search and apply vacancies -->
                                <div class="col-xs-12">
                                    <fieldset>
                                        <legend>Training Calendar</legend>
                                        <!-- left side -->
                                        <div class="col-md-6 col-xs-12">
                                           
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Course Type:</strong></li>
                                                        <li class="style-li error-red">${created}</li>
                                                    </ul>
                                                </div>
<cf:select path="courseType" class="form-control" onchange="getCourseName(this.value);">
<cf:option value="0" label="Select Course Type"></cf:option>
<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/>
</cf:select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Course Name:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
<cf:select path="courseName" class="form-control">
<cf:option value="0" label="Select Course Name" />
</cf:select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training Partner:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
<cf:select path="trainingPartner" class="form-control" onchange="getTrainingCenter(this.value);">
<cf:option value="0" label="Select Training Partner"></cf:option>
<cf:options items="${trainingPartnerList}" itemValue="manageTrainingPartnerId" itemLabel="trainingPartnerName"/>

</cf:select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training Center:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
<cf:select path="trainingCenter" class="form-control">
<cf:option value="0" label="Select Training Center" />
</cf:select>
                                            </div>
                                            
                                        </div>
                                        
                                        <!-- right side -->
                                        <div class="col-md-6 col-xs-12">
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training Date:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
                                                <cf:input path="trainingDate" type="date" class="form-control" required="required" />
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training Time</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
                                                <cf:input path="trainingTime" type="time" class="form-control" required="required" />
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Trainer Name:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
<cf:select path="trainerName" class="form-control">
<cf:option value="0" label="Select Trainer" />
<cf:options items="${trainingNameList}" itemValue="personalInformationTrainerId" itemLabel="FirstName"/>
</cf:select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training Type:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
<cf:select path="trainingType" class="form-control">
<cf:option value="Trainer"  label="Trainer"/>
<cf:option value="Trainee" label="Trainee" />
</cf:select>
                                            </div>
                                            
                                        </div>
<input type="submit"  class="form-control login-btn" value="Create" style="width: 200px;
    margin-left: 13px;" />  
                                          
<a href="#" onclick="getTrainingCalender();" class="btn btn-default pull-right show-details-vacancy collapsed" style="margin-top: -36px;
    margin-right: 15px; background:#ef580d" data-toggle="collapse" data-target="#show-result"
     aria-expanded="false">Show Calendar</a>
                                       
                                    </fieldset>
                                    
                                </div>
                                
                                <!-- search Results -->
                                <div id="testt" class="displayNone" aria-expanded="false">
                                    <h1>Search Results</h1>
                                    <!-- table -->
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <table id="newTable" class="table table-bordered table-responsive table-striped table-hover">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>Training Type</th>
                                                        <th>Course Type</th>
                                                        <th>Course Name</th>
                                                        <th>Training Partner Name</th>
                                                        <th>Training Center name</th>
                                                        <th>Training Date</th>
                                                        <th>Training Time</th>
                                                        <th>Trainer Name</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                   
                                                </tbody>
                                            </table>
                                        </div> <!-- col-xs-12 -->
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    </cf:form>