
    <section id="main-slider" class="no-margin">
        <div class="carousel-inner innerpage">
            <div class="container">
                <div class="row slide-margin">
                    <div class="col-sm-12">
                        <h1 class="animation animated-item-1" style="padding-bottom:10px;">REGISTER HERE</h1> </div>
                    <div class="circle-wrap center-block">
                        <ul>
                            <li>
                                <a href="trainee.fssai"><img src="website/images/trainee.png"></a>
                            </li>
                            <li>
                                <a href="trainer.fssai"><img src="website/images/trainer.png"></a>
                            </li>
                           <!--  <li>
                                <a href="trainingPartner.fssai"><img src="website/images/training-partner.png"></a>
                            </li> -->
                            <li>
                                <a href="assessor.fssai"><img src="website/images/assessor.png"></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--/.item-->
            <!--/.item-->
            <!--/.item-->
        </div>
        <!--/.carousel-inner-->
        <!--/.carousel-->
    </section>
    <!--/#main-slider-->
    <section id="feature">
        <div class="container">
            <div class="row">
                <div class="features">
                    <!--/.col-md-4-->
                    <!--/.col-md-4-->
                    <!--/.col-md-4-->
                    <div class="col-md-12 col-sm-12 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="feature-wrap"> <img class="img-responsive center-block" src="website/images/fssai-certification-logo.jpg" width="132" height="87">
                            <h3>Special Food Safety <br>
              Certification</h3> </div>
                    </div>
                    <!--/.col-md-4-->
                </div>
                <!--/.services-->
            </div>
            <!--/.row-->
        </div>
        <!--/.container-->
    </section>
    
    <section>
        <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
            <div class="row">
                <div class="col-md-2 col-xs-12"></div>
                <div class="col-md-8 col-xs-12">
                    <!-- collapsible accordion -->
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" href="#course">Course Name</a></li>
                                <li><a data-toggle="tab" href="#training">Training Partner</a></li>
                                <li><a data-toggle="tab" href="#duration">Duration</a></li>
                                <li><a data-toggle="tab" href="#who">Target Participant</a></li>
                                <li><a data-toggle="tab" href="#curriculum">Study Material</a></li>
                            </ul>
                         <div class="tab-content">
                        <div id="course" class="tab-pane fade in active">
                        <ul id="courseul"></ul>
                        </div>
                        <div id="training" class="tab-pane fade">
                        <ul id="trainingul"></ul>
                        </div>
                        <div id="duration" class="tab-pane fade">
                            <ul id="durationul">
                            </ul>
                        </div>
                        <div id="who" class="tab-pane fade">
                            <ul>
                                <li class="fsize">Specialized course for food handlers in dairy industry</li>
                                <li class="fsize">Specialized course for food handlers in Meat, Fish and Poultry Processing</li>
                            </ul>
                        </div>
                        <div id="curriculum" class="tab-pane fade">
                            <h4>PPT</h4>   
                            <ul id="ppts">                         
                              </ul>
                              <h4>Videos</h4>
                              <ul id="vedios">
                            </ul>
                        </div>
                    </div>
                    <!-- tabs navigation -->
                </div>
                <div class="col-md-2 col-xs-12"></div>
            </div>
        </div>
          <script src="website/js/jquery.js"></script> 
		<script src="website/js/bootstrap.min.js"></script> 
		<script src="website/js/jquery.isotope.min.js"></script> 
        
        <script type="text/javascript">
        var cousernamelist=${courseNameList};
        for(var index=0;index<cousernamelist.length;index++){
        	 $('#courseul').append(' <li class="fsize">'+cousernamelist[index].coursename+'</li>');
        	 $('#durationul').append('<li class="fsize">'+cousernamelist[index].courseduration+'</li>');
        }
        var trainingPartnerNameList=${trainingPartnerNameList};
        for(var index=0;index<trainingPartnerNameList.length;index++){
        	 $('#trainingul').append(' <li class="fsize">'+trainingPartnerNameList[index]+'</li>');
        }
        var manageCourseContents=${manageCourseContents};
        for(var index=0;index<manageCourseContents.length;index++){
        	if(manageCourseContents[index].contentTypeInput==="PPTs"){
        		$('#ppts').append('<li class="fsize"><a href="'+manageCourseContents[index].contentLinkInput+'" target="_blank">'+manageCourseContents[index].contentNameInput+'</a></li>');
        	}else if(manageCourseContents[index].contentTypeInput==="Videos"){
        		$('#vedios').append('<li class="fsize"><a href="'+manageCourseContents[index].contentLinkInput+'" target="_blank">'+manageCourseContents[index].contentNameInput+'</a></li>');
        	}
       }
        </script>
    </section>   
    <!--/#feature--> 