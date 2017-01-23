<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">

function OnStart(){
	var steps = 3;
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
	
	var isOnline = "${ISONLINE}";
	if(isOnline == 'NO'){
		alert('Content will be available in Classroom');
   	  	window.location.href ='/Fssai_E-Learning_System/loginProcess.fssai';
	}
}
window.onload = OnStart;
</script>

<!-- horizontal navigation -->
<section>
  <%@include file="../roles/top-menu.jsp"%>
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
          <!-- vertical button -->
          <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Mr. Anuj</span> </a> </div>
          </div>
          
          <!-- add the content here for main body --> 
          <!-- feedback form  -->
          
          <div class="container-fluid">
            <div class="row">
              <div class="table-responsive">
                <div class="col-xs-12">
                  <fieldset>
                    <legend><h3>Course Training</h3></legend>
                    <%@include file="../commonjsp/course.jsp" %>
                    <!-- <h4><a class="link-bg text-center" href="training.fssai">Online Training Video</a></h4>
                 	 -->
                 	<!-- <video width="750" height="750" autoplay>
  						<source src="pdf/Sath.mp4" type="video/mp4">
  						Your browser does not support the video tag.
					</video> -->
					<fieldset>
                    <legend><h3>Course Content</h3></legend>
					<ct:choose>
						<ct:when
							test="${contentPath.contains('pdf')}">
							<h4><a href="${contentPath}" target="_blank" >${contentName}</a></h4>
						</ct:when>
					</ct:choose>
					<ct:choose>
						<ct:when
							test="${contentPath.contains('mp4')}">
							<h4><a href="${contentPath}" target="_blank" data-webm="images/Big_Buck_Bunny_2.webm" class="html5lightbox" >${contentName}</a></h4>
						</ct:when>
					</ct:choose>
					<ct:choose>
						<ct:when
							test="${contentPath.contains('ppt')}">
							<h4><a href="${contentPath}" target="_blank" >${contentName}</a></h4>
						</ct:when>
					</ct:choose>
					<fieldset>
					<!-- <h4><a href="pdf/A.mp4?autoPlay=true" target="_blank" data-webm="images/Big_Buck_Bunny_2.webm" class="html5lightbox" >Video Offline</a></h4>
					<h4><a href="pdf/Fostac.pdf" target="_blank" >Fostac1 In PDF</a></h4>
					<h4><a href="pdf/FostacPPT.pptx" target="_blank" >Fostac In PPT</a></h4>
				 -->	
					
                  </fieldset>
                  <br>
                  
                </div>
              </div>
            </div>
            <!-- row ends --> 
          </div>
          <!-- fluid ends --> 
        </div>
      </div>
    </div>
  </div>
</section>
<!-- scripts --> 
