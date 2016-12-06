<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function OnStart(){
	searchAssessmentAgencyList();
}
window.onload = OnStart;
</script>
<script type="text/javascript">
function searchAssessmentAgencyList(){
	document.getElementById("detailListOfAssessor").style.display ='none';
	//document.getElementById("conclusionListOfAssessment").style.display ='block';
		var result="";
		$.ajax({
		type: 'post',
		url: 'searchAssessmentAgencyList.jspp?',
		async: false, 
		success: function (data){
		$('#newTable').show();
		//var mainData = JSON.stringify(data);
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Number of Assessor IDs</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[1]+'</td><td><input type="hidden" id="assessmentAgencyId" value="'+ obj[0]+'" /><a href="#" onclick="showDetail();">'+obj[2]+'</a></td></tr>');
			
		});
		}
		});
	return result;
}


function showDetail(){
	//alert('detail');
	document.getElementById("detailListOfAssessor").style.display ='block';
	//document.getElementById("conclusionListOfAssessment").style.display ='none';
	var result="";
	var id = document.getElementById("assessmentAgencyId").value;
	$.ajax({
	type: 'post',
	url: 'searchAssessorDetail.jspp?'+id,
	async: false, 
	success: function (data){
	$('#newTable1').show();
	//var mainData = JSON.stringify(data);
	var mainData1 = jQuery.parseJSON(data);
	//alert(mainData1);
	var j=1;
	$('#newTable1 tr').remove();
	$('#newTable1').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Assessor Name</th><th>Assessor Id</th><th>Active / In-Active</th><th>Detail</th></tr>')
	$.each(mainData1 , function(i , obj)
	{
		$('#newTable1').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[0]+'</td><td>'+obj[1]+'</td><td>'+obj[2]+'</td><td><input type="hidden" id="statusHidden'+obj[4]+'" value="'+obj[5]+'"/><a href="#" onclick="statusChange('+obj[4]+');">'+obj[3]+'</a></td><td><input type="hidden" id="assessorId'+obj[4]+'" value="'+ obj[4]+'" /><a href="#" onclick="showDetail();">'+obj[4]+'</a></td></tr>');
		console.log(obj[0] +" -" +obj[1] +" -" +obj[2] +" -"+obj[3] +" -"+obj[4]);
		
	});
	}
	});
return result;
}


function statusChange(elementId){
	var id = document.getElementById("assessorId"+elementId).value;
	var status = document.getElementById("statusHidden"+elementId).value;
	alert(id+"  "+ status);
	var total="id="+id+"&status="+status;
	$.ajax({
	type: 'post',
	url: 'changeAssessor.jspp?'+total,
	async: false, 
	success: function (data){
	$( '#name_status' ).html(response);
	$('#newTable1').hide();
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
                        <!-- TODO -->
<!--                         <li><a href="viewTrainingCalendar.fssai">View Calendar</a></li> -->
 							<li><a href="viewAssessmentAgencyCalendar.fssai">View Calendar</a></li>
                       
                        
                    </ul>
                </div>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> 
                                <span class="orange-font">Welcome Assessment Agency</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row"  id="conclusionListOfAssessment">
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
                                    </tbody></table>
                               </fieldset>                                    
                            </div>
                            
                         
                            <div class="col-md-2 hidden-xs"></div>
                        </div>
                        
                        
                        
                        
                        <div class="row" id="detailListOfAssessor">
                            <div class="col-xs-12">
                            <span id=name_status"></span>
                                <div class="page-header">
                                    <h1 id="timeline">List of Pending Assessor ID Activation</h1> </div>
                                <table id="newTable1"  class="table-bordered table-hover table table-responsive">
                                    <thead>
                                        <tr class="background-open-vacancies">
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
<!--                                 <div class="col-xs-12 pull-right"> -->
<!--                                     <input style="margin-top:20px; width:100px;" type="button" class="form-control login-btn btn" value="Activate" /> </div> -->
<!--                             </div> -->
                            <div class="col-md-2 hidden-xs"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>