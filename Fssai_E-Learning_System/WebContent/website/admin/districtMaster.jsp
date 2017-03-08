<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
            <script type="text/javascript">
                function OnStart() {
                    onLoadDistrict();
                }
                window.onload = OnStart;

            </script>

            <script>
                function onLoadDistrict() {
                    var result = "";
                    var name1=JSON.stringify({
                		courseType:0,
                		courseName:0
                  })
                    $.ajax({
                        type: 'post',
                        url: 'onLoadDistrict.fssai?data=',
                        contentType : "application/json",
           		 	 	data:name1,
                        async: false,
                        success: function(data) {
                            $('#newTable').show();
                            var mainData1 = jQuery.parseJSON(data);
                            var j = 1;
                            $('#newTable tr').remove();
                            $('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>State Name</th><th>District Name</th><th>Status</th><th>Edit</th></tr>')
                            $.each(mainData1, function(i, obj) {
                                var status;
                                if (obj[2] == 'A') {
                                    status = 'Active';
                                } else {
                                    status = 'In-Active';
                                }
                                $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td><input type="hidden" id="stateName" value="' + obj[0] + '">' + obj[0] + '</td><td><input type="hidden" id="districtName" value="' + obj[1] + '">' + obj[1] + '</td><td><input type="hidden" id="statusLabel" value="' + status + '">' + status + '</td><td><input type="hidden" id="idCity" value="' + obj[3] + '" /><a href="#" onClick="editDistrict(\'' + obj[0] + '\',\'' + obj[1] + '\',\'' + status + '\',\'' + obj[3] + '\');">Edit</a></td></tr>');

                            });
                        }
                    });
                    return result;
                }

            </script>

            <script type='text/javascript'>
                function validateFields() {
                    $('.displayNone').css('display', 'block');
                    if (document.getElementById("stateId").value == "0") {
                        document.getElementById("stateId").style.borderColor = "red";
                        document.getElementById("stateIdError").style.display = 'block';
                        document.getElementById("stateId").focus();
                        return false;
                    } else {
                        document.getElementById('stateId').style.borderColor = "#ccc";
                        document.getElementById("stateIdError").style.display = 'none';
                    }
                    if (document.getElementById("DistrictName").value == "") {
                        document.getElementById("DistrictName").style.borderColor = "red";
                        document.getElementById("DistrictNameError").style.display = 'block';
                        document.getElementById("DistrictName").focus();
                        return false;
                    } else {
                        document.getElementById('DistrictName').style.borderColor = "#ccc";
                        document.getElementById("DistrictNameError").style.display = 'none';
                    }
                    if (document.getElementById("status").value == "0") {
                        document.getElementById("status").style.borderColor = "red";
                        document.getElementById("statusError").style.display = 'block';
                        document.getElementById("status").focus();
                        return false;
                    } else {
                        document.getElementById('status').style.borderColor = "#ccc";
                        document.getElementById("statusError").style.display = 'none';
                    }
                    return (true);
                }

                function updateDistrict() {

                }

            </script>

            <script type="text/javascript">
                function changeStatus() {
                    var districtLabel = $("#DistrictIdH").val();
                    console.log("districtLabel>>" + districtLabel);
                    var stateName = $("#stateName").val();
                    var disName = $("#DistrictName").val();
                    var statusLabel = $("#status").val();
                    document.getElementById('btnUpdate').style.display = 'none';
                    document.getElementById('btnCreate').style.display = 'block';
                    $(".displayNone").css("display", "block");
                    var total = "id=" + districtLabel + "-status=" + statusLabel + "-disName=" + disName + "-stateName=" + stateName;
                    var name1=JSON.stringify({
                		courseType:0,
                		courseName:0
                  })
                    $('#newTable').hide();
                    $.ajax({
                        type: 'post',
                        async: false,
                        url: 'changeStatusDistrict.fssai?data=' + total,
                        contentType : "application/json",
           		 	 	data:name1,
                        success: function(response) {
                            console.log("response " + response);
                            $('#name_status').html(response);
                        }
                    });
                    return true;

                    $("#newTable").empty();
                    onLoadDistrict();
                }



                function searchDistrict() {
                    $('.displayNone').css('display', 'block');
                    var stateId = $("#stateId").val();
                    console.log("stateId" + stateId);
                    var disName = $("#DistrictName").val();
                    var result = "";
                    var total = "stateId=" + stateId + "-disName=" + disName;
                    var name1=JSON.stringify({
                		courseType:0,
                		courseName:0
                  })
                    $.ajax({
                        type: 'post',
                        url: 'searchDistrict.fssai?data=' + total,
                        contentType : "application/json",
           		 	 	data:name1,
                        async: false,
                        success: function(data) {
                            $('#newTable').show();
                            var mainData1 = jQuery.parseJSON(data);
                            var j = 1;
                            $('#newTable tr').remove();
                            $('#newTable').append('<tr  class="background-open-vacancies" style="background-color:#000077;"><th>S.No.</th><th>State Name</th><th>District Name</th><th>Status</th><th>Edit</th></tr>')
                            $.each(mainData1, function(i, obj) {

                                var status;
                                if (obj[2] == 'A') {
                                    status = 'Active';
                                } else {
                                    status = 'In-Active';
                                }
                                $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td><input type="hidden" id="stateName" value="' + obj[0] + '">' + obj[0] + '</td><td><input type="hidden" id="stateName" value="' + obj[1] + '">' + obj[1] + '</td><td><input type="hidden" id="idCity" value="' + obj[0] + '"><a href="#" onclick="editDistrict(\'' + obj[0] + '\',\'' + obj[1] + '\',\'' + status + '\',\'' + obj[3] + '\');"">edit</a></td><td><a href="#" onclick="changeStatus();">' + status + '</a></td></tr>');
                            });
                        }
                    });
                    return result;
                }

                function editDistrict(state, districtName, statuslabel, distID) {

                    document.getElementById('btnUpdate').style.display = 'block';
                    document.getElementById('btnCreate').style.display = 'none';
                
                    document.getElementById('DistrictName').value = districtName;
                    document.getElementById('DistrictIdH').value = distID;
                
                    stateId.options[0].text = state;

                    console.log("status>" + statuslabel);
                    if (statuslabel == "Active") {
                        $('#status option').remove();
                        $('#status').append('<option value="A" selected="true">Active</option><option value="I">In-active</option>');
                    } else {
                        $('#status option').remove();
                        $('#status').append('<option value="A">Active</option><option value="I"  selected="true">In-active</option>');
                    }
                }

            </script>

            <cf:form action="districtMasterSave.fssai" name="myForm" method="POST" commandName="districtMaster" onsubmit="return validateFields();">


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
                                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Admin</span> </a>
                                            </div>
                                        </div>
                                        <!-- add the content here for main body -->
                                        <!-- timeline  -->
                                        <div class="row">

                                            <div class="col-xs-12">
                                                <h1>District Master</h1>
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
                                                                <cf:select path="stateId" class="form-control">
                                                                    <cf:option value="0" label="Select State" />
                                                                    <cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
                                                                </cf:select>
                                                            </div>


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
                                                        <!-- left side ends -->

                                                        <!-- right side -->
                                                        <div class="col-xs-6">

                                                            <div class="form-group">
                                                                <div>
                                                                    <ul class="lab-no">
                                                                        <li class="style-li"><strong>District Name:
                                                            <span style="color:red;">*</span>
                                                            </strong></li>
                                                                        <li class="style-li error-red">
                                                                            <label class="error visibility" id="DistrictNameError">error</label>

                                                                        </li>
                                                                    </ul>
                                                                </div>
                                                                <cf:input path="DistrictName" placeholder="District Name" class="form-control" />

                                                            </div>


                                                        </div>
                                                        <!-- rigth side ends -->

                                                        <!-- button -->

                                                        <div class="row">
                                                            <div class="col-md-6 hidden-xs"></div>
                                                            <!-- create button -->
                                                            <div class="col-md-3 col-xs-12">
                                                                <input type="hidden" id="DistrictIdH" value="" />
                                                                <input type="submit" id="btnCreate" class="btn login-btn" value="Create" />
                                                                <a href="" onclick="changeStatus();" id="btnUpdate" style="display: none; padding: 6px 7px; width: 40%; 
