<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="website/js/jquery-1.9.1.js"></script>
<script type="text/javascript">
function searchAssessmentAgencyCalendar(){
	alert("search assessmentAgencyCal");
		var result="";
		var agencyId = document.getElementById("agencyId").value;
		$.ajax({
		type: 'post',
		data:{
			agencyId:agencyId 
		},
		url: 'viewAssessmentAgencyCalendar.jspp?',
		async: false, 
		success: function (data){
		$('#tblAACalendar').show();
		var calendarData = jQuery.parseJSON(data);
		var j=1;
		$('#tblAACalendar tr').remove();
		$('#tblAACalendar').append('<thead>'+'<tr class="background-open-vacancies">'+
				'<th>S.No.</th>'+
				'<th>Course Type</th>'+
				'<th>Course Name</th>'+
// 				'<th>Assessment Date</th>'+
				'<th>Assessment Center</th>'+
				'<th>Assessor</th>'+
				'<th>Status</th>'+
				'</tr>'+'</thead>');
		$.each(calendarData , function(i , obj)
		{
			$('#tblAACalendar').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[1]+'</td><td>'+obj[2]+'</td><td>'+obj[3]+'</td><td>'+obj[4]+'</td><td>'+obj[5]+'</td></tr>');
			
		});
		}
		});
	return result;
}
</script>


<cf:form name="viewAssessmentAgencyCalendar" commandName="viewAssessmentAgencyCalendar">

    <section>
    <input type="hidden" id="agencyId"/>
	<script>
	var formDataRaw = '${viewAssessmentAgencyCalendar}';
	var formData = JSON.parse(formDataRaw);
	$('#agencyId').value = formData.manageassessmentagencyid;
	document.getElementById('agencyId').value = formData.manageassessmentagencyid;
	console.log(formData);
	</script>
        <div class="container-fluid">
            <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                            </div>
                            <div id="navbar" class="navbar-collapse collapse">
                                <ul class="nav navbar-nav">
                                    <li></li>
                                    <li class="active hori"><a href="assessmentAgencyHomepage.fssai">Home</a></li>
                                    <li><a href="trainingCenterManagement.fssai">Assessor User Management</a></li>
                                    <li><a href="contactAA.fssai">Contact Us</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="changePasswordAssesAgency.fssai">Change Password</a></li>
                                            <li><a href="fostac.fssai">Logout</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
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
                <div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand"></li> -->
                         <li><a href="view-training-calendar.html">View Calendar</a></li>
                       
                    </ul>
                </div>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Trainee Mr. Lorem </span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <section class="section-form-margin-top">
                  
                        <!-- fostac logo -->
                        <!-- login form -->
                        <div class="row">
                            <div class="col-xs-12">
                                <h3 class="text-capitalize heading-3-padding">View Assessment Calendar</h3>
                                <form>
                                    <!-- personal information -->
                                    <div class="personel-info">
                                        
                                            <!-- left side -->
                                            <div class="col-md-6 col-xs-12">
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Type:</strong></li>
                                                            
                                                        </ul>
                                                    </div>
                                                    <select class="form-control">
                                                        <option></option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Name:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                    <select class="form-control">
                                                        <option></option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Assessment Date:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                    <input type="date" class="form-control" placeholder="Date" required> 
                                                </div>
                                             
                                            </div>
                                            <!-- right side -->
                                            <div class="col-md-6 col-xs-12">
                                              
                                               <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Assessment Center:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                    <select class="form-control">
                                                        <option></option>
                                                    </select>
                                                </div>
                                                
                                               <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Assessor:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                    <select class="form-control">
                                                        <option></option>
                                                    </select>
                                                </div>
                                                 
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Status:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                    <select class="form-control">
                                                        <option>Active</option>
                                                        <option>Inactive</option>
                                                    </select>
                                                </div>
                                                
                                                
                                                <!-- button -->
                                                <div class="row">
                                                    <div class="col-md-6 col-xs-12"></div>

                                                    <div class="col-md-6 col-xs-12" style="margin-top: 26px;">

                                                        <button class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" style="margin-right: 15px " onclick="searchAssessmentAgencyCalendar();return false;">Search</button>
                                                    </div>
                                                </div>
                                                
                                             
                                            </div>
                                            <!-- personal information ends -->
                                    </div>
                                    <div class="row" style="height: 20px;"></div>
                                    
                                   
                                    <!-- training center details ends -->
                                </form>
                            </div> <!-- xs 12 -->
                            <div class="col-md-2 hidden-xs"></div>
                        </div>
                    
                </section>
                        
                        
                        <!-- search result -->
                        <div class="col-xs-12 collapse" id="show-result" aria-expanded="true" style="height: 0;">
                                    
                                    <!-- table -->
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <fieldset>
                                                <legend>Search Result</legend>
                                                
                                                <table id="tblAACalendar" class="table table-bordered table-responsive">
                                                
                                            </table>
                                            </fieldset>
                                            
                                        </div>
                                    </div>
                                </div>
          
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
    </cf:form>
