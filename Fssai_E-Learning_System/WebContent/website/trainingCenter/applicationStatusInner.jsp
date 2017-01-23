<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li class="hori"><a href="contact.html">Contact Us</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="change-password.html">Change Password</a></li>
                    <li><a href="#">Logout</a></li>
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
        <%@include file="leftmenuTrainingPartner.jspf" %>
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
              
              <!-- current upcoming trainings --> 
              <!-- upcoming trainings -->
              <div class="col-xs-12 collapse in" id="show-result" aria-expanded="true" style=""> 
                <!-- table -->
                <div class="row">
                  <div class="col-xs-12">
                    <fieldset>
                      <legend>
                      <h3>Current Application Status</h3>
                      </legend>
                      <h5><strong>Course Type:</strong> <span id="courseType"></span></h5>
                      <h5><strong>Course Name:</strong><span id="courseName"></span></h5>
                      <h5><strong>Training Center Name:</strong><span id="trainingCentername"></span></h5>
                      <h5><strong>Training Date:</strong><span id="trainingDate"></span></h5>
                      <h5><strong>Number of Vacancies:</strong> <span id="noOfVacancys"></span></h5>
                    </fieldset>
                  </div>
                  <div class="col-xs-12 table-overflow-responsive">
                    <fieldset style="margin-top: 20px;">
                      <legend>
                      <h4 style="padding-bottom:20px;">Status</h4>
                      <span id="applicationStatusMesssage" style="color:red;"></span>
                      </legend>
                      <div id="hiddenVaraibles"></div>
                      <table class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No</th>
                            <th>Trainer Name</th>
                            <th class="text-center">View Profile</th>
                            <th>Status</th>
                          </tr>
                        </thead>
                        <tbody id="applicationStatusInner">
                     
                        </tbody>
                      </table>
                      <a href="#" onClick="updateApplicationStatusForEnrolledVacancy()">
                      <input style="width:200px;" type="button" class="form-control login-btn" value="Save" />
                      </a>
                    </fieldset>
                  </div>
                  
                  <!-- pagination -->
<!--                   <ul class="pagination pagination-right-margin  pull-right"> -->
<!--                     <li><a href="#">1</a></li> -->
<!--                     <li><a href="#">2</a></li> -->
<!--                     <li><a href="#">3</a></li> -->
<!--                     <li><a href="#">4</a></li> -->
<!--                     <li><a href="#">5</a></li> -->
<!--                   </ul> -->
                </div>
              </div>
            </div>
                    </div>
                </div>
            </div>
        </section>
        <!--/#footer-->
<script src="website/js/jquery.js"></script> 
<script src="website/js/bootstrap.min.js"></script> 
<script src="website/js/jquery.isotope.min.js"></script> 
  <script type="text/javascript">
                var utilityList=${utilityList };
                console.log(utilityList);
                $("#courseType").text(utilityList.courseTypeName);
                $("#courseName").text(utilityList.courseName);
                $("#trainingCentername").text(utilityList.trainerList[0].value);
                $("#trainingDate").text(utilityList.trainingDate);
                $("#noOfVacancys").text(utilityList.noOfVacancy);
                
                var list=utilityList.trainerList;
                
 for(index=0;index<list.length;index++){
	 $('#hiddenVaraibles').append('<input type="hidden" id="trainerId_'+index+'" name="trainerId_'+index+'" value="'+list[index].id+'">'); 
	  $('#applicationStatusInner').append('<tr>'+
			  '<td>'+(index+1)+'</td><td>'+list[index].value+'</td><td align="center"><input class="login-btn" type="button" value="Opsen"></td>'+
			  '<td><select class="form-control" id="selectOption_'+index+'"><option >Selected</option> <option>Rejected</option><option>Under Process</option>'+
			  '<option>Cancelled</option></select></td></tr>');
 }
 function updateApplicationStatusForEnrolledVacancy(){
	 var strIdList=[];
	 var statusList=[];
	 for(index=0;index<list.length;index++){
		 strIdList.push($("#trainerId_"+index+"").val());
		 statusList.push($("#selectOption_"+index+"").val());
	 }
	 var data=JSON.stringify({
		 	loginId:strIdList.join(),
			status:statusList.join(),
	});
		$.ajax({
		      type: 'post',
		      url: 'updateApplicationStatusForEnrolledVacancy.fssai',
		      contentType : "application/json",
		      data: data,
		      success: function (response) {
		    	 response=JSON.parse(response);
		   		$("#applicationStatusMesssage").text(response.message) 	 
		   
		      }
		      });
 }

	
                </script>
