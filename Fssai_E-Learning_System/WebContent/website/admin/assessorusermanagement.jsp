<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
        <%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

            <cf:form action="assessorUserManagementSearch.fssai" name="myForm" method="POST" commandName="assessorUserManagementForm">
                <!-- horizontal navigation -->
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
                                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Admin</span> </a>
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
                                                            <h3 class="text-capitalize heading-3-padding">Assessor User Management</h3>
                                                            <form>
                                                                <!-- personal information -->
                                                                <div class="personel-info">
                                                                    <fieldset>
                                                                        <!-- left side -->
                                                                        <div class="col-md-6 col-xs-12">
                                                                            <div class="form-group">
                                                                                <div>
                                                                                    <ul class="lab-no">
                                                                                        <li class="style-li"><strong>First Name:</strong></li>
                                                                                        <li class="style-li error-red"> </li>
                                                                                    </ul>
                                                                                </div>
                                                                                <cf:input type="text" class="form-control" path="firstName" placeholder="First Name" /> </div>
                                                                            <div class="form-group">
                                                                                <div>
                                                                                    <ul class="lab-no">
                                                                                        <li class="style-li"><strong>Middle Name:</strong></li>
                                                                                        <li class="style-li error-red"> </li>
                                                                                    </ul>
                                                                                </div>
                                                                                <cf:input type="text" class="form-control" path="middleName" placeholder="Middle Name" /> </div>
                                                                            <div class="form-group">
                                                                                <div>
                                                                                    <ul class="lab-no">
                                                                                        <li class="style-li"><strong>Last Name:</strong></li>
                                                                                        <li class="style-li error-red"> </li>
                                                                                    </ul>
                                                                                </div>
                                                                                <cf:input type="text" class="form-control" path="lastName" placeholder="Last Name" /> </div>
                                                                        </div>
                                                                        <!-- right side -->
                                                                        <div class="col-md-6 col-xs-12">
                                                                            <div class="form-group">
                                                                                <div>
                                                                                    <ul class="lab-no">
                                                                                        <li class="style-li"><strong>User ID:</strong></li>
                                                                                        <li class="style-li error-red"> </li>
                                                                                    </ul>
                                                                                </div>
                                                                                <cf:input type="text" class="form-control" path="userId" placeholder="User Id" /> </div>
                                                                            <div class="form-group">
                                                                                <div>
                                                                                    <ul class="lab-no">
                                                                                        <li class="style-li"><strong>Aadhar Number:</strong></li>
                                                                                        <li class="style-li error-red"> </li>
                                                                                    </ul>
                                                                                </div>
                                                                                <cf:input type="text" class="form-control" path="aadharNumber" placeholder="Aadhar Number" /> </div>
                                                                            <div class="form-group">
                                                                                <div>
                                                                                    <ul class="lab-no">
                                                                                        <li class="style-li"><strong>Status:</strong></li>
                                                                                        <li class="style-li error-red"></li>
                                                                                    </ul>
                                                                                </div>
                                                                                <cf:select path="status" class="form-control">
                                                                                    <cf:option value="0" label="Selet Status" />
                                                                                    <cf:option value="A" label="Active" />
                                                                                    <cf:option value="I" label="In-Active" />
                                                                                </cf:select>
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
                                                                <div class="col-md-4 hidden-xs"></div>
                                                                <div class="col-md-4 col-xs-12">
                                                                    <a href="#">
                                                                    <input type="hidden" path="profileID" name="profileID" id="profileID" value="1"/>
                                                            		<input type="hidden" path="logindetails" name="logindetails" id="logindetails" value=""/>
                                                                        <input type="submit" class="form-control login-btn" value="Search"> </a>
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
                                                        <div class="col-xs-12 table-overflow-responsive">
                                                            <table class="table table-bordered table-hover table-responsive">
                                                                <thead>
                                                                    <th>User ID</th>
                                                                    <th>First Name</th>
                                                                    <th>Middle Name</th>
                                                                    <th>Last Name</th>
                                                                    <th>Aadhar Number</th>
                                                                    <th>Current Status</th>
                                                                    <th>Update Status</th>
                                                                </thead>
                                                                <tbody>
                                                                    <ct:choose>
                                                                        <ct:when test="${not empty searchassessorUsermanagement }">
                                                                            <ct:forEach var="listValue" items="${searchassessorUsermanagement}" varStatus="loop">
                                                                                <tr>
                                                                                    <td>
                                                                                        <label><a href="updateAssessor.fssai?userId=${listValue[6]}" value="${listValue[0]}">${listValue[1]}</a></label>
                                                                                    </td>
                                                                                    <td>
                                                                                        <label>${listValue[2] }</label>
                                                                                    </td>
                                                                                    <td>
                                                                                        <label>${listValue[3]}</label>
                                                                                    </td>
                                                                                    <td>
                                                                                        <label>${listValue[4]}</label>
                                                                                    </td>
                                                                                    <td>
                                                                                        <label>${listValue[5]}</label>
                                                                                    </td>
                                                                                         <td>
                                                                                    <label>${listValue[8]}</label>
                                                                                </td>
                                                                                <td>
                                                                                    <label><input type="submit"  onclick=" return activateDeActivateUser('${listValue[6]}','${listValue[7]}','1');" value="${listValue[7]}"/></label>
                                                                                </td>
                                                                                </tr>
                                                                            </ct:forEach>
                                                                        </ct:when>
                                                                        <ct:otherwise>
                                                                            <td colspan="5">
                                                                                <label>No records available</label>
                                                                            </td>

                                                                        </ct:otherwise>
                                                                    </ct:choose>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                        <div class="col-md-2 hidden-xs"></div>
                                                    </div>
                                                </section>
                                            </div>
                                            <!-- col-xs-12 ends -->
                                        </div>
                                        <!-- row ends -->
                                    </div>
                                </div>
                        </div>
                    </div>
                </section>
                <!-- scripts -->
            </cf:form>
                        <script>
                function activateDeActivateUser(loginDetails,status,profileID){
                	if(confirm("Are you Sure ? You want to "+status )){
                		$("#logindetails").val(loginDetails);	
                		$("#status").val((status=="INACTIVE"?"I":"A"));	
                		$("#assessorUserManagementForm").attr("action" , "activateDeActivateAssessor.fssai");
                    } else{
                        return false;
                    }
                }
            </script>
