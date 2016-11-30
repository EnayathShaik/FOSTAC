
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
                <li class="active hori"><a href="#">Home</a></li>
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
      
      <!-- Sidebar -->
    <%@include file="leftMenuTrainer.jspf" %>
      <!-- /#sidebar-wrapper --> 
      <!-- Page Content -->
      <div id="page-content-wrapper">
        <div class="container-fluid"> 
          
          <!-- vertical button -->
          <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Trainer</span> </a> </div>
          </div>
          
          <!-- add the content here for main body --> 
          <!-- timeline  -->
          
          <div class="container-fluid">
            <div class="row"> 
              
              <!-- table -->
              <div class="row">
                <div class="col-xs-12 table-overflow-responsive">
                  <div class="personel-info">
                    <fieldset>
                      <legend>
                      <h3 style="padding-bottom:20px;">My Training Calendar</h3>
                      </legend>
                      <table class="table table-bordered table-hover table-striped table-responsive table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No.</th>
                            <th>Course Type</th>
                            <th>Course Name</th>
                            <th>Training Date &amp; Time</th>
                            <th>Training Center Name &amp; Address</th>
                            <th>Contact Person Name</th>
                            <th>Contact Person Phone Number &amp; Email ID</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>1</td>
                            <td>Basic</td>
                            <td>GHP-GMP</td>
                            <td><p><strong>Date:</strong> 12/01/2015</p>
                              <p><strong>Time:</strong> 12:00 AM</p></td>
                            <td>FSSAI, ITO</td>
                            <td>Mr. Smith</td>
                            <td>P: 98763524125 <br>E: ajun.j@gmail.com</td>
                          </tr>
                          <tr>
                            <td>2</td>
                            <td>Special</td>
                            <td>HACCP</td>
                            <td><p><strong>Date:</strong> 12/01/2015</p>
                              <p><strong>Time:</strong> 12:00 AM</p></td>
                            <td>FBO Bhavan, Kotla Road</td>
                            <td>Mr. Smith</td>
                            <td>P: 98763524125 <br>E: ajun.j@gmail.com</td>
                          </tr>
                          <tr>
                            <td>3</td>
                            <td>Advanced</td>
                            <td>GHP-GMP-HACCP</td>
                            <td><p><strong>Date:</strong> 12/01/2015</p>
                              <p><strong>Time:</strong> 12:00 AM</p></td>
                            <td>FSSAI, ITO</td>
                            <td>Mr. Smith</td>
                            <td>P: 98763524125 <br>E: ajun.j@gmail.com</td>
                          </tr>
                        </tbody>
                      </table>
                      <div class="row">
                        <div class="col-md-6 hidden-xs"></div>
                        <!-- pagination -->
                        <div class="col-md-6 col-xs-12 pagination-right">
                          <nav aria-label="Page navigation">
                            <ul class="pagination pull-right">
                              <li> <a href="#" aria-label="Previous"> <span aria-hidden="true">«</span> </a> </li>
                              <li><a href="#">1</a></li>
                              <li><a href="#">2</a></li>
                              <li><a href="#">3</a></li>
                              <li><a href="#">4</a></li>
                              <li><a href="#">5</a></li>
                              <li> <a href="#" aria-label="Next"> <span aria-hidden="true">»</span> </a> </li>
                            </ul>
                          </nav>
                        </div>
                      </div>
                    </fieldset>
                  </div>
                </div>
              </div>
              <!-- row ends --> 
              <br>
              <!-- open vacancies table -->
              <div class="col-xs-12"> 
                
                <!-- table -->
                <div class="row">
                  <div class="col-xs-12 table-overflow-responsive">
                    <fieldset>
                      <legend>
                      <h3 style="padding-bottom:20px;">Open Vacancies</h3>
                      </legend>
                      <table class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th width="8%">S.No</th>
                            <th width="15%">Course Type</th>
                            <th width="14%">Course Name</th>
                            <th width="29%">Training Date &amp; Time</th>
                            <th width="23%">Training Center Name &amp; Address</th>
                            <th width="11%"></th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>1</td>
                            <td>Basic</td>
                            <td>GHP-GMP* Certification Course</td>
                            <td><p><strong>Date:</strong> 12/01/2015</p>
                              <p><strong>Time:</strong> 12:00 AM</p></td>
                            <td>FSSAI, FDA Bhvan</td>
                            <td><a href="#" class="btn btn-default">Apply</a></td>
                          </tr>
                          <tr>
                            <td>2</td>
                            <td>Advance</td>
                            <td>HACCP Course for Oil & Fat Industry</td>
                            <td><p><strong>Date:</strong> 10/01/2015</p>
                              <p><strong>Time:</strong> 1:00 PM</p></td>
                            <td>FSSAI, Kotla Road</td>
                            <td><a href="#" class="btn btn-default">Apply</a></td>
                          </tr>
                          <tr>
                            <td>3</td>
                            <td>Special</td>
                            <td>HACCP Course for Water & Beverages Industry</td>
                            <td><p><strong>Date:</strong> 12/01/2015</p>
                              <p><strong>Time:</strong> 12:00 AM</p></td>
                            <td>FSSAI, Kotla Road, ITO</td>
                            <td><a href="#" class="btn btn-default">Apply</a></td>
                          </tr>
                        </tbody>
                      </table>
                    </fieldset>
                  </div>
                </div>
              </div>
              <br>
              <!-- job application -->
              <div class="col-xs-12"> <br>
                <!-- table -->
                <div class="row">
                  <div class="col-xs-12 table-overflow-responsive">
                    <fieldset>
                      <legend>
                      <h3 style="padding-bottom:20px;">Job Application</h3>
                      </legend>
                      <table class="table table-bordered table-responsive table-striped table-hover">
                        <thead>
                          <tr class="background-open-vacancies">
                            <th>S.No</th>
                            <th width="15%">Course Type</th>
                            <th>Course Name</th>
                            <th width="29%">Training Date &amp; Time</th>
                            <th width="23%">Training Center Name &amp; Address</th>
                            <th>Status</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>1</td>
                            <td>Basic</td>
                            <td>GHP-GMP</td>
                            <td><p><strong>Date:</strong> 12/01/2015</p>
                              <p><strong>Time:</strong> 12:00 AM</p></td>
                            <td>FSSAI, FDA Bhvan</td>
                            <td class="bg-success">Selected</td>
                          </tr>
                          <tr>
                            <td>2</td>
                            <td>Advance</td>
                            <td>HACCP Course for Oil & Fat Industry</td>
                            <td><p><strong>Date:</strong> 10/21/2016</p>
                              <p><strong>Time:</strong> 11:30:00 AM</p></td>
                            <td>FSSAI, Kotla Road</td>
                            <td class="bg-danger">Rejected</td>
                          </tr>
                          <tr>
                            <td>3</td>
                            <td>Special</td>
                            <td>HACCP Course for Water & Beverages Industry</td>
                            <td><p><strong>Date:</strong> 11/12/2016</p>
                              <p><strong>Time:</strong> 12:00 AM</p></td>
                            <td>FSSAI, Kotla Road, ITO</td>
                            <td class="bg-primary">Under Process</td>
                          </tr>
                        </tbody>
                      </table>
                    </fieldset>
                  </div>
                </div>
              </div>
              
              <!-- timeline -->
              <div class="container-fluid">
                <div class="row">
                  <div class="col-xs-12">
                    <div class="page-header">
                      <h1 id="timeline">Certification Process for TOT</h1>
                    </div>
                    <ul class="timeline">
                      <li>
                        <div class="timeline-badge success">1</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step 1</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Course Enrollment</p>
                            <p> <a href="basictrainer.fssai">Basic</a> | <a href="advance.fssai">Advance</a> | <a href="special.fssai">Special</a></P>
                          </div>
                        </div>
                      </li>
                      <li class="timeline-inverted">
                        <div class="timeline-badge success">2</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step-2</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Get Your Admit Card</p>
                          </div>
                        </div>
                      </li>
                      <li>
                        <div class="timeline-badge success">3</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step-3</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Attend Training</p>
                            <p><a href="#">Classroom</a></p>
                          </div>
                        </div>
                      </li>
                      <li class="timeline-inverted">
                        <div class="timeline-badge success">4</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step-4</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Get Your Self Assessed</p>
                            <p><a href="#">In Physical Center</a></p>
                          </div>
                        </div>
                      </li>
                      <li>
                        <div class="timeline-badge success">5</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step-5</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Give Your Feedback</p>
                          </div>
                        </div>
                      </li>
                      <li class="timeline-inverted">
                        <div class="timeline-badge success">6</div>
                        <div class="timeline-panel">
                          <div class="timeline-heading">
                            <h4 class="timeline-title">Step-6</h4>
                          </div>
                          <div class="timeline-body">
                            <p>Get Your Certificate</p>
                          </div>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- scripts --> 

