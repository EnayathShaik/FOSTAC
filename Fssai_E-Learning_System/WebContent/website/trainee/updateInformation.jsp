<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="website/js/commonController.js"></script>
<script>
function getDistrict(val) {
		////alert('jjh');
		$.ajax({
			type : 'post',

			url : 'loadDistrict.jspp?' + val,
			success : function(response) {
				var mainData1 = jQuery.parseJSON(response);

				$('#correspondenceDistrict option').remove();
				$('#correspondenceDistrict').append(
						'<option value="0" label="Select District" />');
				$('#correspondenceCity option').remove();
				$('#correspondenceCity').append(
						'<option value="0" label="Select City" />');

				$.each(mainData1, function(i, obj) {
					$('#correspondenceDistrict').append(
							'<option value='+obj.districtId+' >'
									+ obj.districtName + '</option>');
				});
			}
		});
	}

	function getCity(val) {
		$.ajax({
			type : 'post',
			url : 'loadCity.jspp?' + val,
			success : function(response) {
				var mainData1 = jQuery.parseJSON(response);
				$('#correspondenceCity option').remove();
				$('#correspondenceCity').append(
						'<option value="0" label="Select City" />');
				$.each(mainData1, function(i, obj) {
					$('#correspondenceCity').append(
							'<option value='+obj.cityId+' >' + obj.cityName
									+ '</option>');
				});
			}
		});
	}

	function getDistrict1(val) {
		////alert('jjh');
		$.ajax({
			type : 'post',

			url : 'loadDistrict.jspp?' + val,
			success : function(response) {
				var mainData1 = jQuery.parseJSON(response);

				$('#residentialDistrict option').remove();
				$('#residentialDistrict').append(
						'<option value="0" label="Select District" />');
				$('#resCity option').remove();
				$('#resCity')
						.append('<option value="0" label="Select City" />');

				$.each(mainData1, function(i, obj) {
					$('#residentialDistrict').append(
							'<option value='+obj.districtId+' >'
									+ obj.districtName + '</option>');
				});
			}
		});
	}

	function getCity1(val) {
		$.ajax({
			type : 'post',
			url : 'loadCity.jspp?' + val,
			success : function(response) {
				var mainData1 = jQuery.parseJSON(response);
				$('#resCity option').remove();
				$('#resCity')
						.append('<option value="0" label="Select City" />');
				$.each(mainData1, function(i, obj) {
					$('#resCity').append(
							'<option value='+obj.cityId+' >' + obj.cityName
									+ '</option>');

				});
			}
		});
	}

	function getDistrict2(val) {
		////alert('jjh');
		$.ajax({
			type : 'post',

			url : 'loadDistrict.jspp?' + val,
			success : function(response) {
				var mainData1 = jQuery.parseJSON(response);

				$('#bussDistrict option').remove();
				$('#bussDistrict').append(
						'<option value="0" label="Select District" />');
				$('#bussCity option').remove();
				$('#bussCity').append(
						'<option value="0" label="Select City" />');

				$.each(mainData1, function(i, obj) {

					$('#bussDistrict').append(
							'<option value='+obj.districtId+'>'
									+ obj.districtName + '</option>');
				});
			}
		});
	}

	function getCity2(val) {
		$.ajax({
			type : 'post',
			url : 'loadCity.jspp?' + val,
			success : function(response) {
				var mainData1 = jQuery.parseJSON(response);
				$('#bussCity option').remove();
				$('#bussCity').append(
						'<option value="0" label="Select City" />');
				$.each(mainData1, function(i, obj) {

					$('#bussCity').append(
							'<option value='+obj.cityId+' >' + obj.cityName
									+ '</option>');
				});
			}
		});
	}
	</script>


