<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
function OnStart(){
	searchState('ALL');
}
window.onload = OnStart;
</script>
<script type='text/javascript'>

function editStateData(state_id){
	alert(state_id);
	alert(state);
	alert(status);
}

function editStateDataOld(){
	var idHidden =  $("#idH").val();
	var status = $("#status").val();
	var state = $("#stateName").val();

	document.getElementById('btnUpdate').style.display = 'block';
	document.getElementById('btnCreate').style.display = 'none';
	 var total = "id="+idHidden+"&status="+ status+ "&state="+state;
	// alert(total);
	//$('#newTable').hide();
	//alert(total);
	$.ajax({
	type: 'post',
	url: 'deleteState.jspp?'+ total,
	data: {
	       user_name:name,
	      },
	      success: function (response) {
	       $( '#name_status' ).html(response);
	      }
	      });
	//alert (result);
	return true; 
	location.reload();
}
	
function checkState() {
		var name = document.getElementById("stateName").value;
		if (name) {
			$
					.ajax({
						type : 'post',
						url : 'CheckState.jspp?' + name,
						data : {
							user_name : name,
						},
						success : function(response) {
							$('#name_status').html(response);
							if (response == "Already") {
								document.getElementById("btnCreate").style.display = 'none';
								return false;
							} else {
								document.getElementById("btnCreate").style.display = 'block';
								return true;
							}
						}
					});
		} else {
			$('#name_status').html("");
			document.getElementById("btnCreate").style.display = 'none';
			return false;
		}
}
</script>
<script>
function deleteState(state,status,idHidden) {
		document.getElementById('idH').value = idHidden;
		document.getElementById('btnUpdate').style.display = 'none';
		$('label[id=created').html('');
		//document.getElementById('btnCreate').style.display = 'block';
		$("#btnCreate").hide();
		// $("#stateName").prop("disabled", true);
		document.getElementById('stateName').value = state;
	    document.getElementById('stateLabel').value = status;
		$(".displayNone").css("display","block");
		$("#btnUpdate").css("display","block");
		 if(status=="A"){
		$('#status option').remove();
		$('#status').append('<option value="A" selected="true">Active</option><option value="I">In-active</option>');
		}else{
		$('#status option').remove();
		$('#status').append('<option value="A">Active</option><option value="I"  selected="true">In-active</option>');
		} 
}
</script>
<script>
function deleteState1(i) {
	var idHidden =  $("#idLabel'"+i+"'").val();
	var status = $("#statusLabel").val();
	var state = $("#stateLabel").val();
	//alert(idHidden + "  "+ status + "   "+ state);
	document.getElementById('btnUpdate').style.display = 'none';
	document.getElementById('btnCreate').style.display = 'block';
	$(".displayNone").css("display","block");
		var total = "id="+idHidden+"&status="+ status+"";
		$('#newTable').show();
		//alert(total);
		$.ajax({
		type: 'post',
		url: 'deleteState1.jspp?'+ total,
		data: {
		       user_name:name,
		      },
		      success: function (response) {
		       $( '#name_status' ).html(response);
		      }
		      });
		//alert (result);
		
	return true;
}
</script>
<script>
	function searchState(indicator) {
	
		$('.displayNone').css('display', 'block');
		$('#created').css('display', 'none');
		var stateName =  $("#stateName").val();
		var status =  $("#status").val();
		 {
			var result="";
			var total ="";
			if(indicator.match('ALL')){
				total = "stateName=&status="+status;
			}else{
				total = "stateName="+stateName+"&status="+status;
			}
			$.ajax({
			type: 'post',
			url: 'searchState.jspp?'+ total,
			async: false, 
			success: function (data){
			$('#newTable').show();
			var mainData1 = jQuery.parseJSON(data);
			//alert(mainData1);
			var j=1;
			$('#newTable tr').remove();
			$('#newTable').append('<tr  class="background-open-vacancies" style="background-color:#000077;"><th>S.No.</th><th>State Name</th><th>Status</th><th>Change</th><th style="display:none"></th></tr>')
			$.each(mainData1 , function(i , obj)
			{
				var stat ;
				if(obj.status == 'A'){
					stat = 'Active';
				}else{
					stat = 'In-Active';
				}
				var state = obj.stateName;
				var status = obj.status;
				$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td><input type="hidden" id="stateLabel" value="'+obj.stateName+'">'+obj.stateName+'</td><td><input type="hidden" id="statusLabel" value="'+obj.status+'">'+stat+'</td><td> &nbsp;&nbsp;&nbsp;&nbsp; <a href="#" onClick="deleteState(\''+obj.stateName+'\',\''+obj.status+'\',\''+obj.stateId+'\');">Edit</a> </td><td style="display:none;"><input type="hidden" id="idLabel'+i+'" value="'+obj.stateId+'"></td></tr>');	
			});
			}
			});
		return result;
		}

	}
	
	
