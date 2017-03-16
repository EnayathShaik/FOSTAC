<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function OnStart(){
	DrawCaptcha();
	getTPName();
}
window.onload = OnStart;
</script>
<script src="website/js/commonController.js"></script>
<script>
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
	  if(response.trim() == 'Already'){
		  document.getElementById('UserId').value="";
	  }
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

function getTPName(){
	var TPName = '${userName }'; // $("#TrainingPartnerName option:selected").text();
	TPName = TPName.substring(2,5).toUpperCase();
	alert(" TPName  "+TPName);
	$("#TPName").val(TPName);
	
}
function DrawCaptcha()
{
    var a = Math.ceil(Math.random() * 10)+ '';
    var b = Math.ceil(Math.random() * 10)+ '';       
    var c = Math.ceil(Math.random() * 10)+ '';  
    var d = Math.ceil(Math.random() * 10)+ '';  
    var e = Math.ceil(Math.random() * 10)+ '';  
    var f = Math.ceil(Math.random() * 10)+ '';  
    var g = Math.ceil(Math.random() * 10)+ '';  
    var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f + ' ' + g;
    document.getElementById("txtCaptcha").value = code
}

// Validate the Entered input aganist the generated security code function   
function ValidCaptcha(){
    var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
    var str2 = removeSpaces(document.getElementById('txtInput').value);
    if (str1 == str2) 
{
    	return checkagree();
//return true;
}     else
	{
	alert("Please Enter correct captcha");
	document.getElementById('txtInput').value="";
    return false;
	}
}

// Remove the spaces from the entered and generated code
function removeSpaces(string)
{
    return string.split(' ').join('');
}

function checkagree()
{
	var d=document.getElementById('check').checked;
	if(d==true)
	{
		return true;
	}
	else
		{
		alert('Please Confirm on agree');
		return false;
		}
	}


function myBasic(oCheckbox){
	//alert('basic');
	var y = [];
	$("input[name='BasicCourse']:checked").each(function (){
	    y.push($(this).val());
	});
	document.getElementById('BasicCourse1').value= y;
	return y;
}
function myAdvance(oCheckbox){
	alert('advance');
	var y = [];
	$("input[name='AdvanceCourse']:checked").each(function (){
	    y.push($(this).val());
	});
	document.getElementById('AdvanceCourse1').value= y;
	return y;
}
function mySpecial(oCheckbox){
	//alert('special');
	var y = [];
	$("input[name='SpecialCourse']:checked").each(function (){
	    y.push($(this).val());
	});
	document.getElementById('SpecialCourse1').value= y;
	return y;
}

