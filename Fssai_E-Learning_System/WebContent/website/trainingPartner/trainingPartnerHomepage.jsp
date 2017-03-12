<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
            <script type="text/javascript">
                function OnStart() {
                	window.trainingcenterId = ${loginUsertrainingpartner};
                    searchUpcomingTraining();
                    searchCurrentAppliactionStatus();
                }
                window.onload = OnStart;
                

            </script>
            <script type="text/javascript">
                function searchCurrentAppliactionStatus() {
           
                    var data = JSON.stringify({
                     /*    courseType: 0,
                        courseName: 0, */
                        name:window.trainingcenterId
                    })

                    $.ajax({
                        type: 'post',
                        url: 'getApplicationStatusDetails.fssai',
                        contentType: "application/json",
                        data: data,
                        success: function(response) {
                        	
                            response = JSON.parse(response);
                            for (index = 0; index < response.length; index++) {
                                console.log(response[index]);
                                $('#applicaionStatus').append('<tr>'+
                                   		'<td>'+(index+1)+'</td>'+
                                   	    '<td>'+response[index].courseCode+'</td>'+
                                   	    '<td>'+response[index].trainingStartDate+'</td>'+
                                   	 '<td>'+response[index].trainingEndDate+'</td>'+
                                   	     '<td>'+response[index].noOfVacancy+'</td>'+
                                   	    '<td><a  href="editApplicationStatusDetails.fssai?postvacancyID='+response[index].loginId+'">'+response[index].noOfApplications+'</td> '+
                                   	  	'</tr>');
                            }
                        }
                    });

                }


                function confirmStatus(trainingCenterID) {
                    var data = JSON.stringify({
                        id: trainingCenterID
                    });
                    $.ajax({
                        type: 'post',
                        url: 'updateUpcomingTrainingsStatus.fssai',
                        contentType: "application/json",
                        data: data,
                        success: function(response) {
                            response = JSON.parse(response);
                            if (response.message == "OK") {
                                searchUpcomingTraining();

                            }

                        }
                    });
                }

                function searchUpcomingTraining() {

                	var name1=JSON.stringify({
                		courseType:0,
                		courseName:0
                  })
                    var result = "";
                    $.ajax({
                        type: 'post',
                        url: 'searchUpcomingTraining.fssai?data='+window.trainingcenterId,
                        contentType : "application/json",
              		  	data:name1,
                        async: false,
                        success: function(data) {
                            $('#newTable').show();
                            //var mainData = JSON.stringify(data);
                            var mainData1 = jQuery.parseJSON(data);
                            // 		alert(mainData1);
                            var j = 1;
                            $('#newTable tr').remove();
                            $('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Course Code</th><th>Batch Code</th><th>Training Date</th><th>No. Of Seats</th><th>No. Of Enrollments</th></tr>')
                            $.each(mainData1, function(i, obj) {
                               /*  var a = null;
                                var statuss = obj[9];
                                if (statuss == "A") {
                                    a = "Confirmed";
                                } else {
                                    a = '<a href="#"  onClick=confirmStatus(' + obj[0] + '); id=confirm_' + obj[0] + ' >Confirm</a>';
                                } */
                                $('#newTable').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[10] + '</td><td>' + obj[11] + '</td><td>' + obj[2] + '</td><td>' + obj[6] + '</td><td>' + obj[5] + '</td></tr>');

                            });
                        }
                    });
                    return result;
                }

            </script>
            <section>
                <div class="container-fluid">
                    <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
                        <div class="container">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="navbar-header">
                                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                                    </div>
                                    <%@include file="../roles/top-menu.jsp"%>
                                        <!--/.nav-collapse -->
                                </div>
                            </div>
                        </div>
                    </nav>
                </div>
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
                                    <div class="container-fluid">
                                        <div class="row">
                                            <!-- upcoming trainings -->
                                            <div class="col-xs-12 collapse in" id="show-result" aria-expanded="true" style="">
                                                <div class="personel-info">
                                                    <div class="row">
                                                        <div class="col-xs-12 table-overflow-responsive">
                                                            <fieldset>
                                                                <legend>
                                                                    <h3>Upcoming Trainings</h3>
                                                                </legend>
                                                                <table id="newTable" class="table table-bordered table-responsive table-striped table-hover">
                                                                    <thead>
                                                                        <tr class="background-open-vacancies">
                                                                            <th>S.No</th>
                                                                            <th>Course Type</th>
                                                                            <th>Course Name</th>
                                                                            <th>Training Date</th>
                                                                            <th>No. of Seats</th>
                                                                            <th>No. Of Enrollments</th>
                                                                            <th>Required Seats</th>
                                                                            <th>Confirm Status</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                    </tbody>
                                                                </table>
                                                            </fieldset>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- table -->
                                            </div>

                                            <!-- current upcoming trainings -->
                                            <!-- upcoming trainings -->
                                            <div class="col-xs-12 collapse in table-overflow-responsive" id="show-result" aria-expanded="true" style="">

                                                <!-- table -->
                                                <div class="personel-info">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <fieldset>
                                                                <legend>
                                                                    <h3>Current Application Status</h3>
                                                                </legend>
                                                                <table class="table table-bordered table-responsive table-hover table-striped">
                                                                    <thead>
                                                                        <tr class="background-open-vacancies">
                              <th>S.No</th>
                              <th>Course Code</th>
                              <th>Training Start Date</th>
                              <th>Training End Date</th>
                              <th>No. of Vacancies</th>
                              <th>No. Of Applications</th>
                            </tr>
                                                                    </thead>
                                                                    <tbody id="applicaionStatus">
                                                                </table>
                                                            </fieldset>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
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
