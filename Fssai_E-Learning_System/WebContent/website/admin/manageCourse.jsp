<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="website/js/commonController.js"></script>

<script type='text/javascript'>
function OnStart(){
	searchManageCourse('ALL');
	console.log("PROFILEID "+PROFILEID);
	if(PROFILEID=="1"){
		$("#btnCreate").css("display" , "none");
	}
}


window.onload = OnStart;

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

function searchManageCourse(indicator){
// 	alert('lll');
	var courseType =  $("#courseType").val();
	var courseName = $("#courseName").val();
	var freePaid = $("#freePaid").val();
	var duration = $("#duration").val();
	if(courseType==0)
		courseType="";
	if(freePaid==0)
		freePaid="";
		
	var online = document.getElementById('online').checked;
	
	var classroom= document.getElementById('classroom').checked; 
	
	var status = $("#status").val();
	$(".displayNone").css("display","block");
	 {
		var result="";
		var total = "";
		if(indicator.match('ALL')){
			total = "ALL";//"contentLocation=0&courseType=0&courseName=&modeOfTraining=&contentType=0";
		}else{
		total = "courseType="+courseType+"-courseName="+courseName+"-freePaid="+freePaid+"-status="+status+"-duration="+duration;
		}
		
		var name1=JSON.stringify({
			courseType:0,
			courseName:0
	  })
		$.ajax({
		type: 'post',
		url: 'searchManageCourse.fssai?data='+ total,
		contentType : "application/json",
		 data:name1,
		async: false, 
		success: function (data){
		$('#newTable').show();
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Course Code</th><th>Course Type</th><th>Course Name</th><th>Duration</th><th>Free/ Paid</th><th>Online</th><th>Classroom</th><th>Status</th><th>Option</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
			var stat ;
			if(obj[5] == 'A'){
				stat = 'Active';
			}else{
				stat ='In-Active';
			}
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><input type="hidden" id="courseTypeVal'+i+'" value="'+obj[0]+'">'+obj[0]+'<td>'+obj[9]+'</td><td><input type="hidden" id="courseTypeL'+i+'" value="'+obj[1]+'">'+obj[1]+'</td><td><input type="hidden" id="courseNameL'+i+'" value="'+obj[2]+'">'+obj[2]+'</td><td><input type="hidden" id="durationL'+i+'" value="'+obj[3]+'">'+obj[3]+'</td><td><input type="hidden" id="freepaidL'+i+'" value="'+obj[4]+'">'+obj[4]+'</td><td><input type="hidden" id="onlineL'+i+'" value="'+obj[7]+'">'+obj[7]+'</td><td><input type="hidden" id="classroomL'+i+'" value="'+obj[8]+'">'+obj[8]+'</td><td><input type="hidden" id="statusL'+i+'" value="'+stat+'">'+stat+'</td><td><input type="hidden" id="cnid'+i+'" value="'+obj[6]+'"><a href="#" onClick="editManageCourse(\''+i+'\',\''+obj[0]+'\');">edit</a> </td></tr>');	
		});
		}
		});
	return result;
	}
}

