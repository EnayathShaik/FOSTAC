<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle">
       <i class="fa fa-bars"> <span class="orange-font">Welcome Mr. <ct:out value="${loginDetails.get(0).getFirstName() }"></ct:out> </span></i> </a> </div>
    </div>
<!-- add the content here for main body --> 
<!-- timeline  -->
<section class="section-form-margin-top">
      <div class="container">     
    <!-- login form -->
    <div class="row btm-margin">
          <div class="col-md-6  col-xs-12">        
      <h3 class="text-capitalize heading-3-padding">Update Information for Trainee</h3>
      </div>
          <div class="col-md-2 hidden-xs"></div>
        </div>
  </div>
    </section>
    
    <section class="section-form-margin-top">
      <div class="container">     
    <!-- login form -->
    <div class="row btm-margin">
          <div class="col-md-2  col-xs-6">        
      <p>First Name:</p>
      </div>
      
      <div class="col-md-2 col-xs-6">        
      <p> <ct:out value="${loginDetails.get(0).getFirstName() }"></ct:out></p>
      </div>
      
      <div class="col-md-2 col-xs-6">        
      <p>Last Name:</p>
      </div>
      
      <div class="col-md-2 col-xs-6">        
      <p> <ct:out value="${loginDetails.get(0).getLastName() }"></ct:out></p>
      </div>
          <div class="col-md-2 hidden-xs"></div>
        </div>
        
        
        <div class="row btm-margin">
          <div class="col-md-2  col-xs-6">        
      <p>Aadhar Number:</p>
      </div>
      
      <div class="col-md-2 col-xs-6">        
      <p> <ct:out value="${loginDetails.get(0).getAadharNumber() }"></ct:out></p>
      </div>
      
      <div class="col-md-2 col-xs-6">        
      <p>DOB:</p>
      </div>
      
      <div class="col-md-2 col-xs-6">        
      <p> <ct:out value="${loginDetails.get(0).getDOB() }"></ct:out></p>
      </div>
          <div class="col-md-2 hidden-xs"></div>
        </div>
        
        
        <div class="row">
               <div class="col-md-6  col-xs-12">
                    
                    <form>
                        <!-- left side -->
                        <div class="col-md-6 col-xs-12">
                            
                            
                            
                            

                            
                            
                            <!-- residential address -->
                            <div class="form-group">
                                <hr />
                                <label>Residential Address</label>
                                <hr />
                            </div>
                            <div class="form-group">
                                <label>Residential Address Line 1:</label>
                                <input type="text" class="form-control" placeholder="Address" required>
                            </div>
                            <div class="form-group">
                                <label>Residential Address Line 2:</label>
                                <input type="text" class="form-control" placeholder="Address" required>
                            </div>
                            <div class="form-group">
                                <label>State:</label>
                                <select class="form-control" required="required">
                                    <option>Select State</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Closest City:</label>
                                <select class="form-control" required="required">
                                    <option>Select City</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                </select>                                
                            </div>
                            <div class="form-group">
                                <label>Location</label>
                                <input type="text" class="form-control" placeholder="Location" required>
                            </div>
                            <div class="form-group">
                                <label>Pin Code</label>
                                <input type="text" class="form-control" placeholder="Pin Code" required>
                            </div>                                                 
                        </div>

                        <!-- right side -->
                        <div class="col-md-6 col-xs-12">
                            
                            
                            
                            
                            
                            <!-- business address -->
                            <div class="form-group">
                                <hr />
                                <label>Business Address</label>
                                <hr />
                            </div>
                            <div class="form-group">
                                <label>Kind of Business:</label>
                                <select class="form-control" required="required">
                                    <option>Select Kind of Business</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Company Name:</label>
                                <input type="text" class="form-control" placeholder="Company Name" required>
                            </div>
                            <div class="form-group">
                                <label>Designation:</label>
                                <input type="text" class="form-control" placeholder="Designation" required>
                            </div>
                            <div class="form-group">
                                <label>Business Address Line 1:</label>
                                <input type="text" class="form-control" placeholder="Address" required>
                            </div>
                            <div class="form-group">
                                <label>Business Address Line 2:</label>
                                <input type="text" class="form-control" placeholder="Address" required>
                            </div>
                            <div class="form-group">
                                <label>State:</label>
                                <select class="form-control" required="required">
                                    <option>Select State</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Closest City:</label>
                                <select class="form-control" required="required">
                                    <option>Select City</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                    <option>Lorem</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Location</label>
                                <input type="text" class="form-control" placeholder="Location" required>
                            </div>
                            <div class="form-group">
                                <label>Pin Code</label>
                                <input type="text" class="form-control" placeholder="Pin Code" required>
                            </div>
                            

                                  
                        </div>

                        <div class="col-xs-12">
                           
                            <div class="pull-right">
                                <div class="form-group">
                                    <input type="button" class="form-control login-btn" value="Update Details" />
                                </div>
                            </div>
                           
                            
                        </div>
                        
                    </form>    
                                  
                </div>
                <div class="col-md-2 hidden-xs"></div>
            </div>
        
        
        
        
        
        
        
        
        
         
        
    
        
               
  </div>
    </section>
</div></div></div></div></section>