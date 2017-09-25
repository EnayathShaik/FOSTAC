<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="website/js/commonController.js"></script>
<script>
function OnStart(){

	 window.profileId = ${profileId};
	$("#trainingPartner").val('${profileId}');
	

	
	if(window.profileId == 6 ){
		
		document.getElementById('btnCreate').style.display = 'none';
	
	}
	
	
	
	if(window.profileId == 5 ){
		
		document.getElementById('trainingPart').style.display = 'none';
		document.getElementById('trainingCent').style.display = 'none';
	
	}
	
	
	
	 window.trainingEndDate =   flatpickr('[name="trainingEndDate"]' , {
		enableTime: true
	});
	
	 window.trainingStartDate =   flatpickr('[name="trainingStartDate"]' , {
		enableTime: true
	});

	
	 window.assessmentDateTime =   flatpickr('[name="assessmentDateTime"]' , {
		enableTime: true
	});
}


function editTrainingCalendar( srNo , id, courseType){

	var tcid = i;
	
	$("#selCourseType").val($("#selCourseType"+srNo).val());
	
	  $("#selCourseType").trigger("change");
	  window.setTimeout(function() {
          $('#selCourseName').val($("#selCourseName"+srNo).val());
      }, 2000);
	
	$("#selCourseName").val($("#selCourseName"+srNo).val());
	$("#selTrainerNames").val($("#selTrainerNames"+srNo).val());
	$("#trainingStartDate").val($("#trainingStartDate"+srNo).text());
	$("#trainingEndDate").val($("#trainingEndDate"+srNo).text());
	console.log("datetime "+$("#assessmentDateTime"+srNo).text());
	
	$("#assessmentDateTime").val($("#assessmentDateTime"+srNo).text());
	console.log("agency name "+$("#assessmentAgencyname"+srNo).val());
	
	$("#assessmentAgencyName").val($("#assessmentAgencyname"+srNo).val());
	
	$("#assessmentAgencyName").trigger("change");
	  window.setTimeout(function() {
          $('#assessorName').val($("#assessorName"+srNo).val());
      }, 2000);

	$("#seatCapacity").val($("#seatCapacity"+srNo).text());
	$("#type").val($("#type"+srNo).val());
	
	
	document.getElementById('btnUpdate').style.display = 'block';
	document.getElementById('btnCreate').style.display = 'none';
	$("#tcid").val(id);	
	
	
	
	if(window.profileId == 6){
		
		window.trainingStartDate.destroy();
		window.trainingEndDate.destroy();
		
		
		$("#selCourseType").attr('readonly',true);
		$("#selCourseName").attr('readonly',true);
		$("#selTrainerNames").attr('readonly',true);
		$("#trainingStartDate").attr('readonly',true);
		$("#trainingEndDate").attr('readonly',true);
		$("#assessmentAgencyName").attr('readonly',true);
		$("#assessorName").attr('readonly',true);
		$("#seatCapacity").attr('readonly',true);
		$("#type").attr('readonly' , true);
		
			 
		$("#trainingStartDate").val($("#trainingStartDate"+srNo).text());
		$("#trainingEndDate").val($("#trainingEndDate"+srNo).text());
		
		$("#btnUpdate1").css("display" , "block");
		$("#btnUpdate").css("display" , "none");
	}
}
window.onload = OnStart;
</script>
<script>
	function updateTrainingCalendar() {
		
		var assessmentDateTime = (($("#assessmentDateTime").val() == 'undefined' || $("#assessmentDateTime").val() == null ) ? "" : $("#assessmentDateTime").val() );
		var tcid = $("#tcid").val();
		alert(" assessmentDateTime "+assessmentDateTime + " tcid "+tcid);
		
		var total =  "assessmentDateTime="+assessmentDateTime+"@tcid="+tcid;
		var name1=JSON.stringify({
			courseType:0
	  })
	 	$.ajax({
			type: 'post',
			url: 'updateTrainingCalendar.fssai?data='+ total,
			      contentType : "application/json",
				  data:name1,
			      success: function (response) {
			    	  alert(response);
			       $( '#name_status' ).html(response);
			      }
			      });
	}
	
	


	function showDetails() {
		$(".displayNone").css("display", "block");
		var courseType = ($("#selCourseType").val()== 0 ||  $("#selCourseType").val() == null ? "" : $("#selCourseType").val());
		var courseName =  ($("#selCourseName").val() == 0 || $("#selCourseName").val() == null ? "" : $("#selCourseName").val());
		var trainingStartDate = (($("#trainingStartDate").val() == 'undefined' || $("#trainingStartDate").val() == null ) ? "" : $("#trainingStartDate").val() );
		var trainerName = ($("#selTrainerNames").val() == 0 || $("#selTrainerNames").val() == null ? "" : $("#selTrainerNames").val());
		var trainingEndDate = (($("#trainingEndDate").val() == 'undefined' || $("#trainingEndDate").val() == null ) ? "" : $("#trainingEndDate").val() );
		var assessmentDateTime = (($("#assessmentDateTime").val() == 'undefined' || $("#assessmentDateTime").val() == null ) ? "" : $("#assessmentDateTime").val() );
		var assessmentAgencyName = ($("#assessmentAgencyName").val()== 0 ||  $("#assessmentAgencyName").val() == null ? "" : $("#assessmentAgencyName").val());
		var assessorName = ($("#assessorName").val()== 0 ||  $("#assessorName").val() == null ? "" : $("#assessorName").val());
		var seatCapacity = ($("#seatCapacity").val()== 0 ||  $("#seatCapacity").val() == null ? "" : $("#seatCapacity").val());
		//var total = "courseType="+courseType + "&courseName=" + courseName+ "&trainingStartDate=" + trainingStartDate + "&trainingEndDate="+ trainingEndDate+"&trainerName="+trainerName+"&assessmentDateTime="+assessmentDateTime+"&assessmentAgencyName="+assessmentAgencyName+"&assessorName="+assessorName+"&seatCapacity="+seatCapacity;
		var total = courseType + "@" + courseName+ "@" + trainingStartDate + "@"+ trainingEndDate+"@"+trainerName+"@"+assessmentDateTime+"@"+assessmentAgencyName+"@"+assessorName+"@"+seatCapacity+"@"+window.profileId;
		var result = "";
		var name1=JSON.stringify({
			courseName:0
	  })
		$.ajax({
			type : 'post',
			url : 'traineeCenterViewTrainee.fssai?data=' + total,
			 contentType : "application/json",
			  data:name1,
			async : false,
			success : function(data) {
				$('#newTableT').show();
				var mainData1 = jQuery.parseJSON(data);
				var j = 1;
				$('#newTableT tr').remove();
				$.each(mainData1, function(i, obj) {
					$('#newTableT').append(
							'<tr id="tableRow"><td><input id='+obj[0]+' type="hidden"/>' + j++ 
										
									+ '</td><td><input type="hidden" value='+obj[6]+' id=selCourseType'+i+' />'
									+ obj[1] + '</td><td> <input type="hidden" value='+obj[7]+' id=selCourseName'+i+' />' + obj[2]
									+ '</td><td id=trainingStartDate'+i+'>' + obj[3] + '</td><td id=trainingEndDate'+i+'>'+ obj[4] 
									+'</td><td id=assessmentDateTime'+i+'>' + obj[9]	
									+'</td><td><input type="hidden" value='+obj[10]+'  id=assessmentAgencyname'+i+' />' + obj[11]	
									+'</td><td><input type="hidden" value='+obj[12]+'  id=assessorName'+i+' />' + obj[13]	
									+'</td><td><input type="hidden" value='+obj[8]+'  id=selTrainerNames'+i+' />' + obj[5]	
									+'</td><td id=seatCapacity'+i+'>' + obj[14]
									+'</td><td><input type="hidden" value='+obj[16]+'  id=type'+i+' />' + obj[15]
									+ '</td><td class="TPEdit"><input type="button" id="TP"  onClick="editTrainingCalendar(\''+i+'\',\''+obj[0]+'\',\''+obj[1]+'\');" value="Reschedule"/></td><td> <input type="submit"  onclick=" return setId('+obj[0]+')" value="Cancel Training"/> </td></tr>');

				});
			}
		}); 
		

		
		if(window.profileId == 7){
			
			$(".TPEdit").css("display" , "none");
			//$(".TPEdit").attr('disabled' , true);
			
		
		}
		return result;
		
		
		
		
	}
	
	function setId(id){
		//alert("id "+id);
		$("#tcid").val(id);	
		$("#trainingPartnerCalendarForm").attr("action" , "trainingCalendarRemove.fssai");
		
	}