</script>
<cf:form action="stateMasterSave.fssai" name="myForm" method="POST"
	commandName="stateMaster" onsubmit="return validateFields();">

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
								<ul class="nav navbar-nav" style="padding-left: 70px;">
									<li></li>
									<li class="hori"><a href="adminHomepage.fssai">Home</a></li>
									<li><a href="#" class="dropdown-toggle"
										data-toggle="dropdown" role="button" aria-haspopup="true"
										aria-expanded="false">User Management<span class="caret"></span></a>
										<ul class="dropdown-menu">
											<li><a href="traineeUserManagementForm.fssai" class="clr">Trainee</a></li>
											<li><a href="trainerUserManagementForm.fssai" class="clr">Trainer</a></li>
											<li><a href="trainingCenterUserManagementForm.fssai"
												class="clr">Training Center</a></li>
											<li><a href="assessorUserManagementForm.fssai" class="clr">Assessor</a></li>
											<li><a href="adminUserManagementForm.fssai" class="clr">Admin</a></li>
										</ul></li>
									<li class="active"><a href="#" class="dropdown-toggle"
										data-toggle="dropdown" role="button" aria-haspopup="true"
										aria-expanded="false">Master Data<span class="caret"></span></a>
										<ul class="dropdown-menu">
											<li><a href="stateMaster.fssai" class="clr">State</a></li>
											<li><a href="districtMaster.fssai" class="clr">District</a></li>
											<li><a href="cityMaster.fssai" class="clr">City</a></li>
											<li><a href="regionMappingMaster.fssai" class="clr">Region
													Mapping</a></li>
										</ul></li>
									<li><a href="manageTrainingPartnerForm.fssai">Manage
											Training Partner</a></li>
									<li><a href="manageAssessmentAgencyForm.fssai">Manage
											Assessment Agency</a></li>
								</ul>
								<ul class="nav navbar-nav navbar-right">
									<li class="dropdown active"><a href="#"
										class="dropdown-toggle" data-toggle="dropdown" role="button"
										aria-haspopup="true" aria-expanded="false"><i
											class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
										<ul class="dropdown-menu">
											<li><a href="changePasswordAssesAgency.fssai">Change Password</a></li>
											<li><a href="fostac.fssai">Logout</a></li>
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
	<!-- main body -->
	<section class="main-section-margin-top">
		<div class="container-fluid">
			<div id="wrapper">
				<!-- Sidebar -->
				<div id="sidebar-wrapper">
					<ul class="sidebar-nav">
						<!-- <li class="sidebar-brand"></li> -->
						<li><a href="manageCourse.fssai">Manage Course</a></li>
						<li><a href="manageCoursecontent.fssai">Manage Course
								Content</a></li>
						<li><a href="trainingCalendar.fssai">Training Calendar</a></li>
						<li><a href="assessmentSchedule.fssai">Assessment
								Schedule</a></li>
						<li><a href="manageAssessmentQuestions.fssai">Assessment
								Questions</a></li>
						<li><a href="updateTrainerAssessment.fssai">Update
								Assessment</a></li>
					</ul>
				</div>
				<!-- /#sidebar-wrapper -->
				<!-- Page Content -->
				<div id="page-content-wrapper">
					<div class="container-fluid">
						<!-- vertical button -->
						<div class="row">
							<div class="col-lg-12">
								<a href="#menu-toggle" class="vertical-menu-position-btn"
									id="menu-toggle"> <i class="fa fa-bars"></i> <span
									class="orange-font">Welcome Admin</span>
								</a>
							</div>
						</div>
						<!-- add the content here for main body -->
						<!-- timeline  -->
						<div class="row">

							<div class="col-xs-12">
								<h1>State Master <label id="created">${created }</label></h1>
								<div class="row">
									<div class="col-xs-12">

										<!-- left side -->
										<div class="col-xs-6">
											<div class="form-group">
												<div>
													<ul class="lab-no">
														<li class="style-li"><strong>State Name:
														<span style="color:red;">*</span>
														</strong></li>
														<li class="style-li error-red">
														<span id="name_status"></span>
														 <label class="error visibility" id="stateNameError">* error</label>
														<label id="created">${created }</label>
														</li>
													</ul>
												</div>
												<cf:input path="stateName" placeholder="State Name"
													class="form-control"  onkeyup="checkState();" />

											</div>
											<div class="form-group">
												<input type="submit" class="btn login-btn" id="btnCreate" value="Create">



