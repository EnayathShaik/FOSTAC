<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="website/js/commonController.js"></script>

<script type="text/javascript">
	function OnStart() {
		DrawCaptcha();
	}
	window.onload = OnStart;
</script>
<script>
	function DrawCaptcha() {
		var a = Math.ceil(Math.random() * 10) + '';
		var b = Math.ceil(Math.random() * 10) + '';
		var c = Math.ceil(Math.random() * 10) + '';
		var d = Math.ceil(Math.random() * 10) + '';
		var e = Math.ceil(Math.random() * 10) + '';
		var f = Math.ceil(Math.random() * 10) + '';
		var g = Math.ceil(Math.random() * 10) + '';
		var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' ' + f
				+ ' ' + g;
		document.getElementById("txtCaptcha").value = code
	}

	// Validate the Entered input aganist the generated security code function   
	function ValidCaptcha() {
		var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
		var str2 = removeSpaces(document.getElementById('txtInput').value);
		if (str1 == str2) {
			return checkagree();
			return true;
		} else {
			alert("Please Enter correct captcha");
			document.getElementById('txtInput').value = "";
			return false;
		}

	}

	// Remove the spaces from the entered and generated code
	function removeSpaces(string) {
		return string.split(' ').join('');
	}

	function checkagree() {
		var d = document.getElementById('check').checked;
		if (d == true) {
			return true;
		} else {
			alert('Please Confirm on agree');
			return false;
		}
	}
</script>
<script type='text/javascript'>
	function myFunction() {
		window.document.myForm.imgcaptcha.src = '';
		window.document.myForm.imgcaptcha.src = './Captcha.jpg?random='
				+ new Date().getTime();
		return false;
	}
	function AvoidSpace(event) {
		var k = event ? event.which : window.event.keyCode;
		if (k == 32)
			return false;
	}

	
	function myCheckPermanent() {
		var x = document.getElementById('checkPermanent').checked;
		
		if (x == true) {
			document.getElementById('AssessorPermanentLine1').value = document
					.getElementById('AssessorCorrespondenceLine1').value;
			document.getElementById('AssessorPermanentLine2').value = document
					.getElementById('AssessorCorrespondenceLine2').value;
			document.getElementById('AssessorPermanentPincode').value = document
					.getElementById('AssessorCorrespondencePincode').value;
			//$("#AssessorPermanentPincode").attr('readonly',true);
			document.getElementById('AssessorrPermanentState').value = document.getElementById('AssessorCorrespondenceState').value;
			$("#AssessorrPermanentState").trigger("change");
			//$("#AssessorrPermanentState").attr("disabled" , true);
			window.setTimeout(function(){
				//console.log("district "+ document.getElementById('AssessorCorrespondenceDistrict').value);
				$("#AssessorPermanentDistrict").val($("#AssessorCorrespondenceDistrict").val());
				$("#AssessorPermanentDistrict").trigger("change");
				//$("#AssessorPermanentDistrict").attr('disabled',true);
			 }, 3000);
			
				window.setTimeout(function(){
					//console.log(" city "+ document.getElementById('AssessorCorrespondenceCity').value);
					$("#AssessorPermanentCity").val($("#AssessorCorrespondenceCity").val())
			}, 4000);
			
			
		}
		if (x == false) {
			document.getElementById('permanent1').style.display  = 'block';
			document.getElementById('permanent2').style.display  = 'block';
			document.getElementById('AssessorPermanentLine1').value = "";
			document.getElementById('AssessorPermanentLine2').value = "";
			document.getElementById('AssessorPermanentPincode').value = "";
			document.getElementById('AssessorrPermanentState').value = "";
			document.getElementById('AssessorPermanentDistrict').value = "";
			document.getElementById('AssessorPermanentCity').value = "";
		}
	}

	function myBasic(oCheckbox) {
		var y = [];
		$("input[name='BasicCourse']:checked").each(function() {
			y.push($(this).val());
		});
		document.getElementById('BasicCourse1').value = y;
		return y;
	}
	function myAdvance(oCheckbox) {
		var y = [];
		$("input[name='AdvanceCourse']:checked").each(function() {
			y.push($(this).val());
		});
		document.getElementById('AdvanceCourse1').value = y;
		return y;
	}
	function mySpecial(oCheckbox) {
		var y = [];
		$("input[name='SpecialCourse']:checked").each(function() {
			y.push($(this).val());
		});
		document.getElementById('SpecialCourse1').value = y;
		return y;
	}


	
	

	
