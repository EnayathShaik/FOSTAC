<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
function getstateid(){
getState()
}
window.onload=getstateid;
</script>





<script>
 
 function getState()
 {
	var ss= ${loginUr.trainingPartnerPermanentState};
	 var dd=${loginUr.trainingPartnerPermanentDistrict};
	 var cc=${loginUr.trainingPartnerPermanentCity};
	 alert(ss+" "+dd+" "+cc);
	getStateUpdate(ss , dd , cc);
	 alert('hiiiii');
 }
 
 function getStateUpdate(ss , dd , cc)
 {
 	$.ajax({
 	      type: 'post',
 	      url: 'getStateUpdate.jspp',
 	      success: function (response) {      
 	      var mainData2 = jQuery.parseJSON(response);
 	      $('#TrainingPartnerPermanentState option').remove();
 	      $('#TrainingPartnerPermanentState').append('<option value="0" label="Select Stateeeeee" />');
 	  	  
 	      $.each(mainData2 , function(i , obj)
 	  		{	
 	    	  if(ss == obj.stateId){
 	    		  $('#TrainingPartnerPermanentState').append('<option value='+obj.stateId+' label='+obj.stateName+' selected="true" />');	
 	    	  }else{
 	    		  $('#TrainingPartnerPermanentState').append('<option value='+obj.stateId+' label='+obj.stateName+' />');	
 	    	  }	
 	  		});
 	      }
 	      });
 	getDistrictUpdate(ss , dd , cc)
 	
 }

 function getDistrictUpdate(ss , dd , cc)
 {
 	$.ajax({
 	      type: 'post',
 	      url: 'getDistrictUpdate.jspp?'+ ss,
 	      success: function (response) {      
 	      var mainData1 = jQuery.parseJSON(response);
 	      $('#TrainingPartnerPermanentDistrict option').remove();
 	      $('#TrainingPartnerPermanentDistrict').append('<option value="0" label="Select District" />');
 	  	  
 	      $.each(mainData1 , function(i , obj)
 	  		{
 	    	  if(dd == obj.districtId){
 	    		  $('#TrainingPartnerPermanentDistrict').append('<option value='+obj.districtId+' label='+obj.districtName+' selected="true"/>');
 	    	  }else{
 	    		  $('#TrainingPartnerPermanentDistrict').append('<option value='+obj.districtId+' label='+obj.districtName+' />');
 	    	  }	
 	  		});
 	      }
 	      }); 
 	getCityUpdate(dd , cc);
 }
 function getCityUpdate(dd , cc)
 {
 	$.ajax({
 	      type: 'post',
 	      url: 'getCityUpdate.jspp?'+dd,
 	      success: function (response) {      
 	      var mainData1 = jQuery.parseJSON(response);
 	      $('#TrainingPartnerPermanentCity option').remove();
 	      $('#TrainingPartnerPermanentCity').append('<option value="0" label="Select City" />');
 	  	  
 	      $.each(mainData1 , function(i ,obj)
 	  		{
 	    	  if(cc == obj.cityId){
 	    		  $('#TrainingPartnerPermanentCity').append('<option value='+obj.cityId+' label='+obj.cityName+' selected="true"/>');
 	    	  }else{
 	    		  $('#TrainingPartnerPermanentCity').append('<option value='+obj.cityId+' label='+obj.cityName+' />');
 	    	  }	
 	  		});
 	      }
 	      });     

 }
 	
 </script>
 <script>
 
 function getDistrict(val)
    {
    	$.ajax({
    	      type: 'post',
    	      url: 'loadDistrict.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	      $('#TrainingPartnerPermanentDistrict option').remove();
    	      $('#TrainingPartnerPermanentDistrict').append('<option value="0" label="Select District" />');
    	      $('#TrainingPartnerPermanentCity option').remove();
    	      $('#TrainingPartnerPermanentCity').append('<option value="0" label="Select City" />');
    	  	 
    	      $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingPartnerPermanentDistrict').append('<option value='+obj.districtId+' label='+obj.districtName+' />');		
    	  		});
    	      }
    	      });     
    }
    function getCity(val)
    {
    	$.ajax({
    	      type: 'post',
    	      url: 'loadCity.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	      $('#TrainingPartnerPermanentCity option').remove();
    	      $('#TrainingPartnerPermanentCity').append('<option value="0" label="Select City" />');
    	  	  $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingPartnerPermanentCity').append('<option value='+obj.cityId+' label='+obj.cityName+' />');		
    	  		});
    	      }
    	      });     
    }
    </script>
      
    <!-- horizontal navigation -->
     <cf:form   action="updateTrainingpartner.fssai" name="myForm" method="POST" commandName="updateInformation" onsubmit="return validateFields();"> 
    section>
  <div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
      <div class="container">
        <div class="row">
          <div class="col-xs-12">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
             <ul class="nav navbar-nav">
                <li class="hori active"><a href="#">Home</a></li>
                <li class="hori"><a href="update-personal-information.fssai">Update Personal Information</a></li>
                <li class="hori"><a href="view-feedback-details.html">View Feedback Details</a></li>
                <li class="hori"><a href="contactTC.fssai">Contact Us</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href=changePasswordAssesAgency.fssai>Change Password</a></li>
                    <li><a href="fostac.fssai">Logout</a></li>
                  </ul>
                </li>
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
              <!-- <li class="sidebar-brand">
                            </li> -->
              <li> <a href="trainingCalendar.fssai">Training Calendar</a> </li>
              <li> <a href="view-trainee-list.fssai">View Trainee List</a> </li>
              <li> <a href="mark-trainee-attendance.fssai">Mark Attendance</a> </li>
              <li> <a href="post-vacancy.fssai">Post Vacancy for Trainer</a> </li>
              <li> <a href="application-status.fssai">Application Status</a> </li>
              <li> <a href="manage-trainer.fssai">Manage Trainer</a> </li>
              <li> <a href="assessment-calendar.fssai">Assessment Calendar</a></li>
              <li> <a href="payment-confirmation.fssai">Payment Confirmation</a> </li>
            </ul>
          </div>
          <!-- /#sidebar-wrapper --> 
          <!-- Page Content -->
          <div id="page-content-wrapper">
            <div class="container-fluid"> 

              <!-- vertical button -->
              <div class="row">
                <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Mr. Anuj</span> </a> </div>
              </div>

              <!-- add the content here for main body --> 
              <!-- timeline  -->

              <div class="container-fluid">
                <div class="row"> 

                  <!-- upcoming trainings -->
                  <div class="col-xs-12 collapse in" id="show-result" aria-expanded="true" style="">
                    <fieldset>
                      <legend>
                      <h3>Update Personal Information</h3>
                      </legend>
                      
              <!-- personal information -->
              <div class="personel-info">
                <fieldset>
                  <legend><h3>Personal Information</h3></legend>
                  <!-- left side -->
                  <div class="col-md-6 col-xs-12">
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>User Id:</strong></li>
                          
                        </ul>
                      </div>
                      <input type="text" class="form-control"  placeholder="User ID" disabled="disabled" id="UserId"   value=" ${loginUr.loginDetails.loginId}">
                    </div>
      <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Training Center name:</strong></li>
                          <li class="style-li error-red"> </li>
                        </ul>
                      </div>
                      <input type="text" class="form-control" placeholder="Training Center Name" value="${loginUr.trainingCentreName}" disabled="disabled">
                    </div>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Training Partner Name:</strong></li>
                          <li class="style-li error-red"> </li>
                        </ul>
                      </div>
                      <!-- <Select class="form-control">
                        <option>Lorem Ipsum</option>
                        <option>Lorem Ipsum</option>
                        <option>Lorem Ipsum</option>
                        <option>Lorem Ipsum</option>
                        <option>Lorem Ipsum</option>
                        <option>Lorem Ipsum</option>
                      </Select> -->
                      <cf:select path="TrainingPartnerName" class="form-control" disabled="true">
					<cf:options items="${trainingPartnerNameList}" itemValue="manageTrainingPartnerId" itemLabel="trainingPartnerName" />
					</cf:select>
                    </div>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>PAN:</strong></li>
                          <li class="style-li error-red"> </li>
                        </ul>
                      </div>
                      <input type="text" class="form-control" placeholder="PAN" disabled="disabled" value="${loginUr.PAN}">
                    </div>
                  </div>              
                  <!-- right side -->
                  <div class="col-md-6 col-xs-12">
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Title:</strong></li>
                          
                        </ul>
                      </div>
                      <cf:select path="Title" class="form-control" disabled="true">
					<cf:options items="${titleList}" itemValue="titleId" itemLabel="titleName" />
					</cf:select>
                    </div>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>First Name:(Training Center Head) </strong></li>
                          
                        </ul>
                      </div>
                      <input type="text" class="form-control" placeholder="First Name" disabled="disabled"  value=" ${loginUr.firstName}">
                    </div>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Middle Name:(Training Center Head)</strong></li>
                          
                        </ul>
                      </div>
                      <input type="text" class="form-control" placeholder="Middle Name" disabled="disabled"  value=" ${loginUr.middleName}">
                    </div>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Last Name:(Training Center Head)</strong></li>
                          
                        </ul>
                      </div>
                      <input type="text" class="form-control" placeholder="Last Name" disabled="disabled"  value=" ${loginUr.lastName}">
                    </div>
                  </div>
                  <!-- personal information ends -->
                </fieldset>
              </div>
              <!-- personal information ends -->
              <div class="row" style="height: 20px;"></div>
              <!-- contact details -->
              <div class="personel-info">
                <fieldset>
                  <legend><h3>Contact Details</h3></legend>
                  <!-- left side -->
                  <div class="col-md-6 col-xs-12">

                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Training Center Address Line 1:</strong></li>
                          
                        </ul>
                      </div>
                      <cf:input type="text" class="form-control" path="TrainingPartnerPermanentLine1" placeholder="Training Center Line 1"   value=" ${loginUr.trainingPartnerPermanentLine1}"/>
                    </div>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Training Center Address Line 2:</strong></li>
                          
                        </ul>
                      </div>
                      <cf:input type="text" class="form-control" path="TrainingPartnerPermanentLine2" placeholder="Training Center Line 2"  value=" ${loginUr.trainingPartnerPermanentLine2}"/>
                    </div>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>State:</strong></li>
                          
                        </ul>
                      </div>
                     <!--  <select class="form-control">
                        <option value="">Lorem</option>
                        <option value="">Lorem</option>
                        <option value="">Lorem</option>
                        <option value="">Lorem</option>
                      </select> -->
                      <cf:select path="TrainingPartnerPermanentState" class="form-control" onchange="getDistrict(this.value);">
					<cf:option value="0" label="Select State" />
					<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
					</cf:select>
                    </div>
                     <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>District:</strong></li>
                          
                        </ul>
                      </div>
                     <!--  <select class="form-control">
                        <option value="">Lorem</option>
                        <option value="">Lorem</option>
                        <option value="">Lorem</option>
                        <option value="">Lorem</option>
                      </select> -->
                       <cf:select path="TrainingPartnerPermanentDistrict" class="form-control" onchange="getCity(this.value);">
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
                          <li class="style-li"><strong>Closest City:</strong></li>
                          
                        </ul>
                      </div>
                     <!--  <select class="form-control">
                        <option value="">Lorem</option>
                        <option value="">Lorem</option>
                        <option value="">Lorem</option>
                        <option value="">Lorem</option>
                      </select> -->
                      <cf:select path="TrainingPartnerPermanentCity" class="form-control">
                  <cf:option value="0" label="Select City" />
					</cf:select>
                    </div>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>PIN Code:</strong></li>
                          
                        </ul>
                      </div>
                      <cf:input type="text" class="form-control" path="TrainingPartnerPermanentPincode" placeholder="Pincode" value=" ${loginUr.trainingPartnerPermanentPincode}"/>
                    </div>

                     <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Email:</strong></li>
                          
                        </ul>
                      </div>
                      <cf:input type="text" class="form-control" path="TrainingPartnerPermanentEmail" placeholder="Email" value=" ${loginUr.trainingPartnerPermanentEmail}"/>
                    </div>
                     <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Mobile:</strong></li>
                          
                        </ul>
                      </div>
                      <cf:input type="text" class="form-control" path="TrainingPartnerPermanentMobile" placeholder="Mobile" value=" ${loginUr.trainingPartnerPermanentMobile}"/>
                    </div>
                  <!-- right side ends -->
                </fieldset>
              </div>
              <!-- contact details ends -->          
              <div class="row" style="height: 20px;"></div>          
              <!-- Training center Details  -->          
              <div class="personel-info">
                <fieldset>
                  <legend><h3>Training Center Details</h3></legend>              
                  <!-- left side -->
                  <div class="col-md-6 col-xs-12">
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Seating capacity Per session?</strong></li>
                          <li class="style-li error-red"> </li>
                        </ul>
                      </div>
                      <cf:input type="text" class="form-control" path="SeatCapacityPerSession" placeholder="Number of Seats" value=" ${loginUr.seatCapacityPerSession}"/>
                    </div>
                    <div class="form-group">
                      <label>Availability of TV/ Projector in training center ?</label>
                      <br>
                      <label class="radio-inline">
                        <input type="radio" name="optradio">
                        Yes </label>
                      <label class="radio-inline">
                        <input type="radio" name="optradio">
                        No </label>
                    </div>
                    <div class="form-group">
                      <label>Availability of in-house trainers in food safety ?</label>
                      <br>
                      <label class="radio-inline">
                        <input type="radio" name="optradio">
                        Yes </label>
                      <label class="radio-inline">
                        <input type="radio" name="optradio">
                        No </label>
                    </div>
                  </div>
                  <!-- left side ends --> 
                  <!-- right side -->
                  <div class="col-md-6 col-xs-12">
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Number of in-house trainers ?</strong></li>
                          
                        </ul>
                      </div>
                      <cf:input type="text" placeholder="Number of trainers" path="NoOfInHouseTrainers" class="form-control" value=" ${loginUr.noOfInHouseTrainers}"/>
                    </div>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>Numbe of years in Business of training ?</strong></li>
                          
                        </ul>
                      </div>
                      <cf:input type="text" placeholder="Number of years" path="NoOfYearsInBusinessOfTraining" class="form-control" value=" ${loginUr.noOfYearsInBusinessOfTraining}"/>
                    </div>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong>How many training (4hrs) sessions wish to conduct in a month ?</strong></li>
                          
                        </ul>
                      </div>
                      <cf:input type="text" placeholder="Number of trainers" path="NoOfTrainingSessionWishToConductInAMonth" class="form-control" value=" ${loginUr.noOfTrainingSessionWishToConductInAMonth}"/>
                    </div>
                  </div>
                  <!-- right side ends -->
                </fieldset>
              </div>
              <!-- Basic courses -->
              <div class="personel-info">
                <h4>Courses wish to conduct ?</h4>
                <fieldset>
                  <legend><h3>Basic Courses</h3></legend>
                  <!-- left -->
                  <div class="col-md-6 col-xs-12" style="width:100%;">
                <div class="checkbox">
                <ct:if test="${not empty basicCourseList }">
 				<ct:forEach var="listValue" items="${basicCourseList}">
 				<ct:if test="${listValue[0] == 1}">
 				<label> <input type="checkbox"  value="${listValue[2] }" name="BasicCourse"  id="${listValue[2] }"  onclick=" return myBasic();">${listValue[1]}</label><br>
 				</ct:if>
 				</ct:forEach>
				</ct:if>
 				<cf:input path="BasicCourse1" value="" type="hidden"/>
				</div>
              </div>
              <!-- right -->
              <div class="col-md-6 col-xs-12">
            </fieldset>
          </div>
          <!-- basic course -->           
          <!-- Advanced courses -->          
          <div class="personel-info">
            <fieldset>
              <legend>Advanced Courses</legend>
              <!-- left -->
              <div class="col-md-6 col-xs-12" style="width:100%;">
                <div class="checkbox">
                <ct:if test="${not empty basicCourseList }">
 				<ct:forEach var="listValue" items="${basicCourseList}">
 				<ct:if test="${listValue[0] == 2}">
 				<label> <input type="checkbox" value="${listValue[2] }" name="AdvanceCourse" id="${listValue[2] }" onclick=" return myAdvance();">${listValue[1]}</label><br>
 				</ct:if>
 				</ct:forEach>
 				</ct:if>.
 				<cf:input path="AdvanceCourse1" value=""  type="hidden"/>
				</div>
              </div>
              <!-- right -->
              <div class="col-md-6 col-xs-12">
            </fieldset>
          </div>
          <!-- advanced course -->           
          <!-- special courses -->          
          <div class="personel-info">
            <fieldset>
              <legend>Special Courses</legend>
              <!-- left -->
              <div class="col-md-6 col-xs-12" style="width:100%;">
                <div class="checkbox">
                <ct:if test="${not empty basicCourseList }">
 				<ct:forEach var="listValue" items="${basicCourseList}">
 				<ct:if test="${listValue[0] == 3}">
 				<label> <input type="checkbox"  value="${listValue[2] }" name="SpecialCourse"  id="${listValue[2] }"  onclick=" return mySpecial();">${listValue[1]}</label><br>
 				</ct:if>
				</ct:forEach>
				</ct:if>
				<cf:input path="SpecialCourse1" value=""  type="hidden"/>
				</div>
              </div>              
              <!-- right -->
              <div class="col-md-6 col-xs-12"> </div>
            </fieldset>
              </div>
              <!-- special course -->           
              <!-- captcha -->
              <div class="col-xs-12">
                <!-- <div class="checkbox">
                  <label>
                    <input type="checkbox">
                    <a href="#" target="_blank" class="terms-font-size"> I have read and understood the Terms &amp; Conditions
                    and the Privacy Policy of FSSAI. </a> </label>
                </div> -->
              </div>          
              <!-- buttons -->
              <div class="col-md-4 hidden-xs"></div>
              <div class="col-md-4 col-xs-12">
                <input type="submit" class="form-control login-btn" value="Update">
                </a> </div>
              <div class="col-md-4 hidden-xs"></div>          
              <!-- training center details ends -->
           
                    </fieldset>
                  </div>
                  <!-- upcoming training ends --> 

                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    </cf:form>
    <!-- scripts --> 
    
