<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- <script type='text/javascript'>
function validateFields() {
	if(document.getElementById("emailAddress").value=="") {
	document.getElementById("emailAddress").style.borderColor = "red";
	document.getElementById("emailIdError").style.display = 'block';
	document.getElementById("emailAddress").focus();
	return false;
	}else{
	    document.getElementById('messageDetails').style.borderColor = "#ccc";
	    document.getElementById("emailIdError").style.display = 'none';
	    }
	if(document.getElementById("messageDetails").value=="") {
		document.getElementById("messageDetails").style.borderColor = "red";
		document.getElementById("messageError").style.display = 'block';
		document.getElementById("messageDetails").focus();
		return false;
		}else{
		    document.getElementById('messageDetails').style.borderColor = "#ccc";
		    document.getElementById("messageError").style.display = 'none';
		    }
	return( true );
}
</script> -->

<cf:form action="contactTrainingPartnerSave.fssai" name="myForm" method="POST" commandName="contactTrainingPartner" onsubmit="return validateFields();"> 
<section>
      <div class="container-fluid">
        <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
          <div class="container">
            <div class="row">
              <div class="col-xs-12">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                </div>
                <jsp:include page="../trainingPartner/trainingCenterNavBar.jsp" />
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
             <%@include file="../trainingPartner/leftmenuTrainingPartner.jspf" %>
           <!-- Sidebar menu -->
          <!-- /#sidebar-wrapper --> 
          <!-- Page Content -->
          
          <div id="page-content-wrapper">
            <div class="container-fluid"> 

              <!-- vertical button -->
              <div class="row">
            <div class="col-lg-12"> <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> 
            <span class="orange-font">Welcome Training Partner</span> </a> </div>
          </div>
<cf:hidden path="userId" value="${loginUser.loginDetails.loginId}"/>
              <!-- add the content here for main body -->
                        <div class="container-fluid">
                          <div class="row">
                                <div class="col-xs-12 contact-margin-top">
                                  <fieldset>
                                  <legend><h3>Let Us Help You!</h3></legend><br>
                                  <form>
                                  
<span class="error" style="color:red;">${created }</span><br><br>
                                      <div class="form-group">
                                        <label>Your Email Address:</label>
<label class="error visibility" id="emailAddressError" style="color:red;">* error</label>
 <cf:input path="emailAddress"   placeholder="Enter Your Email" class="form-control"   />
                                     
                                      </div>
                                      <div class="form-group">
                                        <label>Message Details</label>
<label class="error visibility" id="messageError" style="color:red;">* error</label>                                       
<cf:textarea path="messageDetails" maxlength="250"  placeholder="Enter Your Message (250 Words)" class="form-control"   />
                                      </div>
                                      <input style="margin-top:20px; width:100px;" type="submit" class="form-control login-btn btn" value="Submit">
                                    </form>
                                  </fieldset>
                                  </div>  
                          </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
</cf:form>
