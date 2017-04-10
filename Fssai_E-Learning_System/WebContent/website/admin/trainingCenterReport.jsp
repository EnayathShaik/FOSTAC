<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="website/js/commonController.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Training Center Report</title>
</head>
<body>
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
      <div class="container" >
	<div class="well" style=" background:#EBEBEB;  border-bottom: #0722A2 solid thick;">
	<h1 align="center" style="color:#0722A2;"><strong>FOSTAC REPORT</strong></h1>
	<h3 align="center">Food safety Training and Certification Training Partner Detailing Report</h3>
		<cf:form action="trainingCenterDetails.fssai" name="myForm" method="POST" commandName="trainingCenterReport" > 
		<div class="row">
								<div class="col-xs-12">
								      <div class="col-md-6 col-xs-12">
									<div class="form-group">
										<div>
											<ul class="lab-no">
												<li class="style-li"><strong>Training Partner:</strong></li>
												<li class="style-li error-red"></li>
											</ul>
										</div>
										<cf:select path="trainingPartner"  style="width:300px;" class="form-control"
											onchange="getTrainingPartner(this.value);">
											<cf:option value="0" label="Select Training Partner"></cf:option>
											<cf:options items="${trainingPartnerList}"
												itemValue="manageTrainingPartnerId"
												itemLabel="trainingPartnerName" />

										</cf:select>
										</div>
									
									</div>
							
								    <div class="col-md-6 col-xs-12">
							 	<div class="form-group">
									<div>
										<ul class="lab-no">
											<li class="style-li"><strong>Created Date:</strong></li>

										</ul>
									</div>
									<cf:input path="createdDate"  style="width:300px;" type="text" class="form-control"
										required="required" />
								</div> 
			
			</div>
		</div>

	</cf:form>	
	</</div>	
</div>


      </div>
      </div>
      
        <div class="row">
                                            <div class="col-xs-12">
                                           <fieldset>
                                           <legend>Training Center Details</legend>
                                            <ct:if test="${!empty trainingCenterDetails}">
                                            <table class="table table-bordered table-responsive">
                                               <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>Training Center</th>
                                                        <th>No of Training Done</th>
                                                        <th>No of trainees Involve</th>
                                                        <th>Pass</th>
                                                        <th>Count Fail</th>
                                                       
                                                    </tr>
                                                </thead>
                                                
                                                <ct:forEach items="${trainingCenterDetails}" var="TrainingSchedule" varStatus="loop">
                                                <tr>
												<td>${loop.count}</td>
												<td>${TrainingSchedule.trainingCenter}</td>
												<td>${TrainingSchedule.noOfTrainingDone}</td>
												<td>${TrainingSchedule.noOfTraineesInvolved}</td>
												<td>${TrainingSchedule.pass}</td>
												<td>${TrainingSchedule.countFail}</td>
												
									
												
											</tr>
										</ct:forEach>
                                            </table>
                                           </ct:if>
                                        </fieldset>
                                                    </div>
                                                </div>
      </section>
      
      
</body>
<script type="text/javascript">

function getTrainingPartner(val){
	alert(val);
	//$("#trainingCenterReport").submit();
	$("#sbmt").trigger('click');
}
</script>
</html>