

 <!-- scripts -->
    <script src="website/afterLogin/js/jquery-2.1.0.min.js"></script>
    <script src="website/afterLogin/js/bootstrap.js"></script>
    <script src="website/afterLogin/js/jquery.isotope.min.js"></script> 

<script src="website/afterLogin/js/wow.min.js"></script>
    <!-- on scroll animation -->
    <script src="website/afterLogin/js/aos.js"></script>
    <script>
        AOS.init();
    </script>
    <!-- carousel -->
    <script src="website/afterLogin/js/owl.carousel.js"></script>
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
    
     

   