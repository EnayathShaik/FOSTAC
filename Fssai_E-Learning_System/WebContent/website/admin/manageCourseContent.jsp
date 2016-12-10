<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type='text/javascript'>
function OnStart(){
	searchManageCourseContent('ALL');
}
window.onload = OnStart;
function validateFields() {
	if(document.getElementById("contentLink").value=="") {
	document.getElementById("contentLink").style.borderColor = "red";
	document.getElementById("contentLinkError").style.display = 'block';
	document.getElementById("contentLink").focus();
	return false;
	}else{
	    document.getElementById('contentLink').style.borderColor = "#ccc";
	    document.getElementById("contentLinkError").style.display = 'none';
	    }
	if(document.getElementById("contentName").value=="") {
		document.getElementById("contentName").style.borderColor = "red";
		document.getElementById("contentNameError").style.display = 'block';
		document.getElementById("contentName").focus();
		return false;
		}else{
		    document.getElementById('contentName').style.borderColor = "#ccc";
		    document.getElementById("contentNameError").style.display = 'none';
		    }
	return true;
}
</script>
<script type='text/javascript'>
function editCourseContentData(){
	var mccId  =  document.getElementById('mccId').value;
	var contentLocation =  $("#contentLocation").val();
	var courseType =  $("#courseType").val();
	var courseName = $("#courseName").val();
	var modeOfTraining = $("#modeOfTraining").val();
	var contentType =  $("#contentType").val(); 
	var contentLink =  $("#contentLink").val();
	var contentName =  $("#contentName").val();
	$(".displayNone").css("display","block");
	var result="";
	var total = mccId+","+contentLocation+","+courseType+","+courseName+","+modeOfTraining+","+contentType+","+contentLink+","+contentName;
	$.ajax({
	type: 'post',
	url: 'editCourseContentDataMCC.jspp?'+ total,
	data: {
		   user_name:name,
		  },
		  success: function (response) {
			   $( '#name_status' ).html(response);
		  }
	});
return result;
}

function searchManageCourseContent(indicator){
	var contentLocation =  $("#contentLocation").val();
	var courseType =  $("#courseType").val();
	var courseName = $("#courseName").val();
	var modeOfTraining = $("#modeOfTraining").val();
	var contentType =  $("#contentType").val(); 
	$(".displayNone").css("display","block");
		 {
		var result="";
		var total ="";
		if(indicator.match('ALL')){
			total = "contentLocation=0&courseType=0&courseName=&modeOfTraining=&contentType=0";
		}else{
			total = "contentLocation="+contentLocation+"&courseType="+courseType+"&courseName="+courseName+"&modeOfTraining="+modeOfTraining+"&contentType="+contentType+"";
		}
		$.ajax({
		type: 'post',
		url: 'searchManageCourseContent.jspp?'+ total,
		async: false, 
		success: function (data){		
		$('#newTable').show();
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Content Location</th><th>Course Type</th><th>Course Name</th><th>Mode of Training</th><th>Content Type</th><th>Content Name</th><th>Content Link</th><th>Option	</th></tr>')
		$.each(mainData1 , function(i , obj)
		{

			$('#newTable').append('<tr id="tableRow"><td>'+ j++ +'</td><td>'+ obj[3]+'</td><td>'+ obj[1] +'</td><td>'+ obj[0] +'</td><td>'+ obj[4] +'</td><td>'+ obj[5] +'</td><td><input type="hidden" id="contentNameLabel" value="'+ obj[6] +'" />'+  obj[6] +'</td><td><input type="hidden" id="contentLinkLabel" value="'+ obj[2] +'" />'+ obj[2] +'</td><td><input type="hidden" id="idLabel'+i+'" value="'+ obj[7] +'" /> <a href="#" onClick="editCourseContent('+i+');">edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onClick="deleteCourseContent('+i+');">delete</a></td></tr>');
		});
		}
		});
	return result;
	}
}

function editCourseContent(i){
	document.getElementById('mccId').value =  $("#idLabel"+i).val();
	document.getElementById('btnUpdate').style.display = 'block';
	document.getElementById('btnCreate').style.display = 'none';
	document.getElementById('contentLink').value = document.getElementById('contentLinkLabel').value;
	document.getElementById('contentName').value = document.getElementById('contentNameLabel').value;
	//$(contentLocation).attr("readOnly", "true");
}

