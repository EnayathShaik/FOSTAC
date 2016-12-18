
<section id="main-slider" class="no-margin">
	<div class="carousel-inner innerpage">
		<div class="container">
			<div class="row slide-margin">
				<div class="col-sm-12">
					<h1 class="animation animated-item-1" style="padding-bottom: 10px;">REGISTER
						HERE</h1>
				</div>
				<div class="circle-wrap center-block">
					<ul>
						<li><a href="trainee.fssai"><img
								src="website/images/trainee.png"></a></li>
						<li><a href="trainer.fssai"><img
								src="website/images/trainer.png"></a></li>
						<li><a href="trainingPartner.fssai"><img
								src="website/images/training-partner.png"></a></li>
						<li><a href="assessor.fssai"><img
								src="website/images/assessor.png"></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--/.carousel-inner  -->
	<!--/.carousel  -->
</section>
<!--/#main-slider -->
<section id="feature">
	<div class="container">
		<div class="row">
			<div class="features">
				<div class="col-md-12 col-xs-12 wow fadeInDown"
					data-wow-duration="1000ms" data-wow-delay="600ms">
					<div class="feature-wrap feature-wrapbasic">
						<img class="img-responsive center-block"
							src="website/images/fssai-certification-logo.jpg" width="132"
							height="87">
						<h3>Basic Food Safety Certification</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/.container  -->
</section>

<!--/#feature -->

<section id="ab">
	<div class="container wow fadeInDown" data-wow-duration="1000ms"
		data-wow-delay="600ms">
		<div class="row">
			<div class="col-md-6 col-sm-6">
				<h2 style="float: left; clear: both;">Basic Course Level</h2>
				<p class="date">
					<strong>Date:</strong> <span id="trainingDate"></span>
				</p>
			</div>
		</div>



		<div class="row">
			<div class="col-md-3 col-sm-2">
				<p class="course-name ">Course Name:</p>
			</div>

			<div class="col-md-3 col-sm-2">
				<form>
					<select id="coursenameList">
					</select>
				</form>

			</div>
		</div>


		<div class="row">
			<div class="col-md-3 col-sm-2">
				<p class="course-name ">Training Partner:</p>
			</div>

			<div class="col-md-3 col-sm-2">
				<form>
					<select id="trainingPartnerList">
					</select>
				</form>
			</div>
		</div>


		<div class="row">
			<div class="col-md-3 col-sm-2">
				<p class="course-name ">Training Centre: State</p>
			</div>
			<div class="col-md-3 col-sm-2">
				<form>
					<select id="states">
					</select>
				</form>
			</div>
		</div>



		<div class="row">
			<div class="col-md-3 col-sm-2">
				<p class="course-name ">Training Centre: City</p>
			</div>
			<div class="col-md-3 col-sm-2">
				<form>
					<select id="citys">
					</select>

					<button style="margin-left: 110px;" class="btn" type="button" onclick="showCalenderDetails();">
						<strong>Show Details</strong>
					</button>
				</form>
			</div>
		</div>


		<div class="row" style="height: 20px;">
			<div class="col-md-2 col-sm-2"></div>
		</div>



		<div class="row">
			<div class="col-md-6 col-sm-6">
				<h2 style="float: left; padding-bottom: 20px;">Search Results</h2>
			</div>
		</div>


		<section id="course">
			<div class="container container-fluid wow fadeInDown"
				data-wow-duration="1000ms" data-wow-delay="600ms">
				<div class="row">
					<div class="col-md-12 col-sm-12">
						<table class="table-border table-responsive container-fluid table">
							<thead>
								<th class="td-heading text-center"><strong>Course
										Name</strong></th>
								<th class="td-heading text-center"><strong>Training
										Partner</strong></th>
								<th class="td-heading text-center"><strong>Training
										Centre</strong></th>
								<th class="td-heading text-center"><strong>Availability
										Seat</strong></th>
							</thead>
							<tbody id="calendrDtls"></tbody>

						</table>
					</div>
				</div>
			</div>
		</section>
		 <script src="website/js/jquery.js"></script> 
		<script src="website/js/bootstrap.min.js"></script> 
		<script src="website/js/jquery.isotope.min.js"></script> 
        
        <script type="text/javascript">
        var cousernamelist=${courseNameList};
        var mangePartnerList=${mangePartnerList};
        var citys=${citys};
        var states=${states};
        var trainingDate=${trainingDate};
        var courseTypeId=${courseTypeId};
        $("#trainingDate").text(trainingDate);
        
        for(var index=0;index<cousernamelist.length;index++){
        	 $('#coursenameList').append('<option value="'+cousernamelist[index].coursenameid+'">'+cousernamelist[index].coursename+'</option>');
        }
        for(var index=0;index<mangePartnerList.length;index++){
       	 $('#trainingPartnerList').append('<option value="'+mangePartnerList[index].id+'">'+mangePartnerList[index].value+'</option>');
       }
        for(var index=0;index<states.length;index++){
        	if(states[index].status=="A")
          	 $('#states').append('<option value="'+states[index].stateId+'">'+states[index].stateName+'</option>');
          }
        for(var index=0;index<citys.length;index++){
          	 $('#citys').append('<option value="'+citys[index].cityId+'">'+citys[index].cityName+'</option>');
          }
        function showCalenderDetails(){
        	alert("Show Calendar Details");
        	 var data=JSON.stringify({
        		 courseNameId:$("#coursenameList").val(),
        		 trainingCenterId:$("#trainingPartnerList").val(),
        		 stateId:$("#states").val(),
        		 cityId:$("#citys").val(),
     			courseTypeId:courseTypeId
     	});
     		$.ajax({
     		      type: 'post',
     		      url: 'showTrainingCalendarDetails.fssai',
     		      contentType : "application/json",
     		      data: data,
     		      success: function (response) {
     		    	 response=JSON.parse(response);
     		    	$('#calendrDtls').empty();
     		    	 for(var index=0;index<response.length;index++){
     		    		$('#calendrDtls').append('<tr>');
     		    		$('#calendrDtls').append('<td class="td-border text-center"><p>'+response[index][0]+'</p></td>');
     		    		$('#calendrDtls').append('<td class="td-border text-center"><p>'+response[index][1]+'</p></td>');
     		    		var addLst=response[index][2].split(",");
     		    		$('#calendrDtls').append('<td class="td-border text-center"><p>'+addLst[0]+'<br>'+addLst[1]+'.<br> '+addLst[2]+', <br> '+addLst[3]+'</p></td>');
     		    		$('#calendrDtls').append('<td class="td-border" align="center"><p>'+response[index][3]+'</p></td>');
     		    		$('#calendrDtls').append('</tr>');
     		          }
     		    	
     		   
     		      }
     		      });
        }
        
        </script>
</section>