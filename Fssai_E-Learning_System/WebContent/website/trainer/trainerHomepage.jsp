<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<%System.out.print("trainee home page jsp"); %>
<!--/#footer-->
<script src="website/js/bootstrap.min.js"></script> 

<script src="website/js/jquery.js"></script> 
 <script src="website/js/bootstrap.min.js"></script> 
<!-- <script src="website/js/jquery.isotope.min.js"></script>  -->
<!-- horizontal navigation -->

<script type="text/javascript">
function OnStart(){
	searchUpcomingTraining();
}
window.onload = OnStart;

function searchUpcomingTraining(){
	var name1=JSON.stringify({
		courseName:0
  })
	$.ajax({
	type: 'post',
	url: 'searchUpcomingTraining.fssai?data=',
	  contentType : "application/json",
	  data:name1,
	async: false, 
	success: function (data){
	$('#newTable').show();
	var mainData1 = jQuery.parseJSON(data);
	console.log(mainData1);
//		alert(mainData1);
	var j=1;
	$('#newTable tr').remove();
	$.each(mainData1 , function(i , obj)
	{
		var a = null;
		var statuss = obj[9];
		if(statuss == "A"){
			a = "Confirmed";
		$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[7]+'</td><td>'+obj[10]+'</td><td>'+obj[2]+'</td><td>'+obj[1]+'</td><td>'+obj[3]+'</td><td>'+obj[4]+'</td></tr>');
		}
		
	});
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
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName}</span> </a> </div>
          </div>
          
          <!-- add the content here for main body --> 
          <!-- timeline  -->
          
          <div class="container-fluid">
            <div class="row"> 
              
              <!-- table -->
              <div class="row">
                <div class="col-xs-12 table-overflow-responsive">
                  <div class="personel-info">
                    <fieldset>
                      <legend>
                      <h3 style="padding-bottom:20px;">My Training Calendar</h3>
                      </legend>
                      <table class="table table-bordered table-hover table-striped table-responsive table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No.</th>
                            <th>Course Type</th>
                            <th>Course Code</th>
                            <th>Training Date &amp; Time</th>
                            <th>Training Center Name &amp; Address</th>
                            <th>Contact Person Name</th>
                            <th>Contact Person Phone Number &amp; Email ID</th>
                          </tr>
                        </thead>
                        <tbody id="newTable">
                        </tbody>
                      </table>
<!--                       <div class="row"> -->
<!--                         <div class="col-md-6 hidden-xs"></div> -->
<!--                         pagination -->
<!--                         <div class="col-md-6 col-xs-12 pagination-right"> -->
<!--                           <nav aria-label="Page navigation"> -->
<!--                             <ul class="pagination pull-right"> -->
<!--                               <li> <a href="#" aria-label="Previous"> <span aria-hidden="true">«</span> </a> </li> -->
<!--                               <li><a href="#">1</a></li> -->
<!--                               <li><a href="#">2</a></li> -->
<!--                               <li><a href="#">3</a></li> -->
<!--                               <li><a href="#">4</a></li> -->
<!--                               <li><a href="#">5</a></li> -->
<!--                               <li> <a href="#" aria-label="Next"> <span aria-hidden="true">»</span> </a> </li> -->
<!--                             </ul> -->
<!--                           </nav> -->
<!--                         </div> -->
<!--                       </div> -->
                    </fieldset>
                  </div>
                </div>
              </div>
              <!-- row ends --> 
              <br>
              <!-- open vacancies table -->
              <!-- <div class="col-xs-12"> 
                table
                <div class="row">
                  <div class="col-xs-12 table-overflow-responsive">
                    <fieldset>
                      <legend>
                      <h3 style="padding-bottom:20px;">Open Vacancies</h3>
                      </legend>
                      <table class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th width="8%">S.No</th>
                            <th width="15%">Course Type</th>
                            <th width="14%">Course Name</th>
                            <th width="29%">Training Date &amp; Time</th>
                            <th width="23%">Training Center Name &amp; Address</th>
                            <th width="11%"></th>
                          </tr>
                        </thead>
                        <tbody id="traineePostVacancy">
                        </tbody>
                      </table>
                    </fieldset>
                  </div>
                </div>
              </div>
              <br> -->
              <!-- job application -->
              <!-- <div class="col-xs-12"> <br>
                table
                <div class="row">
                  <div class="col-xs-12 table-overflow-responsive">
                    <fieldset>
                      <legend>
                      <h3 style="padding-bottom:20px;">Job Application</h3>
                      </legend>
                     
                      <table class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No</th>
                            <th width="15%">Course Type</th>
                            <th>Course Name</th>
                            <th width="29%">Training Date &amp; Time</th>
							<th width="29%">Training Date &amp;</th>
                            <th width="23%">Training Center Name &amp; Address</th>
                            <th>Status</th>
                          </tr>
                        </thead>
                        <tbody id="applicationStatusList">
                        </tbody>
                      </table>
                    </fieldset>
                  </div>
                </div>
              </div> -->
              <!-- <script type="text/javascript">
                  $(document).ready(function(){    
                	  var postVacancyList=${postVacancyTrainingCenter};
                	  var statusList=['Selected','Rejected','Under Process']
                	  var applicationStatusList=${vacancyTrainingCenterBeans};
                	  for(var index=0;index<applicationStatusList.length;index++){
                		  var statusTR=""
                			  if(applicationStatusList[index].status=="Selected"){
                				  	statusTR= '<td class="bg-success">Selected</td>';
                            	    }else if(applicationStatusList[index].status=="Rejected"){
                            	    	statusTR= '<td class="bg-danger">Rejected</td>';
                            	    }else if(applicationStatusList[index].status=="Under Process"){
                            	    	statusTR='<td class="bg-primary">Under Process</td>';
                            	    }
                		  $('#applicationStatusList').append('<tr>'+
                          		'<td>'+(index+1)+'</td><td>'+applicationStatusList[index].coursetypeName+'</td>'+
                          	    '<td>'+applicationStatusList[index].strCourseName+'</td>'+
                          	    '<td><p><strong>Date:</strong>'+postVacancyList[index].trainingDate.replace("-","/").replace("-","/")+'</td>'+
                          	    '<td>'+applicationStatusList[index].personalInformationTrainingPartner.TrainingCentreName+','+applicationStatusList[index].personalInformationTrainingPartner.TrainingPartnerPermanentLine1+' '+applicationStatusList[index].personalInformationTrainingPartner.TrainingPartnerPermanentLine2+'</td> '+statusTR+'</tr>');
                	  }
                	  
                	  console.log(applicationStatusList);
                      for(index=0;index<postVacancyList.length;index++){
                    	  console.log(postVacancyList[index]);
                    	  $('#traineePostVacancy').append('<tr>'+
                    		'<td>'+(index+1)+'</td><td>'+postVacancyList[index].courseType.CourseType+'</td>'+
                    	    '<td>'+postVacancyList[index].courseName.coursename+'</td>'+
                    	    '<td><p><strong>Date:</strong>'+postVacancyList[index].trainingDate.replace("-","/").replace("-","/")+'</td>'+
                    	    '<td>'+postVacancyList[index].trainingCenter.TrainingCentreName+','+postVacancyList[index].trainingCenter.TrainingPartnerPermanentLine1+' '+postVacancyList[index].trainingCenter.TrainingPartnerPermanentLine2+'</td> '+
                    	    '<td> <button id=button'+index+' onclick="applyForVacancy('+index+')" class="btn btn-default">Apply</button></td>'+
                    	  	'</tr>');
                      }
                  });
              
              </script> -->
              <!-- timeline -->
             <%--  <%@include file="../commonjsp/trainee-steps.jsp"%> --%>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- scripts --> 
<!-- <script>
                /* var id = localStorage.getItem('activeID');
                document.getElementById(id).className = "active"; */

            </script>
 -->