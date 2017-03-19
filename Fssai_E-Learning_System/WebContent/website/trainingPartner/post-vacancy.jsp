<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="website/js/commonController.js"></script>
<script type="text/javascript">

function OnStart(){
	searchVacancy('ALL');
	var today = jQuery.now();
	console.log("today "+today);
	flatpickr("#trainingEndTime" , {
		//defaultDate: today, // Date objects and date strings are also accepted
		enableTime: true
	});
	
	flatpickr("#trainingStartTime" , {
		//defaultDate: today, // Date objects and date strings are also accepted
		enableTime: true
	});	
}
window.onload = OnStart;
</script>
<script>

function checkVacancyType(){
	
	var vacancyType = $("#vacancyType").val();
	console.log("vacancyType "+vacancyType);
	
	/*if(vacancyType=="P"){
		
		$("#displayStartDate").css("display","block");
		$("#displayEndDate").css("display","block");
	} */
	
}


</script>
<script>
function validateFields(){
	var courseType =  $("#courseType").val();
	var courseName =  $("#courseName").val();
	var trainingDate =  $("#trainingDate").val();
	var requiredExp =  $("#requiredExp").val();
	var noOfVacancy =  $("#noOfVacancy").val();
	
	var trainingStartDate = $("#trainingDate").val();
	var trainingEndTime = $("#trainingEndTime").val();
	
	if(trainingStartDate == "" ||  trainingEndTime == ""){
		
		alert("Training Date can not be blank.");
		return false;
	}
	
	
	if(courseType == 0){
		document.getElementById('courseType').style.borderColor = "red";
    	document.getElementById("courseTypeError").style.display = 'block';
    	document.getElementById("courseType").focus();
    	return false;
	}else{
		document.getElementById('courseType').style.borderColor = "#ccc";
	    document.getElementById("courseTypeError").style.display = 'none';
	}
	if(courseName == 0){
		document.getElementById('courseName').style.borderColor = "red";
    	document.getElementById("courseNameError").style.display = 'block';
    	document.getElementById("courseType").focus();
    	return false;
	}else{
		document.getElementById('courseName').style.borderColor = "#ccc";
	    document.getElementById("courseNameError").style.display = 'none';
	}
	
	if(requiredExp <= 0){
		document.getElementById('requiredExp').style.borderColor = "red";
    	document.getElementById("requiredExpError").style.display = 'block';
    	document.getElementById("requiredExp").focus();
    	return false;
	}else{
		document.getElementById('requiredExp').style.borderColor = "#ccc";
	    document.getElementById("requiredExpError").style.display = 'none';
	}
	if(noOfVacancy <= 0){
		document.getElementById('noOfVacancy').style.borderColor = "red";
    	document.getElementById("noOfVacancyError").style.display = 'block';
    	document.getElementById("noOfVacancy").focus();
    	return false;
	}else{
		document.getElementById('noOfVacancy').style.borderColor = "#ccc";
	    document.getElementById("noOfVacancyError").style.display = 'none';
	}
}
</script>

<script type="text/javascript">


function searchVacancy(indicator){
	var loginID = '${triningCenter}';
	
	
	var courseType =  ($("#courseType").val() == 0 ? "" : $("#courseType").val());
	var courseName =  ($("#courseName").val() == 0 ? "" : $("#courseName").val());
	var trainingDate = (typeof $("#trainingStartTime").val() === "undefined"  ? "" : $("#trainingStartTime").val() ); 
	var trainingTime = (typeof $("#trainingEndTime").val() === "undefined" ? "" : $("#trainingEndTime").val() ); 
	var requiredExp =  ($("#requiredExp").val() == 0 ? "" : $("#requiredExp").val());
	var noOfVacancy =  ($("#noOfVacancy").val() == 0 ? "" : $("#noOfVacancy").val());
	var name1=JSON.stringify({
		courseType:0,
		courseName:0
  })
	var total = null;
	$(".displayNone").css("display","block");
	
	if(indicator == "ALL")
		 total = "courseType=@courseName=@trainingDate=@requiredExp=@noOfVacancy=@loginid="+loginID;
	else
		 total = "courseType="+courseType+"@courseName="+courseName+"@trainingDate="+trainingDate+"@requiredExp="+requiredExp+"@noOfVacancy="+noOfVacancy+"@loginid="+loginID+"@trainingTime="+trainingTime;
 	var result="";
	 	$.ajax({
		type: 'post',
		url: 'searchVacancy.fssai?data='+ total,
		contentType : "application/json",
		data:name1,
		async: false, 
		success: function (data){
		$('#newTable').show();
		//var mainData = JSON.stringify(data);
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td style="display:none;">'+obj[0]+'</td><td>'+obj[2]+'</td><td>'+obj[3]+'</td><td>'+obj[4]+'</td><td>'+obj[5]+'</td><td>'+obj[6]+'</td></tr>');
			
		});
		}
		});  
	return result;
}


</script>





