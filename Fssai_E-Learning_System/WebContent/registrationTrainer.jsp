<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type='text/javascript'>
    function myFunction() {
    	window.document.myForm.imgcaptcha.src='';window.document.myForm.imgcaptcha.src='./Captcha.jpg?random='+new Date().getTime();
        return false;
    }
    
    function myCheckPermanent() {
    	var x = document.getElementById('checkPermanent').checked;
    	permanent1.style.display = checkPermanent.checked ? "none" : "block";
    	permanent2.style.display = checkPermanent.checked ? "none" : "block";
    	 if(x == true){
    	    	document.getElementById('TrainingCenterPermanentLine1').value= document.getElementById('TrainingCenterCorrespondenceLine1').value;
    	    	document.getElementById('TrainingCenterPermanentLine2').value= document.getElementById('TrainingCenterCorrespondenceLine2').value;
    	    	document.getElementById('TrainingCenterPermanentPincode').value= document.getElementById('TrainingCenterCorrespondencePincode').value;    	
    	    	document.getElementById('').value= document.getElementById('').value;
    	    	document.getElementById('').value= document.getElementById('').value;
    	    	document.getElementById('').value= document.getElementById('').value;
    	    	    	    }
    	    if(x == false){
    	    	document.getElementById('TrainingCenterCorrespondenceLine1').value= "";
    	    	document.getElementById('TrainingCenterCorrespondenceLine2').value= "";
    	    	document.getElementById('TrainingCenterCorrespondencePincode').value= "";
    	    	document.getElementById('').value= document.getElementById('').value="";
    	    	document.getElementById('').value= document.getElementById('').value="";
    	    	document.getElementById('').value= document.getElementById('').value="";   	    	
    	    }
    } 
    
    function validateFields() {
    	alert("hhhhhhhhhhhhhhhhhhhhhh");
    	var x=document.getElementById("AadharNumber").value;
    	if(x =="" || x.length<12 ) {
    		document.getElementById('AadharNumber').style.borderColor = "red";
	    	document.getElementById("AadharNumberError").style.display = 'block';
	    	document.getElementById("AadharNumber").focus();
	    	return false;
    	}else{
    	    document.getElementById('AadharNumber').style.borderColor = "#ccc";
    	    document.getElementById("AadharNumberError").style.display = 'none';
    	    }
    	
    	if(document.getElementById("firstName").value=="") {
    		alert("IN Fname");
    		document.getElementById('firstName').style.borderColor = "red";
	    	document.getElementById("firstNameError").style.display = 'block';
	    	document.getElementById("firstName").focus();
	    	return false;
    	}else{
    	    document.getElementById('firstName').style.borderColor = "#ccc";
    	    document.getElementById("firstNameError").style.display = 'none';
    	    }
    	if(document.getElementById("MiddleName").value=="") {
    		alert("IN Fname");
    		document.getElementById('MiddleName').style.borderColor = "red";
	    	document.getElementById("MiddleNameError").style.display = 'block';
	    	document.getElementById("MiddleName").focus();
	    	return false;
    	}
    	else{
    	    document.getElementById('MiddleName').style.borderColor = "#ccc";
    	    document.getElementById("MiddleNameError").style.display = 'none';
    	    }
    	if(document.getElementById("LastName").value=="") {
    		alert("IN Fname");
    		document.getElementById('LastName').style.borderColor = "red";
	    	document.getElementById("LastNameError").style.display = 'block';
	    	document.getElementById("LastName").focus();
	    	return false;
    	}
    	else{
    	    document.getElementById('LastName').style.borderColor = "#ccc";
    	    document.getElementById("LastNameError").style.display = 'none';
    	    }
    	if(document.getElementById("TrainingCenterCorrespondenceLine1").value=="") {
    		alert("IN Fname");
    		document.getElementById('TrainingCenterCorrespondenceLine1').style.borderColor = "red";
	  		document.getElementById("TrainingCenterCorrespondenceLine1Error").style.display = 'block';
	    	document.getElementById("TrainingCenterCorrespondenceLine1").focus();
	    	return false;
    	}
    	else{
    	    document.getElementById('TrainingCenterCorrespondenceLine1').style.borderColor = "#ccc";
    	    document.getElementById("TrainingCenterCorrespondenceLine1Error").style.display = 'none';
    	    }
    	if(document.getElementById("TrainingCenterCorrespondenceLine2").value=="") {
    		alert("IN Fname");
    		document.getElementById('TrainingCenterCorrespondenceLine2').style.borderColor = "red";
	    	document.getElementById("TrainingCenterCorrespondenceLine2Error").style.display = 'block';
	    	document.getElementById("TrainingCenterCorrespondenceLine2").focus();
	    	return false;
    	} 
    	else{
    	    document.getElementById('TrainingCenterCorrespondenceLine2').style.borderColor = "#ccc";
    	    document.getElementById("TrainingCenterCorrespondenceLine2Error").style.display = 'none';
    	    }
    	
    	 if(document.getElementById("TrainingCenterCorrespondenceState").selectedIndex == 0) {
    		alert("IN Fname");
    		document.getElementById('TrainingCenterCorrespondenceState').style.borderColor = "red";
	    	document.getElementById("TrainingCenterCorrespondenceStateError").style.display = 'block';
	    	document.getElementById("TrainingCenterCorrespondenceState").focus();
	    	return false;
    	}
    	 else{
     	    document.getElementById('TrainingCenterCorrespondenceState').style.borderColor = "#ccc";
     	    document.getElementById("TrainingCenterCorrespondenceStateError").style.display = 'none';
     	    }

       	 if(document.getElementById("TrainingCenterCorrespondenceDistrict").selectedIndex == 0) {
       		alert("IN Fname");
       		document.getElementById('TrainingCenterCorrespondenceDistrict').style.borderColor = "red";
   	    	document.getElementById("TrainingCenterCorrespondenceDistrictError").style.display = 'block';
   	    	document.getElementById("TrainingCenterCorrespondenceDistrict").focus();
   	    	return false;
       	}
       	 else{
        	    document.getElementById('TrainingCenterCorrespondenceDistrict').style.borderColor = "#ccc";
        	    document.getElementById("TrainingCenterCorrespondenceDistrictError").style.display = 'none';
        	    }
  
        	    if(document.getElementById("TrainingCenterCorrespondenceCity").selectedIndex == 0) {
               		alert("IN Fname");
               		document.getElementById('TrainingCenterCorrespondenceCity').style.borderColor = "red";
           	    	document.getElementById("TrainingCenterCorrespondenceCityError").style.display = 'block';
           	    	document.getElementById("TrainingCenterCorrespondenceCity").focus();
           	    	return false;
               	}
               	 else{
                	    document.getElementById('TrainingCenterCorrespondenceCity').style.borderColor = "#ccc";
                	    document.getElementById("TrainingCenterCorrespondenceCityError").style.display = 'none';
                	    }
                	    
        	    var x=document.getElementById("TrainingCenterCorrespondencePincode").value;
            	if(x =="" || x.length<6 ) 
                	    {
                    		alert("IN Fname");
                    		document.getElementById('TrainingCenterCorrespondencePincode').style.borderColor = "red";
                	    	document.getElementById("TrainingCenterCorrespondencePincodeError").style.display = 'block';
                	    	document.getElementById("TrainingCenterCorrespondencePincode").focus();
                	    	return false;
                    	} 
                    	else{
                    	    document.getElementById('TrainingCenterCorrespondencePincode').style.borderColor = "#ccc";
                    	    document.getElementById("TrainingCenterCorrespondencePincodeError").style.display = 'none';
                    	    }
                    	    
                    	    
                    	    
                    	    var x =document.getElementById('TrainingCenterPermanentEmail').value;
                    	    var atpos = x.indexOf("@");
                    	    var dotpos = x.lastIndexOf(".");
                    	    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
                    	      //  alert("Not a valid e-mail address");
                    	        document.getElementById('TrainingCenterPermanentEmail').style.borderColor = "red";
                    	    	document.getElementById("TrainingCenterPermanentEmailError").style.display = 'block';
                    	    	document.getElementById("TrainingCenterPermanentEmail").focus();
                    	    	return false;
                        	} 
                        	else{
                        	    document.getElementById('TrainingCenterPermanentEmail').style.borderColor = "#ccc";
                        	    document.getElementById("TrainingCenterPermanentEmailError").style.display = 'none';
                        	    }
                    	    var x=document.getElementById("TrainingCenterPermanentMobile").value;
                        	if(x =="" || x.length<10 || x.length>10 ) {
                        	    
                            		document.getElementById('TrainingCenterPermanentMobile').style.borderColor = "red";
                        	  		document.getElementById("TrainingCenterPermanentMobileError").style.display = 'block';
                        	    	document.getElementById("TrainingCenterPermanentMobile").focus();
                        	    	return false;
                            	}
                            	else{
                            	    document.getElementById('TrainingCenterPermanentMobile').style.borderColor = "#ccc";
                            	    document.getElementById("TrainingCenterPermanentMobileError").style.display = 'none';
                            	    }
                            	    
                            		if(document.getElementById("TrainingCenterPermanentLine1").value=="") {
                                		alert("IN Fname");
                                		document.getElementById('TrainingCenterPermanentLine1').style.borderColor = "red";
                            	    	document.getElementById("TrainingCenterPermanentLine1Error").style.display = 'block';
                            	    	document.getElementById("TrainingCenterPermanentLine1").focus();
                            	    	return false;
                                	}else{
                                	    document.getElementById('TrainingCenterPermanentLine1').style.borderColor = "#ccc";
                                	    document.getElementById("TrainingCenterPermanentLine1Error").style.display = 'none';
                                	    }
                    	    
                            	    if(document.getElementById("TrainingCenterPermanentLine2").value=="") {
                                		alert("IN Fname");
                                		document.getElementById('TrainingCenterPermanentLine2').style.borderColor = "red";
                            	    	document.getElementById("TrainingCenterPermanentLine2Error").style.display = 'block';
                            	    	document.getElementById("TrainingCenterPermanentLine2").focus();
                            	    	return false;
                                	}else{
                                	    document.getElementById('TrainingCenterPermanentLine2').style.borderColor = "#ccc";
                                	    document.getElementById("TrainingCenterPermanentLine2Error").style.display = 'none';
                                	    }
                    	    
                            	   
                            	    if(document.getElementById("TrainingCenterPermanentState").selectedIndex == 0) {
                                		alert("IN Fname");
                                		document.getElementById('TrainingCenterPermanentState').style.borderColor = "red";
                            	    	document.getElementById("TrainingCenterPermanentStateError").style.display = 'block';
                            	    	document.getElementById("TrainingCenterPermanentState").focus();
                            	    	return false;
                                	}
                                	 else{
                                 	    document.getElementById('TrainingCenterPermanentState').style.borderColor = "#ccc";
                                 	    document.getElementById("TrainingCenterPermanentStateError").style.display = 'none';
                                 	    }

                                   	 if(document.getElementById("TrainingCenterPermanentDistrict").selectedIndex == 0) {
                                   		alert("IN Fname");
                                   		document.getElementById('TrainingCenterPermanentDistrict').style.borderColor = "red";
                               	    	document.getElementById("TrainingCenterPermanentDistrictError").style.display = 'block';
                               	    	document.getElementById("TrainingCenterPermanentDistrict").focus();
                               	    	return false;
                                   	}
                                   	 else{
                                    	    document.getElementById('TrainingCenterPermanentDistrict').style.borderColor = "#ccc";
                                    	    document.getElementById("TrainingCenterPermanentDistrictError").style.display = 'none';
                                    	    }
                              
                                    	    if(document.getElementById("TrainingCenterPermanentCity").selectedIndex == 0) {
                                           		alert("IN Fname");
                                           		document.getElementById('TrainingCenterPermanentCity').style.borderColor = "red";
                                       	    	document.getElementById("TrainingCenterPermanentCityError").style.display = 'block';
                                       	    	document.getElementById("TrainingCenterPermanentCity").focus();
                                       	    	return false;
                                           	}
                                           	 else{
                                            	    document.getElementById('TrainingCenterPermanentCity').style.borderColor = "#ccc";
                                            	    document.getElementById("TrainingCenterPermanentCityError").style.display = 'none';
                                            	    }
                    	    
                                    	    
                                       	    
                                    	    var x=document.getElementById("TrainingCenterPermanentPincode").value;
                                        	if(x =="" || x.length<6 ) 
                                            	    {
                                                		alert("IN Fname");
                                                		document.getElementById('TrainingCenterPermanentPincode').style.borderColor = "red";
                                            	    	document.getElementById("TrainingCenterPermanentPincodeError").style.display = 'block';
                                            	    	document.getElementById("TrainingCenterPermanentPincode").focus();
                                            	    	return false;
                                                	} 
                                                	else{
                                                	    document.getElementById('TrainingCenterPermanentPincode').style.borderColor = "#ccc";
                                                	    document.getElementById("TrainingCenterPermanentPincodeError").style.display = 'none';
                                                	    }
                                                	    
                                                	    
                                        	 if(document.getElementById("FoodSafetyExpBackground").selectedIndex == 0) {
                                            		alert("IN Fname");
                                            		document.getElementById('FoodSafetyExpBackground').style.borderColor = "red";
                                        	    	document.getElementById("FoodSafetyExpBackgroundError").style.display = 'block';
                                        	    	document.getElementById("FoodSafetyExpBackground").focus();
                                        	    	return false;
                                            	}
                                            	 else{
                                             	    document.getElementById('FoodSafetyExpBackground').style.borderColor = "#ccc";
                                             	    document.getElementById("FoodSafetyExpBackgroundError").style.display = 'none';
                                             	    }
                                        	 
                                        	 if(document.getElementById("ExpInFoodSafefyTimeMonth").selectedIndex == 0) {
                                            		alert("IN Fname");
                                            		document.getElementById('ExpInFoodSafefyTimeMonth').style.borderColor = "red";
                                        	    	document.getElementById("ExpInFoodSafefyTimeMonthError").style.display = 'block';
                                        	    	document.getElementById("ExpInFoodSafefyTimeMonth").focus();
                                        	    	return false;
                                            	}
                                            	 else{
                                             	    document.getElementById('ExpInFoodSafefyTimeMonth').style.borderColor = "#ccc";
                                             	    document.getElementById("ExpInFoodSafefyTimeMonthError").style.display = 'none';
                                             	    }
                                                           	 
                                   	 if(document.getElementById("NoOfTrainingSessionConducted").value == "") {
                                  		alert("IN Fname");
                                  		document.getElementById('NoOfTrainingSessionConducted').style.borderColor = "red";
                                       	document.getElementById("NoOfTrainingSessionConductedError").style.display = 'block';
                                      	document.getElementById("NoOfTrainingSessionConducted").focus();
                                       	return false;
                                       	}
                                      	 else{
                                      	    document.getElementById('NoOfTrainingSessionConducted').style.borderColor = "#ccc";
                                    	    document.getElementById("NoOfTrainingSessionConductedError").style.display = 'none';
                                      	    }
                                      
                                      	   if(document.getElementById("TrainingSessionWishToConduct").value == 0) {
                                      		alert("IN Fname");
                                      		document.getElementById('TrainingSessionWishToConduct').style.borderColor = "red";
                                          	document.getElementById("TrainingSessionWishToConductError").style.display = 'block';
                                          	document.getElementById("TrainingSessionWishToConduct").focus();
                                  	    	return false;
                                         	}
                                          	 else{
                                      	    document.getElementById('TrainingSessionWishToConduct').style.borderColor = "#ccc";
                                      	    document.getElementById("TrainingSessionWishToConductError").style.display = 'none';
                                      	    }
                                                	    
                                      	    if(document.getElementById("AssociatedTrainingpartnerName").value == 0) {
                                      		alert("IN Fname");
                                      		document.getElementById('AssociatedTrainingpartnerName').style.borderColor = "red";
                                   	    	document.getElementById("AssociatedTrainingpartnerNameError").style.display = 'block';
                                  	    	document.getElementById("AssociatedTrainingpartnerName").focus();
                                   	    	return false;
                                             	}
                                        	 else{
                                      	    document.getElementById('AssociatedTrainingpartnerName').style.borderColor = "#ccc";
                                     	    document.getElementById("AssociatedTrainingpartnerNameError").style.display = 'none';
                                                      }
