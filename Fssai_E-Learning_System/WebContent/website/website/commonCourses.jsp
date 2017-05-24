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
			$("#a").css("display", "block");
		}
		if (p==6) {
			$("#b").css("display", "block");
		}
		if (p==7) {
			$("#c").css("display", "block");
		}
		if (p==8) {
			$("#d").css("display", "block");
		}
	} 
window.onload = OnStart;
</script>

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
                      <h3  id="a" style="display:none;">Basic Food Safety Certification</h3>
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
													<thead>
														<tr class="background-open-vacancies">
															<th>S.No.</th>
															<th>Course Code</th>
															 <th>Course Name</th>
															<th>Duration</th>
															<th>Free/Paid</th>
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
</section> 
