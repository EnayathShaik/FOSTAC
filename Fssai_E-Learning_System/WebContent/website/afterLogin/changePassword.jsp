<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
<!-- main body -->
<section class="main-section-margin-top">
<div class="container-fluid">
<div id="wrapper">

<!-- Sidebar -->
<div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand">

                        </li> -->

                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Course Enrollment <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="basic.html" class="clr">Basic Course</a></li>
                                <li><a href="advance.html" class="clr">Advanced Course</a></li>
                                <li><a href="special.html" class="clr">Special Course</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="admit-card.html">Generate Admin Card</a>
                        </li>
                        <li>
                            <a href="training.html">Training</a>
                        </li>
                        <li>
                            <a href="assessment-instructions.html">Assessment</a>
                        </li>
                        <li>
                            <a href="feedback-form.html">Feedback</a>
                        </li>
                        <li>
                            <a href="certificate.html">Certification</a>
                        </li>
                    </ul>
                </div>
<!-- /#sidebar-wrapper --> 
<!-- Page Content -->
<div id="page-content-wrapper">
<div class="container-fluid">
<!-- vertical button -->
<div class="row">
      <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> </a> </div>
    </div>
<!-- add the content here for main body --> 
<!-- timeline  -->
<section class="section-form-margin-top">
      <div class="container">     
    <!-- login form -->
    <div class="row btm-margin">
          <div class="col-md-6  col-xs-12">        
      <h3 class="text-capitalize heading-3-padding">Change Password</h3>
      </div>
          <div class="col-md-2 hidden-xs"></div>
        </div>
  </div>
    </section>
    <section class="section-form-margin-top">
      <div class="container">     
    <!-- login form -->
        <div class="row">
               <div class="col-md-4  col-xs-12">
               
               
               
               
                    <cf:form action="updatePassword" method="POST" commandName="updatePassword" >
                        <!-- left side -->
                        <div class="col-md-6 col-xs-12">
                            <!-- residential address -->
                            <div class="form-group">
                                <label>Current Password</label>
                                <input type="text" class="form-control" placeholder="Current Password" required>
                            </div>
                            
                            
                            <div class="form-group">
                                <label>New Password</label>
                                <input type="text" class="form-control" placeholder="New Password" required>
                            </div>
                            
                            <div class="form-group">
                                <label>Confirm Password</label>
                                <input type="text" class="form-control" placeholder="Confirm Password" required>
                            </div>
                            
                            <div class="form-group">
                                    <input type="button" class="form-control login-btn" value="Confirm Password" />
                                </div>
                                                                           
                        </div>

                        <!-- right side -->
                     
                </div>
                <div class="col-md-6  col-xs-6" style="float:left;">
                    
                    <p><strong>Password Policy</strong></p> 
                    <ol>
                    <li>Minimum Password length should be 7 charecters</li>
                    <li>Maximum Password length should not exceed 15 charecters</li>
                    <li>Password must contain one alphabet and one number</li>
                    </ol>         
                </div>
                <div class="col-md-2 hidden-xs"></div>
            </div>
  </div>
    </section>
 </cf:form>    