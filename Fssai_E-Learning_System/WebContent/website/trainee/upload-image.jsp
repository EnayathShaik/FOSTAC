<!-- horizontal navigation -->
<section>
	<%@include file="../roles/top-menu.jsp"%>
</section>

<script src="website/js/jquery.js"></script>
<script>
	
</script>
<!-- main body -->
<section class="main-section-margin-top">
	<div class="container-fluid">
		<div id="wrapper">
			<!-- Sidebar menu -->
			<%@include file="../roles/slider.jsp"%>
			<!-- Sidebar menu -->
			<!-- /#sidebar-wrapper -->
			<!-- Page Content -->
			<div id="page-content-wrapper">
				<div class="container-fluid">
					<!-- vertical button -->
					<div class="row">
						<div class="col-lg-12">
							<a href="#menu-toggle" class="vertical-menu-position-btn"
								id="menu-toggle"> <i class="fa fa-bars"></i> <span
								class="orange-font">Welcome</span>
							</a>
						</div>
					</div>

					<!-- add the content here for main body -->
					<!-- feedback form  -->

					<div class="container-fluid">
						<div class="row">
							<div class="table-responsive">
								<div class="col-xs-12">
									<fieldset>
										<legend>
											<h3>Upload Image</h3>
										</legend>
										<form method="POST" action="savefile.fssai"
											enctype="multipart/form-data">
											<span id="preview"></span> 
											<input type="file" id="file" name="file" />
											<p><input type="submit" value="Upload"></p>  
										</form>

									</fieldset>
									<br>

								</div>
							</div>
						</div>
						<!-- row ends -->
					</div>
					<!-- fluid ends -->
				</div>
			</div>
		</div>
	</div>
</section>
<script>
        $(document).ready(function () {

        	$("#file").change(function() {
        		$("span").html("");
        		var file = this.files[0];
        		displayPreview(file);
        	});

        });
    </script>
<!-- scripts -->
