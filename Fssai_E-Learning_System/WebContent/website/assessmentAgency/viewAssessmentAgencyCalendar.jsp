<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="website/js/commonController.js"></script>

<script src="website/js/jquery-1.9.1.js"></script>
 <script type="text/javascript">
function OnStart(){
	//searchAssessmentAgencyCalendar();
	
	flatpickr("#assessmentDateTime" , {
		enableTime: true
	});	
	
	var profileid = '${profileId}';
	
	if(profileid == "6"){
		$("#assessor").val('${loginUserAssessor}');
	}
	
}
window.onload = OnStart;

</script> 

<script type="text/javascript">
	function searchAssessmentAgencyCalendar() {
		var result = "";
		var agencyId =0;
		var courseType = ($("#courseType").val()== 0 ||  $("#courseType").val() == null ? "" : $("#courseType").val());
		var courseName =  ($("#courseName").val() == 0 || $("#courseName").val() == null ? "" : $("#courseName").val());
		var assessmentDateTime = (($("#assessmentDateTime").val() == 'undefined' || $("#assessmentDateTime").val() == null ) ? "" : $("#assessmentDateTime").val() );
		var assessmentAgencyName = ($("#assessmentAgency").val()== 0 ||  $("#assessmentAgency").val() == null ? "" : $("#assessmentAgency").val());
		var assessorName = ($("#assessor").val()== 0 ||  $("#assessor").val() == null ? "" : $("#assessor").val());
		var total = "courseType="+courseType + "-courseName=" + courseName+"-assessmentDateTime="+assessmentDateTime+"-assessmentAgencyName="+assessmentAgencyName+"-assessorName="+assessorName;
		var name1=JSON.stringify({
			courseType:0,
			courseName:0
	  })
		$.ajax({
			type : 'post',
			url : 'viewAssessmentAgencyCalendar.fssai?data='+total,
			 contentType : "application/json",
			  data:name1,
			async : false,
			success : function(data) {
				$('#tblAACalendar').show();
				var calendarData = jQuery.parseJSON(data);
				var j = 1;
				$('#tblAACalendar tr').remove();
				$('#tblAACalendar').append(
						'<thead>' + '<tr class="background-open-vacancies">'
								+ '<th>S.No.</th>' + '<th>Batch Code</th>'
								+ '<th>Course Code</th>'
								+ '<th>Assessment Date and Time</th>'
								+ '<th>Assessment Center</th>'
								+ '<th>Assessor</th>'
								+ '</tr>' + '</thead>');
				$.each(calendarData, function(i, obj) {
					$('#tblAACalendar').append(
							'<tr id="tableRow"><td>' + j++ + '</td><td>'
									+ obj[7] + '</td><td>' + obj[6]
									+ '</td><td>' + obj[2] + '</td><td>'
									+ obj[3] + '</td><td>' + obj[4]
									+ '</td></tr>');

				});
			}
		});
		return result;
	}	
</script>


<cf:form name="viewAssessmentAgencyCalendar"
	commandName="viewAssessmentAgencyCalendarForm">

	<section>
		<%@include file="../roles/top-menu.jsp"%>
	</section>
	<!-- main body -->
	<section class="main-section-margin-top">
		<div class="container-fluid">
			<div id="wrapper">
				<!-- Sidebar -->
				<%@include file="../roles/slider.jsp"%>
				<!-- /#sidebar-wrapper -->
				<!-- Page Content -->
				<div id="page-content-wrapper">
					<div class="container-fluid">
						<!-- vertical button -->
						<div class="row">
							<div class="col-lg-12">
								<a href="#menu-toggle" class="vertical-menu-position-btn"
									id="menu-toggle"> <i class="fa fa-bars"></i> <span
									class="orange-font">Welcome :  ${userName} </span>
								</a>
							</div>
						</div>
						<!-- add the content here for main body -->
						<!-- timeline  -->
						<section class="section-form-margin-top">

							<!-- fostac logo -->
							<!-- login form -->
							<div class="row">
								<div class="col-xs-12">
									<h3 class="text-capitalize heading-3-padding">View
										Assessment Calendar</h3>
									<form>
										<!-- personal information -->
										<div class="personel-info">

											<!-- left side -->
											 <div class="col-md-6 col-xs-12">
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Course Type:</strong></li>

														</ul>
													</div>
													<cf:select path="courseType" class="form-control"
														onchange="getCourseName(this.value, 'courseName');">
														<cf:option value="0" label="Select Course Type" />
														<cf:options items="${courseTypeList}"
															itemValue="CourseTypeId" itemLabel="CourseType" />
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
														<cf:option value="0" label="Select Course Code" />
														<%-- <cf:options items="${courseNameList}" itemValue="coursenameid" itemLabel="coursename"/> --%>
													</cf:select>
												</div>
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Assessment
																	Date Time:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<cf:input path="assessmentDateTime" type="date" id="assessmentDateTime"  class="form-control" />
												</div>

											</div> 
											<!-- right side -->
											<div class="col-md-6 col-xs-12">

												 <div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Assessment
																	Center:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<cf:select path="assessmentAgency" class="form-control">
													<cf:option value="${assessmentId}" label="${agencyName}" /> 
													</cf:select>
												</div>

												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Assessor:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<cf:select path="assessor" class="form-control">
														
														<cf:option value="0" label="Select Assessor" />
														<cf:options items="${assessorName}" />
													</cf:select>
												
												
												</div>

												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Status:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<select class="form-control">
														<option value="A">Active</option>
														<option value="I">Inactive</option>
													</select>
												</div>
 

												<!-- button -->
												<div class="row">
													<div class="col-md-6 col-xs-12"></div>

													<div class="col-md-6 col-xs-12" style="margin-top: 26px;">

														<button
															class="btn login-btn pull-right show-details-vacancy collapsed"
															data-toggle="collapse" data-target="#show-result"
															aria-expanded="false" style="margin-right: 15px"
															onclick="searchAssessmentAgencyCalendar();return false;">Search</button>
													</div>
												</div>


											</div>
											<!-- personal information ends -->
										</div>
										<div class="row" style="height: 20px;"></div>


										<!-- training center details ends -->
									</form>
								</div>
								<!-- xs 12 -->
								<div class="col-md-2 hidden-xs"></div>
							</div>

						</section>


						<!-- search result -->
						<div class="col-xs-12 collapse" id="show-result"
							aria-expanded="true" style="height: 0;">

							<!-- table -->
							<div class="row">
								<div class="col-xs-12">
									<fieldset>
										<legend>Search Result</legend>

										<table id="tblAACalendar"
											class="table table-bordered table-responsive">

										</table>
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