<script language="javascript" type="text/javascript">
	function myBusiness() {
		var x = document.getElementById("KindOfBusiness").value;
		if ($('[id*=KindOfBusiness] option:selected').text() == 'Not in business') {
			document.getElementById("businessID1").style.display = 'none';
			document.getElementById("businessID2").style.display = 'none';
			document.getElementById("businessID3").style.display = 'none';
		} else {
			document.getElementById("businessID1").style.display = 'block';
			document.getElementById("businessID2").style.display = 'block';
			document.getElementById("businessID3").style.display = 'block';
		}

	}
	function updatemessage() {
		document.getElementById("update").value = "";
	}
	function myCorrespondence() {
		residential1.style.display = checkCorrespondence.checked ? "none"
				: "block";
		residential2.style.display = checkCorrespondence.checked ? "none"
				: "block";
		var x = document.getElementById('checkCorrespondence').checked;
		var y = document.getElementById("correspondenceState").selectedIndex;
		var z = document.getElementById("correspondenceCity").selectedIndex;
		var v = document.getElementById("correspondenceDistrict").selectedIndex;
		////alert(z + "    " + y);
		if (x) {
			/* document.getElementById('Email').value= document.getElementById('correspondenceEmail').value; */
			document.getElementById('ResidentialAddressLine1').value = document
					.getElementById('correspondenceAddress1').value;
			document.getElementById('ResidentialAddressLine2').value = document
					.getElementById('correspondenceAddress2').value;
			/* document.getElementById('Mobile').value= document.getElementById('correspondenceMobile').value; */
			document.getElementById('resPincode').value = document
					.getElementById('correspondencePincode').value;
			document.getElementById('resState').selectedIndex = y;
			document.getElementById('resDistrict').selectedIndex = v;
			document.getElementById('resCity').selectedIndex = z;

		} else {
			
			document.getElementById('ResidentialAddressLine1').value = '${loginUser.residentialLine1 }';
			document.getElementById('ResidentialAddressLine2').value = '${loginUser.residentialLine2 }';
			
		}
	}

	

	function checkname() {
		var name = document.getElementById("userId").value;

		if (name) {
			$
					.ajax({
						type : 'post',
						url : 'checkdata.jspp?' + name,
						data : {
							user_name : name,
						},
						success : function(response) {
							$('#name_status').html(response);
							if (response == "OK") {
								document.getElementById("register").style.display = 'none';
								return true;
							} else {
								document.getElementById("register").style.display = 'block';
								return false;
							}
						}
					});
		} else {
			$('#name_status').html("");
			document.getElementById("register").style.display = 'none';
			return false;
		}
	}
</script>
<script type="text/javascript">
	function OnStart() {

		updateState();

	}
	window.onload = OnStart;
</script>
<script>
	function updateState() {
		var cs = '${loginUser.correspondenceState.stateId }';

		var cd = '${loginUser.correspondenceDistrict.districtId}';
		//alert('cd is'+cd);
		var cc = '${loginUser.correspondenceCity.cityId}';
		var ps = '${loginUser.resState.stateId}';
		var pd = '${loginUser.residentialDistrict.districtId}';
		var pc = '${loginUser.resCity.cityId}';
		var bs = '${loginUser.bussState.stateId}';
		var bd = '${loginUser.bussDistrict.districtId}';
		var bc = '${loginUser.bussCity.cityId}';
		var kob = '${loginUser.kindOfBusiness.kindOfBusinessId}';
		var checkpermanent = '${loginUser.checkPermanent}';
		var designation = '${loginUser.designation}';
		/* $("#Designation").prop('selectedIndex',designation); */
		Designation.options[0].text = designation;
		//alert(checkpermanent);
		if (checkpermanent) {
			//alert("Inside If");
			document.getElementById('checkCorrespondence').checked = true;
			residential1.style.display = checkCorrespondence.checked ? "none"
					: "block";
			residential2.style.display = checkCorrespondence.checked ? "none"
					: "block";
		}

		var checkbusiness = '${loginUser.checkCompany}';
		if (checkbusiness) {
			document.getElementById('checkCompany').checked = true;
			businessID3.style.display = checkCompany.checked ? "none" : "block";
			businessID2.style.display = checkCompany.checked ? "none" : "block";
		}
		$("#KindOfBusiness").prop('value', kob);
		if ($('[id*=KindOfBusiness] option:selected').text() == 'Not in business') {
			myBusiness();
		}
		
		//alert("cs");
		//alert(cs + ' '+cd+' '+cc+' '+ps+' '+pd+' '+pc+' '+bd+' '+bs+' '+bc+' '+checkpermanent+' '+checkbusiness+' '+designation);

		getStateUpdate(cs, cd, cc);
		getStateUpdateP(ps, pd, pc);
		getStateUpdateB(bs, bd, bc);

	}