return true;
 }
    
    function myBasic(oCheckbox){
    	var y = [];
    	$("input[name='BasicCourse']:checked").each(function (){
    	    y.push($(this).val());
    	});
    	document.getElementById('BasicCourse1').value= y;
    	return y;
    }
    function myAdvance(oCheckbox){
    	var y = [];
    	$("input[name='AdvanceCourse']:checked").each(function (){
    	    y.push($(this).val());
    	});
    	document.getElementById('AdvanceCourse1').value= y;
    	return y;
    }
    function mySpecial(oCheckbox){
    	var y = [];
    	$("input[name='SpecialCourse']:checked").each(function (){
    	    y.push($(this).val());
    	});
    	document.getElementById('SpecialCourse1').value= y;
    	return y;
    }
    
    
    function checkname()
    {
     var name=document.getElementById( "UserId" ).value;
    	
     if(name)
     {
      $.ajax({
      type: 'post',
      url: 'checkdata.jspp?'+ name,
      data: {
       user_name:name,
      },
      success: function (response) {
       $( '#name_status' ).html(response);
       if(response=="OK")	
       {
    	   document.getElementById("register").style.display = 'none';
        return true;	
       }
       else
       {
    	   document.getElementById("register").style.display = 'block';
        return false;	
       }
      }
      });
     }
     else
     {
      $( '#name_status' ).html("");
      document.getElementById("register").style.display = 'none';
      return false;
     }
    } 
    
    function getDistrict(val)
    {
    	alert('jjh');
    	$.ajax({
    	      type: 'post',
    	      
    	      url: 'loadDistrict.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	    
    	      $('#TrainingCenterCorrespondenceDistrict option').remove();
    	      $('#TrainingCenterCorrespondenceDistrict').append('<option value="0" label="Select District" />');
    	      $('#TrainingCenterCorrespondenceCity option').remove();
    	      $('#TrainingCenterCorrespondenceCity').append('<option value="0" label="Select City" />');
    	  	 
    	      $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingCenterCorrespondenceDistrict').append('<option value='+obj.districtId+' label='+obj.districtName+' />');		
    	  		});
    	      }
    	      });     
    }
    
    function getDistrictList(val)
    {
    	alert('city');
    	$.ajax({
    	      type: 'post',
    	      
    	      url: 'loadDistrict.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	    
    	      $('#TrainingCenterPermanentDistrict option').remove();
    	      $('#TrainingCenterPermanentDistrict').append('<option value="0" label="Select District" />');
    	      $('#TrainingCenterPermanentCity option').remove();
    	      $('#TrainingCenterPermanentCity').append('<option value="0" label="Select City" />');
    	  	 
    	      $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingCenterPermanentDistrict').append('<option value='+obj.districtId+' label='+obj.districtName+' />');		
    	  		});
    	      }
    	      });     
    }
    
    
    
    
    function getCity(val)
    {
    	$.ajax({
    	      type: 'post',
    	      url: 'loadCity.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	      $('#TrainingCenterCorrespondenceCity option').remove();
    	      $('#TrainingCenterCorrespondenceCity').append('<option value="0" label="Select City" />');
    	  	  $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingCenterCorrespondenceCity').append('<option value='+obj.cityId+' label='+obj.cityName+' />');		
    	  		});
    	      }
    	      });     
    }
    
    function getCityList(val)
    {
    	$.ajax({
    	      type: 'post',
    	      url: 'loadCity.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	      $('#TrainingCenterPermanentCity option').remove();
    	      $('#TrainingCenterPermanentCity').append('<option value="0" label="Select City" />');
    	  	  $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingCenterPermanentCity').append('<option value='+obj.cityId+' label='+obj.cityName+' />');		
    	  		});
    	      }
    	      });     
    }
    
    
    
