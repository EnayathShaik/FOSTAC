<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<%System.out.print("trainee home page jsp"); %>
<section>
      <div class="container-fluid">
    <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
          <div class="container">
        <div class="row">
              <div class="col-xs-12">
            <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                </div>
            <div id="navbar" class="navbar-collapse collapse">
                  <ul class="nav navbar-nav">
                <li class="active hori"><a href="redirectHome.fssai">Home</a></li>
                <li class="hori"><a href="updateInformation.fssai">Update Information</a></li>
                <li class="hori"><a href="contactTrainee.fssai">Contact Us</a></li>
              </ul>
                  <ul class="nav navbar-nav navbar-right">
                <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                      <ul class="dropdown-menu">
                    <li><a href="changePasswordTrainee.fssai">Change Password</a></li>
                    <li><a href="fostac.fssai">Logout</a></li>
                  </ul>
                    </li>
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
       <%@include file="leftMenuTrainee.jspf"%>
       <!-- Sidebar menu -->
          <!-- /#sidebar-wrapper --> 
          <!-- Page Content -->
          <div id="page-content-wrapper">
        <div class="container-fluid"> 
              <!-- timeline  -->
              
              <div class="container-fluid">
            <div class="row">
                  <div class="col-xs-12">
          <!-- feedback form  -->
          <div class="container-fluid">
            <div class="row">
              <div class="table-responsive">
                <div class="col-xs-12">
                  <fieldset>
                    <legend><h3>Course Training</h3></legend>
                    <h4>Course Name: <span class="f16">${courseTrainee.courseName}</span></h4>
                    <h4>Course Code: <span class="f16">${courseTrainee.courseTypeId}</span></h4>
                    <h4>Course Duration: <span class="f16">${courseTrainee.courseDuration}</span></h4><br>
                    
                  </fieldset>
                  <br>
                  
                </div>
              </div>
            </div>
            <!-- row ends --> 
          </div>
                  <!-- fluid ends --> 
                  
 <div class="container-fluid">
            <div class="row">
              <div class="table-responsive">
                <div class="col-xs-12">
                  <fieldset>
                    <legend><h3>Course Curriculum</h3></legend>
                    <h3><span class="f16">Topic 1</span></h3>
                    <h5><a href="playvedio.fssai">${courseTrainee.contentNameInput}</a></h5>
                  </fieldset>
                  <br>
                  
                </div>
              </div>
            </div>
            <!-- row ends --> 
          </div>


              
              </div>
                </div>
          </div>
            </div>
      </div>
        </div>
  </div>
    </section>
    <script>
    $(".video1").css({"display":"none"});
// $("#video1").hide();
</script>