</script>
<script type='text/javascript'>
	function validate() {
		//alert("The form was submitted");
		if (document.getElementById('AadharNumber').value == null) {
			document.getElementById('AadharNumber').focus();
			document.getElementById('AadharNumber').style.color = "red";
			document.getElementById('errorAadharNumber').style.display = 'block';
			return false;
		} else {
			document.getElementById('AadharNumber').style.color = "#ccc";
			document.getElementById('errorAadharNumber').style.display = 'none';
		}

/* 		if (document.getElementById('UserId').value == null) {
			document.getElementById('UserId').focus();
			document.getElementById('UserId').style.borderColor = "red";
			document.getElementById('errorUserId').style.display = 'block';
			return false;
		} else {
			document.getElementById('UserId').style.borderColor = "#ccc";
			document.getElementById('errorUserId').style.display = 'none';
		} */

		if (document.getElementById('Title').value == null) {
			document.getElementById('Title').focus();
			document.getElementById('Title').style.borderColor = "red";
			document.getElementById('errorTitle').style.display = 'block';
			return false;
		} else {
			document.getElementById('Title').style.borderColor = "#ccc";
			document.getElementById('errorTitle').style.display = 'none';
		}

		if (document.getElementById('DOB').value == null) {
			document.getElementById('DOB').focus();
			document.getElementById('DOB').style.borderColor = "red";
			document.getElementById('errorDOB').style.display = 'block';
			return false;
		} else {
			document.getElementById('DOB').style.borderColor = "#ccc";
			document.getElementById('errorDOB').style.display = 'none';
		}

		if (document.getElementById('gender').value == null) {
			document.getElementById('gender').focus();
			document.getElementById('gender').style.borderColor = "red";
			document.getElementById('errorgender').style.display = 'block';
			return false;
		} else {
			document.getElementById('gender').style.borderColor = "#ccc";
			document.getElementById('errorgender').style.display = 'none';
		}

		if (document.getElementById('FirstName').value == null) {
			document.getElementById('FirstName').focus();
			document.getElementById('FirstName').style.borderColor = "red";
			document.getElementById('errorFirstName').style.display = 'block';
			return false;
		} else {
			document.getElementById('FirstName').style.borderColor = "#ccc";
			document.getElementById('errorFirstName').style.display = 'none';
		}

		if (document.getElementById('MiddleName').value == null) {
			document.getElementById('MiddleName').focus();
			document.getElementById('MiddleName').style.borderColor = "red";
			document.getElementById('errorMiddleName').style.display = 'block';
			return false;
		} else {
			document.getElementById('MiddleName').style.borderColor = "#ccc";
			document.getElementById('errorMiddleName').style.display = 'none';
		}

		if (document.getElementById('LastName').value == null) {
			document.getElementById('LastName').focus();
			document.getElementById('LastName').style.borderColor = "red";
			document.getElementById('errorLastName').style.display = 'block';
			return false;
		} else {
			document.getElementById('LastName').style.borderColor = "#ccc";
			document.getElementById('errorLastName').style.display = 'none';
		}

		if (document.getElementById('AssessmentAgencyName').value == null) {
			document.getElementById('AssessmentAgencyName').focus();
			document.getElementById('AssessmentAgencyName').style.borderColor = "red";
			document.getElementById('AssessmentAgencyNameError').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessmentAgencyName').style.borderColor = "#ccc";
			document.getElementById('AssessmentAgencyNameError').style.display = 'none';
		}

		if (document.getElementById('AssessorCorrespondenceLine1').value == null) {
			document.getElementById('AssessorCorrespondenceLine1').focus();
			document.getElementById('AssessorCorrespondenceLine1').style.borderColor = "red";
			document.getElementById('errorAssessorCorrespondenceLine1').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorCorrespondenceLine1').style.borderColor = "#ccc";
			document.getElementById('errorAssessorCorrespondenceLine1').style.display = 'none';
		}

		if (document.getElementById('AssessorCorrespondenceLine2').value == null) {
			document.getElementById('AssessorCorrespondenceLine2').focus();
			document.getElementById('AssessorCorrespondenceLine2').style.borderColor = "red";
			document.getElementById('errorAssessorCorrespondenceLine2').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorCorrespondenceLine2').style.borderColor = "#ccc";
			document.getElementById('errorAssessorCorrespondenceLine2').style.display = 'none';
		}

		if (document.getElementById('AssessorCorrespondenceState').value == null) {
			document.getElementById('AssessorCorrespondenceState').focus();
			document.getElementById('AssessorCorrespondenceState').style.borderColor = "red";
			document.getElementById('AssessorCorrespondenceStateError').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorCorrespondenceState').style.borderColor = "#ccc";
			document.getElementById('AssessorCorrespondenceStateError').style.display = 'none';
		}

		if (document.getElementById('AssessorCorrespondenceDistrict').value == null) {
			document.getElementById('AssessorCorrespondenceDistrict').focus();
			document.getElementById('AssessorCorrespondenceDistrict').style.borderColor = "red";
			document.getElementById('AssessorCorrespondenceDistrictError').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorCorrespondenceDistrict').style.borderColor = "#ccc";
			document.getElementById('AssessorCorrespondenceDistrictError').style.display = 'none';
		}

		if (document.getElementById('AssessorCorrespondenceCity').value == null) {
			document.getElementById('AssessorCorrespondenceCity').focus();
			document.getElementById('AssessorCorrespondenceCity').style.borderColor = "red";
			document.getElementById('AssessorCorrespondenceCityError').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorCorrespondenceCity').style.borderColor = "#ccc";
			document.getElementById('AssessorCorrespondenceCityError').style.display = 'none';
		}

		if (document.getElementById('AssessorCorrespondencePincode').value == null) {
			document.getElementById('AssessorCorrespondencePincode').focus();
			document.getElementById('AssessorCorrespondencePincode').style.borderColor = "red";
			document.getElementById('errorAssessorCorrespondencePincode').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorCorrespondencePincode').style.borderColor = "#ccc";
			document.getElementById('errorAssessorCorrespondencePincode').style.display = 'none';
		}

		if (document.getElementById('AssessorPermanentEmail').value == null) {
			document.getElementById('AssessorPermanentEmail').focus();
			document.getElementById('AssessorPermanentEmail').style.borderColor = "red";
			document.getElementById('errorAssessorPermanentEmail').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorPermanentEmail').style.borderColor = "#ccc";
			document.getElementById('errorAssessorPermanentEmail').style.display = 'none';
		}

		if (document.getElementById('AssessorPermanentMobile').value == null) {
			document.getElementById('AssessorPermanentMobile').focus();
			document.getElementById('AssessorPermanentMobile').style.borderColor = "red";
			document.getElementById('errorAssessorPermanentMobile').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorPermanentMobile').style.borderColor = "#ccc";
			document.getElementById('errorAssessorPermanentMobile').style.display = 'none';
		}

		if (document.getElementById('AssessorPermanentLine1').value == null) {
			document.getElementById('AssessorPermanentLine1').focus();
			document.getElementById('AssessorPermanentLine1').style.borderColor = "red";
			document.getElementById('errorAssessorPermanentLine1').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorPermanentLine1').style.borderColor = "#ccc";
			document.getElementById('errorAssessorPermanentLine1').style.display = 'none';
		}

		if (document.getElementById('AssessorPermanentLine2').value == null) {
			document.getElementById('AssessorPermanentLine2').focus();
			document.getElementById('AssessorPermanentLine2').style.borderColor = "red";
			document.getElementById('errorAssessorPermanentLine2').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorPermanentLine2').style.borderColor = "#ccc";
			document.getElementById('errorAssessorPermanentLine2').style.display = 'none';
		}

		if (document.getElementById('AssessorrPermanentState').value == null) {
			document.getElementById('AssessorrPermanentState').focus();
			document.getElementById('AssessorrPermanentState').style.borderColor = "red";
			document.getElementById('AssessorrPermanentStateError').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorrPermanentState').style.borderColor = "#ccc";
			document.getElementById('AssessorrPermanentStateError').style.display = 'none';
		}

		if (document.getElementById('AssessorPermanentDistrict').value == null) {
			document.getElementById('AssessorPermanentDistrict').focus();
			document.getElementById('AssessorPermanentDistrict').style.borderColor = "red";
			document.getElementById('AssessorPermanentDistrictError').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorPermanentDistrict').style.borderColor = "#ccc";
			document.getElementById('AssessorPermanentDistrictError').style.display = 'none';
		}

		if (document.getElementById('AssessorPermanentCity').value == null) {
			document.getElementById('AssessorPermanentCity').focus();
			document.getElementById('AssessorPermanentCity').style.borderColor = "red";
			document.getElementById('AssessorPermanentCityError').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorPermanentCity').style.borderColor = "#ccc";
			document.getElementById('AssessorPermanentCityError').style.display = 'none';
		}

		if (document.getElementById('AssessorPermanentPincode').value == null) {
			document.getElementById('AssessorPermanentPincode').focus();
			document.getElementById('AssessorPermanentPincode').style.borderColor = "red";
			document.getElementById('AssessorPermanentPincodeError').style.display = 'block';
			return false;
		} else {
			document.getElementById('AssessorPermanentPincode').style.borderColor = "#ccc";
			document.getElementById('AssessorPermanentPincodeError').style.display = 'none';
		}

		if (document.getElementById('ReleventExpOfAuditInMonth').value == null) {
			document.getElementById('ReleventExpOfAuditInMonth').focus();
			document.getElementById('ReleventExpOfAuditInMonth').style.borderColor = "red";
			document.getElementById('ReleventExpOfAuditInMonthError').style.display = 'block';
			return false;
		} else {
			document.getElementById('ReleventExpOfAuditInMonth').style.borderColor = "#ccc";
			document.getElementById('ReleventExpOfAuditInMonthError').style.display = 'none';
		}

	}