</script>


<cf:form   action="registrationTrainer.fssai" name="myForm" method="POST" commandName="registrationFormTrainer" onsubmit="return validateFields();"> 

<!-- login form -->
<div class="row">
<div class="col-md-2 hidden-xs"></div>
<div class="col-md-8  col-xs-12">
<h3 class="text-capitalize heading-3-padding">Trainer Registration Form</h3>
         
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
<li class="style-li error-red"><span id="name_status"> </span><span id="err"> </span>
<cf:errors path="UserId" cssclass="error" /></li>
</ul>
</div>
<cf:input path="UserId" class="form-control" onKeyUP="this.value = this.value.toUpperCase();"  placeholder="User Id"  onblur  ="checkname();"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.AadharNumber" /></strong></li>

<li class="style-li error-red">
<label id="AadharNumberError" class="error visibility">* enter your AadharNumber </label>
<cf:errors path="AadharNumber" cssclass="error" /></li>
</ul>
</div>
<cf:input path="AadharNumber"  class="form-control" maxlength="12"  placeholder="Aadhar Number" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.DOB" /></strong></li>
<li class="style-li error-red">
<label id="DOBError" class="error visibility">* error</label>
<cf:errors path="DOB" cssclass="error" /></li>
</ul>
</div>
<cf:input path="DOB" type="date" class="form-control"  placeholder="DOB"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Gender" /></strong></li>
<li class="style-li error-red"><cf:errors path="gender" cssclass="error" /></li>
</ul>
</div>
<label class="radio-inline">
<cf:radiobutton path="gender" value="M" checked="true" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <cf:radiobutton path="gender" value="F" />Female
</label>
</div>
</div>         
<!-- right side -->
<div class="col-md-6 col-xs-12">
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Title" /></strong></li>
<li class="style-li error-red">

