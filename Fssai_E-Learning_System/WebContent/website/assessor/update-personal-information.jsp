<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
            <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>


                <script>
                    function getstateid() {
                        //alert('ll');
                        getstat2();
                        getstateid1();

                    }
                    window.onload = getstateid;

                </script>




                <script>
                    function getstateid1() {


                        var psid = $ {
                            loginUr.assessorrPermanentState.stateId
                        };
                        var pdid = $ {
                            loginUr.assessorPermanentDistrict.districtId
                        };
                        var pcid = $ {
                            loginUr.assessorPermanentCity.cityId
                        };
                        var title = '${loginUr.title.titleName}';
                        getStateUpdate(psid, pdid, pcid);
                        Title.options[0].text = title;
                        var agency = '${loginUr.assessmentAgencyName.assessmentAgencyName}';
                        AssessmentAgencyName.options[0].text = agency;
                        var month = '${loginUr.releventExpOfAuditInMonth}';
                        ReleventExpOfAuditInMonth.options[0].text = month;

                    }

                    function getStateUpdate(psid, pdid, pcid) {
                        $.ajax({
                            type: 'post',
                            url: 'getStateUpdate.jspp',
                            success: function(response) {
                                var mainData2 = jQuery.parseJSON(response);
                                $('#AssessorrPermanentState option').remove();
                                $('#AssessorrPermanentState').append('<option value="0" >Select Stateeeeee </option>');

                                $.each(mainData2, function(i, obj) {
                                    if (psid == obj.stateId) {
                                        $('#AssessorrPermanentState').append('<option selected="true" value=' + obj.stateId + '>' + obj.stateName + '  </option>');
                                    } else {
                                        $('#AssessorrPermanentState').append('<option value=' + obj.stateId + '>' + obj.stateName + ' </option>');
                                    }
                                });
                            }
                        });
                        getDistrictUpdate(psid, pdid, pcid)

                    }

                    function getDistrictUpdate(ss, dd, cc) {
                        $.ajax({
                            type: 'post',
                            url: 'getDistrictUpdate.jspp?' + ss,
                            success: function(response) {
                                var mainData1 = jQuery.parseJSON(response);
                                $('#AssessorPermanentDistrict option').remove();
                                $('#AssessorPermanentDistrict').append('<option value="0" label="Select District" />');

                                $.each(mainData1, function(i, obj) {
                                    if (dd == obj.districtId) {
                                        $('#AssessorPermanentDistrict').append('<option selected="true" value=' + obj.districtId + '>' + obj.districtName + ' </option>');
                                    } else {
                                        $('#AssessorPermanentDistrict').append('<option value=' + obj.districtId + '>' + obj.districtName + ' </option>');
                                    }
                                });
                            }
                        });
                        getCityUpdate(dd, cc);
                    }

                    function getCityUpdate(dd, cc) {
                        $.ajax({
                            type: 'post',
                            url: 'getCityUpdate.jspp?' + dd,
                            success: function(response) {
                                var mainData1 = jQuery.parseJSON(response);
                                $('#AssessorPermanentCity option').remove();
                                $('#AssessorPermanentCity').append('<option value="0" label="Select City" />');

                                $.each(mainData1, function(i, obj) {
                                    if (cc == obj.cityId) {
                                        $('#AssessorPermanentCity').append('<option selected="true" value=' + obj.cityId + '>' + obj.cityName + ' </option>');
                                    } else {
                                        $('#AssessorPermanentCity').append('<option value=' + obj.cityId + '>' + obj.cityName + '</option>');
                                    }
                                });
                            }
                        });

                    }


                    function getstat2() {
                        var csid = $ {
                            loginUr.assessorCorrespondenceState.stateId
                        };

                        var cdid = $ {
                            loginUr.assessorCorrespondenceDistrict.districtId
                        };

                        var ccid = $ {
                            loginUr.assessorCorrespondenceCity.cityId
                        };

                        getCorrespondanceStateUpdate(csid, cdid, ccid);

                    }

                    function getCorrespondanceStateUpdate(csid, cdid, ccid) {
                        $.ajax({
                            type: 'post',
                            url: 'getStateUpdate.jspp',
                            success: function(response) {
                                var mainData2 = jQuery.parseJSON(response);
                                $('#AssessorCorrespondenceState option').remove();
                                $('#AssessorCorrespondenceState').append('<option value="0" label="Select Stateeeeee" />');

                                $.each(mainData2, function(i, obj) {
                                    if (csid == obj.stateId) {
                                        $('#AssessorCorrespondenceState').append('<option selected="true" value=' + obj.stateId + '>' + obj.stateName + '  </option>');
                                    } else {
                                        $('#AssessorCorrespondenceState').append('<option value=' + obj.stateId + '>' + obj.stateName + ' </option>');
                                    }
                                });
                            }
                        });

                        CorrDistrictUpdate(csid, cdid, ccid);
                    }

                    function CorrDistrictUpdate(csid, cdid, ccid) {
                        $.ajax({
                            type: 'post',
                            url: 'getDistrictUpdate.jspp?' + csid,
                            success: function(response) {
                                var mainData1 = jQuery.parseJSON(response);
                                $('#AssessorCorrespondenceDistrict option').remove();
                                $('#AssessorCorrespondenceDistrict').append('<option value="0" label="Select District" />');

                                $.each(mainData1, function(i, obj) {

                                    //alert("cdname is "+cdname);
                                    // $("#TrainingCenterCorrespondenceDistrict").prop('selectedIndex', cdid);
                                    if (cdid == obj.districtId) {
                                        //TrainingCenterCorrespondenceDistrict.options[0].text = cdname;
                                        $('#AssessorCorrespondenceDistrict').append('<option selected="true" value=' + obj.districtId + '>' + obj.districtName + ' </option>');
                                        //alert("cd is "+cdid);

                                    } else {
                                        $('#AssessorCorrespondenceDistrict').append('<option value=' + obj.districtId + '>' + obj.districtName + ' </option>');
                                    }
                                });
                            }
                        });
                        getCorrCityUpdate(cdid, ccid);
                    }

                    function getCorrCityUpdate(cdid, ccid) {
                        $.ajax({
                            type: 'post',
                            url: 'getCityUpdate.jspp?' + cdid,
                            success: function(response) {
                                var mainData1 = jQuery.parseJSON(response);
                                $('#AssessorCorrespondenceCity option').remove();
                                $('#AssessorCorrespondenceCity').append('<option value="0" label="Select City" />');

                                $.each(mainData1, function(i, obj) {
                                    if (ccid == obj.cityId) {
                                        $('#AssessorCorrespondenceCity').append('<option selected="true" value=' + obj.cityId + '>' + obj.cityName + ' </option>');
                                    } else {
                                        $('#AssessorCorrespondenceCity').append('<option value=' + obj.cityId + '>' + obj.cityName + ' </option>');
                                    }
                                });
                            }
                        });

                    }

                </script>



                <script>
                    function getDistrict(val) {

                        $.ajax({
                            type: 'post',
                            url: 'loadDistrict.jspp?' + val,
                            success: function(response) {
                                var mainData1 = jQuery.parseJSON(response);
                                $('#AssessorCorrespondenceDistrict option').remove();
                                $('#AssessorCorrespondenceDistrict').append('<option value="0" label="Select District" />');
                                $('#AssessorCorrespondenceCity option').remove();
                                $('#AssessorCorrespondenceCity').append('<option value="0" label="Select City" />');

                                $.each(mainData1, function(i, obj) {

                                    $('#AssessorCorrespondenceDistrict').append('<option value=' + obj.districtId + '>' + obj.districtName + ' </option>');
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
                                $('#AssessorCorrespondenceCity option').remove();
                                $('#AssessorCorrespondenceCity').append('<option value="0" label="Select City" />');
                                $.each(mainData1, function(i, obj) {

                                    $("#AssessorCorrespondenceCity").append('<option value=' + obj.cityId + '>' + obj.cityName + ' </option>');
                                });
                            }
                        });
                    }

                    function getDistrictList(val) {
                        $.ajax({
                            type: 'post',
                            url: 'loadDistrict.jspp?' + val,
                            success: function(response) {
                                var mainData1 = jQuery.parseJSON(response);
                                $('#AssessorPermanentDistrict option').remove();
                                $('#AssessorPermanentDistrict').append('<option value="0" label="Select District" />');
                                $('#AssessorPermanentCity option').remove();
                                $('#AssessorPermanentCity').append('<option value="0" label="Select City" />');

                                $.each(mainData1, function(i, obj) {

                                    $('#AssessorPermanentDistrict').append('<option value=' + obj.districtId + '>' + obj.districtName + ' </option>');
                                });
                            }
                        });
                    }

                    function getCityList(val) {
                        $.ajax({
                            type: 'post',
                            url: 'loadCity.jspp?' + val,
                            success: function(response) {
                                var mainData1 = jQuery.parseJSON(response);
                                $('#AssessorPermanentCity option').remove();
                                $('#AssessorPermanentCity').append('<option value="0" label="Select City" />');
                                $.each(mainData1, function(i, obj) {

                                    $('#AssessorPermanentCity').append('<option value=' + obj.cityId + '>' + obj.cityName + ' </option>');
                                });
                            }
                        });
                    }

                </script>

                <script type='text/javascript'>
                    function validate() {
                        //alert("The form was submitted");


                        if (document.getElementById('AssessorCorrespondenceLine1').value == null) {
                            document.getElementById('AssessorCorrespondenceLine1').focus();
                            document.getElementById('AssessorCorrespondenceLine1').style.borderColor = "red";
                            document.getElementById('errorAssessorCorrespondenceLine1').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorCorrespondenceLine1').style.borderColor = "#ccc";
                            document.getElementById('errorAssessorCorrespondenceLine1').style.display = 'none';
                        }

                        if (document.getElementById('AssessorCorrespondenceLine2').value == null) {
                            document.getElementById('AssessorCorrespondenceLine2').focus();
                            document.getElementById('AssessorCorrespondenceLine2').style.borderColor = "red";
                            document.getElementById('errorAssessorCorrespondenceLine2').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorCorrespondenceLine2').style.borderColor = "#ccc";
                            document.getElementById('errorAssessorCorrespondenceLine2').style.display = 'none';
                        }

                        if (document.getElementById('AssessorCorrespondenceState').value == null) {
                            document.getElementById('AssessorCorrespondenceState').focus();
                            document.getElementById('AssessorCorrespondenceState').style.borderColor = "red";
                            document.getElementById('AssessorCorrespondenceStateError').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorCorrespondenceState').style.borderColor = "#ccc";
                            document.getElementById('AssessorCorrespondenceStateError').style.display = 'none';
                        }

                        if (document.getElementById('AssessorCorrespondenceDistrict').value == null) {
                            document.getElementById('AssessorCorrespondenceDistrict').focus();
                            document.getElementById('AssessorCorrespondenceDistrict').style.borderColor = "red";
                            document.getElementById('AssessorCorrespondenceDistrictError').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorCorrespondenceDistrict').style.borderColor = "#ccc";
                            document.getElementById('AssessorCorrespondenceDistrictError').style.display = 'none';
                        }

                        if (document.getElementById('AssessorCorrespondenceCity').value == null) {
                            document.getElementById('AssessorCorrespondenceCity').focus();
                            document.getElementById('AssessorCorrespondenceCity').style.borderColor = "red";
                            document.getElementById('AssessorCorrespondenceCityError').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorCorrespondenceCity').style.borderColor = "#ccc";
                            document.getElementById('AssessorCorrespondenceCityError').style.display = 'none';
                        }

                        if (document.getElementById('AssessorCorrespondencePincode').value == null) {
                            document.getElementById('AssessorCorrespondencePincode').focus();
                            document.getElementById('AssessorCorrespondencePincode').style.borderColor = "red";
                            document.getElementById('errorAssessorCorrespondencePincode').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorCorrespondencePincode').style.borderColor = "#ccc";
                            document.getElementById('errorAssessorCorrespondencePincode').style.display = 'none';
                        }

                        if (document.getElementById('AssessorPermanentEmail').value == null) {
                            document.getElementById('AssessorPermanentEmail').focus();
                            document.getElementById('AssessorPermanentEmail').style.borderColor = "red";
                            document.getElementById('errorAssessorPermanentEmail').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorPermanentEmail').style.borderColor = "#ccc";
                            document.getElementById('errorAssessorPermanentEmail').style.display = 'none';
                        }

                        if (document.getElementById('AssessorPermanentMobile').value == null) {
                            document.getElementById('AssessorPermanentMobile').focus();
                            document.getElementById('AssessorPermanentMobile').style.borderColor = "red";
                            document.getElementById('errorAssessorPermanentMobile').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorPermanentMobile').style.borderColor = "#ccc";
                            document.getElementById('errorAssessorPermanentMobile').style.display = 'none';
                        }

                        if (document.getElementById('AssessorPermanentLine1').value == null) {
                            document.getElementById('AssessorPermanentLine1').focus();
                            document.getElementById('AssessorPermanentLine1').style.borderColor = "red";
                            document.getElementById('errorAssessorPermanentLine1').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorPermanentLine1').style.borderColor = "#ccc";
                            document.getElementById('errorAssessorPermanentLine1').style.display = 'none';
                        }

                        if (document.getElementById('AssessorPermanentLine2').value == null) {
                            document.getElementById('AssessorPermanentLine2').focus();
                            document.getElementById('AssessorPermanentLine2').style.borderColor = "red";
                            document.getElementById('errorAssessorPermanentLine2').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorPermanentLine2').style.borderColor = "#ccc";
                            document.getElementById('errorAssessorPermanentLine2').style.display = 'none';
                        }

                        if (document.getElementById('AssessorrPermanentState').value == null) {
                            document.getElementById('AssessorrPermanentState').focus();
                            document.getElementById('AssessorrPermanentState').style.borderColor = "red";
                            document.getElementById('AssessorrPermanentStateError').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorrPermanentState').style.borderColor = "#ccc";
                            document.getElementById('AssessorrPermanentStateError').style.display = 'none';
                        }

                        if (document.getElementById('AssessorPermanentDistrict').value == null) {
                            document.getElementById('AssessorPermanentDistrict').focus();
                            document.getElementById('AssessorPermanentDistrict').style.borderColor = "red";
                            document.getElementById('AssessorPermanentDistrictError').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorPermanentDistrict').style.borderColor = "#ccc";
                            document.getElementById('AssessorPermanentDistrictError').style.display = 'none';
                        }

                        if (document.getElementById('AssessorPermanentCity').value == null) {
                            document.getElementById('AssessorPermanentCity').focus();
                            document.getElementById('AssessorPermanentCity').style.borderColor = "red";
                            document.getElementById('AssessorPermanentCityError').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorPermanentCity').style.borderColor = "#ccc";
                            document.getElementById('AssessorPermanentCityError').style.display = 'none';
                        }

                        if (document.getElementById('AssessorPermanentPincode').value == null) {
                            document.getElementById('AssessorPermanentPincode').focus();
                            document.getElementById('AssessorPermanentPincode').style.borderColor = "red";
                            document.getElementById('AssessorPermanentPincodeError').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('AssessorPermanentPincode').style.borderColor = "#ccc";
                            document.getElementById('AssessorPermanentPincodeError').style.display = 'none';
                        }

                        if (document.getElementById('ReleventExpOfAuditInMonth').value == null) {
                            document.getElementById('ReleventExpOfAuditInMonth').focus();
                            document.getElementById('ReleventExpOfAuditInMonth').style.borderColor = "red";
                            document.getElementById('ReleventExpOfAuditInMonthError').style.display = 'block';
                            return false;
                        } else {
                            document.getElementById('ReleventExpOfAuditInMonth').style.borderColor = "#ccc";
                            document.getElementById('ReleventExpOfAuditInMonthError').style.display = 'none';
                        }




                    }

                </script>
                <script>
                    function myCheckPermanent() {
                        var x = document.getElementById('checkPermanent').checked;
                        //permanent1.style.display = checkPermanent.checked ? "none" : "block";
                        //permanent2.style.display = checkPermanent.checked ? "none" : "block";
                        if (x == true) {
                            document.getElementById('AssessorPermanentLine1').value = document.getElementById('AssessorCorrespondenceLine1').value;
                            document.getElementById('AssessorPermanentLine2').value = document.getElementById('AssessorCorrespondenceLine2').value;
                            document.getElementById('AssessorPermanentPincode').value = document.getElementById('AssessorCorrespondencePincode').value;
                            document.getElementById('').value = document.getElementById('').value;
                            document.getElementById('').value = document.getElementById('').value;
                            document.getElementById('').value = document.getElementById('').value;
                        }
                        if (x == false) {
                            document.getElementById('AssessorPermanentLine1').value = "";
                            document.getElementById('AssessorPermanentLine2').value = "";
                            document.getElementById('AssessorPermanentPincode').value = "";
                            document.getElementById('').value = document.getElementById('').value = "";
                            document.getElementById('').value = document.getElementById('').value = "";
                            document.getElementById('').value = document.getElementById('').value = "";
                        }
                    }


                    function myBasic(oCheckbox) {
                        var y = [];
                        $("input[name='BasicCourse']:checked").each(function() {
                            y.push($(this).val());
                        });
                        document.getElementById('BasicCourse1').value = y;
                        return y;
                    }

                    function myAdvance(oCheckbox) {
                        var y = [];
                        $("input[name='AdvanceCourse']:checked").each(function() {
                            y.push($(this).val());
                        });
                        document.getElementById('AdvanceCourse1').value = y;
                        return y;
                    }

                    function mySpecial(oCheckbox) {
                        var y = [];
                        $("input[name='SpecialCourse']:checked").each(function() {
                            y.push($(this).val());
                        });
                        document.getElementById('SpecialCourse1').value = y;
                        return y;
                    }


                    function checkname() {
                        var name = document.getElementById("UserId").value;

                        if (name) {
                            $.ajax({
                                type: 'post',
                                url: 'checkdata.jspp?' + name,
                                data: {
                                    user_name: name,
                                },
                                success: function(response) {
                                    $('#name_status').html(response);
                                    if (response == "OK") {
                                        document.getElementById("register").style.display = 'none';
                                        return true;
                                    } else {
                                        document.getElementById("register").style.display = 'block';
                                        return false;
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
                <!-- horizontal navigation -->
                <cf:form action="updateAssessorDatavalue.fssai?id=${loginUr.id}" name="myForm" method="POST" commandName="updateAssessor">
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
                                                    <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle">
                                                        <i class="fa fa-bars"></i> <span class="orange-font">Welcome Mr  ${loginUr.loginDetails.loginId}</span>
                                                    </a>
                                                </div>
                                            </div>

                                            <!-- add the content here for main body -->
                                            <!-- timeline  -->

                                            <div class="container-fluid">
                                                <div class="row">
                                                    <div class="col-md-12  col-xs-12">
                                                        <h3 class="text-capitalize heading-3-padding">Assessor Registration Form</h3>
                                                        <form>

                                                            <!-- personal information -->
                                                            <div class="personel-info">
                                                                <fieldset>
                                                                    <legend>
                                                                        <h3>Update Personal Information</h3></legend>
                                                                    <!-- left side -->
                                                                    <div class="col-md-6 col-xs-12">
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>User Id:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" path="UserId" class="form-control" placeholder="User ID" value="${loginUr.loginDetails.loginId}" disabled="true" />
                                                                        </div>

                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Aadhar:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" path="AadharNumber" class="form-control" placeholder="Aadhar Number" value="${loginUr.aadharNumber}" disabled="true" />
                                                                        </div>


                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Date of Birth:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="date" path="DOB" class="form-control" placeholder="Date" value="${loginUr.DOB}" disabled="true" />
                                                                        </div>

                                                                        <div class="form-group" disabled="true">
                                                                            <!-- <label>Gender</label><br>
                                            <label class="radio-inline">
                                                <input type="radio" name="optradio">Male
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optradio">Female
                                            </label> -->
                                                                            <label class="radio-inline">
                                                                                <cf:radiobutton path="gender" id="male" value="M" checked="true" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                <cf:radiobutton path="gender" id="female" value="F" />Female
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
                                                                                        <label Class="error visibility" id="TitleError">Please select title</label>
                                                                                        <!-- <label id="errorTitle" class="error visibility">* error</label> -->
                                                                                        <cf:errors path="Title" cssClass="error" />
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                            <cf:select path="Title" class="form-control" disabled="true">
                                                                                <cf:option value="0" label="Select Title" />
                                                                                <cf:options items="${titleList}" itemValue="titleId" itemLabel="titleName" />
                                                                            </cf:select>
                                                                        </div>

                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>First Name:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" path="FirstName" class="form-control" placeholder="First Name" value="${loginUr.firstName}" disabled="true" />
                                                                        </div>

                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Middle Name:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" class="form-control" path="MiddleName" placeholder="Middle Name" value="${loginUr.middleName}" disabled="true" />
                                                                        </div>

                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Last Name:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" path="LastName" class="form-control" placeholder="Last Name" value="${loginUr.lastName}" disabled="true" />
                                                                        </div>

                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Assessment Agency Name:</strong></li>
                                                                                    <li class="style-li error-red"> </li>
                                                                                </ul>
                                                                            </div>
                                                                            <cf:select path="AssessmentAgencyName" class="form-control" disabled="true">
                                                                                <%-- <cf:option value="0" label="Select Assessment Agency" /> --%>
                                                                                    <cf:options items="${assessmentAgencyNameList}" itemValue="manageAssessmentAgencyId" itemLabel="assessmentAgencyName" />
                                                                            </cf:select>
                                                                        </div>

                                                                    </div>

                                                                </fieldset>
                                                            </div>
                                                            <!-- personal information ends -->

                                                            <div class="row" style="height: 20px;"></div>

                                                            <!-- contact details -->
                                                            <div class="personel-info">
                                                                <fieldset>
                                                                    <legend>
                                                                        <h3>Correspondence Address</h3></legend>
                                                                    <!-- permanent address -->
                                                                    <!--Left side-->
                                                                    <div class="col-md-6 col-xs-12">
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <!-- <ul class="lab-no">
                      <li class="style-li"><strong>Correspondence Address Line 1:</strong></li>
                      <li class="style-li error-red">*Error</li> 
                       </ul>
                       -->
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong><cs:message code="lbl.Trainer.TrainingCenterCorrespondenceLine1" /></strong></li>
                                                                                    <li class="style-li error-red">
                                                                                        <label id="errorAssessorCorrespondenceLine1" class="error visibility">* error</label>
                                                                                        <cf:errors path="AssessorCorrespondenceLine1" cssClass="error" />
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" class="form-control" placeholder="Training Center Line 1" path="AssessorCorrespondenceLine1" value="${loginUr.assessorCorrespondenceLine1}" maxlength="100" />
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <!-- <ul class="lab-no">
                      <li class="style-li"><strong>Correspondence Address Line 2:</strong></li>
                      <li class="style-li error-red">*Error</li>
                    </ul> -->
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong><cs:message code="lbl.Trainer.TrainingCenterCrrespondenceLine2" /></strong></li>
                                                                                    <li class="style-li error-red">
                                                                                        <label id="errorAssessorCorrespondenceLine2" class="error visibility">* error</label>
                                                                                        <cf:errors path="AssessorCorrespondenceLine2" cssClass="error" />
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" class="form-control" placeholder="Training Center Line 2" path="AssessorCorrespondenceLine2" value="${loginUr.assessorCorrespondenceLine2}" maxlength="100" />
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>State:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:select class="form-control" path="AssessorCorrespondenceState" onchange="getDistrict(this.value);">
                                                                                <option value="">select state</option>
                                                                                <cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />

                                                                            </cf:select>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>District:</strong></li>
                                                                                    <!--  <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:select path="AssessorCorrespondenceDistrict" class="form-control" onchange="getCity(this.value);">
                                                                                <cf:option value="0" label="Select District" />
                                                                            </cf:select>
                                                                        </div>
                                                                    </div>
                                                                    <!-- left side ends -->
                                                                    <!-- right side -->
                                                                    <div class="col-md-6 col-xs-12">
                                                                        <h5><br></h5>

                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Closest City:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:select path="AssessorCorrespondenceCity" class="form-control">
                                                                                <cf:option value="0" label="Select City" />
                                                                                <cf:options items="${cityList}" itemValue="cityId" itemLabel="cityName" />
                                                                            </cf:select>
                                                                        </div>




                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>PIN Code:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" path="AssessorCorrespondencePincode" class="form-control" placeholder="Pincode" value="${loginUr.assessorCorrespondencePincode}" maxlength="6" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
                                                                        </div>

                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Email:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" class="form-control" placeholder="Email" path="AssessorPermanentEmail" value="${loginUr.assessorPermanentEmail}" />
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Mobile:</strong></li>
                                                                                    <!--   <li class="style-li error-red">*error</li>  -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" class="form-control" placeholder="Mobile" path="AssessorPermanentMobile" value="${loginUr.assessorPermanentMobile}" maxlength="10" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" />
                                                                        </div>
                                                                    </div>
                                                                    <!-- right side ends -->
                                                                    <!-- permanent address ends -->
                                                                    <!-- selection -->
                                                                    <div class="col-xs-12">
                                                                        <div class="form-group">
                                                                            <!--  <label>Is your permanent address same as correspondence address</label><br>
                    <label class="radio-inline">
                        <input type="radio" name="optradio">Yes
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optradio">No
                    </label> -->
                                                                        </div>
                                                                    </div>
                                                                    <!-- selection ends -->

                                                                    <!-- correspondance address -->
                                                                    <!--Left side-->
                                                                    <div class="col-md-6 col-xs-12">
                                                                        <h4>Permanent Address</h4>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Permanent Address Line 1:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" class="form-control" placeholder="Training Center Line 1" path="AssessorPermanentLine1" value="${loginUr.assessorPermanentLine1}" maxlength="100" />
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Permanent Address Line 2:</strong></li>
                                                                                    <!--  <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" class="form-control" placeholder="Training Center Line 2" path="AssessorPermanentLine2" value="${loginUr.assessorPermanentLine2}" maxlength="100" />
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>State:</strong></li>
                                                                                    <!--  <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:select path="AssessorrPermanentState" class="form-control" onchange="getDistrictList(this.value);">
                                                                                <cf:option value="0" label="Select State" />
                                                                                <cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
                                                                            </cf:select>
                                                                        </div>

                                                                    </div>
                                                                    <!-- left side ends -->
                                                                    <!-- right side -->
                                                                    <div class="col-md-6 col-xs-12">
                                                                        <h5><br></h5>

                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>District:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:select path="AssessorPermanentDistrict" class="form-control" onchange="getCityList(this.value);">
                                                                                <cf:option value="0" label="Select District" />
                                                                                <cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName" />
                                                                            </cf:select>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Closest City:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:select path="AssessorPermanentCity" class="form-control">
                                                                                <cf:option value="0" label="Select City" />
                                                                                <cf:options items="${cityList}" itemValue="cityId" itemLabel="cityName" />
                                                                            </cf:select>
                                                                        </div>




                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>PIN Code:</strong></li>
                                                                                    <!-- <li class="style-li error-red">*Error</li> -->
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input type="text" class="form-control" value="${loginUr.assessorPermanentPincode}" placeholder="Pincode" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" path="AssessorPermanentPincode" maxlength="6" />
                                                                        </div>

                                                                    </div>
                                                                    <!-- right side ends -->
                                                                </fieldset>
                                                            </div>
                                                            <!-- contact detail ends -->


                                                            <!-- experience details -->
                                                            <div class="personel-info">
                                                                <fieldset>
                                                                    <legend>Experience Details</legend>
                                                                    <!-- left side -->
                                                                    <div class="col-md-6 col-xs-12">

                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong><cs:message code="lbl.Assessor.RelevantExperienceOfAudit" /></strong></li>
                                                                                    <li class="style-li error-red">
                                                                                        <!-- <label Class="error visibility" id="ReleventExpOfAuditInMonthError">* error</label> -->
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-xs-6">
                                                                                    <cf:input cssClass="form-control" place-holder="Years" path="ReleventExpOfAuditInYear" maxlength="2" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" value="${loginUr.releventExpOfAuditInYear}" />
                                                                                </div>
                                                                                <div class="col-xs-6">
                                                                                    <cf:select path="ReleventExpOfAuditInMonth" class="form-control">
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
                                                                                    </cf:select>
                                                                                </div>
                                                                            </div>
                                                                        </div>

                                                                    </div>
                                                                    <!-- left side ends -->

                                                                    <!-- right side -->
                                                                    <div class="col-md-6 col-xs-12">
                                                                        <div class="form-group">
                                                                            <label>How Many assessment can you conduct in a Month ?</label>
                                                                            <cf:input path="HowManyAssessmentConductInAMonth" class="form-control" placeholder="Session Number" maxlength="2" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" value="${loginUr.howManyAssessmentConductInAMonth}" />
                                                                        </div>


                                                                    </div>
                                                                    <!-- right side ends -->
                                                                </fieldset>
                                                            </div>
                                                            <div class="row" style="height: 20px;"> </div>
                                                            <!-- Basic courses -->
                                                            <%-- <div class="personel-info">
<h4>Courses wish to conduct assessment on it ?</h4>
<fieldset>
<legend>Basic Courses</legend>
<!-- left -->
<div class="col-md-6 col-xs-12" style="width:100%;">

            
<div class="checkbox">
<ct:if test="${not empty basicCourseList }">
 <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue[0] == 1}">
 <label> <input type="checkbox"  value="${listValue[2] }" name="BasicCourse"  id="${listValue[2] }"  onclick=" return myBasic();">${listValue[1]}</label><br>
 </ct:if>
 </ct:forEach>
</ct:if>

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
<ct:if test="${not empty basicCourseList }">
 <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue[0] == 2}">
 <label> <input type="checkbox" value="${listValue[2] }" name="AdvanceCourse" id="${listValue[2] }" onclick=" return myAdvance();">${listValue[1]}</label><br>
 </ct:if>
 </ct:forEach>
 </ct:if>
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
<ct:if test="${not empty basicCourseList }">
 <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue[0] == 3}">
 <label> <input type="checkbox"  value="${listValue[2] }" name="SpecialCourse"  id="${listValue[2] }"  onclick=" return mySpecial();">${listValue[1]}</label><br>
 </ct:if>
</ct:forEach>
</ct:if>
<cf:hidden path="SpecialCourse1" value=""/>
</div>
</div>              
<!-- right -->
<div class="col-md-6 col-xs-12"> </div>
</fieldset>
</div> --%>
                                                                <!-- special courses ends -->

                                                                <!-- button -->
                                                                <div class="col-xs-12">
                                                                    <!--  <div class="form-group">
                  <label><img src="img/captcha.jpg" class="img-responsive"></label>
                  <input type="text" class="form-control" placeholder="Captcha" required>
                </div> -->

                                                                    <div class="checkbox">
                                                                        <label>
                                                                            <!-- <input type="checkbox">
                    <a href="#" target="_blank" class="terms-font-size"> I have read and understood the Terms &amp; Conditions
                    and the Privacy Policy of FSSAI. </a> -->
                                                                        </label>
                                                                    </div>
                                                                </div>

                                                                <div class="row" style="height: 20px;"></div>
                                                                <!-- button -->

                                                                <div class="col-md-4 col-xs-12"></div>

                                                                <div class="col-md-4 col-xs-12">
                                                                    <a href="login.html">
                                                                        <input type="submit" class="form-control login-btn" value="Update" onclick="return ValidCaptcha();">
                                                                    </a>
                                                                </div>

                                                                <div class="col-md-4 col-xs-12"></div>

                                                        </form>

                                                    </div>
                                                    <div class="col-md-2 hidden-xs"></div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                            </div>
                        </div>
                    </section>
                </cf:form>
                <script type="text/javascript">
                    var gender = '${loginUr.gender}';
                    if (gender == 'M') {
                        document.getElementById('male').checked = true;
                    } else if (gender = 'F') {
                        document.getElementById('female').checked = true;
                    }

                </script>

               <!--  <script>
                    var id = localStorage.getItem('activeID');
                    document.getElementById(id).className = "active";

                </script> -->
