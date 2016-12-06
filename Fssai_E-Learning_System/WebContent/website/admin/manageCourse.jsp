<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>


<script type='text/javascript'>
function validateFields() {
	if(document.getElementById("courseName").value=="") {
	document.getElementById("courseName").style.borderColor = "red";
	document.getElementById("courseError").style.display = 'block';
	document.getElementById("courseName").focus();
	return false;
	}else{
	    document.getElementById('courseName').style.borderColor = "#ccc";
	    document.getElementById("courseError").style.display = 'none';
	    }
	if(document.getElementById("duration").value=="") {
		document.getElementById("duration").style.borderColor = "red";
		document.getElementById("durationError").style.display = 'block';
		document.getElementById("duration").focus();
		return false;
		}else{
		    document.getElementById('duration').style.borderColor = "#ccc";
		    document.getElementById("durationError").style.display = 'none';
		    }
	if(document.getElementById("freePaid").value=="") {
		document.getElementById("freePaid").style.borderColor = "red";
		document.getElementById("freePaidError").style.display = 'block';
		document.getElementById("freePaid").focus();
		return false;
		}else{
		    document.getElementById('freePaid').style.borderColor = "#ccc";
		    document.getElementById("freePaidError").style.display = 'none';
		    }
	return( true );
}

function searchManageCourse(){
// 	alert('lll');
	var courseType =  $("#courseType").val();
	var courseName = $("#courseName").val();
	var freePaid = $("#freePaid").val();
	var online = document.getElementById('online').checked;
	
	var classroom= document.getElementById('classroom').checked; 
	
	var status = $("#status").val();
	$(".displayNone").css("display","block");
	 {
		var result="";
		var total = "courseType="+courseType+"&courseName="+courseName+"&freePaid="+freePaid+"&status="+status+"&online="+online+"&classroom="+classroom;
		$.ajax({
		type: 'post',
		url: 'searchManageCourse.jspp?'+ total,
		async: false, 
		success: function (data){
		$('#newTable').show();
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Course Type</th><th>Course Name</th><th>Duration</th><th>Free/ Paid</th><th>Online</th><th>Classroom</th><th>Status</th><th>Option</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
			var stat ;
			if(obj[4] == 'A'){
				stat = 'Active';
			}else{
				stat ='In-Active';
			}
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td><input type="hidden" id="courseTypeL'+i+'" value="'+obj[0]+'">'+obj[0]+'</td><td><input type="hidden" id="courseNameL'+i+'" value="'+obj[1]+'">'+obj[1]+'</td><td><input type="hidden" id="durationL'+i+'" value="'+obj[2]+'">'+obj[2]+'</td><td><input type="hidden" id="freepaidL'+i+'" value="'+obj[3]+'">'+obj[3]+'</td><td><input type="hidden" id="onlineL'+i+'" value="'+obj[6]+'">'+obj[6]+'</td><td><input type="hidden" id="classroomL'+i+'" value="'+obj[7]+'">'+obj[7]+'</td><td><input type="hidden" id="statusL'+i+'" value="'+stat+'">'+stat+'</td><td><input type="hidden" id="cnid'+i+'" value="'+obj[5]+'"><a href="#" onClick="editManageCourse('+i+');">edit</a> </td></tr>');	
		});
		}
		});
	return result;
	}
}

</script>
<script>
function editManageCourse(i){
	var c =  $("#cnid"+i).val();
	document.getElementById('idHidden').value = c;
	document.getElementById('hiddenCourseType').value =  $("#courseTypeL"+i).val();
	var courseNameLL =  $("#courseNameL"+i).val();
	var durationLL =  $("#durationL"+i).val();
	var freepaidLL =  $("#freepaidL"+i).val();
	var onlineLL =  $("#onlineL"+i).val();
	var classroomLL =  $("#classroomL"+i).val();
	var statusLL =  $("#statusL"+i).val();
	document.getElementById('btnUpdate').style.display = 'block';
	document.getElementById('btnCreate').style.display = 'none';
	//$("#courseType").attr("disabled", "disabled");
	document.getElementById('courseName').value = courseNameLL; 
	document.getElementById('duration').value = durationLL;
	if(freepaidLL=="free"){
		$('#freePaid option').remove();
		$('#freePaid').append('<option value="free" selected="true">free</option><option value="paid">paid</option>');
	}else{
		$('#freePaid option').remove();
		$('#freePaid').append('<option value="free">free</option><option value="paid"  selected="true">paid</option>');
	}
	
	if(statusLL=="Active"){
		$('#status option').remove();
		$('#status').append('<option value="A" selected="true">Active</option><option value="I">In-active</option>');
	}else{
		$('#status option').remove();
		$('#status').append('<option value="A">Active</option><option value="I"  selected="true">In-active</option>');
	}
	
	if(onlineLL=="Online"){
		document.getElementById('online').checked = true;
	}else{
		document.getElementById('online').checked = false;
	}
	if(classroomLL=="Classroom"){
		document.getElementById('classroom').checked = true;
	}else{
		document.getElementById('classroom').checked = false;
	}
}
</script>
<script>
function editManageCourseData(){
	var courseType = $("#hiddenCourseType").val(); 
	var courseName = $("#courseName").val();
	var duration = $("#duration").val();
	var classroom =  $("#classroom").val();
	var online =  $("#online").val();
	var status = $("#status").val();
	var freePaid = $("#freePaid").val();
	var idHidden =  $("#idHidden").val();
	document.getElementById('btnUpdate').style.display = 'none';
	document.getElementById('btnCreate').style.display = 'block';
	$(".displayNone").css("display","block");
	 {
		var result="";
		var total = "freePaid="+freePaid+"&courseName="+courseName+"&online="+online+"&status="+status+"&duration="+duration+"&id="+idHidden+"&classroom="+classroom;
		alert(idHidden);
		$('#newTable').hide();
		
		$.ajax({
		type: 'post',
		url: 'editManageCourseData.jspp?'+ total,
		data: {
		       user_name:name,
		      },
		      success: function (response) {
		       $( '#name_status' ).html(response);
		      }
		      });
	//return true;
	searchManageCourse();
	}
}

