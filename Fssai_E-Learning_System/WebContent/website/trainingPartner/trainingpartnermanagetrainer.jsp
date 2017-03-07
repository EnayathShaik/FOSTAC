<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="website/js/commonController.js"></script>

<script>

 	function showDetails() {
		
		
		 	var courseType =  ($("#selCourseType").val() == 0 || $("#selCourseType").val() == null ? "" : $("#selCourseType").val());
		 	var trainername =  ($('#selTrainerName').val() == 0 || $('#selTrainerName').val() == null ? "" : $('#selTrainerName').val() );
			var courseName =  ($("#selCourseName").val() == 0 || $("#selCourseName").val() == null ? "" : $("#selCourseName").val()) ;
			var result = "";
		$(".displayNone").css("display", "block");
		var total = "courseType="+courseType+"&courseName="+courseName+"&trainerName="+trainername;
		$.ajax({
			type : 'post',
			url : 'trainingpartnermanagetrainer.jspp?' + total,
			async : false,
			success : function(data) {
				$('#newTable').show();
				var mainData1 = jQuery.parseJSON(data);
				var j = 1;
				$('#newTable tr').remove();
				$.each(mainData1, function(i, obj) {
					$('#newTable').append(
							'<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[1]+ '</td><td>' + obj[2] + '</td><td><a href="#" onClick="removeTrainer(\''+obj[3]+'\');">Remove Trainer</a> </td></tr>');

				});
			}
		});
		return result;
	}


	function removeTrainer(id){
			if(confirm("Are You Sure!!")){
				$.ajax({
					type : 'post',
					url : 'trainingpartnermanagetrainer.jspp?'+id,
					async : false,
					success : function(data) {
					alert(data);
					}
				});
				showDetails();
		    }
		    else{
		        return false;
		    }
		
		
	}
	
</script>
<section>
	 <%@include file="../roles/top-menu.jsp"%>
</section>
<cf:form name="myForm" commandName="trainingPartnerTrainingCalender">
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
															onchange="getCourseName(this.value , 'selCourseName');"
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
																selectTrainerOptions += "<option value='0'>Please Select</option>"
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
																<li class="style-li"><strong>Course Code:</strong></li>

															</ul>
														</div>
														<select class="form-control" name="selCourseName"
															id="selCourseName">
														</select>
													</div>
													 <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="showDetails();return false;">Show Details</button>
												</div>
												<input type="button" id="btnExport"  style="margin-top:-34px; margin-right: 15px;"  class="btn login-btn pull-right" value="Download" />

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
												<table
													class="table table-bordered table-responsive table-striped table-hover">
													<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>Course Code</th>
															<th>Trainer Name</th>
															<th>Remove Trainer</th>
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