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
function saveDetails(){
	
}
function showDetails(){
	$('#tblAssessorCourses tr').remove();
	var result="";
	 var data=JSON.stringify({
		 courseType:$('#selCourseType').val(),
		 courseName:$('#selCourseName').val(),
		 trainingDate:$('#trainingdate').val().replace("-","/").replace("-","/"),
		 trainingTime:$('#trainingtime').val(),
		 trainingCenter:$('#personalInformationTrainingPartnerId').val(),
		 loginId:$('#selTrainerNames').val(),
		 status:$('statusOptions').val()
	});
	$.ajax({
	type: 'post',
	url: 'getTrainingCalenderList.fssai',
	contentType : "application/json",
	data: data,
	success: function (data){
		console.log("Data received..");
		console.log(data);
	var jsonData = jQuery.parseJSON(data);
	console.log(jsonData);
	$('#tcViewDetails tr').remove();
	$.each(jsonData , function(i , obj)
	{
		var status="";
		if(obj.status=="A"){
			status="Active";
		}else{
			status="InActive";
		}
		 $('#tcViewDetails').append('<tr>'+
	           		'<td>'+(i+1)+'</td><td>'+obj.coursetypeName+'</td>'+
	           	    '<td>'+obj.strCourseName+'</td>'+
	           	    '<td>'+obj.trainingDate.replace("-","/").replace("-","/")+'</td>'+
	           	    '<td>'+obj.trainingTime+'</td>'+
	           	  	'<td>'+obj.trainingCenterName+'</td>'+
	           	    '<td>'+obj.loginId+'</td>'+
	           	    '<td>'+status+'</td> '+
	           	  	'</tr>');
	            
	});
	
	},
	failure:function(data){
		alert("Error occured while retrieving upcoming calendars.");
	 msgbox('Error occured while retrieving upcoming calendars.');
	}
	});
return result;	
}


</script>
<section>
   <%@include file="../roles/top-menu.jsp"%>
</section>
<cf:form name="myForm" commandName="trainingPartnerTrainingCalender" >
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
                            <div class="container-fluid">
                                <div class="row">

                                    <!-- search and apply vacancies -->
                                    <div class="col-xs-12">
                                        <fieldset>
                                        <legend><h3>Training Calendar</h3></legend>
                                        <script type="text/javascript">
                                        var formObj = '${trainingPartnerTrainingCalender}';
                                        var formData = JSON.parse(formObj);
                                        var courseTypes = formData.courseTypes;
                                        var trainerList = formData.trainerList;
                                        var trainingCenterList=formData.trainingCenterList;
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
														<script>
															var selectctpeOptions = "<option disabled selected value> -- select courseType -- </option>";
															for(var i=0 ; i < courseTypes.length; i++)
																{
																	console.log(courseTypes[i].CourseTypeId + " -- "+ courseTypes[i].CourseType);
																	selectctpeOptions += "<option value="+courseTypes[i].CourseTypeId+">"+courseTypes[i].CourseType+"</option>"
																	
																}
															document.getElementById('selCourseType').innerHTML += selectctpeOptions; 
														</script>
														
                                                    </div>
                                                    
						                       <div class="form-group">
						                          <div>
						                            <ul class="lab-no">
						                              <li class="style-li"><strong>Course Name:<span style="color:red;">*</span></strong></li>
						                              <li class="style-li error-red">
						                               <label id="courseNameError" class="error visibility">select course name</label>
<%-- 						                               <cf:errors path="courseName" cssclass="error"/> --%>
						                               </li>
						                            </ul>
						                          </div>
						                           <select class="form-control" name="selCourseName" id = "selCourseName"> </select>
						                        </div> 
						                        
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
                                                                <li class="style-li"><strong>Training Time</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="time" id="trainingtime" class="form-control">
                                                    </div>

                                                </div>

                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                        <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Center Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="TrainingCentreName" id = "personalInformationTrainingPartnerId"> </select>
														
                                                    </div>
                                                               
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Trainer Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="selTrainerNames" id = "selTrainerNames"> </select>
														<script>
															var selectTrainerOptions = "";
															for(var i=0 ; i < trainerList.length; i++)
																{
																	selectTrainerOptions += "<option value='"+trainerList[i].value+"'>"+trainerList[i].value+"</option>"
																	
																}
															document.getElementById('selTrainerNames').innerHTML += selectTrainerOptions; 
															var selectctTCpeOptions = "<option disabled selected value> -- select Training Center -- </option>";
															for(var i=0 ; i < trainingCenterList.length; i++)
																{
																	console.log(trainingCenterList[i].personalInformationTrainingPartnerId + " -- "+ trainingCenterList[i].TrainingCentreName);
																	selectctTCpeOptions += "<option value="+trainingCenterList[i].personalInformationTrainingPartnerId+">"+trainingCenterList[i].TrainingCentreName+"</option>"
																	
																}
															document.getElementById('personalInformationTrainingPartnerId').innerHTML += selectctTCpeOptions;
														</script>
														
                                                    </div>
                                                     <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Status:</strong></li>
                                                            
                                                        </ul>
                                                    </div>
                                                    <select  id="statusOptions" name="statusOptions" class="form-control">
                                                        <option value="A">Active</option>
                                                        <option status="I">Inactive</option>
                                                    </select>
                                                </div>
                                               
                                                    <input type="submit" style="margin-top:20px;"  class="btn login-btn pull-right show-details-vacancy collapsed"  data-target="#show-result" aria-expanded="false" onclick="onDownload();return false"  value="download">
                                                     <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="showDetails();return false">Show Details</button>
                                                </div>
                                               
                                            </div>

                                            <div class="col-md-3 hidden-xs"></div>
                                        </div>
                                        </fieldset>


                                    </div>

                                    <!-- search Results -->
                        <!-- search Results -->
              <div class="col-xs-12 collapse table-overflow-responsive" id="show-result" aria-expanded="false" style="height: 0px;"> 
                <!-- table -->
                <div class="row">
                  <div class="col-xs-12">
                    <fieldset style="margin-top: 20px;">
                      <legend>
                      <h4>Search results</h4>
                      </legend>
                      <table id="trainingPartnercalendar" class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No.</th>
                            <th>Course Type</th>
                            <th>Course Name</th>
                            <th>Training Date</th>
                            <th>Training Time</th>
                            <th>Trainer Center Name</th>
                            <th>Trainer Name</th>
                            <th>Status</th>
                          </tr>
                        </thead>
                        <tbody id="tcViewDetails">
                          
                        </tbody>
                      </table>
                  </div>
                </div>
              </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
</cf:form>