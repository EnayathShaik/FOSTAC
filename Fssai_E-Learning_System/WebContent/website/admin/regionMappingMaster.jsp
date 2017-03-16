<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="website/js/commonController.js"></script>
            <script type="text/javascript">
                function OnStart() {
                    onLoadRegion();
                }
                window.onload = OnStart;

            </script>
            <script type='text/javascript'>
                function editRegion(distid, stateid, regionid, cityid, regionName, status) {
                   
                    document.getElementById('btnUpdate').style.display = 'block';
                    document.getElementById('btnCreate').style.display = 'none';
                    document.getElementById('stateId').value = stateid;
                    $("#stateId").trigger("change");
                    window.setTimeout(function() {
                        $('#districtId').val(distid);
                        
                        $("#districtId").trigger("change");
                        
                        window.setTimeout(function() {
                            $('#cityId').val(cityid);
                        }, 1000);

                    }, 1000);
                   
                   
                  //  document.getElementById('cityId').value = cityid;
                    document.getElementById('RegionidH').value = regionid;


                    document.getElementById('regionName').value = regionName;
                    document.getElementById('status').value = status;
                    

                    if (status == "Active") {
                        $('#status option').remove();
                        $('#status').append('<option value="A" selected="true">Active</option><option value="I">In-active</option>');
                    } else {
                        $('#status option').remove();
                        $('#status').append('<option value="A">Active</option><option value="I"  selected="true">In-active</option>');
                    }
                }



                function onLoadRegion() {
                    $('#newTable').show();
                    $('#newTable tr').remove();
                    var name1=JSON.stringify({
                		courseType:0,
                		courseName:0
                  })
                    $.ajax({
                        type: 'post',
                        url: 'onLoadRegion.fssai?data=',
                        contentType : "application/json",
           		 	 	data:name1,
                        async: false,
                        success: function(data) {
                            $('#newTable').show();
                            var mainData1 = jQuery.parseJSON(data);
                           
                            var j = 1;
                            $('#newTable tr').remove();
                            $('#newTable').append('<tr  class="background-open-vacancies" style="background-color:#000077;"><th>S.No.</th><th>State Name</th><th>District Name</th><th>City Name</th><th>Region Name</th><th>Status</th><th>Edit</th></tr>')
                            $.each(mainData1, function(i, obj) {

                                var status;

                                if (obj[8] == 'A') {
                                    status = 'Active';
                                } else {
                                    status = 'In-Active';
                                }
                                $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[3] + '</td><td>' + obj[0] + '</td><td>' + obj[4] + '</td><td>' + obj[1] + '</td><td><input type="hidden" id="statusLabel" value="' + status + '">' + status + '</td><td><a href="#" onclick="editRegion(\'' + obj[6] + '\',\'' + obj[7] + '\',\'' + obj[2] + '\',\'' + obj[5] + '\',\'' + obj[1] + '\',\'' + status + '\');">edit</a></td></tr>');
                            });
                        }
                    });

                }

            </script>
            <script type="text/javascript">
                function editRegionData() {
                    var status = $("#status").val();

                    var regionId = $("#RegionidH").val();

                    var regionName = $('#regionName').val();

                    var stateName = $('#stateId').val();
                    var districtName = $('#districtId').val();
                    var cityName = $('#cityId').val();
                    document.getElementById('btnUpdate').style.display = 'none';
                    document.getElementById('btnCreate').style.display = 'block';
                    $(".displayNone").css("display", "block"); {
                        var result = "";
                        var total = "regionId=" + regionId + "-regionName=" + regionName + "-status=" + status + "-stateName=" + stateName + "-districtName=" + districtName + "-cityName=" + cityName + "";
                        //alert(total);
                        $('#newTable').hide();
                        var name1=JSON.stringify({
                    		courseType:0,
                    		courseName:0
                      })
                        $.ajax({
                            type: 'post',

                            url: 'editRegionData.fssai?data=' + total,
                            contentType : "application/json",
               		 	 	data:name1,
                            async: false,
                            success: function(response) {
                            	$('#regionMappingMaster')[0].reset();
                                $('#name_status').html(response);
                            }
                        });
                        //alert (result);
                        location.reload();
                        onLoadRegion();
                        return true;

                    }
                }


              


                function validateFields() {
                    $('.displayNone').css('display', 'block');
                    if (document.getElementById("regionName").value == "") {
                        document.getElementById("regionName").style.borderColor = "red";
                        document.getElementById("regionNameError").style.display = 'block';
                        document.getElementById("regionName").focus();
                        return false;
                    } else {
                        document.getElementById('regionName').style.borderColor = "#ccc";
                        document.getElementById("regionNameError").style.display = 'none';
                    }
                    if (document.getElementById("districtId").value == "0") {
                        document.getElementById("districtId").style.borderColor = "red";
                        document.getElementById("regionNameError").style.display = 'block';
                        document.getElementById("districtId").focus();
                        return false;
                    } else {
                        document.getElementById('districtId').style.borderColor = "#ccc";
                        document.getElementById("districtIdError").style.display = 'none';
                    }
                    return (true);
                }

                function searchRegion() {
                    var regionName = $("#regionName").val();

                    var stateId = $("#stateId").val();
                    var districtName = $("#districtId").val();
                    var cityId = $("#cityId").val();
                    var status = $("#status").val(); {
                        var result = "";

                        var total = "stateId=" + stateId + "&districtName=" + districtName + "&cityName=" + cityId + "&status=" + status + "&regionName=" + regionName;
                        $.ajax({
                            type: 'post',
                            url: 'searchRegion.jspp?' + total,
                            async: false,
                            success: function(data) {

                                $('#newTable').show();
                                var mainData1 = jQuery.parseJSON(data);
                                var j = 1;
                                $('#newTable tr').remove();
                                $('#newTable').append('<tr  class="background-open-vacancies" style="background-color:#000077;"><th>S.No.</th><th>State</th><th>District</th><th>City</th><th>Region Name</th></tr>')
                                $.each(mainData1, function(i, obj) {
                                    $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[1] + '</td><td>' + obj[2] + '</td><td>' + obj[3] + '</td><td>' + obj[4] + '</td></tr>');
                                });
                            }
                        });
                        return result;
                    }
                    $("#regionNameError").css("display", "none");
                }

            </script>
            <cf:form action="regionMasterSave.fssai" name="myForm" method="POST" id="regionMappingMaster" commandName="regionMappingMaster" onsubmit="return validateFields();">

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
                                                <h1>Region Mapping</h1>
                                                <div class="row">
                                                    <div class="col-xs-12">

                                                        <!-- left side -->
                                                        <div class="col-xs-6">

                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>State Name:
                                                            <span style="color:red;">*</span>
                                                            </strong></li>
                                                                        <li class="style-li error-red">
                                                                            <label id="created" class="error">${created }</label>
                                                                            <label class="error visibility" id="stateIdError"> error</label>
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
                                                                        <li class="style-li"><strong>City Name:
                                                            <span style="color:red;">*</span>
                                                            </strong></li>
                                                                        <li class="style-li error-red">
                                                                            <label id="created" class="error"></label>
                                                                            <label class="error visibility" id="stateIdError"> error</label>
                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:select path="cityId" class="form-control">
                                                                    <cf:option value="0" label="Select City" />
                                                                    <cf:options items="${cityList}" itemValue="cityId" itemLabel="cityName" />
                                                                </cf:select>

                                                                <div class="form-group">
                                                                    <div>
                                                                        <ul class="lab-no">
                                                                            <li class="style-li"><strong>Status:
                                                            <span style="color:red;">*</span>
                                                            </strong></li>
                                                                            <li class="style-li error-red">
                                                                                <label class="error visibility" id="statusError">error</label>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                    <cf:select path="status" class="form-control">
                                                                        <cf:option value="A" label="Active" />
                                                                        <cf:option value="I" label="In-Active" />
                                                                    </cf:select>
                                                                </div>

                                                            </div>




                                                        </div>
                                                        <!-- left side ends -->

                                                        <!-- right side -->
                                                        <div class="col-xs-6">

                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>District:</strong></li>
                                                                        <li class="style-li error-red"></li>
                                                                    </ul>
                                                                </div>
                                                                <cf:select path="districtId" id="districtId" class="form-control" onchange="getCity(this.value , 'cityId');">
                                                                    <cf:option value="0" label="Select District" />
                                                                    <cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName" />
                                                                </cf:select>
                                                            </div>
                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>Region Name:</strong></li>
                                                                        <li class="style-li error-red">
                                                                            <label class="error visibility" id="regionNameError">* error</label>
                                                                        </li>
                                                                    </ul>

                                                                </div>


                                                                <cf:input path="regionName" placeholder="Region Name" class="form-control" />
                                                                <div class="form-group">
                                                                    <button id="btnCreate" style="margin-top:71px;" class="btn login-btn">Create</button>
                                                                    <a href="#testt" style="margin-top: 36px;margin-left: 108px;margin-bottom: -33px;" onclick="searchRegion();" class="btn login-btn">Search</a>
                                                                    <input type="hidden" id="RegionidH" value="">

                                                                    <a href="#" onclick="editRegionData();" id="btnUpdate" style="display: none; padding: 6px 7px; width: 20%; margin-bottom: 0; font-size: 14px; 
