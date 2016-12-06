<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function showDetails(){
	$('#tblUpdateResult tr').remove();
	$('#tblUpdateResult').append('<thead>'+
    '<tr class="background-open-vacancies">'+
        '<th>S.No.</th>'+
        '<th>Course Name</th>'+
        '<th>Training Date</th>'+
        '<th>Training Center</th>'+
        '<th>Trainee Name</th>'+
        '<th>Status</th>'+
        '<th>Comments</th>'+
        '<th>&nbsp;</th>'+
    '</tr>'+
	'</thead>');
	var result="";
	//var id = document.getElementById("assessmentAgencyId").value;
	var assessorId =710;
	$.ajax({
	type: 'post',
	url: 'searchAssessorTraineesForResults.jspp',
	async: false, 
	success: function (data){
		console.log("Data received..");
		console.log(data);
	var jsonData = jQuery.parseJSON(data);
	console.log(jsonData);
	var j=1;
// 	var accessorId;
	$.each(jsonData , function(i , obj)
	{
		var recId = obj[8];
		$('#tblUpdateResult').append('<tr id="tableRow"><td>'+j++ +'</td>'+
				'<td>'+obj[4]+'</td>'+
				'<td>'+obj[2]+'</td>'+
				'<td>'+obj[5]+'</td>'+
				'<td>'+obj[7]+'</td>'+
				'<td><select id=traineeRes'+obj[8]+'><option  value ="P">Pass</option>'+
				'<option  value="F">Fail</option></td>'+
				'<td><input type="text" class="form-control" id = "comments'+obj[8]+'"/>'+
				'<td> <button onclick="updateAssessmentResult('+obj[0]+','+obj[1]+','+obj[8]+');return false;">Update</button></td>'+
				'</tr>');
		console.log("0-"+obj[0] +" #1-" +obj[1] +" #2-" +obj[2] +" #3-"+obj[3] +" #4-"+obj[4]+" #5-"+obj[5]+" #6-"+obj[6]+" #7-"+obj[7]+" #8-"+obj[8]);
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

function updateAssessmentResult(assessorId,trainingcalId, traineeId){
	var comments = document.getElementById("comments"+traineeId).value;
	var resultValue = document.getElementById("traineeRes"+traineeId).value;
	
	$.ajax({
		type: 'post',
		url: 'updateAssessmentResult.jspp',
		data:{
			assessorId: assessorId,
			trainingcalId:trainingcalId,
			traineeId : traineeId,
			comments : comments,
			result : resultValue
		},
		async: false, 
		success: function (data){
			console.log("Data received..");
			console.log(data);
			$( '#resultResponse' ).html(data);
// 			 <li class="style-li error-red">${created}<span id="name_status"></span></li>
		},
		failure: function(data){
			alert ("failure:" + data);
			}
});
}
</script>

<cf:form name="myForm" commandName="markAttendance" >
        <section>
        	<div>
        		<%@include file="topMenuAssessor.jspf" %>
            </div>
        </section>

        <!-- main body -->
        <section class="main-section-margin-top">
            <div class="container-fluid">
                <div id="wrapper">

                    <!-- Sidebar -->
                    <%@include file="leftMenuAssessor.jspf" %>
                    <!-- /#sidebar-wrapper -->
                    <!-- Page Content -->
                    <div id="page-content-wrapper">
                        <div class="container-fluid">

                            <!-- vertical button -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle">
                                        <i class="fa fa-bars"></i> <span class="orange-font">Welcome Training Partner</span>
                                    </a>
                                </div>
                            </div>
							 <!-- add the content here for main body --> 
              <!-- timeline  -->
              <div class="container-fluid">
            <div class="row"> 
                   <script type="text/javascript">
                     var formObj = '${updateResult}';
                     var formData = JSON.parse(formObj);
                     var courseTypes = formData.courseType;
                     var trainingCenters = formData.trainingCenters;
                   </script>
                  <!-- search and apply vacancies -->
                  <div class="col-xs-12">
                      <fieldset>
                      <legend><h3>Update Result</h3></legend>
                           <div class="row">
                      <div class="col-xs-12"> 
                    
                    <!-- left side -->
                    <div class="col-md-6 col-xs-12">
                          <div class="form-group">
                        <div>
                              <ul class="lab-no">
                            <li class="style-li"><strong>Course Name:</strong></li>
                            
                          </ul>
                            </div>
                            <select class="form-control" name="selCourseType" id = "selCourseType"> </select>
								<script>
									var selectOptions = "";
									for(var i=0 ; i < courseTypes.length; i++)
										{
											console.log(courseTypes[i].CourseTypeId + " -- "+ courseTypes[i].CourseType);
											selectOptions += "<option value="+courseTypes[i].CourseTypeId+">"+courseTypes[i].CourseType+"</option>"
											
										}
									document.getElementById('selCourseType').innerHTML += selectOptions; 
							</script>
                      </div>
                          <div class="form-group">
                        <div>
                              <ul class="lab-no">
                            <li class="style-li"><strong>Training Date</strong></li>
                            <li class="style-li error-red"> </li>
                          </ul>
                            </div>
                        <input type="date" class="form-control">
                      </div>
                        </div>
                    
                    <!-- right side -->
                    
                    <div class="col-md-6 col-xs-12">
                          <div class="form-group">
                        <div>
                              <ul class="lab-no">
                            <li class="style-li"><strong>Training Center</strong></li>
                            <li class="style-li error-red"> </li>
                          </ul>
                            </div>
                         <select class="form-control" name="selTrainingCenters" id = "selTrainingCenters"> </select>
							<script>
								var selectTc = "";
								for(var i=0 ; i < trainingCenters.length; i++)
									{
										console.log(trainingCenters[i].id + " -- "+ trainingCenters[i].value);
										selectTc += "<option value="+trainingCenters[i].id+">"+trainingCenters[i].value+"</option>"
										
									}
							document.getElementById('selTrainingCenters').innerHTML += selectTc; 
						</script>
                      </div>
                      <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onClick="showDetails();return false;">Show Details</button>
                        </div>
                    
                  </div>
                      <div class="col-md-3 hidden-xs"></div>
                    </div>
                      </fieldset>
                
               
              </div>

                                    <!-- search Results -->
                                    <div class="col-xs-12 collapse table-overflow-responsive" id="show-result" aria-expanded="false" style="height: 0px;">
                                        <fieldset style="margin-top: 20px;">
                                        <legend><h4>Search Results</h4></legend>

                                              <!-- table -->
                                        <div class="row">
                                            <div class="col-xs-12">
<%--                                             	<li class="style-li error-red">${created}<span id="name_status"></span></li> --%>
												<span id="resultResponse" class = "style-li error-red">
												</span>
                                                <table id = "tblUpdateResult" class="table table-bordered table-responsive table-striped table-hover">
                                                    
                                                </table>
                                            </div>
                                        </div>
                                        </fieldset>


                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
</cf:form>