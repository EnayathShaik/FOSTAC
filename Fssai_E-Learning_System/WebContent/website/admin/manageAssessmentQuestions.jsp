<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
function getQuestions(){
	var courseTypeSearch =  $("#courseTypeSearch").val();
	var courseNameSearch =  $("#courseNameSearch").val();
	alert(courseTypeSearch+'   '+ courseNameSearch)
	var total = "courseNameSearch="+courseNameSearch+"&courseTypeSearch="+courseTypeSearch;
	var result="";
	$.ajax({
	type: 'post',
	url: 'getQuestions.jspp?'+ total,
	async: false, 
	success: function (data){
	$('#newTable').show();
	//var mainData = JSON.stringify(data);
	var mainData1 = jQuery.parseJSON(data);
	var j=1;
	$('#newTable tr').remove();
	$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Course Type</th><th>Course Name</th><th>Question Number</th></tr>')
	$.each(mainData1 , function(i , obj)
	{
		$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[0]+'</td><td><a href="" onClick="onLoadTrainingPartnerCenterId.fssai?id='+obj[0]+'">'+obj[1]+'</a></td><td>'+obj[2]+'</td></tr>');
		
	});
	}
	});
return result;
}
function searchCourse(val)
{
	$.ajax({
	      type: 'post',
	      url: 'searchCourse.jspp?'+ val,
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
function searchCourse1(val)
{
	$.ajax({
	      type: 'post',
	      url: 'searchCourse.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      $('#courseNameSearch option').remove();
	      $('#courseNameSearch').append('<option value="0" label="Select Course Name" />');
	      $.each(mainData1 , function(i , obj)
	  		{
	  				$('#courseNameSearch').append('<option value='+obj[0]+'  >'+obj[1]+'</option>');		
	  		});
	      }
	      });     
}
</script>
<cf:form   action="manageAssessmentQuestionsSave.fssai" name="myForm" method="POST" commandName="assessmentQuestionForm" onsubmit="return validateFields();"> 

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
                                    <li></li>
                                    <li class="active hori"><a href="adminHomepage.fssai">Home</a></li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Management<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="traineeUserManagementForm.fssai" class="clr">Trainee</a></li>
                                            <li><a href="trainerUserManagementForm.fssai" class="clr">Trainer</a></li>
                                            <li><a href="trainingCenterUserManagementForm.fssai" class="clr">Training Center</a></li>
                                            <li><a href="assessorUserManagementForm.fssai" class="clr">Assessor</a></li>
                                            <li><a href="adminUserManagementForm.fssai" class="clr">Admin</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Master Data<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="stateMaster.fssai" class="clr">State</a></li>
                                            <li><a href="districtMaster.fssai" class="clr">District</a></li>
                                            <li><a href="cityMaster.fssai" class="clr">City</a></li>                                            
                                            <li><a href="regionMappingMaster.fssai" class="clr">Region Mapping</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="manageTrainingPartnerForm.fssai">Manage Training Partner</a></li>
                                    <li><a href="manageAssessmentAgencyForm.fssai">Manage Assessment Agency</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="changePasswordAssesAgency.fssai">Change Password</a></li>
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
                <!-- Page Content -->
                <div><%@include file="leftMenuAdmin.jspf" %>
                </div>
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Trainee Mr. Lorem </span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">

                                <div class="col-xs-12">
                                    <h1>Manage Assessment Questions</h1>
                                    <div class="row">
                                        <div class="col-xs-12">

                                            <!-- left side -->
                                            <div class="col-md-6 col-xs-12">
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Type:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                   <cf:select path="courseTypeSearch" class="form-control" onchange="searchCourse1(this.value);">
														<cf:option value="0" label="Select Course Type" />
														<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType" />
                                                      </cf:select>
                                                </div>
                                                
                                                
                                                
                                                 
                                            </div> <!-- left side ends -->

                                            <!-- right side -->
                                            <div class="col-md-6 col-xs-12">
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Name:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                  <cf:select path="courseNameSearch" class="form-control">
												<cf:option value="0" label="Select Course Name" />
												 </cf:select>
                                                </div>                                                 
                                               
                                                
                                            </div> <!-- rigth side ends -->
                                            
                                            <!-- button -->
                                            <div class="row">
                                                <div class="col-md-6 col-xs-12"></div>
                                                
                                                <div class="col-md-6 col-xs-12">
<a href="#" OnClick="getQuestions();" >Search</a>                                               
                                                         </div>
                                            </div>
                                           
                                        </div>

                                       
                                    </div>
                                </div>

                                <!-- search Results -->
                                <div class="col-xs-12">
                                    
                                    <!-- table -->
                                    <div class="row">
                                        
                                        <!-- question list -->
                                        <div class="col-xs-12 table-overflow-responsive">
                                        
                                            <fieldset>
                                                <legend>Question List</legend>
                                                
                                                <table id="newTable" class="table table-responsive table-bordered table-hover">
                                                        <thead>

                                                            <tr class="background-open-vacancies">
                                                                <th class="text-center"><input type="checkbox"> </th>
                                                                <th>Course Type</th>
                                                                <th>Course Name</th>
                                                                <th>Question Number</th>
                                                            </tr>

                                                        </thead>

                                                        <tbody>
                                                        </tbody>
                                                    </table>
                                                   
                                            </fieldset>
                                        </div>
                                        
                                        
                                        
                                        
                                        
                                        
                                    </div>
                                </div> <!-- search div ends -->
								
								<div class="col-xs-12 table-overflow-responsive">
                                            <fieldset>
                                                <legend>Add/ Modify Questions</legend>
                                                
                                                <!-- left side -->
                                                <div class="col-md-6 col-xs-12">
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Course Type:</strong></li>
                                                                <li class="style-li error-red">${created }	
                                                                <cf:errors path="courseTypeId" cssclass="error" />
                                                                 </li>
                                                            </ul>
                                                        </div>
                                                      <cf:select path="courseTypeId" class="form-control" onchange="searchCourse(this.value);">
														<cf:option value="0" label="Select Course Type" />
														<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType" />
                                                      </cf:select>
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Question Number:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                      <cf:input path="questionNumber" class="form-control" placeholder="Question Number" />
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Question Title:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                      <cf:input path="questionTitle" class="form-control" placeholder="Question Title" />
                                                    </div>
                                                    
                                                    
                                                    
                                                    
                                                </div>
                                                
                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Course Name:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                      <cf:select path="courseName" class="form-control">
														<cf:option value="0" label="Select Course Name" />
													    </cf:select>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Help Text:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <cf:input path="questionHint" class="form-control" placeholder="Help Text" />
                                                    </div>     
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Number of Options:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <cf:select path="noOfOption" class="form-control">
                                                            <cf:option value="1" label="1" />
                                                             <cf:option value="2" label="2" />
                                                             <cf:option value="3" label="3" />
                                                              <cf:option value="4" label="4" />
                                                               <cf:option value="5" label="5" />
                                                                <cf:option value="6" label="6" />
                                                        </cf:select>
                                                    </div>     
                                                    
                                                </div>
                                                
                                                <div class="col-md-6 col-xs-12">
                                                    <h3>Correct Answer</h3>
                                                    <table class="table table-bordered table-responsive">
                                                    <thead>
                                                        <tr class="background-open-vacancies">
                                                            <th>S.No.</th>
                                                            <th>Options</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
<tr><td>1</td><td><cf:input path="optionOne" class="form-control" /></td></tr>
<tr><td>2</td><td><cf:input path="optionTwo" class="form-control" /></td></tr>
<tr><td>3</td><td><cf:input path="optionThree" class="form-control" /></td> </tr>
<tr><td>4</td><td><cf:input path="optionFour" class="form-control" /></td></tr>
<tr><td>5</td><td><cf:input path="optionFive" class="form-control" /></td></tr>
<tr><td>6</td><td><cf:input path="optionSix" class="form-control" /></td></tr>
                                                    </tbody>
                                                </table>
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Answer Number:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <cf:input path="correctAnswer" class="form-control" placeholder="Answer Number" />
                                                        
                                                    </div>
                                                    <button class="btn login-btn pull-right">Save</button>
                                                </div> 
                                                
                                                <div class="col-md-6 col-xs-12">
                                                  
                                                
                                                </div>
                                            </fieldset>
                                            <br><br>
                                        </div>
								
                            </div><!-- row ends -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    </cf:form>