margin-bottom: 0; font-size: 14px; font-weight: normal; line-height: 1.42857143; 
text-align: center; white-space: nowrap; vertical-align: middle; 
-ms-touch-action: manipulation; touch-action: manipulation; cursor: pointer; 
-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; 
user-select: none; background-image: none; border: 1px solid transparent; 
background: #ef580d !important; color: #fff; border: 1px solid transparent; 
transition: all 0.8s linear;">
Update</a>
                                                                <a href="#" onclick="searchDistrict();" class="pull-right">Search</a>

                                                            </div>
                                                            <!-- show details -->



                                                        </div>
                                                        <!-- button row ends -->
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
                                                                        <th>S.No.</th>
                                                                        <th>State Name</th>
                                                                        <th>District Name</th>
                                                                        <th>Option</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <%-- <ct:forEach var="listValue" items="${districtShowList}" varStatus="loop"><tr>
<td>${loop.count} </td>
<td>loop[0] </td>
<td>
<label>${listValue }</label>
<input type="hidden"   id="labelStateName" value="${listValue }" /></td>

<td>
<label>${listValue }</label>
<input type="hidden"  id="labelStatus" value="${listValue}" /></td>

<td><a href="#" onclick="deleteState();">delete</a>
&nbsp;&nbsp;&nbsp;
<a href="#" onclick="editState();">
<input type="hidden" name="districtIdd" id="stateIdd"  value="${listValue}"/>edit</a>
</td>
</tr>
 </ct:forEach> --%>


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
