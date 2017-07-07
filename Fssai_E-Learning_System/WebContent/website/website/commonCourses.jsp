<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="website/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
	function OnStart() {
		  url = window.location.href;
		  //alert(url);
		  p = url.charAt(69);
		   //alert(p);
		if (p==5) {
			$("#d").css("display", "block");
		}
		if (p==6) {
			$("#b").css("display", "block");
		}
		if (p==7) {
			$("#c").css("display", "block");
		}
		if (p==8) {
			$("#a").css("display", "block");
		}
	} 
window.onload = OnStart;
</script>

<head>
<style>
button.accordion {
    background-color: #eee;
    color: #444;
    cursor: pointer;
    padding: 18px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
    transition: 0.4s;
}

button.accordion.active, button.accordion:hover {
    background-color: #ddd;
}

button.accordion:after {
    content: '\002B';
    color: #777;
    font-weight: bold;
    float: right;
    margin-left: 5px;
}

button.accordion.active:after {
    content: "\2212";
}

div.panel {
    padding: 0 18px;
    background-color: white;
    color:black; 
    max-height: 0;
    overflow: hidden;
    transition: max-height 0.2s ease-out;
}
</style>
</head>

<section id="main-slider" class="no-margin">
    <div class="carousel-inner innerpage" style="background-image: url(website/images/slider/bg1.jpg)">
        <div class="container">
            <div class="row slide-margin">
                <div class="col-sm-12">
                    <h1 class="animation animated-item-1" style="padding-bottom:10px;">REGISTER HERE</h1>
                </div>
                <div class="circle-wrap center-block">
                    <ul>
                        <li>
                            <a href="trainee.fssai"><img src="website/images/trainee.png"></a>
                        </li>
                        <li>
                            <a href="trainer.fssai"><img src="website/images/trainer.png"></a>
                        </li>
                        <!-- <li>
                            <a href="trainingPartner.fssai"><img src="website/images/training-partner.png"></a>
                        </li> -->
                        <li>
                            <a href="assessor.fssai"><img src="website/images/assessor.png"></a>
                        </li>
                       <li>
					    <a href="trainingpartner.fssai"><img src="website/images/training-partner_bk.png"></a>
                        </li>
                                            </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<!--/#main-slider-->
<section id="feature">
    <div class="container">
        <div class="row">
            <div class="features">
                <div class="col-md-12 col-xs-12 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap feature-wrapbasic"> <img class="img-responsive center-block" src="website/images/fssai-certification-logo.jpg" width="132" height="87">
                      <h3  id="a" style="display:none;">Awarness Food Safety Certification</h3>
                       <h3 id="b" style="display:none;">Advanced Food Safety Certification</h3>
                       <h3 id="c" style="display:none;">Special Food Safety Certification</h3> 
                         <h3 id="d" style="display:none;">Basic Training on Food Safety</h3>
                    </div>
                </div> 
            </div>
            <!--/.services-->
        </div>
        <!--/.row-->
    </div>
    <!--/.container-->  
</section>