<label class="error visibility" id="TitleError">Please select title</label>
<cf:errors path="Title" cssclass="error" /></li>
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
<li class="style-li error-red">
<label id="firstNameError" class="error visibility">Enter your first name error</label>
<cf:errors path="firstName" cssclass="error" /></li>
</ul>
</div>
<cf:input path="firstName" class="form-control"  placeholder="First Name"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.MiddleName" /></strong></li>
<li class="style-li error-red">
<label id="MiddleNameError" class="error visibility">* enter your Middle Name </label>
<cf:errors path="MiddleName" cssclass="error" /></li>
</ul>
</div>
<cf:input path="MiddleName" class="form-control" name="MiddleName"  placeholder="Middle Name"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.LastName" /></strong></li>
<li class="style-li error-red">
<label id="LastNameError" class="error visibility">* error </label>
<cf:errors path="LastName" cssclass="error" /></li>
</ul>
</div>
<cf:input path="LastName" class="form-control"  placeholder="Last Name"/>
</div>

</div></fieldset>
</div>

<div class="row" style="height: 20px;"> </div>          
<!-- contact details -->
<div class="personel-info">
<fieldset>
<legend>Correspondence Address</legend>              
<!-- permanent address -->
<!--Left side-->
<div class="col-md-6 col-xs-12">

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainer.TrainingCenterCorrespondenceLine1" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterCorrespondenceLine1Error" class="error visibility">* enter your TrainingCenterCorrespondence1</label>
<cf:errors path="TrainingCenterCorrespondenceLine1" cssclass="error" /></li>  
</ul>
</div>
<cf:input path="TrainingCenterCorrespondenceLine1" class="form-control"  placeholder="Address Line 1"/>
</div> 

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainer.TrainingCenterCrrespondenceLine2" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterCorrespondenceLine2Error" class="error visibility">* enter your TrainingCenterCorrespondence2</label>
<cf:errors path="TrainingCenterCorrespondenceLine2" cssclass="error" /></li>  
</ul>
</div>
<cf:input path="TrainingCenterCorrespondenceLine2" class="form-control"  placeholder="Address Line 1"/>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.correspondenceState" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="TrainingCenterCorrespondenceStateError">Please select state</label>
<cf:errors path="TrainingCenterCorrespondenceState" cssclass="error" /></li>
</ul>
</div>
<cf:select path="TrainingCenterCorrespondenceState" class="form-control" onchange="getDistrict(this.value);">
<cf:option value="0" label="Select State" />
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
</cf:select>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.District" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="TrainingCenterCorrespondenceDistrictError">Please select district</label>
<cf:errors path="TrainingCenterCorrespondenceDistrict" cssclass="error" /></li>
</ul>
</div>
<cf:select path="TrainingCenterCorrespondenceDistrict" class="form-control" onchange="getCity(this.value);">
<cf:option value="0" label="Select District" />
<%-- <cf:options items="${districtList}" itemValue="districtId" --%>itemLabel="districtName" /> 
</cf:select>
</div>
</div>
<!-- left side ends -->               
<!-- right side -->
<div class="col-md-6 col-xs-12">

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.correspondenceCity" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="TrainingCenterCorrespondenceCityError">Please select city</label>
<cf:errors path="TrainingCenterCorrespondenceCity" cssclass="error" /></li>
</ul>
</div>
<cf:select path="TrainingCenterCorrespondenceCity" class="form-control">
<cf:option value="0" label="Select City" />
<%-- <cf:options items="${cityList}" itemValue="cityId" --%> itemLabel="cityName" />
</cf:select>
</div>
              
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.correspondencePincode" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterCorrespondencePincodeError" class="error visibility">* enter your 6 Digit Pincode</label>
<cf:errors path="TrainingCenterCorrespondencePincode" cssclass="error" /></li>        
</ul>
</div>
<cf:input path="TrainingCenterCorrespondencePincode"  onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Pincode" class="form-control"  maxlength="6" />
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.correspondenceEmail" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterPermanentEmailError" class="error visibility">* enter your Valid Email</label>
<cf:errors path="TrainingCenterPermanentEmail" cssclass="error" /></li>
</ul>
</div>
<cf:input path="TrainingCenterPermanentEmail" placeholder="Email Id" class="form-control" />
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.correspondenceMobile" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterPermanentMobileError" class="error visibility">* enter your TrainingCenterPermanentMobile</label>
<cf:errors path="TrainingCenterPermanentMobile" cssclass="error" /></li>
</ul>
</div>
<cf:input path="TrainingCenterPermanentMobile" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Mobile Number" class="form-control"  maxlength="10" />  
</div>
</div>
<!-- right side ends -->
<!-- permanent address ends -->
<!-- selection -->


