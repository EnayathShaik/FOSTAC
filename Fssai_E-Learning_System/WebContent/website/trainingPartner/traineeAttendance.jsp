<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="website/js/commonController.js"></script>
<script>
function markTraineeAttendance(){
	
	var rollNo = $("#traineeUniqueCode").val();
	alert(rollNo);
	if(rollNo == ""){
		alert("Enter Trainee Roll Number");
		$("#traineeUniqueCode").focus();
		$("#traineeUniqueCode").val("");
		return false;
	}else{
		console.log("else "+rollNo );
		var name1=JSON.stringify({
			courseName:0
	  })

    		$.ajax({
    		      type: 'post',
    		      url: "markTraineeAttendance.fssai?data="+rollNo,
    		      contentType : "application/json",
    		      data:name1,
    		      async:false,
    		      success: function (response) {
    		    	  alert(response);
    		    	 $('#attendance_status').html(response);
    		    	 $("#traineeUniqueCode").val("");
    		    	
    		      } 
    		      });
	}
}


</script>

<section>
  
 <%@include file="../roles/top-menu.jsp"%>
</section>
<cf:form name="myForm"  commandName="traineeAttendanceForm"  >
        <!-- main body -->
        <section class="main-section-margin-top">
            <div class="container-fluid">
                <div id="wrapper">

                    <!-- Sidebar -->
                      <!-- Sidebar -->
<%@include file="../roles/slider.jsp" %>
                    <!-- /#sidebar-wrapper -->
                    <!-- Page Content -->
                    <div id="page-content-wrapper">
                        <div class="container-fluid">

                            <!-- vertical button -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle">
                                        <i class="fa fa-bars"></i> <span class="orange-font">Welcome : ${loginUser.loginDetails.loginId}</span>
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
                                        <legend><h3>View Trainee List</h3></legend>
                                      
                                        
                                        <div class="row">
                                            <div class="col-xs-12">

                                                <!-- left side -->
                                                <div class="col-md-6 col-xs-12">
													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Trainee
																		Unique Code:<span style="color: red;">*</span>
																</strong></li>
																<li class="style-li error-red"><span id="attendance_status">
											<label id="AadharNumberError" class="error visibility">*
												enter trainee unique code</label> <cf:errors path="traineeUniqueCode"
												cssclass="error" /></li>
																		
																		
																		
											
															</ul>
														</div>
														 <cf:input path="traineeUniqueCode" id="traineeUniqueCode" name="traineeUniqueCode" type="text"
															placeholder="Trainee Unique Code" value="" class="form-control" /> 
															
														
													</div>


                                                </div>

                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12" style="right: 273px;top: 27px;">
                                                  <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="markTraineeAttendance();return false;" >Mark Attendance</button>
                                                 
                              
                                                </div>
                                               
                                            </div>

                                            <div class="col-md-3 hidden-xs"></div>
                                        </div>
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

