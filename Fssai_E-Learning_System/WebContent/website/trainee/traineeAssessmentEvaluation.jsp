<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<script src="website/js/jquery.js"></script> 

<script>
function OnStart(){
	$('#tblAssessmentEval').append('<tr class="background-open-vacancies">'+
			'<td width="36%" style="padding:15px;"><strong>Total number of Questions:</strong></td>'+
   			'<td width="52%" align="center"><strong>'+formData.totalQuestions+'</strong></td>'+
 			'</tr>');
	$('#tblAssessmentEval').append('<tr class="background-open-vacancies">'+
    '<td style="padding:15px;"><strong>Total number of correct answers:</strong></td>'+
    '<td align="center"><strong><span id ="correctAnswers">'+formData.correctAnswers+'</span></strong></td>'+
  '</tr>');
	$('#tblAssessmentEval').append('<tr class="background-open-vacancies">'+
    '<td style="padding:15px;"><strong>Total number of incorrect answers:</strong></td>'+
    '<td align="center"><strong><span id ="wrongAnswers"></span>'+formData.incorrectAnswers+'</strong></td>'+
  '</tr>');
  $('#tblAssessmentEval').append('<tr class="background-open-vacancies">'+
    '<td style="padding:15px;"><strong>Total Score %:</strong></td>'+
    '<td align="center"><strong><span id ="totalScore">'+formData.totalScore+'%</span></strong></td>'+
  '</tr>');
  $('#tblAssessmentEval').append('<tr class="background-open-vacancies">'+
    '<td style="padding:15px;"><strong>Result:</strong></td>'+
    '<td bgcolor="#00CC33" align="center"><strong><span id ="result"></span>'+
    '<a href="feedback-timeline.html" style="color:#fff;">'+formData.result+'</a></strong></td>'+
  '</tr>');
}
window.onload = OnStart;
</script>
<style>
#news .item img {
	display: block;
	width: 100%;
	height: auto;
}
</style>
</head>
<!-- <body> -->
<!-- logos -->
 <section>
  <div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top top-logo-background">
      <div class="container-fluid">
        <div class="row">
          <div class="col-xs-6 fostac-logo-left"> <a href="index.html"><img src="img/fostac-logo.png" class="img-responsive fostac-logo-top-padding" alt="logo" /></a> </div>
          <div class="col-xs-6 fssai-logo-right"> <a href="#"><img src="img/fssai-logo.png" class="img-responsive pull-right" alt="logo" /></a> </div>
        </div>
      </div>
    </nav>
  </div>
</section>

<!-- horizontal navigation -->
<section>
  <%@include file="../roles/top-menu.jsp"%>
</section>

<!-- main body -->
<section class="main-section-margin-top">
  <div class="container-fluid">
    <div id="wrapper"> 
      
      <!-- Sidebar menu -->
      <div id="sidebar-wrapper">
       <%@include file="../roles/slider.jsp" %>
      </div>
      <!-- Sidebar menu --> 
      <!-- /#sidebar-wrapper --> 
      <!-- Page Content -->
      <div id="page-content-wrapper">
        <div class="container-fluid"> 
          <!-- vertical button -->
          <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Trainee</span> </a> </div>
          </div>
          <!-- add the content here for main body --> 
          <!-- timeline  -->
          
          <cf:form name ="traineeAssessmentEvaluation" commandName="traineeAssessmentEvaluation">
          <section class="section-form-margin-top" id="assessment">
            <div class="container"> 
              <!-- login form -->
              <div class="row">
                <div class="col-md-12  col-xs-12">
                  <fieldset>
                    <legend>
                    <h3>Assessment Results</h3>
                    </legend>
                    <table id="tblAssessmentEval" width="80%" border="0" align="left" class="container-fluid table-bordered table-responsive">
                      
                    </table>
                  </fieldset>
                </div>
                <div class="col-md-2 hidden-xs"></div>
              </div>
            </div>
            <script>
          	var formObj = '${traineeAssessmentEvaluation}';
            var formData = JSON.parse(formObj);
          </script>
          </section>
  		</cf:form>        
        </div>
      </div>
    </div>
  </div>
</section>
<!-- </body> -->
</html>