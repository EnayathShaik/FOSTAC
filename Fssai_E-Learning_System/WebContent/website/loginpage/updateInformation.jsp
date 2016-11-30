<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<cf:form action="updateTrainee.fssai" name="myForm" method="POST" commandName="updateInformation" onsubmit="return validateFields();"> 


<section>
  <div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="hori"><a href="fostac.fssai">First login Home</a></li>
            <li class="hori"><a href="second-time-login.html">Second Time Login Home Page</a></li>
            <li class="active hori"><a href="updateInformation.fssai">Update Information</a></li>
            <li class="hori"><a href="contactTrainee.fssai">Contact Us</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="change-password.html">Change Password</a></li>
                <li><a href="#">Logout</a></li>
              </ul>
            </li>
          </ul>
        </div>
        <!--/.nav-collapse --> 
      </div>
    </nav>
  </div>
</section>

<!-- main body -->
<section class="main-section-margin-top">
  <div class="container-fluid">
    <div id="wrapper"> 
      
      <!-- Sidebar menu -->
      <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
          <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Course Enrollment <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="basic.fssai" class="clr">Basic Course</a></li>
              <li><a href="advance.fssai" class="clr">Advanced Course</a></li>
              <li><a href="special.fssai" class="clr">Special Course</a></li>
            </ul>
          </li>
          <li> <a href="generateAdmitCard.fssai">Generate Admit Card</a> </li>
          <li> <a href="courseTraining.fssai">Training</a> </li>
          <li> <a href="assessment-Instructions.fssai">Assessment</a> </li>
          <li> <a href="feedbackForm.fssai">Feedback</a> </li>
          <li> <a href="generateCertificate.fssai">Certification</a> </li>
        </ul>
      </div>
      <!-- Sidebar menu --> 
      <!-- /#sidebar-wrapper --> 
      <!-- Page Content -->
      <div id="page-content-wrapper">
        <div class="container-fluid"> 
          <!-- vertical button -->
          <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars">
            <span style="font-size:14px;">Welcome Mr.  ${loginUser.loginDetails.loginId}</span>
            </i> </a> </div>
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
              </div>
            </div>
          </section>
          <section class="section-form-margin-top"> 
            <!-- login form -->
            <div class="row">
              <div class="col-md-8  col-xs-12"> 
                <!-- personel info Start -->
                <div class="personel-info">
                  <fieldset >
                    <legend>
                    <h3>Personal Information</h3>
                    </legend>
                    <!-- left side -->
                    <div class="col-md-6 col-xs-12">
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>User Id:</strong></li>
                            <li class="style-li error-red"></li>
                          </ul>
                        </div>
                        <input type="text" class="form-control" placeholder="User ID"  disabled="disabled"  value=" ${loginUser.loginDetails.loginId}">
                      </div>
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>Aadhar:</strong></li>
                            <li class="style-li error-red"></li>
                          </ul>
                        </div>
                        <cf:input type="text" path="AadharNumber" class="form-control" placeholder="Aadhar Number"  disabled="disabled"   value=" ${loginUser.aadharNumber}"/>
                      </div>
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>Date of Birth:</strong></li>
                            <li class="style-li error-red"></li>
                          </ul>
                        </div>
                        <cf:input type="text" path="dob" class="form-control" placeholder="Date"  disabled="disabled"    value="${loginUser.dob }"/>
                      </div>
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Gender" /></strong></li>
<li class="style-li error-red"><cf:errors path="gender" cssClass="error" /></li>
</ul>
</div>
<label class="radio-inline">
<cf:radiobutton path="gender" value="M" checked="true" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <cf:radiobutton path="gender" value="F" />Female</td>
</label>
</div>
                    </div>
                    
                    <!-- right side -->
                    <div class="col-md-6 col-xs-12">
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>Title:</strong></li>
                            <li class="style-li error-red"></li>
                          </ul>
                        </div>
