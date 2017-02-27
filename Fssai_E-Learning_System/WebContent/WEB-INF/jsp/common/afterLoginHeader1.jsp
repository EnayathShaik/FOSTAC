<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content=" ">
    <title> Fostac </title>

    <!-- stylesheet -->
    <link href="website/afterLogin/css/bootstrap.css" rel="stylesheet" />
    <link href="website/afterLogin/css/custom.css" rel="stylesheet" />
    <link href="website/afterLogin/css/font-awesome.css" rel="stylesheet" />
    <link href="website/afterLogin/css/aos.css" rel="stylesheet" />
    <link href="website/afterLogin/css/owl.carousel.css" rel="stylesheet" />
    <link href="website/afterLogin/css/owl.transitions.css" rel="stylesheet" />
    <link href="website/afterLogin/css/swipebox.css" rel="stylesheet" />
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
                            <a href="#"><img src="website/afterLogin/img/fostac-logo.png" class="img-responsive fostac-logo-top-padding" alt="logo" /></a>
                        </div>

                        <div class="col-xs-6 fssai-logo-right">
                            <a href="#"><img src="website/afterLogin/img/fssai-logo.png" class="img-responsive pull-right" alt="logo" /></a>
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
        <div class="container-fluid">
            <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">

                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div id="navbar" class="navbar-collapse collapse">
                                <ul class="nav navbar-nav">
                                    <li></li>
                                    <li class="active hori"><a href="index.html">Home</a></li>
                                    <li class="hori"><a href="view-enrolled-course.html">View Enrolled Course</a></li>
                                    <li class="hori"><a href="#">Update Information</a></li>
                                    <li class="hori"><a href="contact.html">Contact Us</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li class="dropdown active">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i>  <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Change Password</a></li>
                                            <li><a href="#">Logout</a></li>

                                        </ul>
                                    </li>
                                </ul>
                            </div><!--/.nav-collapse -->
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
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- scripts -->
    <script src="website/afterLogin/js/jquery-2.1.0.min.js"></script>
    <script src="website/afterLogin/js/bootstrap.js"></script>
    <!-- on scroll animation -->
    <script src="website/afterLogin/js/aos.js"></script>
    <script src="website/js/validation.js"></script>
    <script>
        AOS.init();
    </script>
    <!-- carousel -->
    <script src="js/owl.carousel.js"></script>
    <script>
        $(document).ready(function () {

            $("#news").owlCarousel({

                navigation: false, // Show next and prev buttons
                slideSpeed: 300,
                paginationSpeed: 400,
                singleItem: true,
                autoPlay: true

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
    <script src="website/afterLogin/js/jquery.swipebox.js"></script>
    <script type="text/javascript">
        ; (function ($) {

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