<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
            <script>
                function OnStart() {
                    loadTrainingCenter();
                }
                window.onload = OnStart;

                function getCourseName(val) {
                    $('#selCourseName option').remove();
                    $.ajax({
                        type: 'post',
                        url: 'getCourseName.jspp?' + val,
                        success: function(response) {
                            var mainData1 = jQuery.parseJSON(response);
                            $('#selCourseName option').remove();
                            $('#selCourseName').append('<option value="0" label="--Select Course Code--" />');
                            $.each(mainData1, function(i, obj) {
                                $('#selCourseName').append('<option value=' + obj[0] + ' >' + obj[1] + '</option>');
                            });
                        }
                    });
                }

                function loadTrainingCenter() {
                    var trainingCenter = $("#userId").val();
                    $('#personalInformationTrainingPartnerId').val(trainingCenter);

                    $.ajax({

                        type: 'post',
                        url: 'loadFeedbackMaster.jspp',
                        success: function(response) {

                            var data = jQuery.parseJSON(response);
                            console.log("data " + data);
                            $('#trainee').append('<option value="0" label="--Select Trainee--" />');
                            $.each(data, function(i, obj) {
                                $('#trainee').append('<option value=' + obj[0] + ' >' + obj[1] + '</option>');
                            });

                        }

                    })

                }

            </script>
            <script>
                function showDetails() {
                    $("#viewfeedback > tbody").html("");
                    var courseType = $("#selCourseType").val();
                    var courseName = $("#selCourseName").val();
                    var trainee = $("#selTrainee").val();
                    /* var trainingDate = $("#traningDate").val();
                    var traningTime =  $("#traningTime").val();
                    var status = $('#selTraineeStatus').val(); */

                    //alert("courseType "+courseType);
                    /* alert("courseName "+courseName);
                    alert("trainingDate "+trainingDate);
                    alert("traningTime "+traningTime);
                    alert("status "+status);  */

                    $(".displayNone").css("display", "block");
                    //var	total = courseType+"&"+courseName+"&"+trainingDate+"&"+traningTime+"&"+status;
                    var total = courseType + "&" + courseName + "&" + trainee;
                    console.log("total " + total);
                    //var total = "";
                    var result = "";
                    $.ajax({
                        type: 'post',
                        url: 'traineeCenterViewFeedBack.jspp?' + total,
                        async: false,
                        success: function(data) {
                            $('#newTable').show();
                            //var mainData = JSON.stringify(data);
                            var mainData1 = jQuery.parseJSON(data);
                            var j = 1;
                            //$('#newTable tr').remove();
                            $.each(mainData1, function(i, obj) {
                                $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[0] + '</td><td>' + obj[1] + '</td><td>' + obj[2] + '</td><td>' + obj[3] + '</td><td>' + obj[4] + '</td></tr>');

                            });
                        }
                    });
                    return false;
                }

            </script>
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
                                                <input type="hidden" id="userId" value='${loginUsertrainingpartner}' />
                                                <i class="fa fa-bars"></i> <span class="orange-font">Welcome : ${loginUserS.loginDetails.loginId}</span>
                                            </a>
                                        </div>
                                    </div>
                                    <!-- add the content here for main body -->
                                    <!-- timeline  -->
                                    <div class="container-fluid">
                                        <div class="row">

                                            <!-- search and apply vacancies -->
                                            <div class="col-xs-12">
                                                <fieldset>
                                                    <legend>
                                                        <h3>Feedback Details</h3></legend>
                                                    <script type="text/javascript">
                                                        var formObj = '${trainingpartnerapplicationstatus}';
                                                        var formData = JSON.parse(formObj);
                                                        var courseTypes = formData.courseTypes;
                                                        var trainingCenterList = formData.trainingCenterList;
                                                        var traineeList = formData.traineeList;
                                                        console.log(trainingCenterList);

                                                    </script>

                                                    <div class="row">
                                                        <div class="col-xs-12">

                                                            <!-- left side -->
                                                            <div class="col-md-6 col-xs-12">
                                                                <div class="form-group">
                                                                    <div>
                                                                        <ul class="lab-no">
                                                                            <li class="style-li"><strong>Course Type:</strong></li>

                                                                        </ul>
                                                                    </div>
                                                                    <select class="form-control" onchange="getCourseName(this.value);" name="selCourseType" id="selCourseType"> </select>
                                                                </div>

                                                                <!-- <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Course Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="selCourseName" id = "selCourseName"> </select>
								 						
                                                    </div>
                                                    
                                                     <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Trainee Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                 
														<select class="form-control" name="trainee" id = "trainee"> </select>
                                                    </div> -->

                                                            </div>


                                                            <!-- right side -->
                                                            <div class="col-md-6 col-xs-12">
                                                                <div class="form-group">
                                                                    <div>
                                                                        <ul class="lab-no">
                                                                            <li class="style-li"><strong>Course Code:</strong></li>

                                                                        </ul>
                                                                    </div>
                                                                    <select class="form-control" name="selCourseName" id="selCourseName"> </select>

                                                                </div>

                                                                <div class="form-group">
                                                                    <div>
                                                                        <ul class="lab-no">
                                                                            <li class="style-li"><strong>Select Trainee:</strong></li>

                                                                        </ul>
                                                                    </div>
                                                                    <select class="form-control" name="selTrainee" id="selTrainee"> </select>
                                                                    <script>
                                                                        var selectctpeOptions = "<option disabled selected value> -- select trainee -- </option>";
                                                                        for (var i = 0; i < traineeList.length; i++) {
                                                                            selectctpeOptions += "<option value=" + traineeList[i].id + ">" + traineeList[i].value + "</option>"

                                                                        }
                                                                        document.getElementById('selTrainee').innerHTML += selectctpeOptions;

                                                                    </script>

                                                                </div>
                                                                <!-- <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Date:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="date" id="trainingdate" class="form-control">
                                                    </div>
                                                      <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Center Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control" name="TrainingCentreName" id = "personalInformationTrainingPartnerId"> </select>
														
                                                    </div> -->
                                                                <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="return showDetails();">Show Details</button>
                                                            </div>

                                                        </div>

                                                        <div class="col-md-3 hidden-xs"></div>
                                                    </div>
                                                </fieldset>
                                                <script>
                                                    var selectctpeOptions = "<option disabled selected value> -- select courseType -- </option>";
                                                    for (var i = 0; i < courseTypes.length; i++) {
                                                        console.log(courseTypes[i].CourseTypeId + " -- " + courseTypes[i].CourseType);
                                                        selectctpeOptions += "<option value=" + courseTypes[i].CourseTypeId + ">" + courseTypes[i].CourseType + "</option>"

                                                    }
                                                    document.getElementById('selCourseType').innerHTML += selectctpeOptions;
                                                    
                                                    var selectctTCpeOptions = "<option disabled selected value> -- select Training Center -- </option>";
                                                    for (var i = 0; i < trainingCenterList.length; i++) {
                                                        console.log(trainingCenterList[i].personalInformationTrainingPartnerId + " -- " + trainingCenterList[i].TrainingCentreName);
                                                        selectctTCpeOptions += "<option value=" + trainingCenterList[i].personalInformationTrainingPartnerId + ">" + trainingCenterList[i].TrainingCentreName + "</option>"

                                                    }
                                                    document.getElementById('personalInformationTrainingPartnerId').innerHTML += selectctTCpeOptions;

                                                </script>


                                            </div>

                                            <!--                                     search Results -->
                                            <!--                         search Results -->
                                            <!-- search Results -->
                                            <div class="col-xs-12 collapse table-overflow-responsive" id="show-result" aria-expanded="false" style="height: 0px;">
                                                <!-- table -->
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <fieldset style="margin-top: 20px;">
                                                            <legend>
                                                                <h4>Search results</h4>
                                                            </legend>
                                                            <div id="dvData">
                                                                <table id="viewfeedback" class="table table-bordered table-responsive table-striped table-hover">
                                                                    <thead>
                                                                        <tr class="background-open-vacancies">
                                                                            <th>S.No.</th>
                                                                            <th>Trainee</th>
                                                                            <th>Course Type</th>
                                                                            <th>Course Name</th>
                                                                            <th>Feedback Question</th>
                                                                            <th>Points</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody id="newTable">
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                            <!--  <a href="#" class="btn login-btn pull-right" onclick="saveDetails();">Save</a> -->
                                                        </fieldset>
                                                        <div style="width: 95px;">
                                                            <ul class="pager">
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <ul class="feed-no">
                                                    <li class="feed-li"><span><strong>1</strong></span>&nbsp;<span>Poor</span></li>
                                                    <li class="feed-li"><span><strong>2</strong></span>&nbsp;<span>Good</span></li>
                                                    <li class="feed-li"><span><strong>3</strong></span>&nbsp;<span>Better</span></li>
                                                    <li class="feed-li"><span><strong>4</strong></span>&nbsp;<span>Best</span></li>
                                                    <li class="feed-li"><span><strong>5</strong></span>&nbsp;<span>Excellent</span></li>
                                                </ul>
                                            </div>
                                            <%-- </cf:form> --%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </div>
                </div>
            </section>
            <!-- <script>
                var id = localStorage.getItem('activeID');
                document.getElementById(id).className = "active";

            </script> -->
