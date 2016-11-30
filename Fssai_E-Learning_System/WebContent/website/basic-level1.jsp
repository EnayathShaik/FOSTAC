 <%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %> 
 <ul>
            <ct:forEach var="listValue" items="${courseNameOnlyList}">
               <li>${listValue}</li>
                </ct:forEach>
            </ul>
<!--/#main-slider-->
<!--/header-->

<section id="main-slider" class="no-margin">
    <div class="carousel-inner innerpage">
        <div class="container">
          <div class="row slide-margin">
            <div class="col-sm-12">
            <h1 class="animation animated-item-1" style="padding-bottom:10px;">REGISTER HERE</h1>
            </div>
              <div class="circle-wrap circle-wrap-inner center-block">              
              <ul>
                <li><a href="#"><img src="website/images/trainee.png"></a></li>
                <li><a href="#"><img src="website/images/trainer.png"></a></li>
                <li><a href="#"><img src="website/images/training-partner.png"></a></li>
                <li><a href="#"><img src="website/images/assessor.png"></a></li>
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



<section id="feature" >
  <div class="container">
    <div class="row">
      <div class="features">
        
      
        <div class="col-md-12 col-xs-12 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
          <div class="feature-wrap feature-wrapbasic"> <img class="img-responsive center-block" src="website/images/fssai-certification-logo.jpg" width="132" height="87">
            <h3>Basic Food Safety Certification</h3>
          </div>
        </div>
        <!--/.col-md-4-->
        
        
        <!--/.col-md-4-->
        
        
        <!--/.col-md-4--> 
        
      </div>
      <!--/.services--> 
    </div>
    <!--/.row--> 
  </div>
  <!--/.container--> 
</section>

<!--/#feature--><section id="course">
  <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
  <div class="row"><h2>Basic Food Safety Certification</h2></div>
    <div class="row">
<div class="col-md-12 col-sm-12">
<table width="100%" border="0" cellpadding="10" cellspacing="10" class="table-border">
  <tr>
    <td class="td-heading" width="16%" align="center"><strong>Course Name</strong></td>
    <td class="td-heading" width="16%" align="center"><strong>Training Partner</strong></td>
    <td class="td-heading" width="10%" align="center"><strong>Duration</strong></td>
    <td class="td-heading" width="22%" align="center"><strong>Who can avail the Course</strong></td>    
    <td class="td-heading" width="16%" align="center"><strong>Curriculum</strong></td>
    </tr>
  
   <ct:forEach var="listValue" items="${courseNameOnlyList}">
   <ct:if test="${listValue }"></ct:if>
               <li>${listValue}</li>
                </ct:forEach>
  
  <tr>
    <td class="td-border" align="center"><p>GHP-GMP* Certification Course</p></td>
    <td align="center" class="td-border"><p>PMKVY-RPL</p></td>
    <td class="td-border" align="center"><p>3 hrs</p></td>
    <td class="td-border"><p>Street Food Vendors, Small Restaurants, small manufacturer (cottage industry),petty vendor & petty retailers</p></td>
    <td class="td-border"><p>Basics of food hygiene and safety practices in  establishment’s process : from receiving of material to serving & packaging </p></td>
  </tr>  
</table>
</div>
   </div>
      </div>
      
      </section>
    
<section id="course">
  <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
    <div class="row" style="height:50px;"></div>
      </div>
      </section>
<section id="study">
  <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
    <div class="row">
<div class="col-md-4 col-sm-6">
<h4>Study Material</h4>
 <ul>
            <li><a href="http://www.fssai.gov.in/Portals/0/Training_Manual/Level 1 -English.pdf">Manual on Essential of Food Hygiene</a></li>
            <li><a href="http://www.fssai.gov.in/Portals/0/Training_Manual/Level 1 Facilitator Guide.pdf">Manual on Facilitator Guide for essentials of Food Hygience</a></li>
            <li><a href="http://www.fssai.gov.in/Portals/0/Training_Manual/Volume I- Intoduction to Food  and Food Processing.pdf">Introduction to Food and Food Processing</a></li>
            <li><a href="http://www.fssai.gov.in/Portals/0/Pdf/IEC_Awareness_Materials/Leaflets/Clean_Street_Food_Brochure.pdf">Clean Streat Food Brochure</a></li>
              </ul>

</div>

<div class="col-md-4 col-sm-6">
<h4>PPT</h4>
 <ul style="float: left;">
            <li><a href="ppts/Full PPT hindi translated 2.pdf">Good Hygiene in Streat Food</a></li>
            </ul>
</div>

<div class="col-md-4 col-sm-6">
<h4>Video</h4>
 <ul style="float: left;">
   <li   style="float: left; clear:both;"><a class="swipebox-video" rel="vimeo" href="https://youtu.be/_pSz7G_hV8k" target="_blank">Food Safety and Hygiene</a></li>
   
   <li  style="float: left; clear:both;"><a class="swipebox-video" rel="vimeo" href="https://youtu.be/vtEjKle_XeI" target="_blank">Mislabelled Food</a></li>
           
            </ul>
</div>

<div class="col-md-4 col-sm-6">


</div>

   </div>
      </div>
      </section>

<script src="website/js/jquery.js"></script> 
<script src="website/js/bootstrap.min.js"></script> 
<script src="website/js/jquery.isotope.min.js"></script> 
<script src="website/js/main.js"></script> 
<script src="website/js/wow.min.js"></script>
</body>
</html>