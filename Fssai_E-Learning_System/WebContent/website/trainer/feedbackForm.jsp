<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<%System.out.print("trainee home page jsp"); %>
<script type="text/javascript">
function onFeedbackSave(feedbackMasterList){
	var courseId=$('#courseId').val();
	var feedbackMastersIds=[];
	//
	$('div').find('input:hidden').each(function(){
		if($(this).val()==="feedback"){
			//feedbackRating
			var id=$(this).attr('id');
			var feedbackRadioId="feedbackRating"+id;
			var value=$('input[name='+feedbackRadioId+']:checked').val();
			feedbackMastersIds.push(id+'`'+value)
		}
     });
	
	console.log(feedbackMastersIds.length)
	 $.ajax({
	      type: 'post',
	      url: 'saveFeedbackForm.jspp',
	      data: {
	    	  courseId:courseId,
	    	  feedbackMastersIds:feedbackMastersIds.join()
	      },
	      success: function (response) {
	    	  window.location.href ='/Fssai_E-Learning_System/redirectHome.fssai'
	      }
	      });
	
}
<!--

//-->
</script>
<section>
	<div class="container-fluid">
		<nav
			class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar"
								arfeedbackRating${feedbackMaster[1]}-expanded="false" arfeedbackRating${feedbackMaster[1]}-controls="navbar">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li class="active hori"><a href="redirectHome.fssai">Home</a></li>
								<li class="hori"><a href="updateInformation.fssai">Update
										Information</a></li>
								<li class="hori"><a href="contactTrainee.fssai">Contact
										Us</a></li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li class="dropdown active"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									arfeedbackRating${feedbackMaster[1]}-haspopup="true" arfeedbackRating${feedbackMaster[1]}-expanded="false"><i
										class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="changePasswordTrainee.fssai">Change
												Password</a></li>
										<li><a href="fostac.fssai">Logout</a></li>
									</ul></li>
							</ul>
						</div>
						<!--/.nav-collapse -->
					</div>
				</div>
			</div>
		</nav>
	</div>
</section>

<!-- main body -->
<section class="main-section-margin-top">
	<div class="container-fluid">
		<div id="wrapper">

			<!-- Sidebar menu -->
	<%@include file="leftMenuTrainer.jspf"%>
			<!-- Sidebar menu -->
			<!-- /#sidebar-wrapper -->
			<!-- Page Content -->
			<div id="page-content-wrapper">
				<div class="container-fluid">
				 <input type="hidden" id="courseId" value="${courseName.coursenameid}">
				 <div class="row">
                  <div class="table-responsive">
                <div class="col-xs-12">
                <fieldset>
                    <legend>
                    <h3>Course Details</h3>
                    </legend>
                    <h4>Course Name: <span class="f16">${courseName.coursename}</span></h4>
                    <h4>Course Code: <span class="f16">${courseName.coursenameid}</span></h4>
                    <h4>Course Duration: <span class="f16">${courseName.courseduration}</span></h4>
                  </fieldset>
                  <br>
                      <fieldset>
                    <legend>
                    <h3 style="padding-bottom:20px;">Feedback</h3>
                    </legend>
                    <table class="table table-bordered table-striped table-responsive table-hover">
                          <thead>
                        <tr class="blue-table-head">
                              <th>Feedback Point</th>
                              <th class="text-center">1</th>
                              <th class="text-center">2</th>
                              <th class="text-center">3</th>
                              <th class="text-center">4</th>
                              <th class="text-center">5</th>
                            </tr>
                      </thead>
                          <tbody>
						  <ct:forEach items="${feedbackMasters}" var="feedbackMaster">
						  <input type="hidden" id="${feedbackMaster[0]}" value="feedback">
						    <tr>      
						        <td>${feedbackMaster[1]}</td>
							  <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="1"></td>
                              <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="2"></td>
                              <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="3"></td>
                              <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="4"></td>
                              <td class="text-center"><input type="radio" name="feedbackRating${feedbackMaster[0]}" value="5"></td>
						    </tr>
						</ct:forEach>
                      </tbody>
                        </table>
                    <div class="col-xs-12">
                          <ul class="feed-no">
                        <li class="feed-li"><span><strong>1</strong></span>&nbsp;<span>Poor</span></li>
                        <li class="feed-li"><span><strong>2</strong></span>&nbsp;<span>Good</span></li>
                        <li class="feed-li"><span><strong>3</strong></span>&nbsp;<span>Better</span></li>
                        <li class="feed-li"><span><strong>4</strong></span>&nbsp;<span>Best</span></li>
                        <li class="feed-li"><span><strong>5</strong></span>&nbsp;<span>Excellent</span></li>
                      </ul>
                        </div>
                    <div class="col-md-4 col-x-12"></div>
                    <div class="col-md-4 col-x-12"></div>
                    
                    <div class="col-md-4 col-x-12"> <a href="#" onclick="onFeedbackSave(${feedbackMaster})" class="btn login-btn pull-right">Submit</a> </div>
                  </fieldset>
                    </div>
              </div>
                </div>
				</div>
			</div>
		</div>
	</div>
</section>
