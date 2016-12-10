<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function OnStart(){
	searchVacancy();
}
window.onload = OnStart;
</script>
<script>
function getCourseName(val){
	$.ajax({
	      type: 'post',
	      url: 'getCourseName.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	       $('#courseName option').remove();
	      $('#courseName').append('<option value="0" label="Select Course Name" />');
	        $.each(mainData1 , function(i , obj)
	  		{
	  				$('#courseName').append('<option value='+obj[0]+' >'+obj[1]+'</option>');		
	  		});
	      }
	      });
}

</script>
<script>
function validateFields(){
	var courseType =  $("#courseType").val();
	var courseName =  $("#courseName").val();
	var trainingDate =  $("#trainingDate").val();
	var requiredExp =  $("#requiredExp").val();
	var noOfVacancy =  $("#noOfVacancy").val();
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
	if(trainingDate == 0){
		document.getElementById('trainingDate').style.borderColor = "red";
    	document.getElementById("trainingDateError").style.display = 'block';
    	document.getElementById("trainingDate").focus();
    	return false;
	}else{
		document.getElementById('trainingDate').style.borderColor = "#ccc";
	    document.getElementById("trainingDateError").style.display = 'none';
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
	if(noOfVacancy <= 1){
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
function searchVacancy(){
	var courseType =  $("#courseType").val();
	var courseName =  $("#courseName").val();
	var trainingDate = $("#trainingDate").val().replace("-","/").replace("-","/");
	var requiredExp =  $("#requiredExp").val();
	var noOfVacancy =  $("#noOfVacancy").val();
	$(".displayNone").css("display","block");
	var total = "courseType="+courseType+"&courseName="+courseName+"&trainingDate="+trainingDate+"&requiredExp="+requiredExp+"&noOfVacancy="+noOfVacancy+"&selectAll=1";
	var result="";
		$.ajax({
		type: 'post',
		url: 'searchVacancy.jspp?'+ total,
		async: false, 
		success: function (data){
		$('#newTable').show();
		//var mainData = JSON.stringify(data);
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td style="display:none;">'+obj[0]+'</td><td>'+obj[1]+'</td><td>'+obj[6]+'</td><td>'+obj[2]+'</td><td>'+obj[3]+'</td><td>'+obj[4]+'</td><td>'+obj[5]+'</td></tr>');
			
		});
		}
		});
	return result;
}
</script>

<cf:form action="postVacancyTrainingPartnerSave.fssai" name="myForm" method="POST" commandName="postVacancyTrainingCenterForm" onsubmit="return validateFields();" >

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
                <li class="hori"><a href="#">Home</a></li>
                <li class="hori"><a href="update-personal-information.html">Update Personal Information</a></li>
                <li class="hori"><a href="view-feedback-details.html">View Feedback Details</a></li>
                <li class="hori"><a href="contact.html">Contact Us</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="change-password.html">Change Password</a></li>
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
 <%@include file="leftmenuTrainingPartner.jspf" %>
      <!-- /#sidebar-wrapper --> 
      <!-- Page Content -->
      <div id="page-content-wrapper">
        <div class="container-fluid"> 
          
          <!-- vertical button -->
          <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Training Center</span> </a> </div>
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
                  <h3>Post Vacancy for Training Partner</h3>
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
						<cf:select path="courseType" class="form-control" onchange="getCourseName(this.value);">
						<cf:option value="0" label="Select Course Type" />
						<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/>
						</cf:select>
                        </div>
                        <div class="form-group">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Course Name:<span style="color:red;">*</span></strong></li>
                              <li class="style-li error-red">
                               <label id="courseNameError" class="error visibility">select course name</label>
                               <cf:errors path="courseName" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
					<cf:select path="courseName" class="form-control">
					<cf:option value="0" label="Select Course Name" />
					<%-- <cf:options items="${courseNameList}" itemValue="coursenameid" itemLabel="coursename"/> --%>
					</cf:select>
                        </div>
                          <div class="form-group">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Training Center Name:<span style="color:red;">*</span></strong></li>
                              <li class="style-li error-red">
                               <label id="courseNameError" class="error visibility">select Training Center Name:</label>
                               <cf:errors path="trainingCenter" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
					<cf:select path="trainingCenter" class="form-control">
					<cf:option value="0" label="select Training Center Name" />
					<cf:options items="${trainingCenterList}" itemValue="personalInformationTrainingPartnerId" itemLabel="TrainingCentreName"/>
					</cf:select>
                        </div>
                      
                      </div>
                      <!-- right side -->
                      <div class="col-md-6 col-xs-12">
                        <div class="form-group">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Training Date:<span style="color:red;">*</span></strong></li>
                              <li class="style-li error-red">
                               <label id="trainingDateError" class="error visibility">enter training date</label>
                               <cf:errors path="trainingDate" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
                          <cf:input path="trainingDate" type="date" class="form-control" />
                        </div>
                      
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
                          <cf:input path="requiredExp"  class="form-control" />
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
                           <cf:input path="loginId" type="hidden" class="form-control" value="${loginUserS.loginDetails.loginId }" />
                         <cf:input path="noOfVacancy" type="text" class="form-control" />
                        </div>
                      </div>
                      <input type="submit" style="margin-top:20px;"  class="btn login-btn pull-right show-details-vacancy collapsed"  data-target="#show-result" aria-expanded="false" value="Create">
                    <a href="#testt"  onclick="searchVacancy();" style="margin-top:20px; margin-right: 20px;"  class="btn login-btn pull-right"   >Search</a>
                  
                    
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
                      <!-- table -->
                      <table  class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No.</th>
                            <th>Course Type</th>
                            <th>Course Name</th>
                            <th>Training Date</th>
                            <th>Training CenterName</th>
                            <th>Required Experience</th>
                            <th>No. Of Vacancies</th>
                          </tr>
                        </thead>
                        <tbody id="newTable">
                        </tbody>
                      </table>
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