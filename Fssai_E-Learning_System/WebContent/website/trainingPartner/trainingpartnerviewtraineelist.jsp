<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function getCourseName(val){
	 $('#selCourseName option').remove();
	$.ajax({
	      type: 'post',
	      url: 'getCourseName.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	       $('#selCourseName option').remove();
	      $('#selCourseName').append('<option value="0" label="--Select Course Name--" />');
	        $.each(mainData1 , function(i , obj)
	  		{
	  				$('#selCourseName').append('<option value='+obj[0]+' >'+obj[1]+'</option>');		
	  		});
	      }
	      });
}

</script>
<script>

function showDetails(){
	/* alert('Hoiee');
	alert('Data......'); */
	var courseType =  $("#selCourseType").val();
	var courseName =  $("#selCourseName").val();
	var trainingDate = $("#traineeDate").val();/* .replace("-","/").replace("-","/"); */
	var trainingTime =  $("#traineeTime").val();
	
 	var total = courseType+"&"+courseName+"&"+trainingDate+"&"+trainingTime;
	
	/* alert("total "+total); */
	$(".displayNone").css("display","block");
	var result="";
	$.ajax({
		type: 'POST',
		url: 'traineeCenterViewTraineeList.jspp?'+ total,
		async: false, 
		success: function (data){
		$('#newTable').show();
		//var mainData = JSON.stringify(data);
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[0]+'</td><td>'+obj[1]+'</td><td>'+obj[2]+'</td><td>'+obj[3]+'</td><td>'+obj[4]+'</td><td>'+obj[5]+'</td><td>Pending</td></tr>');
			
		});
		}
		});
	return result; 
}

function showDetail(){
	alert("Fetching details to mark attendance..");
	
	$('#tblAssessorCourses tr').remove();
	$('#tblAssessorCourses').append('<thead>'+
    '<tr class="background-open-vacancies">'+
        '<th>S.No.</th>'+
        '<th>Course Type</th>'+
        '<th>Course Name</th>'+
        '<th>Training Date</th>'+
        '<th>Training Time</th>'+
        '<th>Trainer Name</th>'+
        '<th>&nbsp;&nbsp;</th>'+
    '</tr>'+
	'</thead>');
	var result="";
	//var id = document.getElementById("assessmentAgencyId").value;
	var assessorId =710;
	$.ajax({
	type: 'post',
	url: 'trainingpartnerviewtraineelist.jspp?'+assessorId,
	async: false, 
	success: function (data){
		console.log("Data received..");
		console.log(data);
	var jsonData = jQuery.parseJSON(data);
	alert(jsonData)
	console.log(jsonData);
	var j=1;
	var accessorId;
	$.each(jsonData , function(i , obj)
	{
		$('#tblAssessorCourses').append('<tr id="tableRow"><td>'+j++ +'</td>'+
				'<td>'+obj[3]+'</td>'+
				'<td>'+obj[4]+'</td>'+
				'<td>'+obj[5]+'</td>'+
				'<td><select name =attendanceRow'+obj[1]+'><option name="present" value ="A">Present</option>'+
				'<option name="absent" value="I">Absent</option></td>'+
				'<td> <button onclick="updateAttendance('+obj[0]+','+obj[1]+');return false;">Update</button></td>'+
				'</tr>');
		console.log("0-"+obj[0] +" #1-" +obj[1] +" #2-" +obj[2] +" #3-"+obj[3] +" #4-"+obj[4]+" #5-"+obj[5]);
		currentAssessorId = obj[0];
	});
	
	},
	failure:function(data){
		alert("Error occured while retrieving upcoming calendars.");
	 msgbox('Error occured while retrieving upcoming calendars.');
	}
	});
return result;	
}


</script>
<section>
  
 <%@include file="../roles/top-menu.jsp"%>
</section>
<cf:form name="myForm" commandName="trainingPartnerTrainingCalender" >
        <!-- main body -->
        <section class="main-section-margin-top">
            <div class="container-fluid">
                <div id="wrapper">

                    <!-- Sidebar -->
                      <!-- Sidebar -->
