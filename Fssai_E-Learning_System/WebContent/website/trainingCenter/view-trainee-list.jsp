<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function getDistrict(val)
{
	$.ajax({
	      type: 'post',
	      url: 'loadDistrict.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      $('#trainingCenterCity option').remove();
	      $('#trainingCenterCity').append('<option value="0" label="Select District" />');
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  		
	  				$('#trainingCenterCity').append('<option value='+obj.districtId+' label='+obj.districtName+' />');		
	  		});
	      }
	      });     
}

function getCourseDetails(){
	alert('scsdcsdcsd');
	var courseType =  $("#CourseType").val();
	var courseName =  $("#courseName").val();
	var modeOfTraining =  $("#modeOfTraining").val();
	var trainingDate =  $("#trainingDate").val();
	var trainingTime =  $("#trainingTime").val();
	
	
	var status =  $("#status").val();
	//alert(courseName + "  "+ modeOfTraining+"  "+ trainingPatrtner);
	//alert(trainingDate + "  "+ trainingCenterState+"  "+ trainingCenterDistrict);
	var total="courseName="+courseName+"&modeOfTraining="+modeOfTraining+"&trainingDate="+trainingDate+"&CourseType="+CourseType+"&trainingTime="+trainingDate;
	alert(total);
	
	$.ajax({
		
		
	      type: 'post',
	      url: 'getCourseDetailsTrainingCntr.jspp?'+ total,
	    		  
	      success: function (response) {
	    	  alert('aaaaaaaaaaa');
	      var mainData1 = jQuery.parseJSON(response);
	      alert(mainData1);
	      $('#newTable').show();
	      $(".displayNone").css("display","block");
	      var j=1;
			$('#newTable tr').remove();
			$('#newTable').append('<tr  class="background-open-vacancies"><th>Select</th><th>Course Type</th><th>Course Name</th><th>Training Date</th><th>Training Time</th><th>Status</th><th>Mode Of Training</th></tr>');
			$.each(mainData1 , function(i , obj)
			{
			$('#newTable').append('<tr id="tableRow"><td><input type="radio" name="getCalander" id="h" value="'+obj[0]+'" />'+i+'<input type="radio" name="getCalander" onclick="gettid();" id="trainingCalendarIdd"  value="'+obj[0]+'"/></td><td>'+obj[1]+'</td><td>'+obj[2]+'</td><td>'+obj[3]+'</td><td>'+obj[5]+'</td><td>'+obj[6]+'</td><td>'+obj[7]+'</td></tr>');	
			document.getElementById("trainingCalendarId").value = i;
			});
	      
			}
			});
	return result; 
}
</script>
<!-- <script>
function gettid(){
	alert('f');
	if (document.getElementById('trainingCalendarIdd').checked) {
		 alert(calValue);
		  calValue = document.getElementById('trainingCalendarIdd').value;
		  alert(calValue);
		/* }
	document.getElementById("trainingCalendarId").value = document.getElementById("h").value;
	var a = document.getElementById("trainingCalendarId").value;
	var b = document.getElementById("iii").value;
	alert(a + '   '+ b); */
}
</script> -->
<cf:form action="Save.fssai" name="myForm" method="POST" commandName="courseEnrolledUserForm" >
    <!-- horizontal navigation -->
    <section>
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
                    <li class="hori"><a href="index.html">Home</a></li>
                    <li class="hori"><a href="update-personal-information.html">Update Personal Information</a></li>
                    <li class="hori"><a href="view-feedback-details.html">View Feedback Details</a></li>
                    <li class="hori"><a href="contactTrainee.fssai">Contact Us</a></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                      <ul class="dropdown-menu">
                        <li><a href="changePasswordTrainee.fssai">Change Password</a></li>
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
              <li> <a href="view-trainee-list.html">View Trainee List</a> </li>
              <li> <a href="mark-trainee-attendance.html">Mark Attendance</a> </li>
              <li> <a href="post-vacancy.html">Post Vacancy for Trainer</a> </li>
              <li> <a href="application-status.html">Application Status</a> </li>
              <li> <a href="manage-trainer.html">Manage Trainer</a> </li>
              <li> <a href="assessment-calendar.html">Assessment Calendar</a></li>
              <li> <a href="payment-confirmation.html">Payment Confirmation</a> </li>          
            </ul>
          </div>
          <!-- /#sidebar-wrapper --> 
          <!-- Page Content -->
          <div id="page-content-wrapper">
            <div class="container-fluid"> 
              <!-- vertical button -->
             <div class="row">
                <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i>
                 <span class="orange-font">Welcome Trainee</span> </a> </div>
              </div>
              <!-- add the content here for main body --> 
              <!-- timeline  -->
              <div class="container-fluid">
                <div class="row"> 

                  <!-- search and apply vacancies -->
                  <div class="col-xs-12">
                    <fieldset>
                      <legend>
                      <h3>View Trainee List</h3>
                      </legend>
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
                              <cf:select path="CourseType" class="form-control">
                                <option>Basic</option>
                                <option>Advanced</option>
                                <option>Special</option>
                              </cf:select>
                            </div>

                            <div class="form-group">
                              <div>
                                <ul class="lab-no">
                                  <li class="style-li"><strong>Course Name:</strong></li>
                                  
                                </ul>
                              </div>
                              &nbsp;&nbsp;<label> ${created}</label>
<cf:select path="courseName" class="form-control">
<cf:option value="0" label="Select Course" />
<cf:options items="${courseNameList}" itemValue="coursenameid" itemLabel="coursename" />
</cf:select>
                            </div>
                            <div class="form-group">
                              <div>
                                <ul class="lab-no">
                                  <li class="style-li"><strong>Training Date:</strong></li>
                                  <li class="style-li error-red"> </li>
                                </ul>
                              </div>
                              <cf:input type="date" path="trainingDate" class="form-control" placeholder="Training Date"/>
                            </div>

                          </div>

                          <!-- right side -->
                          <div class="col-md-6 col-xs-12">
                            <div class="form-group">
                              <div>
                                <ul class="lab-no">
                                  <li class="style-li"><strong>Training Time</strong></li>
                                  <li class="style-li error-red"> </li>
                                </ul>
                              </div>
                              <cf:input type="time" path="trainingTime" class="form-control"/>
                            </div>
                            <div class="form-group">
                              <div>
                                <ul class="lab-no">
                                  <li class="style-li"><strong>Status</strong></li>
                                  <li class="style-li error-red"> </li>
                                </ul>
                              </div>
                              <cf:select path="status" class="pull-right show-details-vacancy collapsed form-control">
                                <option>Payment Confirmed</option>
                                <option>Auto Confirmed</option>
                                <option>Payment Pending</option>
                              </cf:select>
                            </div>
                            <br><br>
                            <div class="form-group" style="margin-top:10px;">
                              <div>
                                <ul class="lab-no">
                                  <li class="style-li"><strong>Mode of Training:</strong></li>
                                  
                                </ul>
                              </div>
                              <cf:select path="modeOfTraining" class="form-control">
                                <option>Classroom</option>
                                <option>Online</option>
                              </cf:select>
                            </div>
                            <div style="margin-top: 20px; clear:both;">
                              <button type="submit" class="btn login-btn">Download</button>
                             <a href="#" onclick="getCourseDetails();" class="form-control login-btn btn pull-right" style="width: 50%;">Show Details</a>
                              
                            </div>
                          </div>
                        </div>
                      </div>
                    </fieldset>
                  </div>
                  <!-- search Results -->
                  <section class="section-form-margin-top">
                <div class="container-fluid"> 

                  <!-- login form -->              
                  <div id="testt" class="displayNone" aria-expanded="false" style="height: 0px; display:none;">
                    <div class="col-xs-12">
                    <fieldset>
                    <legend><h3 class="text-capitalize heading-3-padding">Certification Course</h3></legend>
                    <table  id="newTable"  class="table-bordered table table-responsive table-striped table-hover">
                        <thead>
                          <tr id="newTable" class="background-open-vacancies">
                            <!-- <td>Select</td>
                            <td>Training Center Name & Address</td>
                            <td>Training Schedule</td>
                            <td>Center Contact Person Name, Mobile & Email Id</td>
                            <td>Seating Capacity</td>
                            <td>Seats available</td> -->
                          </tr>
                        </thead><tbody></tbody>
                      </table>
                      <!--  <div class="col-xs-12 pull-right">
                        <input style="margin-top:20px; width:100px;"  type="submit" class="form-control login-btn btn" value="Enroll" />
                      </div> -->
                    </fieldset>                  

                    </div>
                    <div class="col-md-2 hidden-xs"></div>
                  </div>
                </div>
              </section>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    </cf:form>
    <!-- scripts --> 
    