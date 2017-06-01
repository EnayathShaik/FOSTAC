<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>


<!--/#feature-->
 <section id="list">
  <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
    <div class="row">
      <div class="col-md-8 col-xs-12">
    	<h2 class="text-align">Training Partner & Assessment Agency List:</h2><br>
    	<h3 class="text-align" style="font-weight:bold; font-size:16px;">Training Partner List:</h3>
                                            <!-- table -->
                                            <div class="row">
                                                <div class="col-xs-12">
                                                    <fieldset>
                                                        <table id="newTable" class="table table-bordered table-responsive">
                                                            <thead>
                                                                <tr class="background-open-vacancies">
                                                                    <th>S.No.</th>
                                                                    <th>Training Partner ID</th>
                                                                    <th>Training Partner Name</th>
                                                                    <th>Website Link</th>
                                                                    <th>Current Status</th>
                                                                </tr>
                                                            </thead>
                                                            
                                                            <ct:if test="${!empty manageTrainingPartnerList}">
													<ct:forEach items="${manageTrainingPartnerList}"
														var="manageTrainingPartner" varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${manageTrainingPartner[0]}</td> 
														<td>${manageTrainingPartner[1]}</td>
															<td>${manageTrainingPartner[2]}</td>
															<td>${manageTrainingPartner[3]}</td> 
														</tr>
													</ct:forEach>
													</ct:if>
                                                            <tbody>
                                                            </tbody>
                                                            
                                                        </table>
                                                        
                                                    </fieldset>
                                                </div>
                                            </div>

<ct:if test="${not empty tpList }">
<ct:forEach varStatus="loop" var="tpList" items="${tpList}">
<ul>
<li><a href="http://${tpList.websiteUrl}" style="color:#c52d2f;" target="blank">${tpList.trainingPartnerName}</a></li>            
</ul>
</ct:forEach>
</ct:if>

<h3 class="text-align" style="font-weight:bold; font-size:16px;">Assessment Agency List:</h3>
 <div class="row">
                                                <div class="col-xs-12">
                                                    <fieldset>
                                                        <table id="newTable" class="table table-bordered table-responsive">
                                                            <thead>
                                                                    <tr class="background-open-vacancies">
                                                                        <th>S.No.</th>
                                                                        <th>Assessment Agency ID</th>
                                                                        <th>Assessment Agency Name</th>
                                                                        <th>Website Link</th>
                                                                        <th>Status</th>
                                                                    </tr>
                                                                </thead>
                                                            
                                                            <ct:if test="${!empty manageAssessmentAgencyList}">
													<ct:forEach items="${manageAssessmentAgencyList}"
														var="manageAssessmentAgency" varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${manageAssessmentAgency[0]}</td> 
														<td>${manageAssessmentAgency[1]}</td>
															<td>${manageAssessmentAgency[2]}</td>
															<td>${manageAssessmentAgency[3]}</td> 
														</tr>
													</ct:forEach>
													</ct:if>
                                                            <tbody>
                                                            </tbody>
                                                            
                                                        </table>
                                                        
                                                    </fieldset>
                                                </div>
                                            </div>
<ct:if test="${not empty aaList }">
<ct:forEach varStatus="loop" var="aaList" items="${aaList}">
<ul>
<li>
<a href="http://${aaList.websiteUrl}" style="color:#c52d2f;" target="_blank">${aaList.assessmentAgencyName}</a></li>            
</ul>
</ct:forEach>
</ct:if>      
  </div>     
		
      </div> 
    </div>      
 </section>	
 
 