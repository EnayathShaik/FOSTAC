<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
function OnStart(){

	flatpickr('[name="trainingEndDate"]' , {
		//defaultDate: today, // Date objects and date strings are also accepted
		enableTime: true
	});
	
	flatpickr('[name="trainingStartDate"]' , {
		//defaultDate: today, // Date objects and date strings are also accepted
		enableTime: true
	});

	
	flatpickr('[name="assessmentDateTime"]' , {
		//defaultDate: today, // Date objects and date strings are also accepted
		enableTime: true
	});
}


function editTrainingCalendar( srNo , id, courseType){
	
	console.log("i "+i + "   courseType "+courseType);
	
	
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
}
window.onload = OnStart;

	function getCourseName(val) {
		$('#selCourseName option').remove();
		$.ajax({
			type : 'post',
			url : 'getCourseName.jspp?' + val,
			success : function(response) {
				var mainData1 = jQuery.parseJSON(response);
				$('#selCourseName option').remove();
				$('#selCourseName').append(
						'<option value="0" label="--Select Course Name--" />');
				$.each(mainData1, function(i, obj) {
					$('#selCourseName')
							.append(
									'<option value='+obj[0]+' >' + obj[1]
											+ '</option>');
				});
			}
		});
	}

	function getTrainingCenter(val) {
		$.ajax({
			type : 'post',
			url : 'loadTrainingCenter.jspp?' + val,
			success : function(response) {
				var mainData1 = jQuery.parseJSON(response);
				//alert(mainData1);
				$('#trainingCenter option').remove();
				$('#trainingCenter').append(
						'<option value="0" label="Select Training Center" />');
				$.each(mainData1, function(i, obj) {
					$('#trainingCenter').append(
							'<option value='+obj[0]+' label='+obj[1]+' />');
				});
			}
		});
	}
	
	//getAssessorName.jspp
		function getAssessorName(val) {
		$.ajax({
			type : 'post',
			url : 'getAssessorName.jspp?' + val,
			success : function(response) {
				var mainData1 = jQuery.parseJSON(response);
				
				$('#assessorName option').remove();
			/* 	$('#assessorName').append(
						'<option value="0" label="Select Assessor Name" />'); */
				$.each(mainData1, function(i, obj) {
					$('#assessorName')
					.append(
							'<option value='+obj[0]+' >' + obj[1]
									+ '</option>');
				});
			}
		});
	}
