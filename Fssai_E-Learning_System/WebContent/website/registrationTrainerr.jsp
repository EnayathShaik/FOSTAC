<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
 <script type='text/javascript'>
    function myFunction() {
    	window.document.myForm.imgcaptcha.src='';window.document.myForm.imgcaptcha.src='./Captcha.jpg?random='+new Date().getTime();
        return false;
    }
</script>
 <style>
.error {
    color: red;
}
</style>
 
<!-- login form -->
<div class="row">
<div class="col-md-2 hidden-xs"></div>
<div class="col-md-8  col-xs-12">
<h3 class="text-capitalize heading-3-padding">Trainer Registration Form</h3>
<cf:form action="registerTrainer.fssai" name="myForm" method="POST" commandName="registrationFormTrainer" >

                       

<!-- personal info -->
                            <div class="personel-info">
                                <fieldset>
                                    <legend>Personal Information</legend>

                                    <!-- left side --> 
                                    <div class="col-md-6 col-xs-12">
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.UserId" /></strong></li>
<li class="style-li error-red"><a href="userIdCheck.fssai" onclick="return loadonxml();">check availability</a><span id="err"> </span>
<cf:errors path="UserId" cssClass="error" /></li>
</ul>
</div>
<cf:input path="UserId" class="form-control"  placeholder="User Id"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.AadharNumber" /></strong></li>
<li class="style-li error-red"><cf:errors path="AadharNumber" cssClass="error" /></li>
</ul>
</div>
<cf:input path="AadharNumber" class="form-control" maxlength="12"  placeholder="Aadhar Number" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.DOB" /></strong></li>
<li class="style-li error-red"><cf:errors path="DOB" cssClass="error" /></li>
</ul>
</div>
<cf:input path="DOB" class="form-control"  placeholder="DOB"/>
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
<li class="style-li"><strong><cs:message code="lbl.Trainee.Title" /></strong></li>
<li class="style-li error-red"><cf:errors path="Title" cssClass="error" /></li>
</ul>
</div>
<cf:select path="Title" class="form-control">
<cf:option value="0" label="Select Title" />
<cf:options items="${titleList}" itemValue="titleId" itemLabel="titleName" />
</cf:select>
</div>

 <div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.FirstName" /></strong></li>
<li class="style-li error-red"><cf:errors path="FirstName" cssClass="error" /></li>
</ul>
</div>
<cf:input path="FirstName" class="form-control"  placeholder="First Name"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.MiddleName" /></strong></li>
<li class="style-li error-red"><cf:errors path="MiddleName" cssClass="error" /></li>
</ul>
</div>
<cf:input path="MiddleName" class="form-control" name="MiddleName"  placeholder="Middle Name"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.LastName" /></strong></li>
<li class="style-li error-red"><cf:errors path="Lastname" cssClass="error" /></li>
</ul>
</div>
<cf:input path="Lastname" class="form-control"  placeholder="Last Name"/>
</div>
</div>
</fieldset>
</div>
<div class="row" style="height: 20px;"></div>

<!-- contact details -->
<div class="personel-info">
<fieldset>
<legend>Contact Information</legend>
<!-- left side -->
<div class="col-md-6 col-xs-12">
                                        <div class="form-group">
                                             <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Email:</strong></li>
                                                    <li class="style-li error-red">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="email" class="form-control" placeholder="Email" required>
                                        </div>

                                        <div class="form-group">
                                             <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Mobile:</strong></li>
                                                    <li class="style-li error-red">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" class="form-control" placeholder="Mobile" required>
                                        </div>

                                        
                                        <div class="form-group">
                                             <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>State:</strong></li>
                                                    <li class="style-li error-red">*Error</li>
                                                </ul>
                                            </div>
                                            <select class="form-control">
                                                <option value="">Lorem</option>
                                                <option value="">Lorem</option>
                                                <option value="">Lorem</option>
                                                <option value="">Lorem</option>                                                
                                            </select>
                                        </div>

                                        <div class="form-group">
                                             <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>PIN Code:</strong></li>
                                                    <li class="style-li error-red">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" class="form-control" placeholder="Mobile" required>
                                        </div>
                                        

                                    </div> <!-- left side ends -->



                                    <!-- right side -->
                                    <div class="col-md-6 col-xs-12">
                                        <div class="form-group">
                                             <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Residence Address 1:</strong></li>
                                                    <li class="style-li error-red">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" class="form-control" placeholder="Address" required>
                                        </div>

                                        <div class="form-group">
                                             <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Residence Address 2:</strong></li>
                                                    <li class="style-li error-red">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" class="form-control" placeholder="Address" required>
                                        </div>


                                        <div class="form-group">
                                             <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Closest City:</strong></li>
                                                    <li class="style-li error-red">*Error</li>
                                                </ul>
                                            </div>
                                            <select class="form-control">
                                                <option value="">Lorem</option>
                                                <option value="">Lorem</option>
                                                <option value="">Lorem</option>
                                                <option value="">Lorem</option>                                                
                                            </select>
                                        </div>

                                        <div class="form-group">
                                             <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Location:</strong></li>
                                                    <li class="style-li error-red">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" class="form-control" placeholder="Location" required>
                                        </div>

                                        
                                    </div> <!-- right side ends -->
                                </fieldset>
                            </div>
