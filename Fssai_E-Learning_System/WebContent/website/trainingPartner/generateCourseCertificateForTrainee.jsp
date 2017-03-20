<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
 <script src="website/js/commonController.js"></script>
<script type="text/javascript">
function OnStart(){
	window.userId = '${userId}';
	flatpickr('[id="trainingStartDate"]' , {
		enableTime: true
	});

	flatpickr('[id="trainingEndDate"]' , {
		enableTime: true
	});

	
}

window.onload = OnStart;
</script>
<script>


function getCertificate(val){

 	var name=JSON.stringify({
		courseType:0,
		courseName:0
  })
  var profileId = '${profileId}'; 
  if(profileId == 3){
	  val = val+"-"+'${userId}';  
  }else{
	  
	  val = val+"-NA";
	
  }
  
	$.ajax({
	      type: 'post',
	      url: 'getCertificateID.fssai?data='+val,
	      contentType : "application/json",
	      data:name,
	      success: function (response) {   
	    	 
	      var mainData1 = jQuery.parseJSON(response);
 	        $('#certificateId option').remove();
	      $('#certificateId').append('<option value="0" label="Select certificateId Code" />');
	        $.each(mainData1 , function(i , obj)
	  		{
	  				$('#certificateId').append('<option value='+obj+' >'+obj+'</option>');		
	  		});  
	      }
	      });
}

function redirectTogenerateCertificate( certificateId,  result , loginId , traineeId ){
	
 var certificateId = (certificateId == null ? "" :certificateId );
var tpName = (tpName == null ? "" :tpName );
var address = (address == null ? "" :address );

$("#mainCertificateId").val(certificateId);
$("#loginId").val(parseInt(loginId));
$("#traineeId").val(parseInt(traineeId));
if(result != "P" ){
	//
	$("#generateCourseCertificateForm").attr("action" , "generateCourseCertificateGO.fssai");
	$("#generateCourseCertificateForm").submit();	
}else{
	alert("Not Eligible to generate Cerificate, Need to clear Test");
	return false;
}
 
	
}


function showDetails(){
	
	var courseType =  ($("#courseType").val()== null ? "" : $("#courseType").val());
	 var courseName = ( $("#courseName").val() == null ? "" : $("#courseName").val());
	var batchCode =( $("#batchCode").val() == null ? "" :  $("#batchCode").val());
	var trainingStartDate =( $("#trainingStartDate").val() == null ? "" : $("#trainingStartDate").val());
	var trainingEndDate = ( $("#trainingEndDate").val() == null ? "" : $("#trainingEndDate").val()  );
	 
 	var total = courseType+"@"+courseName+"@"+batchCode+"@"+trainingStartDate+"@"+trainingEndDate+"@"+window.userId;
	$(".displayNone").css("display","block");
	var result="";
 	var name1=JSON.stringify({
		courseType:0
  })
  
	$.ajax({
		type: 'POST',
		url: 'certificateForTraineeList.fssai?data='+ total,
		 contentType : "application/json",
		 data:name1,
		async: false, 
		success: function (data){
		$('#newTable').show();
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[0]+'</td><td>'+obj[1]+'</td><td id="trainingStart'+j+'" >'+obj[2]+'</td><td id="trainingEnd'+j+'">'+obj[3]+'</td><td id="traineeName'+j+'">'+obj[4]+'</td><td><button  onclick="redirectTogenerateCertificate( \''+obj[5]+'\'  , \''+obj[8]+'\'  , \''+obj[9]+'\'  , \''+obj[10]+'\');return false;" >Generate Certificate</button></td></tr>');
			
		});
		}
		});
	return result; 
}



</script>

<cf:form action="" name="myForm"  method="POST" commandName="generateCourseCertificateForm" id="generateCourseCertificateForm"  >

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
                  <h3>Generate Cerificate</h3>
                  </legend>
                  <div class="row">
                    <div class="col-xs-12"> 
                      
                      <!-- left side -->
                      <div class="col-md-6 col-xs-12">
                        <div class="form-group" id="CT">
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
						<cf:select path="courseType" id="courseType" name="courseType" class="form-control" onchange="getCourseName(this.value ,'courseName' );">
						<cf:option value="0" label="Select Course Type" />
						<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/>
						</cf:select>
                        </div>
                    

              			<div class="form-group" id="BC">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Batch Code:<span style="color:red;">*</span></strong></li>
                              <li class="style-li error-red">
                               <label id="batchcodeError" class="error visibility">select Batch Code</label>
                               <cf:errors path="courseName" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
					<cf:select path="batchCode" id="batchCode" name="batchCode" class="form-control" >
					<cf:option value="" label="Select Batch Code" /> 
					</cf:select>
                        </div>

													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training
																		Start Time</strong></li>
																<li class="style-li error-red"></li>
															</ul>
														</div>
														<input type="text" class="form-control"
															path="trainingEndDate" id="trainingEndDate">
													</div>

												</div>
                      <!-- right side -->
												<div class="col-md-6 col-xs-12">

													<div class="form-group" id="CN">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Course Code:<span
																		style="color: red;">*</span></strong></li>
																<li class="style-li error-red"><label
																	id="courseNameError" class="error visibility">Select
																		Course Code</label> <cf:errors path="courseName"
																		cssclass="error" /></li>
															</ul>
														</div>
														<cf:select path="courseName" id="courseName"
															name="courseName" class="form-control"
															onchange="getBatch(this.value , 'batchCode')">
															<cf:option value="0" label="Select Course Code" />
														</cf:select>
													</div>

													<div class="form-group">
														<div>
															<ul class="lab-no">
																<li class="style-li"><strong>Training
																		Start Date:</strong></li>
																<li class="style-li error-red"></li>
															</ul>
														</div>
														<input type="text" class="form-control" id="trainingStartDate" path="trainingStartDate">
													</div>
													
							
                    							  <cf:input path="mainCertificateId" id="mainCertificateId" name="mainCertificateId" type="hidden" class="form-control" />
                        						<cf:input path="loginId" id="loginId" name="loginId" type="hidden" class="form-control" />
                        						<cf:input path="traineeId" id="traineeId" name="traineeId" type="hidden" class="form-control" />

												</div>
												<input type="button"  style="margin-top:20px;"  class="btn login-btn pull-right show-details-vacancy collapsed"  data-target="#show-result" aria-expanded="false" onclick="showDetails();return false;" value="Show Details"> 
                   
                    
                    </div>
                    <div class="col-md-3 hidden-xs"></div>
                  </div>
                </fieldset>
              </div>
              <!-- search Results -->
              
              
                 <div  id="show-result" > 
                <!-- table -->
                <div class="row">
                  <div class="col-xs-12">
                    <fieldset style="margin-top: 20px;">
                      <legend>
                      <h4>Search results</h4>
                      </legend>
                      <div id="dvData">
                     <table class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No.</th>
                            <th>Batch Code</th>
                            <th>Course Code</th>
                            <th>Training Start Date</th>
                            <th>Training End Date</th>
                            <th>Participant Name</th>
                            <th>Generate Certificate</th>
                            
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