<!-- selection ends -->
              

</fieldset>

<br><br>












<fieldset>
		<legend>Permanent Address</legend>
		
<div class="col-xs-12">
<div class="col-md-12 col-sm-12 col-x-sm-12">
<input type="checkbox" id="checkPermanent" onclick="myCheckPermanent(this)"> <label class = "error">Is your correspondence address same as permanent address.</label> 
</div>

</div>		
<!--Left side-->
<div class="col-md-6 col-xs-12" id="permanent1">

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainer.TrainingCenterPermanentLine1" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterPermanentLine1Error" class="error visibility">* enter your Permanent Training Center</label>
<cf:errors path="TrainingCenterPermanentLine1"  cssclass="error"/></li> 
</ul>
</div>
<cf:input path="TrainingCenterPermanentLine1" placeholder="Address Line 1" class="form-control" />
</div> 

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainer.TrainingCenterPermanentLine2" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterPermanentLine2Error" class="error visibility">* enter your Permanent Training Center</label>
<cf:errors path="TrainingCenterPermanentLine2"  cssclass="error"/></li> 
</ul>
</div>
<cf:input path="TrainingCenterPermanentLine2" placeholder="Address Line 2" class="form-control" />
</div> 

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.State" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="TrainingCenterPermanentStateError">Please select state</label>
<cf:errors path="TrainingCenterPermanentState" cssclass="error" /></li>
</ul>
</div>
<cf:select path="TrainingCenterPermanentState" class="form-control" onchange="getDistrictList(this.value);">
<cf:option value="0" label="Select State" />
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
</cf:select>
</div>


