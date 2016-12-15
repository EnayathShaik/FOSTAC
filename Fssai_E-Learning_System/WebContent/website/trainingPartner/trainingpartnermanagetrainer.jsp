<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
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
</script>
<script>
	function showDetails() {
		alert("Fetching details to mark attendance..");

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
					url : 'trainingpartnermanagetrainer.jspp?' + assessorId,
					async : false,
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
		/* 	var courseType =  $("#courseType").val();
			var courseName =  $("#courseName").val();
			var trainingDate = $("#trainingDate").val().replace("-","/").replace("-","/");
			var requiredExp =  $("#requiredExp").val();
			var noOfVacancy =  $("#noOfVacancy").val(); */
		$(".displayNone").css("display", "block");
		//var total = "courseType="+courseType+"&courseName="+courseName+"&trainingDate="+trainingDate+"&requiredExp="+requiredExp+"&noOfVacancy="+noOfVacancy;
		var total = "";
		var result = "";
		$.ajax({
			type : 'post',
			url : 'trainingpartnermanagetrainer.jspp?' + total,
			async : false,
			success : function(data) {
				$('#newTable').show();
				//var mainData = JSON.stringify(data);
				var mainData1 = jQuery.parseJSON(data);
				var j = 1;
				$('#newTable tr').remove();
				$.each(mainData1, function(i, obj) {
					$('#newTable').append(
							'<tr id="tableRow"><td>' + j++ + '</td><td>'+ obj[0] + '</td><td>' + obj[1]+ '</td><td>' + obj[2] + '</td><td><input type="checkbox">Remove Trainer</td></tr>');

				});
			}
		});
		return result;
	}
</script>
<section>
	<div class="container-fluid">
		<nav
			class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li class="hori"><a href="index.html">Home</a></li>
								<li class="hori"><a href="update-personal-information.html">Update
										Personal Information</a></li>
								<li class="hori"><a href="view-feedback-details.html">View
										Feedback Details</a></li>
								<li class="hori"><a href="contact.html">Contact Us</a></li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li class="dropdown active"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false"><i
										class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="change-password.html">Change Password</a></li>
										<li><a href="#">Logout</a></li>
									</ul></li>
							</ul>
						</div>
						<!--/.nav-collapse -->
					</div>
				</div>
			</div>
		</nav>
	</div>
</section>
<cf:form name="myForm" commandName="trainingPartnerTrainingCalender">
	<!-- main body -->
	<section class="main-section-margin-top">
		<div class="container-fluid">
			<div id="wrapper">

				<!-- Sidebar -->
				<%@include file="leftmenuTrainingPartner.jspf"%>
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
										${loginUser.loginDetails.loginId}</span>
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
											<h3>Manage Trainer</h3>
										</legend>
										<script type="text/javascript">
											var formObj = '${trainingpartnermanagetrainer}';
											var formData = JSON.parse(formObj);
											var courseTypes = formData.courseTypes;
											var trainerList = formData.trainerList;
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
														<select class="form-control"
															onchange="getCourseName(this.value);"
															name="selCourseType" id="selCourseType">
														</select>
														<script>
															var selectctpeOptions = "<option disabled selected value> -- select courseType -- </option>";
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
																<li class="style-li"><strong>Trainer Name:</strong></li>

															</ul>
														</div>
														<select class="form-control" name="selTrainerName"
															id="selTrainerName">
														</select>
														<script>
															var selectTrainerOptions = "";
															for ( var i = 0; i < trainerList.length; i++) {
																console
																		.log(trainerList[i].CourseTypeId
																				+ " -- "
																				+ trainerList[i].CourseType);
																selectTrainerOptions += "<option value="+trainerList[i].id+">"
																		+ trainerList[i].value
																		+ "</option>"

															}
															document
																	.getElementById('selTrainerName').innerHTML += selectTrainerOptions;
														</script>

													</div>


												</div>

												<!-- right side -->
												<div class="col-md-6 col-xs-12">
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Course Name:</strong></li>

															</ul>
														</div>
														<select class="form-control" name="selCourseName"
															id="selCourseName">
														</select>
													</div>
													<button
														class="btn login-btn pull-right show-details-vacancy collapsed"
														data-toggle="collapse" data-target="#show-result"
														aria-expanded="false" onclick="showDetails();return false">Show
														Details</button>
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
												<table
													class="table table-bordered table-responsive table-striped table-hover">
													<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>Course Type</th>
															<th>Course Name</th>
															<th>Trainer Name</th>
															<th>Remove Trainer</th>
														</tr>
													</thead>
													<tbody id="newTable">
													</tbody>
												</table>
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