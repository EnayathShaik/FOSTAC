<%@page import="java.util.List"%>
    <%@page import="org.hibernate.Query"%>
        <%@page import="org.hibernate.Session"%>
            <%@page import="org.hibernate.SessionFactory"%>
                <%@page import="org.hibernate.cfg.Configuration"%>
                    <%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
                        <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
                            <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
                            <script src="website/js/commonController.js"></script>

                                <script type="text/javascript">
                                    function validateFields() {
                                        if (document.getElementById("TrainingCenterCorrespondenceLine1").value == "") {
                                            document.getElementById('TrainingCenterCorrespondenceLine1').style.borderColor = "red";
                                            document.getElementById("TrainingCenterCorrespondenceLine1Error").style.display = 'block';
                                            document.getElementById("TrainingCenterCorrespondenceLine1").focus();
                                            return false;
                                        } else {
                                            document.getElementById('TrainingCenterCorrespondenceLine1').style.borderColor = "#ccc";
                                            document.getElementById("TrainingCenterCorrespondenceLine1Error").style.display = 'none';
                                        }

                                        if (document.getElementById("TrainingCenterCorrespondenceLine2").value == "") {
                                            document.getElementById('TrainingCenterCorrespondenceLine2').style.borderColor = "red";
                                            document.getElementById("TrainingCenterCorrespondenceLine2Error").style.display = 'block';
                                            document.getElementById("TrainingCenterCorrespondenceLine2").focus();
                                            return false;
                                        } else {
                                            document.getElementById('TrainingCenterCorrespondenceLine2').style.borderColor = "#ccc";
                                            document.getElementById("TrainingCenterCorrespondenceLine2Error").style.display = 'none';
                                        }


                                        if (document.getElementById("TrainingCenterCorrespondenceState").selectedIndex == 0) {
                                            document.getElementById('TrainingCenterCorrespondenceState').style.borderColor = "red";
                                            document.getElementById("TrainingCenterCorrespondenceStateError").style.display = 'block';
                                            document.getElementById("TrainingCenterCorrespondenceState").focus();
                                            return false;
                                        } else {
                                            document.getElementById('TrainingCenterCorrespondenceState').style.borderColor = "#ccc";
                                            document.getElementById("TrainingCenterCorrespondenceStateError").style.display = 'none';
                                        }

                                        if (document.getElementById("TrainingCenterCorrespondenceDistrict").selectedIndex == 0) {
                                            document.getElementById('TrainingCenterCorrespondenceDistrict').style.borderColor = "red";
                                            document.getElementById("TrainingCenterCorrespondenceDistrictError").style.display = 'block';
                                            document.getElementById("TrainingCenterCorrespondenceDistrict").focus();
                                            return false;
                                        } else {
                                            document.getElementById('TrainingCenterCorrespondenceDistrict').style.borderColor = "#ccc";
                                            document.getElementById("TrainingCenterCorrespondenceDistrictError").style.display = 'none';
                                        }

                                        if (document.getElementById("TrainingCenterCorrespondenceCity").selectedIndex == 0) {
                                            document.getElementById('TrainingCenterCorrespondenceCity').style.borderColor = "red";
                                            document.getElementById("TrainingCenterCorrespondenceCityError").style.display = 'block';
                                            document.getElementById("TrainingCenterCorrespondenceCity").focus();
                                            return false;
                                        } else {
                                            document.getElementById('TrainingCenterCorrespondenceCity').style.borderColor = "#ccc";
                                            document.getElementById("TrainingCenterCorrespondenceCityError").style.display = 'none';
                                        }

                                        var x = document.getElementById("TrainingCenterCorrespondencePincode").value;
                                        if (x == "" || x.length < 6) {
                                            document.getElementById('TrainingCenterCorrespondencePincode').style.borderColor = "red";
                                            document.getElementById("TrainingCenterCorrespondencePincodeError").style.display = 'block';
                                            document.getElementById("TrainingCenterCorrespondencePincode").focus();
                                            return false;
                                        } else {
                                            document.getElementById('TrainingCenterCorrespondencePincode').style.borderColor = "#ccc";
                                            document.getElementById("TrainingCenterCorrespondencePincodeError").style.display = 'none';
                                        }

                                        var x = document.getElementById('TrainingCenterPermanentEmail').value;
                                        // if(x!=''){
                                        var atpos = x.indexOf("@");
                                        var dotpos = x.lastIndexOf(".");
                                        if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
                                            document.getElementById('TrainingCenterPermanentEmail').style.borderColor = "red";
                                            document.getElementById("TrainingCenterPermanentEmailError").style.display = 'block';
                                            document.getElementById("TrainingCenterPermanentEmail").focus();
                                            return false;
                                            //}
                                        } else {
                                            document.getElementById('TrainingCenterPermanentEmail').style.borderColor = "#ccc";
                                            document.getElementById("TrainingCenterPermanentEmailError").style.display = 'none';
                                        }
                                        var x = document.getElementById("TrainingCenterPermanentMobile").value;
                                        //if(x!=''){

                                        if (x.length < 10 || x.length > 10) {

                                            document.getElementById('TrainingCenterPermanentMobile').style.borderColor = "red";
                                            document.getElementById("TrainingCenterPermanentMobileError").style.display = 'block';
                                            document.getElementById("TrainingCenterPermanentMobile").focus();
                                            return false;
                                            //    	}
                                        } else {
                                            document.getElementById('TrainingCenterPermanentMobile').style.borderColor = "#ccc";
                                            document.getElementById("TrainingCenterPermanentMobileError").style.display = 'none';
                                        }

                                        if (document.getElementById('checkPermanent').checked == false) {



                                            if (document.getElementById("TrainingCenterPermanentLine1").value == "") {
                                                document.getElementById('TrainingCenterPermanentLine1').style.borderColor = "red";
                                                document.getElementById("TrainingCenterPermanentLine1Error").style.display = 'block';
                                                document.getElementById("TrainingCenterPermanentLine1").focus();
                                                return false;
                                            } else {
                                                document.getElementById('TrainingCenterPermanentLine1').style.borderColor = "#ccc";
                                                document.getElementById("TrainingCenterPermanentLine1Error").style.display = 'none';
                                            }

                                            if (document.getElementById("TrainingCenterPermanentLine2").value == "") {
                                                document.getElementById('TrainingCenterPermanentLine2').style.borderColor = "red";
                                                document.getElementById("TrainingCenterPermanentLine2Error").style.display = 'block';
                                                document.getElementById("TrainingCenterPermanentLine2").focus();
                                                return false;
                                            } else {
                                                document.getElementById('TrainingCenterPermanentLine2').style.borderColor = "#ccc";
                                                document.getElementById("TrainingCenterPermanentLine2Error").style.display = 'none';
                                            }


                                            if (document.getElementById("TrainingCenterPermanentState").selectedIndex == 0) {
                                                document.getElementById('TrainingCenterPermanentState').style.borderColor = "red";
                                                document.getElementById("TrainingCenterPermanentStateError").style.display = 'block';
                                                document.getElementById("TrainingCenterPermanentState").focus();
                                                return false;
                                            } else {
                                                document.getElementById('TrainingCenterPermanentState').style.borderColor = "#ccc";
                                                document.getElementById("TrainingCenterPermanentStateError").style.display = 'none';
                                            }

                                            if (document.getElementById("TrainingCenterPermanentDistrict").selectedIndex == 0) {
                                                document.getElementById('TrainingCenterPermanentDistrict').style.borderColor = "red";
                                                document.getElementById("TrainingCenterPermanentDistrictError").style.display = 'block';
                                                document.getElementById("TrainingCenterPermanentDistrict").focus();
                                                return false;
                                            } else {
                                                document.getElementById('TrainingCenterPermanentDistrict').style.borderColor = "#ccc";
                                                document.getElementById("TrainingCenterPermanentDistrictError").style.display = 'none';
                                            }

                                            if (document.getElementById("TrainingCenterPermanentCity").selectedIndex == 0) {
                                                document.getElementById('TrainingCenterPermanentCity').style.borderColor = "red";
                                                document.getElementById("TrainingCenterPermanentCityError").style.display = 'block';
                                                document.getElementById("TrainingCenterPermanentCity").focus();
                                                return false;
                                            } else {
                                                document.getElementById('TrainingCenterPermanentCity').style.borderColor = "#ccc";
                                                document.getElementById("TrainingCenterPermanentCityError").style.display = 'none';
                                            }



                                            var x = document.getElementById("TrainingCenterPermanentPincode").value;
                                            if (x == "" || x.length < 6) {
                                                document.getElementById('TrainingCenterPermanentPincode').style.borderColor = "red";
                                                document.getElementById("TrainingCenterPermanentPincodeError").style.display = 'block';
                                                document.getElementById("TrainingCenterPermanentPincode").focus();
                                                return false;
                                            } else {
                                                document.getElementById('TrainingCenterPermanentPincode').style.borderColor = "#ccc";
                                                document.getElementById("TrainingCenterPermanentPincodeError").style.display = 'none';
                                            }

                                        }

                                        if (document.getElementById("FoodSafetyExpBackground").selectedIndex == 0) {
                                            document.getElementById('FoodSafetyExpBackground').style.borderColor = "red";
                                            document.getElementById("FoodSafetyExpBackgroundError").style.display = 'block';
                                            document.getElementById("FoodSafetyExpBackground").focus();
                                            return false;
                                        } else {
                                            document.getElementById('FoodSafetyExpBackground').style.borderColor = "#ccc";
                                            document.getElementById("FoodSafetyExpBackgroundError").style.display = 'none';
                                        }

                                        if (document.getElementById("ExpInFoodSafefyTimeMonth").selectedIndex == 0) {
                                            document.getElementById('ExpInFoodSafefyTimeMonth').style.borderColor = "red";
                                            document.getElementById("ExpInFoodSafefyTimeMonthError").style.display = 'block';
                                            document.getElementById("ExpInFoodSafefyTimeMonth").focus();
                                            return false;
                                        } else {
                                            document.getElementById('ExpInFoodSafefyTimeMonth').style.borderColor = "#ccc";
                                            document.getElementById("ExpInFoodSafefyTimeMonthError").style.display = 'none';
                                        }

                                        if (document.getElementById("NoOfTrainingSessionConducted").value == "") {
                                            document.getElementById('NoOfTrainingSessionConducted').style.borderColor = "red";
                                            document.getElementById("NoOfTrainingSessionConductedError").style.display = 'block';
                                            document.getElementById("NoOfTrainingSessionConducted").focus();
                                            return false;
                                        } else {
                                            document.getElementById('NoOfTrainingSessionConducted').style.borderColor = "#ccc";
                                            document.getElementById("NoOfTrainingSessionConductedError").style.display = 'none';
                                        }

                                        if (document.getElementById("TrainingSessionWishToConduct").value == 0) {
                                            document.getElementById('TrainingSessionWishToConduct').style.borderColor = "red";
                                            document.getElementById("TrainingSessionWishToConductError").style.display = 'block';
                                            document.getElementById("TrainingSessionWishToConduct").focus();
                                            return false;
                                        } else {
                                            document.getElementById('TrainingSessionWishToConduct').style.borderColor = "#ccc";
                                            document.getElementById("TrainingSessionWishToConductError").style.display = 'none';
                                        }

                                        return true;








                                    }

                                </script>
                                <script type="text/javascript">
                                    function preventBack() {
                                        window.history.forward();
                                    }
                                    setTimeout("preventBack()", 0);
                                    window.onunload = function() {
                                        null
                                    };

                                </script>

                                <script>
                                    function getstateid() {

                                        getstat2();
                                        getstateid1();
                                    }
                                    window.onload = getstateid;

                                </script>
                                <script>
                                    function getstateid1() {


                                        //var psid = ${stateid};
                                        var psid = '${loginUr.permanentstate.stateId}';
                                        var psname = '${loginUr.permanentstate.stateName}';
                                        var pdid = '${loginUr.permanentdistrict.districtId}';
                                        var pdname = '${loginUr.permanentdistrict.districtName}';
                                        var pcid = '${loginUr.permanentcity.cityId}';
                                        var pcname = '${loginUr.permanentcity.cityName}';
                                        var title = '${loginUr.title.titleId}';
                                        //var tp = '${tp}';
                                        var tp = '${trainingPartnerID}';
										
                                        var safety = '${loginUr.foodSafetyExpBackground}';
                                        var month=${loginUr.expInFoodSafefyTimeMonth};
                                   
                                        $("#FoodSafetyExpBackground").prop('selectedIndex', safety);
                                        $("#ExpInFoodSafefyTimeMonth").prop('selectedIndex', month);
                              
                                        getStateUpdate(psid, pdid, pcid);

                                       
                                        $("#Title").prop('value', title);
                                        $("#associatedTrainingpartnerName").val(tp);
                                     
                                        //associatedTrainingpartnerName.options[0].text = tp;
                                    }

                                    function getStateUpdate(psid, pdid, pcid) {
                                        $.ajax({
                                            type: 'post',
                                            url: 'getStateUpdate.jspp',
                                            success: function(response) {
                                                var mainData2 = jQuery.parseJSON(response);
                                                $('#TrainingCenterPermanentState option').remove();
                                                $('#TrainingCenterPermanentState').append('<option value="0" label="Select Stateeeeee" />');

                                                $.each(mainData2, function(i, obj) {
                                                    if (psid == obj.stateId) {
                                                        $('#TrainingCenterPermanentState').append('<option selected="true" value=' + obj.stateId + '>' + obj.stateName + '</option>');
                                                    } else {
                                                        $('#TrainingCenterPermanentState').append('<option value=' + obj.stateId + '>' + obj.stateName + '</option>');
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
                                                $('#TrainingCenterPermanentDistrict option').remove();
                                                $('#TrainingCenterPermanentDistrict').append('<option value="0" label="Select District" />');

                                                $.each(mainData1, function(i, obj) {
                                                    if (dd == obj.districtId) {
                                                        $('#TrainingCenterPermanentDistrict').append('<option  selected="true" value=' + obj.districtId + '>' + obj.districtName + '</option>');
                                                    } else {
                                                        $('#TrainingCenterPermanentDistrict').append('<option value=' + obj.districtId + '>' + obj.districtName + '</option>');
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
                                                $('#TrainingCenterPermanentCity option').remove();
                                                $('#TrainingCenterPermanentCity').append('<option value="0" label="Select City" />');

                                                $.each(mainData1, function(i, obj) {
                                                    if (cc == obj.cityId) {
                                                        $('#TrainingCenterPermanentCity').append('<option selected="true" value=' + obj.cityId + '>' + obj.cityName + '</option>');
                                                    } else {
                                                        $('#TrainingCenterPermanentCity').append('<option value=' + obj.cityId + '>' + obj.cityName + '</option>');
                                                    }
                                                });
                                            }
                                        });

                                    }


                                    function getstat2() {
                                        var csid = '${loginUr.correspondencestate.stateId}';
                                        var csname = '${loginUr.correspondencestate.stateName}';
                                        var cdid = '${loginUr.correspondencedistrict.districtId}';

                                        var cdname = '${loginUr.correspondencedistrict.districtName}';
                                        var ccid = '${loginUr.correspondencecity.cityId}';
                                        var ccname = '${loginUr.correspondencecity.cityName}';
                                        //var trainingPartnerName='${loginUr.associatedTrainingpartnerName.trainingPartnerName}';
                                        //TrainingCenterCorrespondenceState.options[0].text = csname;
                                        // TrainingCenterCorrespondenceDistrict.options[0].text = cdname;
                                        //TrainingCenterCorrespondenceCity.options[0].text = ccname;
                                        getCorrespondanceStateUpdate(csid, cdid, ccid, cdname);
                                        /* associatedTrainingpartnerName.options[0].text = trainingPartnerName; */
                                    }

                                    function getCorrespondanceStateUpdate(csid, cdid, ccid, cdname) {
                                        $.ajax({
                                            type: 'post',
                                            url: 'getStateUpdate.jspp',
                                            success: function(response) {
                                                var mainData2 = jQuery.parseJSON(response);
                                                $('#TrainingCenterCorrespondenceState option').remove();
                                                $('#TrainingCenterCorrespondenceState').append('<option value="0" label="Select Stateeeeee" />');

                                                $.each(mainData2, function(i, obj) {
                                                    if (csid == obj.stateId) {
                                                        $('#TrainingCenterCorrespondenceState').append('<option selected="true" value=' + obj.stateId + '>' + obj.stateName + '</option>');
                                                    } else {
                                                        $('#TrainingCenterCorrespondenceState').append('<option value=' + obj.stateId + '>' + obj.stateName + '</option>');
                                                    }
                                                });
                                            }
                                        });
                                        CorrDistrictUpdate(csid, cdid, ccid, cdname);
                                    }

                                    function CorrDistrictUpdate(csid, cdid, ccid, cdname) {
                                        $.ajax({
                                            type: 'post',
                                            url: 'getDistrictUpdate.jspp?' + csid,
                                            success: function(response) {
                                                var mainData1 = jQuery.parseJSON(response);
                                                $('#TrainingCenterCorrespondenceDistrict option').remove();
                                                $('#TrainingCenterCorrespondenceDistrict').append('<option value="0" label="Select District" />');

                                                $.each(mainData1, function(i, obj) {

                                                    // $("#TrainingCenterCorrespondenceDistrict").prop('selectedIndex', cdid);
                                                    if (cdid == obj.districtId) {
                                                        //TrainingCenterCorrespondenceDistrict.options[0].text = cdname;
                                                        $('#TrainingCenterCorrespondenceDistrict').append('<option selected="true" value=' + obj.districtId + '>' + obj.districtName + '</option>');

                                                    } else {
                                                        $('#TrainingCenterCorrespondenceDistrict').append('<option value=' + obj.districtId + '>' + obj.districtName + '</option>');
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
                                                $('#TrainingCenterCorrespondenceCity option').remove();
                                                $('#TrainingCenterCorrespondenceCity').append('<option value="0" label="Select City" />');

                                                $.each(mainData1, function(i, obj) {
                                                    if (ccid == obj.cityId) {
                                                        $('#TrainingCenterCorrespondenceCity').append('<option selected="true" value=' + obj.cityId + '>' + obj.cityName + '</option>');
                                                    } else {
                                                        $('#TrainingCenterCorrespondenceCity').append('<option value=' + obj.cityId + '>' + obj.cityName + '</option>');
                                                    }
                                                });
                                            }
                                        });
                                    }

                                </script>


                                <script>

                                    function myCheckPermanent() {
                                        var x = document.getElementById('checkPermanent').checked;
                                        permanent1.style.display = checkPermanent.checked ? "none" : "block";
                                        permanent2.style.display = checkPermanent.checked ? "none" : "block";
                                        if (x == true) {
                                            document.getElementById('TrainingCenterPermanentLine1').value = document.getElementById('TrainingCenterCorrespondenceLine1').value;
                                            document.getElementById('TrainingCenterPermanentLine2').value = document.getElementById('TrainingCenterCorrespondenceLine2').value;
                                            document.getElementById('TrainingCenterPermanentPincode').value = document.getElementById('TrainingCenterCorrespondencePincode').value;
                                            document.getElementById('').value = document.getElementById('').value;
                                            document.getElementById('').value = document.getElementById('').value;
                                            document.getElementById('').value = document.getElementById('').value;
                                        }
                                        if (x == false) {
                                            /* document.getElementById('TrainingCenterCorrespondenceLine1').value= "";
                                            document.getElementById('TrainingCenterCorrespondenceLine2').value= "";
                                            document.getElementById('TrainingCenterCorrespondencePincode').value= ""; */
                                            document.getElementById('TrainingCenterPermanentLine1').value = "";
                                            document.getElementById('TrainingCenterPermanentLine2').value = "";
                                            document.getElementById('TrainingCenterPermanentPincode').value = "";
                                            document.getElementById('').value = document.getElementById('').value = "";
                                            document.getElementById('').value = document.getElementById('').value = "";
                                            document.getElementById('').value = document.getElementById('').value = "";
                                        }
                                    }

                                </script>

                                <!-- horizontal navigation -->
                                <cf:form action="updateTrainer11.fssai?id=${loginUr.personalInformationTrainerId}" name="myForm" method="POST" commandName="updateInformation" onsubmit="return validateFields();">
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
                                                                    <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${loginUr.loginDetails.loginId}</span> </a>
                                                                </div>
                                                            </div>
                                                            <!-- add the content here for main body -->
                                                            <!-- timeline  -->
                                                            <div class="container-fluid">
                                                                <div class="row">
                                                                    <div class="col-xs-12">
                                                                        <form>
                                                                            <!-- personal info -->
                                                                            <div class="personel-info">
                                                                                <fieldset>
                                                                                    <legend>
                                                                                        <h3>Personal Information</h3> </legend>
                                                                                    <!-- left side -->
                                                                                    <div class="col-md-6 col-xs-12">

                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>User Id:</strong></li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <input type="text" class="form-control" disabled="disabled" value="${loginUr.loginDetails.loginId}">
                                                                                        </div>

                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Aadhar:</strong></li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <input type="text" class="form-control" placeholder="Aadhar Number" disabled="disabled" value="${loginUr.aadharNumber}">
                                                                                        </div>

                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Date of Birth:</strong></li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <input type="text" class="form-control" placeholder="Date" disabled="disabled" value="${loginUr.DOB}">
                                                                                        </div>



                                                                                        <!-- <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Upload Your Profile:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <input type="file" id="myFile">
                                                    </div> -->



                                                                                        <div class="form-group">
                                                                                            <!--  <label>Gender</label>
                                                        <br />
                                                        <label class="radio-inline">
                                                            <input type="radio" name="optradio"> Yes </label>
                                                        <label class="radio-inline">
                                                            <input type="radio" name="optradio"> No </label> -->
                                                                                            <label class="radio-inline">
                                                                                                <cf:radiobutton path="gender" id="male" value="M" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                <cf:radiobutton path="gender" id="female" value="F" />Female
                                                                                            </label>
                                                                                        </div>

                                                                                    </div>
                                                                                    <!-- right side -->
                                                                                    <div class="col-md-6 col-xs-12">
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Title:</strong></li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <cf:select path="Title" class="form-control" disabled="true">

                                                                                                <cf:options items="${titleList}" itemValue="titleId" itemLabel="titleName" />
                                                                                            </cf:select>
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>First Name:</strong></li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <input type="text" class="form-control" placeholder="First Name" disabled="disabled" value="${loginUr.firstName}"> </div>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Middle Name:</strong></li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <input type="text" class="form-control" placeholder="Middle Name" disabled="disabled" value="${loginUr.middleName}"> </div>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Last Name:</strong></li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <input type="text" class="form-control" placeholder="Last Name" disabled="disabled" value="${loginUr.lastName}"> </div>

                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Father Name:</strong></li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <input type="text" class="form-control" placeholder="Father Name" disabled="disabled" value="${loginUr.fathername}"> </div>

                                                                                    </div>
                                                                                </fieldset>
                                                                            </div>
                                                                            <div class="row" style="height: 20px;"> </div>
                                                                            <!-- contact details -->
                                                                            <div class="personel-info">
                                                                                <fieldset>
                                                                                    <legend>
                                                                                        <h3>Contact Information</h3> </legend>
                                                                                    <!-- permanent address -->
                                                                                    <!--Left side-->
                                                                                    <div class="col-md-6 col-xs-12">
                                                                                        <h4>Correspondence Address</h4>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Correspondence Address Line 1:</strong></li>
                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="TrainingCenterCorrespondenceLine1Error" class="error visibility">* enter your TrainingCenterCorrespondence1</label>
                                                                                                        <cf:errors path="TrainingCenterCorrespondenceLine1" cssclass="error" />
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <cf:input type="text" class="form-control" maxlength="100" path="TrainingCenterCorrespondenceLine1" placeholder="Training Center Line 1" value="${loginUr.trainingCenterCorrespondenceLine1}" /> </div>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Correspondence Address Line 2:</strong></li>
                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="TrainingCenterCorrespondenceLine2Error" class="error visibility">* enter your TrainingCenterCorrespondence2</label>
                                                                                                        <cf:errors path="TrainingCenterCorrespondenceLine2" cssclass="error" />
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <cf:input type="text" class="form-control" maxlength="100" path="TrainingCenterCorrespondenceLine2" placeholder="Training Center Line 2" value="${loginUr.trainingCenterCorrespondenceLine2}" /> </div>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>State:</strong></li>
                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="TrainingCenterCorrespondenceStateError" class="error visibility">* enter your TrainingCenterCorrespondenceState</label>
                                                                                                        <cf:errors path="TrainingCenterCorrespondenceState" cssclass="error" />
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <cf:select path="TrainingCenterCorrespondenceState" class="form-control" onchange="getDistrict(this.value , 'TrainingCenterCorrespondenceDistrict');">
                                                                                                <cf:option value="0" label="Select State" />
                                                                                                <cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
                                                                                            </cf:select>
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>District:</strong></li>
                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="TrainingCenterCorrespondenceDistrictError" class="error visibility">* enter your TrainingCenterCorrespondenceDistrict</label>
                                                                                                        <cf:errors path="TrainingCenterCorrespondenceDistrict" cssclass="error" />
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <cf:select path="TrainingCenterCorrespondenceDistrict" class="form-control" onchange="getCity(this.value , 'TrainingCenterCorrespondenceCity');">
                                                                                                <cf:option value="0" label="Select District" />
                                                                                                <%-- <cf:options items="${districtList}" itemValue="districtId" --%>itemLabel="districtName" />
                                                                                            </cf:select>
                                                                                        </div>
                                                                                    </div>
                                                                                    <!-- left side ends -->
                                                                                    <!-- right side -->
                                                                                    <div class="col-md-6 col-xs-12">
                                                                                        <h5><br>
                          </h5>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Closest City:</strong></li>
                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="TrainingCenterCorrespondenceCityError" class="error visibility">* enter your TrainingCenterCorrespondenceCity</label>
                                                                                                        <cf:errors path="TrainingCenterCorrespondenceCity" cssclass="error" />
                                                                                                    </li>
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
                                                                                                    <li class="style-li"><strong>PIN Code:</strong></li>
                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="TrainingCenterCorrespondencePincodeError" class="error visibility">* enter your TrainingCenterCorrespondencePincode</label>
                                                                                                        <cf:errors path="TrainingCenterCorrespondencePincode" cssclass="error" />
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <cf:input type="text" class="form-control" maxlength="6" path="TrainingCenterCorrespondencePincode" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Pincode" value="${loginUr.trainingCenterCorrespondencePincode}" /> </div>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Email:</strong></li>
                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="TrainingCenterPermanentEmailError" class="error visibility">* enter your Email</label>
                                                                                                        <cf:errors path="TrainingCenterPermanentEmail" cssclass="error" />
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <cf:input type="text" class="form-control" path="TrainingCenterPermanentEmail" placeholder="Email" value="${loginUr.trainingCenterPermanentEmail}" /> </div>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Mobile:</strong></li>
                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="TrainingCenterPermanentMobileError" class="error visibility">* enter your TrainingCenterPermanentMobile</label>
                                                                                                        <cf:errors path="TrainingCenterPermanentMobile" cssclass="error" />
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <cf:input type="text" class="form-control" maxlength="10" path="TrainingCenterPermanentMobile" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Mobile" value="${loginUr.trainingCenterPermanentMobile}" /> </div>
                                                                                    </div>
                                                                                    <!-- right side ends -->
                                                                                    <!-- permanent address ends -->
                                                                                    <!-- selection -->
                                                                                    <%-- <div class="col-xs-12">
                                                    <div class="form-group">
                                                        <!-- <label>Is your correspondence address same as permanent address</label>
                                                        <br>
                                                        <label class="radio-inline">
                                                            <input type="radio" name="optradio"> Yes </label>
                                                        <label class="radio-inline">
  
                                                            <input type="radio" name="optradio"> No </label> -->
  <input type="checkbox" id="checkPermanent" onclick="myCheckPermanent(this)"> <label class = "error">Is your permanent address same as correspondence address.</label>                                                           
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
                                                                <li class="style-li"><strong>Permanent Adddress Line 1:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" path="TrainingCenterPermanentLine1" placeholder="Training Center Line 1" value="${loginUr.trainingCenterPermanentLine1}"/> </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Permanent Adddress Line 2:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" path="trainingCenterPermanentLine2" placeholder="Training Center Line 2" value="${loginUr.trainingCenterPermanentLine2}"/> </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>State:</strong></li>
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
                                                <div class="col-md-6 col-xs-12">
                                                    <h5><br>
                          </h5>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>District:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <cf:select path="TrainingCenterPermanentDistrict" class="form-control"  onchange="getCityList(this.value);">
<cf:option value="0" label="Select District" />
<cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName" />
</cf:select>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Closest City:</strong></li>
                                                            </ul>
                                                        </div>
                                                       <cf:select path="TrainingCenterPermanentCity" class="form-control">
<cf:option value="0" label="Select City" />
<cf:options items="${cityList}" itemValue="cityId" itemLabel="cityName" />
</cf:select>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>PIN Code:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" path="TrainingCenterPermanentPincode" placeholder="Pincode" value="${loginUr.trainingCenterPermanentPincode}"/> </div>
                                                </div>
                                                <!-- right side ends -->
                                            </fieldset>
                       --%>



                                                                            </div>

                                                                            <fieldset>
                                                                                <legend>Permanent Address</legend>

                                                                                <div class="col-xs-12">
                                                                                    <div class="col-md-12 col-sm-12 col-x-sm-12">
                                                                                        <ct:choose>
                                                                                            <ct:when test="${loginUr.checkAddress == true }">
                                                                                                <input type="checkbox" id="checkPermanent" onclick="myCheckPermanent(this)" checked="checked">
                                                                                                <label class="error">Is your permanent address same as correspondence address.</label>
                                                                                            </ct:when>
                                                                                            <ct:otherwise>
                                                                                                <input type="checkbox" id="checkPermanent" onclick="myCheckPermanent(this)">
                                                                                                <label class="error">Is your permanent address same as correspondence address.</label>
                                                                                            </ct:otherwise>
                                                                                        </ct:choose>

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
                                                                                                    <cf:errors path="TrainingCenterPermanentLine1" cssclass="error" />
                                                                                                </li>
                                                                                            </ul>
                                                                                        </div>
                                                                                        <cf:input path="TrainingCenterPermanentLine1" maxlength="100" placeholder="Address Line 1" class="form-control" value="${loginUr.trainingCenterPermanentLine1}" />
                                                                                    </div>

                                                                                    <div class="form-group">
                                                                                        <div>
                                                                                            <ul class="lab-no">
                                                                                                <li class="style-li"><strong><cs:message code="lbl.Trainer.TrainingCenterPermanentLine2" /></strong></li>
                                                                                                <li class="style-li error-red">
                                                                                                    <label id="TrainingCenterPermanentLine2Error" class="error visibility">* enter your Permanent Training Center</label>
                                                                                                    <cf:errors path="TrainingCenterPermanentLine2" cssclass="error" />
                                                                                                </li>
                                                                                            </ul>
                                                                                        </div>
                                                                                        <cf:input path="TrainingCenterPermanentLine2" maxlength="100" placeholder="Address Line 2" class="form-control" value="${loginUr.trainingCenterPermanentLine2}" />
                                                                                    </div>

                                                                                    <div class="form-group">
                                                                                        <div>
                                                                                            <ul class="lab-no">
                                                                                                <li class="style-li"><strong><cs:message code="lbl.Trainee.State" /></strong></li>
                                                                                                <li class="style-li error-red">
                                                                                                    <label class="error visibility" id="TrainingCenterPermanentStateError">Please select state</label>
                                                                                                    <cf:errors path="TrainingCenterPermanentState" cssclass="error" />
                                                                                                </li>
                                                                                            </ul>
                                                                                        </div>
                                                                                        <cf:select path="TrainingCenterPermanentState" class="form-control" onchange="getDistrict(this.value, 'TrainingCenterPermanentDistrict');">
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
                                                                                                    <cf:errors path="TrainingCenterPermanentDistrict" cssclass="error" />
                                                                                                </li>
                                                                                            </ul>
                                                                                        </div>
                                                                                        <cf:select path="TrainingCenterPermanentDistrict" class="form-control" onchange="getCity(this.value , 'TrainingCenterPermanentCity');">
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
                                                                                                    <cf:errors path="TrainingCenterPermanentCity" cssclass="error" />
                                                                                                </li>
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
                                                                                                    <cf:errors path="TrainingCenterPermanentPincode" cssclass="error" />
                                                                                                </li>
                                                                                            </ul>
                                                                                        </div>
                                                                                        <%-- <cf:input path="TrainingCenterPermanentPincode" name="TrainingCenterPermanentPincode" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Pincode" class="form-control" type="text" value="" maxlength="6" value="${loginUr.trainingCenterPermanentPincode}"/> --%>
                                                                                            <cf:input type="text" class="form-control" maxlength="6" path="TrainingCenterPermanentPincode" placeholder="Pincode" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,&#39;&#39;)" value="${loginUr.trainingCenterPermanentPincode}" />
                                                                                    </div>


                                                                                </div>
                                                                                <!-- right side ends -->
                                                                            </fieldset>
                                                                            <!-- contact details ends -->
                                                                            <div class="row" style="height: 20px;"> </div>
                                                                            <!-- Experience Detais -->
                                                                            <div class="personel-info">
                                                                                <fieldset>
                                                                                    <legend>
                                                                                        <h3>Experience Details</h3> </legend>
                                                                                    <!-- left side -->
                                                                                    <div class="col-md-6 col-xs-12">
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>Food Safety Experience Background:</strong></li>
                                                                                                    <li class="style-li error-red"> </li>
                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="FoodSafetyExpBackgroundError" class="error visibility">* enter your FoodSafetyExpBackground</label>
                                                                                                        <cf:errors path="FoodSafetyExpBackground" cssclass="error" />
                                                                                                    </li>
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
                                                                                                    <li class="style-li"><strong>Experience in Food Safety Experience:</strong></li>
                                                                                                    <li class="style-li error-red"> </li>

                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="ExpInFoodSafefyTimeYearError" class="error visibility">* enter your FoodSafetyExpBackground</label>
                                                                                                        <cf:errors path="ExpInFoodSafefyTimeYear" cssclass="error" />
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <div class="row">
                                                                                                <div class="col-xs-6">
                                                                                                    <!-- <select class="form-control" required>
                                                                    <option>Select Year</option>
                                                                    <option>2001</option>
                                                                    <option>2002</option>
                                                                    <option>2003</option>
                                                                    <option>2004</option>
                                                                    <option>2005</option>
                                                                </select> -->
                                                                                                    <cf:input type="text" name="experienceyear" path="ExpInFoodSafefyTimeYear" value="${loginUr.expInFoodSafefyTimeYear}" style="height:40px;border-Color:red" />
                                                                                                </div>
                                                                                                <div class="col-xs-6">

                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="ExpInFoodSafefyTimeMonthError" class="error visibility">* enter your ExpInFoodSafefyTimeMonth</label>
                                                                                                        <cf:errors path="ExpInFoodSafefyTimeMonth" cssclass="error" />
                                                                                                    </li>
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
                                                                                                    </cf:select>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>No. Of Training Sessions Conducted:</strong></li>
                                                                                                    <li class="style-li error-red"> </li>

                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="NoOfTrainingSessionConductedError" class="error visibility">* enter your NoOfTrainingSessionConducted</label>
                                                                                                        <cf:errors path="NoOfTrainingSessionConducted" cssclass="error" />
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                            <cf:input type="text" class="form-control" path="NoOfTrainingSessionConducted" placeholder="Session Number" value="${loginUr.noOfTrainingSessionConducted}" /> </div>
                                                                                    </div>
                                                                                    <!-- left side ends -->
                                                                                    <!-- right side -->
                                                                                    <div class="col-md-6 col-xs-12">
                                                                                        <div class="form-group">
                                                                                            <label>How Many Trainings (4Hrs) Sessions Wish To Conduct in a Month ?</label>
                                                                                            <li class="style-li error-red">
                                                                                                <label id="TrainingSessionWishToConductError" class="error visibility">* enter your TrainingSessionWishToConduct</label>
                                                                                                <cf:errors path="TrainingSessionWishToConduct" cssclass="error" />
                                                                                            </li>
                                                                                            <cf:input type="text" class="form-control" path="TrainingSessionWishToConduct" placeholder="Session Number" value="${loginUr.trainingSessionWishToConduct}" /> </div>
                                                                                        <div class="form-group">
                                                                                            <label>Associated with any Training Partner ?</label>
                                                                                            <br />
                                                                                            <!--  <label class="radio-inline">
                                                            <input type="radio" name="optradio"> Yes </label>
                                                        <label class="radio-inline">
                                                            <input type="radio" name="optradio"> No </label> -->
                                                                                            <label class="radio-inline">
                                                                                                <cf:radiobutton path="AssociatedWithAnyTrainingPartner" value="Y" checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                                                <cf:radiobutton path="AssociatedWithAnyTrainingPartner" value="N" />No</td>
                                                                                            </label>
                                                                                        </div>
                                                                                        <div class="form-group">
                                                                                            <div>
                                                                                                <ul class="lab-no">
                                                                                                    <li class="style-li"><strong>If Yes Training Partner Name:</strong></li>
                                                                                                    <li class="style-li error-red"> </li>
                                                                                                    <li class="style-li error-red">
                                                                                                        <label id="associatedTrainingpartnerNameError" class="error visibility">* enter your associatedTrainingpartnerName</label>
                                                                                                        <cf:errors path="associatedTrainingpartnerName" cssclass="error" />
                                                                                                    </li>
                                                                                                </ul>
                                                                                            </div>
                                                                                        <%--     <cf:input type="text" class="form-control" path="associatedTrainingpartnerName" placeholder="Partner Name"  value="${loginUr.associatedTrainingpartnerName}"/> --%> 

                                                                                                <cf:select path="associatedTrainingpartnerName" id="associatedTrainingpartnerName" name ="associatedTrainingpartnerName" class="form-control">
                                                                                                    <cf:options items="${trainingPartnerList}" itemValue="manageTrainingPartnerId" itemLabel="trainingPartnerName" />
                                                                                                </cf:select> 

                                                                                        </div>
                                                                                    </div>
                                                                                    <!-- right side ends -->
                                                                                </fieldset>
                                                                            </div>
                                                                            <div class="row" style="height: 20px;"> </div>

                                                                            <!-- special course -->
                                                                            <div class="row" style="height: 20px;"> </div>
                                                                            <div class="col-xs-12">
                                                                                <!-- <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> <a href="#" target="_blank" class="terms-font-size"> I have read and understood the Terms &amp; Conditions
                          and the Privacy Policy of FSSAI. </a> </label>
                                            </div> -->
                                                                            </div>
                                                                            <div class="col-md-4 hidden-xs"></div>
                                                                            <div class="col-md-4 col-xs-12">
                                                                                <div class="pull-right">
                                                                                    <div class="form-group">
                                                                                        <input type="submit" class="form-control login-btn" value="Update">
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4 hidden-xs"></div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                            </div>
                                        </div>
                                    </section>
                                </cf:form>
                                <!-- scripts -->

                                <script type="text/javascript">
                                    var gender = '${loginUr.gender}';
                                    if (gender == 'M') {
                                        document.getElementById('male').checked = true;
                                    } else if (gender = 'F') {
                                        document.getElementById('female').checked = true;
                                    }

                                </script>

                                <!-- <script>
                                    var id = localStorage.getItem('activeID');
                                    document.getElementById(id).className = "active";

                                </script> -->