</script>
<script>
	function getStateUpdate(cs, cd, cc) {
		$
				.ajax({
					type : 'post',
					url : 'getStateUpdate.jspp',
					success : function(response) {
						var mainData2 = jQuery.parseJSON(response);
						$('#correspondenceState option').remove();
						$('#correspondenceState')
								.append(
										'<option value="0" label="Select Stateeeeee" />');

						$
								.each(
										mainData2,
										function(i, obj) {
											if (cs == obj.stateId) {
												$('#correspondenceState')
														.append(
																'<option selected="true" value='+obj.stateId+' >'+obj.stateName+'</option>');
											} else {
												$('#correspondenceState')
														.append(
																'<option value='+obj.stateId+'>'+obj.stateName+'</option>');
											}
										});
						
					}
				});
		getDistrictUpdate(cs, cd, cc);
	}
	function getDistrictUpdate(cs, cd, cc) {
		$
				.ajax({
					type : 'post',
					url : 'getDistrictUpdate.jspp?' + cs,
					success : function(response) {
						var mainData1 = jQuery.parseJSON(response);
						$('#correspondenceDistrict option').remove();
						$('#correspondenceDistrict').append(
								'<option value="0" label="Select District" />');

						$
								.each(
										mainData1,
										function(i, obj) {
											if (cd == obj.districtId) {
												$('#correspondenceDistrict')
														.append(
																'<option selected="true" value='+obj.districtId+'>'+obj.districtName+' </option>');
											} else {
												$('#correspondenceDistrict')
														.append(
																'<option value='+obj.districtId+'>'+obj.districtName+' </option>');
											}
										});
					}
				});
		getCityUpdate(cd, cc);
	}
	function getCityUpdate(cd, cc) {
		$
				.ajax({
					type : 'post',
					url : 'getCityUpdate.jspp?' + cd,
					success : function(response) {
						var mainData1 = jQuery.parseJSON(response);
						$('#correspondenceCity option').remove();
						$('#correspondenceCity').append(
								'<option value="0" label="Select City" />');

						$
								.each(
										mainData1,
										function(i, obj) {
											if (cc == obj.cityId) {
												$('#correspondenceCity')
														.append(
																'<option selected="true" value='+obj.cityId+'>'+obj.cityName+' </option>');
											} else {
												$('#correspondenceCity')
														.append(
																'<option value='+obj.cityId+'>'+obj.cityName+' </option>');
											}
										});
					}
				});

		//alert("hhhhhh");
	}
</script>
<script>
	function getStateUpdateP(ps, pd, pc) {
		$
				.ajax({
					type : 'post',
					url : 'getStateUpdate.jspp',
					success : function(response) {
						var mainData2 = jQuery.parseJSON(response);
						$('#resState option').remove();
						$('#resState').append(
								'<option value="0" label="Select State" />');

						$
								.each(
										mainData2,
										function(i, obj) {
											if (ps == obj.stateId) {
												$('#resState')
														.append(
																'<option selected="true" value='+obj.stateId+'>'+obj.stateName+'</option>');
											} else {
												$('#resState')
														.append(
																'<option value='+obj.stateId+'>'+obj.stateName+'</option>');
											}
										});
					}
				});
		getDistrictUpdateP(ps, pd, pc);
	}
