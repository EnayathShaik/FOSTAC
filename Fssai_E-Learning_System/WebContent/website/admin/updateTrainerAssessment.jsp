<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="website/js/commonController.js"></script>
<style>
.error {
	color: red;
}
</style>

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
function getTrainingCenter(val)
{
	$.ajax({
	      type: 'post',
	      url: 'trainingCenterByCoursenameId.fssai',
	      data:{
	    	  courseNameId: val  
	      },
	      success: function (response) {      
	      var mainData = jQuery.parseJSON(response);
	      $('#trainingCenter option').remove();
	      $('#trainingCenter').append('<option value="0" label="Select Training Center" />');
	  	  $.each(mainData , function(i , obj)
	  		{
	  				$('#trainingCenter').append('<option value='+obj.id+' label='+obj.value+' />');		
	  		});
	      },
	      failure: function(response){
	    	 console.log(response);
	      }
	      });     
}
function showDetails(){
	console.log("Displaying details of the trainees");
	var idCourseName = $('#courseName').val();
	var idTrainingCenter = $('#trainingCenter').val();
	$('#tblAssessorCourses tr').remove();
	$('#tblAssessorCourses').append('<thead>'+
    '<tr class="background-open-vacancies">'+
        '<th>S.No.</th>'+
        '<th>Course Name</th>'+
        '<th>Assessment Date</th>'+
        '<th>Assessment Time</th>'+
        '<th>Attendance</th>'+
        '<th>&nbsp;&nbsp;</th>'+
    '</tr>'+
	'</thead>');
	
	$('#tblTrainerAssessmentEvaluation tr').remove();
    $('#tblTrainerAssessmentEvaluation').append('<thead> <tr class="background-open-vacancies">'+
        '<th>S.No.</th>'+
        '<th>Course Type</th>'+
        '<th>Course Name</th>'+
//         '<th>Training Date</th>'+
        '<th>Training Center</th>'+
        '<th>Trainee Name</th>'+
        '<th>Rating</th>'+
        '<th>&nbsp;</th>'+
    '</tr></thead>');

	$.ajax({
	      type: 'post',
	      url: 'searchTrainerForAssessmentValidation.fssai',
	      data:{
	    	  courseNameId: idCourseName ,
	    	  tpId : idTrainingCenter
	      },
	      success: function (response) {      
	      var mainData = jQuery.parseJSON(response);
	      var optionData = "";
	      
	      for(var j=1; j<=5; j++){
	    	  optionData = optionData+"<option id="+j+" value="+j+">"+j+"</option>";
	      }
	     // $('#tblTrainerAssessmentEvaluation').append('<option value="0" label="Select Training Center" />');
	     var k=1;
	  	  $.each(mainData , function(i , obj)
	  		{
	  				$('#tblTrainerAssessmentEvaluation').append('<tr>'+
	  				'<td>'+(k++)+'</td>'+
	  				'<td>'+obj.courseType+'</td>'+
	  				'<td>'+obj.courseName+'</td>'+
	  				'<td>'+obj.trainingPartnerName+'</td>'+
	  				'<td>'+obj.trainerName+'</td>'+
	  				'<td><select id="rating'+obj.trainerId+'">'+optionData+'</select> </td>'+
	  				'<td><input type="button" onclick = "saveAssessment('+obj.trainerId+','+obj.trainingPartnerId+','+obj.courseNameId+');return false;" value="Update"></button></td>'+
	  				'</tr>');
	  				console.log(obj.trainerId + " - " + obj.trainerName);
	  		});
	      },
	      failure: function(response){
	    	 console.log(response);
	      }
	      });
}

