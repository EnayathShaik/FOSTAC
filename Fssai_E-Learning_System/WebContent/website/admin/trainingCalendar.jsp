<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="website/js/commonController.js"></script>
<script type="text/javascript">
function OnStart(){
	var profileId =
		<%=(Integer) session.getAttribute("profileId")%>
	if(profileId == 7){
		var inputSubmit = document.getElementById("CreateTraineeCalender"); 
		inputSubmit.style.display = "none";
		
	}
	getTrainingCalender('ALL');
	console.log("PROFILEID "+PROFILEID);
	if(PROFILEID=="1"){
		$("#CreateTraineeCalender").css("display" , "none");
	}
	
	 window.trainingEndDate =   flatpickr('[name="trainingEndDate"]' , {
			enableTime: true
		});
		
		 window.trainingStartDate =   flatpickr('[name="trainingStartDate"]' , {
			enableTime: true
		});

}
window.onload = OnStart;
</script>
<script>

</script>
<script>
function getTrainingCenter(val)
{
	var name1=JSON.stringify({
		courseName:0
  })
	$.ajax({
	      type: 'post',
	      url: 'loadTrainingCenter.fssai?data='+ val,
	      contentType : "application/json",
		  data:name1,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
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
	var trainingDate = $("#trainingStartDate").val();
	var trainingTime = $("#trainingEndDate").val();
	var trainerName = $("#trainerName").val();
	var result="";
	var total=""; 
	
	if(indicator.match('ALL')){
		total = "ALL";//"contentLocation=0&courseType=0&courseName=&modeOfTraining=&contentType=0";
	}else{
	
	total="courseType="+courseType+"@courseName="+courseName+"@trainingPartner="+trainingPartner+ 
	"@trainingCenter="+trainingCenter+"@trainingDate="+trainingDate+"@trainingTime="+trainingTime+
	"@trainerName="+trainerName;
	}
	var name1=JSON.stringify({
		courseName:0
  })
	$.ajax({
	      type: 'post',
	      url: 'getTrainingCalender.fssai?data='+ total,
	      contentType : "application/json",
		  data:name1,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      var j = 1;
	      $('#newTable tr').remove();
	      $('#newTable').append('<tr class="background-open-vacancies"><td>S.No.</td><td>Batch Code</td><td>Course Code</td><td>Training Partner Name</td><td>Training Center name</td><td>Training Date</td><td>Training Time</td><td>Trainer Name</td><tr>')
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  				$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[12]+'</td><td>'+obj[13]+'</td><td>'+obj[1]+'</td><td>'+obj[10]+'</td><td>'+obj[5]+'</td><td>'+obj[6]+'</td><td>'+obj[11]+'</td><tr>');		
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
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName}</span> </a>
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
												<cf:select path="courseType" class="form-control" onchange="getCourseName(this.value , 'courseName');">
													<cf:option value="0" label="Select Course Type"></cf:option>
													<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/>
												</cf:select>
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Course Code:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
													<cf:select path="courseName" class="form-control">
														<cf:option value="0" label="Select Course Code" />
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
                                                        <li class="style-li"><strong>Training Start Date:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
                                                <cf:input path="trainingStartDate" type="text" class="form-control" required="required" />
                                            </div>
                                            
                                            <div class="form-group">
                                                <div>
                                                    <ul class="lab-no">
                                                        <li class="style-li"><strong>Training End Date:</strong></li>
                                                        <li class="style-li error-red"></li>
                                                    </ul>
                                                </div>
                                                <cf:input path="trainingEndDate" type="text" class="form-control" required="required" />
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
                                       </div>
                                        
<input type="submit"  class="form-control login-btn" id="CreateTraineeCalender" value="Create" style="width: 200px;
    margin-left: 13px;" />  
                                          
<a href="#" onclick="getTrainingCalender('SELECTED');" class="btn btn-default pull-right show-details-vacancy collapsed" style="margin-top: 0px;
    margin-right: 15px; background:#ef580d" data-toggle="collapse" data-target="#show-result"
     aria-expanded="false">Show Calendar</a>
     <input type="button" id="btnExport" style="margin-right: 20px;"  class="btn login-btn pull-right" value="Download" />
                                       
                                    </fieldset>
                                    
                                </div>
                                
                                <!-- search Results -->
                                <div id="testt" class="displayNone" aria-expanded="false">
                                    <h1>Search Results</h1>
                                    <!-- table -->
                                    <div class="row">
                                        <div id="dvData" class="col-xs-12">
                                            <table id="newTable" class="table table-bordered table-responsive table-striped table-hover">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>Batch Code</th>
                                                        <th>Course Code</th>
                                                        <th>Training Partner Name</th>
                                                        <th>Training Center name</th>
                                                        <th>Training Start Date</th>
                                                        <th>Training End Date</th>
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