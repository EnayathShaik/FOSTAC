<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
            <style>
                .error {
                    color: red;
                }

            </style>
            <script src="website/js/commonController.js"></script>
            <script type="text/javascript">
                function validate() {
                    var status = true;
                   // var userID = $("#userId").val();
                    var trainingPartnerName = $("#trainingPartnerName").val();
                    var websiteURL = $("#websiteUrl").val();
                    var pan = $("#PAN").val();
                    var email = $("#email").val();
                    var headOfficeDataAddress1 = $("#headOfficeDataAddress1").val();
                    var headOfficeDataAddress2 = $("#headOfficeDataAddress2").val();
                    var pin = $("#pin").val();
                    var stateId = $("#state").val();
                    var district = $("#district").val();
                    var city = $("#city").val();
                  /*   if (userID == "" || userID.length <= 0) {
                        alert('Please Enter User ID')
                        status = false;
                    } else */ if (trainingPartnerName == "" || trainingPartnerName.length <= 0) {
                        alert('Please Enter Training Partner Name.')
                        status = false;
                    } else if (websiteURL == "" || websiteURL.length <= 0) {
                        alert('Please Enter Website URL.')
                        status = false;
                    } else if (pan == "" || pan.length <= 0) {
                        alert('Please Enter PAN.')
                        status = false;
                    } else if (email == "" || email.length <= 0) {
                        alert('Please Enter Email.')
                        status = false;
                    } else if (headOfficeDataAddress1 == "" || headOfficeDataAddress1.length <= 0) {
                        alert('Please Enter Address 1.')
                        status = false;
                    } else if (headOfficeDataAddress2 == "" || headOfficeDataAddress2.length <= 0) {
                        alert('Please Enter Address 2.')
                        status = false;
                    } else if (pin == "" || pin.length <= 0) {
                        alert('Please Enter Pincode.')
                        status = false;
                    } else if (stateId == 0 || stateId == "" || stateId.length <= 0) {
                        alert('Please Select State.')
                        status = false;
                    } else if (district == 0 || district == "" || district.length <= 0) {
                        alert('Please Select District')
                        status = false;
                    } else if (city == 0 || city == "" || city.length <= 0) {
                        alert('Please Select City.')
                        status = false;
                    }
                    if (!status) {
                        return false;
                    }
                }

                function OnStart() {
                    ////alert('s');
                    //updateDiv();
                    //searchDataTP('ALL');
                }
                window.onload = OnStart;

            </script>
            <script>
                function updateDiv() {
                    $("#updateDiv").hide();
                }

            </script>
            <script type="text/javascript">
                function preventBack() {
                    window.history.forward();
                }
                setTimeout("preventBack()", 10);
                window.onunload = function() {
                    null
                };

            </script>

            <script language="javascript" type="text/javascript">
                function AvoidSpace(event) {
                    var k = event ? event.which : window.event.keyCode;
                    if (k == 32) return false;
                }


                function checkname() {
                    var name = document.getElementById("userId").value;

                    if (name) {
                        $.ajax({
                            type: 'post',
                            url: 'checkdata.jspp?' + name,
                            data: {
                                user_name: name,
                            },

                            success: function(response) {
                                $('#name_status').html(response);

                                if (response.trim() == 'Already') {
                                    document.getElementById('userId').value = "";
                                    document.getElementById("register").style.display = 'none';
                                    return false;

                                } else {
                                    var aa = $('#name_status').html(response);
                                    document.getElementById("register").style.display = 'block';
                                    return true;
                                }
                            }
                        });
                    } else {
                        $('#name_status').html("");
                        document.getElementById("register").style.display = 'none';
                        return false;
                    }
                }

  

            </script>
            <script type="text/javascript" language="javascript">
                function pan_validate(pan) {
                    var regpan = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
                    if (regpan.test(pan) == false) {
                        document.getElementById("panstatus").innerHTML = "Invalid PAN !!!";
                    } else {
                        document.getElementById("panstatus").innerHTML = "";
                    }
                }

                function searchDataTP(indicator) {

                    var userId = $("#userId").val();
                    //alert("userId>"+userId);
                    var tpn = $("#trainingPartnerName").val();
                    var websiteURL = $("#websiteUrl").val();
                    var pan = $("#PAN").val();
                    var email = $("#email").val();
                    var headOfficeDataAddress1 = $("#headOfficeDataAddress1").val();
                    var headOfficeDataAddress2 = $("#headOfficeDataAddress2").val();
                    var pin = $("#pin").val();
                    var stateId = $("#state").val();
                    var district = $("#district").val();
                    var city = $("#city").val();
                    var status = $("#status").val();
                    //alert(status);
                    if (stateId == 0)
                        stateId = "";
                    if (district == 0)
                        district = "";
                    if (city == 0)
                        city = "";

                    //$(".displayNone").css("display","block");
                    {
                        var result = "";
                        var total = "";

                        if (indicator.match('ALL')) {
                            $('#updateDiv').hide();

                            total = "ALL"; //"contentLocation=0&courseType=0&courseName=&modeOfTraining=&contentType=0";
                        } else {
                            total = "userId=" + userId + "-assessmentAgencyName=" + tpn + "-websiteURL=" + websiteURL + "-pan=" + pan + "-email=" + email + "-headOfficeDataAddress1=" + headOfficeDataAddress1 + "-headOfficeDataAddress2=" + headOfficeDataAddress2 + "-pin=" + pin + "-stateId=" + stateId + "-district=" + district + "-city=" + city + "-status=" + status;
                        }
                    	var name1=JSON.stringify({
                    		courseName:0
                      })
                        $.ajax({
                            type: 'post',
                            url: 'searchDataTP.fssai?data=' + total,
                            contentType : "application/json",
                  		  	data:name1,
                            async: false,
                            success: function(data) {
                                $('#newTable').show();
                                var mainData1 = jQuery.parseJSON(data);
                                console.log(mainData1);
                                var j = 1;
                                $('#newTable tr').remove();
                                $('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Training Partner Id</th><th>Training Partner Name</th><th>Weblink</th><th>Current Status</th><th>Option</th></tr>')
                                $.each(mainData1, function(i, obj) {
                                    $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[1] + '</td><td>' + obj[2] + '</td><td>' + obj[4] + '</td><td>' +obj[6]+ '</td><td><input type="hidden" id="mtpId" value="' + obj[0] + '" /><a href="#" onClick="editManageTrainingPartner(\'' + obj[0] + '\');">edit</a> </td></tr>');
                                });
                            }
                        });
                        return result;
                    }
                }

                function editManageTrainingPartner(id) {
          
                	var name1=JSON.stringify({
                		courseName:0
                  })
                    $(".displayNone").css("display", "block"); {
                        var result = "";
                        var total = id;
                        $.ajax({
                            type: 'post',
                            url: 'editMTP.fssai?data=' + total,
                            async: false,
                            contentType : "application/json",
                  		  	data:name1,
                            success: function(data) {
                                $('#newTable').show();
                                var mainData1 = jQuery.parseJSON(data);
                                //alert(mainData1);
                                $.each(mainData1, function(i, obj) {
                                    document.getElementById("trainingPartnerName").value = obj[3];
                                    document.getElementById("userId").value = obj[1];
                                    $("#trainingPartnerName").attr("disabled", "disabled");
                                    $("#userId").attr("disabled", "disabled");

                                    $("#PAN").attr("disabled", "disabled");
                                    document.getElementById("PAN").value = obj[2];
                                    document.getElementById("websiteUrl").value = obj[5];
                                    document.getElementById("email").value = obj[12];
                                    document.getElementById("headOfficeDataAddress1").value = obj[6];
                                    document.getElementById("headOfficeDataAddress2").value = obj[7];
                                    document.getElementById("pin").value = obj[8];
                                    document.getElementById("idHiddenUser").value = id;
                                    var s = obj[9];
                                    var d = obj[10];
                                    var c = obj[11];
                                   
                                    if (obj[4] == "A") {
                                   
                                        $('#status option ').remove();
                              
                                        $('#status').append('<option value="A" selected="true">Active</option><option value="I">In-active</option>');
                                    } else {
                                        
                                        $('#status option').remove();
                                        $('#status').append('<option value="A">Active</option><option value="I"  selected="true">In-active</option>');
                                    }
                                
                                  $("#state").val(s);
                                  
                                  $("#state").trigger("change");
                                  window.setTimeout(function() {
                                      $('#district').val(d);
                                      
                                      $("#district").trigger("change");
                                      
                                      window.setTimeout(function() {
                                          $('#city').val(c);
                                      }, 1000);

                                  }, 1000);
                                 

                                  
                                  
                                });
                            }
                        });
                        $("#updateDiv").css("display", "block");
                        $("#createDiv").css("display", "none");
                        return result;
                    }
                }

            </script>
            <script>
                function updateMTP() {
                    var status = $("#status").val();;
                    var url = $("#websiteUrl").val();;
                    var email = $("#email").val();;
                    var address1 = $("#headOfficeDataAddress1").val();;
                    var address2 = $("#headOfficeDataAddress2").val();;
                    var pin = $("#pin").val();;
                    var state = $("#state").val();;
                    var district = $("#district").val();;
                    var city = $("#city").val();
                    var mtpId = $('#mtpId').val();
                    var idHiddenUser = $('#idHiddenUser').val();
                    var result = "";
                    var total = status + '-' + url + '-' + email + '-' + address1 + '-' + address2 + '-' + pin + '-' + state + '-' + district + '-' + city + '-' + idHiddenUser;
                	var name1=JSON.stringify({
                		courseName:0
                  })
                    $.ajax({
                        type: 'post',
                        url: 'updateMTP.fssai?data=' + total,
                        contentType : "application/json",
              		  	data:name1,
                        success: function(response) {
                            $('#name_status').html(response);
                        }
                    });

                    location.reload();
                    return result;
                }

            </script>
            <cf:form action="manageTrainingPartnerSave.fssai" name="myForm" method="POST" commandName="manageTrainingPartnerForm" onsubmit="return validateFields();">

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
                                            <div class="col-lg-12">
                                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName}</span> </a>
                                            </div>
                                        </div>
                                        <!-- add the content here for main body -->
                                        <!-- timeline  -->
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <h1>Manage Training Partner</h1>

                                                <fieldset>
                                                    <legend>Head Office Details</legend>
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <!-- left side -->
                                                            <div class="col-md-6 col-xs-12">

                                                                <div class="form-group" style="display:none">
                                                                    <div>
                                                                        <ul class="lab-no">
                                                                            <li class="style-li"><strong><cs:message code="lbl.Trainee.UserId" /></strong></li>
                                                                            <li class="style-li error-red">${created }<span id="name_status"> </span>
                                                                                <cf:errors path="userId" cssClass="error" />
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <cf:input path="userId"  placeholder="UserId" class="form-control" />
                                                                </div>

                                                                <div class="form-group">
                                                                    <div>
                                                                        <ul class="lab-no">
                                                                            <li class="style-li"><strong>Training Partner Name:</strong></li>
                                                                            <li class="style-li error-red">
                                                                                <cf:errors path="trainingPartnerName" cssClass="error" />
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <cf:input path="trainingPartnerName" maxlength="100" placeholder="Training Partner Name" class="form-control" />
                                                                </div>

                                                                <div class="form-group">
                                                                    <div>
                                                                        <ul class="lab-no">
                                                                            <li class="style-li"><strong>Website URL:</strong></li>
                                                                            <li class="style-li error-red">
                                                                                <cf:errors path="websiteUrl" cssClass="error" />
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <cf:input path="websiteUrl" maxlength="100" placeholder="Website URL" class="form-control" />
                                                                </div>



                                                            </div>
                                                            <!-- left side ends -->
                                                            <!-- right side -->
                                                            <div class="col-md-6 col-xs-12">



                                                                <div class="form-group">
                                                                    <div>
                                                                        <ul class="lab-no">
                                                                            <li class="style-li"><strong>PAN:</strong></li>
                                                                            <li class="style-li error-red">
                                                                                <span id="name_status"> </span>
                                                                                <span id="panstatus"></span>
                                                                                <cf:errors path="PAN" cssClass="error" />
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <cf:input path="PAN" maxlength="10" placeholder="PAN" class="form-control" onKeyUP="this.value = this.value.toUpperCase();" onblur="pan_validate(this.id,this.value);" />
                                                                </div>

                                                                <div class="form-group">
                                                                    <div>
                                                                        <ul class="lab-no">
                                                                            <li class="style-li"><strong>Status:</strong></li>
                                                                            <li class="style-li error-red"></li>
                                                                        </ul>
                                                                    </div>
                                                                    <cf:select path="status" class="form-control">
                                                                        <cf:option value="A" label="Active" />
                                                                        <cf:option value="I" label="In-Active" />
                                                                    </cf:select>
                                                                </div>

                                                                <div class="form-group">
                                                                    <div>
                                                                        <ul class="lab-no">
                                                                            <li class="style-li"><strong>Email:</strong></li>
                                                                            <li class="style-li error-red"></li>
                                                                        </ul>
                                                                    </div>
                                                                    <cf:input path="email" class="form-control" maxlength="100" />

                                                                </div>
                                                            </div>
                                                            <!-- rigth side ends -->
                                                        </div>
                                                    </div>
                                                </fieldset>
                                            </div>
                                            <div style="height:50px;"></div>
                                            <div class="row">
                                                <!-- head office data -->
                                                <div class="col-xs-12">
                                                    <fieldset>
                                                        <legend>Head Office Data</legend>
                                                        <!-- left side -->
                                                        <div class="col-md-6 col-xs-12">
                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>Address 1:</strong></li>
                                                                        <li class="style-li error-red">
                                                                            <cf:errors path="headOfficeDataAddress1" cssClass="error" />
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:input path="headOfficeDataAddress1" maxlength="100" placeholder="Address" class="form-control" />
                                                            </div>
                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>Address 2:</strong></li>
                                                                        <li class="style-li error-red">
                                                                            <cf:errors path="headOfficeDataAddress2" cssClass="error" />
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:input path="headOfficeDataAddress2" maxlength="100" placeholder="Address" class="form-control" />
                                                            </div>
                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>PIN:</strong></li>
                                                                        <li class="style-li error-red">
                                                                            <cf:errors path="pin" cssClass="error" />
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:input path="pin" maxlength="6" placeholder="PIN" class="form-control" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
                                                            </div>
                                                        </div>
                                                        <!-- right side -->
                                                        <div class="col-md-6 col-xs-12">
                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>State:</strong></li>
                                                                        <li class="style-li error-red"></li>
                                                                    </ul>
                                                                </div>
                                                                <cf:select path="state" class="form-control" onchange="getDistrict(this.value , 'district')">
                                                                    <cf:option value="0" label="Select State" />
                                                                    <cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
                                                                </cf:select>
                                                            </div>
                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>District:</strong></li>
                                                                        <li class="style-li error-red"></li>
                                                                    </ul>
                                                                </div>
                                                                <cf:select path="district" class="form-control" onchange="getCity(this.value , 'city')">
                                                                    <cf:option value="0" label="Select District" />
                                                                </cf:select>
                                                            </div>
                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>City:</strong></li>
                                                                        <li class="style-li error-red"></li>
                                                                    </ul>
                                                                </div>
                                                                <cf:select path="city" class="form-control">
                                                                    <cf:option value="0" label="Select City" />
                                                                </cf:select>
                                                            </div>
                                                        </div>
                                                    </fieldset>
                                                </div>
                                            </div>
                                            <!-- button -->
                                            <div class="row" id="register1">
                                                <div class="col-md-6 col-xs-12"></div>
                                                <div class="col-md-6 col-xs-12" style="margin-top: 26px;">

                                                    <div id="createDiv" style="float:left;">
                                                    	<input type="hidden" path="profileID" name="profileID" id="profileID" value="1"/>
                                                    	<input type="hidden" path="logindetails" name="logindetails" id="logindetails" value=""/>
                                                        <input type="submit" id="register" onclick="return validate();" class="btn login-btn" value="Create" />
                                                        <input type="hidden" id="idHiddenUser" value="">
                                                    </div>
                                                    <div id="updateDiv" style=" float:left; margin-left: 20px;">
                                                        <a href="#" onclick="updateMTP();" class="btn btn-default pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" style="margin-right: 0px;  ">
