<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="website/js/commonController.js"></script>
            <script>
                function getstateid() {
                    getState()
                }
                window.onload = getstateid;

            </script>





            <script>
                function getState() {
                    var ss = ${loginUr.trainingPartnerPermanentState};
                    var dd = ${loginUr.trainingPartnerPermanentDistrict};
                    var cc = ${loginUr.trainingPartnerPermanentCity};

                    getStateUpdate(ss, dd, cc);

                }

                function getStateUpdate(ss, dd, cc) {
                    $.ajax({
                        type: 'post',
                        url: 'getStateUpdate.jspp',
                        success: function(response) {
                            var mainData2 = jQuery.parseJSON(response);
                            $('#TrainingPartnerPermanentState option').remove();
                            $('#TrainingPartnerPermanentState').append('<option value="0" label="Select Stateeeeee" />');

                            $.each(mainData2, function(i, obj) {
                                if (ss == obj.stateId) {
                                    $('#TrainingPartnerPermanentState').append('<option  selected="true" value=' + obj.stateId + '>' + obj.stateName + ' </option>');
                                } else {
                                    $('#TrainingPartnerPermanentState').append('<option value=' + obj.stateId + '>' + obj.stateName + ' </option>');
                                }
                            });
                        }
                    });
                    getDistrictUpdate(ss, dd, cc)

                }

                function getDistrictUpdate(ss, dd, cc) {
                    $.ajax({
                        type: 'post',
                        url: 'getDistrictUpdate.jspp?' + ss,
                        success: function(response) {
                            var mainData1 = jQuery.parseJSON(response);
                            $('#TrainingPartnerPermanentDistrict option').remove();
                            $('#TrainingPartnerPermanentDistrict').append('<option value="0" label="Select District" />');

                            $.each(mainData1, function(i, obj) {
                                if (dd == obj.districtId) {
                                    $('#TrainingPartnerPermanentDistrict').append('<option selected="true" value=' + obj.districtId + '>' + obj.districtName + '  </option>');
                                } else {
                                    $('#TrainingPartnerPermanentDistrict').append('<option value=' + obj.districtId + '>' + obj.districtName + ' </option>');
                                }
                            });
                        }
                    });
                    getCityUpdate(dd, cc);
                }

                function getCityUpdate(dd, cc) {
                    $.ajax({
                        type: 'post',
                        url: 'getCityUpdate.jspp?' + dd,
                        success: function(response) {
                            var mainData1 = jQuery.parseJSON(response);
                            $('#TrainingPartnerPermanentCity option').remove();
                            $('#TrainingPartnerPermanentCity').append('<option value="0" label="Select City" />');

                            $.each(mainData1, function(i, obj) {
                                if (cc == obj.cityId) {
                                    $('#TrainingPartnerPermanentCity').append('<option selected="true" value=' + obj.cityId + '>' + obj.cityName + '  </option>');
                                } else {
                                    $('#TrainingPartnerPermanentCity').append('<option value=' + obj.cityId + '>' + obj.cityName + ' </option>');
                                }
                            });
                        }
                    });

                }

            </script>
            <script>

        

            </script>

            <!-- horizontal navigation -->
            <cf:form action="updateTrainingpartner.fssai?id=${loginUr.personalInformationTrainingPartnerId}" name="myForm" method="POST" commandName="updateInformation" onsubmit="return validateFields();">
                <section>
                    <%@include file="../roles/top-menu.jsp"%>
                </section>

                <!-- main body -->
                <section class="main-section-margin-top">
                    <div class="container-fluid">
                        <div id="wrapper">

                            <!-- Sidebar -->
                            <%@include file="../roles/slider.jsp" %>
                                <!-- /#sidebar-wrapper -->
                                <!-- Page Content -->
                                <div id="page-content-wrapper">
