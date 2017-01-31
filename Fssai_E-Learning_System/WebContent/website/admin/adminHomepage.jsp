<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
function OnStart(){
	document.getElementById("detailListOfTP").style.display ='none';
	document.getElementById("fullListOfTP").style.display ='block';
	searchTrainingCenterList1();
	searchAssessmentAgencyList();
}
window.onload = OnStart;
</script>
<script type="text/javascript">
function searchTrainingCenterList1(){
	var result="";
	$.ajax({
	type: 'post',
	url: 'searchTrainingCenterList.jspp',
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
	$.ajax({
	type: 'post',
	url: 'onLoadTrainingPartnerCenterId.jspp?'+id,
	async: false, 
	success: function (data){
	$('#newTable1').show();
	//var mainData = JSON.stringify(data);
	var mainData1 = jQuery.parseJSON(data);
	//alert(mainData1);
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

//Assessment Agency
function searchAssessmentAgencyList() {
                    document.getElementById("detailListOfAssessor").style.display = 'none';
                    //document.getElementById("conclusionListOfAssessment").style.display ='block';
                    var result = "";
                    $.ajax({
                        type: 'post',
                        url: 'searchAssessmentAgencyList.jspp?',
                        async: false,
                        success: function(data) {
                            $('#newTableAss').show();
                            //var mainData = JSON.stringify(data);
                            var mainData1 = jQuery.parseJSON(data);
                            var j = 1;
                            $('#newTableAss tr').remove();
                            $('#newTableAss').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Number of Assessor IDs</th></tr>')
                            $.each(mainData1, function(i, obj) {
                                $('#newTableAss').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[1] + '</td><td><input type="hidden" id="assessmentAgencyId" value="' + obj[0] + '" /><a href="#" onclick="showDetailAssAgency();">' + obj[2] + '</a></td></tr>');

                            });
                        }
                    });
                    return result;
                }


                function showDetailAssAgency() {
                    //alert('detail');
                    document.getElementById("detailListOfAssessor").style.display = 'block';
                    //document.getElementById("conclusionListOfAssessment").style.display ='none';
                    var result = "";
                    var id = document.getElementById("assessmentAgencyId").value;
                    $.ajax({
                        type: 'post',
                        url: 'searchAssessorDetail.jspp?' + id,
                        async: false,
                        success: function(data) {
                            $('#newTable1Ass').show();
                            //var mainData = JSON.stringify(data);
                            var mainData1 = jQuery.parseJSON(data);
                            //alert(mainData1);
                            var j = 1;
                            $('#newTable1Ass tr').remove();
                            $('#newTable1Ass').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Assessor Name</th><th>Assessor Id</th><th>Active / In-Active</th><th>Detail</th></tr>')
                            $.each(mainData1, function(i, obj) {
                                $('#newTable1Ass').append('<tr id="tableRow"><td>' + j++ + '</td><td>' + obj[0] + '</td><td>' + obj[1] + '</td><td>' + obj[2] + '</td><td><input type="hidden" id="statusHidden' + obj[4] + '" value="' + obj[5] + '"/><a href="#" onclick="statusChangeAssAgency(' + obj[4] + ');">' + obj[3] + '</a></td><td><input type="hidden" id="assessorId' + obj[4] + '" value="' + obj[4] + '" /><a href="#" onclick="showDetail();">' + obj[4] + '</a></td></tr>');
                                console.log(obj[0] + " -" + obj[1] + " -" + obj[2] + " -" + obj[3] + " -" + obj[4]);

                            });
                        }
                    });
                    return result;
                }


                function statusChangeAssAgency(elementId) {
                    var id = document.getElementById("assessorId" + elementId).value;
                    var status = document.getElementById("statusHidden" + elementId).value;
                    var total = "id=" + id + "&status=" + status;
                    $.ajax({
                        type: 'post',
                        url: 'changeAssessor.jspp?' + total,
                        async: false,
                        success: function(data) {
                            $('#name_status').html(response);
                            $('#newTable1').hide();
                        }
                    });
                    showDetailAssAgency();
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
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Training Partner</span> </a>
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
                          <div class="row" id="conclusionListOfAssessment">
                                        <div class="col-xs-12">
                                            <fieldset>
                                                <legend>Pending Assessor ID Activation</legend>

                                                <table id="newTableAss" class="table-bordered table table-responsive table-hover">
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
                                            <span id="name_status"></span>
                                <div class="page-header ">
                                    <h1 id="timeline ">List of Pending Assessor ID Activation</h1> </div>
                                <table id="newTable1Ass"  class="table-bordered table-hover table table-responsive ">
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
        </div>
    </section>