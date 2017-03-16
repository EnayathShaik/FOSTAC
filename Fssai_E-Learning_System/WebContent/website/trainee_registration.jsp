
<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>


<html>
<!-- <head> -->
<?
 $myForm = $_POST['correspondenceDistrict'];
 ?>
 <script src="website/js/commonController.js"></script>
 <script type="text/javascript">
 	
 
function OnStart(){
	DrawCaptcha();
	if(document.getElementById('checkCorrespondence').checked == true){
		document.getElementById("residential1").style.display = "none";
		document.getElementById("residential2").style.display = "none";
	}
	if(document.getElementById('checkCompany').checked == true){
		document.getElementById("businessID2").style.display= 'none';
		document.getElementById("businessID3").style.display= 'none';
	}
}
window.onload = OnStart;
</script>

<script type='text/javascript'>
    function myFunction() {
    	window.document.myForm.imgcaptcha.src='';window.document.myForm.imgcaptcha.src='./Captcha.jpg?random='+new Date().getTime();
        return false;
    }
    function validateFields() {
        //alert("validate");

    /*     if (document.getElementById("userId").value == "") {
            document.getElementById('userId').style.borderColor = "red";
            document.getElementById("userIdError").style.display = 'block';
            document.getElementById("userId").focus();
            return false;
        } else {
            document.getElementById('userId').style.borderColor = "#ccc";
            document.getElementById("userIdError").style.display = 'none';
        } */
        if (document.getElementById("Title").value == 0) {
            document.getElementById('Title').style.borderColor = "red";
            document.getElementById("TitleError").style.display = 'block';
            document.getElementById("Title").focus();
            return false;
        } else {
            document.getElementById('Title').style.borderColor = "#ccc";
            document.getElementById("TitleError").style.display = 'none';
        }
        var x = document.getElementById("AadharNumber").value;
        if (x == "" || x.length < 12) {
            document.getElementById('AadharNumber').style.borderColor = "red";
            document.getElementById("AadharNumberError").style.display = 'block';
            document.getElementById("AadharNumber").focus();
            return false;
        } else {
            document.getElementById('AadharNumber').style.borderColor = "#ccc";
            document.getElementById("AadharNumberError").style.display = 'none';
        }

        if (document.getElementById("traineeFirstName").value == "") {
            //alert("IN Fname");d
            document.getElementById('traineeFirstName').style.borderColor = "red";
            document.getElementById("firstNameError").style.display = 'block';
            document.getElementById("traineeFirstName").focus();
            return false;
        } else {
            document.getElementById('traineeFirstName').style.borderColor = "#ccc";
            document.getElementById("firstNameError").style.display = 'none';
        }

        if (document.getElementById("dateP").value == "") {
            //alert("IN Fname");
            document.getElementById('dateP').style.borderColor = "red";
            document.getElementById("dobError").style.display = 'block';
            document.getElementById("dateP").focus();
            return false;
        } else {
            document.getElementById('dateP').style.borderColor = "#ccc";
            document.getElementById("dobError").style.display = 'none';
        }


        if (document.getElementById("LastName").value == "") {
            //alert("IN Lname");
            document.getElementById('LastName').style.borderColor = "red";
            document.getElementById("LastNameError").style.display = 'block';
            document.getElementById("LastName").focus();
            return false;
        } else {
            document.getElementById('LastName').style.borderColor = "#ccc";
            document.getElementById("LastNameError").style.display = 'none';
        }


        if (document.getElementById("FatherName").value == "") {
            //alert("IN Fname");
            document.getElementById('FatherName').style.borderColor = "red";
            document.getElementById("FatherNameError").style.display = 'block';
            document.getElementById("FatherName").focus();
            return false;
        } else {
            document.getElementById('FatherName').style.borderColor = "#ccc";
            document.getElementById("FatherNameError").style.display = 'none';
        }




        if (document.getElementById("correspondenceAddress1").value == "") {
            //alert("IN Fname");
            document.getElementById('correspondenceAddress1').style.borderColor = "red";
            document.getElementById("correspondenceAddress1Error").style.display = 'block';
            document.getElementById("correspondenceAddress1").focus();
            return false;
        } else {
            document.getElementById('correspondenceAddress1').style.borderColor = "#ccc";
            document.getElementById("correspondenceAddress1Error").style.display = 'none';
        }

        if (document.getElementById("correspondenceAddress2").value == "") {
            //alert("IN Fname");
            document.getElementById('correspondenceAddress2').style.borderColor = "red";
            document.getElementById("correspondenceAddress2Error").style.display = 'block';
            document.getElementById("correspondenceAddress2").focus();
            return false;
        } else {
            document.getElementById('correspondenceAddress2').style.borderColor = "#ccc";
            document.getElementById("correspondenceAddress2Error").style.display = 'none';
        }

        if (document.getElementById("correspondenceState").selectedIndex == 0) {
            //alert("IN Fname");
            document.getElementById('correspondenceState').style.borderColor = "red";
            document.getElementById("correspondenceStateError").style.display = 'block';
            document.getElementById("correspondenceState").focus();
            return false;
        } else {
            document.getElementById('correspondenceState').style.borderColor = "#ccc";
            document.getElementById("correspondenceStateError").style.display = 'none';
        }

        var x = document.getElementById('Email').value;
        if (x != '') {
            var atpos = x.indexOf("@");
            var dotpos = x.lastIndexOf(".");
            if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
                //  //alert("Not a valid e-mail address");
                document.getElementById('Email').style.borderColor = "red";
                document.getElementById("EmailError").style.display = 'block';
                document.getElementById("Email").focus();
                return false;
            }
        } else {
            document.getElementById('Email').style.borderColor = "#ccc";
            document.getElementById("EmailError").style.display = 'none';
        }

        if (document.getElementById("correspondenceDistrict").selectedIndex == 0) {
            //alert("IN Fname");
            document.getElementById('correspondenceDistrict').style.borderColor = "red";
            document.getElementById("correspondenceDistrictError").style.display = 'block';
            document.getElementById("correspondenceDistrict").focus();
            return false;
        } else {
            document.getElementById('correspondenceDistrict').style.borderColor = "#ccc";
            document.getElementById("correspondenceDistrictError").style.display = 'none';
        }

        if (document.getElementById("correspondenceCity").selectedIndex == 0) {
            //alert("IN Fname");
            document.getElementById('correspondenceCity').style.borderColor = "red";
            document.getElementById("correspondenceCityError").style.display = 'block';
            document.getElementById("correspondenceCity").focus();
            return false;
        } else {
            document.getElementById('correspondenceCity').style.borderColor = "#ccc";
            document.getElementById("correspondenceCityError").style.display = 'none';
        }

        var x = document.getElementById("correspondencePincode").value;
        if (x.length < 6) {
            document.getElementById('correspondencePincode').style.borderColor = "red";
            document.getElementById("correspondencePincodeError").style.display = 'block';
            document.getElementById("correspondencePincode").focus();
            return false;
        } else {
            document.getElementById('correspondencePincode').style.borderColor = "#ccc";
            document.getElementById("correspondencePincodeError").style.display = 'none';
        }

        var x = document.getElementById("Mobile").value;
        if (x != '') {
            if (x.length < 10) {
                document.getElementById('Mobile').style.borderColor = "red";
                document.getElementById("MobileError").style.display = 'block';
                document.getElementById("Mobile").focus();
                return false;
            } else {
                document.getElementById('Mobile').style.borderColor = "#ccc";
                document.getElementById("MobileError").style.display = 'none';
            }

            if (document.getElementById('checkCorrespondence').checked == false) {

            
                if (document.getElementById("ResidentialAddressLine1").value == "") {
                    document.getElementById('ResidentialAddressLine1').style.borderColor = "red";
                    document.getElementById("ResidentialAddressLine1Error").style.display = 'block';
                    document.getElementById("ResidentialAddressLine1").focus();
                    return false;
                } else {
                    document.getElementById('ResidentialAddressLine2').style.borderColor = "#ccc";
                    document.getElementById("ResidentialAddressLine2Error").style.display = 'none';
                }
                if (document.getElementById("ResidentialAddressLine2").value == "") {
                    document.getElementById('ResidentialAddressLine2').style.borderColor = "red";
                    document.getElementById("ResidentialAddressLine2Error").style.display = 'block';
                    document.getElementById("ResidentialAddressLine2").focus();
                    return false;
                } else {
                    document.getElementById('ResidentialAddressLine2').style.borderColor = "#ccc";
                    document.getElementById("ResidentialAddressLine2Error").style.display = 'none';
                }
                if (document.getElementById("resState").selectedIndex == 0) {
                    document.getElementById('resState').style.borderColor = "red";
                    document.getElementById("resStateError").style.display = 'block';
                    document.getElementById("resState").focus();
                    return false;
                } else {
                    document.getElementById('resState').style.borderColor = "#ccc";
                    document.getElementById("resStateError").style.display = 'none';
                }

                if (document.getElementById("residentialDistrict").selectedIndex == 0) {
                    document.getElementById('residentialDistrict').style.borderColor = "red";
                    document.getElementById("residentialDistrictError").style.display = 'block';
                    document.getElementById("residentialDistrict").focus();
                    return false;
                } else {
                    document.getElementById('residentialDistrict').style.borderColor = "#ccc";
                    document.getElementById("residentialDistrictError").style.display = 'none';
                }


                if (document.getElementById("resCity").selectedIndex == 0) {
                    document.getElementById('resCity').style.borderColor = "red";
                    document.getElementById("resCityError").style.display = 'block';
                    document.getElementById("resCity").focus();
                    return false;
                } else {
                    document.getElementById('resCity').style.borderColor = "#ccc";
                    document.getElementById("resCityError").style.display = 'none';
                }
                var x = document.getElementById("resPincode").value;

                if (x.length < 6) {
                    document.getElementById('resPincode').style.borderColor = "red";
                    document.getElementById("resPincodeError").style.display = 'block';
                    document.getElementById("resPincode").focus();
                    return false;
                } else {
                    document.getElementById('resPincode').style.borderColor = "#ccc";
                    document.getElementById("resPincode").style.display = 'none';
                }
                
            }

        	
  
                if (document.getElementById("KindOfBusiness").selectedIndex == 0) {
           
                    document.getElementById('KindOfBusiness').style.borderColor = "red";
                    document.getElementById("KindOfBusinessError").style.display = 'block';
                    document.getElementById("KindOfBusiness").focus();
                    return false;
            	    }  else if (document.getElementById("KindOfBusiness").value == 6) {
                    document.getElementById('KindOfBusiness').style.borderColor = "#ccc";
                    document.getElementById("KindOfBusinessError").style.display = 'none';
                   
                }  else {
                	
                    document.getElementById('KindOfBusiness').style.borderColor = "#ccc";
                    document.getElementById("KindOfBusinessError").style.display = 'none';
                    if (document.getElementById("CompanyName").value == "") {
                        document.getElementById('CompanyName').style.borderColor = "red";
                        document.getElementById("CompanyNameError").style.display = 'block';
                        document.getElementById("CompanyName").focus();
                        return false;
                    } else {
                        document.getElementById('CompanyName').style.borderColor = "#ccc";
                        document.getElementById("CompanyNameError").style.display = 'none';
                    }

                    
                    if (document.getElementById("Designation").selectedIndex == 0) {
                        document.getElementById('Designation').style.borderColor = "red";
                        document.getElementById("DesignationError").style.display = 'block';
                        document.getElementById("Designation").focus();
                        return false;
                    } else {
                        document.getElementById('Designation').style.borderColor = "#ccc";
                        document.getElementById("DesignationError").style.display = 'none';
                    }

                    alert(document.getElementById("registrationNo").value )
                    if (document.getElementById("registrationNo").value == "") {
                        document.getElementById('registrationNo').style.borderColor = "red";
                        document.getElementById("registrationNoError").style.display = 'block';
                        document.getElementById("registrationNo").focus();
                        return false;
                    } else {
                    	
                    
                        document.getElementById('registrationNo').style.borderColor = "#ccc";
                        document.getElementById("registrationNoError").style.display = 'none';
                        if (document.getElementById('checkCompany').checked == false) {

                            if (document.getElementById("BusinessAddressLine1").value == "") {
                                document.getElementById('BusinessAddressLine1').style.borderColor = "red";
                                document.getElementById("BusinessAddressLine1Error").style.display = 'block';
                                document.getElementById("BusinessAddressLine1").focus();
                                return false;
                            } else {
                                document.getElementById('BusinessAddressLine1').style.borderColor = "#ccc";
                                document.getElementById("BusinessAddressLine1Error").style.display = 'none';
                            }
                            if (document.getElementById("BusinessAddressLine2").value == "") {
                                document.getElementById('BusinessAddressLine2').style.borderColor = "red";
                                document.getElementById("BusinessAddressLine2Error").style.display = 'block';
                                document.getElementById("BusinessAddressLine2").focus();
                                return false;
                            } else {
                                document.getElementById('BusinessAddressLine2').style.borderColor = "#ccc";
                                document.getElementById("BusinessAddressLine2Error").style.display = 'none';
                            }



                            if (document.getElementById("bussState").selectedIndex == 0) {
                                document.getElementById('bussState').style.borderColor = "red";
                                document.getElementById("bussStateError").style.display = 'block';
                                document.getElementById("bussState").focus();
                                return false;
                            } else {
                                document.getElementById('bussState').style.borderColor = "#ccc";
                                document.getElementById("bussStateError").style.display = 'none';
                            }

                            if (document.getElementById("bussDistrict").selectedIndex == 0) {
                                document.getElementById('bussDistrict').style.borderColor = "red";
                                document.getElementById("bussDistrictError").style.display = 'block';
                                document.getElementById("bussDistrict").focus();
                                return false;
                            } else {
                                document.getElementById('bussDistrict').style.borderColor = "#ccc";
                                document.getElementById("bussDistrictError").style.display = 'none';
                            }


                            if (document.getElementById("bussCity").selectedIndex == 0) {
                                document.getElementById('bussCity').style.borderColor = "red";
                                document.getElementById("bussCityError").style.display = 'block';
                                document.getElementById("bussCity").focus();
                                return false;
                            } else {
                                document.getElementById('bussCity').style.borderColor = "#ccc";
                                document.getElementById("bussCityError").style.display = 'none';
                            }
                            var x = document.getElementById("bussPincode").value;
                            if (x.length < 6) {
                                document.getElementById('bussPincode').style.borderColor = "red";
                                document.getElementById("bussPincodeError").style.display = 'block';
                                document.getElementById("bussPincode").focus();
                                return false;
                            } else {
                                document.getElementById('bussPincode').style.borderColor = "#ccc";
                                document.getElementById("bussPincodeError").style.display = 'none';
                            }

                        }
                    }
                }
          
        }

    }