</script>
<script>
	function getDistrictUpdateP(ps, pd, pc) {
		$
				.ajax({
					type : 'post',
					url : 'getDistrictUpdate.jspp?' + ps,
					success : function(response) {
						var mainData1 = jQuery.parseJSON(response);
						$('#residentialDistrict option').remove();
						$('#residentialDistrict').append(
								'<option value="0" label="Select District" />');

						$
								.each(
										mainData1,
										function(i, obj) {
											if (pd == obj.districtId) {
												$('#residentialDistrict')
														.append(
																'<option selected="true" value='+obj.districtId+'>'+obj.districtName+' </option>');
											} else {
												$('#residentialDistrict')
														.append(
																'<option value='+obj.districtId+'>'+obj.districtName+' </option>');
											}
										});
					}
				});
		getCityUpdateP(pd, pc);
	}
</script>
<script>
	function getCityUpdateP(pd, pc) {
		//alert('in city');
		$
				.ajax({
					type : 'post',
					url : 'getCityUpdate.jspp?' + pd,
					success : function(response) {
						var mainData1 = jQuery.parseJSON(response);
						$('#resCity option').remove();
						$('#resCity').append(
								'<option value="0" label="Select District" />');

						$
								.each(
										mainData1,
										function(i, obj) {
											if (pc == obj.cityId) {
												$('#resCity')
														.append(
																'<option selected="true" value='+obj.cityId+'>'+obj.cityName+' </option>');
											} else {
												$('#resCity')
														.append(
																'<option value='+obj.cityId+'>'+obj.cityName+' </option>');
											}
										});
					}
				});
	}
</script>
<script>
	function getStateUpdateB(bs, bd, bc) {
		$
				.ajax({
					type : 'post',
					url : 'getStateUpdate.jspp',
					success : function(response) {
						var mainData2 = jQuery.parseJSON(response);
						$('#bussState option').remove();
						$('#bussState').append(
								'<option value="0" label="Select State" />');

						$
								.each(
										mainData2,
										function(i, obj) {
											if (bs == obj.stateId) {
												$('#bussState')
														.append(
																'<option selected="true" value='+obj.stateId+'>'+obj.stateName+'</option>');
															
											} else {
												$('#bussState')
														.append(
																'<option value='+obj.stateId+'>'+obj.stateName+'</option>');
											}
										});
					}
				});
		getDistrictUpdateB(bs, bd, bc);
	}
</script>
<script>
	function getDistrictUpdateB(bs, bd, bc) {
		$
				.ajax({
					type : 'post',
					url : 'getDistrictUpdate.jspp?' + bs,
					success : function(response) {
						var mainData1 = jQuery.parseJSON(response);
						$('#bussDistrict option').remove();
						$('#bussDistrict').append(
								'<option value="0" label="Select District" />');

						$
								.each(
										mainData1,
										function(i, obj) {
											if (bd == obj.districtId) {
												$('#bussDistrict')
														.append(
																'<option selected="true" value='+obj.districtId+'>'+obj.districtName+' </option>');
											} else {
												$('#bussDistrict')
														.append(
																'<option value='+obj.districtId+'>'+obj.districtName+' </option>');
											}
										});
					}
				});
		getCityUpdateB(bd, bc);
	}
</script>
<script>
	function getCityUpdateB(bd, bc) {
		$
				.ajax({
					type : 'post',
					url : 'getCityUpdate.jspp?' + bd,
					success : function(response) {
						var mainData1 = jQuery.parseJSON(response);
						$('#bussCity option').remove();
						$('#bussCity').append(
								'<option value="0" label="Select District" />');

						$
								.each(
										mainData1,
										function(i, obj) {
											if (bc == obj.cityId) {
												$('#bussCity')
														.append(
																'<option selected="true" value='+obj.cityId+'>'+obj.cityName+' </option>');
											} else {
												$('#bussCity')
														.append(
																'<option value='+obj.cityId+'>'+obj.cityName+' </option>');
											}
										});
					}
				});
		//alert('bc end');
	}
</script>