</div>
<!-- left side ends -->               
<!-- right side -->
<div class="col-md-6 col-xs-12" id="permanent2">
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.District" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="TrainingCenterPermanentDistrictError">Please select district</label>
<cf:errors path="TrainingCenterPermanentDistrict" cssclass="error" /></li>
</ul>
</div>
<cf:select path="TrainingCenterPermanentDistrict" class="form-control"  onchange="getCityList(this.value);">
<cf:option value="0" label="Select District" />
<%-- <cf:options items="${districtList}" itemValue="districtId" --%> itemLabel="districtName" />
</cf:select>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.City" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="TrainingCenterPermanentCityError">Please select city</label>
<cf:errors path="TrainingCenterPermanentCity" cssclass="error" /></li>
</ul>
</div>
<cf:select path="TrainingCenterPermanentCity" class="form-control">
<cf:option value="0" label="Select City" />
<%-- <cf:options items="${cityList}" itemValue="cityId" --%> itemLabel="cityName" />
</cf:select>
</div>
              
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Pincode" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterPermanentPincodeError" class="error visibility">* enter your pinNumber</label>
<cf:errors path="TrainingCenterPermanentPincode" cssclass="error" /></li>        
</ul>
</div>
<input id="TrainingCenterPermanentPincode" name="TrainingCenterPermanentPincode" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Pincode" class="form-control" type="text" value="" maxlength="6">
</div>