<cf:select path="Title" class="form-control" >
<cf:option value="0" label="Mr." />
<cf:option value="1" label="Mrs." />
<%-- <cf:options items="${titleList}" itemValue="titleId" itemLabel="titleName" /> --%>
</cf:select>
                      </div>
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>First Name:</strong></li>
                            <li class="style-li error-red"></li>
                          </ul>
                        </div>
                        <cf:input type="text" path="firstName" class="form-control" placeholder="First Name" disabled="disabled"  value="${loginUser.firstName }"/>
                      </div>
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>Middle Name:</strong></li>
                            <li class="style-li error-red"></li>
                          </ul>
                        </div>
                        <cf:input type="text"  path="MiddleName" class="form-control" placeholder="Middle Name" disabled="disabled"  value="${loginUser.middleName }"/>
                      </div>
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>Last Name:</strong></li>
                            <li class="style-li error-red"></li>
                          </ul>
                        </div>
                        <cf:input type="text"  path="lastName" class="form-control" placeholder="Last Name" disabled="disabled"  value="${loginUser.lastName }"/>
                      </div>
                    </div>
                  </fieldset>
                </div>
                <!-- personel info End-->
                
                <div class="row" style="height:20px;"></div>
                
                <!-- Contact details Start -->
                <div class="personel-info">
                  <fieldset >
                    <legend>
                    <h3>Permanent Contact Details</h3>
                    </legend>
                    <!--Left side-->
                    <div class="col-md-6 col-xs-12">
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.ResidentialAddressLine1" /></strong></li>
<li class="style-li error-red"><cf:errors path="ResidentialAddressLine1"  cssClass="error"/></li> 
</ul>
</div>
<cf:input path="ResidentialAddressLine1" placeholder="Residential Address Line 2" class="form-control" value="${loginUser.residentialLine1 }"/>
</div> 
                    
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Mobile" /></strong></li>
<li class="style-li error-red"><cf:errors path="Mobile" cssClass="error" /></li>
</ul>
</div>
<cf:input path="Mobile" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Mobile Number" class="form-control" type="text" value="${loginUser.mobile }" maxlength="10"/>
</div>
                       
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.State" /></strong></li>
<li class="style-li error-red"><cf:errors path="resState" cssClass="error" /></li>
</ul>
</div>
<cf:select path="resState" class="form-control state">
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
</cf:select>
</div>
                       <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>City:</strong></li>
                            <li class="style-li error-red"></li>
                          </ul>
                        </div>
<cf:select path="correspondenceCity" class="form-control" onchange="return myBusiness()">
<cf:options items="${cityList}" itemValue="cityId" itemLabel="cityName" />
</cf:select> 
                      </div>
                    </div>
                    <!--Left side--> 
                    <!--Right side-->

                    
                    <div class="col-md-6 col-xs-12">
                     <div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.ResidentialAddressLine2" /></strong></li>
<li class="style-li error-red"><strong><cf:errors path="ResidentialAddressLine2"  cssClass="error"/></li>       
</ul>
</div>
<cf:input path="ResidentialAddressLine2"  value="${loginUser.residentialLine2}" placeholder="Residential Address Line 2" class="form-control" />
</div> 
 <div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Email" /></strong></li>
<li class="style-li error-red"><cf:errors path="Email" cssClass="error" /></li>
</ul>
</div>
<cf:input path="Email" class="form-control"  placeholder="Email" value="${loginUser.email }"/>
</div>
               
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>District:</strong></li>
                            <li class="style-li error-red">*Error</li>
                          </ul>
                        </div>
                        <select class="form-control">
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select>
                      </div>
                     
                     
                     
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Pincode" /></strong></li>
<li class="style-li error-red"><cf:errors path="resPincode" cssClass="error" /></li>        
</ul>
</div>
<input id="resPincode" name="resPincode" value="${loginUser.resPincode }" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Pincode" class="form-control" type="text" value="" maxlength="6">
</div>
                    </div>
                    <!--Right side-->
                    
                  </fieldset>
                </div>
                <!-- Contact details End--> 
                <!-- Contact details Start -->
                <div class="personel-info">
                  <fieldset >
                    <legend>
                    <h3>Correspondence Contact Details</h3>
                    </legend>
                    <!--Left side-->
                    <div class="col-md-6 col-xs-12">
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.correspondenceAddress1" /></strong></li>
<li class="style-li error-red"><cf:errors path="correspondenceAddress1" cssClass="error" /></li>  
</ul>
</div>
<cf:input path="correspondenceAddress1" class="form-control"  placeholder="Address "  value="${loginUser.residentialLine1}" />
</div>                    
                      
                     
                     
                     <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>State:</strong></li>
                            <li class="style-li error-red">*Error</li>
                          </ul>
                     
                     
                        </div>
