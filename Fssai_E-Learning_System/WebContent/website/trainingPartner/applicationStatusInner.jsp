<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
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
                     <!--  <h5><strong>Course Type:</strong> <span id="courseType"></span></h5> -->
                      <h5><strong>Course Code:</strong><span id="courseName"></span></h5>
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
                            <th class="text-center">View Pro11file</th>
                            <th>Status</th>
                            <th></th>
                          </tr>
                        </thead>
                        <tbody id="applicationStatusInner">
                     
                        </tbody>
                      </table>
                     <!--  <a href="#" onClick="updateApplicationStatusForEnrolledVacancy()">
                      <input style="width:200px;" type="button" class="form-control login-btn" value="Save" />
                      </a> -->
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
                //$("#courseType").text(utilityList.courseTypeName);
                $("#courseName").text(utilityList.courseName);
                $("#trainingDate").text(utilityList.trainingDate);
                $("#noOfVacancys").text(utilityList.noOfVacancy);
                
                var list=utilityList.trainerList;
                
 for(index=0;index<list.length;index++){
	 $('#hiddenVaraibles').append('<input type="hidden" id="trainerId_'+index+'" name="trainerId_'+index+'" value="'+list[index].id+'">'); 
	 if(list[index].status == 'CON'){
		 $('#applicationStatusInner').append('<tr>'+
				  '<td>'+(index+1)+'</td><td>'+list[index].value+'</td><td align="center"><a href="#" onClick="viewProfile(\''+list[index].link+'\');" >View Profile</a></td>'+
				  '<td><select class="form-control" id="selectOption_'+index+'"><option value="0">Please Select</option><option selected="true"  value="CON">Selected</option> <option value="REJ">Rejected</option><option value="PEN">Under Process</option>'+
				  '<option value="CAN">Cancelled</option></select></td><td><a href="#" onClick="updateApplicationStatusForEnrolledVacancySingle(\''+list[index].id+'\',\''+index+'\');">Save</a> </td></tr>');

	 } else  if(list[index].status == 'CAN'){
		 $('#applicationStatusInner').append('<tr>'+
				  '<td>'+(index+1)+'</td><td>'+list[index].value+'</td><td align="center"><a href="#" onClick="viewProfile(\''+list[index].link+'\');" >View Profile</a></td>'+
				  '<td><select class="form-control" id="selectOption_'+index+'"><option value="0">Please Select</option><option value="CON">Selected</option> <option value="REJ">Rejected</option><option value="PEN">Under Process</option>'+
				  '<option selected="true"  value="CAN">Cancelled</option></select></td><td><a href="#" onClick="updateApplicationStatusForEnrolledVacancySingle(\''+list[index].id+'\',\''+index+'\');">Save</a> </td></tr>');

	 } else  if(list[index].status == 'REJ'){
		 $('#applicationStatusInner').append('<tr>'+
				  '<td>'+(index+1)+'</td><td>'+list[index].value+'</td><td align="center"><a href="#" onClick="viewProfile(\''+list[index].link+'\');" >View Profile</a></td>'+
				  '<td><select class="form-control" id="selectOption_'+index+'"><option value="0">Please Select</option><option value="CON">Selected</option> <option selected="true"  value="REJ">Rejected</option><option value="PEN">Under Process</option>'+
				  '<option value="CAN">Cancelled</option></select></td><td><a href="#" onClick="updateApplicationStatusForEnrolledVacancySingle(\''+list[index].id+'\',\''+index+'\');">Save</a> </td></tr>');

	 } else  if(list[index].status == 'PEN'){
		 $('#applicationStatusInner').append('<tr>'+
				  '<td>'+(index+1)+'</td><td>'+list[index].value+'</td><td align="center"><a href="#" onClick="viewProfile(\''+list[index].link+'\');" >View Profile</a></td>'+
				  '<td><select class="form-control" id="selectOption_'+index+'"><option value="0">Please Select</option><option value="CON">Selected</option> <option value="REJ">Rejected</option><option selected="true"  value="PEN">Under Process</option>'+
				  '<option value="CAN">Cancelled</option></select></td><td><a href="#" onClick="updateApplicationStatusForEnrolledVacancySingle(\''+list[index].id+'\',\''+index+'\');">Save</a> </td></tr>');

	 } else {
		 $('#applicationStatusInner').append('<tr>'+
				  '<td>'+(index+1)+'</td><td>'+list[index].value+'</td><td align="center"><a href="#" onClick="viewProfile(\''+list[index].link+'\');" >View Profile</a></td>'+
				  '<td><select class="form-control" id="selectOption_'+index+'"><option value="0">Please Select</option><option value="CON">Selected</option> <option value="REJ">Rejected</option><option value="PEN">Under Process</option>'+
				  '<option value="CAN">Cancelled</option></select></td><td><a href="#" onClick="updateApplicationStatusForEnrolledVacancySingle(\''+list[index].id+'\',\''+index+'\');">Save</a> </td></tr>');

	 }
 }
 
 function viewProfile(userName){
	 var myWindow = window.open('${resumePath}/'+userName+".pdf", "", "width=500,height=500");
 }
 function updateApplicationStatusForEnrolledVacancySingle(id,index){
	 var status = $("#selectOption_"+index+"").val();
	 /* var strIdList=[];
	 var statusList=[];
	 for(index=0;index<list.length;index++){
		 strIdList.push($("#trainerId_"+index+"").val());
		 statusList.push($("#selectOption_"+index+"").val());
	 } */
	 var data=JSON.stringify({
		 	loginId:id,
			status:status,
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