</script>

<cf:form action="registrationAsssessor.fssai" name="myForm"
	method="POST" commandName="registrationFormAssessor">

	<!-- login form -->
	<div class="row">
		<div class="col-md-2 hidden-xs"></div>
		<div class="col-md-8  col-xs-12">
			<h3 class="text-capitalize heading-3-padding">Assessor
				Registration Form</h3>

			<!-- personal info -->
			<div class="personel-info">
				<fieldset>
					<legend>Personal Information</legend>
					<!-- left side -->
					<div class="col-md-6 col-xs-12">


						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.AadharNumber" /></strong></li>
									<li class="style-li error-red"><span id="aadhar_status"><label
										id="errorAadharNumber" class="error visibility">*
											error</label> <cf:errors path="AadharNumber" cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="AadharNumber" class="form-control" maxlength="12"
								placeholder="Aadhar Number" onblur="ck_aadhar('personalinformationassessor');"
								onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
						</div>
						<div class="form-group" style="display:none">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.UserId" /></strong></li>
									<li class="style-li error-red"><span id="name_status">
											<!-- <a href="userIdCheck.fssai" onclick="return loadonxml();">check availability</a> -->
											<span id="name_status"> </span> <label id="errorUserId"
											class="error visibility">* error</label> <cf:errors
												path="UserId" cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="UserId" 
								class="form-control" type="hidden" placeholder="User Id" value="${userId}" />
						</div>
						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.Title" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="TitleError">Please select
											title</label> <label id="errorTitle" class="error visibility">*
											error</label> <cf:errors path="Title" cssClass="error" /></li>
								</ul>
							</div>
							<cf:select path="Title" class="form-control">
								<cf:option value="0" label="Select Title" />
								<cf:options items="${titleList}" itemValue="titleId"
									itemLabel="titleName" />
							</cf:select>
						</div>
						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.DOB" /></strong></li>
									<li class="style-li error-red"><label id="errorDOB"
										class="error visibility">* error</label> <cf:errors path="DOB"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="DOB" type="text" readonly="true" class="form-control" id="dateP"
								placeholder="DOB" />
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.Gender" /></strong></li>
									<li class="style-li error-red"><label id="errorgender"
										class="error visibility">* error</label> <cf:errors
											path="gender" cssClass="error" /></li>
								</ul>
							</div>
							<label class="radio-inline"> <cf:radiobutton
									path="gender" value="M" checked="true" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<cf:radiobutton path="gender" value="F" />Female
							</label>
						</div>
					</div>
					<!-- right side -->
					<div class="col-md-6 col-xs-12">

						<!-- <div class="form-group" style = "height:120px;">