function saveAssessment(trainerId, trainingPartnerId, courseNameId){
	var rating = $('#rating'+trainerId).val();
	console.log("Trainer Id:" + trainerId + " \t CourseId:"+ courseNameId + "\t Training Partner Id - "+trainingPartnerId + "\t Rating - "+rating);
	$.ajax({
		type: 'post',
      url: 'saveTrainerAssessment.fssai',
      data:{
    	  trainerId : trainerId,
    	  courseNameId: courseNameId ,
    	  trainingPartnerId : trainingPartnerId,
    	  rating: rating
      },
      success: function (response) {      
    	  console.log(response);
    	  $('#strResponse').text = response;
      },
      failure: function(response){
    	  console.log(response);
    	  $('#strResponse').text = response;
      }
	});
	
}
</script>
<cf:form name="myForm" commandName="updateTrainerAssessment" >
<!-- 	onsubmit="return validateFields();"> -->
<!-- <section> -->
<!--         <div class="container-fluid"> -->
<!--             <nav class="navbar navbar-default navbar-fixed-top top-logo-background"> -->
<!--                 <div class="container-fluid"> -->
<!--                     <div class="row"> -->
<!--                         <div class="col-xs-6 fostac-logo-left"> -->
<!--                             <a href="index.html"><img src="img/fostac-logo.png" class="img-responsive fostac-logo-top-padding" alt="logo" /></a> -->
<!--                         </div> -->
<!--                         <div class="col-xs-6 fssai-logo-right"> -->
<!--                             <a href="http://www.fssai.gov.in/" target="_blank"><img src="img/fssai-logo.png" class="img-responsive pull-right" alt="logo" /></a> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </nav> -->
<!--         </div> -->
<!--     </section> -->
    <!-- horizontal navigation -->
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
                                            <li><a href="change-password.html">Change Password</a></li>
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
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome  ${userName} </span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="container-fluid">
                            <div class="row">
                                <!-- search and apply vacancies -->
                                <div class="col-xs-12">
                                    <h1>Update Assessment Result For Trainer</h1>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <!-- left side -->
                                            <div class="col-md-6 col-xs-12">
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Type:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>

                                                    <cf:select path="courseType" class="form-control" onchange="getCourseName(this.value , 'courseName');">
														<cf:option value="0" label="Select Course Type"></cf:option>
 														<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/> 
													</cf:select>
                                                </div>
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Name:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                    <cf:select path="courseName" class="form-control" onchange="getTrainingCenter(this.value);">
														<cf:option value="0" label="Select Course Name" />
													</cf:select>
                                                </div>
                                                
                                            </div>
                                            <!-- right side -->
                                            <div class="col-md-6 col-xs-12">
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Training Date</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                    <input type="date" class="form-control" id= "trainingDate"> 
                                                </div>
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Training Center</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                    <cf:select path="trainingCenter" class="form-control">
														<cf:option value="0" label="Select Training Center" />
													</cf:select>
                                                </div>
                                                
                                                <button class="btn btn-default pull-right" onclick="showDetails();return false;">Show Details</button>
                                                
                                            </div>
                                            
                                        </div>
                                        <div class="col-md-3 hidden-xs">
                                        
                                        </div>
                                    </div>
                                </div>
                                <!-- search Results -->
                                
                                 <div style="height: 0px;">
                                        <fieldset style="margin-top: 20px;">
                                        <legend><h4>Search Results</h4></legend>

                                              <!-- table -->
                                        <div class="row">
                                            <div class="col-xs-12">
                                            <span id="strResponse" class="style-li error-red"></span>
                                                <table id = "tblTrainerAssessmentEvaluation" class="table table-bordered table-responsive table-striped table-hover">
                                                    
                                                </table>
                                            </div>
                                        </div>
                                        </fieldset>


                                    </div>
                                    
                                <div class="col-xs-12 collapse" id="show-result" aria-expanded="false" style="height: 0px;">
                                    
                                   <div class="col-xs-12 table-overflow-responsive">
                                    
                                         <fieldset>
                                        <legend>Search Result</legend>
                                         
                                            <table id = "tblTrainerAssessmentEvaluation"  class="table table-bordered table-responsive table-striped table-hover">
<!--                                             <thead> -->
<!--                                                     <tr class="background-open-vacancies"> -->
<!--                                                         <th>S.No.</th> -->
<!--                                                         <th>Course Type</th> -->
<!--                                                         <th>Course Name</th> -->
<!--                                                         <th>Training Date</th> -->
<!--                                                         <th>Training Center</th> -->
<!--                                                         <th>Trainee Name</th> -->
<!--                                                         <th>Rating</th> -->
<!--                                                     </tr> -->
<!--                                                 </thead> -->
                                            </table>
                                            <div> <a href="#" class="btn btn-default pull-right">Save</a> </div>
                                       
                                        
                                    </fieldset>
                                    </div>
                                    <!-- table -->
                                    <div class="row">
                                      
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