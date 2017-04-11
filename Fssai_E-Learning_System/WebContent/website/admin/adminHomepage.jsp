<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <<style>
<!--

#myDIV {
text-align: center;
  width: 146px;
  height: 171px;
  margin: 5px;
  float: left;
  overflow: hidden;
  position: relative;
  background: #888;
  color: #222;
  -webkit-border-top-right-radius: 1.2em;
      -moz-border-radius-topright: 1.2em;
          border-top-right-radius: 1.2em;
  display:inline-block;
}

.font-dashboard {
	    font-size: 20px;
}

.element .symbol {
 left: 0.2em;
    top: 0.4em;
    font-size: 3.8em;
    line-height: 1.0em;
    color: #FFF;
}

.number {
		text-align: center;
       font-size: 4.25em;
    font-weight: bold;
    color: hsla(0,0%,0%,.5);
    right: 0.5em;
    top: 0.5em;
        margin-top: 10px;
}
.clickable .element:hover {
  cursor: pointer;
}

.clickable .element:hover h3 {
  text-shadow:
    0 0 10px white,
    0 0 10px white
  ;
}

-->
</style>
            <script type="text/javascript">
                function OnStart() {
                    searchAssessmentAgencyList();
                }
                window.onload = OnStart;

            </script>
            <script type="text/javascript">
                function searchAssessmentAgencyList() {
                    document.getElementById("detailListOfAssessor").style.display = 'none';
                	var name1=JSON.stringify({
                		courseName:0
                  })
                    var result = "";
                    $.ajax({
                        type: 'post',
                        url: 'searchAssessmentAgencyList.fssai?data=',
                        contentType : "application/json",
              		  	data:name1,
                        async: false,
                        success: function(data) {
                            $('#newTable').show();
                            //var mainData = JSON.stringify(data);
                            var mainData1 = jQuery.parseJSON(data);
                            var j = 1;
                            $('#newTable tr').remove();
                            $('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Number of Assessor IDs</th></tr>')
                            $.each(mainData1, function(i, obj) {
                                $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[1] + '</td><td><input type="hidden" id="assessmentAgencyId" value="' + obj[0] + '" /><a href="#" onclick="showDetail();">' + obj[2] + '</a></td></tr>');

                            });
                        }
                    });
                    return result;
                }


                function showDetail() {

                    document.getElementById("detailListOfAssessor").style.display = 'block';
                    var result = "";
                    var id = document.getElementById("assessmentAgencyId").value;
                 	var name1=JSON.stringify({
                		courseName:0
                  })
                    $.ajax({
                        type: 'post',
                        url: 'searchAssessorDetail.fssai?data=' + id,
                        contentType : "application/json",
              		  	data:name1,
                        async: false,
                        success: function(data) {
                            $('#newTable1').show();
                            //var mainData = JSON.stringify(data);
                            var mainData1 = jQuery.parseJSON(data);
                            //alert(mainData1);
                            var j = 1;
                            $('#newTable1 tr').remove();
                            $('#newTable1').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Assessor Name</th><th>Assessor Id</th><th>Activate</th></tr>')
                            $.each(mainData1, function(i, obj) {
                                $('#newTable1').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[0] + '</td><td>' + obj[1] + '</td><td>' + obj[2] + '</td><td><input type="hidden" id="statusHidden' + obj[4] + '" value="' + obj[3] + '"/><input type="hidden" id="assessorId' + obj[4] + '" value="' + obj[4] + '" /><button onclick="statusChange(' + obj[4] + ');return false;"> Activate</button></td></tr>');
                                console.log(obj[0] + " -" + obj[1] + " -" + obj[2] + " -" + obj[3] + " -" + obj[4]);

                            });
                        }
                    });
                    return result;
                }

                </script>