<cf:select path="resState" class="form-control state">
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
</cf:select>
                      </div> <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>City:</strong></li>
                            <li class="style-li error-red">*Error</li>
                          </ul>
                        </div>
                        <select class="form-control">
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select>
                      </div>
                     
                    </div>
                    <!--Left side--> 
                    <!--Right side-->
                    <div class="col-md-6 col-xs-12">
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.correspondenceAddress2" /></strong></li>
<li class="style-li error-red"><cf:errors path="correspondenceAddress2" cssClass="error" /></li>       
</ul>
</div>
<cf:input path="correspondenceAddress2" class="form-control"  placeholder="Address 2"  value="${loginUser.residentialLine2}"/>
</div>                     
                      
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>District:</strong></li>
                            <li class="style-li error-red">*Error</li>
                          </ul>
                        </div>
                        <select class="form-control">
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select>                      </div>
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.correspondencePincode" /></strong></li>
<li class="style-li error-red"><cf:errors path="correspondencePincode" cssClass="error" /></li>        
</ul>
</div>
<cf:input path="correspondencePincode"  value="${loginUser.correspondencePincode}"  onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Pincode" class="form-control"  maxlength="6" />
</div>                      
                      
                      <!-- <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>Location:</strong></li>
                            <li class="style-li error-red">*Error</li>
                          </ul>
                        </div>
                        <input type="text" class="form-control" placeholder="Location" >
                      </div> -->
                    </div>
                    <!--Right side-->
                    
                  </fieldset>
                </div>
                <!-- Contact details End-->
                <div class="row" style="height:20px;"></div>
                <div class="personel-info">
                  <fieldset>
                    <legend>
                    <h3>Kind of Business</h3>
                    </legend>
                    <div class="form-group">
                      <div>
                        <ul class="lab-no">
                          <li class="style-li"><strong></strong></li>
                          <li class="style-li error-red">*Error</li>
                        </ul>
                      </div>
                     <select class="form-control">
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select>
                  </fieldset>
                </div>
                <!-- Business address Start -->
                <div class="personel-info ">
                  <fieldset >
                    <legend>
                    <h3>Business Details</h3>
                    </legend>
                    <!--Left side-->
                    <div class="col-md-6 col-xs-12">
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.CompanyName" /></strong></li>
<li class="style-li error-red">
<cf:errors path="CompanyName" cssClass="error" /></li>
</ul>
</div>
<cf:input path="CompanyName" class="form-control"  placeholder="Company Name"   value="${loginUser.companyName}"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Designation" /></strong></li>
<li class="style-li error-red"><cf:errors path="Designation" cssClass="error" /></li>
</ul>
</div>
<cf:input path="Designation" class="form-control"  placeholder="Designation" value="${loginUser.designation}"/>
</div>
                    
                      
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>State:</strong></li>
                            <li class="style-li error-red">*Error</li>
                          </ul>
                        </div>
                        <select class="form-control">
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select>
                      </div>
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>City:</strong></li>
                            <li class="style-li error-red">*Error</li>
                          </ul>
                        </div>
                        <select class="form-control" >
                          <option value="">Select City</option>
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select>
                      </div>
                    </div>
                    <!--Left side--> 
                    <!--Right side-->
                    <div class="col-md-6 col-xs-12">
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.BusinessAddressLine1" /></strong></li>
<li class="style-li error-red"><cf:errors path="BusinessAddressLine1" cssClass="error" /></li>
</ul>
</div>
<cf:input path="BusinessAddressLine1" class="form-control"  placeholder="Business Address Line 1" value="${loginUser.businessAddressLine1}"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.BusinessAddressLine2" /></strong></li>
<li class="style-li error-red">
<cf:errors path="BusinessAddressLine2" cssClass="error" /></li>
</ul>
</div>
<cf:input path="BusinessAddressLine2" class="form-control"  placeholder="Business Address Line 2"  value="${loginUser.businessAddressLine2}"/>
</div>
 
                      <div class="form-group">
                        <div>
                          <ul class="lab-no">
                            <li class="style-li"><strong>District:</strong></li>
                            <li class="style-li error-red">*Error</li>
                          </ul>
                        </div>
                        <select class="form-control" >
                          <option value="">Select State</option>
                          <option value="0">Lorem</option>
                          <option value="1">Lorem</option>
                          <option value="2">Lorem</option>
                          <option value="3">Lorem</option>
                        </select>
                      </div>


 <div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Pincode" /></strong></li>
<li class="style-li error-red"><cf:errors path="bussPincode" cssClass="error" /></li>
</ul>
</div>
<cf:input path="bussPincode" class="form-control"  value="${loginUser.bussPincode}"  placeholder="Pincode" maxlength="6" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"/>
</div>                     
                       
                    </div>
                    <!--Right side-->
                    
                  </fieldset>
                </div>
                <!-- Business address Start -->
                <div class="row" style="height:20px;"></div>
                <div class="checkbox">
                 
                </div>
                
                  <!-- left side --> 
                  
                  <!-- right side -->
                  
                  <div class="col-xs-12">
                    <div class="col-xs-4"></div>
                    <div class="col-xs-4">
                      <div class="form-group"> 
                        <input type="submit" class="form-control login-btn" value="Update" />
                        </div>
                    </div>
                    <div class="col-xs-4"></div>
                  </div>
                
              </div>
              <div class="col-md-2 hidden-xs"></div>
            </div>
          </section>
          </div></div></div></div></section></cf:form>