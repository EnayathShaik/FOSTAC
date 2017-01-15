<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
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
var result="";
var response="";

function editApplicationStatus(){
	//var id = document.getElementById("assessmentAgencyId").value;
	var data=JSON.stringify({
		courseType:$('#selCourseType').val()==null?0:$('#selCourseType').val(),
		courseName:$('#selCourseName').val()==null?0:$('#selCourseName').val(),
		trainingDate:$('#trainingdate').val()
  });
	$.ajax({
	      type: 'post',
	      url: 'editApplicationStatusDetails.fssai',
	      contentType : "application/json",
	      data: data,
	      success: function (response) {
	    	 response=JSON.parse(response);
	    	 console.log(response)
// 	    	 for(index=0;index<response.length;index++){
//          	  console.log(response[index]);
//          	  $('#applicaionStatus').append('<tr>'+
//          		'<td>'+(index+1)+'</td><td>'+response[index].courseTypeName+'</td>'+
//          	    '<td>'+response[index].courseName+'</td>'+
//          	    '<td>'+response[index].trainingDate.replace("-","/").replace("-","/")+'</td>'+
//          	     '<td>'+response[index].noOfVacancy+'</td>'+
//          	    '<td><a href="#" onClick="editApplicationStatus('+index+')">'+response[index].noOfApplications+'</td> '+
//          	  	'</tr>');
//            }
	      }
	      });
}
function showDetail(){
	
	
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
	//var id = document.getElementById("assessmentAgencyId").value;
	var data=JSON.stringify({
		courseType:$('#selCourseType').val()==null?0:$('#selCourseType').val(),
		courseName:$('#selCourseName').val()==null?0:$('#selCourseName').val(),
		trainingDate:$('#trainingdate').val(),
		trainingCenter:0
  });
	$.ajax({
	      type: 'post',
	      url: 'getApplicationStatusDetails.fssai',
	      contentType : "application/json",
	      data: data,
	      success: function (response) {
	    	 response=JSON.parse(response);
	    	 for(index=0;index<response.length;index++){
           	  console.log(response[index]);
           	  $('#applicaionStatus').append('<tr>'+
           		'<td>'+(index+1)+'</td><td>'+response[index].courseTypeName+'</td>'+
           	    '<td>'+response[index].courseName+'</td>'+
           	    '<td>'+response[index].trainingDate.replace("-","/").replace("-","/")+'</td>'+
           	     '<td>'+response[index].noOfVacancy+'</td>'+
           	    '<td><a href="editApplicationStatusDetails.fssai?courseType='+response[index].courseTypeId+'&&courseName='+response[index].courseNameId+'">'+response[index].noOfApplications+'</td> '+
           	  	'</tr>');
             }
	      }
	      });

}
function showDetails() {
	
		var courseType =  ($("#selCourseType").val() == null ? "" : $("#selCourseType").val());
		var courseName =  ($("#selCourseName").val() == 0 ? "" :  $("#selCourseName").val());
		alert(courseName);
		var trainingDate = $("#trainingdate").val(); //  .replace("-","/").replace("-","/");
	
		
	$(".displayNone").css("display", "block");
	var total = "courseType="+courseType+"&courseName="+courseName+"&trainingDate="+trainingDate;
	var result = "";
	$.ajax({
		type : 'post',
		url : 'getApplicationStatusDetails.jspp?' + total,
		async : false,
		success : function(data) {
			$('#newTable').show();
			var mainData1 = jQuery.parseJSON(data);
			var j = 1;
			$('#newTable tr').remove();
			$.each(mainData1, function(i, obj) {
				$('#newTable').append(
						'<tr id="tableRow"><td>' + j++ + '</td><td>'
								+ obj[0] + '</td><td>' + obj[1]
								+ '</td><td>' + obj[2] + '</td><td>'
								+ obj[3] + '</td><td></td></tr>');

			});
		}
	});
	return result;
}

</script>
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
                                        <legend><h3>Trainer Application Status</h3></legend>
                                        <script type="text/javascript">
                                        var formObj = '${trainingpartnerapplicationstatus}';
                                        var formData = JSON.parse(formObj);
                                        var courseTypes = formData.courseTypes;
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
															var selectctpeOptions = "<option disabled selected value> -- select courseType -- </option>";
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
                                                                <li class="style-li"><strong>Training Date:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="date" id="trainingdate" class="form-control">
                                                    </div>
                                                     <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="showDetails();">Show Details</button>
                                               <input type="button" id="btnExport" style="margin-right: 20px;"  class="btn login-btn pull-right" value="Download" />
                                                </div>
                                               
                                            </div>

                                            <div class="col-md-3 hidden-xs"></div>
                                        </div>
                                        </fieldset>


                                    </div>

<!--                                     search Results -->
<!--                         search Results -->
              <div class="col-xs-12 collapse table-overflow-responsive" id="show-result" aria-expanded="false" style="height: 0px;"> 
<!--                 table -->
                <div class="row">
                  <div class="col-xs-12">
                    <fieldset style="margin-top: 20px;">
                      <legend>
                      <h4>Current Application Status</h4>
                      </legend>
                      
<div id="dvData">
                      <table id ="tableData" class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
						    <th>S.No</th>
                            <th>Course Type</th>
                            <th>Course Name</th>
                            <th>Training Date</th>
                            <th>No. of Vacancies</th>
                            <th>No. Of Applications</th>
                          </tr>
                        </thead>
                        <tbody id="newTable">
			</tbody>
			</div>
              </div>
</table>
</fieldset>
</div>
</div>
</div>
<%-- </cf:form> --%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
