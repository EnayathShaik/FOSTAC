<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
            <script>
                function AvoidSpace(event) {
                    var k = event ? event.which : window.event.keyCode;
                    if (k == 32) return false;
                }

                function checkname() {
                    var name = document.getElementById("userId").value;

                    if (name) {
                        $.ajax({
                            type: 'post',
                            url: 'checkdata.jspp?' + name,
                            data: {
                                user_name: name,
                            },

                            success: function(response) {
                                $('#name_status').html(response);

                                if (response.trim() == 'Already') {
                                    document.getElementById('userId').value = "";
                                    document.getElementById("register").style.display = 'none';
                                    return false;

                                } else {
                                    var aa = $('#name_status').html(response);
                                    document.getElementById("register").style.display = 'block';
                                    return true;
                                }
                            }
                        });
                    } else {
                        $('#name_status').html("");
                        document.getElementById("register").style.display = 'none';
                        return false;
                    }
                }

            </script>
            <cf:form action="adminUserManagementSave.fssai" name="myForm" method="POST" commandName="adminUserManagementForm">
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
                                            <div class="col-lg-12">
                                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${userName }</span> </a>
                                            </div>
                                        </div>
                                        <!-- add the content here for main body -->
                                        <!-- timeline  -->
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <section class="section-form-margin-top">
                                                    <!-- fostac logo -->
                                                    <!-- login form -->
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <h3 class="text-capitalize heading-3-padding">Admin Center User Management</h3>

                                                            <!-- personal information -->
                                                            <div class="personel-info">
                                                                <fieldset>
                                                                    <!-- left side -->
                                                                    <div class="col-md-6 col-xs-12">
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>First Name:</strong></li>
                                                                                    <li class="style-li error-red">
                                                                                        <cf:errors path="firstName" cssClass="error" />${created }</li>
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input path="firstName" placeholder="First Name" class="form-control" required="required" />
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Middle Name:</strong></li>
                                                                                    <li class="style-li error-red">
                                                                                        <cf:errors path="middleName" cssClass="error" />
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input path="middleName" placeholder="Middle Name" class="form-control" required="required" /> </div>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Last Name:</strong></li>
                                                                                    <li class="style-li error-red">
                                                                                        <cf:errors path="lastName" cssClass="error" />
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input path="lastName" placeholder="Last Name" class="form-control" required="required" />
                                                                        </div>
                                                                    </div>
                                                                    <!-- right side -->
                                                                    <div class="col-md-6 col-xs-12">
                                                                        <div class="form-group" style="display:none">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>User ID:</strong></li>
                                                                                    <li class="style-li error-red">
                                                                                        <span id="name_status"> </span>
                                                                                        <cf:errors path="userId" cssClass="error" />
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input path="userId" value="${ userId }"  placeholder="UserId" class="form-control"  />
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <div>
                                                                                <ul class="lab-no">
                                                                                    <li class="style-li"><strong>Aadhar Number:</strong></li>
                                                                                    <li class="style-li error-red">
                                                                                        <cf:errors path="aadharNumber" cssClass="error" />
                                                                                    </li>
                                                                                </ul>
                                                                            </div>
                                                                            <cf:input path="aadharNumber" maxlength="12" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Aadhar Number" class="form-control" required="required" /> </div>



                                                                        <div class="form-group">
                                                                            <%--  <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Status:</strong></li>
                                                            <li class="style-li error-red"></li>
                                                        </ul>
                                                    </div>
<cf:select path="status" class="form-control">
<cf:option value="A" label="Active" />
<cf:option value="i" label="In-Active" />
</cf:select> --%>
                                                                                <div class="col-md-6 col-xs-12">

                                                                                    <input type="submit" class="form-control login-btn" id="register" value="Create" style="margin-top:26px;">
                                                                                </div>
                                                                        </div>
                                                                    </div>
                                                                    <!-- personal information ends -->
                                                                </fieldset>
                                                            </div>
                                                            <!-- personal information ends -->
                                                            <!-- Training center Details  -->
                                                            <div class="row" style="height: 20px;"></div>
                                                            <!-- captcha -->
                                                            <!-- buttons -->
                                                            <div class="row">
                                                                <!-- left side -->
                                                                <div class="col-md-6 col-xs-12">

                                                                </div>

                                                                <!--right side -->
                                                                <div class="col-md-6 col-xs-12">

                                                                    <div class="row">
                                                                        <div class="col-md-6 col-xs-12">

                                                                            <!-- <input type="submit" class="form-control login-btn" value="Create">  -->
                                                                        </div>

                                                                        <div class="col-md-6 col-xs-12">
                                                                            <!-- <input type="button" class="form-control login-btn" value="Search">  -->
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                            </div>
                                                            <div class="col-md-4 hidden-xs"></div>
                                                            <div class="col-md-4 col-xs-12">

                                                            </div>
                                                            <div class="col-md-4 hidden-xs"></div>
                                                            <!-- training center details ends -->

                                                        </div>
                                                        <div class="col-md-2 hidden-xs"></div>
                                                    </div>
                                                </section>
                                                <section class="section-form-margin-top">

                                                    <div class="row" style="height:20px;"></div>
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <table class="container-fluid table table-bordered table-responsive">
                                                                <thead>
                                                                    <tr class="background-open-vacancies">
                                                                        <th>User ID</th>
                                                                        <th>First Name</th>
                                                                        <th>Middle Name</th>
                                                                        <th>Last Name</th>
                                                                        <th>Aadhar Number</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <ct:forEach var="listValue" items="${searchAdminUserManagement}" varStatus="loop">
                                                                        <tr>
                                                                            <td>
                                                                                <label><a href="" value="${listValue.adminUserManagementId }">${listValue.loginDetails.loginId }</a></label>
                                                                            </td>
                                                                            <td>
                                                                                <label>${listValue.firstName }</label>
                                                                            </td>
                                                                            <td>
                                                                                <label>${listValue.middleName }</label>
                                                                            </td>
                                                                            <td>
                                                                                <label>${listValue.lastName }</label>
                                                                            </td>
                                                                            <td>
                                                                                <label>${listValue.aadharNumber }</label>
                                                                            </td>
                                                                    </ct:forEach>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <div class="col-md-2 hidden-xs"></div>
                                                    </div>
                                                </section>
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
