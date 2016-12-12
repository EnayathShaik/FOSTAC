<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="website/js/jquery-1.9.1.js"></script>
<script>
function getDistrict(val)
{
	
	$.ajax({
	      type: 'post',
	      
	      url: 'loadDistrict.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	    
	      $('#districtId option').remove();
	      $('#districtId').append('<option value="0" label="Select District" />');
	      $.each(mainData1 , function(i , obj)
	  		{
	  		
	  				$('#districtId').append('<option value='+obj.districtId+' label='+obj.districtName+' />');		
	  		});
	      }
	      });     
}


</script>
<cf:form name="myForm" method="POST" commandName="trainingPartnerSearch" > 

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
      <h2 class="text-align">Search Training Center</h2>
    </div>
  </div>
  <div class="row">
    <div class="col-md-6 col-xs-12"> 
<!--     <label>State:</label> -->
<!--       <select class="form-control"> -->
<!--         <option>Delhi</option> -->
<!--         <option>UP</option> -->
<!--         <option>HP</option> -->
<!--       </select> -->
<%--       	<cf:select path="stateId" class="form-control" onchange="getDistrict(this.value);"> --%>
<%-- 			<cf:option value="0" label="Select State" /> --%>
<%-- 			<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName"/> --%>
<%-- 		</cf:select> --%>
<!--       <label>District:</label> -->
<!--       <select class="form-control"> -->
<!--         <option>Delhi</option> -->
<!--         <option>Kanpur</option> -->
<!--         <option>Shimla</option> -->
<!--       </select>       -->

<%-- 		<cf:select path="districtId" class="form-control" > --%>
<%-- 		<cf:option value="0" label="Select District" /> --%>
		<%-- <cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName"/> --%>
<%-- 		</cf:select> --%>
<!--       <button style="margin-left:5px;" class="btn btn-default" type="button">Search</button> -->
    </div>
  </div>  
</section>
<script type="text/javascript">
var formObj = '${trainingPartnerSearch}';
var formData = JSON.parse(formObj);
var tableRow = formData.listTp;
</script>
<section>
	<div class="container">
    	<div class="row">
    <div class="col-md-12 col-xs-12"> 
    <div style="margin-top: 20px;"></div>
    <table class="table table-border table-responsive table-striped table-hover" id="tblTrainingPartners">
  <thead>
    <th class="td-heading text-center">Training Partner Name</th>
    <th class="td-heading text-center">Training Center Name</th>
<!--     <th class="td-heading text-center">Contact Person Name</th> -->
    <th class="td-heading text-center">Training Center Address, Phone Number, Email ID</th>
    <th class="td-heading text-center">Running Courses</th>
  </thead>
  <script type="text/javascript">
  $.each(tableRow , function(i , obj)
 		{
	 		$('#tblTrainingPartners').append(' <tr> <td class="text-center">'+obj.trainingPartnerName+'</td>'+
	 				'<td class="text-center">'+obj.trainingCenterName+'</td>'+
	 				'<td class="text-center">'+obj.details+'</td>'+
	 				'<td class="text-center">'+obj.courseName+'</td></tr>');		
 		});
  </script>
</table>
    </div>
  </div>
    </div>
</section>
</cf:form>