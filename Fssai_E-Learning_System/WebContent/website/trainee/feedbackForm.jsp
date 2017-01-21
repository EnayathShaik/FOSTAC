<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<%System.out.print("trainee home page jsp"); %>
<script type="text/javascript">
function OnStart(){
	var steps = 5;
	var traineeSteps =
		<%=(Integer) session.getAttribute("traineeSteps")%>
	if(steps > traineeSteps){
	}else{
		if(steps-1 == traineeSteps){
			alert('Please Complete Your Previous Training First')
		}else{
			alert('Please Flow Step By Step..');
		}
		window.location.href ='/Fssai_E-Learning_System/loginProcess.fssai';
	}
}
window.onload = OnStart;
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
	    	  alert('Thanks for your feedback.');
	    	  window.location.href ='/Fssai_E-Learning_System/afterFeedbackSubmit.fssai'
	      }
	      });
	
}
<!--

//-->


// $('td', 'table').each(function(i) {
//     //$(this).text(23+1);
// });



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
						<%@include file="../roles/top-menu.jsp"%>
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
			
<%@include file="../roles/slider.jsp" %>
			<!-- Sidebar menu -->
			<!-- /#sidebar-wrapper -->
			<!-- Page Content -->
			<div id="page-content-wrapper">
				<div class="container-fluid">
				 <input type="hidden" id="courseId" value="${courseTrainee.courseNameID}">
				 <div class="row">
                  <div class="table-responsive">
                <div class="col-xs-12">
                <fieldset>
                    <legend>
                    <h3>Course Details</h3>
                    </legend>
                   <%@include file="../commonjsp/course.jsp" %>
                     </fieldset>
                  <br>
                      <fieldset>
                    <legend>
                    <h3 style="padding-bottom:20px;">Feedback</h3>
                    </legend>
                    <table class="table table-bordered table-striped table-responsive table-hover paginated">
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
<!--/#footer-->
<script src="website/js/jquery.js"></script> 
<script src="website/js/bootstrap.min.js"></script> 
<script src="website/js/jquery.isotope.min.js"></script> 
<style>
div.pager {
    text-align: center;
    margin: 1em 0;
}

div.pager span {
    display: inline-block;
    width: 1.8em;
    height: 1.8em;
    line-height: 1.8;
    text-align: center;
    cursor: pointer;
    background: #bab8bd;
    color: #fff;
    margin-right: 0.5em;
}

div.pager span.active {
    background: #534e9e;
}

</style>

<script type="text/javascript">


$('table.paginated').each(function() {
    var currentPage = 0;
    var numPerPage = 5;
    var $table = $(this);
    $table.bind('repaginate', function() {
        $table.find('tbody tr').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
    });
    $table.trigger('repaginate');
    var numRows = $table.find('tbody tr').length;
    var numPages = Math.ceil(numRows / numPerPage);
    var $pager = $('<div class="pager"></div>');
    for (var page = 0; page < numPages; page++) {
        $('<span class="page-number"></span>').text(page + 1).bind('click', {
            newPage: page
        }, function(event) {
            currentPage = event.data['newPage'];
            $table.trigger('repaginate');
            $(this).addClass('active').siblings().removeClass('active');
        }).appendTo($pager).addClass('clickable');
    }
    $pager.insertBefore($table).find('span.page-number:first').addClass('active');
});
</script>