<cf:form action="postVacancyTrainingPartnerSave.fssai" name="myForm" method="POST" commandName="postVacancyTrainingCenterForm" onsubmit="return validateFields();" >

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
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${logId}</span> </a> </div>
          </div>
          
          <!-- add the content here for main body --> 
          <!-- ti<div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Mr. Anuj</span> </a> </div>
          </div>meline  -->
          <div class="container-fluid">
            <div class="row"> 
              
              <!-- search and apply vacancies -->
              <div class="col-xs-12">
                <fieldset>
                  <legend>
                  <h3>Post Vacancy for Trainer</h3>
                  </legend>
                  <div class="row">
                    <div class="col-xs-12"> 
                      
                      <!-- left side -->
                      <div class="col-md-6 col-xs-12">
                        <div class="form-group">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Course Type:<span style="color:red;">*</span></strong></li>
                               <li class="style-li error-red">
                               <label id="courseTypeError" class="error visibility">select course type</label>
                                                            <span id="name_status"> ${created } </span>
                                                           
								 <cf:errors path="courseType" cssclass="error"/>
                                                            </li>
                            </ul>
                          </div>
						<cf:select path="courseType" class="form-control" onchange="getCourseName(this.value , 'courseName');">
						<cf:option value="0" label="Select Course Type" />
						<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/>
						</cf:select>
                        </div>
                        <div class="form-group">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Course Code:<span style="color:red;">*</span></strong></li>
                              <li class="style-li error-red">
                               <label id="courseNameError" class="error visibility">select course name</label>
                               <cf:errors path="courseName" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
					<cf:select path="courseName" class="form-control">
					<cf:option value="0" label="Select Course Code" />
					<%-- <cf:options items="${courseNameList}" itemValue="coursenameid" itemLabel="coursename"/> --%>
					</cf:select>
                        </div>
                     
                          <div class="form-group">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Vacancy Type:<span style="color:red;">*</span></strong></li>
                               <li class="style-li error-red">
                               <label id="vacancyTypeError" class="error visibility">select vacancy type</label>
                                                            <span id="name_status"> ${created } </span>
                                                           
								 <cf:errors path="vacancyType" cssclass="error"/>
                                                            </li>
                            </ul>
                          </div>
						<cf:select path="vacancyType" class="form-control" onchange="checkVacancyType()">
						<cf:option value="0" label="Select Vacancy Type" />
						<cf:options items="${vacancyMap}" />
						</cf:select>
                        </div>
                        
                        
                        
                               <div class="form-group" id="displayStartDate" >
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Training Start Date:</strong></li>
                              <li class="style-li error-red">
                               <label id="trainingDateError" class="error visibility">enter training date</label>
                               <cf:errors path="trainingDate" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
                          <cf:input path="trainingDate" type="date" id="trainingStartTime"  class="form-control" />
                        </div>
                        
                      </div>
                      <!-- right side -->
                      <div class="col-md-6 col-xs-12">
                        <div class="form-group">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Required Experience<span style="color:red;">*</span></strong></li>
                              <li class="style-li error-red">
                               <label id="requiredExpError" class="error visibility">enter required experience</label>
                               <cf:errors path="requiredExp" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
                          <cf:input path="requiredExp" maxlength="2" class="form-control" />
                        </div>
                        <div class="form-group">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>No. Of Vacancy <span style="color:red;">*</span></strong></li>
                              <li class="style-li error-red">
                              <li class="style-li error-red">
                               <label id="noOfVacancyError" class="error visibility">enter number of vacancy</label>
                               <cf:errors path="noOfVacancy" cssclass="error"/>
                               </li>
                               </li>
                            </ul>
                          </div>
                           <cf:input path="loginId" id="loginId" type="hidden" class="form-control" value="${loginUserS.loginDetails.loginId}" />
                         <cf:input path="noOfVacancy" type="text" maxlength="3" class="form-control" />
                        </div>
                        <div class="form-group">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Trainee Center:<span style="color:red;">*</span></strong></li>
                               <li class="style-li error-red">
                               <label id="traineeCenterError" class="error visibility">Select Trainee Center</label>
                                                            
                                                           
								 <cf:errors path="trainingCenter" cssclass="error"/>
                                                            </li>
                            </ul>
                          </div>
						<cf:select path="trainingCenter" class="form-control" >
						<cf:option value="${triningCenter}" label="${logId}" />
						
						</cf:select>
                        </div>

                      <div class="form-group" id="displayEndDate" >
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Training End Date:</strong></li>
                              <li class="style-li error-red">
                               <label id="trainingDateError" class="error visibility">Enter End Date</label>
                               <cf:errors path="trainingEndTime" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
                          <cf:input path="trainingEndTime" id="trainingEndTime" type="text" class="form-control" />
                        </div>
                        
                        
                      </div>
                      <input type="submit" style="margin-top:20px;"  class="btn login-btn pull-right show-details-vacancy collapsed"  data-target="#show-result" aria-expanded="false" value="Create">
                      <a href="#testt"  onclick="searchVacancy('');return false;" style="margin-top:20px; margin-right: 20px;"  class="btn login-btn pull-right"   >Search</a>
                 	  <!-- <input type="button" id="btnExport" style="margin-top:20px; margin-right: 20px;"  class="btn login-btn pull-right" value="Download" /> -->
                    
                    </div>
                    <div class="col-md-3 hidden-xs"></div>
                  </div>
                </fieldset>
              </div>
              <!-- search Results -->
              <div class="col-xs-12 displayNone"  style="display:none;">
                <fieldset style="margin-top: 20px;">
                  <legend>
                  <h4>Search Results</h4>
                  </legend>
                  <div class="row">
                    <div class="col-xs-12"> 
                    <div id="dvData">
                      <!-- table -->
                      <table  class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No.</th>
                            <th>Course Code</th>
                            <th>Training Start Date</th>
                            <th>Training End Date</th>
                            <th>Required Experience</th>
                            <th>No. Of Vacancies</th>
                          </tr>
                        </thead>
                        <tbody id="newTable">
                        </tbody>
                      </table>
                      </div>
                      </div>
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