<input type="hidden" id="idHidden" value="">




											</div>
										</div>
										<!-- left side ends -->

										<!-- right side -->
										<div class="col-xs-6">

											<div class="form-group">
												<div>
													<ul class="lab-no">
														<li class="style-li"><strong>Status:</strong></li>
														<li class="style-li error-red"><cf:errors
																path="status" cssClass="error" /></li>
													</ul>
												</div>
												<cf:select path="status" class="form-control">
													<cf:option value="A" label="Active" />
													<cf:option value="I" label="In-Active" />
												</cf:select>

											</div>

											<div class="form-group">

<a href="" onclick="editStateDataOld();" id="btnUpdate" style="display: none; padding: 6px 7px; width: 20%; 
margin-bottom: 0; font-size: 14px; font-weight: normal; line-height: 1.42857143; 
text-align: center; white-space: nowrap; vertical-align: middle; 
-ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; 
-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; 
user-select: none; background-image: none; border: 1px solid transparent; 
background: #ef580d !important; color: #fff; border: 1px solid transparent; 
transition: all 0.8s linear;">
Update</a> 
	<a href="#testt" onclick="searchState('SELECTED');" class="pull-right">Search</a>


											</div>
											<!-- button row ends -->

										</div>
										<!-- rigth side ends -->

										<!-- button -->


									</div>


								</div>
							</div>

							<!-- search Results -->
							<div class="col-xs-12 " id="testt">

								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
										<fieldset class="displayNone" >
											<legend>Search Result</legend>

											<table id="newTable"
												class="table table-striped table-hover table-bordered table-responsive">
												<thead>
													<tr class="background-open-vacancies">
														<th>S. No.</th>
														<th>State Name</th>
														<th>Status</th>
														<th>Change Status</th>
													</tr>
												</thead>
												<tbody>
<%-- <ct:if test="${not empty stateList }">
<ct:forEach varStatus="loop" var="state" items="${stateList}">
<tr>
<td>${loop.count } </td><td>${state.stateName }</td>
<td>
${state.status } 
</td>
<td>
<input type="hidden" id="idLabel1" value="${state.stateId }">
<input type="hidden" id="statusLabel1" value="${state.status }">
<a href="#" onclick="deleteState1();">Active / In-Active</a></td>
</tr>
</ct:forEach>
</ct:if> --%>
			
												</tbody>
											</table>

										</fieldset>

									</div>
								</div>
							</div>
							<!-- search div ends -->

						</div>
						<!-- row ends -->

					</div>
				</div>
			</div>
		</div>
	</section>
	<input type="hidden" id="idH" value="" />
</cf:form>