<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	function preventBack() {
		window.history.forward();
	}
	setTimeout("preventBack()", 10);
	window.onunload = function() {
		null
	};
</script>
<%
	System.out.println("Profile ID : "
			+ session.getAttribute("profileId"));
	if (session.getAttribute("profileId").equals(3)) {
		System.out.println("Profile ID : "
				+ session.getAttribute("profileId"));
%>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		 <li><a href="basic.fssai">Course Enrollment</a></li> 
	<!-- 	<li class="dropdown active"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown" role="button" aria-haspopup="true"
			aria-expanded="false">Course Enrollment <span class="caret"></span></a>
			<ul disabled disa class="dropdown-menu">
				<li><a href="basic.fssai" class="clr">Basic Course</a></li>
				<li><a href="advanceTrainee.fssai" class="clr">Advanced
						Course</a></li>
				<li><a href="specialTrainee.fssai" class="clr">Special
						Course</a></li>
			</ul></li>  -->
		<li><a href="generateAdmitCardtrainee.fssai">Generate Admit
				Card</a></li>
		<li><a href="course-training.fssai?courseTypeId=1">Training</a></li>
		<li><a href="assessment-instructions-trainee.fssai">Assessment</a>
		</li>
		<li><a href="feedbackForm.fssai">Feedback</a></li>
		<li><a href="generateCertificatetrainee.fssai">Certification</a>
		</li>
	</ul>
</div>
<%
	} else if (session.getAttribute("profileId").equals(4)) {
%>
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
	<li><a href="search-and-apply.fssai">Search	& Apply Vacancy</a></li>
	
	<!-- 
		<li class="dropdown active"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown" role="button" aria-haspopup="true"
			aria-expanded="false">Course Enrollment <span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="basic.fssai" class="clr">Basic Course</a></li>
				<li><a href="advanceTrainee.fssai" class="clr">Advanced
						Course</a></li>
				<li><a href="specialTrainee.fssai" class="clr">Special
						Course</a></li>
			</ul></li>
		<li><a href="generateAdmitCardtrainee.fssai">Generate Admit
				Card</a></li>
		<li><a href="course-training.fssai?courseTypeId=1">Training</a></li>
		<li><a href="assessment-instructions-trainee.fssai">Assessment</a>
		</li>
		<li><a href="feedbackForm.fssai">Feedback</a></li>
		<li><a href="generateCertificatetrainee.fssai">Certification</a>
		</li> -->
	</ul>
</div>

<%
	} else if (session.getAttribute("profileId").equals(5)) {
%>
<div id="sidebar-wrapper">
        <ul class="sidebar-nav">
          <!-- <li class="sidebar-brand">
                        </li> -->
          <li> <a href="trainingpartnertrainingcalendar.fssai">Training Calendar</a> </li>
          <li> <a href="trainingpartnerviewtraineelist.fssai">View Trainee List</a> </li>
          <li> <a href="trainingpartnermarkAttendence.fssai">Mark Attendance</a> </li>
          <li> <a href="postVacancyTrainingPartner.fssai">Post Vacancy for Trainer</a> </li>
          <li> <a href="trainingpartnerapplicationstatus.fssai">Application Status</a> </li>
          <li> <a href="trainingpartnermanagetrainer.fssai">Manage Trainer</a> </li>
          <!-- <li> <a href="trainingpartnerassessmentcalendar.fssai">Assessment Calendar</a></li> -->
          <li> <a href="trainingpartnerpaymentconfirmation.fssai">Fees</a> </li>
          <li> <a href="generateCourseCertificate.fssai">Generate Certificate</a> </li>
        </ul>
      </div>

<%
	} else if (session.getAttribute("profileId").equals(6)) {
%>
<div id="sidebar-wrapper">
      <ul class="sidebar-nav">
          <!-- <li class="sidebar-brand">
                    </li> -->
          <li> <a href="viewAssessmentAgencyCalendar.fssai">Assessment Calendar</a> </li>
          <li> <a href="trainingpartnermarkAttendence.fssai">Mark Attendance</a> </li>
          <li> <a href="update-result.fssai">Update Result</a> </li>
      </ul>
</div>

<%
	} else if (session.getAttribute("profileId").equals(7)) {
%>
<div id="sidebar-wrapper">
        <ul class="sidebar-nav">
          <!-- <li class="sidebar-brand">
                        </li> -->
          <li> <a href="postVacancyTrainingPartner.fssai">Post Vacancy for Trainer</a> </li>
          <li> <a href="trainingpartnerapplicationstatus.fssai">Application Status</a> </li>
           <li><a href="trainingCalendarForm.fssai">View Training Calendar</a></li>
           <li><a href="viewFeedbackDetails.fssai">View Feedback</a></li>
           <li><a href="registrationFormTrainingPartner.fssai">Register Training Center</a></li>
        </ul>
      </div>

<%
	} else if (session.getAttribute("profileId").equals(8)) {
%>
<div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand"></li> -->
                        <!-- TODO -->
<!--                         <li><a href="viewTrainingCalendar.fssai">View Calendar</a></li> -->
 							<li><a href="viewAssessmentAgencyCalendar.fssai">View Calendar</a></li>
                       
                        
                    </ul>
                </div>

<%
	} else if (session.getAttribute("profileId").equals(1)) {
%>
<div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand"></li> -->
                        <li><a href="manageCourse.fssai">Manage Course</a></li>
                        <li><a href="manageCourseContent.fssai">Manage Course Content</a></li>
                      <!--   <li> <a href="trainingCalendarForm.fssai">Training Calendar</a> </li> -->
                        <li> <a href="trainingpartnerassessmentcalendar.fssai">Update Assessor</a> </li>
                        <li> <a href="manageAssessmentQuestions.fssai">Assessment Questions</a> </li>
                        <li> <a href="updateTrainerAssessmentForm.fssai">TOT Assessment</a> </li>
                        <li> <a href="feedbackMaster.fssai">Feedback Master</a> </li>
                    </ul>
                </div>

<%
	} else if (session.getAttribute("profileId").equals(2)) {
%>
<div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand"></li> -->
                        <li><a href="manageCourse.fssai">Manage Course</a></li>
                        <li><a href="manageCourseContent.fssai">Manage Course Content</a></li>
                        <li> <a href="trainingpartnerassessmentcalendar.fssai">Update Assessor</a> </li>
                        <li> <a href="manageAssessmentQuestions.fssai">Assessment Questions</a> </li>
                        <!-- <li> <a href="updateTrainerAssessmentForm.fssai">TOT Assessment</a> </li> -->
                        <li> <a href="feedbackMaster.fssai">Feedback Master</a> </li>
                    </ul>
                </div>

<%
	}
%>