</div>
<!-- right side ends -->
</fieldset>



</div>


<!-- contact details ends -->          
<div class="row" style="height: 20px;"> </div>          
<!-- Experience Detais -->
<div class="personel-info">
<fieldset>
<legend>Experience Details</legend>              
<!-- left side -->
<div class="col-md-6 col-xs-12">
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainer.FoodSafetyExperienceBackground" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="FoodSafetyExpBackgroundError">Please select experience</label>

<cf:errors path="FoodSafetyExpBackground" cssclass="error" /></li>
</ul>
</div>
<cf:select path="FoodSafetyExpBackground" class="form-control">
<cf:option value="0" label="Select background" />
<cf:option value="1" label="Industry" />
<cf:option value="2" label="Academics" />
<cf:option value="3" label="R & D" />
</cf:select>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong>

<cs:message code="lbl.Trainer.ExperienceinFoodSafetyExperience" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="ExpInFoodSafefyTimeMonthError">Please select experience</label>
</li>
</ul>
</div>
<div class="row">
<div class="col-xs-6">
<cf:input cssclass="form-control" place-holder="Years" path="ExpInFoodSafefyTimeYear" maxlength="2" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"/>
</div>
<div class="col-xs-6">
<cf:select path="ExpInFoodSafefyTimeMonth" class="form-control">
<cf:option value="0" label="Select Month" />
<cf:option value="1" label="1" />
<cf:option value="2" label="2" />
<cf:option value="3" label="3" />
<cf:option value="4" label="4" />
<cf:option value="5" label="5" />
<cf:option value="6" label="6" />
<cf:option value="7" label="7" />
<cf:option value="8" label="8" />
<cf:option value="9" label="9" />
<cf:option value="10" label="10" />
<cf:option value="11" label="11" />
<cf:option value="12" label="12" />
</cf:select>
</div>
</div>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong>No. Of Training Sessions Conducted:</strong></li>
<li class="style-li error-red"> 
<label class="error visibility" id="NoOfTrainingSessionConductedError">Please enter your session</label>

<cf:errors path="NoOfTrainingSessionConducted" cssclass="error" />

</li>
</ul>
</div>
<cf:input path="NoOfTrainingSessionConducted" class="form-control" placeholder="Session Number" maxlength="4" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"/>
</div>
</div>
<!-- left side ends --> 
              
<!-- right side -->
<div class="col-md-6 col-xs-12">
<div class="form-group">
<ul class="lab-no">
<li class="style-li error-red">
<label class="error visibility" id="TrainingSessionWishToConductError">Please select experience</label>

<cf:errors path="TrainingSessionWishToConduct" cssclass="error" /></li>
</ul>
<label>How Many Trainings (4Hrs) Sessions Wish To Conduct in a Month ?</label>
<cf:input path="TrainingSessionWishToConduct" class="form-control" placeholder="Session Number" maxlength="2" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"/>
</div>
<div class="form-group">
<label>Associated with any Training Partner ?</label>
<br />

