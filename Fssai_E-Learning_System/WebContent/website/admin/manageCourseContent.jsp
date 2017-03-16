<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="website/js/commonController.js"></script>
<script type='text/javascript'>
function OnStart(){
	searchManageCourseContent('ALL');
	console.log("PROFILEID "+PROFILEID);
	if(PROFILEID=="1"){
		$("#btnCreate").css("display" , "none");
		$(".edit").css("display" , "none");
		$(".delete").css("display" , "none");
	}
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
<script>
function getContentName(val)
{
	console.log("val "+val);
	$.ajax({
	      type: 'post',
	      
	      url: 'loadCourseName.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	    
	      $('#courseName option').remove();
	     $('#courseName').append('<option value="0" label="Select Course Code" />');
	      $.each(mainData1 , function(i , obj)
	  		{                                                                                                                                         
	  				$('#courseName').append('<option value='+obj[0]+'>'+obj[1]+'</option>');		
	  		});
	      }
	      });     
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
	async:false,
	url: 'editCourseContentDataMCC.jspp?'+ total,
	data: {
		   user_name:name,
		  },
		  success: function (response) {
			   $( '#name_status' ).html(response);
		  }
	});
	location.reload();
return result;
}

function searchManageCourseContent(indicator){
	var contentLocation =  $("#contentLocation").val();
	var courseType =  $("#courseType").val();
	var courseName = $("#courseName").val();
	var modeOfTraining = $("#modeOfTraining").val();
	var contentType =  $("#contentType").val(); 

	var contentLink =  $("#contentLink").val(); 
	var contentName =  $("#contentName").val(); 
	if(contentLocation==0)
		contentLocation="";
	if(courseType==0)
		courseType="";
	if(courseName==0)
		courseName="";
	if(modeOfTraining==0)
		modeOfTraining="";
	if(contentType==0)
		contentType="";
	$(".displayNone").css("display","block");
		 {
		var result="";
		var total ="";
		if(indicator.match('ALL')){
			total = "ALL";//"contentLocation=0&courseType=0&courseName=&modeOfTraining=&contentType=0";
		}else{
			total = "contentLocation="+contentLocation+"&courseType="+courseType+"&courseName="+courseName+"&modeOfTraining="+modeOfTraining+"&contentType="+contentType+"&contentLink="+contentLink+"&contentName="+contentName+"";
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
		$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Content Location</th><th>Course Type</th><th>Course Code</th><th>Mode of Training</th><th>Content Type</th><th>Content Name</th><th>Content Link</th><th>Option	</th></tr>')
		$.each(mainData1 , function(i , obj)
		{

			$('#newTable').append('<tr id="tableRow"><td>'+ j++ +'</td><td>'+ obj[3]+'</td><td>'+ obj[1] +'</td><td>'+ obj[0] +'</td><td>'+ obj[4] +'</td><td>'+ obj[5] +'</td><td><input type="hidden" id="contentNameLabel" value="'+ obj[6] +'" />'+  obj[6] +'</td><td><input type="hidden" id="contentLinkLabel" value="'+ obj[2] +'" />'+ obj[2] +'</td><td><input type="hidden" id="idLabel'+i+'" value="'+ obj[7] +'" /> <a href="#" class="edit" onClick="editCourseContent(\''+obj[3]+'\',\''+obj[1]+'\',\''+obj[0]+'\',\''+obj[4]+'\',\''+obj[5]+'\',\''+obj[2]+'\',\''+obj[6]+'\',\''+i+'\');">edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="delete" onClick="deleteCourseContent('+i+');">delete</a></td></tr>');
		});
		}
		});
	return result;
	}
}

function editCourseContent(location , courseType , courseName ,modeOfTraining , contentType ,link ,contentName,i){
	$('.error-red').html('');
	console.log("-----> "+location + " "+courseType + " " +courseName + " "+modeOfTraining + " "+contentType + " "+contentName + " "+link);
	document.getElementById('mccId').value =  $("#idLabel"+i).val();
	document.getElementById('btnUpdate').style.display = 'block';
	document.getElementById('btnCreate').style.display = 'none';
	$("#contentLocation").val(location);
	$("#courseType option").filter(function() {
	    return this.text == courseType; 
	}).attr('selected', true);
	$("#courseName option").filter(function() {
	    return this.text == courseName; 
	}).attr('selected', true);
	$("#modeOfTraining").val(modeOfTraining);
	$("#contentType").val(contentType);
	$("#contentName").val(contentName);
	$("#contentLink").val(link);
	
	//$(contentLocation).attr("readOnly", "true");
}

function deleteCourseContent(i){
	$('.error-red').html('');
	var contentLink =  $("#contentLinkLabel").val();
	var contentName = $("#contentNameLabel").val();
	
	 var result = confirm("Do you want to delete this record?");
	 
	 if(result){
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
				async : false,
				url: 'deleteCourseContent.jspp?'+ total,
				data: {
				       user_name:name,
				      },
				      success: function (response) {
				       $( '#name_status' ).html(response);
				      }
				      });
				OnStart();
			return true;
			
			}
 
	 }
	}

</script>
<cf:form action="manageCourseContentSearch.fssai" name="myForm" method="POST" commandName="manageCourseContent" onsubmit="return validateFields();"> 

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
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName }</span> </a>
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
<cf:option value="0" label="Content Location" />
<cf:option value="Website" label="Website" />
<cf:option value="Application" label="Application" />
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
<cf:option value="0" label="Select Course Type" />
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

<cf:select path="courseType" class="form-control" onchange="getCourseName(this.value , 'courseName');">
<cf:option value="0" label="Select Course Type" />
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
<cf:option value="0" label="Select Mode of Training" />
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
                                                    
                                              
                                                
  
                                                    <button id="btnCreate"  class="btn login-btn">Create</button>
                                              		<a href="#testt" class="btn login-btn" onclick="searchManageCourseContent('SELECTED');">Search</a>
                                                
<a href="#" onclick="editCourseContentData();" id="btnUpdate" style="display: none; padding: 6px 7px; width: 20%; margin-bottom: 0; font-size: 14px; 
font-weight: normal; line-height: 1.42857143; text-align: center; white-space: nowrap; vertical-align: middle;
 -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; -webkit-user-select: none; 
 -moz-user-select: none; -ms-user-select: none; user-select: none; background-image: none; border: 1px solid transparent;
  background: #ef580d !important; color: #fff; border: 1px solid transparent; transition: all 0.8s linear;">Update</a>
                                               


                                
   
                                            
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
                                                        <th>Course Code</th>
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