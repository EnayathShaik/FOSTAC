<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function OnStart(){
	searchCity('ALL');
}
window.onload = OnStart;
</script>
<script type='text/javascript'>
function searchCity(indicator){
	var stateId =  $("#stateId").val();
	var districtName =  $("#districtId").val();
	var cityName =  $("#cityName").val();
	var status =  $("#status").val();
	$(".displayNone").css("display","block");
	 {
		var result="";
		var total ="";
		 if(indicator.match('ALL')){
			total = "stateId=0&districtName=0&cityName=&status="+status;
		}else{ 
			total = "stateId="+stateId +"&districtName="+districtName+"&cityName="+cityName+"&status="+status;
		}
		$.ajax({
		type: 'post',
		url: 'searchCity.jspp?'+ total,
		async: false, 
		success: function (data){
		$('#newTable').show();
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>State Name</th><th>District Name</th><th>City Name</th><th>Status</th><th>Edit</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
			var status ;
	 		if(obj[3] == 'A'){
				status = 'Active';
			}else{
				status = 'In-Active';
			}
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td><input type="hidden" id="stateH" value="'+obj[0]+'">'+obj[0]+'</td><td><input type="hidden" id="districtH" value="'+obj[1]+'">'+obj[1]+'</td><td><input type="hidden" id="cityNameH" value="'+obj[2]+'">'+obj[2]+'</td><td><input type="hidden" id="statusH" value="'+obj[3]+'">'+status+'</td><td><input type="hidden" id="id" value="'+obj[4]+'"><a href="#" onclick="editCity();">edit</a></td></tr>');	
		});
		}
		});
	return result;
	}
}

function editCity(){
	//$('#cityName').attr('readonly', 'true');
	document.getElementById('btnUpdate').style.display = 'block';
	document.getElementById('btnCreate').style.display = 'none';
	var a = document.getElementById('stateH').value;
	var b = document.getElementById('districtH').value;
	var c = document.getElementById('statusH').value;
	stateId.options[0].text = a;
	$("#stateId").prop('selectedIndex',0);
	$("#stateId").prop("disabled", true);
	$('#districtId option').remove();
	$('#districtId').append('<option value="0" label="'+b+'" />');
	$("#districtId").prop("disabled", true);
	document.getElementById('cityName').value = document.getElementById('cityNameH').value;
	//var status = document.getElementById('statusLabel').value;
	if(c=="A"){
		$('#status option').remove();
		$('#status').append('<option value="A" selected="true">Active</option><option value="I">In-active</option>');
	}else{
		$('#status option').remove();
		$('#status').append('<option value="A">Active</option><option value="I"  selected="true">In-active</option>');
	}
}

function editCityData(){
	var status =  $("#status").val();
	var cityId = $("#id").val();
	alert(cityId);
	document.getElementById('btnUpdate').style.display = 'none';
	document.getElementById('btnCreate').style.display = 'block';
	$(".displayNone").css("display","block");
	 {
		var result="";
		var total = "status="+status+"&cityId="+cityId;
		alert(total);
		$('#newTable').hide();
		$.ajax({
		type: 'post',
		url: 'editCityData.jspp?'+ total,
		data: {
		       user_name:name,
		      },
		      success: function (response) {
		       $( '#name_status' ).html(response);
		      }
		      });
		//alert (result);
	return true;
	}
}

function deleteCity(){
	var cityId = $("#idLabel").val();
	document.getElementById('btnUpdate').style.display = 'none';
	document.getElementById('btnCreate').style.display = 'block';
	$(".displayNone").css("display","block");
	 {
		var result="";
		var total = cityId;
		alert(total);
		$('#newTable').hide();
		$.ajax({
		type: 'post',
		url: 'deleteCity.jspp?'+ total,
		data: {
		       user_name:name,
		      },
		      success: function (response) {
		       $( '#name_status' ).html(response);
		      }
		      });
		//alert (result);
	return true;
	}
}
</script>
<script>
function getDistrict(val)
{
	
	$.ajax({
	      type: 'post',
	      
	      url: 'loadDistrict.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	    
	      $('#districtId option').remove();
	      $('#districtId').append('<option value="0" label="Select District" />');
	      $.each(mainData1 , function(i , obj)
	  		{
	  		
	  				$('#districtId').append('<option value='+obj.districtId+' label='+obj.districtName+' />');		
	  		});
	      }
	      });     
}


