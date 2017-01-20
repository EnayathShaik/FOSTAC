<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function OnStart(){
	var steps = 1;
	var traineeSteps =
		<%=(Integer) session.getAttribute("traineeSteps")%>
	if(steps > traineeSteps){
	}else{
		if(steps-1 == traineeSteps){
			alert('Please Complete Your Previous Training First')
		}else{
			alert('Please Flow Step By Step..');
		}
		window.location.href ='/Fssai_E-Learning_System/loginProcess.fssai';
	}
}
window.onload = OnStart;

function confirmTrainee(){
	if(confirm("(Trainee can enroll to one course at one time,another course enrollment will be done after the completion of last step i.e. Generate Certificate).?")){
    }
    else{
        return false;
    }
}
function getDistrict(val)
{
	$.ajax({
	      type: 'post',
	      url: 'loadDistrict.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      $('#trainingCenterCity option').remove();
	      $('#trainingCenterCity').append('<option value="0" label="Select District" />');
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  		
	  				$('#trainingCenterCity').append('<option value='+obj.districtId+' label='+obj.districtName+' />');		
	  		});
	      }
	      });     
}

function getCourseDetails(){
	var courseName =  $("#courseName").val();
	var modeOfTraining =  $("#modeOfTraining").val();
	var trainingPatrtner =  $("#trainingPartner").val();
	var trainingDate =  $("#trainingDate").val();
	var trainingCenterState =  $("#trainingCenterState").val();
	var trainingCenterDistrict =  $("#trainingCenterCity").val();
	//alert(courseName + "  "+ modeOfTraining+"  "+ trainingPatrtner);
	//alert(trainingDate + "  "+ trainingCenterState+"  "+ trainingCenterDistrict);
	var result;
	var total="courseName="+courseName+"&modeOfTraining="+modeOfTraining+"&trainingPatrtner="+trainingPatrtner+"&trainingDate="+trainingDate+"&trainingCenterState="+trainingCenterState+"&trainingCenterDistrict="+trainingCenterDistrict;
	//alert(total);
	
	$.ajax({
	      type: 'post',
	      url: 'getCourseDetails.jspp?'+ total,
	      success: function (response) { 
	    	  //alert('kjgkghghhggjkgkggkggjhg');
	      var mainData1 = jQuery.parseJSON(response);
	     // alert(mainData1);
	     $('#newTable').show();
	     $(".displayNone").css("display","block");
	      var j=1;
		 $('#newTable tr').remove();
			$('#newTable').append('<tr  class="background-open-vacancies"><th>Select</th><th>Training Center Name & Address</th><th>Training Schedule</th><th>	Center Contact Person Name, Mobile & Email Id</th><th>Seating Capacity</th><th>Seats available</th></tr>')
			$.each(mainData1 , function(i , obj)
			{
			$('#newTable').append('<tr id="tableRow"><td><input type="hidden" name="getCalander" id="h" value="'+obj[0]+'" /><input type="radio" name="getCalander" onclick="gettid(this.value);" id="trainingCalendarIdd"  value="'+obj[0]+'"/></td><td>'+obj[1]+'</td><td>'+obj[2]+'</td><td>'+obj[3]+'</td><td>'+obj[5]+'</td><td>'+obj[6]+'</td></tr>');	
			//document.getElementById("trainingCalendarId").value = i;
			}); 
			}
			});
	return result; 
}


function getCourseTrainingType(){
	
	var data =  $("#courseName").val();
	console.log("data "+data);
	$.ajax({
		type: 'post',
	    url: 'getCourseTrainingMode.jspp?'+data,
	    success: function (response) {      
	    	console.log("Success respose" + response);
	    if(response == "Online"){
	    	$("#modeOfTraining").val("Online");
	    }else{
	    	$("#modeOfTraining").val("Classroom");
	    }
	   
		},
		failure: function (response){
			console.log("Failure response:" + response);
		}
	});
}

</script>
<script>
function gettid(value){
		document.getElementById("trainingCalendarId").value = value;
}
</script>
<cf:form action="advanceTraineeSave.fssai" name="myForm" method="POST" commandName="advanceTrainee" >
    <section>
       <%@include file="../roles/top-menu.jsp"%>
    </section>

    <!-- main body -->
    <section class="main-section-margin-top">
      <div class="container-fluid">
        <div id="wrapper"> 

          <!-- Sidebar menu -->
    
