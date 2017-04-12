<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
 <div id="google_translate_element"></div><script type="text/javascript">
function googleTranslateElementInit() {
  new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
}
</script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
        

    <!-- logos -->
    <section>
    <div class="container-fluid">
    <div class="col-xs-6 fostac-logo-left">
		<label id="uniqueId" style="font-size: 20px; font-weight: bold;">${loginUserS.loginDetails.loginId}</label>
	</div>
            <nav class="navbar navbar-default navbar-fixed-top top-logo-background">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xs-6 fostac-logo-left">
                            <a href="#"><img src="website/afterLogin/img/fostac-logo.png" class="img-responsive fostac-logo-top-padding" alt="logo" /></a>
                        </div>
                        <div class="col-xs-6 fssai-logo-right">
							<label id="uniqueId" style="margin-top:20px; font-size: 20px; font-weight: bold;">${loginUserS.loginDetails.loginId}</label>
                            <a href="#"><img src="website/afterLogin/img/fssai-logo.png"  class="img-responsive pull-right" alt="logo" style="margin-right: 59px;" /></a>
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