<div class="col-md-8  col-xs-12">
                    <h3 class="text-capitalize heading-3-padding">Update Personal Information</h3>

                    <!-- Training Center information -->
                    <div class="personel-info">
                        <fieldset>
                            <legend>Personal Information</legend>
                            <!-- left side -->
                            <div class="col-md-6 col-xs-12">

									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>User Id:</strong></li>

											</ul>
										</div>
										<input type="text" class="form-control" placeholder="User ID"
											disabled="disabled" id="UserId"
											value=" ${loginUr.loginDetails.loginId}">
									</div>
									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>Training Center
														name:</strong></li>
												<li class="style-li error-red"></li>
											</ul>
										</div>
										<input type="text" class="form-control"
											placeholder="Training Center Name"
											value="${loginUr.trainingCentreName}" disabled="disabled">
									</div>

									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>Training Partner
														Name:</strong></li>
												<li class="style-li error-red"></li>
											</ul>
										</div>

										<cf:select path="TrainingPartnerName" class="form-control"
											disabled="true">
											<cf:options items="${trainingPartnerNameList}"
												itemValue="manageTrainingPartnerId"
												itemLabel="trainingPartnerName" />
										</cf:select>
									</div>

									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>Training Center
														Address Line 1:</strong></li>

											</ul>
										</div>
										<cf:input type="text" class="form-control"
											path="TrainingPartnerPermanentLine1"
											placeholder="Training Center Line 1"
											value=" ${loginUr.trainingPartnerPermanentLine1}" />
									</div>

									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>Training Center
														Address Line 2:</strong></li>

											</ul>
										</div>
										<cf:input type="text" class="form-control"
											path="TrainingPartnerPermanentLine2"
											placeholder="Training Center Line 2"
											value=" ${loginUr.trainingPartnerPermanentLine2}" />
									</div>

									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>State:</strong></li>

											</ul>
										</div>
										<cf:select path="TrainingPartnerPermanentState"
											class="form-control" onchange="getDistrict(this.value  , 'TrainingPartnerPermanentDistrict');">
											<cf:option value="0" label="Select State" />
											<cf:options items="${stateList}" itemValue="stateId"
												itemLabel="stateName" />
										</cf:select>
									</div>



								</div>
                            <!-- right side -->
                            <div class="col-md-6 col-xs-12">
									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>District:</strong></li>

											</ul>
										</div>
										<cf:select path="TrainingPartnerPermanentDistrict"
											class="form-control" onchange="getCity(this.value , 'TrainingPartnerPermanentCity');">
											<cf:option value="0" label="Select District" />
										</cf:select>
									</div>
									<div class="col-md-6 col-xs-12">
										<div class="form-group">
											<div>
												<ul class="lab-no">
													<li class="style-li"><strong>Closest City:</strong></li>

												</ul>
											</div>
											<cf:select path="TrainingPartnerPermanentCity"
												class="form-control">
												<cf:option value="0" label="Select City" />
											</cf:select>
										</div>

										<div class="form-group">
											<div>
												<ul class="lab-no">
													<li class="style-li"><strong>PIN Code:</strong></li>

												</ul>
											</div>
											<cf:input type="text" maxlength="6" class="form-control"
												path="TrainingPartnerPermanentPincode" placeholder="Pincode"
												value=" ${loginUr.trainingPartnerPermanentPincode}" />
										</div>
										<div class="form-group">
											<div>
												<ul class="lab-no">
													<li class="style-li"><strong>Email:</strong></li>

												</ul>
											</div>
											<cf:input type="text" class="form-control"
												path="TrainingPartnerPermanentEmail" placeholder="Email"
												value=" ${loginUr.trainingPartnerPermanentEmail}" />
										</div>

										<div class="form-group">
											<div>
												<ul class="lab-no">
													<li class="style-li"><strong>Landline:</strong></li>

												</ul>
											</div>
											<cf:input type="text" class="form-control"
												path="TrainingPartnerPermanentMobile" placeholder="Mobile"
												value=" ${loginUr.trainingPartnerPermanentMobile}" />
										</div>

									</div>
									<!-- personal information ends -->
                        </fieldset>
                    </div>
                    <!-- Training Center ends -->
                    <div class="row" style="height: 20px;"></div>
                    <!-- Training center head etails -->
                    <div class="personel-info">
                        <fieldset>
                            <legend>
                                Training Center Head Details</legend>
                            <!-- left side -->
                            <div class="col-md-6 col-xs-12">
									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>First
														Name:(Training Center Head) </strong></li>

											</ul>
										</div>
										<input type="text" class="form-control"
											placeholder="First Name" disabled="disabled"
											value=" ${loginUr.firstName}">
									</div>
							

									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>Last
														Name:(Training Center Head)</strong></li>

											</ul>
										</div>
										<input type="text" class="form-control"
											placeholder="Last Name" disabled="disabled"
											value=" ${loginUr.lastName}">
									</div>

								</div>
                            <!-- left side ends -->

                            <!-- right side -->
                            <div class="col-md-6 col-xs-12">
                         		<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>Middle
														Name:(Training Center Head)</strong></li>

											</ul>
										</div>
										<input type="text" class="form-control"
											placeholder="Middle Name" disabled="disabled"
											value=" ${loginUr.middleName}">
									</div>
                       

                            </div>

                            <!-- right side ends -->

                        </fieldset>
                    </div>
                    <!-- training center head ends -->
                    <div class="row" style="height: 20px;"></div>
                    <!-- facilities Details  -->
                    <div class="personel-info">
                        <fieldset>
                            <legend>
                                Facilities</legend>
                            <!-- left side -->
                            <div class="col-md-6 col-xs-12">


									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>Seating capacity
														Per session?</strong></li>
												<li class="style-li error-red"></li>
											</ul>
										</div>
										<cf:input type="text" class="form-control"
											path="SeatCapacityPerSession" placeholder="Number of Seats"
											value=" ${loginUr.seatCapacityPerSession}" />
									</div>
									<div class="form-group">
										<label>Availability of TV/ Projector in training
											center ?</label> <br> <label class="radio-inline"> <cf:radiobutton
												path="AvailabiltyOfTVProjector" value="Y" checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<cf:radiobutton path="AvailabiltyOfTVProjector" value="N" />No
										</label>
									</div>
									<div class="form-group">
										<label>Availability of in-house trainers in food
											safety ?</label> <br> <label class="radio-inline"> <cf:radiobutton
												path="AvailabiltyOfInHouseTrainersInFoodSafety" value="Y"
												checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <cf:radiobutton
												path="AvailabiltyOfInHouseTrainersInFoodSafety" value="N" />No
										</label>
									</div>
								</div>
                            <!-- left side ends -->
                            <!-- right side -->
                            <div class="col-md-6 col-xs-12">

									<div class="form-group">
										<label>Facility of Electricity + Air-Conditioner ?</label> <br>
										<label class="radio-inline"> <cf:radiobutton
												path="FacilityOfElectricityAndAirCondition" value="Y"
												checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <cf:radiobutton
												path="FacilityOfElectricityAndAirCondition" value="N" />No
										</label>
									</div>

									<div class="form-group">
										<label>Facility of Drinking Water?</label> <br> <label
											class="radio-inline"> <cf:radiobutton
												path="FacilityOfDrinkingWater" value="Y" checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<cf:radiobutton path="FacilityOfDrinkingWater" value="N" />No
										</label>
									</div>

									<div class="form-group">
										<label>Facility of Washroom ?</label> <br> <label
											class="radio-inline"> <cf:radiobutton
												path="FacilityOfWashroom" value="Y" checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<cf:radiobutton path="FacilityOfWashroom" value="N" />No
										</label>
									</div>
								</div>
                            <!-- right side ends -->
                        </fieldset>
                    </div>
                    <!-- facilities ends -->

                    <!-- buttons -->
                    <div class="col-md-4 hidden-xs"></div>
                     <div class="col-md-4 col-xs-12">
                      <input type="submit" class="form-control login-btn" value="Update">
                  
                      </div>
                     <div class="col-md-4 hidden-xs"></div>
                    <!-- training center details ends -->

                </div>
                                    </div>
                                </div>
                        </div>
                </section>
            </cf:form>
            <!-- scripts -->
            <!-- <script>
                var id = localStorage.getItem('activeID');
                document.getElementById(id).className = "active";

            </script> -->
