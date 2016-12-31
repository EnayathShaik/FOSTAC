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
<script>
    function generateAnsSeq(){
    	$('#assAnsTable').html("");
    	var noOfAssmentQ =  $("#noOfAssesmentQues").val();
    	for(i=1;i<=noOfAssmentQ;i++){
    		$('#assAnsTable').append('<tr><td>'+i+'</td><td><cf:input path="optionOne" class="form-control" /></td></tr>')
    	}
    }
    </script>
    <section>
        <%@include file="../roles/top-menu.jsp"%>
    </section>
    <!-- main body -->
    <section class="main-section-margin-top">
        <div class="container-fluid">
            <div id="wrapper">
                <!-- Page Content -->
                <div><%@include file="../roles/slider.jsp" %>
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
                                                        <cf:select id="noOfAssesmentQues" onchange="generateAnsSeq();" path="noOfOption" class="form-control">
                                                            <cf:option value="-1" label="Please Select" />
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
                                                    <table id="assAnsTable" class="table table-bordered table-responsive">
                                                    <thead>
                                                        <tr class="background-open-vacancies">
                                                            <th>S.No.</th>
                                                            <th>Options</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody></tbody>
                                                </table>
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Answer Number:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <cf:input path="correctAnswer" onkeyup="allnumeric(this.id,this.value);" class="form-control" placeholder="Answer Number" />
                                                        
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
    
    