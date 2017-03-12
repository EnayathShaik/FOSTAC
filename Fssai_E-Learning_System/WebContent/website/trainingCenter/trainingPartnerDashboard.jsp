<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
function OnStart(){
	document.getElementById("detailListOfTP").style.display ='none';
	document.getElementById("fullListOfTP").style.display ='block';
	//searchTrainingCenterList1();
}
window.onload = OnStart;
</script>
<script type="text/javascript">
function searchTrainingCenterList1(){
	var result="";
	var name1=JSON.stringify({
		courseName:0
  })
	$.ajax({
	type: 'post',
	url: 'searchTrainingCenterList.fssai',
	contentType : "application/json",
	data:name1,
	async: false, 
	success: function (data){
		$('#newTable').show();
		var mainData1 = jQuery.parseJSON(data);
		//alert(mainData1);
		var j=1;
		$('#newTable tr').remove();
		$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Training Partner Name</th><th>Number of Training Center IDs</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
		$('#newTable').append('<tr id="tableRow"><td>'+ j++ +'</td><td>'+obj[1]+'</td><td><input type="hidden" id="idd" value="'+obj[0]+'"><a href="#" onclick="onLoadTrainingPartnerCenterId();">'+obj[2]+'</a></td></tr>');
		});	
		}
		});
	return result;
}
function onLoadTrainingPartnerCenterId(){

	document.getElementById("detailListOfTP").style.display ='block';
	document.getElementById("fullListOfTP").style.display ='none';
	var id = document.getElementById("idd").value;
	var result="";
	var id = document.getElementById("idd").value;
	var name1=JSON.stringify({
		courseName:0
  })
	$.ajax({
	type: 'post',
	url: 'onLoadTrainingPartnerCenterId.fssai?data='+id,
	contentType : "application/json",
	data:name1,
	async: false, 
	success: function (data){
	$('#newTable1').show();
	var mainData1 = jQuery.parseJSON(data);
	var j=1;
	$('#newTable1 tr').remove();
	$('#newTable1').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Training Center Name</th><th>Training Center Id</th><th>Active / In-Active</th></tr>')
	$.each(mainData1 , function(i , obj)
	{
		$('#newTable1').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[1]+'</td><td>'+obj[3]+'</td><td><input type="hidden" id="statusHidden" value="'+obj[4]+'"/><a href="#" onclick="statusChange();">Active</a></td></tr>');
		
	});
	}
	});
return result;
}

function statusChange(){
	var id = document.getElementById("statusHidden").value;
	//alert(id);
	var status = document.getElementById("statusHidden").value;
	var total=id;
	$.ajax({
	type: 'post',
	url: 'changeAssessor1.jspp?'+total,
	async: false, 
	success: function (data){
	$( '#name_status' ).html(response);
	$('#newTable1').hide();
	}
	});
	onLoadTrainingPartnerCenterId();
return result;
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
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName }</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">
                             <div class="col-xs-12" id="fullListOfTP">
                            <fieldset>
                                <legend>Pending Training Center ID Activation</legend>
                                <table id="newTable" class="table-bordered table table-hover table-responsive">
                                    <thead>
                                        <tr  class="background-open-vacancies">
                                            <td>S. No.</td>
                                            <td>Training Partner Name</td>
                                            <td>Number of Training Center IDs</td>
                                        </tr>
                                    </thead>
                                    <tbody></tbody>                                   
                                </table>                               
                            </fieldset>
                                 <br><br>
                            </div> <!-- col xs ends -->
                            
                         
                            <div class="col-md-2 hidden-xs"></div>
                            <div class="row" id="detailListOfTP">
                            <div class="col-xs-12">
                            <span id="name_status"></span>
                                <div class="page-header">
                                    <h1 id="timeline">List of Pending Training Partner ID Activation</h1> </div>
                                <table id="newTable1"  class="table-bordered table-hover table table-responsive">
                                    <thead>
                                        <tr class="background-open-vacancies">
                                            <td>S. No.</td>
                                            <td>Training Center Name</td>
                                            <td>Training Center ID</td>
                                            <td>Status</td>
                                        </tr>
                                    </thead>
                                   <tbody></tbody>
                                </table>
                                         </div>
                            <div class="col-md-2 hidden-xs"></div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>