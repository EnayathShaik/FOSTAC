<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content=" ">
    <title>Fostac</title>
    <!-- stylesheet -->
    <link href="css/bootstrap.css" rel="stylesheet" />
    <link href="css/custom.css" rel="stylesheet" />
    <link href="css/font-awesome.css" rel="stylesheet" />
    <link href="css/aos.css" rel="stylesheet" />
    <link href="css/owl.carousel.css" rel="stylesheet" />
    <link href="css/owl.transitions.css" rel="stylesheet" />
    <link href="css/swipebox.css" rel="stylesheet" />
    <style>
        #news .item img {
            display: block;
            width: 100%;
            height: auto;
        }
    </style>
</head>

<body>
    <!-- logos -->
    <section>
        <div class="container-fluid">
            <nav class="navbar navbar-default navbar-fixed-top top-logo-background">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xs-6 fostac-logo-left">
                            <a href="#"><img src="img/fostac-logo.png" class="img-responsive fostac-logo-top-padding" alt="logo" /></a>
                        </div>
                        <div class="col-xs-6 fssai-logo-right">
                            <a href="#"><img src="img/fssai-logo.png" class="img-responsive pull-right" alt="logo" /></a>
                        </div>
                    </div>
                    <!--<div>
                        <ul class="nav navbar-nav">
                            <li><a href="#"><img src="img/fostac-logo.png" class="img-responsive" alt="logo" /></a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><img src="img/fssai-logo.png" class="img-responsive" alt="logo" /></a></li>
                        </ul>
                    </div>-->
                    <!--/.nav-collapse -->
                </div>
            </nav>
        </div>
    </section>
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
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Trainee Mr. Lorem </span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">

                                <div class="col-xs-12">
                                    <h1>Update Assessor Details</h1>
                                    <div class="row">
                                        <div class="col-xs-12">

                                            <!-- left side -->
                                            <div class="col-xs-6">
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Type:</strong></li>
                                                            <li class="style-li error-red">*Error</li>
                                                        </ul>
                                                    </div>
                                                   <select class="form-control">
                                                       <option>Basic</option>
                                                       <option>Advanced</option>
                                                       <option>Special</option>
                                                    </select>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Training Date:</strong></li>
                                                            <li class="style-li error-red">*Error</li>
                                                        </ul>
                                                    </div>
                                                   <input type="date" class="form-control" placeholder="Date">
                                                </div>
                                                
                                                 <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Training Center:</strong></li>
                                                            <li class="style-li error-red">*Error</li>
                                                        </ul>
                                                    </div>
                                                     <select class="form-control">
                                                        <option></option>
                                                         <option></option>
                                                         <option></option>
                                                         <option></option>
                                                     </select>
                                                </div>
                                            </div> <!-- left side ends -->

                                            <!-- right side -->
                                            <div class="col-xs-6">
                                                
                                                 <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Course Name:</strong></li>
                                                            <li class="style-li error-red">*Error</li>
                                                        </ul>
                                                    </div>
                                                   <select class="form-control">
                                                        <option>GHP</option>  
                                                       <option>Basic</option>
                                                   </select>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Training Partner:</strong></li>
                                                            <li class="style-li error-red">*Error</li>
                                                        </ul>
                                                    </div>
                                                   <select class="form-control">
                                                        <option> </option> 
                                                       <option> </option>
                                                   </select>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Assessment Agency:</strong></li>
                                                            <li class="style-li error-red">*Error</li>
                                                        </ul>
                                                    </div>
                                                   <select class="form-control">
                                                        <option> </option> 
                                                       <option> </option>
                                                   </select>
                                                </div>
                                         
                                                
                                            </div> <!-- rigth side ends -->
                                            
                                            <!-- button -->
                                            <div class="row">
                                                <div class="col-md-6 col-xs-12"></div>
                                                
                                                <div class="col-md-6 col-xs-12">
                                                    <button type="submit" class="btn btn-default pull-right show-details-vacancy collapsed" data-toggle="collapse" data-target="#show-result" aria-expanded="false" style="margin-right: 15px  ">Search</button>
                                                </div>
                                            </div>
                                           
                                        </div>

                                       
                                    </div>
                                </div>

                                <!-- search Results -->
                                <div class="col-xs-12 collapse" id="show-result" aria-expanded="false" style="height: 0px;">
                                    
                                    <!-- table -->
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <fieldset>
                                                <legend>Search Result</legend>
                                                
                                                <table class="table table-bordered table-responsive">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th>S.No.</th>
                                                        <th>Course Type</th>
                                                        <th>Course Name</th>
                                                        <th>Training Date</th>
                                                        <th>Training Center</th>
                                                        <th>Assessment Agency</th>
                                                        <th>Assessor Name</th>
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>Basic</td>
                                                        <td>GHP-GMP</td>
                                                        <td>12/08/2015</td>
                                                        <td>Delhi</td>
                                                        <td>
                                                            <select class="form-control">
                                                                <option>ABC</option>
                                                                <option>ABC</option>
                                                                <option>ABC</option>
                                                            </select>
                                                        </td>
                                                        <td>
                                                            <select>
                                                                <option>Mr. Anuj</option>
                                                                <option>Mr. Anuj</option>
                                                                <option>Mr. Anuj</option>
                                                            </select>
                                                        </td>
                                                        
                                                    </tr>
                                                    <tr>
                                                       <td>2</td>
                                                        <td>Advanced</td>
                                                        <td>GHP-GMP</td>
                                                        <td>12/08/2015</td>
                                                        <td>Delhi</td>
                                                        <td>ABC</td>
                                                        <td>Mr. Anuj</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3</td>
                                                        <td>Basic</td>
                                                        <td>GHP-GMP</td>
                                                        <td>12/08/2015</td>
                                                        <td>Delhi</td>
                                                        <td>ABC</td>
                                                        <td>Mr. Anuj</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            </fieldset>
                                            
                                        </div>
                                    </div>
                                </div> <!-- search div ends -->

                            </div><!-- row ends -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- scripts -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <!-- on scroll animation -->
    <script src="js/aos.js"></script>
    <script>
        AOS.init();
    </script>
    <!-- carousel -->
    <script src="js/owl.carousel.js"></script>
    <script>
        $(document).ready(function () {
            $("#news").owlCarousel({
                navigation: false, // Show next and prev buttons
                slideSpeed: 300
                , paginationSpeed: 400
                , singleItem: true
                , autoPlay: true
                    // "singleItem:true" is a shortcut for:
                    // items : 1,
                    // itemsDesktop : false,
                    // itemsDesktopSmall : false,
                    // itemsTablet: false,
                    // itemsMobile : false
            });
        });
    </script>
    <!-- gallery -->
    <script src="js/jquery.swipebox.js"></script>
    <script type="text/javascript">
        ;
        (function ($) {
            $('.swipebox').swipebox();
        })(jQuery);
    </script>
    <!-- Menu Toggle Script -->
    <script>
        $("#menu-toggle").click(function (e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>
</body>

</html>