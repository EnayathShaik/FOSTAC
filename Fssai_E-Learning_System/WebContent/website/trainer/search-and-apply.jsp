  
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
                    <li class="hori active"><a href="search-and-apply.fssai">Search & Apply Vacancy</a></li>
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
          <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
              <!-- <li class="sidebar-brand">
                                </li> -->
              <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Course Enrollment <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="basicTrainer.fssai" class="clr">Basic Course</a></li>
                  <li><a href="advance.fssai" class="clr">Advanced Course</a></li>
                  <li><a href="special.fssai" class="clr">Special Course</a></li>
                </ul>
              </li>
              <li> <a href="generate-admit-card.fssai">Generate Admit Card</a> </li>
              <li> <a href="course-training.fssai">Training</a> </li>
              <li> <a href="assessment-instructions.fssai">Assessment</a> </li>
              <li> <a href="feedback-form.fssai">Feedback</a> </li>
              <li> <a href="generate-certificate.fssai">Certification</a> </li>
            </ul>
          </div>
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
                <fieldset>
                  <legend>
                  <h3>Search and Apply Vacancies</h3>
                  </legend>
                  <div class="row"> 
                    <!-- search and apply vacancies -->
                    <div class="col-xs-12">
                      <div class="row">
                        <div class="col-xs-12"> 

                          <!-- left side -->
                          <div class="col-xs-6">
                            <div class="form-group">
                              <label>Course Type:</label>
                              <select class="form-control">
                                <option>Basic</option>
                                <option>Advanced</option>
                                <option>Special</option>
                              </select>
                            </div>
                            <div class="form-group">
                              <label>Course Name:</label>
                              <select class="form-control">
                                <option>GHP-GMP* Certification Course</option>
                                <option>GHP-GMP* Certification Course (GHP-GMP Advance)</option>
                                <option>HACCP* Course for Milk Industry</option>
                              </select>
                            </div>
                            <div class="form-group">
                              <label>Training Partner:</label>
                              <select class="form-control">
                                <option>Skill India</option>
                                <option>PMKY</option>
                                <option>UGC</option>
                              </select>
                            </div>
                          </div>

                          <!-- right side -->
                          <div class="col-xs-6">
                            <div class="form-group">
                              <label>Training Center:</label>
                              <select class="form-control">
                                <option>KarolBagh</option>
                                <option>Bikaner Rajhsthan</option>
                                <option>Chennai</option>
                              </select>
                            </div>
                            <div class="form-group">
                              <label>Training Date:</label>
                              <input type="date" class="form-control" />
                            </div>
                          </div>
                          <br>
                          <button style="margin-top:30px;" type="submit" class="btn login-btn pull-right show-details-vacancy" data-toggle="collapse" data-target="#show-result">Show Details</button>
                        </div>
                        <div class="col-md-3 hidden-xs"></div>
                      </div>
                    </div>                   
                  </div>
                </fieldset>
                  
                  <!-- search result -->
                  <div class="col-xs-12">   
                      
                       <!-- search Results -->
                    <div class="col-xs-12 collapse table-overflow-responsive" id="show-result">
                      <fieldset style="margin-top:20px;">
                        <legend>
                        <h4>Search Results</h4>
                        </legend>
                        <!-- table -->
                        <div class="row">
                        <div class="col-xs-12">
                        <table class="table table-bordered table-responsive table-striped table-hover">
                          <thead>
                            <tr class="background-open-vacancies">
                              <th>S.No</th>
                              <th>Course Type</th>
                              <th>Course Name</th>
                              <th>Training Partner</th>
                              <th>Training Center Name</th>
                              <th>Contact Person Name, Address, Phone</th>
                              <th>Vacancy</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>1
                                <input type="checkbox" /></td>
                              <td>Basic</td>
                              <td>GHP-GMP* Certification Course</td>
                              <td>FSSAI</td>
                              <td>KarolBagh</td>
                              <td>Rahul Tiwari, KarolBagh, 9811234568</td>
                              <td>1</td>
                            </tr>
                            <tr>
                              <td>2
                                <input type="checkbox" /></td>
                              <td>Advance</td>
                              <td>GHP-GMP-HACCP Certification</td>
                              <td>FSSAI</td>
                              <td>Bikaner Rajsthan</td>
                              <td>Manoj Dabas, Rajstha, 9900112233</td>
                              <td>3</td>
                            </tr>
                            <tr>
                              <td>3
                                <input type="checkbox" /></td>
                              <td>Special</td>
                              <td>HACCP* Course for Milk Industry</td>
                              <td>UGC</td>
                              <td>Chennai</td>
                              <td>Sunil Shekhawat, 9811456890</td>
                              <td>8</td>
                            </tr>
                          </tbody>
                        </table>
                        <a href="#" class="btn login-btn pull-right">Apply</a>
                      </fieldset>
                    </div>
                      
                  </div>
                  
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- scripts --> 