<script>
   
	function myCompany(val) {
		//alert("Inside My Company");
		businessID3.style.display = checkCompany.checked ? "none" : "block";
		businessID2.style.display = checkCompany.checked ? "none" : "block";
		var x = document.getElementById('checkCompany').checked;
		var s = $("#correspondenceState").val();
		var d = $("#correspondenceDistrict").val();
		var c = $("#correspondenceCity").val();
		if (x) {
			document.getElementById('BusinessAddressLine1').value = document
					.getElementById('correspondenceAddress1').value;
			document.getElementById('BusinessAddressLine2').value = document
					.getElementById('correspondenceAddress2').value;
			document.getElementById('bussPincode').value = document
					.getElementById('correspondencePincode').value;
			document.getElementById('bussState').value = s;
			document.getElementById('bussDistrict').value = d;
			document.getElementById('bussCity').value = c;

		} else {
			
		}
	}

</script>


<cf:form action="updateTrainee.fssai?id=${loginUser.id}" name="myForm" method="POST"
	commandName="updateInformation" onsubmit="return validateFields();">
	<section>
		<%@include file="../roles/top-menu.jsp"%>
	</section>

	<!-- main body -->
	<section class="main-section-margin-top">
		<div class="container-fluid">
			<div id="wrapper">

				<!-- Sidebar menu -->
				<%@include file="../roles/slider.jsp" %>
				<!-- Sidebar menu -->
				<!-- /#sidebar-wrapper -->
				<!-- Page Content -->
				<div id="page-content-wrapper">
					<div class="container-fluid">
						<!-- vertical button -->
						<div class="row">
							<div class="col-lg-12">
								<a href="#menu-toggle" class="vertical-menu-position-btn"
									id="menu-toggle"> <i class="fa fa-bars"> <span
										style="font-size: 14px;">Welcome Trainee</span>
								</i>
								</a>
							</div>
						</div>
						<!-- add the content here for main body -->
						<!-- timeline  -->
						<section class="section-form-margin-top">
							<div class="container">
								<!-- login form -->
								<div class="row btm-margin">
									<div class="col-md-6  col-xs-12">
										<h3 class="text-capitalize heading-3-padding">Update
											Information for Trainee</h3>
										<strong style="color: red">${update}</strong>
									</div>
								</div>
							</div>
						</section>
						<section class="section-form-margin-top">
							<!-- login form -->
							<div class="row">
								<div class="col-xs-12">
									<!-- personel info Start -->
									<div class="personel-info">
										<fieldset>
											<legend>
												<h3>Personal Information</h3>
											</legend>
											<!-- left side -->
											<div class="col-md-6 col-xs-12">
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>User Id:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<input type="text" class="form-control"
														placeholder="User ID" disabled="disabled"
														value=" ${loginUser.loginDetails.loginId}">
												</div>
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Aadhar:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<input type="text" class="form-control"
														placeholder="Aadhar Number" disabled="disabled"
														value=" ${loginUser.aadharNumber}">
												</div>
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Date of Birth:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<input type="text" class="form-control" placeholder="Date"
														disabled="disabled" value="${loginUser.dob }">
												</div>
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.Gender" /></strong></li>
															<li class="style-li error-red"><cf:errors
																	path="gender" cssClass="error" /></li>
														</ul>
													</div>
													<label class="radio-inline"> <cf:radiobutton
															path="gender" id="male" value="M" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<cf:radiobutton id="female" path="gender" value="F" />Female
														</td>
													</label>
												</div>
											</div>

											<!-- right side -->
											<div class="col-md-6 col-xs-12">
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Title:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<cf:select path="Title" class="form-control"
														disabled="true">
														
