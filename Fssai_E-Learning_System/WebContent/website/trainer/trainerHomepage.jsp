<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<%System.out.print("trainee home page jsp"); %>
<!--/#footer-->
<script src="website/js/jquery.js"></script> 
<script src="website/js/bootstrap.min.js"></script> 
<script src="website/js/jquery.isotope.min.js"></script> 
<!-- horizontal navigation -->
<<script type="text/javascript">
function applyForVacancy(coursetypeid,coursenameid,personalInformationTrainingPartnerId,loginId){
	console.log(coursetypeid);
	console.log(coursenameid);
	console.log(personalInformationTrainingPartnerId);
	var buttonID=window.event.currentTarget.id;
	var data=JSON.stringify({
		courseType:coursetypeid,
		courseName:coursenameid,
	  	trainingCenter:personalInformationTrainingPartnerId,
	  	loginId:loginId
  });
	$.ajax({
	      type: 'post',
	      url: 'applyForVacancy.fssai',
	      contentType : "application/json",
	      data: data,
	      success: function (response) {
	    	var response=JSON.parse(response);
			var msg=response.message;
	    	  $('#'+buttonID).text(msg);
	    	  $('#'+buttonID).prop("disabled",true);
	      }
	      });
}
</script>
<section>
<%@include file="topMenuTrainer.jspf" %>
</section>
<!-- main body -->
<section class="main-section-margin-top">
  <div class="container-fluid">
    <div id="wrapper"> 
      
      <!-- Sidebar -->
    <%@include file="leftMenuTrainer.jspf" %>
      <!-- /#sidebar-wrapper --> 
      <!-- Page Content -->
      <div id="page-content-wrapper">
        <div class="container-fluid"> 
          
          <!-- vertical button -->
          <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Trainer</span> </a> </div>
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
<!--                       <table class="table table-bordered table-hover table-striped table-responsive table-hover"> -->
                      Nothing is available for you