</script>
<script>
function validateFields() {
	if(document.getElementById("stateId").value=="0") {
		document.getElementById('stateId').style.borderColor = "red";
    	document.getElementById("stateIdError").style.display = 'block';
    	document.getElementById("stateId").focus();
    	return false;
	}
	 else{
	    document.getElementById('stateId').style.borderColor = "#ccc";
	    document.getElementById("stateIdError").style.display = 'none';
	    } 
	if(document.getElementById("districtId").value=="0") {
		document.getElementById('districtId').style.borderColor = "red";
    	document.getElementById("districtIdError").style.display = 'block';
    	document.getElementById("districtId").focus();
    	return false;
	}
	 else{
	    document.getElementById('districtId').style.borderColor = "#ccc";
	    document.getElementById("districtIdError").style.display = 'none';
	    }
	if(document.getElementById("cityName").value=="") {
		document.getElementById('cityName').style.borderColor = "red";
    	document.getElementById("cityNameError").style.display = 'block';
    	document.getElementById("cityName").focus();
    	return false;
	}
	 else{
	    document.getElementById('cityName').style.borderColor = "#ccc";
	    document.getElementById("cityNameError").style.display = 'none';
	    }
}
</script>
<cf:form action="cityMasterSave.fssai" name="myForm" method="POST" commandName="cityMaster" onsubmit="return validateFields();"> 

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
                                <ul class="nav navbar-nav"  style="padding-left: 70px;">
                                    <li></li>
                                    <li class="hori"><a href="adminHomepage.fssai">Home</a></li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Management<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="traineeUserManagementForm.fssai" class="clr">Trainee</a></li>
                                            <li><a href="trainerUserManagementForm.fssai" class="clr">Trainer</a></li>
                                            <li><a href="trainingCenterUserManagementForm.fssai" class="clr">Training Center</a></li>
                                            <li><a href="assessorUserManagementForm.fssai" class="clr">Assessor</a></li>
                                            <li><a href="adminUserManagementForm.fssai" class="clr">Admin</a></li>
                                        </ul>
                                    </li>
                                    <li class="active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Master Data<span class="caret"></span></a>
                                       <ul class="dropdown-menu">
                                            <li><a href="stateMaster.fssai" class="clr">State</a></li>
                                            <li><a href="districtMaster.fssai" class="clr">District</a></li>
                                            <li><a href="cityMaster.fssai" class="clr">City</a></li>                                            
                                            <li><a href="regionMappingMaster.fssai" class="clr">Region Mapping</a></li>
                                        </ul>
                                        <li><a href="manageTrainingPartnerForm.fssai">Manage Training Partner</a></li>
                                    <li><a href="manageAssessmentAgencyForm.fssai">Manage Assessment Agency</a></li>
                                    </li>
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
                <!-- Sidebar -->
                <div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand"></li> -->
                        <li><a href="manageCourse.fssai">Manage Course</a></li>
                        <li><a href="manageCourseContent.fssai">Manage Course Content</a></li>
                        <li> <a href="trainingCalendarForm.fssai">Training Calendar</a> </li>
                        <li> <a href="assessmentSchedule.fssai">Assessment Schedule</a> </li>
                        <li> <a href="manageAssessmentQuestions.fssai">Assessment Questions</a> </li>
                        <li> <a href="updateTrainerAssessmentForm.fssai">Update Assessment</a> </li>
                    </ul>
                </div>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome TAdmin</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">

                                <div class="col-xs-12">
                                    <h1>City Master</h1>
                                    <div class="row">
                                        <div class="col-xs-12">

                                            <!-- left side -->
                                            <div class="col-xs-6">
                                            
                                          
                                                
                                                  <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>State Name:</strong></li>
                                                            <li class="style-li error-red">${created }
                                                            <label class="error visibility" id="stateIdError">select state</label>
                                                            </li>
                                                        </ul>
                                                    </div>
<cf:select path="stateId" class="form-control" onchange="getDistrict(this.value);">
<cf:option value="0" label="Select State" />
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName"/>
</cf:select>
                                                </div>
                                                 <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Status:</strong></li>
                                                        </ul>
                                                    </div>
<cf:select path="status" class="form-control">
<cf:option value="A" label="Active" />
<cf:option value="I" label="In-Active" />
</cf:select>
                                                </div>
                                                 
                                               
                                            </div> <!-- left side ends -->

                                            <!-- right side -->
                                            <div class="col-xs-6">
                                                   <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>District Name:</strong></li>
                                                            <li class="style-li error-red">
                                                            <label class="error visibility" id="districtIdError">select district</label>
                                                            </li>
                                                        </ul>
                                                    </div>
											<cf:select path="districtId" class="form-control" >
											<cf:option value="0" label="Select District" />
											<%-- <cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName"/> --%>
											</cf:select>
                                                </div>
                                               <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>City Name:</strong></li>
                                                            <li class="style-li error-red">
                                                            <label class="error visibility" id="cityNameError">enter city</label>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                     <cf:input path="cityName"   placeholder="City Name" class="form-control"   />
                                                </div>
                                                
                                              
                                                <div class="form-group">
                                                    <button id="btnCreate" class="btn login-btn">Create</button>
                                                    <input type="hidden" id="idHidden" value="">

<a href="#" onclick="editCityData();" id="btnUpdate" style="display: none; padding: 6px 7px; width: 20%; margin-bottom: 0; font-size: 14px; 
font-weight: normal; line-height: 1.42857143; text-align: center; white-space: nowrap; vertical-align: middle;
 -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; -webkit-user-select: none; 
 -moz-user-select: none; -ms-user-select: none; user-select: none; background-image: none; border: 1px solid transparent;
  background: #ef580d !important; color: #fff; border: 1px solid transparent; transition: all 0.8s linear;">Update</a>

                                                 
                                                  <a href="#testt" onclick="searchCity('SELECTED');" class="pull-right">Search</a>
                                                    
                                                </div>
                                                
                                            </div> <!-- rigth side ends -->
                                            
                                            <!-- button -->
                                            
                                           
                                        </div>

                                       
                                    </div>
                                </div>

                                <!-- search Results -->
                                <div class="col-xs-12 displayNone" id="show-result" aria-expanded="false" style="height: 0px; display:none;">
                                    
                                    <!-- table -->
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <fieldset>
                                                <legend>Search Result</legend>
                                                
                                                <table id="newTable" class="table table-bordered table-responsive">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>City Name</th>
                                                        <th>District Name</th>
                                                        <th>State Name</th>
                                                        <th>Status</th>
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    
                                                </tbody>
                                            </table>
                                            </fieldset>
                                            
                                        </div>
                                    </div>
                                </div> <!-- search div ends -->

                            </div> <!-- row ends -->
                       
                    </div>
                </div>
            </div>
        </div>
    </section>
    </cf:form>