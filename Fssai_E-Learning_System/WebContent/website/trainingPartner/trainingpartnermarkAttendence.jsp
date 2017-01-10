<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function OnStart(){
	showDetails('ALL');
}
window.onload = OnStart;


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

function ck_aadhar(thisValue){
	var id=$(thisValue).closest('tr').children('td:first').text();
	var value = thisValue.value;
	var validAadhar =$(thisValue).closest('td').find('input[id="validAadhar"]').val();
	alert(value ==validAadhar )
	if(value ==validAadhar ){
		$("#attendanceRow"+id).val("A");
	}else{
		
		$("#attendanceRow"+id).val("I");
		
	}

}
function showDetails(indicator){
	 	var courseType =  ($("#selCourseType").val() == null ) ? "" : $("#selCourseType").val() ;
		var courseName =  ($("#selCourseName").val() == null) ? "" :$("#selCourseName").val() ;
		var trainingDate = $("#trainingDate").val().replace("-","/").replace("-","/");
		var trainingTime =  $("#trainingDate").val();
		var status = $('#selTraineeStatus').val(); 
		 var total = "";
		
		$(".displayNone").css("display","block");
		
		if(indicator == "ALL")
			{
			total = "courseType=&courseName=&trainingDate=&trainingTime=";
			}else{
			total = "courseType="+courseType+"&courseName="+courseName+"&trainingDate="+trainingDate+"&trainingTime"+trainingTime;		
			}
		 
		
		var result="";
			$.ajax({
			type: 'post',
			url: 'searchMarkAttendance.jspp?'+ total,
			async: false, 
			success: function (data){
			$('#newTable').show();
			//var mainData = JSON.stringify(data);
			var mainData1 = jQuery.parseJSON(data);
			var j=1;
			$('#newTable tr').remove();
			$.each(mainData1 , function(i , obj)
			{
		
				$('#newTable').append('<tr id="tableRow"><td>'+j+'</td><td>'+obj[0]+'</td><td>'+obj[1]+'</td><td>'+obj[2]+'</td><td>'+obj[3]+'</td><td>'+obj[4]+'</td><td><input type="hidden" value='+obj[5]+' name="validAadhar" id="validAadhar" /><input path="AadharNumber" id="AadharNumber" name="AadharNumber" class="form-control" maxlength="12" placeholder="Aadhar Number" onblur=ck_aadhar(this); /></td><td><select style="width:100px;height:34px;font-size:12px;" name =attendanceRow'+j+'  id=attendanceRow'+j+'><option name="present" value ="A">Present</option><option name="absent" value="I">Absent</option></td><td><button onclick="updateAttendance('+obj[6]+' , '+j+');return false;">Update</button></td></tr>');
				
			});
			}
			});
			
			$('input[id="AadharNumber"]').keyup(function(e)
			        {
			if (/\D/g.test(this.value))
			{
			this.value = this.value.replace(/\D/g, '');
			}
			});
		return result;
	}
	
	
	function updateAttendance(courseEnrolledid , id){
		
		alert("id "+ id + " courseEnrolledid  "+courseEnrolledid);
		var status = $("#attendanceRow"+id).val();
		var total =  "courseenrolledId="+courseEnrolledid+"&status="+status ;
	 	$.ajax({
			type: 'post',
			url: 'updateAttendanceStatus.jspp?'+ total,
			data: {
			       user_name:name,
			      },
			      success: function (response) {
			       $( '#name_status' ).html(response);
			      }
			      });
		 	location.reload();
		 	return true;
	}

function showDetail(){
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
	var result="";
	//var id = document.getElementById("assessmentAgencyId").value;
	var assessorId =710;
	$.ajax({
	type: 'post',
	url: 'trainingpartnerviewtraineelist.jspp?'+assessorId,
	async: false, 
	success: function (data){
		console.log("Data received..");
		console.log(data);
	var jsonData = jQuery.parseJSON(data);
	console.log(jsonData);
	var j=1;
	var accessorId;
	$.each(jsonData , function(i , obj)
	{
		$('#tblAssessorCourses').append('<tr id="tableRow"><td>'+j++ +'</td>'+
				'<td>'+obj[3]+'</td>'+
				'<td>'+obj[4]+'</td>'+
				'<td>'+obj[5]+'</td>'+
				'<td><select name =attendanceRow'+obj[1]+'><option name="present" value ="A">Present</option>'+
				'<option name="absent" value="I">Absent</option></td>'+
				'<td> <button onclick="updateAttendance('+obj[0]+','+obj[1]+');return false;">Update</button></td>'+
				'</tr>');
		console.log("0-"+obj[0] +" #1-" +obj[1] +" #2-" +obj[2] +" #3-"+obj[3] +" #4-"+obj[4]+" #5-"+obj[5]);
		currentAssessorId = obj[0];
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
                      <!-- Sidebar -->
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
                                        <legend><h3>Mark Attendence</h3></legend>
                                        <script type="text/javascript">
                                        var formObj = '${trainingpartnermarkAttendence}';
                                        var formData = JSON.parse(formObj);
                                        var courseTypes = formData.courseTypes;
                                        var statusList = formData.statusList;
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
															var selectctpeOptions =  "<option disabled selected value> -- select courseType -- </option>";
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
                                                                <li class="style-li"><strong>Training Time</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="time" class="form-control" id="trainingTime" name="trainingTime">
                                                    </div>
                                                  <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Date:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="date" class="form-control" id="trainingDate" name="trainingDate">
                                                    </div>                              
                                                    
                                                     <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="showDetails('');return false">Show Details</button>
                                                     <input type="button" id="btnExport" style="margin-right: 20px;"  class="btn login-btn pull-right" value="Download" />
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
                      <div id="dvData">
                      <table  class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No.</th>
                            <th>Course Type</th>
                            <th>Course Name</th>
                            <th>Training Date</th>
                            <th>Training Time</th>
                            <th>Participant Name</th>
                            <th>Aadhar No.</th>
                            <th>Attendance</th>
                            <th>Save</th>
                           
                          </tr>
                        </thead>
                        <tbody id="newTable">
                        </tbody>
                      </table>
                      </div>
             
                    </fieldset>
                    <div style="width: 95px;">
                      <ul class="pager">
                      </ul>
                    </div>
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