<%@include file="../roles/slider.jsp" %>
          <!-- Sidebar menu --> 
          <div id="page-content-wrapper">
            <div class="container-fluid"> 

              <!-- vertical button -->
              <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> 
            <span class="orange-font">Welcome Trainee</span>
            <cf:input type="hidden" path="personalinformationtraineeid" value="${personalinformationtraineeid }" />
            <cf:input type="hidden" path="loginId" value="${loginId }" />
            <cf:input type="hidden" path="trainingCalendarId" value="" />
             </a> </div>
          </div>


              <!-- add the content here for main body --> 

              <!-- timeline  -->
              <section class="section-form-margin-top">
                <div class="personel-info">
                <div class="container-fluid">

                <!-- login form -->
                <div class="row">
                <div class="col-xs-12">
                  <fieldset >
                    <legend><h3>Course Enrollment: Advance Course</h3></legend>              
                    <div class="row"></div>
                    <form>
                      <!-- left side -->
                      <div class="col-md-6 col-xs-12">
                        <div class="form-group">
                          <label>Course Name</label> &nbsp;&nbsp;<label> ${created}</label>
							<cf:select path="courseName" class="form-control" onchange="getCourseTrainingType();">
							<cf:option value="0" label="Select Course" />
							<cf:options items="${advanceCourseNameList}" itemValue="coursenameid" itemLabel="coursename" />
							</cf:select>
                        </div>
                        <div class="form-group">
                          <label>Training Partner</label>
<cf:select path="trainingPartner" class="form-control">
<cf:option value="0" label="Select Training Partner" />
<cf:options items="${trainingPartnerList}" itemValue="manageTrainingPartnerId" itemLabel="trainingPartnerName" />
</cf:select>
                        </div>
                        <div class="form-group">
                          <label>Training Centre: State</label>
<cf:select path="trainingCenterState" class="form-control" onchange="getDistrict(this.value);">
<cf:option value="0" label="Select State" />
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
</cf:select>
                        </div>

                        <!-- residential address --> 

                      </div>

                      <!-- right side -->
                      <div class="col-md-6 col-xs-12">
                        <div class="form-group">
                          <label>Mode of Training</label>
<cf:select path="modeOfTraining" class="form-control">
<cf:option value="0" label="Select Mode of Training"></cf:option>
<cf:option value="Online" label="Online" />
<cf:option value="Classroom" label="Classroom" />
</cf:select>
                        </div>
                        <div class="form-group">
                          <label>Training Date</label>
                          <input type="date" id="trainingDate" class="form-control" placeholder="Training Date">
                        </div>
                        <div class="form-group">
                          <label>Training Centre: District</label>
<cf:select path="trainingCenterCity" class="form-control">
<cf:option value="0" label="Select District" />
</cf:select>
                        </div>
                        
                        
                        
                        <!-- business address --> 
                      </div>
                      <div class="col-md-6 col-xs-12">
                        <div class="form-group">
            
<a href="#" onclick="getCourseDetails();" class="form-control login-btn btn pull-right" style="width: 50%;">Show Details</a>
                        </div>

                        <!-- residential address --> 

                      </div>
                    </form>
                    <div class="col-md-2 hidden-xs"></div>
                  </fieldset>
                </div>
              </section>
              <section class="section-form-margin-top">
                <div class="container-fluid"> 

                  <!-- login form -->              
                  <div id="testt" class="displayNone" aria-expanded="false" style="height: 0px; display:none;">
                    <div class="col-xs-12">
                    <fieldset>
                    <legend><h3 class="text-capitalize heading-3-padding">Certification Course</h3></legend>
                    <table  id="newTable"  class="table-bordered table table-responsive table-striped table-hover">
                        <thead>
                          <tr id="newTable" class="background-open-vacancies">
                            <!-- <td>Select</td>
                            <td>Training Center Name & Address</td>
                            <td>Training Schedule</td>
                            <td>Center Contact Person Name, Mobile & Email Id</td>
                            <td>Seating Capacity</td>
                            <td>Seats available</td> -->
                          </tr>
                        </thead><tbody></tbody>
                      </table>
                       <div class="col-xs-12 pull-right">
                        <input style="margin-top:20px; width:100px;" onclick="return confirmTrainee();" type="submit" class="form-control login-btn btn" value="Enroll" />
                      </div>
                    </fieldset>                  

                    </div>
                    <div class="col-md-2 hidden-xs"></div>
                  </div>
                </div>
              </section>
</div></div></div></div></section></cf:form>