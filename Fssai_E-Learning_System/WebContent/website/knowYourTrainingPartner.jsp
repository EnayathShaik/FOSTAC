<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="main-slider" class="no-margin">
    <div class="carousel-inner innerpage">
        <div class="container">
          <div class="row slide-margin">
            <div class="col-sm-12">
            <h1 class="animation animated-item-1" style="padding-bottom:10px;">REGISTER HERE</h1>
            </div>
              <div class="circle-wrap center-block">
              <ul>
                <li><a href="trainee.fssai"><img src="website/images/trainee.png"></a></li>
                <li><a href="trainer.fssai"><img src="website/images/trainer.png"></a></li>
                <li><a href="trainingPartner.fssai"><img src="website/images/training-partner.png"></a></li>
                <li><a href="assessor.fssai"><img src="website/images/assessor.png"></a></li>
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


<!--/#feature-->
 <section id="list">
  <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
    <div class="row">
      <div class="col-md-8 col-xs-12">
    	<h2 class="text-align">Training Partner & Assessment Agency List</h2><br>
      	<h3 class="text-align" style="font-weight:bold; font-size:16px;">Training Partner List:</h3>
      
      											<tbody>
<ct:if test="${not empty tpList }">
<ct:forEach varStatus="loop" var="tpList" items="${tpList}">
<ul>
<li><a href="http://${tpList.websiteUrl}" style="color:#c52d2f;" target="blank">${tpList.trainingPartnerName}</a></li>            
</ul>
</ct:forEach>
</ct:if>

<h3 class="text-align" style="font-weight:bold; font-size:16px;">Assessment Agency List:</h3>
<ct:if test="${not empty aaList }">
<ct:forEach varStatus="loop" var="aaList" items="${aaList}">
<ul>
<li>
<a href="http://${aaList.websiteUrl}" style="color:#c52d2f;" target="_blank">${aaList.assessmentAgencyName}</a></li>            
</ul>
</ct:forEach>
</ct:if>      
        
		
      </div> 
    </div>      
 </section>	
 
 