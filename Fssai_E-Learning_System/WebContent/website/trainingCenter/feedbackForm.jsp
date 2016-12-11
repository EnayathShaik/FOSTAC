<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function getCourseName(val){
	 $('#selCourseName option').remove();
	$.ajax({
	      type: 'post',
	      url: 'getCourseName.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	       $('#selCourseName option').remove();
	      $('#selCourseName').append('<option value="0" label="--Select Course Name--" />');
	        $.each(mainData1 , function(i , obj)
	  		{
	  				$('#selCourseName').append('<option value='+obj[0]+' >'+obj[1]+'</option>');		
	  		});
	      }
	      });
}

</script>
<script>

function showDetails(){
	alert("Fetching details to mark attendance..");
	
	$('#tblAssessorCourses tr').remove();
	$('#tblAssessorCourses').append('<thead>'+
    '<tr class="background-open-vacancies">'+
        '<th>S.No.</th>'+
        '<th>Course Type</th>'+
        '<th>Course Name</th>'+
        '<th>Training Date</th>'+
        '<th>Training Time</th>'+
        '<th>Trainer Name</th>'+
        '<th>&nbsp;&nbsp;</th>'+
    '</tr>'+
	'</thead>');
	//var id = document.getElementById("assessmentAgencyId").value;
	var data=JSON.stringify({
		courseTypeId:$('#selCourseType').val()==null?0:$('#selCourseType').val(),
		courseNameId:$('#selCourseName').val()==null?0:$('#selCourseName').val(),
		trainingDate:$('#trainingdate').val(),
		feedbackId:$('#personalInformationTrainingPartnerId').val()==null?0:$('#personalInformationTrainingPartnerId').val()
		
  });
	$.ajax({
	      type: 'post',
	      url: 'getFeedbackDetails.fssai',
	      contentType : "application/json",
	      data: data,
	      success: function (response) {
	    	 response=JSON.parse(response);
	    	 if(response.length==0){
	    		 $('#show-result').hide();
	    	 }else{
	    		 $('#show-result').show();
	    	 }
	    	 for(index=0;index<response.length;index++){
				var objec=response[index];
				var rdStr=""
				for(var radioIndex=0;radioIndex<5;radioIndex++){
					if((radioIndex+1)==parseInt(objec[2])){
					rdStr+='<td class="text-center"><input type="radio" name="'+index+'" value="'+radioIndex+'" checked="checked" /></td> ';				
					}else{
						rdStr+='<td class="text-center"><input type="radio" name="'+index+'" value="'+radioIndex+'"/></td> '
					}
				}
	    		 $('#feedbackDetails').append('<tr>'+
           		'<td>'+objec[1]+'</td>'+rdStr+'</tr>');
             }
	      }
	      });

}


</script>
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
                <li><a href="training-center-management.html">Training Center Management</a></li>
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
                            <div class="container-fluid">
                                <div class="row">

                                    <!-- search and apply vacancies -->
                                    <div class="col-xs-12">
                                        <fieldset>
                                        <legend><h3>Feedback Details</h3></legend>
                                        <script type="text/javascript">
                                        var formObj = '${trainingpartnerapplicationstatus}';
                                        var formData = JSON.parse(formObj);
                                        var courseTypes = formData.courseTypes;
                                        var trainingCenterList=formData.trainingCenterList;
                                        console.log(trainingCenterList);
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
                                                        <select class="form-control" onchange="getCourseName(this.value);" name="selCourseType" id = "selCourseType"> </select>
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Course Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="selCourseName" id = "selCourseName"> </select>
														
                                                    </div>
                                                </div>

                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                 
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Date:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="date" id="trainingdate" class="form-control">
                                                    </div>
                                                      <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Center Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="TrainingCentreName" id = "personalInformationTrainingPartnerId"> </select>
														
                                                    </div>
                                                     <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="showDetails();">Show Details</button>
                                                </div>
                                               
                                            </div>

                                            <div class="col-md-3 hidden-xs"></div>
                                        </div>
                                        </fieldset>
<script>
															var selectctpeOptions = "<option disabled selected value> -- select courseType -- </option>";
															for(var i=0 ; i < courseTypes.length; i++)
																{
																	console.log(courseTypes[i].CourseTypeId + " -- "+ courseTypes[i].CourseType);
																	selectctpeOptions += "<option value="+courseTypes[i].CourseTypeId+">"+courseTypes[i].CourseType+"</option>"
																	
																}
															document.getElementById('selCourseType').innerHTML += selectctpeOptions;
															
															var selectctTCpeOptions = "<option disabled selected value> -- select Training Center -- </option>";
															for(var i=0 ; i < trainingCenterList.length; i++)
																{
																	console.log(trainingCenterList[i].personalInformationTrainingPartnerId + " -- "+ trainingCenterList[i].TrainingCentreName);
																	selectctTCpeOptions += "<option value="+trainingCenterList[i].personalInformationTrainingPartnerId+">"+trainingCenterList[i].TrainingCentreName+"</option>"
																	
																}
															document.getElementById('personalInformationTrainingPartnerId').innerHTML += selectctTCpeOptions;
														</script>
														

                                    </div>

<!--                                     search Results -->
<!--                         search Results -->
              <div class="col-xs-12 collapse table-overflow-responsive" id="show-result" aria-expanded="false" style="height: 0px;"> 
<!--                 table -->
                <div class="row">
                  <div class="col-xs-12">
                    <fieldset style="margin-top: 20px;">
                      <legend>
                      <h4>Feed back details</h4>
                      </legend>
                                <table class="table table-bordered table-striped table-responsive table-hover paginated">
                          <thead>
                        <tr class="blue-table-head">
                              <th>Feedback Point</th>
                              <th class="text-center">1</th>
                              <th class="text-center">2</th>
                              <th class="text-center">3</th>
                              <th class="text-center">4</th>
                              <th class="text-center">5</th>
                            </tr>
                      </thead>
                          <tbody id="feedbackDetails">
<!-- 						    <tr>       -->
<%-- 						        <td>${feedbackMaster[1]}</td> --%>
<%-- 							  <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="1"></td> --%>
<%--                               <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="2"></td> --%>
<%--                               <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="3"></td> --%>
<%--                               <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="4"></td> --%>
<%--                               <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="5"></td> --%>
<!-- 						    </tr> -->
                      </tbody>
                        </table>
                    <div class="col-xs-12">
                          <ul class="feed-no">
                        <li class="feed-li"><span><strong>1</strong></span>&nbsp;<span>Poor</span></li>
                        <li class="feed-li"><span><strong>2</strong></span>&nbsp;<span>Good</span></li>
                        <li class="feed-li"><span><strong>3</strong></span>&nbsp;<span>Better</span></li>
                        <li class="feed-li"><span><strong>4</strong></span>&nbsp;<span>Best</span></li>
                        <li class="feed-li"><span><strong>5</strong></span>&nbsp;<span>Excellent</span></li>
                      </ul>
                        </div>
                    <div class="col-md-4 col-x-12"></div>
                    <div class="col-md-4 col-x-12"></div>
                    
</fieldset>
</div>
</div>
</div>
<%-- </cf:form> --%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
