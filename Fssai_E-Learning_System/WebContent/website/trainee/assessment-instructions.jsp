<script type="text/javascript">
function OnStart(){
	var steps = 4;
	var traineeSteps =
		<%=(Integer) session.getAttribute("traineeSteps")%>
	if(steps > traineeSteps){
	}else{
		if(steps-1 == traineeSteps){
			alert('Please Complete Your Previous Training First')
		}else{
			alert('Please Flow Step By Step..');
		}
		window.location.href ='/Fssai_E-Learning_System/loginProcess.fssai';
	}
	var isOnline = "${ISONLINE}";
	if(isOnline == 'NO'){
		alert('Dear User, You have registered for classroom training, So the assessment will be done at training center');
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

        <!-- Sidebar -->
      <%@include file="../roles/slider.jsp" %>
        <!-- /#sidebar-wrapper --> 
        <!-- Page Content -->
        <div id="page-content-wrapper">
        <div class="container-fluid">
        <!-- vertical button -->
        <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Mr. Anuj</span> </a> </div>
          </div>
        <!-- add the content here for main body --> 
        <!-- timeline  -->
        <section class="section-form-margin-top">
              <div class="container">     
            <!-- login form -->
            <div class="row btm-margin">
                  <div class="col-md-6  col-xs-12"> 
                      <fieldset>
                    <legend><h3>Course Details</h3></legend>
                   <%@include file="../commonjsp/course.jsp" %>
                    <h4>Assessment Agency Name: <span class="f16">${courseTrainee.assessorAgency }</span></h4>
                    <h4>Assessor Name: <span class="f16">${courseTrainee.assessor}</span></h4>
                  </fieldset>
                     <br>
              <h3 class="text-capitalize heading-3-padding">Assesment Instructions</h3>
              </div>
                  <div class="col-md-2 hidden-xs"></div>
                </div>
          </div>
            </section>
            <section class="section-form-margin-top">
              <div class="container">     
            <!-- login form -->
                <div class="row">
                       <div class="col-md-12  col-xs-12">
                       <p>The test consists of 60 (5 point Likert scale) items across the Big 5 personality factors</p>
                            <ol>
                            <li>Extraversion</li>
                            <li>Agreeableness</li>
                            <li>Conscientiousness</li>
                            <li>Emotional Stability and</li>
                            <li>Openness to Experience</li>                    
                            </ol>      
                        </div>
                        <div class="col-md-2 hidden-xs"></div>
                    </div>

                    <div class="row">
                       <div class="col-md-12  col-xs-12">
                       <p><strong>Click to start Test</strong></p>

                        </div>
                        <div class="col-md-2 hidden-xs"></div>
                    </div>

                    <div class="row">
                       <div class="col-md-12  col-xs-12">
                       <div class="form-group">
                         <a href="traineeAssessmentOnline.fssai"><input style="width:150px;"  type="button" class="form-control login-btn btn" value="Start Assessment" /></a>
                        </div>

                        </div>
                        <div class="col-md-2 hidden-xs"></div>
                    </div>

          </div>
            </section>

        <!-- scripts --> 

       </div>
       </div>
       </div>
       </div>
       </section>