<cf:options items="${titleList}" itemValue="titleId" itemLabel="titleName" />
														 
													</cf:select>
												</div>
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>First Name:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<input type="text" class="form-control"
														placeholder="First Name" disabled="disabled"
														value="${loginUser.firstName }">
												</div>
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Middle Name:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<input type="text" class="form-control"
														placeholder="Middle Name" disabled="disabled"
														value="${loginUser.middleName }">
												</div>
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Last Name:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<input type="text" class="form-control"
														placeholder="Last Name" disabled="disabled"
														value="${loginUser.lastName }">
												</div>
											</div>
										</fieldset>
									</div>
									<!-- personel info End-->
									<div class="row" style="height: 20px;"></div>
									<div class="personel-info">
										<fieldset>
											<legend>
												<h3>Correspondence Contact Details</h3>
											</legend>
											<!--Left side-->
											<div class="col-md-6 col-xs-12">
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.correspondenceAddress1" /></strong></li>
															<li class="style-li error-red"><cf:errors
																	path="correspondenceAddress1" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="correspondenceAddress1"
														class="form-control" placeholder="Address "
														value="${loginUser.correspondenceAddress1}"
														maxlength="100" />
												</div>


												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.correspondenceAddress2" /></strong></li>
															<li class="style-li error-red"><cf:errors
																	path="correspondenceAddress2" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="correspondenceAddress2"
														class="form-control" placeholder="Address 2"
														value="${loginUser.correspondenceAddress2}"
														maxlength="100" />
												</div>



												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>State:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
														<!--  <select class="form-control">
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select>-->
													</div>
													<cf:select path="correspondenceState" class="form-control"
														onchange="getDistrict(this.value , 'correspondenceDistrict');">
														<cf:option value="0" label="Select State" />
														<cf:options items="${stateList}" itemValue="stateId"
															itemLabel="stateName" />
													</cf:select>
												</div>



												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Email</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<cf:input id="Email" path="Email" placeholder="Email"
														class="form-control" value="${loginUser.email}"
														type="text" />

												</div>






											</div>
											<!--Left side-->
											<!--Right side-->
											<div class="col-md-6 col-xs-12">


												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>District:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<!--  <select class="form-control">
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select>   -->
													<cf:select path="correspondenceDistrict"
														class="form-control" onchange="getCity(this.value , 'correspondenceCity');">
														<cf:option value="0" label="Select District" />
														<%-- <cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName" /> --%>
													</cf:select>
												</div>


												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>City:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<!--  <select class="form-control">
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select> -->
													<cf:select path="correspondenceCity" class="form-control"
														onchange="return myBusiness()">
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
															<li class="style-li error-red"><cf:errors
																	path="correspondencePincode" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="correspondencePincode"
														value="${loginUser.correspondencePincode}"
														onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
														placeholder="Pincode" class="form-control" maxlength="6" />
												</div>


												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Mobile:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<input id="mobile" name="mobile" placeholder="Mobile"
														class="form-control" value="${loginUser.mobile}"
														type="text"
														onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
														maxlength="10">

												</div>

												<!-- <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>Location:</strong></li>
                            <li class="style-li error-red"></li>
                          </ul>
                        </div>
                        <input type="text" class="form-control" placeholder="Location" >
                      </div> -->
											</div>
											<!--Right side-->

										</fieldset>
									</div>
									<!-- Contact details End-->


									<div class="row" style="height: 20px;"></div>

									<!-- Contact details Start -->
									<div class="personel-info">
										<fieldset>
											<legend>
												<h3>Permanent Contact Details</h3>
											</legend>
											<div class="col-md-12 col-xs-12" id=residential>
												<cf:checkbox id="checkCorrespondence"
													path="checkCorrespondence" onclick="myCorrespondence(this)" />
												<label class="error">Is your permanent address same
													as correspondence address.</label>
											</div>




											<!--Left side-->
											<div id="residential1" class="col-md-6 col-xs-12">



												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.ResidentialAddressLine1" /></strong></li>
															<li class="style-li error-red"><cf:errors
																	path="ResidentialAddressLine1" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="ResidentialAddressLine1"
														placeholder="Residential Address Line 2"
														class="form-control"
														value="${loginUser.residentialLine1 }" maxlength="100" />
												</div>


												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.ResidentialAddressLine2" /></strong></li>
															<li class="style-li error-red"></strong><cf:errors
																		path="ResidentialAddressLine2" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="ResidentialAddressLine2"
														value="${loginUser.residentialLine2}"
														placeholder="Residential Address Line 2"
														class="form-control" maxlength="100" />
												</div>


												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.State" /></strong></li>
															<li class="style-li error-red"><cf:errors
																	path="resState" cssClass="error" /></li>
														</ul>
														<!--  <select class="form-control">
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select> -->
													</div>
													<%-- <cf:select path="resState" class="form-control state">
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
</cf:select> --%>
													<cf:select path="resState" class="form-control state"
														onchange="getDistrict(this.value , 'residentialDistrict');">
														<cf:option value="0" label="Select State" />
														<cf:options items="${stateList}" itemValue="stateId"
															itemLabel="stateName" />
													</cf:select>
												</div>

											</div>
											<!--Left side-->
											<!--Right side-->


											<div id="residential2" class="col-md-6 col-xs-12">


												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>District:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<cf:select path="residentialDistrict" class="form-control"
														onchange="getCity(this.value , 'resCity');">
														<cf:option value="0" label="Select District" />
														<cf:options items="${districtList}" itemValue="districtId"
															itemLabel="districtName" />
													</cf:select>

												</div>



												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Closest City:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
		
													<cf:select path="resCity" class="form-control">
														<cf:option value="0" label="Select City" />
														<cf:options items="${cityList}" itemValue="cityId"
															itemLabel="cityName" />
													</cf:select>
												</div>



												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Pin Code:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<cf:input id="resPincode" path="resPincode"
														class="form-control" placeholder="Pin Code"
														value="${loginUser.resPincode}"
														onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
														maxlength="6" />
												</div>
											</div>
											<!--Right side-->

										</fieldset>
									</div>
									<!-- Contact details End-->
									<!-- Contact details Start -->

									<div style="margin-top: 20px;"></div>
									<div class="personel-info">
										<fieldset>
											<legend>
												<h3>Kind of Business</h3>
											</legend>


											<div class="col-md-6 col-xs-12">
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Select Kind of
																	Business:</strong></li>
														</ul>
													</div>
													<cf:select path="KindOfBusiness" class="form-control"
														onchange="return myBusiness()">
														<cf:option value="0" label="Select Business" />
														<cf:options items="${kindOfBusinessList}"
															itemValue="kindOfBusinessId"
															itemLabel="kindOfBusinessName" />
													</cf:select>
												</div>
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Designation:</strong> <a
																href="#myModal" data-toggle="modal"
																data-target="#myModal">Do you want?</a></li>
														</ul>
													</div>
													<div class="modal fade" id="myModal" role="dialog">
														<div class="modal-dialog">
															<!-- Modal content-->
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal">×</button>
																	<h4 class="modal-title">Designation</h4>
																</div>
																<div class="modal-body">
																	<table align="center" width="200" border="0"
																		class="table table-bordered table-responsive table-hover table-striped">
																		<thead>
																			<tr>
																				<th bgcolor="#0033CC" style="color: #fff;">Designation</th>
																				<th bgcolor="#0033CC" style="color: #fff;">Example</th>
																			</tr>
																		</thead>
																		<tbody>
																			<tr>
																				<td>Food Handler</td>
																				<td>Example</td>
																			</tr>
																			<tr>
																				<td>Food Safety Supervisior</td>
																				<td>Example</td>
																			</tr>
																			<tr>
																				<td>Food Safety Manager</td>
																				<td>Example</td>
																			</tr>
																			<tr>
																				<td>Other</td>
																				<td>Example</td>
																			</tr>
																		</tbody>
																	</table>
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn login-btn"
																		data-dismiss="modal">Close</button>
																</div>
															</div>
														</div>
													</div>
													<script>
														console.log("designation selected:");
													</script>
													<cf:select path="Designation" class="form-control" >
														<cf:option value="0" label="Select" />
														<cf:option value="Food Handler" label="Food Handler" />
														<cf:option value="Food Safety Supervisior"
															label="Food Safety Supervisior" />
														<cf:option value="Food Safety Manager"
															label="Food Safety Manager" />
														<cf:option value="Other" label="Other" />
													</cf:select>
												</div>
											</div>

											<!-- right side start -->

											<div class="col-md-6 col-xs-12">
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Company Name:</strong></li>
														</ul>
													</div>
													<cf:input id="CompanyName" path="CompanyName"
														class="form-control" placeholder="Company Name"
														required="" value="${loginUser.companyName}"
														maxlength="50" />
												</div>
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Registration
																	Number:</strong></li>
														</ul>
													</div>
													<cf:input id="registrationNo" path="registrationNo"
														value="${loginUser.registrationNo }" class="form-control"
														placeholder="Number" maxlength="50" />
												</div>

											</div>






										</fieldset>
									</div>
									<div style="height: 20px;"></div>
									<!-- Business address Start -->
									<div class="personel-info ">
										<fieldset>
											<legend>
												<h3>Business Details</h3>
											</legend>
											<div class="col-md-12 col-xs-12 " id="businessID1">
												<cf:checkbox path="checkCompany" id="checkCompany"
													onclick="myCompany(this.value)" />
												<label class="error">Is your company address same as
													correspondence address.</label>
											</div>
											<!--Left side-->
											<div class="col-md-6 col-xs-12" id="businessID2">




												<div class="form-group">

													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.BusinessAddressLine1" /></strong></li>
															<li class="style-li error-red"><cf:errors
																	path="BusinessAddressLine1" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="BusinessAddressLine1" class="form-control"
														placeholder="Business Address Line 1"
														value="${loginUser.businessAddressLine1}" maxlength="100" />
												</div>


												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.BusinessAddressLine2" /></strong></li>
															<li class="style-li error-red"><cf:errors
																	path="BusinessAddressLine2" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="BusinessAddressLine2" class="form-control"
														placeholder="Business Address Line 2"
														value="${loginUser.businessAddressLine2}" maxlength="100" />
												</div>

												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>State:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<!--   <select class="form-control">
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select> -->
													<cf:select path="bussState" class="form-control"
														onchange="getDistrict(this.value , 'bussDistrict');">
														<cf:option value="0" label="Select State" />
														<cf:options items="${stateList}" itemValue="stateId"
															itemLabel="StateName" />
													</cf:select>
												</div>

											</div>
											<!--Left side-->


											<!--Right side-->
											<div class="col-md-6 col-xs-12" id="businessID3">



												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>District:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
				
													<select id="bussDistrict" name="bussDistrict"
														class="form-control" onchange="getCity(this.value , 'bussCity');">
														<option value="0" selected="selected">Select
															District</option>

													</select>

												</div>



												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Closest City:</strong></li>
															<li class="style-li error-red"></li>
														</ul>
													</div>
													<cf:select path="bussCity" id="bussCity"
														class="form-control">
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
															<li class="style-li error-red"><cf:errors
																	path="bussPincode" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="bussPincode" class="form-control"
														value="${loginUser.bussPincode}" placeholder="Pincode"
														maxlength="6"
														onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
												</div>

											</div>
											<!--Right side-->

										</fieldset>
									</div>
									<!-- Business address Start -->
									<div class="row" style="height: 20px;"></div>

									<form>
										<!-- left side -->

										<!-- right side -->

										<div class="col-xs-12">
											<div class="col-xs-4"></div>
											<div class="col-xs-4">
												<div class="form-group">
													<input type="submit" class="form-control login-btn"
														value="Update" onsubmit= />
												</div>
											</div>
											<div class="col-xs-4"></div>
										</div>
									</form>
								</div>
								<div class="col-md-2 hidden-xs"></div>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</section>
</cf:form>
<script type="text/javascript">
var gender = '${loginUser.gender}';
if(gender == 'M'){
	document.getElementById('male').checked = true;
}else if(gender = 'F'){
	document.getElementById('female').checked = true;
}
</script>
<!--  <script>
                var id = localStorage.getItem('activeID');
                document.getElementById(id).className = "active";

            </script> -->