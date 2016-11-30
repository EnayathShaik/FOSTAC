
<!-- horizontal navigation -->
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
                <li></li>
                <li class="hori"><a href="#">Home</a></li>
                <li class="hori"><a href="search-and-apply.fssai">Search & Apply Vacancy</a></li>
                <li class="hori"><a href="update-profile.fssai">Update Profile</a></li>
                <li class="hori"><a href="contactTrainer.fssai">Contact Us</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="changePasswordTrainer.fssai">Change Password</a></li>
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
  <%@include file="leftMenuTrainer.jspf" %>
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
                    <legend><h3>Generate Admit Card</h3></legend>
                    <h4>Course Name: <span class="f16">GHP-GMP* Certification Course</span></h4>
                    <h4>Course Code: <span class="f16">0034</span></h4>
                    <h4>Course Duration: <span class="f16">2 Hours</span></h4><br>
                    <h4><a class="link-bg text-center" href="admit-card.fssai">Generate Admit Card</a></h4>
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
