<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function OnStart(){
	getTrainingCalender('ALL');
}
window.onload = OnStart;
</script>
<script>
function getCourseName(val)
{
	$.ajax({
	      type: 'post',
	      url: 'loadCourseName.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	     // alert(mainData1);
	      $('#courseName option').remove();
	      $('#courseName').append('<option value="0" label="Select Course name" />')
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  				$('#courseName').append('<option value='+obj[0]+'>'+obj[1]+'</option>');		
	  		});
	      }
	      });     
}
</script>
<script>
function getTrainingCenter(val)
{
	$.ajax({
	      type: 'post',
	      url: 'loadTrainingCenter.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	        //alert(mainData1);
	      $('#trainingCenter option').remove();
	      $('#trainingCenter').append('<option value="0">Select Training Center </option>');
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  		
	  				$('#trainingCenter').append('<option value='+obj[0]+'>'+obj[1]+'</option>');		
	  		});
	      }
	      });     
}
</script>
<script>
function getTrainingCalender(indicator){
	var courseType = $("#courseType").val();
	var courseName = $("#courseName").val();
	var trainingPartner = $("#trainingPartner").val();
	var trainingCenter = $("#trainingCenter").val();
	var trainingDate = $("#trainingDate").val();
	var trainingTime = $("#trainingTime").val();
	var trainerName = $("#trainerName").val();
	var trainingType = $("#trainingType").val();
	var result="";
	var total=""; 
	
	if(indicator.match('ALL')){
		total = "ALL";//"contentLocation=0&courseType=0&courseName=&modeOfTraining=&contentType=0";
	}else{
	
	total="courseType="+courseType+"&courseName="+courseName+"&trainingPartner="+trainingPartner+ 
	"&trainingCenter="+trainingCenter+"&trainingDate="+trainingDate+"&trainingTime="+trainingTime+
	"&trainerName="+trainerName+"&trainingType="+trainingType;
	}
	//alert("total>"+total);
	$.ajax({
	      type: 'post',
	      url: 'getTrainingCalender.jspp?'+ total,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      //alert(mainData1);
	      var j = 1;
	      $('#newTable tr').remove();
	      $('#newTable').append('<tr class="background-open-vacancies"><td>S.No.</td><td>Training Type</td><td>Course Type</td><td>Course Name</td><td>Training Partner Name</td><td>Training Center name</td><td>Training Date</td><td>Training Time</td><td>Trainer Name</td><tr>')
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  				$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[9]+'</td><td>'+obj[4]+'</td><td>'+obj[3]+'</td><td>'+obj[1]+'</td><td>'+obj[10]+'</td><td>'+obj[5]+'</td><td>'+obj[6]+'</td><td>'+obj[11]+'</td><tr>');		
	  		});
	      }
	      });  
	$('#newTable').show();
	return result;
}
</script>
<cf:form action="trainingCalenderSave.fssai" name="myForm" method="POST" commandName="trainingCalendarForm" > 


    <section>
        
 <%@include file="../roles/top-menu.jsp"%>
    </section>
    <!-- main body -->
    <section class="main-section-margin-top">
        <div class="container-fluid">
            <div id="wrapper">
                <!-- Sidebar -->
                <div> <%@include file="../roles/slider.jsp" %>

                </div>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Admin</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="container-fluid">
                            <div class="row">
                                <!-- search and apply vacancies -->
                                <div class="col-xs-12">
                                    <fieldset>
                                        <legend>Training Calendar</legend>
                                        <!-- left side -->
                                        <div class="col-md-6 col-xs-12">
                                           
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Course Type:</strong></li>
                                                        <li class="style-li error-red">${created}</li>
                                                    </ul>
                                                </div>
												<cf:select path="courseType" class="form-control" onchange="getCourseName(this.value);">
													<cf:option value="0" label="Select Course Type"></cf:option>
													<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/>
												</cf:select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Course Name:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
													<cf:select path="courseName" class="form-control">
														<cf:option value="0" label="Select Course Name" />
													</cf:select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training Partner:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
<cf:select path="trainingPartner" class="form-control" onchange="getTrainingCenter(this.value);">
<cf:option value="0" label="Select Training Partner"></cf:option>
<cf:options items="${trainingPartnerList}" itemValue="manageTrainingPartnerId" itemLabel="trainingPartnerName"/>

</cf:select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training Center:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
<cf:select path="trainingCenter" class="form-control">
<cf:option value="0" label="Select Training Center" />
</cf:select>
                                            </div>
                                            
                                        </div>
                                        
                                        <!-- right side -->
                                        <div class="col-md-6 col-xs-12">
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training Date:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
                                                <cf:input path="trainingDate" type="date" class="form-control" required="required" />
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training Time</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
                                                <cf:input path="trainingTime" type="time" class="form-control" required="required" />
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Trainer Name:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
<cf:select path="trainerName" class="form-control">
<cf:option value="0" label="Select Trainer" />
<cf:options items="${trainingNameList}" itemValue="personalInformationTrainerId" itemLabel="FirstName"/>
</cf:select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training Type:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
<cf:select path="trainingType" class="form-control">
<cf:option value="0" label="Please Select" />
<cf:option value="Trainer"  label="Trainer"/>
<cf:option value="Trainee" label="Trainee" />
</cf:select>
                                            </div>
                                            
                                        </div>
<input type="submit"  class="form-control login-btn" value="Create" style="width: 200px;
    margin-left: 13px;" />  
                                          
<a href="#" onclick="getTrainingCalender('SELECTED');" class="btn btn-default pull-right show-details-vacancy collapsed" style="margin-top: -36px;
    margin-right: 15px; background:#ef580d" data-toggle="collapse" data-target="#show-result"
     aria-expanded="false">Show Calendar</a>
                                       
                                    </fieldset>
                                    
                                </div>
                                
                                <!-- search Results -->
                                <div id="testt" class="displayNone" aria-expanded="false">
                                    <h1>Search Results</h1>
                                    <!-- table -->
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <table id="newTable" class="table table-bordered table-responsive table-striped table-hover">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>Training Type</th>
                                                        <th>Course Type</th>
                                                        <th>Course Name</th>
                                                        <th>Training Partner Name</th>
                                                        <th>Training Center name</th>
                                                        <th>Training Date</th>
                                                        <th>Training Time</th>
                                                        <th>Trainer Name</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                   
                                                </tbody>
                                            </table>
                                        </div> <!-- col-xs-12 -->
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