</script>
<script type="text/javascript" language="javascript">
function AvoidSpace(event) {
    var k = event ? event.which : window.event.keyCode;
    if (k == 32) return false;
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
    

    function getCity(val)
    {
    	$.ajax({
    	      type: 'post',
    	      url: 'loadCity.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	      $('#TrainingPartnerPermanentCity option').remove();
    	      $('#TrainingPartnerPermanentCity').append('<option value="0" label="Select City" />');
    	  	  $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingPartnerPermanentCity').append('<option value='+obj.cityId+'>'+obj.cityName+'</option>');		
    	  		});
    	      }
    	      });     
    }
   
    function validateFields() {

    	
    	//alert("Training Centre Name");
    	if(document.getElementById('TrainingCentreName').value == '') {
    	document.getElementById("TrainingCentreName").style.borderColor = "red";
    	document.getElementById("TrainingCentreNameError").style.display = 'block';
    	document.getElementById("TrainingCentreName").focus();
    	return false;
    	}else{
    		//alert("Training Centre Name66666666666666666");
    	    document.getElementById('TrainingCentreName').style.borderColor = "#ccc";
    	    document.getElementById("TrainingCentreNameError").style.display = 'none';
    	    } 
    	
    
    	if(document.getElementById('PAN').value == '') {
    	document.getElementById("PAN").style.borderColor = "red";
    	document.getElementById("PANError").style.display = 'block';
    	document.getElementById("PAN").focus();
    	return false;
    	}else{
    		//alert("PAN Name*********");
    	    document.getElementById('PAN').style.borderColor = "#ccc";
    	    document.getElementById("PANError").style.display = 'none';
    	    } 
    	
    	//Title
    	//alert("Title Name");
    	if(document.getElementById('Title').value == '0') {
    	document.getElementById("Title").style.borderColor = "red";
    	document.getElementById("TitleError").style.display = 'block';
    	document.getElementById("Title").focus();
    	return false;
    	}else{
    		//alert("Title Name*********");
    	    document.getElementById('Title').style.borderColor = "#ccc";
    	    document.getElementById("TitleError").style.display = 'none';
    	    } 
    	
    	//FirstName
    	//alert("First Name");
    	if(document.getElementById('FirstName').value == '') {
    	document.getElementById("FirstName").style.borderColor = "red";
    	document.getElementById("FirstNameError").style.display = 'block';
    	document.getElementById("FirstName").focus();
    	return false;
    	}else{
    		//alert("FirstName Name*********");
    	    document.getElementById('FirstName').style.borderColor = "#ccc";
    	    document.getElementById("FirstNameError").style.display = 'none';
    	    } 
    	
    	//LastName
    	//alert("LastName Name");
    	if(document.getElementById('LastName').value == '') {
    	document.getElementById("LastName").style.borderColor = "red";
    	document.getElementById("LastNameError").style.display = 'block';
    	document.getElementById("LastName").focus();
    	return false;
    	}else{
    		//alert("FirstName Name*********");
    	    document.getElementById('LastName').style.borderColor = "#ccc";
    	    document.getElementById("LastNameError").style.display = 'none';
    	    } 
    	
    	//TrainingPartnerPermanentLine1
    	//alert("TrainingPartnerPermanentLine1 Name");
    	if(document.getElementById('TrainingPartnerPermanentLine1').value == '') {
    	document.getElementById("TrainingPartnerPermanentLine1").style.borderColor = "red";
    	document.getElementById("TrainingPartnerPermanentLine1Error").style.display = 'block';
    	document.getElementById("TrainingPartnerPermanentLine1").focus();
    	return false;
    	}else{
    		//alert("TrainingPartnerPermanentLine1 Name*********");
    	    document.getElementById('TrainingPartnerPermanentLine1').style.borderColor = "#ccc";
    	    document.getElementById("TrainingPartnerPermanentLine1Error").style.display = 'none';
    	    } 
    	
    	//TrainingPartnerPermanentLine2
    	//alert("TrainingPartnerPermanentLine2 Name");
    	if(document.getElementById('TrainingPartnerPermanentLine2').value == '') {
    	document.getElementById("TrainingPartnerPermanentLine2").style.borderColor = "red";
    	document.getElementById("TrainingPartnerPermanentLine2Error").style.display = 'block';
    	document.getElementById("TrainingPartnerPermanentLine2").focus();
    	return false;
    	}else{
    		//alert("TrainingPartnerPermanentLine2 Name*********");
    	    document.getElementById('TrainingPartnerPermanentLine2').style.borderColor = "#ccc";
    	    document.getElementById("TrainingPartnerPermanentLine2Error").style.display = 'none';
    	    } 
    	
    	//alert('state name');
    	if(document.getElementById('TrainingPartnerPermanentState').value == '0') {
    		//alert('state   ' + document.getElementById('TrainingPartnerPermanentState').value);
    	document.getElementById("TrainingPartnerPermanentState").style.borderColor = "red";
    	document.getElementById("TrainingPartnerPermanentStateError").style.display = 'block';
    	document.getElementById("TrainingPartnerPermanentState").focus();
    	return false;
    	}else{
    	    document.getElementById('TrainingPartnerPermanentState').style.borderColor = "#ccc";
    	    document.getElementById("TrainingPartnerPermanentStateError").style.display = 'none';
    	    }
    	
    	if(document.getElementById('TrainingPartnerPermanentDistrict').value == '0') {
    		//alert('district');
        	document.getElementById("TrainingPartnerPermanentDistrict").style.borderColor = "red";
        	document.getElementById("TrainingPartnerPermanentDistrictError").style.display = 'block';
        	document.getElementById("TrainingPartnerPermanentDistrict").focus();
        	return false;
        	}else{
        	    document.getElementById('TrainingPartnerPermanentDistrict').style.borderColor = "#ccc";
        	    document.getElementById("TrainingPartnerPermanentDistrictError").style.display = 'none';
        	    }
    		//alert('city name');
    	   if(document.getElementById('TrainingPartnerPermanentCity').value == '0') {
    		
        	document.getElementById("TrainingPartnerPermanentCity").style.borderColor = "red";
        	document.getElementById("TrainingPartnerPermanentCityError").style.display = 'block';
        	document.getElementById("TrainingPartnerPermanentCity").focus();
        	return false;
        	}else{
        	    document.getElementById('TrainingPartnerPermanentCity').style.borderColor = "#ccc";
        	    document.getElementById("TrainingPartnerPermanentCityError").style.display = 'none';
        	    }
    	   
    	   
    	 //TrainingPartnerPermanentPincode
       	//alert("TrainingPartnerPermanentPincode Name");
    	var x= document.getElementById('TrainingPartnerPermanentPincode').value;
       	if(x=='' ||x.length<6) {
       	document.getElementById("TrainingPartnerPermanentPincode").style.borderColor = "red";
       	document.getElementById("TrainingPartnerPermanentPincodeError").style.display = 'block';
       	document.getElementById("TrainingPartnerPermanentPincode").focus();
       	return false;
       	}else{
       		//alert("TrainingPartnerPermanentPincode Name*********");
       	    document.getElementById('TrainingPartnerPermanentPincode').style.borderColor = "#ccc";
       	    document.getElementById("TrainingPartnerPermanentPincodeError").style.display = 'none';
       	    } 
       	
      //TrainingPartnerPermanentEmail
       //	alert("TrainingPartnerPermanentEmail Name");
       	 var x =document.getElementById('TrainingPartnerPermanentEmail').value;
         var atpos = x.indexOf("@");
         var dotpos = x.lastIndexOf(".");
         if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
         //  ////alert("Not a valid e-mail address");
		document.getElementById('TrainingPartnerPermanentEmail').style.borderColor = "red";
        document.getElementById("TrainingPartnerPermanentEmailError").style.display = 'block';
        document.getElementById("TrainingPartnerPermanentEmail").focus();
        return false;
        }else{
        	document.getElementById('TrainingPartnerPermanentEmail').style.borderColor = "#ccc";
            document.getElementById("TrainingPartnerPermanentEmailError").style.display = 'none';
        } 
    	
       	//TrainingPartnerPermanentMobile
	  	//alert("TrainingPartnerPermanentMobile Name");
       var x=document.getElementById('TrainingPartnerPermanentMobile').value;
       if(x!=''){
       	if(x.length<10) {
       	document.getElementById("TrainingPartnerPermanentMobile").style.borderColor = "red";
       	document.getElementById("TrainingPartnerPermanentMobileError").style.display = 'block';
       	document.getElementById("TrainingPartnerPermanentMobile").focus();
       	return false;
       	}
       	}else{
       		//alert("TrainingPartnerPermanentMobile Name*********");
       	    document.getElementById('TrainingPartnerPermanentMobile').style.borderColor = "#ccc";
       	    document.getElementById("TrainingPartnerPermanentMobileError").style.display = 'none';
       	    } 
       	
       //	SeatCapacityPerSession
     // alert("SeatCapacityPerSession Name");
       	if(document.getElementById('SeatCapacityPerSession').value == '') {
       	document.getElementById("SeatCapacityPerSession").style.borderColor = "red";
       	document.getElementById("SeatCapacityPerSessionError").style.display = 'block';
       	document.getElementById("SeatCapacityPerSession").focus();
       	return false;
       	}else{
       		//alert("SeatCapacityPerSession Name*********");
       	    document.getElementById('SeatCapacityPerSession').style.borderColor = "#ccc";
       	    document.getElementById("SeatCapacityPerSessionError").style.display = 'none';
       	    } 

          	if(document.getElementById('NoOfInHouseTrainers').value == '') {
          	document.getElementById("NoOfInHouseTrainers").style.borderColor = "red";
          	document.getElementById("NoOfInHouseTrainersError").style.display = 'block';
          	document.getElementById("NoOfInHouseTrainers").focus();
          	return false;
          	}else{
          		//alert("NoOfInHouseTrainers *********");
          	    document.getElementById('NoOfInHouseTrainers').style.borderColor = "#ccc";
          	    document.getElementById("NoOfInHouseTrainersError").style.display = 'none';
          	    } 
          	
          	 // NoOfYearsInBusinessOfTraining
          	//alert("NoOfYearsInBusinessOfTraining");
          	if(document.getElementById('NoOfYearsInBusinessOfTraining').value == '') {
          	document.getElementById("NoOfYearsInBusinessOfTraining").style.borderColor = "red";
          	document.getElementById("NoOfYearsInBusinessOfTrainingError").style.display = 'block';
          	document.getElementById("NoOfYearsInBusinessOfTraining").focus();
          	return false;
          	}else{
          		//alert("NoOfYearsInBusinessOfTraining *********");
          	    document.getElementById('NoOfYearsInBusinessOfTraining').style.borderColor = "#ccc";
          	    document.getElementById("NoOfYearsInBusinessOfTrainingError").style.display = 'none';
          	    } 
          	

         	 // NoOfYearsInBusinessOfTraining
         	//alert("NoOfYearsInBusinessOfTraining");
         	if(document.getElementById('NoOfYearsInBusinessOfTraining').value == '') {
         	document.getElementById("NoOfYearsInBusinessOfTraining").style.borderColor = "red";
         	document.getElementById("NoOfYearsInBusinessOfTrainingError").style.display = 'block';
         	document.getElementById("NoOfYearsInBusinessOfTraining").focus();
         	return false;
         	}else{
         		//alert("NoOfYearsInBusinessOfTraining *********");
         	    document.getElementById('NoOfYearsInBusinessOfTraining').style.borderColor = "#ccc";
         	    document.getElementById("NoOfYearsInBusinessOfTrainingError").style.display = 'none';
         	    } 
         	
         //	NoOfTrainingSessionWishToConductInAMonth
         	//alert("NoOfTrainingSessionWishToConductInAMonth");
         	if(document.getElementById('NoOfTrainingSessionWishToConductInAMonth').value == '') {
         	document.getElementById("NoOfTrainingSessionWishToConductInAMonth").style.borderColor = "red";
         	document.getElementById("NoOfTrainingSessionWishToConductInAMonthError").style.display = 'block';
         	document.getElementById("NoOfTrainingSessionWishToConductInAMonth").focus();
         	return false;
         	}else{
         		//alert("NoOfTrainingSessionWishToConductInAMonth *********");
         	    document.getElementById('NoOfTrainingSessionWishToConductInAMonth').style.borderColor = "#ccc";
         	    document.getElementById("NoOfTrainingSessionWishToConductInAMonthError").style.display = 'none';
         	    } 
         	
         	//txtCaptcha
         	
         	if(document.getElementById('txtCaptcha').value == '') {
         	document.getElementById("txtCaptcha").style.borderColor = "red";
         	document.getElementById("txtCaptchaError").style.display = 'block';
         	document.getElementById("txtCaptcha").focus();
         	return false;
         	}else{
         		
         	    document.getElementById('txtCaptcha').style.borderColor = "#ccc";
         	    document.getElementById("txtCaptchaError").style.display = 'none';
         	    } 
         	
         	
    	
    return( true );
    
   }</script>

