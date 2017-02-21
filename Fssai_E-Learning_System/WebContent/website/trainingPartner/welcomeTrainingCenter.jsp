<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
	<%@include file="../roles/top-menu.jsp"%>
</section>
<!-- main body -->
<section class="main-section-margin-top">
	<div class="container-fluid">
		<div id="wrapper">
			<!-- Sidebar -->
			<%@include file="../roles/slider.jsp"%>
			<!-- /#sidebar-wrapper -->
			<!-- Page Content -->
			<div id="page-content-wrapper">
				<div style="height: 70px;"></div>
				<h3>
					<strong> You have been registered successfully !!! </strong> <br>
					<br> Your UserId id : ${id } and password is ${pwd}
				</h3>
				<div style="height: 70px;"></div>
			</div>
		</div>
	</div>
</section>