</script>
<section>
	
 <%@include file="../roles/top-menu.jsp"%>
</section>
<cf:form id="trainingPartnerCalendarForm" name="myForm"
	action="trainingCenterCalenderSave.fssai"
	commandName="trainingPartnerCalendarForm">
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
								<a href="#menu-toggle" class="vertical-menu-position-btn"
									id="menu-toggle"> <i class="fa fa-bars"></i> <span
									class="orange-font">Welcome :
										${userName}</span>
										
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
										<legend>
										
											<h3>Training Calendar</h3>
										</legend>
										<script type="text/javascript">
											var formObj = '${trainingPartnerTrainingCalender}';
											var formData = JSON.parse(formObj);
											var courseTypes = formData.courseTypes;
											var trainerList = formData.trainerList;
											var assessmentAgencyNameList = formData.assessmentAgencyName;
											var trainingPartnerList = formData.trainingPartnerList;
											
										</script>

										<div class="row">
											<div class="col-xs-12">

												<!-- left side -->
												<div class="col-md-6 col-xs-12">
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Course Type:</strong></li>
																 <li class="style-li error-red">*</li>
																 <li id="courseTypeError" style="display:none;" class="style-li error-red" >Please Select Course Type.</li>
																<span id="name_status"> ${created } </span>
															</ul>
														</div>
														<select path="selCourseType" class="form-control"
															onchange="getCourseName(this.value , 'selCourseName');"
															name="selCourseType" id="selCourseType">
														</select>
														<script>
															var selectctpeOptions = "<option disabled selected value='0'> -- select courseType -- </option>";
															for ( var i = 0; i < courseTypes.length; i++) {
																console
																		.log(courseTypes[i].CourseTypeId
																				+ " -- "
																				+ courseTypes[i].CourseType);
																selectctpeOptions += "<option value="+courseTypes[i].CourseTypeId+">"
																		+ courseTypes[i].CourseType
																		+ "</option>"

															}
															document
																	.getElementById('selCourseType').innerHTML += selectctpeOptions;
														</script>

													</div>

													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Course Code:<span
																		style="color: red;">*</span></strong></li>
																 <li id="courseCodeError" style="display:none;" class="style-li error-red" >Please Select Course Code.</li>
															</ul>
														</div>
														<select class="form-control" name="selCourseName"
															id="selCourseName">
														</select>
														
													</div>
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Trainer Name:</strong></li>
																 <li class="style-li error-red">*</li>
																<li id="TrainerNamesError" style="display:none;" class="style-li error-red" >Please Select Course Code.</li>
															</ul>
														</div>
														<select class="form-control" name="selTrainerNames"
															id="selTrainerNames">
														</select>
														<script>
															var selectTrainerOptions = "<option disabled selected value='0'> -- select Trainer -- </option>";
															for ( var i = 0; i < trainerList.length; i++) {
																selectTrainerOptions += "<option value="+trainerList[i].id+">"
																		+ trainerList[i].value
																		+ "</option>"

															}
															document
																	.getElementById('selTrainerNames').innerHTML += selectTrainerOptions;
														</script>

													</div>
													
														<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Seat Capacity:</strong></li>
																<li class="style-li error-red">*</li>
																<li id="seatCapacityError" style="display:none;" class="style-li error-red" >Please Enter Seat Capacity.</li>
															</ul>
														</div>
														<input type="text" value="" name="seatCapacity" 
															id="seatCapacity" class="form-control">
													</div>
													
															<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong> Type:<span
																		style="color: red;">*</span></strong></li>
																<li id="typeError" style="display:none;" class="style-li error-red" >Please Select Course Code.</li>
															</ul>
														</div>
														<select class="form-control" name="type" id="type">
														<option value="0">Select Type</option>
														<option value="P">Paid</option>
														<option value="U">Un-Paid</option>
														</select>
													</div>
					
											<div class="form-group" id="trainingPart" >
											<div>
															<ul class="lab-no">
																<li class="style-li"><strong> Training Partner:<span
																		style="color: red;">*</span></strong></li>
																<li id="trainingPartnerError" style="display:none;" class="style-li error-red" >Please Select Training Partner.</li>
															</ul>
														</div>
											
												
											 	<select class="form-control" name="trainingPartner" onchange="getTrainingCenter(this.value , 'trainingCenter');"
															id="trainingPartner">
														</select>
														<script>
														console.log("length "+trainingPartnerList.length);
															var trainingPartnerListOptions = "";//"<option disabled selected value='0'> -- select training partner -- </option>";
															for ( var i = 0; i < trainingPartnerList.length; i++) {
																trainingPartnerListOptions += "<option value="+trainingPartnerList[i].id+">"
																		+ trainingPartnerList[i].value
																		+ "</option>"

															}
															document
																	.getElementById('trainingPartner').innerHTML += trainingPartnerListOptions;
															document.getElementById('trainingPartner').value = '${partnerId}';
														
															
														</script>
 
                       							 </div>
													
													


												</div>

												<!-- right side -->
												<div class="col-md-6 col-xs-12">

													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training Start
																		Date:</strong></li>
																<li class="style-li error-red">*</li>
																<li id="trainingStartDateError" style="display:none;" class="style-li error-red" >Please Select Training Start Date.</li>
															</ul>
														</div>
														<input type="text" value="" name="trainingStartDate" 
															id="trainingStartDate" class="form-control">
													</div>
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training End Date</strong></li>
																<li class="style-li error-red">*</li>
																<li id="trainingEndDateError" style="display:none;" class="style-li error-red" >Please Select Training End Date.</li>
															</ul>
														</div>
														<input type="text" name="trainingEndDate" 
															id="trainingEndDate" class="form-control">
															
															<input type="hidden" name="loginId"
															id="loginId" value="${loginUserS.loginDetails.loginId}" class="form-control">
													</div>
													
													           <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Assessment Date and Time:</strong></li>
                                                                <li class="style-li error-red">*</li>
																<li id="assessmentDateTimeError" style="display:none;" class="style-li error-red" >Please Select Assessment Date.</li>
                                                            </ul>
                                                        </div>
                                                        <input type="text"  id="assessmentDateTime" value="" name="assessmentDateTime" class="form-control">
                                                    </div>
                      
                      
                      							 <div class="form-group">
                      							   <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Assesment Agency Name:</strong></li>
                                                                <li class="style-li error-red">*</li>
																<li id="assessmentAgencyNameError" style="display:none;" class="style-li error-red" >Please Select Assesment Agency Name.</li>
                                                            </ul>
                                                        </div>
                          						
											 	<select class="form-control" name="assessmentAgencyName" onchange="getAssessorName(this.value)"
															id="assessmentAgencyName">
														</select>
														<script>
														console.log("length "+assessmentAgencyNameList.length);
															var assessmentAgencyNameOptions = "<option disabled selected value='0'> -- select Agency Name -- </option>";
															for ( var i = 0; i < assessmentAgencyNameList.length; i++) {
																assessmentAgencyNameOptions += "<option value="+assessmentAgencyNameList[i].id+">"
																		+ assessmentAgencyNameList[i].value
																		+ "</option>"

															}
															document
																	.getElementById('assessmentAgencyName').innerHTML += assessmentAgencyNameOptions;
														</script>
 
                       							 </div>
                       							 
                       							 	<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Assessor Name:<span
																		style="color: red;">*</span></strong></li>
																<li class="style-li error-red"><label
																	id="assessorNameError" class="error visibility">select
																		Assessor name</label> 
																</li>
															</ul>
														</div>
														<select class="form-control" name="assessorName"
															id="assessorName">
														</select>
													</div>

													<div class="form-group" id="trainingCent" >
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training
																		Center:</strong></li>
																 <li class="style-li error-red">*</li>
																<li id="trainingCenterError" style="display:none;" class="style-li error-red" >Please Select Training Center.</li>
															</ul>
														</div>
										
															<select class="form-control" name="trainingCenter"
															id="trainingCenter">
														</select>
													</div>


													<input type="hidden" path="userName" name="userName" value="${userName}">
													<input type="hidden" path="tcid" name="tcid" value="0" id="tcid">
													<input type="submit" 
														style="margin-top: 20px;"
														class="btn login-btn pull-right show-details-vacancy collapsed" id="btnCreate"
														data-target="#show-result" aria-expanded="false"  onclick=" return validateFields(); "
														value="Create">
														
														<input type="submit" 
														style="display:none; margin-top: 20px;"
														class="btn login-btn pull-right show-details-vacancy collapsed" id="btnUpdate"
														data-target="#show-result" aria-expanded="false"
														value="Update">
														
														<button
														style="display:none; margin-top: 20px;" onclick="updateTrainingCalendar()"
														class="btn login-btn pull-right show-details-vacancy collapsed" style="display:none" id="btnUpdate1"
														data-target="#show-result" aria-expanded="false"
														>Update</button>
														
														
  
													<button style="margin-top: 20px; margin-right: 5px;"
														class="btn login-btn pull-right show-details-vacancy collapsed"
														data-toggle="collapse" data-target="#show-result"
														aria-expanded="false" onclick="showDetails();return false">Show
														Details</button>
														 <input type="button" id="btnExport" style="margin-top:20px; margin-right: 20px;"  class="btn login-btn pull-right" value="Download" />
												</div>

											</div>

											<div class="col-md-3 hidden-xs"></div>
										</div>
									</fieldset>


								</div>

								<!-- search Results -->
								<!-- search Results -->
								<div class="col-xs-12 collapse table-overflow-responsive"
									id="show-result" aria-expanded="false" style="height: 0px;">
									<!-- table -->
									<div class="row">
										<div class="col-xs-12">
											<fieldset style="margin-top: 20px;">
												<legend>
													<h4>Search results</h4>
												</legend>
												<div id="dvData">
												<table id="trainingPartnercalendar"
													class="table table-bordered table-responsive table-striped table-hover">
													<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															
															<th>Batch Code</th>
															<th>Course Code</th>
															<th>Training Start Date</th>
															<th>Training End Date</th>
															<th>Assessment Date Time</th> 
															<th>Assessment Agency Name</th>
															<th>Assessor Name</th>
															<th>Trainer Name</th>
															<th>Seat Capacity</th>
															<th>Type</th>
															<th class="TPEdit">Reschedule</th>
															<th >Cancel</th>
														</tr>
													</thead>
													<tbody id="newTableT">
													</tbody>
												</table>
												</div>
												<a href="#" class="btn login-btn pull-right">Save</a>
											</fieldset>
											<div style="width: 95px;"></div>
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
 <script>
   
   
   function validateFields(){
	   var pid = ${profileId};
$("#courseTypeError").css("display" , "none");
$("#courseCodeError").css("display" , "none");
$("#TrainerNamesError").css("display" , "none");
$("#seatCapacityError").css("display" , "none");
$("#typeError").css("display" , "none");
$("#trainingPartnerError").css("display" , "none");
$("#trainingStartDateError").css("display" , "none");
$("#trainingEndDateError").css("display" , "none");
$("#assessmentDateTimeError").css("display" , "none");
$("#assessmentAgencyNameError").css("display" , "none");
$("#assessorNameError").css("display" , "none");
$("#trainingCenterError").css("display" , "none");

if($("#selCourseType").val() == null){
		 
		$("#courseTypeError").css("display" , "block");
		return false;
	 }  
	
if($("#selCourseName").val() == 0){
	 
	$("#courseCodeError").css("display" , "block");
	return false;
 } 
if($("#selTrainerNames").val() == null){
	 
	$("#TrainerNamesError").css("display" , "block");
	return false;
 }
 if($("#seatCapacity").val() == ''){
	 
	$("#seatCapacityError").css("display" , "block");
	return false;
 } 
if($("#type").val() == 0){
	 
	$("#typeError").css("display" , "block");
	return false;
 }
 if(pid==7){
	 if($("#trainingPartner").val() == null){
		 
			$("#trainingPartnerError").css("display" , "block");
			return false;
		 }
 }

if($("#trainingStartDate").val() == ''){
	$("#trainingStartDateError").css("display" , "block");
	return false;
 }
var currDate=new Date();

var currDateFormat=(currDate.getMonth()+1)+"-"+currDate.getDate()+"-"+currDate.getFullYear();
var currmili=new Date(currDateFormat).getTime();
var d1=$("#trainingStartDate").val().split('-');


var temp=d1[0];
d1[0]=d1[1];
d1[1]=temp;
var d1mili=new Date(d1).getTime();

if(d1mili<currmili){
	alert("Today is "+currDate.getDate()+"-"+(currDate.getMonth()+1)+"-"+currDate.getFullYear()+". Selected Date("+$("#trainingStartDate").val()+") is a past Date.");
	$("#trainingStartDate").val("");
	$("#trainingStartDate").focus();
	return false;
	
	}
	

if($("#trainingEndDate").val() == ''){
	 
	$("#trainingEndDateError").css("display" , "block");
	return false;
 } 
 
 
 
 
var d2=$("#trainingEndDate").val().split('-');
temp2=d2[0];
d2[0]=d2[1];
d2[1]=temp2;

var sd=new Date(d1).getTime();
 var ed=new Date(d2).getTime();

	if(sd>ed){
 alert("End Date cannot be less than Start Date  ");
 $("#trainingEndDate").val("");
	$("#trainingEndDate").focus();

 return false;
}
	
	
if($("#assessmentDateTime").val() == ''){
	 
	$("#assessmentDateTimeError").css("display" , "block");
	return false;
 }


var d3=$("#assessmentDateTime").val().split('-');
temp3=d3[0];
d3[0]=d3[1];
d3[1]=temp3;

 var ad=new Date(d3).getTime();

 if(sd>ad || ed<ad){
	 alert("Assessment Date should be between start date and end date");
	 $("#assessmentDateTime").val("");
		$("#assessmentDateTime").focus();

	 return false;
 }
	
	
if($("#assessmentAgencyName").val() == null){
	 
	$("#assessmentAgencyNameError").css("display" , "block");
	return false;
 }
if($("#assessorName").val() == 0){
	 
	$("#assessorNameError").css("display" , "block");
	return false;
 }
 if(pid==7){
	 if($("#trainingCenter").val() ==0){
		 
			$("#trainingCenterError").css("display" , "block");
			return false;
		 } 
 }

 
  }

   </script>