<section>
  <div class="col-xs-12 " id="testt">
								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
										<fieldset>
											<legend>Course Name List</legend>
									<table id="datatablesfosrest" 
													class="table table-bordered table-responsive">
													<thead style="background: #e6511a;">
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>Course Code</th>
															 <th>Course Name</th>
															<th>Duration</th>
															<th>Free/Paid</th> 
															<th>Uploaded Content</th>
														<!-- 	<th></th>
															<th>Activate Training</th> --> 
														</tr>
													</thead>
													<ct:if test="${!empty commonList}">
													<ct:forEach items="${commonList}"
														var="commonList" varStatus="loop">
														<tr>
															<td>${loop.count}</td>
																														
															
															<td>${commonList.courseCode}</td>
														<td>${commonList.coursename}</td>
															<td>${commonList.courseduration}</td>
															<td>${commonList.paidunpaid}</td> 
															<td style="width: 200px;"> 
															 <div  >    
														<button class="accordion"  >${commonList.coursename}</button> 
														<div class="panel">  	
														<br />
													
														<br />
															 
													 
    												  
    												  <h3>Study Material</h3>  
													<ct:forEach items="${commonList2}" 
														var="commonList2" varStatus="loop">  
													
															<ct:if test="${commonList.courseCode==commonList2[0] && commonList2[5]=='StudyMaterial' && commonList2[7]!='Not Uploaded' }">   
													<%-- 		   
														 
														<ul>
  														
 																<li>Content Name: ${commonList2[6]}</li>
  																<li>Content Location: ${commonList2[3]}</li>
  																<li>Content Link: ${commonList2[2]}</li>
  																
  																<li>Mode of Training Input: ${commonList2[4]}</li>
  																<li>Mode of Training Input: ${commonList2[5]}</li>
  																 
   														  
    												  </ul>   --%> 
    												   
    												    
    												<ul>
    												<li> <a href="${commonList2[7]}" target="_blank"> ${commonList2[7]}</a></li>
    												 </ul>  
    												 
															</ct:if> 
															
													</ct:forEach> 
													<h3>Videos</h3>  
													
														<ct:forEach items="${commonList2}" 
														var="commonList2" varStatus="loop">  
													
															<ct:if test="${commonList.courseCode==commonList2[0] && commonList2[5]=='Videos' && commonList2[7]!='Not Uploaded'}">   
												
    												    
    													<ul>
    												<li> <a href="${commonList2[7]}" target="_blank"> ${commonList2[7]}</a></li>
    												 </ul>  
    												   
															</ct:if> 
															
													</ct:forEach> 
															<h3>PPTs</h3> 
														<ct:forEach items="${commonList2}" 
														var="commonList2" varStatus="loop"> 
													
															<ct:if test="${commonList.courseCode==commonList2[0] && commonList2[5]=='PPTs' && commonList2[7]!='Not Uploaded'}">   
    												<ul> 
    												<li> <a href="${commonList2[7]}" target="_blank"> ${commonList2[7]}</a></li>
    												 <li><a href="${commonList2[2]}" target="_blank">${commonList2[2]}</a></li>
    												 </ul>    
															</ct:if> 
															 
													</ct:forEach> 
													<h3>Content Link</h3>  
												<ct:forEach items="${commonList2}" 
														var="commonList2" varStatus="loop"> 
													
															<ct:if test="${commonList.courseCode==commonList2[0]}">   
											
    												<ul>  
    												 <li><a href="${commonList2[2]}" target="_blank">${commonList2[2]}</a></li>
    												 </ul>     
    												
															</ct:if> 
															
													</ct:forEach> 
													
													 
																