<!-- contact details ends -->

                            <div class="row" style="height: 20px;">                               
                            </div>

                            <!-- Experience Detais -->
                            <div class="personel-info">
                                <fieldset>
                                    <legend>Experience Details</legend>
                                

                                <!-- left side -->
                                <div class="col-md-6 col-xs-12">
                                    <div class="form-group">
                                             <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Food Safety Experience Background:</strong></li>
                                                    <li class="style-li error-red"> </li>
                                                </ul>
                                            </div>
                                            <select class="form-control">
                                                <option value="">Lorem</option>
                                                <option value="">Lorem</option>
                                                <option value="">Lorem</option>
                                                <option value="">Lorem</option>
                                            </select>
                                    </div>

                                    <div class="form-group">   
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Experience in Food Safety Experience:</strong></li>
                                                    <li class="style-li error-red"> </li>
                                                </ul>
                                            </div> 
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <select class="form-control" required="required">
                                                <option>Select Year</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                            </select>
                                        </div>
                                        <div class="col-xs-6">
                                            <select class="form-control" required="required">
                                                <option>Select Month</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                            </select>
                                        </div>                                    
                                    </div>
                                </div>

                                <div class="form-group">
                                     <div>
                                        <ul class="lab-no">
                                            <li class="style-li"><strong>No. Of Training Sessions Conducted:</strong></li>
                                            <li class="style-li error-red"> </li>
                                        </ul>
                                    </div>
                                    <input type="text" class="form-control" placeholder="Session Number" required>
                                </div>

                                


                                </div> <!-- left side ends -->


                                <!-- right side -->
                                <div class="col-md-6 col-xs-12">
                                <div class="form-group">                                
                                    <label>How Many Trainings (4Hrs) Sessions Wish To Conduct in a Month ?</label>
                                    <input type="text" class="form-control" placeholder="Session Number" required>
                                </div>

                                <div class="form-group">
                                    <label>Associated with any Training Partner ?</label><br />
                                    <label class="radio-inline">
                                        <input type="radio" name="optradio">Yes
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="optradio">No
                                    </label>
                                </div>

                                <div class="form-group">
                                    <div>
                                        <ul class="lab-no">
                                            <li class="style-li"><strong>Training Partner Name:</strong></li>
                                            <li class="style-li error-red"> </li>
                                        </ul>
                                    </div>
                                    <input type="text" class="form-control" placeholder="Partner Name" required>
                                </div>
                                </div> <!-- right side ends -->

                                </fieldset>
                            </div>

                            <div class="row" style="height: 20px;">                               
                            </div>
                        
                            <!-- Basic courses -->
                            
                            <div class="personel-info">
                                <h4>Courses wish to conduct ?</h4>
                                <fieldset>
                                    <legend>Basic Courses</legend>         
                                    <!-- left -->
                                    <div class="col-md-6 col-xs-12">                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                    </div>
                                    
                                    <!-- right -->
                                    <div class="col-md-6 col-xs-12">                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                    </div>
                                    
                                </fieldset>
                            </div> <!-- basic course -->
                        
                        <!-- Advanced courses -->
                            
                            <div class="personel-info">
                                <fieldset>
                                    <legend>Advanced Courses</legend>                                    
                                    <!-- left -->
                                    <div class="col-md-6 col-xs-12">                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                    </div>
                                    
                                    <!-- right -->
                                    <div class="col-md-6 col-xs-12">                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                    </div>
                                    
                                </fieldset>
                            </div> <!-- advanced course -->
                        
                        <!-- special courses -->
                            
                            <div class="personel-info">
                                <fieldset>
                                    <legend>Special Courses</legend>                                    
                                    <!-- left -->
                                    <div class="col-md-6 col-xs-12">                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                    </div>
                                    
                                    <!-- right -->
                                    <div class="col-md-6 col-xs-12">                                        
                                        <div class="checkbox">
                                          <label>
                                            <input type="checkbox">
                                            <a href="#" target="_blank" class="terms-font-size"> Lorem Ipsum </a> </label>
                                        </div>
                                    </div>
                                    
                                </fieldset>
                            </div> <!-- special course -->
                        
                        <div class="row" style="height: 20px;">                               
                            </div>
                        
                        
                        

                            <div class="col-xs-12">
                                <div class="form-group">
                                  <label><img src="img/captcha.jpg" class="img-responsive"></label>
                                  <input type="text" class="form-control" placeholder="Captcha" required>
                                </div>

                                <div class="checkbox">
                                  <label>
                                    <input type="checkbox">
                                    <a href="#" target="_blank" class="terms-font-size"> I have read and understood the Terms &amp; Conditions
                                    and the Privacy Policy of FSSAI. </a> </label>
                                </div>
                            </div>
                        
                            <div class="col-md-4 hidden-xs"></div>

                            <div class="col-md-4 col-xs-12">
                                <div class="pull-right">
                                    <div class="form-group">
                                        <a href="login.html"><input type="button" class="form-control login-btn" value="Register"></a>
                                      </div>
                                </div>
                            </div>
                        
                            <div class="col-md-4 hidden-xs"></div>
                        
</cf:form>    
                                  
                </div>
                <div class="col-md-2 hidden-xs"></div>
            </div>
  
   