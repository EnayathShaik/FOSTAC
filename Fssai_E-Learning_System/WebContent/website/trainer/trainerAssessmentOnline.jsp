<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<%System.out.print("trainee home page jsp"); %>
<script src="website/js/jquery.js"></script> 

        <!-- horizontal navigation -->
        <section>
              <div class="container-fluid">
            <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
                  <div class="container">
                <div class="navbar-header">
                      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    </div>
                 <%@include file="topMenuTrainer.jspf" %>
                <!--/.nav-collapse --> 
              </div>
                </nav>
          </div>
            </section>
             <!-- main body -->
        <section class="main-section-margin-top">
        <div class="container-fluid">
        <div id="wrapper">

        <!-- Sidebar -->
      
        <!-- /#sidebar-wrapper --> 
        <!-- Page Content -->
        <div id="page-content-wrapper">
        <div class="container-fluid">
        <!-- vertical button -->
	<div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> 
			<span class="orange-font">Welcome Trainee</span> </a>
			</div>
          </div>
        <!-- vertical button -->
<FORM action="submitAssessment.fssai" name="myForm" method="POST" >
	<section>
		<div class="row"> 
			<div class="col-md-12  col-xs-12">
			<h3>Assessment Questions</h3>  
			<div id="questionsTable" class="paginated" ></div>
			</div>
		</div>
		
			<script >
			var questionList = ${traineeAssessment};
			
			$('#questionsTable').append('<input type="hidden" name="courseNameId" value = "'+questionList.courseNameId+'">');
// 			$('#questionsTable').append('<input type="hidden" name = "assessmentQuestionsList" value = "+JSON.stringify(assessmentQuestions)+">');
			$(window).load(function () {
				var assessmentQuestions = [];
				for(var index=0;index<questionList.listAssessmentQuestion.length;index++){
					$('#questionsTable').append('<ol>');
					$('#questionsTable').append('<li><strong>Question No.'+questionList.listAssessmentQuestion[index].questionNumber+':</strong>'+questionList.listAssessmentQuestion[index].questionTitle+'</li>')
					
					//var noOption=questionList.listAssessmentQuestion[index].noOfOption;
					assessmentQuestions.push(questionList.listAssessmentQuestion[index].assessmentQuestionId);
					var noOption=6;
					$('#questionsTable').append('<table width="200" border="0">');
					for(var noOptionIndex=1; noOptionIndex<=noOption; noOptionIndex++){
						var questionOption = "option";
						var value= "";
						switch(noOptionIndex){
						case 1:
							value = "One";
							break;
						case 2:
							value = "Two";
							break;
						case 3:
							value = "Three";
							break;
						case 4:
							value = "Four";
							break;
						case 5:
							value = "Five";
							break;
						case 6:
							value = "Six";
							break;
						}
						questionOption += value;
						var questionListRow = questionList.listAssessmentQuestion[index];
						$('#questionsTable').append('<tr><td>'+noOptionIndex+')</td> <td><input name="'+questionList.listAssessmentQuestion[index].assessmentQuestionId+'" type="radio" value="'+noOptionIndex+'"></td><td>'+questionListRow[questionOption]+'</td></tr>')
					}
					$('#questionsTable').append('</table>');
					$('#questionsTable').append('</ol>')
				}
				$('#questionsTable').append('<input type="hidden" name = "assessmentQuestionsList" value = "'+assessmentQuestions+'">');
				$('#questionsTable').append('<input type="hidden" name = "assessmentQuestions" value = "'+JSON.stringify(assessmentQuestions)+'">');
			});
			 </script>
			 
	</section>
	<INPUT TYPE="submit" class="btn login-btn pull-right" VALUE="Save">
</FORM>
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

$(window).load(function () {
	$('div.paginated').each(function() {
	    var currentPage = 0;
	    var numPerPage = 5;
	    var $olList = $(this);
	    $olList.bind('repaginate', function() {
	        $olList.find('ol').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
	        $olList.find('table').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
	        $olList.find('li').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
	        $olList.find('tr').hide().slice(currentPage * numPerPage*6, (currentPage + 1) * numPerPage*6).show();
	    });
	    $olList.trigger('repaginate');
	    var numRows = $olList.find('ol').length;
	    var numPages = Math.ceil(numRows / numPerPage);
	    var $pager = $('<div class="pager"></div>');
	    for (var page = 0; page < numPages; page++) {
	        $('<span class="page-number"></span>').text(page + 1).bind('click', {
	            newPage: page
	        }, function(event) {
	            currentPage = event.data['newPage'];
	            $olList.trigger('repaginate');
	            $(this).addClass('active').siblings().removeClass('active');
	        }).appendTo($pager).addClass('clickable');
	    }
	    $pager.insertBefore($olList).find('span.page-number:first').addClass('active');
	});
});
</script>