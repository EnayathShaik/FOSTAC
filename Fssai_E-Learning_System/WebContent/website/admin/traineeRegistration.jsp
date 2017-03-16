
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
                                    <li class="active hori"><a href="fostac.fssai">Home</a></li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Management<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="trainee-user-management.html" class="clr">Trainee</a></li>
                                            <li><a href="trainer-user-management.html" class="clr">Trainer</a></li>
                                            <li><a href="training-center--user-management.html" class="clr">Training Center</a></li>
                                            <li><a href="assessor-user-management.html" class="clr">Assessor</a></li>
                                            <li><a href="admin--user-management.html" class="clr">Admin</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Master Data<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="state-master.html" class="clr">State</a></li>
                                            <li><a href="district-master.html" class="clr">District</a></li>
                                            <li><a href="city-master.html" class="clr">City</a></li>                                            
                                            <li><a href="region-mapping-master.html" class="clr">Region Mapping</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="manage-training-partner.html">Manage Training Partner</a></li>
                                    <li><a href="manage-assessment-agency.html">Manage Assessment Agency</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="changePasswordAssesAgency.fssai">Change Password</a></li>
                                            <li><a href="#">Logout</a></li>
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
                  <%@include file="../roles/slider.jsp" %>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Trainee Mr. Lorem </span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">
                            <div class="col-md-8  col-xs-12">
                                <h3 class="text-capitalize heading-3-padding">Trainee Registration Form</h3>
                                <form>
                                    <!-- left side -->
                                    <div class="col-md-6 col-xs-12">
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Training Partner Name:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <select required="required" class="form-control">
                                                <option>Skilled India</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Mobile:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="9899112354" class="form-control"> </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Email ID:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="sharmasita13@gmail.com" class="form-control"> </div>
                                        <!-- residential address -->
                                        <div class="form-group">
                                            <hr>
                                            <label>Training Center Address</label>
                                            <hr> </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Training Center Address line 1:</strong></li>
                                                    <input type="text" required placeholder="ITO, Kotla Road" class="form-control">
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Training Center Address line 2:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="Address" class="form-control"> </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>State:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <select required="required" class="form-control">
                                                <option>New Delhi</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Closest City:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <select required="required" class="form-control">
                                                <option>Delhi</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Location:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="ITO" class="form-control"> </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>PIN Code:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="110020" class="form-control"> </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Region:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <select required="required" class="form-control">
                                                <option>Central Delhi</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>District/ States In a Region:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <select required="required" class="form-control">
                                                <option>Delhi</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                                <option>Lorem</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- right side -->
                                    <div class="col-md-6 col-xs-12">
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>First name (Head of Training Center):</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="First Name" class="form-control"> </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Last name (Head of Training Center):</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="Last Name" class="form-control"> </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>PAN No  (Head of Training Center):</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="Pan NO" class="form-control"> </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>Seating Capacity per session:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="10" class="form-control"> </div>
                                        <!-- professional address -->
                                        <div class="form-group">
                                            <label>Availability of TV/Projector in the training room:</label>
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <select required="required" class="form-control">
                                                        <option>Yes</option>
                                                        <option>No</option>
                                                    </select>
                                                </div>
                                                <div class="col-xs-6 hidden">
                                                    <select required="required" class="form-control">
                                                        <option>3</option>
                                                        <option>Lorem</option>
                                                        <option>Lorem</option>
                                                        <option>Lorem</option>
                                                        <option>Lorem</option>
                                                        <option>Lorem</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Availability of In-House Trainers in Food Safety:</label>
                                            <div class="row">
                                                <div class="col-xs-6">
                                                    <select required="required" class="form-control">
                                                        <option>Yes</option>
                                                        <option>No</option>
                                                    </select>
                                                </div>
                                                <div class="col-xs-6 hidden">
                                                    <select required="required" class="form-control">
                                                        <option>3</option>
                                                        <option>Lorem</option>
                                                        <option>Lorem</option>
                                                        <option>Lorem</option>
                                                        <option>Lorem</option>
                                                        <option>Lorem</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>No of In-House Trainers:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="20" class="form-control"> </div>
                                        <div class="form-group">
                                            <label><strong>No of Years in business of training:</strong></label>
                                            <input type="text" required placeholder="4" class="form-control"> </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>No of Years in business of training:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="Skilled India" class="form-control"> </div>
                                        <div class="form-group">
                                            <div>
                                                <ul class="lab-no">
                                                    <li class="style-li"><strong>How many Training (4Hrs) sessions wish to conduct in a month?:</strong></li>
                                                    <li class="style-li error-red" style="display:none;">*Error</li>
                                                </ul>
                                            </div>
                                            <input type="text" required placeholder="Skilled India" class="form-control"> </div>
                                        <div class="form-group">
                                            <label class="radio-inline">
                                                <input type="radio" name="optradio"> Activate </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optradio"> Deactivate </label>
                                        </div>
                                        <br> </div>
                                    <div class="col-xs-12">
                                        <div class="col-xs-4"></div>
                                        <div class="col-xs-4">
                                            <div class="form-group">
                                                <input type="button" value="Save" class="form-control login-btn"> </div>
                                        </div>
                                        <div class="col-xs-4"></div>
                                    </div>
                                </form>
                            </div>
                            <div class="col-md-2 hidden-xs"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>