Update</a>
                                                    </div>

                                                    <a href="#testt" onclick="searchDataTP('SELECTED');" class="pull-right">Search</a>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- search Results -->
                                        <div class="col-xs-12 " id="show-result" aria-expanded="false" style="height: 0px;">
                                            <!-- table -->
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <fieldset>
                                                        <legend>Search Result</legend>
                                                        <table id="newTable" class="table table-bordered table-responsive">
                                                            <thead>
                                                                <tr class="background-open-vacancies">
                                                                    <th>S.No.</th>
                                                                    <th>Training Partner ID</th>
                                                                    <th>Training Partner Name</th>
                                                                    <th>Website Link</th>
                                                                    <th>Current Status</th>
                                                                    <th>Update Status</th>
                                                                    <th>Option</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                            </tbody>
                                                        </table>
                                                    </fieldset>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- search div ends -->

                                        <!-- row ends -->
                                    </div>

                                </div>
                </section>
            </cf:form>
   <script>
              
           /*      function activateDeActivateUser(loginDetails,status,profileID){
                	if(confirm("Are you Sure to  ?"+status)){
                		
                		$("#logindetails").val(loginDetails);	
                		$("#status").val((status=="INACTIVE"?"I":"A"));	
                		alert($("#logindetails").val() + " "+ $("#status").val());
                		$("#manageTrainingPartnerForm").attr("action" , "activateDeActivateTrainingPartner.fssai");
                		alert($("#manageTrainingPartnerForm").attr("action"));
                    } else{
                        return false;
                    }
                } */
            </script>