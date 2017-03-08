<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="website/js/commonController.js"></script>
            <script type="text/javascript">
                function OnStart() {
                    searchCity('ALL');
                }
                window.onload = OnStart;

            </script>
            <script type='text/javascript'>
                function searchCity(indicator) {
                    var stateId = ($("#stateId").val() == null ? "" : $("#stateId").val());
                    var districtName =( $("#districtId").val() == null ? "" : $("#districtId").val());
                    var cityName = ($("#cityName").val() == null ? "" : $("#cityName").val());
                    var status = $("#status").val();
                    $(".displayNone").css("display", "block"); {
                        var result = "";
                        var total = "";
                        if (indicator.match('ALL')) {
                            total = "stateId=0-districtName=0-cityName=-status=" + status;
                        } else {
                            total = "stateId=" + stateId + "-districtName=" + districtName + "-cityName=" + cityName + "-status=" + status;
                            console.log("total>" + total)
                        }
                    	var name1=JSON.stringify({
                    		courseType:0,
                    		courseName:0
                      })
                        $.ajax({
                            type: 'post',
                            url: 'searchCity.fssai?data=' + total,
                            contentType : "application/json",
                  		  	data:name1,
                            async: false,
                            success: function(data) {
                                $('#newTable').show();
                                var mainData1 = jQuery.parseJSON(data);
                                var j = 1;
                                $('#newTable tr').remove();
                                $('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>State Name</th><th>District Name</th><th>City Name</th><th>Status</th><th>Edit</th></tr>')
                                $.each(mainData1, function(i, obj) {
                                    var status;
                                    if (obj[3] == 'A') {
                                        status = 'Active';
                                    } else {
                                        status = 'In-Active';
                                    }
                                    $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td><input type="hidden" id="stateH" value="' + obj[6] + '">' + obj[0] + '</td><td><input type="hidden" id="districtH" value="' + obj[1] + '">' + obj[1] + '</td><td><input type="hidden" id="cityNameH" value="' + obj[2] + '">' + obj[2] + '</td><td><input type="hidden" id="statusH" value="' + obj[3] + '">' + status + '</td><td><input type="hidden" id="id" value="' + obj[4] + '"><a href="#" onclick="editCity(\'' + obj[6] + '\',\'' + obj[1] + '\',\'' + obj[2] + '\',\'' + obj[5] + '\',\'' + status + '\',\'' + obj[4] + '\');">edit</a></td><td><input type="hidden" id="districtHID" value="' + obj[5] + '"></tr>');
                                });
                            }
                        });
                        return result;
                    }
                }

                function editCity(state, district, city, districtHid, status, cityID) {
                    $('.error-red').html('');
                    document.getElementById('btnUpdate').style.display = 'block';
                    document.getElementById('btnCreate').style.display = 'none';

                    document.getElementById('idHidden').value = cityID;
                    
                    console.log("state " + state);
                    $("#stateId").val(state);
                    $("#stateId").trigger("change");
                    window.setTimeout(function() {
                        $('#districtId').val(districtHid);
                    }, 3000);
                    
                    $("#cityName").val(city);
                    $(".displayNone").css("display", "block");
                    $("#btnUpdate").css("display", "block");
                                    }

                function editCityData() {

                    var status = $("#status").val();
                    var cityId = $("#idHidden").val();
                    alert(cityId)
                    var cityName = $("#cityName").val();
                    var districtId = $("#districtId").val();
                    var showResponse = "";
                    document.getElementById('btnUpdate').style.display = 'none';
                    document.getElementById('btnCreate').style.display = 'block';
                    $(".displayNone").css("display", "block"); {
                        var result = "";
                        var total = "status=" + status + "-cityId=" + cityId + "-cityName=" + cityName + "-districtId=" + districtId;
                        var name1=JSON.stringify({
                    		courseType:0,
                    		courseName:0
                      })
                        $.ajax({
                            type: 'post',
                            async: false,
                            url: 'editCityData.fssai?data=' + total,
                            contentType : "application/json",
               		 	 	data:name1,
                            success: function(response) {
                                //  showResponse = response;

                            }
                        });
                        location.reload();
                        return true;

                    }

                }

                 </script>
            <script>
                function validateFields() {
                    if (document.getElementById("stateId").value == "0") {
                        document.getElementById('stateId').style.borderColor = "red";
                        document.getElementById("stateIdError").style.display = 'block';
                        document.getElementById("stateId").focus();
                        return false;
                    } else {
                        document.getElementById('stateId').style.borderColor = "#ccc";
                        document.getElementById("stateIdError").style.display = 'none';
                    }
                    if (document.getElementById("districtId").value == "0") {
                        document.getElementById('districtId').style.borderColor = "red";
                        document.getElementById("districtIdError").style.display = 'block';
                        document.getElementById("districtId").focus();
                        return false;
                    } else {
                        document.getElementById('districtId').style.borderColor = "#ccc";
                        document.getElementById("districtIdError").style.display = 'none';
                    }
                    if (document.getElementById("cityName").value == "") {
                        document.getElementById('cityName').style.borderColor = "red";
                        document.getElementById("cityNameError").style.display = 'block';
                        document.getElementById("cityName").focus();
                        return false;
                    } else {
                        document.getElementById('cityName').style.borderColor = "#ccc";
                        document.getElementById("cityNameError").style.display = 'none';
                    }
                }

            </script>
            <cf:form action="cityMasterSave.fssai" name="myForm" method="POST" commandName="cityMaster" onsubmit="return validateFields();">

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
                                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome TAdmin</span> </a>
                                            </div>
                                        </div>
                                        <!-- add the content here for main body -->
                                        <!-- timeline  -->
                                        <div class="row">

                                            <div class="col-xs-12">
                                                <h1>City Master</h1>
                                                <div class="row">
                                                    <div class="col-xs-12">

                                                        <!-- left side -->
                                                        <div class="col-xs-6">



                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>State Name:</strong></li>
                                                                        <li class="style-li error-red">${created }
                                                                            <label class="error visibility" id="stateIdError">select state</label>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:select path="stateId" class="form-control" onchange="getDistrict(this.value , 'districtId');">
                                                                    <cf:option value="0" label="Select State" />
                                                                    <cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
                                                                </cf:select>
                                                            </div>
                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>Status:</strong></li>
                                                                    </ul>
                                                                </div>
                                                                <cf:select path="status" class="form-control">
                                                                    <cf:option value="A" label="Active" />
                                                                    <cf:option value="I" label="In-Active" />
                                                                </cf:select>
                                                            </div>


                                                        </div>
                                                        <!-- left side ends -->

                                                        <!-- right side -->
                                                        <div class="col-xs-6">
                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>District Name:</strong></li>
                                                                        <li class="style-li error-red">
                                                                            <label class="error visibility" id="districtIdError">select district</label>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:select path="districtId" class="form-control">
                                                                    <cf:option value="0" label="Select District" />
                                                                    <cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName" />
                                                                </cf:select>
                                                            </div>
                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>City Name:</strong></li>
                                                                        <li class="style-li error-red">
                                                                            <label class="error visibility" id="cityNameError">enter city</label>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:input path="cityName" placeholder="City Name" class="form-control" />
                                                            </div>


                                                            <div class="form-group">
                                                                <button id="btnCreate" class="btn login-btn">Create</button>
                                                                <input type="hidden" id="idHidden" value="">

                                                                <a href="#" onclick="editCityData();" id="btnUpdate" style="display: none; padding: 6px 7px; width: 20%; margin-bottom: 0; font-size: 14px; 
