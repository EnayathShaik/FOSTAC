<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

function OnStart(){
	loadTrainingCenter();
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

function loadTrainingCenter(){
	var trainingCenter = $("#userId").val();
	$('#personalInformationTrainingPartnerId').val(trainingCenter);
	
	$.ajax({
	
		type:'post',
		url : 'loadFeedbackMaster.jspp',
		success: function (response){
			
			var data =  jQuery.parseJSON(response);
			console.log("data "+data);
			   $('#trainee').append('<option value="0" label="--Select Trainee--" />');
		        $.each(data , function(i , obj)
		  		{
		  				$('#trainee').append('<option value='+obj[0]+' >'+obj[1]+'</option>');		
		  		});
			
		} 
		
	})
	
}



</script>
<script>

function showDetails(){
	var trainingCenter = $("#userId").val();
	var trainee = $("#trainee").val();
	var courseid = $("#selCourseType").val();
	var courseName = $("#selCourseName").val();
	var trainingDate = $("#trainingdate").val();
	var value = trainingCenter+"&"+trainee+"&"+courseid+"&"+courseName+"&"+trainingDate+"&";
	alert("value "+value);
	$(".displayNone").css("display","block");
	$.ajax({
	      type: 'post',
	      url: 'getFeedbackDetails.jspp?'+ value,
	      async: false, 
	      success: function (response) {
	    	 response=JSON.parse(response);
	    	 if(response.length==0){
	    		 $('#show-result').hide();
	    	 }else{
	    		 $('#show-result').show();
	    	 }
	    	 
	    	    $.each(response , function(i , obj)
	    		  		{
	    		  				console.log(obj +" "+ i);		
	    		  		});
	    	 for(index=0;index<response.length;index++){
				var objec=response[index];
				var rdStr=""
				for(var radioIndex=0;radioIndex<5;radioIndex++){
					if((radioIndex+1)==parseInt(objec[2])){
					rdStr+='<td class="text-center"><input type="radio" name="'+index+'" value="'+radioIndex+'" checked="checked" /></td> ';				
					}else{
						rdStr+='<td class="text-center"><input type="radio" name="'+index+'" value="'+radioIndex+'"/></td> '
					}
				}
				
	    		 $('#feedbackDetails').append('<tr>'+
           		'<td>'+objec[1]+'</td>'+rdStr+'</tr>');
             }
	      }
	      });

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
                                    <input type="hidden" id="userId" value='${loginUsertrainingpartner}' /> 
                                        <i class="fa fa-bars"></i> <span class="orange-font">Welcome : ${loginUserS.loginDetails.loginId}</span>
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
                                        <legend><h3>Feedback Details</h3></legend>
                                        <script type="text/javascript">
                                        var formObj = '${trainingpartnerapplicationstatus}';
                                        var formData = JSON.parse(formObj);
                                        var courseTypes = formData.courseTypes;
                                        var trainingCenterList=formData.trainingCenterList;
                                        console.log(trainingCenterList);
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
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Course Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="selCourseName" id = "selCourseName"> </select>
								 						
                                                    </div>
                                                    
                                                     <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Trainee Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                 
														<select class="form-control" name="trainee" id = "trainee"> </select>
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
                                                      <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Center Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="TrainingCentreName" id = "personalInformationTrainingPartnerId"> </select>
														
                                                    </div>
                                                     <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="showDetails();">Show Details</button>
                                                </div>
                                               
                                            </div>

                                            <div class="col-md-3 hidden-xs"></div>
                                        </div>
                                        </fieldset>
<script>
															var selectctpeOptions = "<option disabled selected value> -- select courseType -- </option>";
															for(var i=0 ; i < courseTypes.length; i++)
																{
																	console.log(courseTypes[i].CourseTypeId + " -- "+ courseTypes[i].CourseType);
																	selectctpeOptions += "<option value="+courseTypes[i].CourseTypeId+">"+courseTypes[i].CourseType+"</option>"
																	
																}
															document.getElementById('selCourseType').innerHTML += selectctpeOptions;
															
															var selectctTCpeOptions = "<option disabled selected value> -- select Training Center -- </option>";
															for(var i=0 ; i < trainingCenterList.length; i++)
																{
																	console.log(trainingCenterList[i].personalInformationTrainingPartnerId + " -- "+ trainingCenterList[i].TrainingCentreName);
																	selectctTCpeOptions += "<option value="+trainingCenterList[i].personalInformationTrainingPartnerId+">"+trainingCenterList[i].TrainingCentreName+"</option>"
																	
																}
															document.getElementById('personalInformationTrainingPartnerId').innerHTML += selectctTCpeOptions;
														</script>
														

                                    </div>

<!--                                     search Results -->
<!--                         search Results -->
              <div class="col-xs-12 displayNone"  style="display:none;">
<!--                 table -->
                <div class="row">
                  <div class="col-xs-12">
                    <fieldset style="margin-top: 20px;">
                      <legend>
                      <h4>Feed back details</h4>
                      </legend>
                                <table class="table table-bordered table-responsive table-striped table-hover">
                          <thead>
                        <tr class="background-open-vacancies">
                              <th>Feedback Point</th>
                              <th class="text-center">1</th>
                              <th class="text-center">2</th>
                              <th class="text-center">3</th>
                              <th class="text-center">4</th>
                              <th class="text-center">5</th>
                            </tr>
                      </thead>
                          <tbody id="feedbackDetails">
						    <tr id="Good">  
						    
					        <td>Good</td>
							  <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="1"></td> 
                             <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="2"></td> 
                             <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="3"></td>
                             <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="4"></td> 
                            <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="5"></td> 
						    </tr>
						      <tr id="vgood">  
					        <td> Very Good</td>
							  <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="1"></td> 
                             <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="2"></td> 
                             <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="3"></td>
                             <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="4"></td> 
                            <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="5"></td> 
						    </tr>
                      </tbody>
                        </table>
                    <div class="col-xs-12">
                          <ul class="feed-no">
                        <li class="feed-li"><span><strong>1</strong></span>&nbsp;<span>Poor</span></li>
                        <li class="feed-li"><span><strong>2</strong></span>&nbsp;<span>Good</span></li>
                        <li class="feed-li"><span><strong>3</strong></span>&nbsp;<span>Better</span></li>
                        <li class="feed-li"><span><strong>4</strong></span>&nbsp;<span>Best</span></li>
                        <li class="feed-li"><span><strong>5</strong></span>&nbsp;<span>Excellent</span></li>
                      </ul>
                        </div>
                    <div class="col-md-4 col-x-12"></div>
                    <div class="col-md-4 col-x-12"></div>
                    
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
