<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="website/js/commonController.js"></script>
<script>
function saveAssesmentCalender(i,courseType,courseName,trainer,traininingCalandar){
	var assessor =  $('#assRow'+traininingCalandar).val();
	var assmntDate = $('#assesmentdate'+i).val();
	var assmntTime = $('#assesmenttime'+i).val();
	alert(assmntDate)
	alert(assmntTime)
	if(assmntDate == null || assmntDate == ""){
		alert('Please Select Assessment date');
		return false;
	}
	if(assmntTime == null || assmntTime == ""){
		alert('Please Select Assessment time');
		return false;
	}
	if(assessor <= 0){
		alert('Please Select Assessor');
		return false;
	}
	
	var total = courseType+'&'+courseName+'&'+trainer+'&'+assmntDate+'&'+assmntTime+'&'+traininingCalandar+'&'+assessor;
	var result="";
		$.ajax({
		type: 'post',
		url: 'saveAssementCalender.jspp?'+ total,
		async: false, 
		success: function (data){
		var mainData1 = jQuery.parseJSON(data);
		alert('Result : '+mainData1);
		}
		});
	
}


</script>
<script>
/* function showDetails(){
	alert("Fetching details to mark attendance..");
	alert('hiee');
	$('#tblAssessorCourses tr').remove();
	$('#tblAssessorCourses').append('<thead>'+
    '<tr class="background-open-vacancies">'+
        '<th>S.No.</th>'+
        '<th>Course Type</th>'+
        '<th>Course Code</th>'+
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
	url: 'trainingpartnerassessmentcalendar.jspp?'+assessorId,
	async: false, 
	success: function (data){
		console.log("Data received..");
		console.log(data);
	var jsonData = jQuery.parseJSON(data);
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
 */
 
function showDetails(){
	 	var courseType =  ($("#selCourseType").val()==null ? "" : $("#selCourseType").val());
		var courseName =  ($("#selCourseName").val() == null ? "" : $("#selCourseName").val());
		var TrainerNames = ( $("#selTrainerNames").val() == null ? "" :$("#selTrainerNames").val() ); 
		var assesmentDate = ($('#assessmentDate').val() == null ? "" :$('#assessmentDate').val() );
		var assesmentTime = ($('#assessmentTime').val() == null ? "" : $('#assessmentTime').val());
	
		$(".displayNone").css("display","block");
		var total = "courseType="+courseType+"&-courseName="+courseName+"-trainingDate="+trainingDate+"-requiredExp="+requiredExp+"-noOfVacancy="+noOfVacancy;
		var total = "";
		var result="";
		var name1=JSON.stringify({
			courseType:0
	  })
			$.ajax({
			type: 'post',
			url: 'traineeAssessmentCalender.fssai?data='+ total,
			 contentType : "application/json",
			 data:name1,
			async: false, 
			success: function (data){
			$('#newTable').show();
			var mainData1 = jQuery.parseJSON(data);
			var j=1;
			$('#newTable tr').remove();
			$.each(mainData1 , function(i , obj)
			{
				$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[0]+'</td><td>'+obj[1]+'</td><td><input id="assesmentdate'+i+'" value='+obj[3]+' type="date"/></td><td><input id="assesmenttime'+i+'" value='+obj[4]+' type="time"/></td><td>'+obj[5]+'</td>'+
						'<td><select id =assRow'+obj[6]+'><option value="0">Select Assessor</option>'+
						'</td>'+
						'<td><a href="#" onClick="saveAssesmentCalender('+i+',\''+obj[0]+'\',\''+obj[1]+'\',\''+obj[2]+'\',\''+obj[6]+'\');">Save</a> </td></tr>');
				for(var i=0 ; i < assessorList.length; i++){
					//$('#assRow'+obj[6]+').append('<option value='+obj.districtId+'>'+obj.districtName+' </option>');
					if(obj[7]==assessorList[i].id){
						$('#assRow'+obj[6]+'').append('<option selected="true"  value ='+assessorList[i].id+'>'+assessorList[i].value+'</option>');
					}else{
						$('#assRow'+obj[6]+'').append('<option value ='+assessorList[i].id+'>'+assessorList[i].value+'</option>');
					}
					
				
				}   
			});
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
         <%@include file="../roles/slider.jsp" %>
                    <!-- /#sidebar-wrapper -->
                    <!-- Page Content -->
                    <div id="page-content-wrapper">
                        <div class="container-fluid">

                            <!-- vertical button -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle">
                                        <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName }</span>
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
                                        <legend><h3>Assesment Calendar</h3></legend>
                                        <script type="text/javascript">
                                        var formObj = '${trainingpartnerassessmentcalendar}';
                                        var formData = JSON.parse(formObj);
                                        var courseTypes = formData.courseTypes;
                                        var trainerList = formData.trainerList;
                                        var assessorList = formData.assessorList;
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
                                                        <select class="form-control"  onchange="getCourseName(this.value , 'selCourseName');"  name="selCourseType" id = "selCourseType"> </select>
														<script>
															var selectctpeOptions = "<option disabled selected value> -- select courseType -- </option>";
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
                                                                <li class="style-li"><strong>Course Code:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="selCourseName" id = "selCourseName"> </select>
                                                    </div>
                                                                      
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Trainer Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="selTrainerNames" id = "selTrainerNames"> </select>
														<script>
															var selectTrainerOptions = "";
															selectTrainerOptions += "<option value='0'>Please Select</option>"
															for(var i=0 ; i < trainerList.length; i++)
																{
																	selectTrainerOptions += "<option value="+trainerList[i].id+">"+trainerList[i].value+"</option>"
																	
																}
															document.getElementById('selTrainerNames').innerHTML += selectTrainerOptions; 
														</script>
														
                                                    </div>

                                                </div>

                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                 
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Assessment Date:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="date" class="form-control" id="assessmentDate" name="assessmentDate">
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Assessment Time</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="time" class="form-control" id="assessmentTime" name="assessmentTime">
                                                    </div>
                                                     <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="showDetails();return false">Show Details</button>
                                              <!--    <input type="button" id="btnExport" style="margin-right: 20px;"  class="btn login-btn pull-right" value="Download" /> -->
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
                      <table class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No.</th>
                            <th>Course Type</th>
                            <th>Course Code</th>
                            <th>Assessment Date</th>
                            <th>Assessment Time</th>
                            <th>Trainer Name</th>
                            <th>Assessor</th>
                             <th>Save</th>
                          </tr>
                        </thead>
                        <tbody id="newTable">
                        </tbody>
                      </table>
                      </div>
                      <a href="#" class="btn login-btn pull-right">Save</a>
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
        </section>
</cf:form>