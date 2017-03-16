<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function OnStart(){
	onFeedbackMasterSearchClick("ALL");
}
window.onload = OnStart;
</script>
<script type="text/javascript">
function searchTrainingPartnameList(){
	$('#newTable').show();
		var result="";
		$.ajax({
		type: 'post',
		url: 'searchTrainingPartnameList.jspp?',
		async: false, 
		success: function (data){
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
<script type='text/javascript'>
var feedbackMasterArr=["feedbackTypeID","courseType","catogery","feedback","status"];
function editFeedbackMaster(feedbackTypeID){
	$('.error-red').html('');
	$('#feedbackTypeID').val(feedbackTypeID);
	$('#courseType option:contains(' + $(':hidden#'+feedbackTypeID+'courseType').val() + ')').prop({selected: true});
	$('#catogery option:contains(' + $(':hidden#'+feedbackTypeID+'hiddencatogery').val() + ')').prop({selected: true});
	$('input:radio[name=status]').filter('[value='+$(':hidden#'+feedbackTypeID+'status').val()+']').prop('checked', true);
	$('#feedback').val($(':hidden#'+feedbackTypeID+'feedback').val());
	$('#submit').val('Update');
}

function onFeedbackMasterSearchClick(indicator){
	$('.error-red').html('');
	var courseType = $("#courseType").val();
	var catogery = $("#catogery").val();
	var feedback = $("#feedback").val();
	($("#status1").prop("checked")) ? status ="Active" : status = "Inactive"; 
	console.log("status "+status);
	var searchStr = "";
	if(indicator == "ALL"){
		searchStr = "ALL";
	}else{
		searchStr = "courseType="+courseType+"-catogery="+catogery+"-feedback="+feedback+"-status="+status;
	}
	console.log(" searchStr "+searchStr);
	var name1=JSON.stringify({
		courseType:0,
		courseName:0
  })
	$.ajax({
		type: 'post',
		url: 'searchFeedbackMaster.fssai?data='+searchStr,
		 contentType : "application/json",
		 data:name1,
		async: false, 
		success: function (data){
			var feedbackList=jQuery.parseJSON(data);
			var feedbackCount=feedbackList.length;
			$('#newTable tr').remove();
			$('#newTable').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>User Type</th><th>Feedback</th><th>Feedback Category</th><th>Status</th><th>Edit</th></tr>')
			if(feedbackCount>0){
				for(var index=0;index<feedbackCount;index++){
					var trStr="<tr>";
					var feedbackObj=feedbackList[index];
					var fdbkCount=feedbackObj.length
					if(fdbkCount>0){
						trStr=trStr.concat("<td><input type='hidden' id='"+feedbackMasterArr[0]+"' value='"+feedbackObj[0]+"'/>"+feedbackObj[0]+"</td>");
					}
					for(var fbIndex=1;fbIndex<fdbkCount;fbIndex++){
						var hiddenID=feedbackObj[0]+feedbackMasterArr[fbIndex];
						trStr=trStr.concat("<td><input type='hidden' id='"+hiddenID+"' value='"+feedbackObj[fbIndex]+"'/>"+feedbackObj[fbIndex]+"</td>");
					}
					trStr=trStr.concat("<td><a href='#' onClick='editFeedbackMaster("+feedbackObj[0]+");'>edit</a></td></tr>");
					$('#tbody').append(trStr);
				}
				var theDropDown = document.querySelector("#show-result");
				theDropDown.classList.remove("collapse");
			}
		}
		});
	}
function validateFields(){
	var fback = document.getElementById("feedback").value;
	if(fback.length <= 0){
		alert('Please enter feebback.');
		return false;
	}
	if($('#submit').val()==='Create'){
		$('#feedbackTypeID').val(0);
	}
}
function onLoadTrainingPartnerCenterId(){
	var  id = document.getElementById("idHiddenTrainingPartner").value;
	var result="";
	//$('#newTable').hide();
	//$('#newTable1').hide();
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
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> 
                                <span class="orange-font">Welcome ${userName } </span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">
                        <cf:form action="saveFeedbackMaster.fssai" name="myForm" method="POST" commandName="feedbackMaster" onsubmit="return validateFields()">
                              <div class="col-xs-12">
 									<h1>Feedback Master</h1>
 									<span class="style-li error-red">${created}<span id="name_status"></span></span>
 									<div class="row">
 									<div class="col-xs-12">
                                            <!-- left side -->
                                            <div class="col-md-6 col-xs-12">
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>User Type:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                   <cf:select id="courseType" path="courseType" class="form-control">
	                                                   <cf:option value="Trainee" label="Trainee" />
                                                    </cf:select>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Feedback Category:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                  <cf:select id="catogery" path="catogery" class="form-control">
		                                                   <cf:option value="Trainee" label="Trainee" />
                                                    </cf:select>
                                                </div>
                                            </div> <!-- left side ends -->

                                            <!-- right side -->
                                            <div class="col-md-6 col-xs-12">
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Feedback:</strong></li>
                                                            <li class="style-li error-red"></li>
                                                        </ul>
                                                    </div>
                                                   <cf:input id="feedback" path="feedback" class="form-control" />
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div style="padding-top: 35px;">
                                                        
                                                    </div>
                                                    <cf:radiobutton path="status" label="Active" checked="checked"  class="radio-inline"  value="Active"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <cf:radiobutton path="status" label="Inactive"  class="radio-inline"  value="Inactive"/>
                                                </div>
                                                
                                               <div class="row">
                                                
                                                <!-- create button -->
                                                <div class="col-md-6 col-xs-12">
                                                    <br>
                                                    <cf:hidden path="feedbackTypeID" value="${feedbackID}"/>
                                                    <input id="submit" class="btn login-btn" style="width: 100%;" type='submit' value='Create'/>
                                                    <br>
                                                </div>
                                                <!-- show details -->
                                                <div class="col-md-6 col-xs-12">
                                                    <br>
                                                    <a  class="btn login-btn show-details-vacancy collapsed"  href="#" onclick="onFeedbackMasterSearchClick('')" style="width: 100%;">Search</a>
                                                    <br>
                                                </div>
                                                </div>
                                                </div>
                                                </div>
                                                    <!-- search Results -->
                                   <div class="col-xs-12 displayNone" id="show-result" aria-expanded="false" style="height: 0px;">   
                                    <!-- table -->
                                    <div class="row">
                                        <div class="col-xs-12 table-overflow-responsive">
                                            <fieldset>
                                                <legend>Search Result</legend>
                                                
                                                <table id="newTable" class="table table-bordered table-responsive">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>User Type</th>
                                                        <th>Feedback Category</th>
                                                        <th>Feedback</th>
                                                        <th>Status</th>
                                                        <th>Option</th>
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody id="tbody">
                                                </tbody>
                                            </table>
                                            </fieldset>
                                            
                                        </div>
                                    </div>
                                </div> <!-- search div ends -->
                                            </div> <!-- button row ends -->
                                                
                                            </div> <!-- rigth side ends -->
                                            
                                            <!-- button -->
                            
                            <div class="col-md-2 hidden-xs"></div>
                            </cf:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    
    
                                