</div>
																</div> </td> 
														</tr>
													</ct:forEach>
													</ct:if>
												</table>
											<ct:if test="${empty commonList}">
											No Records Available.
											</ct:if>
										</fieldset>	
										</div>
								</div>
						</div>
			<!-- .//////////////////////////////////////////////////////////////////////////////////////////////////////// -->
			
 
	<ct:if test="${!empty commonList}">  
	<ct:if test="${!empty commonList2}">  
	<body> 
		
			<h2>Course Content</h2> 
													<ct:forEach items="${commonList}"
														var="commonList" varStatus="loop">
								  <div class="col-md-6 col-xs-12 " style="  float: left; margin-left: 356px;">  
														<button class="accordion">${commonList.coursename}</button> 
														<div class="panel">  	
														<br />
														<h3>Course Code: ${commonList.courseCode}</h3> 
														<%-- <li>${commonList.coursename}</li> --%>  
															<h3>Duration: ${commonList.courseduration}</h3> 
															<h3>free/Paid: ${commonList.paidunpaid}</h3>
														
														
														<br />
															<%--  <table 
													class="table table-bordered table-responsive">
													<thead style="background: #e6511a;">
    												  <tr><th>Content Name</th><th>Mode of Training Input</th><th>Content Type</th><th>Uploaded Content</th><th>Content Link</th></tr> 
    												  </thead> 
													<ct:forEach items="${commonList2}" 
														var="commonList2" varStatus="loop"> 
													
															<ct:if test="${commonList.courseCode==commonList2[0]}">   
															   
														 
														<ul>
  														
 																<li>Content Name: ${commonList2[6]}</li>
  																<li>Content Location: ${commonList2[3]}</li>
  																<li>Content Link: ${commonList2[2]}</li>
  																
  																<li>Mode of Training Input: ${commonList2[4]}</li>
  																<li>Mode of Training Input: ${commonList2[5]}</li>
  																 
   														  
    												  </ul>   
    												   
    												 <tr><td> ${commonList2[6]}</td><td>${commonList2[4]}</td><td>${commonList2[5]}</td><td><a href="${commonList2[7]}" target="_blank"> ${commonList2[7]}</a></td><td><a href="${commonList2[2]}" target="_blank">${commonList2[2]}</a></td></tr>
    												  
															</ct:if> 
															
													</ct:forEach> 
													 </table>  --%>
													 
													  <div  >    
														 
															 
													  
    												  
    												  <h4 align="left" >Study Material</h4>    
													<ct:forEach items="${commonList2}" 
														var="commonList2" varStatus="loop">  
													
															<ct:if test="${commonList.courseCode==commonList2[0] && commonList2[5]=='StudyMaterial' && commonList2[7]!='Not Uploaded'}">   
													<%-- 		   
														 
														<ul>
  														
 																<li>Content Name: ${commonList2[6]}</li>
  																<li>Content Location: ${commonList2[3]}</li>
  																<li>Content Link: ${commonList2[2]}</li>
  																
  																<li>Mode of Training Input: ${commonList2[4]}</li>
  																<li>Mode of Training Input: ${commonList2[5]}</li>
  																 
   														  
    												  </ul>   --%> 
    												   
    												    
    												<ul>
    												<li> <a href="${commonList2[7]}" target="_blank"> ${commonList2[7]}</a></li>
    												 </ul>  
    												 
															</ct:if> 
															
													</ct:forEach> 
													
													<br />
													<h4>Videos</h4>  
													
														<ct:forEach items="${commonList2}" 
														var="commonList2" varStatus="loop"> 
													
															<ct:if test="${commonList.courseCode==commonList2[0] && commonList2[5]=='Videos' && commonList2[7]!='Not Uploaded'}">   
												
    												    
    													<ul>
    												<li> <a href="${commonList2[7]}" target="_blank"> ${commonList2[7]}</a></li>
    												 </ul>  
    												   
															</ct:if> 
															
													</ct:forEach> 
													<br />
															<h4>PPTs</h4>  
														<ct:forEach items="${commonList2}"  
														var="commonList2" varStatus="loop"> 
													
															<ct:if test="${commonList.courseCode==commonList2[0] && commonList2[5]=='PPTs' && commonList2[7]!='Not Uploaded'}">   
    												<ul> 
    												<li> <a href="${commonList2[7]}" target="_blank"> ${commonList2[7]}</a></li>
    												 <li><a href="${commonList2[2]}" target="_blank">${commonList2[2]}</a></li>
    												 </ul>    
															</ct:if> 
															 
													</ct:forEach> 
													<br />
													<br />
													<h4>Content Link</h4>  
												<ct:forEach items="${commonList2}" 
														var="commonList2" varStatus="loop"> 
													
															<ct:if test="${commonList.courseCode==commonList2[0]}">   
											
    												<ul>  
    												 <li><a href="${commonList2[2]}" target="_blank">${commonList2[2]}</a></li>
    												 </ul>     
    												
															</ct:if> 
															
													</ct:forEach> 
													
													 
																
</div>
																</div>
													
													 
																
</div>
																</div> 
													</ct:forEach>
													</ct:if>
													</ct:if>
													


		
						
			</body> 			
						
</section> 


<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].onclick = function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight){
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    } 
  }
}
</script>
