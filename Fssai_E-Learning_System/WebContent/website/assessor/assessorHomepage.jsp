<script type="text/javascript">
function OnStart(){
	currentAssessorId = -1;
	searchUpcomingTrainings();
}
window.onload = OnStart;
function searchUpcomingTrainings(){
	
	$('#tblUpcomingAssessments tr').remove();
	$('#tblUpcomingAssessments').append('<thead> <tr class="background-open-vacancies"> <th>S.No</th> <th>Traning Course Name</th> <th>Training Date</th> <th>Training Course Address</th> <th>No. Of Participants</th><th> &nbsp;</th></tr> </thead>');
	var result="";
	//var id = document.getElementById("assessmentAgencyId").value;
	var assessorId =710;
	$.ajax({
	type: 'post',
	url: 'searchAssessorCalendar.jspp?'+assessorId,
	async: false, 
	success: function (data){
		console.log("Data received..");
		console.log(data);
	//var mainData = JSON.stringify(data);
	var jsonData = jQuery.parseJSON(data);
	console.log(jsonData);
	var j=1;
	var accessorId;
// 	$('#tblUpcomingAssessments').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Assessor Name</th><th>Assessor Id</th><th>Active / In-Active</th><th>Detail</th></tr>')
	$.each(jsonData , function(i , obj)
	{
		$('#tblUpcomingAssessments').append('<tr id="tableRow"><td>'+j++ +'</td>'+
				'<td>'+obj[1]+'</td>'+
				'<td>'+obj[2]+'</td>'+
				'<td>'+obj[5]+'</td>'+
				'<td>'+obj[6]+'</td>'+
				//'<td><input type="hidden" id="statusHidden'+obj[4]+'" value="'+obj[5]+'"/><a href="#" onclick="applyAssessment('+obj[4]+');">'+'Apply'+'</a></td>'+
// 				'<td><input type="hidden" id="calendarId'+obj[4]+'" value="'+ obj[4]+'" /></td>'+
				'<td><input type = "checkbox" name ="assessments" value ='+obj[3]+'></td>'+
				'</tr>');
		console.log("0-"+obj[0] +" #1-" +obj[1] +" #2-" +obj[2] +" #3-"+obj[3] +" #4-"+obj[4]+" #5-"+obj[5]);
		currentAssessorId = obj[0];
	});
	
	},
	failure:function(data){
		alert("Error occured while retrieving upcoming calendars.");
	 msgbox('Error occured while retrieving upcoming calendars.');
	}
	});
return result;	
	
}


function applyAssessments(){
	var calendarIds = "";
    
	 $. each($("input[name='assessments']:checked"), function(){
		 calendarIds += $(this). val() +",";
		 console.log( "selected values " + calendarIds);}
	 );
	 
	var  queryData= {
			calendarIds: calendarIds,
 	  		assessorId:currentAssessorId
  	 };
	
	$.ajax({
		type: 'post',
		url: 'applyAssessments.jspp',
		data: queryData,
		async: false, 
		success: function (data){
			$('#updateStatus').html(data);
			console.log(data);
		},
		failure: function(data){
			msgbox('Error occured while applying for assessments..');
		}
	});
	
}
</script>

    <section>
       <%@ include file="topMenuAssessor.jspf"%>
        </section>

    <!-- main body -->
    <section class="main-section-margin-top">
          <div class="container-fluid">
        <div id="wrapper"> 

              <!-- Sidebar -->
           	<%@include file="leftMenuAssessor.jspf" %>
              <!-- /#sidebar-wrapper --> 
              <!-- Page Content -->
              <div id="page-content-wrapper">
            <div class="container-fluid"> 

                  <!-- vertical button -->
                  <div class="row">
                <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Training Partner</span> </a> </div>
              </div>

                  <!-- add the content here for main body --> 
                  <!-- timeline  -->

                  <div class="container-fluid">
                <div class="row"> 

                      <!-- upcoming trainings -->
                      <div class="col-xs-12 collapse in table-overflow-responsive" id="show-result" aria-expanded="true" style="">
                    <fieldset>
                          <legend><h3>Upcoming Assessment</h3></legend>
					<div>	
						<input type="hidden" id="currentAccessorId" value=""/>
					</div>
					<div><span id="updateStatus" class="error-red"></span>
					</div>
                    <!-- table -->
                    <div class="row">
                          <div class="col-xs-12">
                        <table id = "tblUpcomingAssessments" class="table table-bordered table-responsive table-striped table-hover">
<!--                            <thead> -->
<!--                             <tr class="background-open-vacancies"> -->
<!--                                   <th>S.No</th> -->
<!--                                   <th>Traning Course Name</th> -->
<!--                                   <th>Training Date</th> -->
<!--                                   <th>Training Course Address</th> -->
<!--                                   <th>No. Of Participants</th> -->
<!--                                 </tr> -->
<!--                           </thead> -->
<!--                               <tbody> -->
<!--                             <tr> -->
<!--                                   <td>1</td> -->
<!--                                   <td>HACCP Course for Oil & Fat Industry</td> -->
<!--                                   <td>10/10/2016</td> -->
<!--                                   <td>Karol Bagh, New Delhi, 110011</td> -->
<!--                                   <td>60</td> -->
<!--                                 </tr> -->
<!--                             <tr> -->
<!--                                   <td>2</td> -->
<!--                                   <td>GHP-GMP* Certification Course</td> -->
<!--                                   <td>20/09/2016</td> -->
<!--                                   <td>FDA Bhavan, New Delhi</td> -->
<!--                                   <td>70</td> -->
<!--                                 </tr> -->
<!--                             <tr> -->
<!--                                   <td>3</td> -->
<!--                                   <td>GHP-GMP-HACCP Certification Course for Manufacturing Sector</td> -->
<!--                                   <td>10/12/2016</td> -->
<!--                                   <td>Chankyapuri, New Delhi</td> -->
<!--                                   <td>28</td> -->
<!--                                 </tr> -->
<!--                           </tbody> -->
                            </table>
                        </div>
                        </div>
                        <button type="submit" class="btn login-btn pull-right show-details-vacancy collapsed" onclick="applyAssessments();">Accept</button>
                          </fieldset>               
                  </div>
                    </div>
              </div>
                </div>
          </div>
        </div>
      </div>
        </section>