<!--                         <thead> -->
<!--                           <tr class="background-open-vacancies"> -->
<!--                             <th>S.No.</th> -->
<!--                             <th>Course Type</th> -->
<!--                             <th>Course Name</th> -->
<!--                             <th>Training Date &amp; Time</th> -->
<!--                             <th>Training Center Name &amp; Address</th> -->
<!--                             <th>Contact Person Name</th> -->
<!--                             <th>Contact Person Phone Number &amp; Email ID</th> -->
<!--                           </tr> -->
<!--                         </thead> -->
<!--                         <tbody> -->
<!--                           <tr> -->
<!--                             <td>1</td> -->
<!--                             <td>Basic</td> -->
<!--                             <td>GHP-GMP</td> -->
<!--                             <td><p><strong>Date:</strong> 12/01/2015</p> -->
<!--                               <p><strong>Time:</strong> 12:00 AM</p></td> -->
<!--                             <td>FSSAI, ITO</td> -->
<!--                             <td>Mr. Smith</td> -->
<!--                             <td>P: 98763524125 <br>E: ajun.j@gmail.com</td> -->
<!--                           </tr> -->
<!--                           <tr> -->
<!--                             <td>2</td> -->
<!--                             <td>Special</td> -->
<!--                             <td>HACCP</td> -->
<!--                             <td><p><strong>Date:</strong> 12/01/2015</p> -->
<!--                               <p><strong>Time:</strong> 12:00 AM</p></td> -->
<!--                             <td>FBO Bhavan, Kotla Road</td> -->
<!--                             <td>Mr. Smith</td> -->
<!--                             <td>P: 98763524125 <br>E: ajun.j@gmail.com</td> -->
<!--                           </tr> -->
<!--                           <tr> -->
<!--                             <td>3</td> -->
<!--                             <td>Advanced</td> -->
<!--                             <td>GHP-GMP-HACCP</td> -->
<!--                             <td><p><strong>Date:</strong> 12/01/2015</p> -->
<!--                               <p><strong>Time:</strong> 12:00 AM</p></td> -->
<!--                             <td>FSSAI, ITO</td> -->
<!--                             <td>Mr. Smith</td> -->
<!--                             <td>P: 98763524125 <br>E: ajun.j@gmail.com</td> -->
<!--                           </tr> -->
<!--                         </tbody> -->
<!--                       </table> -->
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
              <div class="col-xs-12"> 
                <!-- table -->
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
                  <script type="text/javascript">
                  $(document).ready(function(){    
                	  var postVacancyList=${postVacancyTrainingCenter};
                      for(index=0;index<postVacancyList.length;index++){
                    	  console.log(postVacancyList[index]);
                    	  $('#traineePostVacancy').append('<tr>'+
                    		'<td>'+(index+1)+'</td><td>'+postVacancyList[index].courseType.CourseType+'</td>'+
                    	    '<td>'+postVacancyList[index].courseName.coursename+'</td>'+
                    	    '<td><p><strong>Date:</strong>'+postVacancyList[index].trainingDate+'</td>'+
                    	    '<td>'+postVacancyList[index].trainingCenter.TrainingCentreName+','+postVacancyList[index].trainingCenter.TrainingPartnerPermanentLine1+' '+postVacancyList[index].trainingCenter.TrainingPartnerPermanentLine2+'</td> '+
                    	    '<td> <button id=button'+index+' onclick="applyForVacancy('+postVacancyList[index].courseType.CourseTypeId+','+postVacancyList[index].courseName.coursenameid+','+postVacancyList[index].trainingCenter.personalInformationTrainingPartnerId+','+postVacancyList[index].trainingCenter.loginDetails.id+')" class="btn btn-default">Apply</button></td>'+
                    	  	'</tr>');
                      }
                  });
              
              </script>
              <br>
              <!-- job application -->
              <div class="col-xs-12"> <br>
                <!-- table -->
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
                            <th width="23%">Training Center Name &amp; Address</th>
                            <th>Status</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>1</td>
                            <td>Basic</td>
                            <td>GHP-GMP</td>
                            <td><p><strong>Date:</strong> 12/01/2015</p>
                              <p><strong>Time:</strong> 12:00 AM</p></td>
                            <td>FSSAI, FDA Bhvan</td>
                            <td class="bg-success">Selected</td>
                          </tr>
                          <tr>
                            <td>2</td>
                            <td>Advance</td>
                            <td>HACCP Course for Oil & Fat Industry</td>
                            <td><p><strong>Date:</strong> 10/21/2016</p>
                              <p><strong>Time:</strong> 11:30:00 AM</p></td>
                            <td>FSSAI, Kotla Road</td>
                            <td class="bg-danger">Rejected</td>
                          </tr>
                          <tr>
                            <td>3</td>
                            <td>Special</td>
                            <td>HACCP Course for Water & Beverages Industry</td>
                            <td><p><strong>Date:</strong> 11/12/2016</p>
                              <p><strong>Time:</strong> 12:00 AM</p></td>
                            <td>FSSAI, Kotla Road, ITO</td>
                            <td class="bg-primary">Under Process</td>
                          </tr>
                        </tbody>
                      </table>
                    </fieldset>
                  </div>
                </div>
              </div>
              
              <!-- timeline -->
              <div class="container-fluid">
                <div class="row">
                  <div class="col-xs-12">
                    <div class="page-header">
                      <h1 id="timeline">Certification Process for TOT</h1>
                    </div>
                    <ul class="timeline">
                      <li>
                        <div class="timeline-badge success">1</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step 1</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Course Enrollment</p>
                            <p> <a href="basictrainer.fssai">Basic</a> | <a href="advance.fssai">Advance</a> | <a href="special.fssai">Special</a></P>
                          </div>
                        </div>
                      </li>
                      <li class="timeline-inverted">
                        <div class="timeline-badge success">2</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step-2</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Get Your Admit Card</p>
                          </div>
                        </div>
                      </li>
                      <li>
                        <div class="timeline-badge success">3</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step-3</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Attend Training</p>
                            <p><a href="#">Classroom</a></p>
                          </div>
                        </div>
                      </li>
                      <li class="timeline-inverted">
                        <div class="timeline-badge success">4</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step-4</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Get Your Self Assessed</p>
                            <p><a href="#">In Physical Center</a></p>
                          </div>
                        </div>
                      </li>
                      <li>
                        <div class="timeline-badge success">5</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step-5</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Give Your Feedback</p>
                          </div>
                        </div>
                      </li>
                      <li class="timeline-inverted">
                        <div class="timeline-badge success">6</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step-6</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Get Your Certificate</p>
                          </div>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- scripts --> 

