<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function OnStart(){
	var profileId = '${profileId}';
	
	if(profileId == 3){
		
		$("#CT").css("display" , "none");
		$("#CN").css("display" , "none");
		$("#BC").css("display" , "none");
		
		var userId = '${userId}';
		
		getCertificate('');
		
		
	}
	
	
}

window.onload = OnStart;
</script>
<script>


function checkVacancyType(){
	
	var vacancyType = $("#vacancyType").val();
	console.log("vacancyType "+vacancyType);
	
	if(vacancyType=="P"){
		
		$("#displayStartDate").css("display","block");
		$("#displayEndDate").css("display","block");
	}
	
}

function getCourseName(val){
	$.ajax({
	      type: 'post',
	      url: 'getCourseName.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	       $('#courseName option').remove();
	      $('#courseName').append('<option value="0" label="Select Course Code" />');
	        $.each(mainData1 , function(i , obj)
	  		{
	  				$('#courseName').append('<option value='+obj[0]+' >'+obj[1]+'</option>');		
	  		});
	      }
	      });
}


function getBatch(val){
	var courseType = $("#courseType").val();
	var coursename = val;
	var data = coursename;
 	var name=JSON.stringify({
		courseType:0,
		courseName:0
  })
	$.ajax({
	      type: 'post',
	      url: 'getBatchCode.fssai?data='+data,
	      contentType : "application/json",
	      data:name,
	      success: function (response) {   
	    	
	    	 
	      var mainData1 = jQuery.parseJSON(response);
 	        $('#batchCode option').remove();
	      $('#batchCode').append('<option value="0" label="Select Batch Code" />');
	        $.each(mainData1 , function(i , obj)
	  		{
	  				$('#batchCode').append('<option value='+obj+' >'+obj+'</option>');		
	  		});  
	      }
	      });
}
//getCertificateID

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
	    	 // alert(response);
	    	 
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

function getdata(val){
	
	$("#mainCertificateId").val(val);
}
</script>

<cf:form action="generateCourseCertificateGO.fssai" name="myForm" method="POST" commandName="generateCourseCertificateForm" id="generateCourseCertificateForm"  >

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
						<cf:select path="courseType" class="form-control" onchange="getCourseName(this.value);">
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
					<cf:select path="batchCode" class="form-control" onchange="getCertificate(this.value)">
					<cf:option value="0" label="Select Batch Code" />
					<%--  <cf:options items="${batchcodeList}" itemValue="coursenameid" itemLabel="coursename"/> --%> 
					</cf:select>
                        </div>
                        
                      
                          <div class="form-group" id="displayStartDate" >
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Certificate ID:</strong></li>
                              <li class="style-li error-red">
                               <label id="certificateIdError" class="error visibility">enter certificateId date</label>
                               <cf:errors path="certificateId" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
                     <cf:select path="certificateId" class="form-control" onchange="getdata(this.value)">
					<cf:option value="0" label="Select certificateId Code" />
					<%-- <cf:options items="${courseNameList}" itemValue="coursenameid" itemLabel="coursename"/> --%>
					</cf:select>
                        </div>
                        
                      </div>
                      <!-- right side -->
                      <div class="col-md-6 col-xs-12">
                      
                          <div class="form-group" id="CN">
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Course Code:<span style="color:red;">*</span></strong></li>
                              <li class="style-li error-red">
                               <label id="courseNameError" class="error visibility">select course name</label>
                               <cf:errors path="courseName" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
					<cf:select path="courseName" class="form-control" onchange="getBatch(this.value)">
					<cf:option value="0" label="Select Course Code" />
					<%-- <cf:options items="${courseNameList}" itemValue="coursenameid" itemLabel="coursename"/> --%>
					</cf:select>
                        </div>
                       
                     
                           <div class="form-group" id="displayStartDate" >
                          <div>
                            <ul class="lab-no">
                              <li class="style-li"><strong>Certificate ID:</strong></li>
                              <li class="style-li error-red">
                               <label id="certificateIdError" class="error visibility">enter certificateId date</label>
                               <cf:errors path="mainCertificateId" cssclass="error"/>
                               </li>
                            </ul>
                          </div>
                      <cf:input path="mainCertificateId" id="mainCertificateId" type="text" class="form-control" />
                        </div>
  
                      </div>
                      <input type="submit" style="margin-top:20px;"  class="btn login-btn pull-right show-details-vacancy collapsed"  data-target="#show-result" aria-expanded="false" value="GO">
                   
                    
                    </div>
                    <div class="col-md-3 hidden-xs"></div>
                  </div>
                </fieldset>
              </div>
              <!-- search Results -->
              
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</cf:form>
