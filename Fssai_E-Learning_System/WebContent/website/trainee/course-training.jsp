
<script type="text/javascript">
function OnStart(){
	var isOnline = "${ISONLINE}";
	if(isOnline == 'NO'){
		alert('Content will be available in Classroom');
   	  	window.location.href ='/Fssai_E-Learning_System/loginProcess.fssai';
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
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Mr. Anuj</span> </a> </div>
          </div>
          
          <!-- add the content here for main body --> 
          <!-- feedback form  -->
          
          <div class="container-fluid">
            <div class="row">
              <div class="table-responsive">
                <div class="col-xs-12">
                  <fieldset>
                    <legend><h3>Course Training1324</h3></legend>
                    <h4>Course Name: <span class="f16">${courseName.coursename }</span></h4>
                    <h4>Course Code: <span class="f16">${courseName.coursenameid }</span></h4>
                    <h4>Course Duration: <span class="f16">${courseName.courseduration }</span></h4>
                    <h4><a class="link-bg text-center" href="training.fssai">Training Video</a></h4>
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
