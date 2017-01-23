<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function OnStart(){
	searchTrainingPartnameList();
	searchAssessmentAgencyList();
}
window.onload = OnStart;
</script>
<script type="text/javascript">
function searchTrainingPartnameList(){
		var result="";
		$.ajax({
		type: 'post',
		url: 'searchTrainingPartnameList.jspp?',
		async: false, 
		success: function (data){
		$('#newTable').show();
		//var mainData = JSON.stringify(data);
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable tr').remove();
		$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Training Partner Name</th><th>Number of Training Center IDs</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[1]+'</td><td><a href="" onClick="onLoadTrainingPartnerCenterId.fssai?id='+obj[0]+'">'+obj[2]+'</a></td></tr>');
			
		});
		}
		});
	return result;
}
</script>
<script type="text/javascript">
function searchAssessmentAgencyList(){
		var result="";
		$.ajax({
		type: 'post',
		url: 'searchAssessmentAgencyList.jspp?',
		async: false, 
		success: function (data){
		$('#newTable1').show();
		//var mainData = JSON.stringify(data);
		var mainData1 = jQuery.parseJSON(data);
		var j=1;
		$('#newTable1 tr').remove();
		$('#newTable1').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Number of Assessor IDs</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable1').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[1]+'</td><td><a href="onLoadAssessmentAgencyCenterId.jspp?"'+obj[0]+'>'+obj[2]+'</a></td></tr>');
			
		});
		}
		});
	return result;
}
</script>

<!-- <script>
function onLoadTrainingPartnerCenterId(){
	var  id = document.getElementById("idHiddenTrainingPartner").value;
	var result="";
	$('#newTable').hide();
	$('#newTable1').hide();
	$.ajax({
	type: 'post',
	url: 'onLoadTrainingPartnerCenterId.jspp?'+ id,
	async: false, 
	success: function (data){
	$('#newTable2').show();
	//var mainData = JSON.stringify(data);
	var mainData1 = jQuery.parseJSON(data);
	var j=1;
	$('#newTable2 tr').remove();
	$('#newTable2').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Training Partner Name</th><th>Training Center Id</th><th>Option</th></tr>')
	$.each(mainData1 , function(i , obj)
	{
		$('#newTable2').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[1]+'</td><td>'+obj[2]+'</td></tr>');
		
	});
	}
	});
return result;
}
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
                                <span class="orange-font">Welcome Admin </span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">
                             <div class="col-xs-12">
                            <fieldset>
                                <legend>Pending Training Center ID Activation</legend>
                               
                                <table class="table-bordered table table-hover table-responsive"  id="newTable">
                                <thead>
                                            <tr class="background-open-vacancies">
                                                <td>S. No.</td>
                                                <td>Training Partner Name</td>
                                                <td>Number of Training Centers IDs</td>
                                            </tr>
                                        </thead>                                    
                                </table>                               
                            </fieldset>
                                 <br><br>
                            </div> <!-- col xs ends -->
                            
                            
                            <!-- second table -->
                            
                            
                            <div class="col-xs-12">
                               <fieldset>
                                    <legend>Pending Assessor ID Activation</legend> 
                                   
                                    <table class="table-bordered table table-responsive table-hover" id="newTable1">
                                        <thead>
                                            <tr class="background-open-vacancies">
                                                <td>S. No.</td>
                                                <td>Assessment Agency Name</td>
                                                <td>Number of Assessor IDs</td>
                                            </tr>
                                        </thead>
                                    </table>
                               </fieldset>                                    
                            </div>
                            
                            
                            <!-- add the content here for main body -->
                        <!-- timeline  -->
                     
                            <!-- <div class="col-xs-12">
                                
                                <fieldset>
                                    <legend>List of Pending Training Center ID Activation</legend>
                                     <table id="newTable2" class="table-bordered table-hover table table-responsive">
                                    <thead>
                                        <tr class="background-open-vacancies">
                                            <td>S. No.</td>
                                            <td>Training Partner Name</td>
                                            <td>Training Center ID</td>
                                            <td>Option</td>
                                        </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                               
                                </fieldset>
                                </div> -->
                            
                            <div class="col-md-2 hidden-xs"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    
    
                                