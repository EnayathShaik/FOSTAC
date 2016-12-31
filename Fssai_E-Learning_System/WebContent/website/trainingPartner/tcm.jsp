<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

function OnStart(){
	searchVacancy();
}
window.onload = OnStart;
</script>

<cf:form action="tcmSave.fssai" name="myForm" method="POST" commandName="tcmForm" onsubmit="" >
<section>
   <%@include file="../roles/top-menu.jsp"%>
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
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Training Center</span> </a> </div>
          </div>
          
          <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <section class="section-form-margin-top">
                  
                        <!-- fostac logo -->
                        <!-- login form -->
                        <div class="row">
                            <div class="col-xs-12">
                                <h3 class="text-capitalize heading-3-padding">Training Center User Management</h3>
                                <form>
                                    <!-- personal information -->
                                    <div class="personel-info">
                                     
                                            <!-- left side -->
                                            <div class="col-md-6 col-xs-12">
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>First Name:</strong></li>
                                                            <li class="style-li error-red">*Error</li>
                                                        </ul>
                                                    </div>
                                                    <input type="text" class="form-control" placeholder="User ID" required=""> </div>
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Middle Name:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                    <input type="date" class="form-control" placeholder="First Name" required=""> </div>
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Last Name:</strong></li>
                                                            <li class="style-li error-red"> </li>
                                                        </ul>
                                                    </div>
                                                    <input type="date" class="form-control" placeholder="First Name" required=""> </div>
                                            </div>
                                            <!-- right side -->
                                            <div class="col-md-6 col-xs-12">
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>User ID:</strong></li>
                                                            <li class="style-li error-red">*Error</li>
                                                        </ul>
                                                    </div>
                                                    <input type="text" class="form-control" placeholder="User ID" required=""> </div>
 <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Training Center name:</strong></li>
                                                            <li class="style-li error-red">*Error</li>
                                                        </ul>
                                                    </div>
                                                    <input type="text" class="form-control" placeholder="Training Center Name" required=""> </div>                                                
<div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>PAN Number:</strong></li>
                                                            <li class="style-li error-red">*Error</li>
                                                        </ul>
                                                    </div>
                                                    <input type="text" class="form-control" placeholder="PAN" required=""> </div>
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li">
                                                                <input name="" type="checkbox" value="Active"> Active&nbsp;
                                                                <input name="" type="checkbox" value="Deactive"> Deactive</li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- personal information ends -->
                                   
                                    </div>
                                    <!-- personal information ends -->
                                    <!-- Training center Details  -->
                                    <div class="row" style="height: 20px;"></div>
                                    <!-- captcha -->
                                    <!-- buttons -->
                                    <div class="col-md-4 hidden-xs"></div>
                                    <div class="col-md-4 col-xs-12">
                                        <a href="file:///C:/Users/pc/Desktop/Zentech/Fostac%20Prototype/Website_Last/fostac-training-partner(TP)/login.html">
                                            <input type="button" class="form-control login-btn" value="Search">
                                        </a>
                                    </div>
                                    <div class="col-md-4 hidden-xs"></div>
                                    <!-- training center details ends -->
                                </form>
                            </div>
                            <div class="col-md-2 hidden-xs"></div>
                        </div>
                    
                </section>
                <section class="section-form-margin-top">
                   
                        <!-- fostac logo -->
                        <!-- login form -->
                        <div class="row" style="height:20px;"></div>
                        <div class="row">
                            <div class="col-xs-12">
                                <table class="table-hover table table-bordered table-responsive">
                                    <thead>
                                        <tr><th>User ID</th>
                                        <th>First Name</th>
                                        <th>Middle Name</th>
                                        <th>Last Name</th>
                                        <th>Aadhar Number</th>
                                    </tr></thead>
                                    <tbody><tr>
                                        <td><a href="file:///C:/Users/pc/Desktop/Zentech/Fostac%20Prototype/Website_Last/fostac-training-partner(TP)/training-partner-registration.html">12345</a></td>
                                        <td>Sita</td>
                                        <td>Middle Name</td>
                                        <td>Sharma</td>
                                        <td>123456789111</td>
                                    </tr>
                                </tbody></table>
                            </div>
                            <div class="col-md-2 hidden-xs"></div>
                        </div>
                  
                </section>
        </div>
      </div>
    </div>
  </div>
</section>
</cf:form>