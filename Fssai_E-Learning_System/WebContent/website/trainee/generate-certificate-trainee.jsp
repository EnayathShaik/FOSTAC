<script type="text/javascript">
function OnStart(){
	var isEligible = "${Eligible}";
	if(isEligible == ''){
		alert('Need to Clear Exam First.');
   	  	window.location.href ='/Fssai_E-Learning_System/loginProcess.fssai';
	}
	var steps = 6;
	var traineeSteps =
		<%=(Integer) session.getAttribute("traineeSteps")%>
	if(steps > traineeSteps){
	}else{
		if(steps-1 == traineeSteps){
			alert('Please Complete Your Previous Training First')
		}else{
			alert('Please Flow Step By Step..');
		}
		//window.location.href ='/Fssai_E-Learning_System/loginProcess.fssai';
	}
}
window.onload = OnStart;
</script>
<!-- horizontal navigation -->
<section>
<%@include file="../roles/top-menu.jsp"%>
</section>
<!-- main body -->
<section class="main-section-margin-top">
  <div class="container-fluid">
    <div id="wrapper"> 
      <!-- Sidebar menu -->
      <%@include file="../roles/slider.jsp" %>
       <!-- Sidebar menu -->
      <!-- /#sidebar-wrapper --> 
      <!-- Page Content -->
      <div id="page-content-wrapper">
        <div class="container-fluid"> 
          <!-- vertical button -->
         <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${loginUser.firstName }</span> </a> </div>
          </div>
          
          <!-- add the content here for main body --> 
          <!-- feedback form  -->
          
          <div class="container-fluid">
            <div class="row">
              <div class="table-responsive">
                <div class="col-xs-12">
                  <fieldset>
                    <legend><h3>Generate Certificate</h3></legend>
                    <%@include file="../commonjsp/course.jsp" %>
                     <h4><a class="link-bg text-center" href="certificatetrainee.fssai">Generate Certificate</a></h4>
                  </fieldset>
                  <br>
                  
                </div>
              </div>
            </div>
            <!-- row ends --> 
          </div>
          
          <!-- fluid ends --> 
        </div>
      </div>
    </div>
  </div>
</section>
<!-- scripts --> 