<%@include file="../roles/slider.jsp" %>
                    <!-- /#sidebar-wrapper -->
                    <!-- Page Content -->
                    <div id="page-content-wrapper">
                        <div class="container-fluid">

                            <!-- vertical button -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle">
                                        <i class="fa fa-bars"></i> <span class="orange-font">Welcome : ${loginUser.loginDetails.loginId}</span>
                                    </a>
                                </div>
                            </div>

                            <!-- add the content here for main body -->
                            <!-- timeline  -->
                            <div class="container-fluid">
                                <div class="row">

                                    <!-- search and apply vacancies -->
                                    <div class="col-xs-12">
                                        <fieldset>
                                        <legend><h3>View Trainee List</h3></legend>
                                        <script type="text/javascript">
                                        var formObj = '${trainingpartnerviewtraineelist}';
                                        var formData = JSON.parse(formObj);
                                        var courseTypes = formData.courseTypes;
                                        var trainerList = formData.trainerList;
                                        var statusList = formData.statusList;
                                        var modeOfTrainingList = formData.modeOfTrainingList;
                                        </script>
                                        
                                        <div class="row">
                                            <div class="col-xs-12">

                                                <!-- left side -->
                                                <div class="col-md-6 col-xs-12">
                                                     <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Course Type:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" onchange="getCourseName(this.value);"  name="selCourseType" id = "selCourseType"> </select>
														<script>
															var selectctpeOptions =  "<option disabled selected value> -- select courseType -- </option>";
															for(var i=0 ; i < courseTypes.length; i++)
																{
																	console.log(courseTypes[i].CourseTypeId + " -- "+ courseTypes[i].CourseType);
																	selectctpeOptions += "<option value="+courseTypes[i].CourseTypeId+">"+courseTypes[i].CourseType+"</option>"
																	
																}
															document.getElementById('selCourseType').innerHTML += selectctpeOptions; 
														</script>
														
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Course Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="selCourseName" id = "selCourseName"> </select>
                                                    </div>
                                                   
                                                     
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Date:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="date" class="form-control" id="traineeDate">
                                                    </div>

                                                </div>

                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Time</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="time" class="form-control" id="traineeTime">
                                                    </div>
                                                                                
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Status:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="selTraineeStatus" id = "selTraineeStatus"> </select>
														<script>
															var selTraineeStatusOptions = "";
															for(var i=0 ; i < statusList.length; i++)
																{
																	console.log(statusList[i].id + " -- "+ statusList[i].value);
																	selTraineeStatusOptions += "<option value="+statusList[i].id+">"+statusList[i].value+"</option>"
																	
																}
															document.getElementById('selTraineeStatus').innerHTML += selTraineeStatusOptions; 
														</script>
														
                                                    </div>
                                                       <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Mode of Training:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="selTraineeModeOfTraining" id = "selTraineeModeOfTraining"> </select>
														<script>
															var selTraineeModeOfTrainingOptions = "";
															for(var i=0 ; i < modeOfTrainingList.length; i++)
																{
																	console.log(modeOfTrainingList[i].id + " -- "+ modeOfTrainingList[i].value);
																	selTraineeModeOfTrainingOptions += "<option value="+modeOfTrainingList[i].id+">"+modeOfTrainingList[i].value+"</option>"
																	
																}
															document.getElementById('selTraineeModeOfTraining').innerHTML += selTraineeModeOfTrainingOptions; 
														</script>
														
                                                    </div>
                                                     <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="showDetails();return false">Show Details</button>
                                                		<input type="button" id="btnExport" style="margin-right: 20px;"  class="btn login-btn pull-right" value="Download" />
                                                		
                                                		<!-- <a href="#testt" class="pull-right" onclick="showDetails();">Search</a> -->
                                                </div>
                                               
                                            </div>

                                            <div class="col-md-3 hidden-xs"></div>
                                        </div>
                                        </fieldset>


                                    </div>

                                    <!-- search Results -->
                        <!-- search Results -->
              <div class="col-xs-12 collapse table-overflow-responsive" id="show-result" aria-expanded="false" style="height: 0px;"> 
                <!-- table -->
                <div class="row">
                  <div class="col-xs-12">
                    <fieldset style="margin-top: 20px;">
                      <legend>
                      <h4>Search results</h4>
                      </legend>
                      <div id="dvData">
                      <table  class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No.</th>
                            <th>Course Type</th>
                            <th>Course Name</th>
                            <th>Training Date</th>
                            <th>Training Time</th>
                            <th>Participant Name</th>
                            <th>Mode OF Training</th>
                            <th>Status</th>
                          </tr>
                        </thead>
                        <tbody id="newTable">
                        </tbody>
                      </table>
                      </div>
                      <!-- <a href="#" class="btn login-btn pull-right">Save</a> -->
                    </fieldset>
                    <div style="width: 95px;">
                      <ul class="pager">
                       
                      </ul>
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
</cf:form>