function deleteCourseContent(i){
	var contentLink =  $("#contentLinkLabel").val();
	var contentName = $("#contentNameLabel").val();
	var id = $("#idLabel"+i).val();
	document.getElementById('btnUpdate').style.display = 'none';
	document.getElementById('btnCreate').style.display = 'block';
	$(".displayNone").css("display","block");
	 {
		var result="";
		var total = id;
		$('#newTable').hide();	
		$.ajax({
		type: 'post',
		url: 'deleteCourseContent.jspp?'+ total,
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
<cf:form action="manageCourseContentSearch.fssai" name="myForm" method="POST" commandName="manageCourseContent" onsubmit="return validateFields();"> 

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
                                <ul class="nav navbar-nav" >
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
                <!-- Sidebar -->
                <div> <%@include file="leftMenuAdmin.jspf" %>
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
                        <div class="row">

                                <div class="col-xs-12">
                                    <h1>Manage Course Content</h1>
                                    <div class="row">
                                        <div class="col-xs-12">

                                            <!-- left side -->
                                            <div class="col-xs-6">
                                                
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Content Location:</strong></li>
                                                            <li class="style-li error-red">${created}<span id="name_status"></span></li>
                                                        </ul>
                                                    </div>
<cf:select path="contentLocation" class="form-control">
<cf:option value="Website" label="Website" />
<cf:option value="Application" label="Application" />
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
<cf:options items="${courseNameList}" itemValue="coursenameid" itemLabel="coursename"/>
</cf:select> 
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Content Type:</strong></li>
                                                            <li class="style-li error-red">
                                                            
                                                            </li>
                                                        </ul>
                                                    </div>
<cf:select path="contentType" class="form-control">
<cf:option value="PPTs" label="PPTs" />
<cf:option value="Videos" label="Videos" />
<cf:option value="StudyMaterial" label="Study Material" />
</cf:select>
                                                </div>
 <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Content Name:</strong></li>
                                                            <li class="style-li error-red">
                                                            <label class="error visibility" id="contentNameError">* error</label>
                                                            <cf:errors path="contentName" cssClass="error" /></li>
                                                        </ul>
                                                    </div>
<cf:input path="contentName" class="form-control" />
                                                </div>                                                
                                                
                                            </div> <!-- left side ends -->

                                            <!-- right side -->
                                            <div class="col-xs-6">
                                                
                                                
                                                 <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Type:</strong></li>
                                                            <li class="style-li error-red"></li>
                                                        </ul>
                                                    </div>
<cf:select path="courseType" class="form-control">
<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/>
</cf:select>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Mode of Training:</strong></li>
                                                            <li class="style-li error-red"></li>
                                                        </ul>
                                                    </div>
<cf:select path="modeOfTraining" class="form-control">
<cf:option value="Online" label="Online" />
<cf:option value="Classroom" label="Classroom" />
</cf:select>
                                                </div>
                                              
                                               <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Content Link:</strong></li>
                                                            <li class="style-li error-red">
                                                            <label class="error visibility" id="contentLinkError">* error</label>
                                                            <cf:errors path="contentLink" cssClass="error" />  </li>
                                                        </ul>
                                                    </div>
<cf:input path="contentLink" class="form-control" />
                                                </div>  
                                            </div> <!-- rigth side ends -->
                                            <br><br>
                                            <!-- button -->
                                            <div class="row">
                                                <div class="col-md-6 col-xs-12"></div>
                                                
                                                <div class="col-md-6 col-xs-12" style="margin-top: 26px;">
                                                    
                                              
                                                
  
                                                    <button id="btnCreate" class="btn login-btn">Create</button>
                                              
                                                
<a href="#" onclick="editCourseContentData();" id="btnUpdate" style="display: none; padding: 6px 7px; width: 20%; margin-bottom: 0; font-size: 14px; 
font-weight: normal; line-height: 1.42857143; text-align: center; white-space: nowrap; vertical-align: middle;
 -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; -webkit-user-select: none; 
 -moz-user-select: none; -ms-user-select: none; user-select: none; background-image: none; border: 1px solid transparent;
  background: #ef580d !important; color: #fff; border: 1px solid transparent; transition: all 0.8s linear;">Update</a>
                                               


                                
<a href="#testt" class="pull-right" onclick="searchManageCourseContent('SELECTED');">Search</a>   
                                            
                                                </div>
                                            </div>
                                           
                                        </div>

                                       
                                    </div>
                                </div>

                                <!-- search Results -->
                                <div class="col-xs-12">
                                    
                                    <!-- table -->
                                    <div class="row">
                                        <div class="col-xs-12 displayNone"  style="display:none;">
                                             <fieldset>
                                                <legend>Course Content</legend>
                                                
                                                <table id="newTable" class="table table-bordered table-responsive ">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                       
                                                        <th>Content Location</th>
                                                        <th>Course Type</th>
                                                        <th>Course Name</th>
                                                        <th>Mode of Training</th>
                                                        <th>Content Name</th>
                                                        <th>Content Link</th>
                                                         <th>Option</th>
                                                         
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                
  <%--                                             
                                                    <tr>
                                                        <td>
<cf:select path="contentLocationInput" class="form-control">
<cf:option value="Website" label="Website" />
<cf:option value="Application" label="Application" />
</cf:select>														
														<td>
<cf:select path="courseTypeInput" class="form-control">
<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/>
</cf:select>
                                                        
                                                        </td>
                                                        <td>
<cf:select path="courseNameInput" class="form-control">
<cf:options items="${courseNameList}" itemValue="coursenameid" itemLabel="coursename"/>
</cf:select>                                                        
                                                        </td>
                                                        <td>
<cf:select path="modeOfTrainingInput" class="form-control">
<cf:option value="Online" label="Online" />
<cf:option value="Classroom" label="Classroom" />
</cf:select>                                                       
                                                        </td>
                                                        <td>
<cf:select path="contentTypeInput" class="form-control">
<cf:option value="PPTs" label="PPTs" />
<cf:option value="Videos" label="Videos" />
<cf:option value="StudyMaterial" label="Study Material" />
</cf:select>                                                        
                                                        </td>
                                                        <td>
<cf:input path="contentNameInput" placeholder="Content Name" /></td>
      
                                                        <td>
 <cf:input path="contentLinkInput" placeholder="Content Name" />                                                       
  <!--  <input type="file" name="contentLinkInput" /> -->                                                     
</td>
  <td><a href="#" onclick="manageCourseContentLink();">save</a> </td>                                                      
                                                    </tr>
    --%>                                                
                                                </tbody>
                                            </table>
                                                
                                             
                                              
                                            </fieldset>
                                            
                                        </div>
                                    </div>
                                </div> <!-- search div ends -->

                            </div><!-- row ends -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <input type="hidden" id="mccId" value="" />
    </cf:form>