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
  <div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="hori"><a href="index.html">Home</a></li>
            <li class="hori"><a href="update-information.html">Update Information</a></li>
            <li class="hori"><a href="contact.html">Contact Us</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="change-password.html">Change Password</a></li>
                <li><a href="#">Logout</a></li>
              </ul>
            </li>
          </ul>
        </div>
        <!--/.nav-collapse --> 
      </div>
    </nav>
  </div>
</section>

<!-- main body -->
<section class="main-section-margin-top">
  <div class="container-fluid">
    <div id="wrapper"> 
      
      <!-- Sidebar menu -->
      <div id="sidebar-wrapper">
       <%@include file="leftMenuTrainee.jspf"%>
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