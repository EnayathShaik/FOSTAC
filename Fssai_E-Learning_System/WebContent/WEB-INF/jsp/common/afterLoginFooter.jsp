  </div>
            </div>
        </div>
    </section>


<!--/#bottom-->
<footer class="footer-bottom-position">
  <!-- <div class="container">
    <div class="row">
      <div class="col-sm-12 text-center">Design and Developed by &nbsp;<a href="http://www.zentechinfo.com/" target="_blank" style="color:#1c1b1b; text-decoration:underline;">Zentech Info Solutions Pvt. Ltd.</a> &copy; FSSAI 2016- All Right Reserved.</div>    </div>
  </div> -->
</footer>



 <!-- scripts -->
<!--  <script src="website/js/jquery.js"></script>  -->
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
        	
        	
        	
        	$(function(){
        	    var dtToday = new Date();
        	    var month = dtToday.getMonth() + 1;
        	    var day = dtToday.getDate();
        	    var year = dtToday.getFullYear();
        	    if(month < 10)
        	        month = '0' + month.toString();
        	    if(day < 10)
        	        day = '0' + day.toString();
        	    var minDate = year + '-' + month + '-' + day;    
        	    $('#seltraineeDate').attr('min', minDate);
        	});

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
    
     

   


