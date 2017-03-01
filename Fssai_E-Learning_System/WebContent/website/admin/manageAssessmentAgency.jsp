<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
            <style>
                .error {
                    color: red;
                }

            </style>
            <script type="text/javascript">
                function validate() {
                    var status = true;
                   // var userID = $("#userId").val();
                    var assAgencyName = $("#assessmentAgencyName").val();
                    var websiteURL = $("#websiteUrl").val();
                    var pan = $("#PAN").val();
                    var email = $("#email").val();
                    var headOfficeDataAddress1 = $("#headOfficeDataAddress1").val();
                    var headOfficeDataAddress2 = $("#headOfficeDataAddress2").val();
                    var pin = $("#pin").val();
                    var stateId = $("#stateId").val();
                    var district = $("#district").val();
                    var city = $("#city").val();
                   /*  if (userID == "" || userID.length <= 0) {
                        alert('Please Enter User ID')
                        status = false;
                    } else  */if (assAgencyName == "" || assAgencyName.length <= 0) {
                        alert('Please Enter Assessment Agency Name.')
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
                    //alert('s');
                    updateDiv();
                }
                window.onload = OnStart;

            </script>
            <script>
                function updateDiv() {
                    $("#updateDiv").hide();
                }

            </script>
            <script language="javascript" type="text/javascript">
                function AvoidSpace(event) {
                    var k = event ? event.which : window.event.keyCode;
                    if (k == 32)
                        return false;
                }

                function checkname() {
                    var name = document.getElementById("userId").value;

                    if (name) {
                        $
                            .ajax({
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

                function getDistrict(val) {
                    $.ajax({
                        type: 'post',
                        url: 'loadDistrict.jspp?' + val,
                        success: function(response) {
                            var mainData1 = jQuery.parseJSON(response);
                            $('#district option').remove();
                            $('#district').append(
                                '<option value="0" label="Select District" />');
                            $('#city option').remove();
                            $('#city').append('<option value="0" label="Select City" />');
                            $.each(mainData1, function(i, obj) {
                                $('#district').append(
                                    '<option value=' + obj.districtId + '  >' + obj.districtName + '</option>');
                            });
                        }
                    });
                }

                function getCity(val) {
                    $.ajax({
                        type: 'post',
                        url: 'loadCity.jspp?' + val,
                        success: function(response) {
                            var mainData1 = jQuery.parseJSON(response);
                            $('#city option').remove();
                            $('#city').append('<option value="0" label="Select City" />');
                            $.each(mainData1, function(i, obj) {
                                $('#city').append(
                                    '<option value=' + obj.cityId + ' >' + obj.cityName + '</optipon>');
                            });
                        }
                    });
                }

            </script>
            <script type="text/javascript" language="javascript">
                function pan_validate(pan) {
                    var regpan = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
                    if (regpan.test(pan) == false) {
                        document.getElementById("statusPan").innerHTML = "Invalid PAN !!!";
                    } else {
                        document.getElementById("statusPan").innerHTML = "";
                    }
                }

                function searchData() {
                    var userId = $("#userId").val();
                    var aan = $("#assessmentAgencyName").val(); - $(".displayNone").css("display", "block"); {
                        var result = "";
                        var total = "userId=" + userId + "&assessmentAgencyName=" + aan;
                        $
                            .ajax({
                                type: 'post',
                                url: 'searchData.jspp?' + total,
                                async: false,
                                success: function(data) {
                                    var mainData1 = jQuery.parseJSON(data);
                                    var j = 1;
                                    $('#newTable tr').remove();
                                    $('#newTable')
                                        .append(
                                            '<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Id</th><th>Assessment Agency Name</th><th>Weblink</th><th>Status</th><th>Option</th></tr>')
                                    $
                                        .each(
                                            mainData1,
                                            function(i, obj) {
                                                $('#newTable')
                                                    .append(
                                                        '<tr id="tableRow"><td>' + j++
                                                        + '</td><td>' + obj[1] + '</td><td>' + obj[2] + '</td><td>' + obj[3] + '</td><td>' + obj[4] + '</td><td><input type="hidden" id="maaId' + i + '" value="' + obj[0] + '" /><a href="#" onClick="editManageAssessmentAgency(' + i + ');">edit</a><input type="hidden" id="sid" value="' + obj[13] + '"><input type="hidden" id="sid" value="' + obj[14] + '"> <input type="hidden" id="sid" value="' + obj[15] + '"></td></tr>');
                                            });
                                }
                            });
                        $('#newTable').show();
                        return result;
                    }
                }

            </script>
            <script>
                function getStateUpdate(ss, dd, cc) {
                    $
                        .ajax({
                            type: 'post',
                            url: 'getStateUpdate.jspp',
                            success: function(response) {
                                var mainData2 = jQuery.parseJSON(response);
                                $('#stateId option').remove();
                                $('#stateId')
                                    .append(
                                        '<option value="0" label="Select Stateeeeee" />');
                                $
                                    .each(
                                        mainData2,
                                        function(i, obj) {
                                            if (ss == obj.stateId) {
                                                $('#stateId')
                                                    .append(
                                                        '<option selected="true" value=' + obj.stateId + '>' + obj.stateName + '  </option>');
                                            } else {
                                                $('#stateId')
                                                    .append(
                                                        '<option value=' + obj.stateId + '>' + obj.stateName + ' </option>');
                                            }
                                        });
                            }
                        });
                    getDistrictUpdate(ss, dd, cc);
                }

                function getDistrictUpdate(ss, dd, cc) {
                    $
                        .ajax({
                            type: 'post',
                            url: 'getDistrictUpdate.jspp?' + ss,
                            success: function(response) {
                                var mainData1 = jQuery.parseJSON(response);
                                $('#district option').remove();
                                $('#district').append(
                                    '<option value="0" label="Select District" />');

                                $
                                    .each(
                                        mainData1,
                                        function(i, obj) {
                                            if (dd == obj.districtId) {
                                                $('#district')
                                                    .append(
                                                        '<option selected="true" value=' + obj.districtId + '>' + obj.districtName + ' </option>');
                                            } else {
                                                $('#district')
                                                    .append(
                                                        '<option value=' + obj.districtId + '>' + obj.districtName + ' </option>');
                                            }
                                        });
                            }
                        });
                    getCityUpdate(dd, cc);
                }

                function getCityUpdate(dd, cc) {
                    $
                        .ajax({
                            type: 'post',
                            url: 'getCityUpdate.jspp?' + dd,
                            success: function(response) {
                                var mainData1 = jQuery.parseJSON(response);
                                $('#city option').remove();
                                $('#city').append(
                                    '<option value="0" label="Select District" />');

                                $
                                    .each(
                                        mainData1,
                                        function(i, obj) {
                                            if (cc == obj.cityId) {
                                                $('#city')
                                                    .append(
                                                        '<option selected="true" value=' + obj.cityId + '>' + obj.cityName + ' </option>');
                                            } else {
                                                $('#city')
                                                    .append(
                                                        '<option value=' + obj.cityId + '>' + obj.cityName + ' </option>');
                                            }
                                        });
                            }
                        });
                }

                function editManageAssessmentAgency(i) {
                    var userId = $("#maaId" + i).val();
                    document.getElementById("i").value = i;
                    alert(userId);
                    $(".displayNone").css("display", "block");
                    $("#updateDiv").show();
                    $("#createDiv").hide(); {
                        var result = "";
                        var total = userId;
                        $
                            .ajax({
                                type: 'post',
                                url: 'editMAA.jspp?' + total,
                                async: false,
                                success: function(data) {
                                    $('#newTable').show();
                                    var mainData1 = jQuery.parseJSON(data);
                                    $
                                        .each(
                                            mainData1,
                                            function(i, obj) {
                                                document
                                                    .getElementById("assessmentAgencyName").value = obj[2];
                                                document
                                                    .getElementById("userId").value = obj[1];
                                                $("#assessmentAgencyName")
                                                    .attr("disabled",
                                                        "disabled");
                                                $("#userId").attr("disabled",
                                                    "disabled");
                                                $("#PAN").attr("disabled",
                                                    "disabled");

                                                document.getElementById("PAN").value = obj[5];
                                                document
                                                    .getElementById("websiteUrl").value = obj[3];
                                                document
                                                    .getElementById("email").value = obj[6];
                                                document
                                                    .getElementById("headOfficeDataAddress1").value = obj[7];
                                                document
                                                    .getElementById("headOfficeDataAddress2").value = obj[8];
                                                document.getElementById("pin").value = obj[9];

                                                var s = obj[10];
                                                var ss = obj[13];
                                                var d = obj[11];
                                                var dd = obj[14];
                                                var c = obj[12];
                                                var cc = obj[15];
                                                getStateUpdate(ss, dd, cc);

                                                /* $('#stateId option').remove();
                                                $('#stateId').append('<option value="'+s+'">ss</option>');
												
                                                $('#district option').remove();
                                                $('#district').append('<option value="'+14+'">dd</option>');
												
                                                $('#city option').remove();
                                                $('#city').append('<option value="'+15+'">cc</option>'); */

                                                //stateId.options[0].text = s;
                                                //district.options[0].text = d;
                                                //city.options[0].text = c;
                                                if (obj[4] == "A") {
                                                    //alert('a');
                                                    $('#status option')
                                                        .remove();
                                                    $('#status')
                                                        .append(
                                                            '<option value="0">Select Status</option><option value="A" selected="true">Active</option><option value="I">In-active</option>');
                                                } else {
                                                    //alert('i');
                                                    $('#status option')
                                                        .remove();
                                                    $('#status')
                                                        .append(
                                                            '<option value="0" >In-Active</option><option value="A">Active</option><option value="I"  selected="true">In-active</option>');
                                                }
                                            });
                                }
                            });

                        return result;
                    }
                }

            </script>
            <script>
                function updateData() {
                    var i = document.getElementById("i").value;
                    var userId = $("#maaId" + i).val();
                    //alert(userId);
                    var status = $("#status").val();
                    var websiteUrl = $("#websiteUrl").val();
                    var email = $("#email").val();
                    var headOfficeDataAddress1 = $("#headOfficeDataAddress1").val();
                    var headOfficeDataAddress2 = $("#headOfficeDataAddress2").val();
                    var pin = $("#pin").val();
                    var stateId = $("#stateId").val();
                    var district = $("#district").val();
                    var city = $("#city").val();

                    var total = "userId=" + userId + "&status=" + status + "&websiteUrl=" + websiteUrl + "&email=" + email + "&headOfficeDataAddress1=" + headOfficeDataAddress1 + "&headOfficeDataAddress2=" + headOfficeDataAddress1 + "&pin=" + pin + "&stateId=" + stateId + "&district=" + district + "&city=" + city;
                    $(".displayNone").css("display", "block");
                    $("#updateDiv").hide();
                    $("#createDiv").show();
                    $.ajax({
                        type: 'post',
                        url: 'updateMAA.jspp?' + total,
                        data: {
                            user_name: name,
                        },
                        success: function(response) {
                            $('#name_status').html(response);

                        }
                    });

                    $('#status option').remove();
                    $('#status')
                        .append(
                            '<option value="0" >Select Status</option><option value="A">Active</option><option value="I" >In-active</option>');

                    $("#websiteUrl").val() = '';
                    $("#email").val() = '';
                    $("#headOfficeDataAddress1").val() = '';
                    $("#headOfficeDataAddress2").val() = '';
                    $("#pin").val() = '';
                    $("#stateId").val() = '';
                    $("#district").val() = '';
                    $("#city").val() = '';
                }

            </script>
            <cf:form action="manageAssessmentAgencySave.fssai" name="myForm" method="POST" commandName="manageAssessmentAgencyForm" onsubmit="return validateFields();">

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
                                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Admin</span>
                                                </a>
                                            </div>
                                        </div>
                                        <!-- add the content here for main body -->
                                        <!-- timeline  -->
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <h1>Manage Assessment Agency</h1>
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <!-- left side -->
                                                        <div class="col-xs-6">
                                                            <div class="form-group" style="display:none">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>User ID:</strong></li>
                                                                        <li class="style-li error-red">${created } <span id="name_status"> </span>
                                                                            <cf:errors path="userId" cssClass="error" />
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:input path="userId"  placeholder="UserId" class="form-control" />
                                                            </div>

                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>Assessment
																Agency Name:</strong></li>
                                                                        <li class="style-li error-red">
                                                                            <cf:errors path="assessmentAgencyName" cssClass="error" />
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:input path="assessmentAgencyName" placeholder="Assessment Agency Name" class="form-control" />
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
                                                                <cf:input path="websiteUrl" placeholder="Website URL" class="form-control" />
                                                            </div>

                                                        </div>
                                                        <!-- left side ends -->
                                                        <!-- right side -->
                                                        <div class="col-xs-6">

                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>PAN:</strong></li>
                                                                        <li class="style-li error-red"><span id="status1"></span>
                                                                            <span id="statusPan"></span> <span id="name_status">
														</span>
                                                                            <cf:errors path="PAN" cssClass="error" />
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:input path="PAN" placeholder="PAN" class="form-control" onKeyUP="this.value = this.value.toUpperCase();" onblur="pan_validate(this.value);" />
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
                                            </div>
                                            <!-- head data -->
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
                                                            <cf:input path="headOfficeDataAddress1" placeholder="Address" class="form-control" />
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
                                                            <cf:input path="headOfficeDataAddress2" placeholder="Address" class="form-control" />
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
                                                            <cf:input path="pin" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="PIN" class="form-control" maxlength="6" />
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
                                                            <cf:select path="stateId" class="form-control" onchange="getDistrict(this.value);">
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
                                                            <cf:select path="district" class="form-control" onchange="getCity(this.value);">
                                                                <cf:option value="0" label="Select District" />
                                                                <%-- <cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName"/> --%>
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
                                                                <%-- <cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName"/> --%>
                                                            </cf:select>
                                                        </div>
                                                        <%--  <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Status:</strong></li>
                                                    <li class="style-li error-red"></li>
                                                </ul>
                                            </div>
<cf:select path="status" class="form-control">
<cf:option value="A" label="Active" />
<cf:option value="i" label="In-Active" />
</cf:select>
                                        </div> --%>
                                                    </div>
                                                </fieldset>
                                            </div>
                                            <!-- button -->
                                            <!-- button -->
                                            <div class="row">
                                                <div class="col-md-6 col-xs-12"></div>
                                                <div class="col-md-6 col-xs-12" style="margin-top: 26px;">

                                                    <div id="createDiv" style="float: left;">
                                                        <input type="submit" id="register" onclick="return validate();" class="btn login-btn" value="Create" />
                                                    </div>
                                                    <div id="updateDiv" style="float: left; margin-left: 20px;">
                                                        <a href="#" onclick="updateData();" class="btn btn-default pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" style="margin-right: 0px;"> Update</a>
                                                    </div>
                                                    <div id="searchDiv" style="float: left; margin-left: 20px;">
                                                        <a href="#" onclick="searchData();" class="btn btn-default pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" style="margin-right: 15px;"> Search</a>
                                                    </div>


                                                </div>
                                            </div>
                                            <!-- search Results -->
                                            <div id="testt" class="displayNone" aria-expanded="false">
                                                <!-- table -->
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <fieldset>
                                                            <legend>Search Result</legend>
                                                            <table id="newTable" class="table table-bordered table-responsive">
                                                                <thead>
                                                                    <tr class="background-open-vacancies">
                                                                        <th>S.No.</th>
                                                                        <th>Assessment Agency ID</th>
                                                                        <th>Assessment Agency Name</th>
                                                                        <th>Website Link</th>
                                                                        <th>Status</th>
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
                                        </div>
                                        <!-- row ends -->
                                    </div>
                                </div>
                        </div>
                    </div>
                </section>
                <input type="hidden" id="i" value="">
            </cf:form>
            <!-- <script>
                var id = localStorage.getItem('activeID');
                document.getElementById(id).className = "active";

            </script> -->