function deleteManageCourse(){
	////alert('data delete');
	var idHidden =  $("#idLabel").val();
	var status = $("#statusLabel").val();
	document.getElementById('btnUpdate').style.display = 'none';
	document.getElementById('btnCreate').style.display = 'block';
	$(".displayNone").css("display","block");
		var total = "id="+idHidden+"&status="+ status+ "";
		$('#newTable').hide();
		
		////alert(total);
		$.ajax({
		type: 'post',
		url: 'deleteManageCourse.jspp?'+ total,
		data: {
		       user_name:name,
		      },
		      success: function (response) {
		       $( '#name_status' ).html(response);
		      }
		      });
		////alert (result);
	return true;
	}
</script>
<cf:form action="manageCourse.fssai" name="myForm" method="POST" commandName="manageCourse" onsubmit="return validateFields();"> 

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
                                <ul class="nav navbar-nav" style="padding-left:92px;">
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
                <div > <%@include file="leftMenuAdmin.jspf" %>
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
                                    <h1>Manage Course</h1>
                                    <div class="row">
                                        <div class="col-xs-12">

                                            <!-- left side -->
                                            <div class="col-xs-6">
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Type:</strong></li>
                                                            <li class="style-li error-red">
                                                            <span id="name_status"> </span>
                                                            ${created }</li>
                                                        </ul>
                                                    </div>
<cf:select path="courseType" class="form-control">
<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/>
</cf:select>


                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Name:</strong></li>
                                                            <li class="style-li error-red"><label class="error visibility" id="courseError">* error</label></li>
                                                        </ul>
                                                    </div>
                                                   <cf:input path="courseName"   placeholder="Course Name" class="form-control"   />
                                                </div>
                                                
                                                 <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Duration:</strong></li>
                                                            <li class="style-li error-red">
                                                            <label class="error visibility" id="durationError">* error</label></li>
                                                        </ul>
                                                    </div>
                                                  <cf:input path="duration"  onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"   placeholder="In Minutes" class="form-control"   />
                                                </div>
                                            </div> <!-- left side ends -->

                                            <!-- right side -->
                                            <div class="col-xs-6">
                                                
                                                 <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Free/ Paid:</strong></li>
                                                            <li class="style-li error-red"></li>
                                                        </ul>
                                                    </div>
<cf:select path="freePaid" class="form-control">
<cf:option value="0" label="Select" />
<cf:option value="free" label="Free" />
<cf:option value="paid" label="Paid" />
</cf:select>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Mode of Training:</strong></li>
                                                            <li class="style-li error-red"></li>
                                                        </ul>
                                                    </div>
                                                   <%-- <cf:select path="modeOfTraining" class="form-control">
<cf:option value="Online" label="Online" />
<cf:option value="Classroom" label="Classroom" />
</cf:select> --%>
<cf:checkbox path="classroom" id="classroom" class="from-control" value="" label="Classroom"/>
<cf:checkbox path="online" class="from-control" id="online" value="" label="Online"/>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Status:</strong></li>
                                                            <li class="style-li error-red"></li>
                                                        </ul>
                                                    </div>
                                                   <cf:select path="status" class="form-control">
<cf:option value="A" label="Active" />
<cf:option value="I" label="In-active" />
</cf:select>
                                                </div>
                                         
                                                
                                            </div> <!-- rigth side ends -->
                                            
                                            <!-- button -->
                                            <div class="row">
                                                <div class="col-md-6 col-xs-12"></div>
                                                
                                                <div class="col-md-6 col-xs-12">
                                               
                                                
                                                    <button id="btnCreate" class="btn login-btn">Create</button>
                                              
                                                
<a href="#" onclick="editManageCourseData();" id="btnUpdate" style="display: none; padding: 6px 7px; width: 20%; margin-bottom: 0; font-size: 14px; 
font-weight: normal; line-height: 1.42857143; text-align: center; white-space: nowrap; vertical-align: middle;
 -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; -webkit-user-select: none; 
 -moz-user-select: none; -ms-user-select: none; user-select: none; background-image: none; border: 1px solid transparent;
  background: #ef580d !important; color: #fff; border: 1px solid transparent; transition: all 0.8s linear;">Update</a>

<a href="#testt" class="pull-right" onclick="searchManageCourse();">Search</a>
                                               
                                                </div>
                                            </div>
                                           
                                        </div>

                                       
                                    </div>
                                </div>

                                <!-- search Results -->
                                <div  id="testt" class="displayNone" aria-expanded="false" style="height: 0px; display:none;">
                                    
                                    <!-- table -->
                                    <div class="row">
                                        <div >
                                            <fieldset>
                                                <legend>Search Result</legend>
                                                
                                                <table class="table table-bordered table-responsive" id="newTable" style="display: none">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <!-- <th>Course Code</th> -->
                                                        <th>Course Type</th>
                                                        <th>Course Name</th>
                                                        <th>Duration</th>
                                                        <th>Free/ Paid</th>
                                                        <th>Mode of Training</th>
                                                        <th>Status</th>
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody id="rowdata">
                                                                                              
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
 
 <input type="hidden" id="idHidden" value="" />
 <input type="hidden" id="hiddenCourseType" value="" />                                             
   </cf:form>