</script>
<script>
function editManageCourse(i,courseType){
	var c =  $("#cnid"+i).val();
	$('.error-red').html('');
	document.getElementById('idHidden').value = c;
	document.getElementById('hiddenCourseType').value =  $("#courseTypeL"+i).val();
	var courseNameLL =  $("#courseNameL"+i).val();
	var durationLL =  $("#durationL"+i).val();
	var freepaidLL =  $("#freepaidL"+i).val();
	var onlineLL =  $("#onlineL"+i).val();
	var classroomLL =  $("#classroomL"+i).val();
	var statusLL =  $("#statusL"+i).val();
	document.getElementById('courseType').value = courseType;
	document.getElementById('btnUpdate').style.display = 'block';
	document.getElementById('btnCreate').style.display = 'none';

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
	$('.error-red').html('');
	var courseType = ($("#hiddenCourseType").val() == null ? "" : $("#hiddenCourseType").val()); 
	var courseName = ($("#courseName").val() == null ? "" : $("#courseName").val());
	var duration = ($("#duration").val() == null ? "" : $("#duration").val());
	var classroom =  ($("#classroom").prop("checked") == null ? "" : $("#classroom").prop("checked") );
	var online = ( $("#online").prop("checked") == null ? "" : $("#online").prop("checked"));
	console.log("online "+online);
	var status = ($("#status").val()== null ? "" : $("#status").val() );
	var freePaid = ($("#freePaid").val() == null ? "" : $("#freePaid").val());
	var idHidden =  ($("#idHidden").val() == null ? "" : $("#idHidden").val());
	document.getElementById('btnUpdate').style.display = 'none';
	document.getElementById('btnCreate').style.display = 'block';
	$(".displayNone").css("display","block");
	 
		var result="";
		var total = "freePaid="+freePaid+"-courseName="+courseName+"-online="+online+"-status="+status+"-duration="+duration+"-id="+idHidden+"-classroom="+classroom;
		console.log("total "+total);
	//	alert(idHidden);
		$('#newTable').hide();
		var name1=JSON.stringify({
			courseType:0,
			courseName:0
	  })
	 	$.ajax({
		type: 'post',
		url: 'editManageCourseData.fssai?data='+ total,
		 contentType : "application/json",
		  data:name1,
		      success: function (response) {
		       $( '#name_status' ).html(response);
		      }
		      });
	 	location.reload();
	 	return true;
	
	//searchManageCourse();
	
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
         <%@include file="../roles/top-menu.jsp"%>
    </section>
    <!-- main body -->
    <section class="main-section-margin-top">
        <div class="container-fluid">
            <div id="wrapper">
                <!-- Sidebar -->
                <div > <%@include file="../roles/slider.jsp" %>
                </div>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName }</span> </a>
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
                                                            <span id="name_status" class = "clear-label"> </span>
                                                            ${created }</li>
                                                        </ul>
                                                    </div>
<cf:select path="courseType" class="form-control">
<cf:option value="0" label="Select Course" />
<cf:options items="${courseTypeList}" itemValue="CourseTypeId" itemLabel="CourseType"/>
</cf:select>


                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Code:</strong></li>
                                                            <li class="style-li error-red"><label class="error visibility" id="courseError">* error</label></li>
                                                        </ul>
                                                    </div>
                                                   <cf:input path="courseName"   placeholder="Course Code" class="form-control"   />
                                                </div>
                                                
                                                 <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Duration:</strong></li>
                                                            <li class="style-li error-red">
                                                            <label class="error visibility" id="durationError">* error</label></li>
                                                        </ul>
                                                    </div>
                                                  <cf:input path="duration"  onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"   placeholder="In Hours" class="form-control"   />
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
                                              
                                                
<a href="#" onclick="editManageCourseData();return false;" id="btnUpdate" style="display: none; padding: 6px 7px; width: 20%; margin-bottom: 0; font-size: 14px; 
font-weight: normal; line-height: 1.42857143; text-align: center; white-space: nowrap; vertical-align: middle;
 -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; -webkit-user-select: none; 
 -moz-user-select: none; -ms-user-select: none; user-select: none; background-image: none; border: 1px solid transparent;
  background: #ef580d !important; color: #fff; border: 1px solid transparent; transition: all 0.8s linear;">Update</a>

<a href="#testt" class="pull-right" onclick="searchManageCourse('SELECTED');">Search</a>
                                               
                                                </div>
                                            </div>
                                           
                                        </div>

                                       
                                    </div>
                                </div>

                                <!-- search Results -->
                             <!--    <div  id="testt" class="displayNone" aria-expanded="false" style="height: 0px;"> -->
                                 <div class="col-xs-12 displayNone" id="show-result" aria-expanded="false" style="height: 0px;">    
                                    <!-- table -->
                                    <div class="row">
                                        <div >
                                            <fieldset>
                                                <legend>Search Result</legend>
                                                
                                                <table class="table table-bordered table-responsive" id="newTable" >
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <!-- <th>Course Code</th> -->
                                                        <th>Course Type</th>
                                                        <th>Course Code</th>
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