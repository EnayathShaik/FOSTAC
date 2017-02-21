<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<%
		System.out.println("Profile ID : "
				+ session.getAttribute("profileId"));
		if (session.getAttribute("profileId").equals(3)) {
			System.out.println("Profile ID : "
					+ session.getAttribute("profileId"));
	%>
	<div class="container-fluid">
		<nav
			class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active hori"><a href="loginProcess.fssai">Home</a></li>
							<li class="hori"><a href="updateInformation.fssai?userId=0">Update
									Information</a></li>
							<li class="hori"><a href="contactTrainee.fssai">Contact
									Us</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown active"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><i
									class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
								<ul class="dropdown-menu">
								<li><a href="uploadImage.fssai">Upload Image</a></li>
									<li><a href="changePasswordTrainee.fssai">Change
											Password</a></li>
									<li><a href="fostac.fssai">Logout</a></li>
								</ul></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
		</nav>
	</div>
	<%
		} else if (session.getAttribute("profileId").equals(4)) {
	%>
	<div class="container-fluid">
		<nav
			class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active hori"><a href="loginProcess.fssai">Home</a></li>
							<!-- <li class="hori"><a href="search-and-apply.fssai">Search
									& Apply Vacancy</a></li> -->
							<li class="hori"><a href="update-profile.fssai?userId=0">Update
									Profile</a></li>
							<li class="hori"><a href="contactTrainee.fssai">Contact
									Us</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown active"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><i
									class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
								<ul class="dropdown-menu">
								<li><a href="uploadProfile.fssai">Upload Profile</a></li>
									<li><a href="changePasswordTrainee.fssai">Change
											Password</a></li>
									<li><a href="fostac.fssai">Logout</a></li>
								</ul></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
		</nav>
	</div>

	<%
		} else if (session.getAttribute("profileId").equals(5)) {
	%>
	<div class="container-fluid">
		<nav
			class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="hori"><a href="loginProcess.fssai">Home</a></li>
							<li class="hori"><a href="update-personal-information.fssai?userId=0">Update
									Personal Information</a></li>
							<li class="hori"><a href="viewFeedbackDetails.fssai">View
									Feedback Details</a></li>
							<li class="hori"><a href="contactTrainee.fssai">Contact
									Us</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown active"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><i
									class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="changePasswordTrainee.fssai">Change
											Password</a></li>
									<li><a href="fostac.fssai">Logout</a></li>
								</ul></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
		</nav>
	</div>

	<%
		} else if (session.getAttribute("profileId").equals(6)) {
	%>
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
                    <li class="active hori"><a href="loginProcess.fssai">Home</a></li>
                    <li class="hori"><a href="updateAssessor.fssai?userId=0">Update Personal Information</a></li>
                   <li class="hori"><a href="contactTrainee.fssai">Contact
									Us</a></li>
                  </ul>
                      <ul class="nav navbar-nav navbar-right">
							<li class="dropdown active"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><i
									class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="changePasswordTrainee.fssai">Change
											Password</a></li>
									<li><a href="fostac.fssai">Logout</a></li>
								</ul></li>
						</ul>
                    </div>
                <!--/.nav-collapse --> 
              </div>
                </div>
          </div>
            </nav>
      </div>

	<%
		} else if (session.getAttribute("profileId").equals(7)) {
	%>
	<div class="container-fluid">
		<nav
			class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li></li>
							<li class="active hori"><a href="loginProcess.fssai">Home</a></li>
							<li><a href="trainingCenterUserManagementForm.fssai">Training
									Center Management</a></li>
							<li class="hori"><a href="contactTrainee.fssai">Contact
									Us</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown active"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><i
									class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="changePasswordTrainee.fssai">Change
											Password</a></li>
									<li><a href="fostac.fssai">Logout</a></li>
								</ul></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
		</nav>
	</div>

	<%
		} else if (session.getAttribute("profileId").equals(8)) {
	%>
	<div class="container-fluid">
		<nav
			class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li></li>
							<li class="active hori"><a
								href="loginProcess.fssai">Home</a></li>
							<li><a href="assessorUserManagementForm.fssai">Assessor
									User Management</a></li>
							<li class="hori"><a href="contactTrainee.fssai">Contact
									Us</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown active"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><i
									class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="changePasswordTrainee.fssai">Change
											Password</a></li>
									<li><a href="fostac.fssai">Logout</a></li>
								</ul></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
		</nav>
	</div>

	<%
		} else if (session.getAttribute("profileId").equals(1)) {
	%>
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
                                    <li class="active hori"><a href="loginProcess.fssai">Home</a></li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Management<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="traineeUserManagementForm.fssai" class="clr">Trainee</a></li>
                                            <li><a href="trainerUserManagementForm.fssai" class="clr">Trainer</a></li>
                                            <li><a href="trainingCenterUserManagementForm.fssai" class="clr">Training Center</a></li>
                                            <li><a href="assessorUserManagementForm.fssai" class="clr">Assessor</a></li>
                                            <li><a href="adminUserManagementForm.fssai" class="clr">Admin</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Master Data<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="stateMaster.fssai" class="clr">State</a></li>
                                            <li><a href="districtMaster.fssai" class="clr">District</a></li>
                                            <li><a href="cityMaster.fssai" class="clr">City</a></li>                                            
                                            <li><a href="regionMappingMaster.fssai" class="clr">Region Mapping</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="manageTrainingPartnerForm.fssai">Manage Training Partner</a></li>
                                    <li><a href="manageAssessmentAgencyForm.fssai">Manage Assessment Agency</a></li>
                                </ul>
                               <ul class="nav navbar-nav navbar-right">
							<li class="dropdown active"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><i
									class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="changePasswordTrainee.fssai">Change
											Password</a></li>
									<li><a href="fostac.fssai">Logout</a></li>
								</ul></li>
						</ul>
                            </div>
                            <!--/.nav-collapse -->
                        </div>
                    </div>
                </div>
            </nav>
        </div>
	<%
		} else if (session.getAttribute("profileId").equals(2)) {
	%>
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
                                    <li class="active hori"><a href="loginProcess.fssai">Home</a></li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User Management<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="traineeUserManagementForm.fssai" class="clr">Trainee</a></li>
                                            <li><a href="trainerUserManagementForm.fssai" class="clr">Trainer</a></li>
                                            <li><a href="trainingCenterUserManagementForm.fssai" class="clr">Training Center</a></li>
                                            <li><a href="assessorUserManagementForm.fssai" class="clr">Assessor</a></li>
                                            <li><a href="adminUserManagementForm.fssai" class="clr">Admin</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Master Data<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="stateMaster.fssai" class="clr">State</a></li>
                                            <li><a href="districtMaster.fssai" class="clr">District</a></li>
                                            <li><a href="cityMaster.fssai" class="clr">City</a></li>                                            
                                            <li><a href="regionMappingMaster.fssai" class="clr">Region Mapping</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="manageTrainingPartnerForm.fssai">Manage Training Partner</a></li>
                                    <li><a href="manageAssessmentAgencyForm.fssai">Manage Assessment Agency</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
							<li class="dropdown active"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"><i
									class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="changePasswordTrainee.fssai">Change
											Password</a></li>
									<li><a href="fostac.fssai">Logout</a></li>
								</ul></li>
						</ul>
                            </div>
                            <!--/.nav-collapse -->
                        </div>
                    </div>
                </div>
            </nav>
        </div>
	<%
		}
	%></ body>
</html>