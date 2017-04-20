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
                                <legend>List Of Training Center</legend>
                          
                        
                            
                         
                             <div class="col-xs-12 table-overflow-responsive">
                                                <table id="datatablesfostac" class="table-hover table table-bordered table-responsive">
                                                    <thead>
                                                        <th>User ID</th>
                                                        <th>Training center Name</th>
                                                        <th>Current Status</th>
                                                        <th>Update Status</th>
                                                    </thead>
                                                    <tbody>
                                                        <ct:choose>
                                                            <ct:when test="${not empty searchTrainingCenterUsermanagement }">
                                                                <ct:forEach var="listValue" items="${searchTrainingCenterUsermanagement}" varStatus="loop">
                                                                    <tr>
                                                                        <td>
                                                                            <label><a href="update-personal-information.fssai?userId=${listValue[3]}" value="${listValue[0]}">${listValue[1]}</a></label>
                                                                        </td>
                                                                        <td>
                                                                            <label>${listValue[2] }</label>
                                                                        </td>
                                                                       
                                                                            <td>
                                                                                    <label>${listValue[5]}</label>
                                                                                </td>
                                                                                <td>
                                                                                    <label><input type="submit"  onclick=" return activateDeActivateUser('${listValue[3]}','${listValue[4]}','1');" value="${listValue[4]}"/></label>
                                                                                </td>
                                                                    </tr>
                                                                </ct:forEach>
                                                            </ct:when>
                                                            <ct:otherwise>
                                                                <td colspan="5">
                                                                    <label>No records available</label>
                                                                </td>

                                                            </ct:otherwise>
                                                        </ct:choose>
                                                    </tbody>
                                                </table>
                                            </div>
                                            </fieldset>
                           </div> <!-- col xs ends -->
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>