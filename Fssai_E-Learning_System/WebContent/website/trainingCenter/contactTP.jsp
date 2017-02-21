<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

            <script>
                function OnStart() {
                    //alert('kk');
                    BlankFields();
                }
                window.onload = OnStart;

            </script>
            <script>
                function BlankFields() {
                    document.getElementById("emailAddress").value = '';
                    document.getElementById("messageDetails").value = '';
                }

            </script>
            <script type='text/javascript'>
                function validateFields() {
                    /* if(document.getElementById("emailAddress").value=="") {
                    document.getElementById("emailAddress").style.borderColor = "red";
                    document.getElementById("emailAddressError").style.display = 'block';
                    document.getElementById("emailAddress").focus();
                    return false;
                    }else{
                        document.getElementById('emailAddress').style.borderColor = "#ccc";
                        document.getElementById("emailAddressError").style.display = 'none';
                        } */
                    var x = document.getElementById('emailAddress').value;
                    var atpos = x.indexOf("@");
                    var dotpos = x.lastIndexOf(".");
                    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= x.length) {
                        //  alert("Not a valid e-mail address");
                        document.getElementById('emailAddress').style.borderColor = "red";
                        document.getElementById("emailAddressError").style.display = 'block';
                        document.getElementById("emailAddress").focus();
                        return false;
                    } else {
                        document.getElementById('emailAddress').style.borderColor = "#ccc";
                        document.getElementById("emailAddressError").style.display = 'none';
                    }
                    if (document.getElementById("messageDetails").value == "") {
                        document.getElementById("messageDetails").style.borderColor = "red";
                        document.getElementById("messageDetailsError").style.display = 'block';
                        document.getElementById("messageDetails").focus();
                        return false;
                    } else {
                        document.getElementById('messageDetails').style.borderColor = "#ccc";
                        document.getElementById("messageDetailsError").style.display = 'none';
                    }
                    return (true);
                }

            </script>
            <cf:form action="contactTPSave.fssai" name="myForm" method="POST" commandName="contactTrainee" onsubmit="return validateFields();">

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
                                                <li class="hori"><a href="index.html">Home</a></li>
                                                <li class="hori"><a href="update-personal-information.html">Update Personal Information</a></li>
                                                <li class="hori"><a href="view-feedback-details.html">View Feedback Details</a></li>
                                                <li class="hori active"><a href="contactTC.fssai">Contact Us</a></li>
                                            </ul>
                                            <ul class="nav navbar-nav navbar-right">
                                                <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="changePasswordTCentre.fssai">Change Password</a></li>
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
                            <div id="sidebar-wrapper">
                                <ul class="sidebar-nav">
                                    <!-- <li class="sidebar-brand">
                        </li> -->
                                    <li> <a href="trainingCalendar.fssai">Training Calendar</a> </li>
                                    <li> <a href="view-trainee-list.html">View Trainee List</a> </li>
                                    <li> <a href="mark-trainee-attendance.html">Mark Attendance</a> </li>
                                    <li> <a href="post-vacancy.fssai">Post Vacancy for Trainer</a> </li>
                                    <li> <a href="application-status.html">Application Status</a> </li>
                                    <li> <a href="manage-trainer.html">Manage Trainer</a> </li>
                                    <li> <a href="assessment-calendar.html">Assessment Calendar</a></li>
                                    <li> <a href="payment-confirmation.html">Payment Confirmation</a> </li>
                                </ul>
                            </div>
                            <!-- Sidebar menu -->
                            <!-- /#sidebar-wrapper -->
                            <!-- Page Content -->
                            <div id="page-content-wrapper">
                                <div class="container-fluid">

                                    <!-- vertical button -->
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Mr. Anuj</span> </a>
                                        </div>
                                    </div>

                                    <!-- add the content here for main body -->
                                    <!-- feedback form  -->

                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="col-xs-12 contact-margin-top">
                                                <fieldset>
                                                    <legend>
                                                        <h3>Let Us Help You!</h3>
                                                    </legend>
                                                    <br>

                                                    <div class="form-group">
                                                        <label>Your Email Address:</label>
                                                        <label class="error" style="color:red;"> ${created }</label>
                                                        <label class="error visibility" id="emailAddressError" style="color:red;">* enter your email address </label>
                                                        <cf:input path="emailAddress" type="email" class="form-control" placeholder="Enter Your Email" />
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Message Details</label>
                                                        <label class="error visibility" id="messageDetailsError" style="color:red;">* write your message</label>

                                                        <cf:textarea path="messageDetails" class="form-control" placeholder="Enter Your Message (250 Words)" /> </div>
                                                    <input style="margin-top:20px; width:100px;" type="submit" class="form-control login-btn btn" value="Submit" />

                                                </fieldset>
                                            </div>
                                            <div class="col-md-2 hidden-xs"> </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

            </cf:form>
            <!-- <script>
                var id = localStorage.getItem('activeID');
                document.getElementById(id).className = "active";

            </script> -->