<label class="radio-inline">
<cf:radiobutton path="AssociatedWithAnyTrainingPartner" value="Y" checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<cf:radiobutton path="AssociatedWithAnyTrainingPartner" value="N" />No</td>
</label>

</div>
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong>If Yes Training Partner Name:</strong></li>
<li class="style-li error-red"> 
<label id=AssociatedTrainingpartnerNameError class="error visibility">* enter your AssociatedTrainingpartnerName</label>
<cf:errors path="AssociatedTrainingpartnerName" cssclass="error" /></li>
</ul>
</div>
<cf:input path="AssociatedTrainingpartnerName" class="form-control" placeholder="Partner Name" />
</div>
</div>
<!-- right side ends -->              
</fieldset>
</div>
<div class="row" style="height: 20px;"> </div>
<!-- Basic courses -->
<div class="personel-info">
<h4>Courses wish to conduct ?</h4>
<fieldset>
<legend>Basic Courses</legend>
<!-- left -->
<div class="col-md-6 col-xs-12" style="width:100%;">

            
<div class="checkbox">
 <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue.coursetypeid == 1}">
 <label> <input type="checkbox"  value="${listValue.coursenameid }" name="BasicCourse"  id="${listValue.coursenameid }"  onclick=" return myBasic();">${listValue.coursename}</label><br>
 </ct:if>
 </ct:forEach>

 <cf:hidden path="BasicCourse1" value=""/>
</div>
 </div>
<!-- right -->
<div class="col-md-6 col-xs-12"></div>
</fieldset>
</div>
<!-- basic course -->           
<!-- Advanced courses -->          
<div class="personel-info">
<fieldset>
<legend>Advanced Courses</legend>
<!-- left -->
<div class="col-md-6 col-xs-12" style="width:100%;">
<div class="checkbox">
 <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue.coursetypeid == 2}">
 <label> <input type="checkbox" value="${listValue.coursenameid }" name="AdvanceCourse" id="${listValue.coursenameid }" onclick=" return myAdvance();">${listValue.coursename}</label><br>
 </ct:if>
 </ct:forEach>
 <cf:hidden path="AdvanceCourse1" value=""/>
</div>
<!-- right -->
<div class="col-md-6 col-xs-12"></div></div>
</fieldset>
</div>
<!-- advanced course --> 
          
<!-- special courses -->
<div class="personel-info">
<fieldset>
<legend>Special Courses</legend>
<!-- left -->
<div class="col-md-6 col-xs-12" style="width:100%;">
<div class="checkbox">
 <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue.coursetypeid == 3}">
 <label> <input type="checkbox"  value="${listValue.coursenameid }" name="SpecialCourse"  id="${listValue.coursenameid }"  onclick=" return mySpecial();">${listValue.coursename}</label><br>
 </ct:if>
</ct:forEach>
<cf:hidden path="SpecialCourse1" value=""/>
</div>
</div>              
<!-- right -->
<div class="col-md-6 col-xs-12"> </div>
</fieldset>
</div>
<!-- special course -->          
<div class="row" style="height: 20px;"> </div>
<div style="width:95%; margin-left:20px; float:left; height:100px; border:1px solid #cecece;"  class="form-group">
<div style="float:left">

<div style="float:left; width:98%;">
<label id="captchaError" style="float:left; width:99%; font-family:Calibri; margin-left:0px;">Please enter captcha in below textbox !!!</label>
</div>
<div style="float:left; width:99%;">
<img src="./Captcha.jpg" name="imgcaptcha" class="img-responsive" style="float:left; margin-left:1%;"/>
<button type="button" style="float:left; margin-left:1%; background:#f55d11; height:45px; color:#fff; border-radius:8px; border:none;"
 onclick="window.document.myForm.imgcaptcha.src='';window.document.myForm.imgcaptcha.src='./Captcha.jpg?random='+new Date().getTime();"> <i class="fa fa-refresh"></i> </button>
<input type="text" class="form-control" id ="Captcha"placeholder="Captcha"  style="float:left; margin-left:1%; width:25%;" />
</div>
</div>
<div style="float:left; width:99%;">
<input type="checkbox" id="check" style="margin-left:1%;">
<a href="#" target="_blank" class="terms-font-size"> I have read and understood the Terms & Conditions and the Privacy Policy of FSSAI. </a>
</div>
</div>



<div class="col-xs-12"></div>
          <div class="col-md-4 hidden-xs"></div>
          <div class="col-md-4 col-xs-12" id="register">
            <div class="pull-right">
              <div class="form-group"> 
                <input type="submit"  class="form-control login-btn" value="Register" >
                </div>
            </div>
          </div>
          <div class="col-md-4 hidden-xs"></div>

      </div>
      <div class="col-md-2 hidden-xs"></div>
      </div>
</cf:form>