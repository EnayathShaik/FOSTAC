
        <section>
            <div class="container-fluid">
                <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12">

                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>

                                </div>
                                <div id="navbar" class="navbar-collapse collapse">

                                    <ul class="nav navbar-nav">
                                    <li class="hori"><a href="index.html">Home</a></li>
                                    <li class="hori"><a href="update-personal-information.html">Update Personal Information</a></li>
                                    <li class="hori"><a href="contactAssessorPage.fssai">Contact Us</a></li>
                                    </ul>

                                    <ul class="nav navbar-nav navbar-right">
                                        <li class="dropdown active">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i>  <span class="caret"></span></a>
                                            <ul class="dropdown-menu">
                                                <li><a href="#">Change Password</a></li>
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
                      <li> <a href="assessment-calendar.fssai">Assessment Calendar</a> </li>
                      <li> <a href="mark-attendance.fssai">Mark Attendance</a> </li>
                      <li> <a href="update-result.fssai">Update Result</a> </li>
                    </ul>
                    </div>
                    <!-- /#sidebar-wrapper -->
                    <!-- Page Content -->
                    <div id="page-content-wrapper">
                        <div class="container-fluid">

                            <!-- vertical button -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle">
                                        <i class="fa fa-bars"></i> <span class="orange-font">Welcome Training Partner</span>
                                    </a>
                                </div>
                            </div>

                            <!-- add the content here for main body -->
                            <!-- timeline  -->
                            <div class="container-fluid">
                                <div class="row">

                                    <!-- search and apply vacancies -->
                                    <div class="col-xs-12">
                                        <fieldset>
                                        <legend><h3>Assessor Attendance</h3></legend>
                                        <div class="row">
                                            <div class="col-xs-12">

                                                <!-- left side -->
                                                <div class="col-md-6 col-xs-12">
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Course Name:</strong></li>
                                                                
                                                            </ul>
                                                        </div>
                                                        <select class="form-control">
                                                            <option>Basic</option>
                                                            <option>Advanced</option>
                                                            <option>Special</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Assessment Date:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="date" class="form-control">
                                                    </div>

                                                </div>

                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Assessment Time</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="time" class="form-control">
                                                    </div>

                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Center</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <select class="form-control">
                                                            <option>Skill India</option>
                                                            <option>FSSAI</option>
                                                            <option>PMKVY</option>
                                                        </select>
                                                    </div>
                                                     <button type="submit" class="btn login-btn pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false">Show Details</button>
                                                </div>
                                               
                                            </div>

                                            <div class="col-md-3 hidden-xs"></div>
                                        </div>
                                        </fieldset>


                                    </div>

                                    <!-- search Results -->
                                    <div class="col-xs-12 collapse table-overflow-responsive" id="show-result" aria-expanded="false" style="height: 0px;">
                                        <fieldset style="margin-top: 20px;">
                                        <legend><h4>Search Results</h4></legend>

                                              <!-- table -->
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <table class="table table-bordered table-responsive table-striped table-hover">
                                                    <thead>
                                                        <tr class="background-open-vacancies">
                                                            <th>S.No.</th>
                                                            <th>Course Name</th>
                                                            <th>Assessment Date</th>
                                                            <th>Assessment Time</th>
                                                            <th>Attendance</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>1</td>
                                                            <td>HACCP* Course for Milk Industry</td>
                                                            <td>12/11/2016</td>
                                                            <td>12:00</td>
                                                            <td>
                                                                <select class="form-control">
                                                                    <option>Present</option>
                                                                    <option>Absent</option>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>2</td>
                                                            <td>GHP-GMP* Certification Course</td>
                                                            <td>28/10/2016</td>
                                                            <td>11:00</td>
                                                            <td>
                                                                <select class="form-control">
                                                                    <option>Present</option>
                                                                    <option>Absent</option>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>3</td>
                                                            <td>HACCP Course for Water & Beverages Industry</td>
                                                            <td>28/09/2016</td>
                                                            <td>10:30</td>
                                                            <td>
                                                                <select class="form-control">
                                                                    <option>Present</option>
                                                                    <option>Absent</option>
                                                                </select>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        </fieldset>


                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>