<script >
                function statusChange(elementId) {
                
                	var result = "";
                    var id = document.getElementById("assessorId" + elementId).value;
                    var status = document.getElementById("statusHidden" + elementId).value;
                    var total = "id=" + id + "@status=" + status;
                	var name1=JSON.stringify({
                		courseName:0
                  })
                    $.ajax({
                        type: 'post',
                        url: 'changeAssessor.fssai?data=' + total,
                        contentType : "application/json",
              		  	data:name1,
                        async: false,
                        success: function(data) {
                            $('#name_status').html(response);
                            $('#newTable1').hide();
                        }
                    });
                    showDetail();
                    return result;
                }

                </script>
            

            <!-- <script>
                var id = localStorage.getItem('activeID');
                document.getElementById(id).className = "active";

            </script> -->


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
                                            <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i>
                                                <span class="orange-font">Welcome ${userName}</span> </a>
                                        </div>
                                    </div>
                                    <!-- add the content here for main body -->
                                    <!-- timeline  -->
                                    <div class="row" id="conclusionListOfAssessment">
                                    
                                    
                                    
                                    <fieldset>
                                    
                                    <div id="myDIV" style="background-color: #f2dede;;">
                                      <p class="number">${traineeCount}</p>
                                      <h3 class="symbol font-dashboard"><a href="traineeUserManagementForm.fssai?Name=callSubmit"> Trainee</a></h3>
                                      </div>&nbsp;&nbsp;
                                     <div id="myDIV" style="background-color: #dff0d8;">
                                      <p class="number">${trainerCount}</p>
                                      <h3 class="symbol font-dashboard"><a href="trainerUserManagementForm.fssai?Name=callSubmit">Trainer</a></h3> 
									</div>&nbsp;&nbsp;
                                      <div id="myDIV" style="background-color: e6e6e6;">
                                         <p class="number">${trainingCenterCount}</p>
                                      <h3 class="symbol font-dashboard"><a href="trainingCenterUserManagementForm.fssai?Name=callSubmit">Training Center</a></h3>
                                       </div>&nbsp;&nbsp;
                                       <div id="myDIV" style="background-color: #fcf8e3;"> 
                                        <p class="number ">${trainingPartnerCount}</p>
                                      <h3 class="symbol font-dashboard"><a href="manageTrainingPartnerForm.fssai?Name=callSubmit">Training Partner</a></h3>
                                       </div>&nbsp;&nbsp;
                                        <div id="myDIV" style="background-color: rgba(77, 144, 254, 0.39);"> 
                                         <p class="number">${assessorCount}</p>
                                      	<h3 class="symbol font-dashboard"><a href="assessorUserManagementForm.fssai?Name=callSubmit">Assessor</a></h3>
                                        </div>&nbsp;&nbsp;
                                       <div id="myDIV" style="background-color: #c0c0c0;"> 
                                        <p class="number">${assessmentagencyCount}</p>
                                      	<h3 class="symbol font-dashboard"><a href="manageAssessmentAgencyForm.fssai?Name=callSubmit">Assessment Agency</a></h3>
                                       </div>&nbsp;&nbsp;
                                    
                                    </fieldset>
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                        <div class="col-xs-12">
                                            <fieldset>
                                                <legend>Pending Assessor ID Activation</legend>

                                                <table id="newTable" class="table-bordered table table-responsive table-hover">
                                                    <thead>
                                                        <tr class="background-open-vacancies">
                                                            <td>S. No.</td>
                                                            <td>Assessment Agency Name</td>
                                                            <td>Number of Assessor IDs</td>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    </tbody>
                                                </table>
                                            </fieldset>
                                        </div>


                                        <div class="col-md-2 hidden-xs"></div>
                                    </div>




                                    <div class="row" id="detailListOfAssessor">
                                        <div class="col-xs-12">
                                            <span id=name_status "></span>
                                <div class="page-header ">
                                    <h1 id="timeline">List of Pending Assessor ID Activation</h1> </div>
                                <table id="newTable1"  class="table-bordered table-hover table table-responsive ">
                                    <thead>
                                        <tr class="background-open-vacancies ">
                                            <td>S. No.</td>
                                            <td>Assessment Agency Name</td>
                                            <td>Assessor Name</td>
                                            <td>Assessor ID</td>
                                            <td>Status</td>
                                            <td>Detail</td>
                                        </tr>
                                    </thead>
                                   <tbody></tbody>
                                </table>
<!--                                 <div class="col-xs-12 pull-right "> -->
<!--                                     <input style="margin-top:20px; width:100px; " type="button " class="form-control login-btn btn " value="Activate " /> </div> -->
<!--                             </div> -->
                            <div class="col-md-2 hidden-xs "></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