font-weight: normal; line-height: 1.42857143; text-align: center; white-space: nowrap; vertical-align: middle;
 -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; -webkit-user-select: none; 
 -moz-user-select: none; -ms-user-select: none; user-select: none; background-image: none; border: 1px solid transparent;
  background: #ef580d !important; color: #fff; border: 1px solid transparent; transition: all 0.8s linear;">Update</a>


                                                                <a href="#testt" onclick="searchCity('SELECTED');" class="pull-right">Search</a>

                                                            </div>

                                                        </div>
                                                        <!-- rigth side ends -->

                                                        <!-- button -->


                                                    </div>


                                                </div>
                                            </div>

                                            <!-- search Results -->
                                            <div class="col-xs-12 displayNone" id="show-result" aria-expanded="false" style="height: 0px; display:none;">

                                                <!-- table -->
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <fieldset>
                                                            <legend>Search Result</legend>

                                                            <table id="newTable" class="table table-bordered table-responsive">
                                                                <thead>
                                                                    <tr class="background-open-vacancies">
                                                                        <th>S.No.</th>
                                                                        <th>City Name</th>
                                                                        <th>District Name</th>
                                                                        <th>State Name</th>
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
            </cf:form>
            <!-- <script>
                var id = localStorage.getItem('activeID');
                document.getElementById(id).className = "active";

            </script> -->