</script>
<style>
.error {
	color: red;
}
</style>

<script>
function DrawCaptcha()
{
    var a = Math.ceil(Math.random() * 7)+ '';
    var b = Math.ceil(Math.random() * 7)+ '';       
    var c = Math.ceil(Math.random() * 7)+ '';  
    var d = Math.ceil(Math.random() * 7)+ '';  
    var e = Math.ceil(Math.random() * 7)+ '';  
    var f = Math.ceil(Math.random() * 7)+ '';  
    var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e + ' '+ f ;
    document.getElementById("txtCaptcha").value = code
}



// Validate the Entered input aganist the generated security code function   
function ValidCaptcha(){
	var status = true;
	var message = "";
	var kindOfBuss = removeSpaces(document.getElementById('KindOfBusiness').value);
	if(kindOfBuss != 6){
		var companyName = removeSpaces(document.getElementById('CompanyName').value);
		var designation = removeSpaces(document.getElementById('Designation').value);
		var bussAdd1 = removeSpaces(document.getElementById('BusinessAddressLine1').value);
		var district = removeSpaces(document.getElementById('bussDistrict').value);
		var bussAdd2 = removeSpaces(document.getElementById('BusinessAddressLine2').value);
		var city = removeSpaces(document.getElementById('bussCity').value);
		var state = removeSpaces(document.getElementById('bussState').value);
		var pincode = removeSpaces(document.getElementById('bussPincode').value);
		
		if(kindOfBuss != 7){
			if(companyName == "" || companyName.length <= 0){
				message = 'Please Enter Company Name.';
				  status = false;
				}
				else if(designation == 0 || designation == "" || designation.length <= 0){
					message ='Please Select Designation.';
					  status = false;
				}
		}
		
		if(status && document.getElementById('checkCompany').checked==false){
			if(bussAdd1 == "" || bussAdd1.length <= 0){
				message ='Please Enter Business Address line 1.';
				  status = false;
				}
			else if( state == 0 || state == "" || state.length <= 0){
					message = 'Please Select State.';
					status = false;
				}
			else if(district == 0 || district == "" || district.length <= 0){
					message = 'Please Select District';
					status = false;
				}
			else if(bussAdd2 == "" || bussAdd2.length <= 0){
					message = 'Please Enter Buss Add2.';
					status = false;
				}
			else if(city == 0 || city == "" || city.length <= 0){
					message = 'Please Select City.' ;
				 	status = false;
				}
			
			else if(pincode == "" || pincode.length <= 0){
					message = 'Please Enter Pincode';
				  	status = false;
				}
			
		}
		
		if(!status){
			alert(message);
			return false;
		}
		
	}
	
	var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
    var str2 = removeSpaces(document.getElementById('txtInput').value);
    
    
    if (str1 == str2) 
	{ 
    	return checkagree();
    	return true;
	} else{      
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
function AvoidSpace(event) {
    var k = event ? event.which : window.event.keyCode;
    if (k == 32) return false;
}

function my11(str) {
  var xhttp;
  if (str == "") {
    document.getElementById("resState").innerHTML = "";
    return;
  }
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("resCity").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "loadCity.fssaii?q="+str, true);
  xhttp.send();
}
</script>


<script language="javascript" type="text/javascript">
function myBusiness() {
    var x = document.getElementById("KindOfBusiness").value;
	if($('[id*=KindOfBusiness] option:selected').text()=='Not in business'){
    	document.getElementById("desiNCm").style.display= 'none';
    	document.getElementById("businessID1").style.display= 'none';
    	document.getElementById("businessID2").style.display= 'none';
    	document.getElementById("businessID3").style.display= 'none';
   }else{
	document.getElementById("desiNCm").style.display= 'block';
	document.getElementById("businessID1").style.display= 'block';
	document.getElementById("businessID2").style.display= 'block';
	document.getElementById("businessID3").style.display= 'block';
	document.getElementById("CompanyName").value='';
	$('#Designation option').remove();
	$('#Designation').append('<option value="0">Select</option><option value="Food Handler">Food Handler</option><option value="Food Safety Supervisior">Food Safety Supervisior</option>		<option value="Food Safety Manager">Food Safety Manager</option><option value="Other">Other</option>');
		
	}
}
function myCorrespondence() {
	//alert('ll');
	var x = document.getElementById('checkCorrespondence').checked;
    residential1.style.display = checkCorrespondence.checked ? "none" : "block";
    residential2.style.display = checkCorrespondence.checked ? "none" : "block";
    
    if(x == true){
    	document.getElementById('ResidentialAddressLine1').value= document.getElementById('correspondenceAddress1').value;
    	document.getElementById('ResidentialAddressLine2').value= document.getElementById('correspondenceAddress2').value;
    	document.getElementById('resPincode').value= document.getElementById('correspondencePincode').value;
    	  	
    }
    if(x == false){
    	document.getElementById('ResidentialAddressLine1').value="";
    	document.getElementById('ResidentialAddressLine2').value= "";
    	document.getElementById('resPincode').value= "";
    	
    }
    
    
    
    
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

</script>
<script>
    function myCompany(val) {
    	businessID3.style.display = checkCompany.checked ? "none" : "block";
    	businessID2.style.display = checkCompany.checked ? "none" : "block";
    	var x = document.getElementById('checkCompany').checked;
        var s = $("#correspondenceState").val();
        var d = $("#correspondenceDistrict").val();
        var c = $("#correspondenceCity").val();
        if(x == true){
        	document.getElementById('BusinessAddressLine1').value= document.getElementById('correspondenceAddress1').value;
        	document.getElementById('BusinessAddressLine2').value= document.getElementById('correspondenceAddress2').value;
        	document.getElementById('bussPincode').value= document.getElementById('correspondencePincode').value;
        	document.getElementById('bussState').value=s;
        	document.getElementById('bussDistrict').value=d;
        	document.getElementById('bussCity').value=c;
        	
        }
        if(x == false){
        	document.getElementById('BusinessAddressLine1').value="";
        	document.getElementById('BusinessAddressLine2').value= "";
        	document.getElementById('bussPincode').value= "";
        	$("#bussState").prop('selectedIndex',0);
        	$("#bussDistrict").prop('selectedIndex',0);
        	$("#bussCity").prop('selectedIndex',0);
        }
 }
 
     
</script>
<!-- <head> -->
<body>

	<cf:form action="registerTrainee.fssai" name="myForm" method="POST"
		commandName="registrationFormTrainee"
		onsubmit="return validateFields();">

		<div class="row">
			<div class="col-md-2 hidden-xs"></div>
			<div class="col-md-8  col-xs-12">
				<h3 class="text-capitalize heading-3-padding">Trainee
					Registration Form</h3>
				<!-- personel info Start -->
				<div class="personel-info">
					<fieldset>
						<legend>Personal Information</legend>
						<!-- left side -->
						<div class="col-md-6 col-xs-12">

							<div class="form-group" style="display:none">
								<div>
									<ul class="lab-no" >
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.UserId" /></strong></li>
										<li class="style-li error-red"><span id="name_status">
										</span><span id="err"> </span> <label id=userIdError
											class="error visibility">* Enter your UserId </label> <cf:errors
												path="userId" cssClass="error" />${created }</li>
									</ul>
								</div>
								<cf:input path="userId" maxlength="20" type="hidden"
									class="form-control" readonly="true" value="${userId}"
									placeholder="User Id" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.AadharNumber" /></strong></li>
										<li class="style-li error-red"><span id="aadhar_status"><label
												id=AadharNumberError class="error visibility">*
													Enter your aadharNumber </label> <cf:errors path="AadharNumber"
													cssClass="error" /></li>
									</ul>
								</div>
								<%-- <cf:input path="AadharNumber" class="form-control"
									maxlength="12" placeholder="Aadhar Number"
									onblur="ck_aadhar('personalinformationtrainee');" value="0"
									onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" /> --%>
							<input type="text" id="AadharNumberShow" class="form-control" placeholder="Aadhar Number" value="" disabled="true"  />
							<cf:input type="hidden" path="AadharNumber" class="form-control" placeholder="Aadhar Number" value="" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.DOB" /></strong></li>
										<li class="style-li error-red"><label id="dobError"
											class="error visibility">* select your date </label> <cf:errors
												path="dob" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="dob" type="text" id="dateP" class="form-control"
									placeholder="DOB" readonly="true" />
							</div>
							
							
								<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.Caste" /></strong></li>
										<li class="style-li error-red"><label id="casteError"
											class="error visibility">* select your Category </label> <cf:errors
												path="caste" cssClass="error" /></li>
									</ul>
								</div>
									<cf:select path="caste" class="form-control">
									<cf:option value="0" label="Select Category" />
									<cf:options items="${casteList}"  />
								</cf:select>
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.Gender" /></strong></li>
										<li class="style-li error-red"><cf:errors path="gender"
												cssClass="error" /></li>
									</ul>
								</div>
								<label class="radio-inline"> <cf:radiobutton
										path="gender" value="M" checked="true" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<cf:radiobutton path="gender" value="F" />Female
									</td>
								</label>
							</div>
						</div>



						<!-- right side -->
						<div class="col-md-6 col-xs-12">
							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.Title" /></strong></li>
										<li class="style-li error-red"><label id="TitleError"
											class="error visibility">* enter your Title</label> <cf:errors
												path="Title" cssClass="error" /></li>
									</ul>
								</div>
								
								<cf:select path="Title" class="form-control">
									<cf:option value="0" label="Select Title" />
									<cf:options items="${titleList}" itemValue="titleId"
										itemLabel="titleName" />
								</cf:select>
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.FirstName" /></strong></li>
										<li class="style-li error-red"><label id="firstNameError"
											class="error visibility">* enter your firstname </label> <cf:errors
												path="firstName" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input id="traineeFirstName"
									onkeyup="allLetter(this.id,this.value);" path="firstName"
									maxlength="50" class="form-control" placeholder="First Name" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.MiddleName" /></strong></li>
										<li class="style-li error-red"><label
											id="MiddleNameError" class="error visibility">* enter
												your middlename </label> <cf:errors path="MiddleName"
												cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="MiddleName"
									onkeyup="allLetter(this.id,this.value);" maxlength="50"
									class="form-control" name="MiddleName"
									placeholder="Middle Name" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.LastName" /></strong></li>
										<li class="style-li error-red"><label id="LastNameError"
											class="error visibility">* enter your last name </label> <cf:errors
												path="LastName" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="LastName" id="LastName"
									onkeyup="allLetter(this.id,this.value);" maxlength="50"
									class="form-control" placeholder="Last Name" />
							</div>
							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.fatherName" /></strong></li>
										<li class="style-li error-red"><label
											id="FatherNameError" class="error visibility">* enter
												your father name </label> <cf:errors path="FatherName"
												cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="FatherName"
									onkeyup="allLetter(this.id,this.value);" maxlength="100"
									class="form-control" placeholder="Father Name" />
							</div>
						</div>
					</fieldset>
				</div>
				<!-- personel info End-->
				<div class="row" style="height: 20px;"></div>


				<!-- Contact details Start -->
				<div class="personel-info">
					<fieldset>
						<legend>Correspondence Address </legend>

						<!--Left side-->

						<div class="col-md-6 col-xs-12" id="correspondence1">

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.correspondenceAddress1" /></strong></li>
										<li class="style-li error-red"><label
											id="correspondenceAddress1Error" class="error visibility">*
												enter your correspondence address </label> <cf:errors
												path="correspondenceAddress1" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="correspondenceAddress1" maxlength="100"
									class="form-control" placeholder="Address " />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.correspondenceAddress2" /></strong></li>
										<li class="style-li error-red"><label
											id="correspondenceAddress2Error" class="error visibility">*
												enter your correspondence address </label> <cf:errors
												path="correspondenceAddress2" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="correspondenceAddress2" maxlength="100"
									class="form-control" placeholder="Address 2" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.correspondenceState" /></strong></li>
										<li class="style-li error-red"><label
											id="correspondenceStateError" class="error visibility">*
												select your state </label> <cf:errors path="correspondenceState"
												cssClass="error" /></li>
									</ul>
								</div>
								<cf:select path="correspondenceState" class="form-control"
									onchange="getDistrict(this.value, 'correspondenceDistrict');">
									<cf:option value="0" label="Select State" />
									<cf:options items="${stateList}" itemValue="stateId"
										itemLabel="stateName" />
								</cf:select>
							</div>
							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.Email" /></strong></li>
										<li class="style-li error-red"><label id="EmailError"
											class="error visibility">* Not a valid e-mail address</label>
											<cf:errors path="Email" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="Email" class="form-control" placeholder="Email" />
							</div>


						</div>
						<!--Left side-->
						<!--Right side-->
						<div class="col-md-6 col-xs-12" id="correspondence2">
							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.District" /></strong></li>
										<li class="style-li error-red"><label
											id="correspondenceDistrictError" class="error visibility">*
												select your correspondence district </label> <cf:errors
												path="correspondenceDistrict" cssClass="error" /></li>
									</ul>
								</div>
								<cf:select path="correspondenceDistrict" class="form-control"
									onchange="getCity(this.value , 'correspondenceCity');">
									<cf:option value="0" label="Select District" />
									<%-- <cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName" /> --%>
								</cf:select>
							</div>
							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.correspondenceCity" /></strong></li>
										<li class="style-li error-red"><label
											id="correspondenceCityError" class="error visibility">*
												select your correspondence city</label> <cf:errors
												path="correspondenceCity" cssClass="error" /></li>
									</ul>
								</div>
								<cf:select path="correspondenceCity" class="form-control"
									onchange="return myBusiness()">
									<cf:option value="0" label="Select City" />
									<cf:options items="${cityList}" itemValue="cityId"
										itemLabel="cityName" />
								</cf:select>
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.correspondencePincode" /></strong></li>
										<li class="style-li error-red"><label
											id="correspondencePincodeError" class="error visibility">*
												enter your correspondence pincode </label> <cf:errors
												path="correspondencePincode" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="correspondencePincode" maxlength="6"
									onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
									placeholder="Pincode" class="form-control" />
							</div>
							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.Mobile" /></strong></li>
										<li class="style-li error-red"><label id="MobileError"
											class="error visibility">* enter your correct mobile
												number </label> <cf:errors path="Mobile" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="Mobile"
									onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
									placeholder="Mobile Number" class="form-control" type="text"
									value="" maxlength="10" />
							</div>

							<!--Right side-->
						</div>
					</fieldset>
				</div>





				<!-- Contact details End-->
				<div class="row" style="height: 20px;"></div>

				<div class="personel-info">
					<fieldset>
						<legend>Permanent Address </legend>

						<div class="col-md-12 col-sm-12 col-x-sm-12">
							<cf:checkbox id="checkCorrespondence" path="checkCorrespondence"
								onclick="myCorrespondence(this)" />
							<label class="error">Is your permanent address same as
								correspondence address.</label>
						</div>

						<!--Left side-->
						<div class="col-md-6 col-xs-12" id="residential1">

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.ResidentialAddressLine1" /></strong></li>
										<li class="style-li error-red"><label
											id="ResidentialAddressLine1Error" class="error visibility">*
												enter your residentialAddress1 </label> <cf:errors
												path="ResidentialAddressLine1" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="ResidentialAddressLine1" maxlength="100"
									placeholder="Residential Address Line 2" class="form-control" />
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong></strong><cs:message
													code="lbl.Trainee.ResidentialAddressLine2" /></strong></li>
										<li class="style-li error-red"><label
												id="ResidentialAddressLine2Error" class="error visibility">*
													enter your residentialAddress1 </label> <cf:errors
													path="ResidentialAddressLine2" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="ResidentialAddressLine2" maxlength="100"
									placeholder="Residential Address Line 2" class="form-control" />
							</div>




							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.State" /></strong></li>
										<li class="style-li error-red"><label id="resStateError"
											class="error visibility">* select your state </label> <cf:errors
												path="resState" cssClass="error" /></li>
									</ul>
								</div>
								<cf:select path="resState" class="form-control state"
									onchange="getDistrict(this.value , 'residentialDistrict');">
									<cf:option value="0" label="Select State" />
									<cf:options items="${stateList}" itemValue="stateId"
										itemLabel="stateName" />
								</cf:select>
							</div>
							<table>
								<tr>
									<td id="response">
										<!--Response will be inserted here-->
									</td>
								</tr>
							</table>

						</div>
						<!--Left side-->
						<!--Right side-->
						<div class="col-md-6 col-xs-12" id="residential2">
							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.District" /></strong></li>
										<li class="style-li error-red"><label
											id="residentialDistrictError" class="error visibility">*
												select your district </label> <cf:errors path="residentialDistrict"
												cssClass="error" /></li>
									</ul>
								</div>
								<cf:select path="residentialDistrict" class="form-control"
									onchange="getCity(this.value , 'resCity');">
									<cf:option value="0" label="Select District" />
									<cf:options items="${districtList}" itemValue="districtId"
										itemLabel="districtName" />
								</cf:select>
							</div>


							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
														code="lbl.Trainee.City" /></strong></li>
										<li class="style-li error-red"><label id="resCityError"
											class="error visibility">* select your city </label> <cf:errors
												path="resCity" cssClass="error" /></li>
									</ul>
								</div>
								<cf:select path="resCity" class="form-control">
									<cf:option value="0" label="Select City" />
									<cf:options items="${cityList}" itemValue="cityId"
										itemLabel="cityName" />
								</cf:select>
							</div>


							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.Pincode" /></strong></li>
										<li class="style-li error-red"><label
											id="resPincodeError" class="error visibility">* enter
												your pincode</label> <cf:errors path="resPincode" cssClass="error" /></li>
									</ul>
								</div>
								<input id="resPincode" name="resPincode"
									onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"
									placeholder="Pincode" class="form-control" type="text" value=""
									maxlength="6">
							</div>

							<!--Right side-->
						</div>
					</fieldset>
				</div>

				<!-- Business address Start -->
				<div class="personel-info ">
					<fieldset>
						<legend>Business Details</legend>

						<div class="col-xs-12">
							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.KindOfBusiness" /></strong></li>
										<li class="style-li error-red"><label
											id="KindOfBusinessError" class="error visibility">*
												select your kindofbussiness </label> <cf:errors
												path="KindOfBusiness" cssClass="error" /></li>
									</ul>
								</div>
								<cf:select path="KindOfBusiness" class="form-control"
									onchange="return myBusiness()">
									<cf:option value="0" label="Select Business" />
									<cf:options items="${kindOfBusinessList}"
										itemValue="kindOfBusinessId" itemLabel="kindOfBusinessName" />
								</cf:select>
								<div id="desiNCm">
									<div>


										<div class="col-xs-12" style="padding: 0;">

											<!-- left side -->
											<div class="col-md-6 col-xs-12" style="padding-left: 0;">
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.CompanyName" /></strong></li>
															<li class="style-li error-red"><label
																id="CompanyNameError" class="error visibility">*
																	enter your CompanyName</label> <cf:errors path="CompanyName"
																	cssClass="error" /></li>
														</ul>
													</div>
													<cf:input path="CompanyName" maxlength="50"
														class="form-control" placeholder="Company Name" />
												</div>
											</div>

											<!-- right side -->
											<div class="col-md-6 col-xs-12" style="padding-right: 0;">
												<div class="form-group">
													<div>
														<ul class="lab-no">
															<li class="style-li"><strong><cs:message
																		code="lbl.Trainee.Designation" /><a href="#myModal"
																data-toggle="modal" data-target="#myModal">Do you
																	want?</a><strong></li>
															<li class="style-li error-red"><label
																id="DesignationError" class="error visibility">*
																	enter your designation </label> <cf:errors path="Designation"
																	cssClass="error" /></li>
														</ul>
													</div>
													<cf:select path="Designation" class="form-control">
														<cf:option value="0" label="Select" />
														<cf:option value="Food Handler" label="Food Handler" />
														<cf:option value="Food Safety Supervisior"
															label="Food Safety Supervisior" />
														<cf:option value="Food Safety Manager"
															label="Food Safety Manager" />
														<cf:option value="Other" label="Other" />
													</cf:select>
												</div>
											</div>

										</div>




										<div class="form-group">
											<div class="modal fade" id="myModal" role="dialog">
												<div class="modal-dialog">
													<!-- Modal content-->
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal">&times;</button>
															<h4 class="modal-title">Designation</h4>
														</div>
														<div class="modal-body">
															<table align="center" width="200" border="0"
																class="table table-bordered table-responsive table-hover table-striped">
																<thead>
																	<th bgcolor="#0033CC" style="color: #fff;">Designation</th>
																	<th bgcolor="#0033CC" style="color: #fff;">Example</th>
																</thead>
																<tr>
																	<td>Food Handler</td>
																	<td>Example</td>
																</tr>
																<tr>
																	<td>Food Safety Supervisior</td>
																	<td>Example</td>
																</tr>
																<tr>
																	<td>Food Safety Manager</td>
																	<td>Example</td>
																</tr>
																<tr>
																	<td>Other</td>
																	<td>Example</td>
																</tr>
															</table>
														</div>
														<div class="modal-footer">
															<button type="button" class="btn login-btn"
																data-dismiss="modal">Close</button>
														</div>
													</div>
												</div>
											</div>
										</div>

									</div>
									<div>
										<div class="form-group">
											<div>
												<ul class="lab-no">
													<li class="style-li"><strong>Registration/Licence No.</strong></li>
													<li class="style-li error-red"><label
														id="registrationNoError" class="error visibility">*
															enter your registrationNumber </label> <cf:errors
															path="registrationNo" cssClass="error" /></li>
												</ul>
											</div>
											<cf:input path="registrationNo" maxlength="50"
												class="form-control"
												placeholder="Registration/Licence Number" />
										</div>
									</div>
								</div>
							</div>
						</div>


						<!--Left side-->

						<div class="col-md-12 col-xs-12 " id="businessID1">
							<cf:checkbox path="checkCompany" id="checkCompany"
								onclick="myCompany(this.value)" />
							<label class="error">Is your company address same as
								correspondence address.</label>
						</div>
						<div class="col-md-6 col-xs-12" id="businessID2">

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.BusinessAddressLine1" /></strong></li>
										<li class="style-li error-red"><label
											id="BusinessAddressLine1Error" class="error visibility">*
												enter your BusinessAddressLine1 </label> <cf:errors
												path="BusinessAddressLine1" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="BusinessAddressLine1" maxlength="100"
									class="form-control" placeholder="Business Address Line 1" />
							</div>



							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.BusinessAddressLine2" /></strong></li>
										<li class="style-li error-red"><label
											id="BusinessAddressLine2Error" class="error visibility">*
												enter your BusinessAddressLine2 </label> <cf:errors
												path="BusinessAddressLine2" cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="BusinessAddressLine2" maxlength="100"
									class="form-control" placeholder="Business Address Line 2" />
							</div>



							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.State" /></strong></li>
										<li class="style-li error-red"><label id="bussStateError"
											class="error visibility">* enter your bussinessState
										</label> <cf:errors path="bussState" cssClass="error" /></li>
									</ul>
								</div>
								<cf:select path="bussState" class="form-control"
									onchange="getDistrict(this.value , 'bussDistrict');">
									<cf:option value="0" label="Select State" />
									<cf:options items="${stateList}" itemValue="stateId"
										itemLabel="StateName" />
								</cf:select>
							</div>




						</div>
						<!--Left side-->
						<!--Right side-->
						<div class="col-md-6 col-xs-12" id="businessID3">

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.District" /><strong></li>
										<li class="style-li error-red"><label
											id="bussDistrictError" class="error visibility">*
												select your bussinessDistrict </label> <cf:errors
												path="bussDistrict" cssClass="error" /></li>
									</ul>
								</div>
								<cf:select path="bussDistrict" class="form-control"
									onchange="getCity(this.value , 'bussCity');">
									<cf:option value="0" label="Select District" />
									<cf:options items="${districtList}" itemValue="districtId"
										itemLabel="districtName" />
								</cf:select>
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><cs:message code="lbl.Trainee.City" /></li>
										<li class="style-li error-red"><cf:errors
												path="correspondenceState" cssClass="error" /></li>
									</ul>
								</div>
								<label id="bussCityError" class="error visibility">*
									select your bussinessDistrict </label>
								<cf:select path="bussCity" class="form-control">
									<cf:option value="0" label="Select City" />
									<cf:options items="${cityList}" itemValue="cityId"
										itemLabel="cityName" />
								</cf:select>
							</div>

							<div class="form-group">
								<div>
									<ul class="lab-no">
										<li class="style-li"><strong><cs:message
													code="lbl.Trainee.Pincode" /></strong></li>
										<li class="style-li error-red"><label
											id="bussPincodeError" class="error visibility">*
												enter your bussinessPincode </label> <cf:errors path="bussPincode"
												cssClass="error" /></li>
									</ul>
								</div>
								<cf:input path="bussPincode" class="form-control"
									placeholder="Pincode" maxlength="6"
									onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
							</div>
						</div>
						<!--Right side-->
					</fieldset>
				</div>


				<!-- Business address Start -->
				<div class="row" style="height: 20px;"></div>
				<div
					style="width: 95%; margin-left: 32px; float: left; height: 100px; border: 1px solid #cecece;"
					class="form-group">
					<div style="float: left">
						<div style="float: left; width: 98%;">
							<label id="captchaError"
								style="float: left; width: 99%; font-family: Calibri; margin-left: 0px;">Please
								enter captcha in below textbox !!!</label>
						</div>

						<div style="float: left; width: 99%;">

							<input type="text" id="txtCaptcha"
								style="background-image: url(1.jpg); text-align: center; border: none; width: 140px; margin-left: 8px; font-weight: bold; font-family: Modern"
								disabled="disabled" /> <input type="button" id="btnrefresh"
								value="Refresh" onclick="DrawCaptcha();" /> <input type="text"
								id="txtInput" placeholder="Captcha" style="width: 140px;"/ >

						</div>
					</div>
					<div style="float: left; width: 99%;">
						<input type="checkbox" id="check" style="margin-left: 1%;">
						<!-- <a href="#" target="_blank" class="terms-font-size">  -->
						I have read and understood the Terms & Conditions and the Privacy
						Policy of FSSAI.
						<!-- </a> -->
					</div>
				</div>

				<div class="col-xs-12">
					<div class="col-xs-4"></div>
					<div class="col-xs-4" id="register">
						<div class="form-group">
<!-- 							<input type="submit" class="form-control login-btn" -->
<!-- 								value="Register" onclick="return ValidCaptcha();" /> -->
								<input type="submit" class="form-control login-btn"
								value="Register" />
						</div>
					</div>
					<div class="col-xs-4"></div>
				</div>
			</div>
		</div>


		<div class="col-md-2 hidden-xs"></div>
	</cf:form>
	
	<script type="text/javascript">
	var traineeAadhar = localStorage.getItem('traineeAadhar');
 	document.getElementById( "AadharNumber" ).value = traineeAadhar;
 	document.getElementById( "AadharNumberShow" ).value = traineeAadhar;
 	localStorage.removeItem('traineeAadhar');
 	var DOB = localStorage.getItem('DOB');
 	document.getElementById( "dateP" ).value = DOB;
 	localStorage.removeItem('DOB');
 	
 	var firstname = localStorage.getItem('name');
 	document.getElementById( "traineeFirstName" ).value =firstname;
 	localStorage.removeItem('name');
 	
 	
	</script>