font-weight: normal; line-height: 1.42857143; text-align: center; white-space: nowrap; vertical-align: middle;
 -ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; -webkit-user-select: none; 
 -moz-user-select: none; -ms-user-select: none; user-select: none; background-image: none; border: 1px solid transparent;
  background: #ef580d !important; color: #fff; border: 1px solid transparent; transition: all 0.8s linear;">Update</a>

                                                                    <!--  <a href="#testt" onclick="searchRegion();"  class="btn login-btn">Search</a>-->
                                                                </div>
                                                            </div>
                                                            <!-- rigth side ends -->
                                                        </div>
                                                        <!-- button -->
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
                                    </div>

                                    <!-- search Results -->
                                    <div class="col-xs-12 displayNone" id="show-result" aria-expanded="false" style="height: 0px;">

                                        <!-- table -->
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <fieldset>
                                                    <legend>Search Result</legend>

                                                    <table id="newTable" class="table table-bordered table-responsive">
                                                        <thead>
                                                            <tr class="background-open-vacancies">
                                                                <th> </th>
                                                                <th>S.No.</th>
                                                                <th>Region Name</th>
                                                                <th>District</th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>

                                                        </tbody>
                                                    </table>

                                                    <!-- + - buttons -->
                                                    <!--  <div class="row">
                                                    <div class="col-md-6 col-xs-12">
                                                        <div style="width: 95px;">
                                                            <ul class="pager">
                                                                <li class="previous"><a href="#"><i class="fa fa-plus"></i></a></li>
                                                                <li class="next"><a href="#"><i class="fa fa-minus"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="col-md-6 col-xs-12">
                                                        <button class="btn login-btn pull-right" style="margin-top: 20px;">Save</button>
                                                    </div>
                                                </div> -->



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