</script>
<script>
	function saveDetails() {

	}

	function showDetail() {
		//
		var courseType = $("#selCourseType").val();
		var courseName = $("#selCourseName").val();
		var trainingDate = $("#trainingStartDate").val();
		var trainingTime = $("#trainingEndDate").val();
		var trainerName = $('#selTrainerNames').val();
		
		$('#tblAssessorCourses tr').remove();
		$('#tblAssessorCourses').append(
				'<thead>' + '<tr class="background-open-vacancies">'
						+ '<th>S.No.</th>' + '<th>Course Type</th>'
						+ '<th>Course Name</th>' + '<th>Training Date</th>'
						+ '<th>Training Time</th>' + '<th>Trainer Name</th>'
						+ '<th>&nbsp;&nbsp;</th>' + '</tr>' + '</thead>');
		var result = "";
		//var id = document.getElementById("assessmentAgencyId").value;
		var assessorId = 710;
		$
				.ajax({
					type : 'post',
					url : 'searchTrainingPartnerGenaricServlet.jspp?'
							+ assessorId,
					async : false,
					data : {
						cousertypeid : $('#selCourseType').val(),
						coursenameid : $('#selCourseName').val(),
						trainerid : $('#selTrainerNames').val(),
						trainingdate : $('#trainingdate').val(),
						trainingtime : $('#trainingtime').val(),
						screentype : "TRAINING_PARTNER_CALENDAR"
					},
					success : function(data) {
						console.log("Data received..");
						console.log(data);
						var jsonData = jQuery.parseJSON(data);
						console.log(jsonData);
						var j = 1;
						var accessorId;
						$
								.each(
										jsonData,
										function(i, obj) {
											$('#tblAssessorCourses')
													.append(
															'<tr id="tableRow"><td>'
																	+ j++
																	+ '</td>'
																	+ '<td>'
																	+ obj[3]
																	+ '</td>'
																	+ '<td>'
																	+ obj[4]
																	+ '</td>'
																	+ '<td>'
																	+ obj[5]
																	+ '</td>'
																	+ '<td><select name =attendanceRow'+obj[1]+'><option name="present" value ="A">Present</option>'
																	+ '<option name="absent" value="I">Absent</option></td>'
																	+ '<td> <button onclick="updateAttendance('
																	+ obj[0]
																	+ ','
																	+ obj[1]
																	+ ');return false;">Update</button></td>'
																	+ '</tr>');
											console.log("0-" + obj[0] + " #1-"
													+ obj[1] + " #2-" + obj[2]
													+ " #3-" + obj[3] + " #4-"
													+ obj[4] + " #5-" + obj[5]);
											currentAssessorId = obj[0];
										});

					},
					failure : function(data) {
						alert("Error occured while retrieving upcoming calendars.");
						msgbox('Error occured while retrieving upcoming calendars.');
					}
				});
		return result;
	}

	function showDetails() {
		$(".displayNone").css("display", "block");
		var courseType = ($("#selCourseType").val()== 0 ||  $("#selCourseType").val() == null ? "" : $("#selCourseType").val());
		var courseName =  ($("#selCourseName").val() == 0 || $("#selCourseName").val() == null ? "" : $("#selCourseName").val());
		var trainingStartDate = (($("#trainingStartDate").val() == 'undefined' || $("#trainingStartDate").val() == null ) ? "" : $("#trainingStartDate").val() );
		var trainerName = ($("#selTrainerNames").val() == 0 || $("#selTrainerNames").val() == null ? "" : $("#selTrainerNames").val());
		var trainingEndDate = (($("#trainingEndDate").val() == 'undefined' || $("#trainingEndDate").val() == null ) ? "" : $("#trainingEndDate").val() );

		var total = "courseType="+courseType + "&courseName=" + courseName+ "&trainingStartDate=" + trainingStartDate + "&trainingEndDate="+ trainingEndDate+"&trainerName="+trainerName;
		var result = "";
		$.ajax({
			type : 'post',
			url : 'traineeCenterViewTrainee.jspp?' + total,
			
			async : false,
			success : function(data) {
				$('#newTable').show();
				//var mainData = JSON.stringify(data);
				var mainData1 = jQuery.parseJSON(data);
				var j = 1;
				$('#newTable tr').remove();
				$.each(mainData1, function(i, obj) {
					console.log(" --> "+obj[9] + ' 10  '+obj[10] + '  11 '+obj[11] + '  12 '+obj[12]);
					$('#newTable').append(
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
									+ '</td><td><input type="button"  onClick="editTrainingCalendar(\''+i+'\',\''+obj[0]+'\',\''+obj[1]+'\');" value="Reschedule"/></td><td> <input type="submit"  onclick=" return setId('+obj[0]+')" value="Cancel Training"/> </td></tr>');

				});
			}
		}); 
		return result;
	}
	
	function setId(id){
		alert("id "+id);
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
										${loginUserS.loginDetails.loginId}</span>
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
											
										</script>

										<div class="row">
											<div class="col-xs-12">

												<!-- left side -->
												<div class="col-md-6 col-xs-12">
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Course Type:</strong></li>
																<label id="courseTypeError" class="error visibility">select
																	course type</label>
																<span id="name_status"> ${created } </span>
															</ul>
														</div>
														<select path="selCourseType" class="form-control"
															onchange="getCourseName(this.value);"
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
																<li class="style-li error-red"><label
																	id="courseNameError" class="error visibility">select
																		course code</label> <%--  <cf:errors path="courseName" cssclass="error"/> --%>
																</li>
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
																<li class="style-li error-red"></li>
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
																<li class="style-li error-red"><label
																	id="courseNameError" class="error visibility">select
																		Type</label> <%--  <cf:errors path="type" cssclass="error"/> --%>
																</li>
															</ul>
														</div>
														<select class="form-control" name="type" id="type">
														<option value="0">Select Type</option>
														<option value="P">Paid</option>
														<option value="U">Un-Paid</option>
														</select>
													</div>
					
												</div>

												<!-- right side -->
												<div class="col-md-6 col-xs-12">

													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training Start
																		Date:</strong></li>
																<li class="style-li error-red"></li>
															</ul>
														</div>
														<input type="date" value="" name="trainingStartDate" 
															id="trainingStartDate" class="form-control">
													</div>
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training End Date</strong></li>
																<li class="style-li error-red"></li>
															</ul>
														</div>
														<input type="time" name="trainingEndDate" 
															id="trainingEndDate" class="form-control">
															
															<input type="hidden" name="loginId"
															id="loginId" value="${loginUserS.loginDetails.loginId}" class="form-control">
													</div>
													
													           <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Assessment Date and Time:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="text"  id="assessmentDateTime" value="" name="assessmentDateTime" class="form-control">
                                                    </div>
                      
                      
                      							 <div class="form-group">
                          						<label>Assesment Agency Name</label> &nbsp;&nbsp;
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
                                                
													<input type="hidden" path="tcid" name="tcid" value="0" id="tcid">
													<input type="submit" onclick="return saveDetails();"
														style="margin-top: 20px;"
														class="btn login-btn pull-right show-details-vacancy collapsed" id="btnCreate"
														data-target="#show-result" aria-expanded="false"
														value="Create">
														
														<input type="submit" 
														style="display:none; margin-top: 20px;"
														class="btn login-btn pull-right show-details-vacancy collapsed" id="btnUpdate"
														data-target="#show-result" aria-expanded="false"
														value="Update">
														
														
  
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
															<th >Reschedule</th>
															<th >Cancel</th>
														</tr>
													</thead>
													<tbody id="newTable">
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