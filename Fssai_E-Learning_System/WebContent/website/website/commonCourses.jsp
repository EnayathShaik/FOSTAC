<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>

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
                    </ul>
                </div>
            </div>
        </div>
        <!--/.item-->
        <!--/.item-->
        <!--/.item-->
    </div>
    <!--/.carousel-inner-->
    <!--/.carousel-->
</section>
<!--/#main-slider-->
<section id="feature">
    <div class="container">
        <div class="row">
            <div class="features">
                <div class="col-md-12 col-xs-12 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap feature-wrapbasic"> <img class="img-responsive center-block" src="website/images/fssai-certification-logo.jpg" width="132" height="87">
                        <h3>Basic Food Safety Certification</h3>
                    </div>
                </div>
                <!--/.col-md-4-->
                <!--/.col-md-4-->
                <!--/.col-md-4-->
            </div>
            <!--/.services-->
        </div>
        <!--/.row-->
    </div>
    <!--/.container-->
</section>

<section>
  <!--   <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
        <div class="row">
            <div class="col-md-2 col-xs-12"></div>
            <div class="col-md-10 col-xs-14">
                collapsible accordion
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#course">Course Name</a></li>
                    <li><a data-toggle="tab" href="#training">Training Partner</a></li>
                    <li><a data-toggle="tab" href="#duration">Duration</a></li>
                    <li><a data-toggle="tab" href="#who">Target Participant</a></li>
                    <li><a data-toggle="tab" href="#curriculum">Study Material</a></li>
                </ul>
                content for above tabs
                <div class="tab-content">
                    <div id="course" class="tab-pane fade in active">
                        <ul id="courseul"></ul>
                    </div>
                    <div id="training" class="tab-pane fade">
                        <ul id="trainingul"></ul>
                    </div>
                    <div id="duration" class="tab-pane fade">
                        <ul id="durationul">
                        </ul>
                    </div>
                    <div id="who" class="tab-pane fade">
                        <ul>
                            <li class="fsize">Any Individual</li>
                        </ul>
                    </div>
                    <div id="curriculum" class="tab-pane fade">
                        <h4>PPT</h4>
                        <ul id="ppts">
                        </ul>
                        <h4>Videos</h4>
                        <ul id="vedios">
                        </ul>
                    </div>
                </div>

                tabs navigation

            </div>
            <div class="col-md-2 col-xs-12"></div>
        </div>
    </div> -->
    
    
    
    
    
    
    <div class="col-xs-12 " id="testt">
								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
										<ct:if test="${!empty cateringList}">
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
													<ct:forEach items="${cateringList}"
														var="cateringList" varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${cateringList.courseCode}</td>
														<td>${cateringList.coursename}</td>
															<td>${cateringList.courseduration}</td>
															<td>${cateringList.paidunpaid}</td> 
															<%-- <td>${cateringList.attendance}</td>
															<td><input type="checkbox"></td> --%>
														</tr>
													</ct:forEach>
												</table>
											<!-- 	<div class="col-md-06 col-xs-12" style="margin-top: -72px;">
												<input type="button" id="savebtn" value="Save"
													style=" float: right;"
													 class="btn login-btn" />  -->
											
										</fieldset>
										</ct:if>
									</div>
								</div>
							</div>
    
    
    
    
    
    
    
      <div class="col-xs-12 " id="testt">
								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
									<ct:if test="${!empty manufacturingList}">
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
													<ct:forEach items="${manufacturingList}"
														var="manufacturingList" varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${manufacturingList.courseCode}</td>
														<td>${manufacturingList.coursename}</td>
															<td>${manufacturingList.courseduration}</td>
															<td>${manufacturingList.paidunpaid}</td> 
															<%-- <td>${cateringList.attendance}</td>
															<td><input type="checkbox"></td> --%>
														</tr>
													</ct:forEach>
												</table>
											<!-- 	<div class="col-md-06 col-xs-12" style="margin-top: -72px;">
												<input type="button" id="savebtn" value="Save"
													style=" float: right;"
													 class="btn login-btn" />  -->
											
										</fieldset>
										</ct:if>
									</div>
								</div>
							</div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      <div class="col-xs-12 " id="testt">
								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
									<ct:if test="${!empty transportList}">
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
													<ct:forEach items="${transportList}"
														var="transportList" varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${transportList.courseCode}</td>
														<td>${transportList.coursename}</td>
															<td>${transportList.courseduration}</td>
															<td>${transportList.paidunpaid}</td> 
															<%-- <td>${cateringList.attendance}</td>
															<td><input type="checkbox"></td> --%>
														</tr>
													</ct:forEach>
												</table>
											<!-- 	<div class="col-md-06 col-xs-12" style="margin-top: -72px;">
												<input type="button" id="savebtn" value="Save"
													style=" float: right;"
													 class="btn login-btn" />  -->
											
										</fieldset>
										</ct:if>
									</div>
								</div>
							</div>
    
    
    
    
    
    
    
    
    
    
    
    
      <div class="col-xs-12 " id="testt">
								<!-- table -->
								<div class="row">
									<div class="col-xs-12">
									<ct:if test="${!empty retailList}">
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
													<ct:forEach items="${retailList}"
														var="retailList" varStatus="loop">
														<tr>
															<td>${loop.count}</td>
															<td>${retailList.courseCode}</td>
														<td>${retailList.coursename}</td>
															<td>${retailList.courseduration}</td>
															<td>${retailList.paidunpaid}</td> 
															<%-- <td>${cateringList.attendance}</td>
															<td><input type="checkbox"></td> --%>
														</tr>
													</ct:forEach>
												</table>
											<!-- 	<div class="col-md-06 col-xs-12" style="margin-top: -72px;">
												<input type="button" id="savebtn" value="Save"
													style=" float: right;"
													 class="btn login-btn" />  -->
											
										</fieldset>
										</ct:if>
									</div>
								</div>
							</div>
    
    
    
    
    
    
    <script src="website/js/jquery.js"></script>
    <script src="website/js/bootstrap.min.js"></script>
    <script src="website/js/jquery.isotope.min.js"></script>

    <script type="text/javascript">
        var cousernamelist = $ {
            courseNameList
        };
        for (var index = 0; index < cousernamelist.length; index++) {
            $('#courseul').append(' <li class="fsize">' + cousernamelist[index].coursename + '</li>');
            $('#durationul').append('<li class="fsize">' + cousernamelist[index].courseduration + '</li>');
        }
        var trainingPartnerNameList = $ {
            trainingPartnerNameList
        };
        for (var index = 0; index < trainingPartnerNameList.length; index++) {
            $('#trainingul').append(' <li class="fsize">' + trainingPartnerNameList[index] + '</li>');
        }
        var manageCourseContents = $ {
            manageCourseContents
        };
        for (var index = 0; index < manageCourseContents.length; index++) {
            if (manageCourseContents[index].contentTypeInput === "PPTs") {
                $('#ppts').append('<li class="fsize"><a href="' + manageCourseContents[index].contentLinkInput + '" target="_blank">' + manageCourseContents[index].contentNameInput + '</a></li>');
            } else if (manageCourseContents[index].contentTypeInput === "Videos") {
                $('#vedios').append('<li class="fsize"><a href="' + manageCourseContents[index].contentLinkInput + '" target="_blank">' + manageCourseContents[index].contentNameInput + '</a></li>');
            }
        }

    </script>
</section>
<!-- <script>
    var id = localStorage.getItem('activeID');
    document.getElementById(id).className = "active";

</script> -->
