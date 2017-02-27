<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
function OnStart(){
	searchCurrentAppliactionStatus();
}
window.onload = OnStart;
</script>
<script type="text/javascript">
function searchCurrentAppliactionStatus(){
	var data=JSON.stringify({
		courseType:0,
		courseName:0
  })
	
	$.ajax({
	      type: 'post',
	      url: 'getApplicationStatusDetails.fssai?name=sdfds',
	      contentType : "application/json",
	      data:data,
	      success: function (response) {
	    	 response=JSON.parse(response);
	    	 for(index=0;index<response.length;index++){
           	  console.log(response[index]);
           	  $('#applicaionStatus').append('<tr>'+
           		'<td>'+(index+1)+'</td>'+
           	    '<td>'+response[index].courseCode+'</td>'+
           	    '<td>'+response[index].trainingDate+'</td>'+
           	 '<td>'+response[index].trainingEndDate+'</td>'+
           	     '<td>'+response[index].noOfVacancy+'</td>'+
           	    '<td><a  href="editApplicationStatusDetails.fssai?postvacancyID='+response[index].loginId+'">'+response[index].noOfApplications+'</td> '+
           	  	'</tr>');
             }
	      }
	      });

}
//onClick="ck_NoOfTrainer('+response[index].noOfApplications+'); return false;"
/* function ck_NoOfTrainer(noOfApplicant){
	if(noOfApplicant <= 0){
		alert('No Applicant Found');
		return false;
	}
	
} */
</script>
<section>
  <div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
      <div class="container">
        <div class="row">
          <div class="col-xs-12">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            </div>
             <%@include file="../roles/top-menu.jsp"%>
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
 <%@include file="../roles/slider.jsp" %>
      <!-- /#sidebar-wrapper --> 
      <!-- Page Content -->
      <div id="page-content-wrapper">
        <div class="container-fluid"> 
          
          <!-- vertical button -->
          <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Training Center</span> </a> </div>
          </div>
          <!-- add the content here for main body --> 
          <!-- timeline  -->
          <div class="container-fluid">
            <div class="row"> 
              <!-- current upcoming trainings --> 
              <!-- upcoming trainings -->
              <div class="col-xs-12 collapse in table-overflow-responsive" id="show-result" aria-expanded="true" style=""> 
                
                <!-- table -->
                <div class="personel-info">
                  <div class="row">
                    <div class="col-xs-12">
                      <fieldset>
                        <legend>
                        <h3>Current Application Status</h3>
                        </legend>
                        <table class="table table-bordered table-responsive table-hover table-striped">
                          <thead>
                            <tr class="background-open-vacancies">
                              <th>S.No</th>
                              <th>Course Code</th>
                              <th>Training Start Date</th>
                              <th>Training End Date</th>
                              <th>No. of Vacancies</th>
                              <th>No. Of Applications</th>
                            </tr>
                          </thead>
                          <tbody id="applicaionStatus">
                        </table>
                      </fieldset>
                    </div>
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