<div>
<div class = "profilePic" style = "width:30%; margin-top:25px; height:120px; border:1px solid gray;">

</div>
</div>

</div> -->





						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.FirstName" /></strong></li>
									<li class="style-li error-red"><label id="errorFirstName"
										class="error visibility">* error</label> <cf:errors
											path="FirstName" cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="FirstName"
								onkeyup="allLetter(this.id,this.value);" maxlength="50"
								class="form-control" placeholder="First Name" />
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.MiddleName" /></strong></li>
									<li class="style-li error-red"><label id="errorMiddleName"
										class="error visibility">* error</label> <cf:errors
											path="MiddleName" cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="MiddleName"
								onkeyup="allLetter(this.id,this.value);" maxlength="50"
								class="form-control" name="MiddleName" placeholder="Middle Name" />
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.LastName" /></strong></li>
									<li class="style-li error-red"><label id="errorLastName"
										class="error visibility">* error</label> <cf:errors
											path="LastName" cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="LastName"
								onkeyup="allLetter(this.id,this.value);" maxlength="50"
								class="form-control" placeholder="Last Name" />
						</div>


						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Assessor.AssesmentAgencyName" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="AssessmentAgencyNameError">
											* error</label> <cf:errors path="AssessmentAgencyName"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:select path="AssessmentAgencyName" class="form-control">
								<cf:option value="0" label="Select Assessment Agency" />
								<cf:options items="${assessmentAgencyNameList}"
									itemValue="manageAssessmentAgencyId"
									itemLabel="assessmentAgencyName" />
							</cf:select>
						</div>
					</div>
				</fieldset>
			</div>

			<div class="row" style="height: 20px;"></div>
			<!-- contact details -->
			<div class="personel-info">
				<fieldset>
					<legend>Correspondence Address</legend>
					<!-- permanent address -->
					<!--Left side-->
					<div class="col-md-6 col-xs-12">

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainer.TrainingCenterCorrespondenceLine1" /></strong></li>
									<li class="style-li error-red"><label
										id="errorAssessorCorrespondenceLine1" class="error visibility">*
											error</label> <cf:errors path="AssessorCorrespondenceLine1"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="AssessorCorrespondenceLine1" maxlength="100"
								class="form-control" placeholder="Address Line 1" />
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainer.TrainingCenterCrrespondenceLine2" /></strong></li>
									<li class="style-li error-red"><label
										id="errorAssessorCorrespondenceLine2" class="error visibility">*
											error</label> <cf:errors path="AssessorCorrespondenceLine2"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="AssessorCorrespondenceLine2" maxlength="100"
								class="form-control" placeholder="Address Line 1" />
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.correspondenceState" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="AssessorCorrespondenceStateError">
											* error</label> <cf:errors path="AssessorCorrespondenceState"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:select path="AssessorCorrespondenceState"
								class="form-control" onchange="getDistrict(this.value , 'AssessorCorrespondenceDistrict');">
								<cf:option value="0" label="Select State" />
								<cf:options items="${stateList}" itemValue="stateId"
									itemLabel="stateName" />
							</cf:select>
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.District" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility"
										id="AssessorCorrespondenceDistrictError"> * error</label> <cf:errors
											path="AssessorCorrespondenceDistrict" cssClass="error" /></li>
								</ul>
							</div>
							<cf:select path="AssessorCorrespondenceDistrict"
								class="form-control" onchange="getCity(this.value , 'AssessorCorrespondenceCity');">
								<cf:option value="0" label="Select District" />
							</cf:select>
						</div>
					</div>
					<!-- left side ends -->
					<!-- right side -->
					<div class="col-md-6 col-xs-12">

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.correspondenceCity" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="AssessorCorrespondenceCityError">
											* error</label> <cf:errors path="AssessorCorrespondenceCity"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:select path="AssessorCorrespondenceCity" class="form-control">
								<cf:option value="0" label="Select City" />
								<cf:options items="${cityList}" itemValue="cityId"
									itemLabel="cityName" />
							</cf:select>
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.correspondencePincode" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility"
										id="errorAssessorCorrespondencePincode"> * error</label> <cf:errors
											path="AssessorCorrespondencePincode" cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="AssessorCorrespondencePincode"
								onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
								placeholder="Pincode" class="form-control" maxlength="6" />
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.correspondenceEmail" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="errorAssessorPermanentEmail">
											* error</label> <cf:errors path="AssessorPermanentEmail"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="AssessorPermanentEmail" placeholder="Email Id"
								class="form-control" />
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.correspondenceMobile" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="errorAssessorPermanentMobile">
											* error</label> <cf:errors path="AssessorPermanentMobile"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="AssessorPermanentMobile"
								onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
								placeholder="Mobile Number" class="form-control" maxlength="10" />
						</div>
					</div>
					<!-- right side ends -->
					<!-- permanent address ends -->
					<!-- selection -->


					<!-- selection ends -->


				</fieldset>

				<br>
				<br>

				<fieldset>
					<legend>Permanent Address</legend>

					<div class="col-xs-12">
						<div class="col-md-12 col-sm-12 col-x-sm-12">
							<input type="checkbox" id="checkPermanent"
								onclick="myCheckPermanent(this)"> <label class="error">Is
								your correspondence address same as permanent address.</label>
						</div>

					</div>
					<!--Left side-->
					<div class="col-md-6 col-xs-12" id="permanent1">

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainer.TrainingCenterPermanentLine1" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="errorAssessorPermanentLine1">
											* error</label> <cf:errors path="AssessorPermanentLine1"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="AssessorPermanentLine1" maxlength="100"
								placeholder="Address Line 1" class="form-control" />
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainer.TrainingCenterPermanentLine2" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="errorAssessorPermanentLine2">
											* error</label> <cf:errors path="AssessorPermanentLine2"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="AssessorPermanentLine2" maxlength="100"
								placeholder="Address Line 2" class="form-control" />
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.State" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="AssessorrPermanentStateError">Please
											select state</label> <cf:errors path="AssessorrPermanentState"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:select path="AssessorrPermanentState" class="form-control"
								onchange="getDistrict(this.value , 'AssessorPermanentDistrict');">
								<cf:option value="0" label="Select State" />
								<cf:options items="${stateList}" itemValue="stateId"
									itemLabel="stateName" />
							</cf:select>
						</div>


					</div>
					<!-- left side ends -->
					<!-- right side -->
					<div class="col-md-6 col-xs-12" id="permanent2">
						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.District" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="AssessorPermanentDistrictError">Please
											select district</label> <cf:errors path="AssessorPermanentDistrict"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:select path="AssessorPermanentDistrict" class="form-control"
								onchange="getCity(this.value , 'AssessorPermanentCity');">
								<cf:option value="0" label="Select District" />
								<cf:options items="${districtList}" itemValue="districtId"
									itemLabel="districtName" />
							</cf:select>
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.City" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="AssessorPermanentCityError">Please
											select city</label> <cf:errors path="AssessorPermanentCity"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:select path="AssessorPermanentCity" class="form-control">
								<cf:option value="0" label="Select City" />
								<cf:options items="${cityList}" itemValue="cityId"
									itemLabel="cityName" />
							</cf:select>
						</div>

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Trainee.Pincode" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="AssessorPermanentPincodeError">Please
											select city</label> <cf:errors path="AssessorPermanentPincode"
											cssClass="error" /></li>
								</ul>
							</div>
							<cf:input path="AssessorPermanentPincode"
								onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
								placeholder="Pincode" class="form-control" maxlength="6" />
						</div>


					</div>
					<!-- right side ends -->
				</fieldset>



			</div>


			<!-- contact details ends -->
			<div class="row" style="height: 20px;"></div>
			<!-- Experience Detais -->
			<div class="personel-info">
				<fieldset>
					<legend>Experience Details</legend>
					<!-- left side -->
					<div class="col-md-6 col-xs-12">

						<div class="form-group">
							<div>
								<ul class="lab-no">
									<li class="style-li"><strong><cs:message
												code="lbl.Assessor.RelevantExperienceOfAudit" /></strong></li>
									<li class="style-li error-red"><label
										Class="error visibility" id="ReleventExpOfAuditInMonthError">*
											error</label></li>
								</ul>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<cf:input cssClass="form-control" place-holder="Years"
										path="ReleventExpOfAuditInYear" maxlength="2"
										onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
								</div>
								<div class="col-xs-6">
									<cf:select path="ReleventExpOfAuditInMonth"
										class="form-control">
										<cf:option value="0" label="Select Month" />
										<cf:option value="1" label="1" />
										<cf:option value="2" label="2" />
										<cf:option value="3" label="3" />
										<cf:option value="4" label="4" />
										<cf:option value="5" label="5" />
										<cf:option value="6" label="6" />
										<cf:option value="7" label="7" />
										<cf:option value="8" label="8" />
										<cf:option value="9" label="9" />
										<cf:option value="10" label="10" />
										<cf:option value="11" label="11" />
									</cf:select>
								</div>
							</div>
						</div>

					</div>
					<!-- left side ends -->

					<!-- right side -->
					<div class="col-md-6 col-xs-12">
						<div class="form-group">
							<label>How Many assessment can you conduct in a Month ?</label>
							<cf:input path="HowManyAssessmentConductInAMonth"
								class="form-control" placeholder="Session Number" maxlength="2"
								onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
						</div>


					</div>
					<!-- right side ends -->
				</fieldset>
			</div>
			<div class="row" style="height: 20px;"></div>
			<!-- Basic courses -->
			<div class="personel-info">
				<h4>Courses wish to conduct assessment on it ?</h4>
				<fieldset>
					<legend>Basic Courses</legend>
					<!-- left -->
					<div class="col-md-6 col-xs-12" style="width: 100%;">


						<div class="checkbox">
							<ct:if test="${not empty basicCourseList }">
								<ct:forEach var="listValue" items="${basicCourseList}">
									<ct:if test="${listValue[0] == 1}">
										<label> <input type="checkbox"
											value="${listValue[2] }" name="basicCourses"
											id="${listValue[2] }" onclick=" return myBasic();">${listValue[1]}
										</label>
										<br>
									</ct:if>
								</ct:forEach>
							</ct:if>

							<cf:hidden path="BasicCourse1" value="" />
						</div>
					</div>
					<!-- right -->
					<div class="col-md-6 col-xs-12"></div>
				</fieldset>
			</div>
			<!-- basic course -->
			<!-- Advanced courses -->
			<div class="personel-info">
				<fieldset>
					<legend>Advanced Courses</legend>
					<!-- left -->
					<div class="col-md-6 col-xs-12" style="width: 100%;">
						<div class="checkbox">
							<ct:if test="${not empty basicCourseList }">
								<ct:forEach var="listValue" items="${basicCourseList}">
									<ct:if test="${listValue[0] == 2}">
										<label> <input type="checkbox"
											value="${listValue[2] }" name="AdvanceCourse"
											id="${listValue[2] }" onclick=" return myAdvance();">${listValue[1]}
										</label>
										<br>
									</ct:if>
								</ct:forEach>
							</ct:if>
							<cf:hidden path="AdvanceCourse1" value="" />
						</div>
						<!-- right -->
						<div class="col-md-6 col-xs-12"></div>
					</div>
				</fieldset>
			</div>
			<!-- advanced course -->

			<!-- special courses -->
			<div class="personel-info">
				<fieldset>
					<legend>Special Courses</legend>
					<!-- left -->
					<div class="col-md-6 col-xs-12" style="width: 100%;">
						<div class="checkbox">
							<ct:if test="${not empty basicCourseList }">
								<ct:forEach var="listValue" items="${basicCourseList}">
									<ct:if test="${listValue[0] == 3}">
										<label> <input type="checkbox"
											value="${listValue[2] }" name="SpecialCourse"
											id="${listValue[2] }" onclick=" return mySpecial();">${listValue[1]}
										</label>
										<br>
									</ct:if>
								</ct:forEach>
							</ct:if>
							<cf:hidden path="SpecialCourse1" value="" />
						</div>
					</div>
					<!-- right -->
					<div class="col-md-6 col-xs-12"></div>
				</fieldset>
			</div>
			<!-- special course -->
			<div class="row" style="height: 20px;"></div>
			<div
				style="width: 95%; margin-left: 32px; float: left; height: 100px; border: 1px solid #cecece;"
				class="form-group">
				<div style="float: left">
					<div style="float: left; width: 98%;">
						<label id="captchaError"
							style="float: left; width: 99%; font-family: Calibri; margin-left: 0px;">Please
							enter captcha in below textbox !!!</label>
					</div>

					<div style="float: left; width: 99%;">

						<input type="text" id="txtCaptcha"
							style="background-image: url(1.jpg); text-align: center; border: none; width: 140px; margin-left: 8px; font-weight: bold; font-family: Modern"
							disabled="disabled" /> <input type="button" id="btnrefresh"
							value="Refresh" onclick="DrawCaptcha();" /> <input type="text"
							id="txtInput" placeholder="Captcha" style="width: 140px;"/ >

					</div>
				</div>
				<div style="float: left; width: 99%;">
					<input type="checkbox" id="check" style="margin-left: 1%;">
					<!-- <a href="#" target="_blank" class="terms-font-size"> -->
					I have read and understood the Terms & Conditions and the Privacy
					Policy of FSSAI.
					<!-- </a> -->
				</div>
			</div>



			<div class="col-xs-12"></div>
			<div class="col-md-4 hidden-xs"></div>
			<div class="col-md-4 col-xs-12" id="register">
				<div class="pull-right">
					<div class="form-group">
						<input type="submit" class="form-control login-btn"
							value="Register" onclick="return ValidCaptcha();">
					</div>
				</div>
			</div>
			<div class="col-md-4 hidden-xs"></div>

		</div>
		<div class="col-md-2 hidden-xs"></div>
	</div>
</cf:form>