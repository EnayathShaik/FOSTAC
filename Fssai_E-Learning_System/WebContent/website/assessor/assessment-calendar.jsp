
        <!-- horizontal navigation -->
        <section>
             <%@include file="../roles/top-menu.jsp"%>
        </section>
<script>
function showDetail(){
	alert('Exec started');
	//alert('detail');
	//document.getElementById("show-result").style.display ='block';
	//document.getElementById("conclusionListOfAssessment").style.display ='none';
	var result="";
	//var id = document.getElementById("assessmentAgencyId").value;
	var assessorId =710;
	$.ajax({
	type: 'post',
	url: 'searchAssessorCalendar.jspp?'+id,
	async: false, 
	success: function (data){
		console.log("Data received..");
// 	$('#newTable1').show();
// 	//var mainData = JSON.stringify(data);
// 	var mainData1 = jQuery.parseJSON(data);
// 	//alert(mainData1);
// 	var j=1;
// 	$('#newTable1 tr').remove();
// 	$('#newTable1').append('<tr  class="background-open-vacancies"><th>S.No.</th><th>Assessment Agency Name</th><th>Assessor Name</th><th>Assessor Id</th><th>Active / In-Active</th><th>Detail</th></tr>')
// 	$.each(mainData1 , function(i , obj)
// 	{
// 		$('#newTable1').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[0]+'</td><td>'+obj[1]+'</td><td>'+obj[2]+'</td><td><input type="hidden" id="statusHidden'+obj[4]+'" value="'+obj[5]+'"/><a href="#" onclick="statusChange('+obj[4]+');">'+obj[3]+'</a></td><td><input type="hidden" id="assessorId'+obj[4]+'" value="'+ obj[4]+'" /><a href="#" onclick="showDetail();">'+obj[4]+'</></td></tr>');
// 		console.log(obj[0] +" -" +obj[1] +" -" +obj[2] +" -"+obj[3] +" -"+obj[4]);
		
// 	});
	}
	});
return result;
}
</script>
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
                                        <legend><h3>Assessment Calendar</h3></legend>
                                            <div class="row">
                                            <div class="col-xs-12">

                                                <!-- left side -->
                                                <div class="col-md-6 col-xs-12">
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Course Name:</strong></li>
                                                                <li class="style-li error-red">*Error</li>
                                                            </ul>
                                                        </div>
                                                        <select class="form-control">
                                                            <option>Basic</option>
                                                            <option>Advanced</option>
                                                            <option>Special</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Training Date</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                            </ul>
                                                        </div>
                                                        <input type="time" class="form-control">
                                                    </div>
                                                    <button type="submit" class="btn login-btn pull-right show-details-vacancy collapsed" 
                                                    data-toggle="collapse" data-target="#show-result" aria-expanded="false" onclick="showDetail();">Show Details</button>
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
                                                <table id="upcomingTrainings" class="table table-bordered table-responsive table-striped table-hover">
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





