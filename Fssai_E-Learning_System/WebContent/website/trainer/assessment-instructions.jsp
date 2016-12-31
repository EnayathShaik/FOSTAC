      

        <!-- horizontal navigation -->
        <section>
              <%@include file="topMenuTrainer.jspf" %>
            </section>

        <!-- main body -->
        <section class="main-section-margin-top">
        <div class="container-fluid">
        <div id="wrapper">

        <!-- Sidebar -->
      <%@include file="leftMenuTrainer.jspf"%>
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
                    <h4>Course Name: <span class="f16">${courseName.coursename }</span></h4>
                    <h4>Course Code: <span class="f16">${courseName.coursenameid }</span></h4>
                    <h4>Course Duration: <span class="f16">${courseName.courseduration }</span></h4>
                    <h4>Assessment Agency Name: <span class="f16">${utility.assessmentAgencyName }</span></h4>
                      <h4>Assessor Name: <span class="f16">${utility.assessorName }</span></h4>
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
                         <a href="trainerAssessmentOnline.fssai"><input style="width:150px;"  type="button" class="form-control login-btn btn" value="Start Assessment" /></a>
                        </div>

                        </div>
                        <div class="col-md-2 hidden-xs"></div>
                    </div>

          </div>
            </section>
</div>
</div>
</div>
</div>
</section>
        <!-- scripts --> 

       