<cf:form action="registrationTrainingPartner.fssai" name="myForm"
	method="POST" commandName="registrationFormTrainingPartner"
	onsubmit="return validateFields();">
	<section>
		<%@include file="../roles/top-menu.jsp"%>
	</section>
	<!-- main body -->
	<section class="main-section-margin-top">
		<div class="container-fluid">
			<div id="wrapper">

				<!-- Sidebar -->
				<%@include file="../roles/slider.jsp"%>
				<!-- /#sidebar-wrapper -->
				<!-- Page Content -->
				<div id="page-content-wrapper">
					<div class="container-fluid">

						<!-- vertical button -->
						<div class="row">
							<div class="col-lg-12">
								<a href="#menu-toggle" class="vertical-menu-position-btn"
									id="menu-toggle"> <i class="fa fa-bars"></i> <span
									class="orange-font">Welcome Training Center</span>
								</a>
							</div>
						</div>

						<!-- add the content here for main body -->
						<!-- timeline  -->
						<section class="section-form-margin-top">

							<!-- fostac logo -->
							<!-- login form -->
							<div class="row">
								<div class="col-md-2 hidden-xs"></div>
								<div class="col-md-8  col-xs-12">
                    <h3 class="text-capitalize heading-3-padding">Training Center Registration Form</h3>

                    <!-- Training Center information -->
                    <div class="personel-info">
                        <fieldset>
                            <legend>
                                Training Center Information</legend>
                            <!-- left side -->
                            <div class="col-md-6 col-xs-12">
                            	<div class="form-group" style="display: none">

													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.UserId" /></strong></li>
															<li class="style-li error-red"><span id="name_status"> <label id="UserIdError"
																	class="error visibility">Enter UserId</label> <cf:errors
																		path="UserId" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="UserId" maxlength="20" class="form-control"
														placeholder="User ID" />
												</div>
                               					<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Training
																	Center Name</strong></li>
															<li class="style-li error-red"><label
																id="TrainingCentreNameError" class="error visibility">Enter
																	Training Centre Name</label> <cf:errors
																	path="TrainingCentreName" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="TrainingCentreName" maxlength="50"
														class="form-control" placeholder="Training Centre Name" />
												</div>

                             					<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Training
																	Partner Name:</strong></li>
															<li class="style-li error-red"><cf:errors
																	path="TrainingPartnerName" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input type="hidden" path="TPName" id="TPName" />
													<cf:select path="TrainingPartnerName" class="form-control"
														onchange="getTPName()">
														<cf:option value="${partnerId }" label="${userName }" />
														<%-- <cf:options items="${trainingPartnerNameList}"
															itemValue="manageTrainingPartnerId"
															itemLabel="trainingPartnerName" /> --%>
													</cf:select>
												</div>

                             					<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Training Center Address</strong> (<em>Line 1</em>)<strong>:</strong></li>
															<li class="style-li error-red"><label
																id="TrainingPartnerPermanentLine1Error"
																class="error visibility">Enter Training Center
																	Address Line 1</label> <cf:errors
																	path="TrainingPartnerPermanentLine1" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="TrainingPartnerPermanentLine1"
														maxlength="100" class="form-control"
														placeholder="Training Partner Address 1" />
												</div>


                               						<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Training Center Address</strong> (<em>Line 2</em>)<strong>:</strong></li>
															<li class="style-li error-red"><label
																id="TrainingPartnerPermanentLine2Error"
																class="error visibility">Enter Training Center
																	Address Line 2</label> <cf:errors
																	path="TrainingPartnerPermanentLine2" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="TrainingPartnerPermanentLine2"
														maxlength="100" class="form-control"
														placeholder="Training Partner Address 2" />
												</div>

                              					<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>State:</strong></li>
															<li class="style-li error-red"><label
																class="error visibility"
																id="TrainingPartnerPermanentStateError">Select
																	State</label> <cf:errors path="TrainingPartnerPermanentState"
																	cssClass="error" /></li>
														</ul>
													</div>
													<cf:select path="TrainingPartnerPermanentState"
														class="form-control" onchange="getDistrict(this.value , 'TrainingPartnerPermanentDistrict');">
														<cf:option value="0" label="Select State" />
														<cf:options items="${stateList}" itemValue="stateId"
															itemLabel="stateName" />
													</cf:select>
												</div>



                            </div>
                            <!-- right side -->
                            <div class="col-md-6 col-xs-12">

                            		<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>District:</strong></li>
															<li class="style-li error-red"><label
																class="error visibility"
																id="TrainingPartnerPermanentDistrictError">Select
																	District</label> <cf:errors
																	path="TrainingPartnerPermanentDistrict"
																	cssClass="error" /></li>
														</ul>
													</div>
													<cf:select path="TrainingPartnerPermanentDistrict"
														class="form-control" onchange="getCity(this.value);">
														<cf:option value="0" label="Select District" />
													</cf:select>
												</div>

                             						<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Closest City:</strong></li>
															<li class="style-li error-red"><label
																class="error visibility"
																id="TrainingPartnerPermanentCityError">Select
																	City</label> <cf:errors path="TrainingPartnerPermanentCity"
																	cssClass="error" /></li>
														</ul>
													</div>
													<cf:select path="TrainingPartnerPermanentCity"
														class="form-control">
														<cf:option value="0" label="Select City" />
													</cf:select>
												</div>

                             					<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>PIN Code:</strong></li>

															<li class="style-li error-red"><label
																class="error visibility"
																id="TrainingPartnerPermanentPincodeError">Insert
																	Valid PIN Code</label> <cf:errors
																	path="TrainingPartnerPermanentPincode" cssClass="error" />
															</li>
														</ul>
													</div>
													<cf:input path="TrainingPartnerPermanentPincode"
														onkeypress="return AvoidSpace(event)" class="form-control"
														onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
														maxlength="6" placeholder="Pincode" />
												</div>

                              				 	<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Email:</strong></li>
															<li class="style-li error-red"><label
																class="error visibility"
																id="TrainingPartnerPermanentEmailError">Enter
																	Valid Email Id</label> <cf:errors
																	path="TrainingPartnerPermanentEmail" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="TrainingPartnerPermanentEmail"
														onkeypress="return AvoidSpace(event)" maxlength="50"
														class="form-control" placeholder="Email" />
												</div>

                               					<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Landline:</strong></li>
															<li class="style-li error-red"><label
																class="error visibility"
																id="TrainingPartnerPermanentLandLineError">Enter
																	Valid Landline Number</label> <cf:errors
																	path="TrainingPartnerPermanentLandLine" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="TrainingPartnerPermanentLandLine"
														onkeypress="return AvoidSpace(event)" class="form-control"
														  maxlength="10" placeholder="Landline" />
												</div>

                            </div>
                            <!-- personal information ends -->
                        </fieldset>
                    </div>
                    <!-- Training Center ends -->
                    <div class="row" style="height: 20px;"></div>
                    <!-- Training center head etails -->
                    <div class="personel-info">
                        <fieldset>
                            <legend>
                                Training Center Head Details</legend>
                            <!-- left side -->
                            <div class="col-md-6 col-xs-12">
                              
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>First
																	Name:(Training Center Head) </strong></li>
															<li class="style-li error-red"><label
																id="FirstNameError" class="error visibility">Enter
																	First Name</label> <cf:errors path="FirstName" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="FirstName" maxlength="50"
														onkeyup="allLetter(this.id,this.value);"
														class="form-control" placeholder="First Name" />
												</div>
                            					<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Middle
																	Name:(Training Center Head)</strong></li>
															<li class="style-li error-red"><cf:errors
																	path="MiddleName" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="MiddleName" maxlength="50"
														onkeyup="allLetter(this.id,this.value);"
														class="form-control" placeholder="Middle Name" />
												</div>

                             					 <div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Last
																	Name:(Training Center Head)</strong></li>
															<li class="style-li error-red"><label
																id="LastNameError" class="error visibility">Enter
																	Last Name</label> <cf:errors path="LastName" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="LastName" maxlength="50"
														onkeyup="allLetter(this.id,this.value);"
														class="form-control" placeholder="Last Name" />
												</div>

                            </div>
                            <!-- left side ends -->

                            <!-- right side -->
                            <div class="col-md-6 col-xs-12">
                               				
                             					 <div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Mobile:</strong></li>
															<li class="style-li error-red"><label
																class="error visibility"
																id="TrainingPartnerPermanentMobileError">Enter
																	Valid Mobile Number</label> <cf:errors
																	path="TrainingPartnerPermanentMobile" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="TrainingPartnerPermanentMobile"
														onkeypress="return AvoidSpace(event)" class="form-control"
														onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
														maxlength="10" placeholder="Mobile" />
												</div>
                              					<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>PAN:</strong></li>
															<li class="style-li error-red"><label id="PANError"
																class="error visibility">Enter Valid PAN Number</label>
																<cf:errors path="PAN" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="PAN" maxlength="10" class="form-control"
														onkeypress="return AvoidSpace(event)" placeholder="PAN"
														onKeyUP="this.value = this.value.toUpperCase();"
														onblur="pan_validate(this.id,this.value);" />
												</div>

                            </div>

                            <!-- right side ends -->

                        </fieldset>
                    </div>
                    <!-- training center head ends -->
                    <div class="row" style="height: 20px;"></div>
                    <!-- facilities Details  -->
                    <div class="personel-info">
                        <fieldset>
                            <legend>
                                Facilities</legend>
                            <!-- left side -->
                            <div class="col-md-6 col-xs-12">
                              	<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong>Seating
																	capacity Per session?</strong></li>
															<li class="style-li error-red"><label
																class="error visibility"
																id="SeatCapacityPerSessionError">Enter Seating
																	capacity Per session</label> <cf:errors
																	path="SeatCapacityPerSession" cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="SeatCapacityPerSession"
														onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
														maxlength="4" class="form-control"
														placeholder="No of seats" />
												</div>
                              					<div class="form-group">
													<label>Availability of TV/ Projector in training
														center ?</label> <br> <label class="radio-inline"> <cf:radiobutton
															path="AvailabiltyOfTVProjector" value="Y" checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<cf:radiobutton path="AvailabiltyOfTVProjector" value="N" />No
													</label>
												</div>
                              					<div class="form-group">
													<label>Availability of in-house trainers in food
														safety ?</label> <br> <label class="radio-inline"> <cf:radiobutton
															path="AvailabiltyOfInHouseTrainersInFoodSafety" value="Y"
															checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <cf:radiobutton
															path="AvailabiltyOfInHouseTrainersInFoodSafety" value="N" />No
													</label>
												</div>
                            </div>
                            <!-- left side ends -->
                            <!-- right side -->
                            <div class="col-md-6 col-xs-12">
                            
                            			
                            					<div class="form-group">
													<label>Facility of Electricity + Air-Conditioner ?</label> <br>
													 <label class="radio-inline"> <cf:radiobutton
															path="FacilityOfElectricityAndAirCondition" value="Y"
															checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <cf:radiobutton
															path="FacilityOfElectricityAndAirCondition" value="N" />No
													</label>
												</div>
													<div class="form-group">
													<label>Facility of Drinking Water?</label> <br>
													 <label class="radio-inline"> <cf:radiobutton
															path="FacilityOfDrinkingWater" value="Y"
															checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <cf:radiobutton
															path="FacilityOfDrinkingWater" value="N" />No
													</label>
												</div>
													<div class="form-group">
													<label>Facility of Washroom ?</label> <br>
													 <label class="radio-inline"> <cf:radiobutton
															path="FacilityOfWashroom" value="Y"
															checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <cf:radiobutton
															path="FacilityOfWashroom" value="N" />No
													</label>
												</div>
                          					  </div>
                            <!-- right side ends -->
                        </fieldset>
                    </div>
                    <!-- facilities ends -->
                    <!-- Basic courses -->
                    <div class="personel-info">
                        <h4>Courses wish to conduct ?</h4>
                    					<fieldset>
											<legend>Basic Courses</legend>
											<!-- left -->
											<div class="col-md-6 col-xs-12" style="width: 100%;">
												<div class="checkbox">
													<ct:if test="${not empty basicCourseList }">
														<ct:forEach var="listValue" items="${basicCourseList}">
															<ct:if test="${listValue[0] == 1}">
																<label> <input type="checkbox"
																	value="${listValue[2] }" name="BasicCourse"
																	id="${listValue[2] }" onclick=" return myBasic();">${listValue[1]}
																</label>
																<br>
															</ct:if>
														</ct:forEach>
													</ct:if>
													<cf:input path="BasicCourse1" value="" type="hidden" />
												</div>
											</div>
											<!-- right -->
											<div class="col-md-6 col-xs-12">
										</fieldset>
                    </div>
                    <!-- basic course -->
                    <!-- Advanced courses -->
                    <div class="personel-info">
                        <fieldset>
                            <legend>
                                <h3>Advanced Courses</h3></legend>
                            <!-- left -->
                         				<div class="col-md-6 col-xs-12" style="width: 100%;">
												<div class="checkbox">
													<ct:if test="${not empty basicCourseList }">
														<ct:forEach var="listValue" items="${basicCourseList}">
															<ct:if test="${listValue[0] == 2}">
																<label> <input type="checkbox"
																	value="${listValue[2] }" name="AdvanceCourse"
																	id="${listValue[2] }" onclick=" return myAdvance();">${listValue[1]}
																</label>
																<br>
															</ct:if>
														</ct:forEach>
													</ct:if>
													.
													<cf:input path="AdvanceCourse1" value="" type="hidden" />
												</div>
											</div>
                            <!-- right -->
                            <div class="col-md-6 col-xs-12"></div>
                        </fieldset>
                    </div>
                    <!-- advanced course -->
                    <!-- special courses -->
                    <div class="personel-info">
                        <fieldset>
                            <legend>
                                <h3>Special Courses</h3></legend>
                            <!-- left -->
                        		<div class="col-md-6 col-xs-12" style="width: 100%;">
												<div class="checkbox">
													<ct:if test="${not empty basicCourseList }">
														<ct:forEach var="listValue" items="${basicCourseList}">
															<ct:if test="${listValue[0] == 3}">
																<label> <input type="checkbox"
																	value="${listValue[2] }" name="SpecialCourse"
																	id="${listValue[2] }" onclick=" return mySpecial();">${listValue[1]}
																</label>
																<br>
															</ct:if>
														</ct:forEach>
													</ct:if>
													<cf:input path="SpecialCourse1" value="" type="hidden" />
												</div>
											</div>
                            <!-- right -->
                            <div class="col-md-6 col-xs-12"> </div>
                        </fieldset>
                    </div>
                    <!-- special course -->
                    <!-- captcha -->
                    <div class="col-xs-12">
                        	<div style="float: left; width: 99%;">

												<input type="text" id="txtCaptcha"
													style="background-image: url(1.jpg); text-align: center; border: none; width: 140px; margin-left: 8px; font-weight: bold; font-family: Modern"
													disabled="disabled" /> <input type="button"
													id="btnrefresh" value="Refresh" onclick="DrawCaptcha();" />
												<input type="text" id="txtInput" placeholder="Captcha"
													style="width: 140px;"/ >

											</div>
                     	<div style="float: left; width: 99%;">
											<input type="checkbox" id="check" style="margin-left: 1%;">
											<!-- <a href="#" target="_blank" class="terms-font-size"> -->
											I have read and understood the Terms & Conditions and the
											Privacy Policy of FSSAI.
											<!--  </a> -->
										</div>
                    </div>
                    <!-- buttons -->
                    <div class="col-md-4 hidden-xs"></div>
                    <div class="col-md-4 col-xs-12">
                        <a href="login.html">
                            <input type="submit" class="form-control login-btn"
											value="Register" onclick="return ValidCaptcha();">
                        </a>
                    </div>
                    <div class="col-md-4 hidden-xs"></div>
                    <!-- training center details ends -->

                </div>
								<div class="col-md-2 hidden-xs"></div>
							</div>

						</section>
						
					</div>
				</div>
			</div>
		</div>
	</section>
</cf:form>