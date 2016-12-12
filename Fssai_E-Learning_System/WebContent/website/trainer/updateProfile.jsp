<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>


<%-- <%
response.setHeader("Pragma","No-cache");     
response.setHeader("Cache-Control","no-cache");     
response.setDateHeader("Expires",   0); 

%> --%>

<script type="text/javascript">
function validateFields(){
if(document.getElementById("TrainingCenterCorrespondenceLine1").value=="") {
	alert("IN TrainingCenterCorrespondenceLine1");
	 document.getElementById('TrainingCenterCorrespondenceLine1').style.borderColor = "red";
		document.getElementById("TrainingCenterCorrespondenceLine1Error").style.display = 'block';
	document.getElementById("TrainingCenterCorrespondenceLine1").focus();
	return false;
}
else{
    document.getElementById('TrainingCenterCorrespondenceLine1').style.borderColor = "#ccc";
    document.getElementById("TrainingCenterCorrespondenceLine1Error").style.display = 'none'; 
    }
   
    
    if(document.getElementById("TrainingCenterCorrespondenceLine2").value=="") {
    	alert("IN TrainingCenterCorrespondenceLine2");
    	 document.getElementById('TrainingCenterCorrespondenceLine2').style.borderColor = "red";
    		document.getElementById("TrainingCenterCorrespondenceLine2Error").style.display = 'block';
    	document.getElementById("TrainingCenterCorrespondenceLine2").focus();
    	return false;
    }
    else{
        document.getElementById('TrainingCenterCorrespondenceLine2').style.borderColor = "#ccc";
        document.getElementById("TrainingCenterCorrespondenceLine2Error").style.display = 'none'; 
        }
        
        
        if(document.getElementById("TrainingCenterCorrespondenceState").selectedIndex == 0) {
       		////alert("IN Fname");
       		document.getElementById('TrainingCenterCorrespondenceState').style.borderColor = "red";
   	    	document.getElementById("TrainingCenterCorrespondenceStateError").style.display = 'block';
   	    	document.getElementById("TrainingCenterCorrespondenceState").focus();
   	    	return false;
       	}
       	 else{
        	    document.getElementById('TrainingCenterCorrespondenceState').style.borderColor = "#ccc";
        	    document.getElementById("TrainingCenterCorrespondenceStateError").style.display = 'none';
        	    }
        	    
        	    if(document.getElementById("TrainingCenterCorrespondenceDistrict").selectedIndex == 0) {
               		////alert("IN Fname");
               		document.getElementById('TrainingCenterCorrespondenceDistrict').style.borderColor = "red";
           	    	document.getElementById("TrainingCenterCorrespondenceDistrictError").style.display = 'block';
           	    	document.getElementById("TrainingCenterCorrespondenceDistrict").focus();
           	    	return false;
               	}
               	 else{
                	    document.getElementById('TrainingCenterCorrespondenceDistrict').style.borderColor = "#ccc";
                	    document.getElementById("TrainingCenterCorrespondenceDistrictError").style.display = 'none';
                	    }
        	    
        	    if(document.getElementById("TrainingCenterCorrespondenceCity").selectedIndex == 0) {
               		////alert("IN Fname");
               		document.getElementById('TrainingCenterCorrespondenceCity').style.borderColor = "red";
           	    	document.getElementById("TrainingCenterCorrespondenceCityError").style.display = 'block';
           	    	document.getElementById("TrainingCenterCorrespondenceCity").focus();
           	    	return false;
               	}
               	 else{
                	    document.getElementById('TrainingCenterCorrespondenceCity').style.borderColor = "#ccc";
                	    document.getElementById("TrainingCenterCorrespondenceCityError").style.display = 'none';
                	    }
    
        	    var x=document.getElementById("TrainingCenterCorrespondencePincode").value;
            	if(x =="" || x.length<6 ) 
                	    {
                    		////alert("IN Fname");
                    		document.getElementById('TrainingCenterCorrespondencePincode').style.borderColor = "red";
                	    	document.getElementById("TrainingCenterCorrespondencePincodeError").style.display = 'block';
                	    	document.getElementById("TrainingCenterCorrespondencePincode").focus();
                	    	return false;
                    	} 
                    	else{
                    	    document.getElementById('TrainingCenterCorrespondencePincode').style.borderColor = "#ccc";
                    	    document.getElementById("TrainingCenterCorrespondencePincodeError").style.display = 'none';
                    	    }
    
            	  var x =document.getElementById('TrainingCenterPermanentEmail').value;
        		 // if(x!=''){
               var atpos = x.indexOf("@");
               var dotpos = x.lastIndexOf(".");
                 if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
                	    //  alert("Not a valid e-mail address");
              document.getElementById('TrainingCenterPermanentEmail').style.borderColor = "red";
             	document.getElementById("TrainingCenterPermanentEmailError").style.display = 'block';
             	document.getElementById("TrainingCenterPermanentEmail").focus();
                	return false;
                 //}
        		  }else{
                      document.getElementById('TrainingCenterPermanentEmail').style.borderColor = "#ccc";
                      document.getElementById("TrainingCenterPermanentEmailError").style.display = 'none'; 
                     	}
                 var x=document.getElementById("TrainingCenterPermanentMobile").value;
           	 //if(x!=''){
           		 
             	if( x.length<10 || x.length>10 ) {
                      	    
         		document.getElementById('TrainingCenterPermanentMobile').style.borderColor = "red";
     	  		document.getElementById("TrainingCenterPermanentMobileError").style.display = 'block';
     	    	document.getElementById("TrainingCenterPermanentMobile").focus();
       	    	return false;
               //    	}
           	  }
                  	else{
             document.getElementById('TrainingCenterPermanentMobile').style.borderColor = "#ccc"; 
             document.getElementById("TrainingCenterPermanentMobileError").style.display = 'none';
                  	}
                 
           	 if(document.getElementById('checkPermanent').checked==false){
           	 
           	 
           	 
             	if(document.getElementById("TrainingCenterPermanentLine1").value=="") {
            		////alert("IN Fname");
            		document.getElementById('TrainingCenterPermanentLine1').style.borderColor = "red";
        	    	document.getElementById("TrainingCenterPermanentLine1Error").style.display = 'block';
        	    	document.getElementById("TrainingCenterPermanentLine1").focus();
        	    	return false;
            	}else{
            	    document.getElementById('TrainingCenterPermanentLine1').style.borderColor = "#ccc";
            	    document.getElementById("TrainingCenterPermanentLine1Error").style.display = 'none';
            	    }
	    
        	    if(document.getElementById("TrainingCenterPermanentLine2").value=="") {
            		////alert("IN Fname");
            		document.getElementById('TrainingCenterPermanentLine2').style.borderColor = "red";
        	    	document.getElementById("TrainingCenterPermanentLine2Error").style.display = 'block';
        	    	document.getElementById("TrainingCenterPermanentLine2").focus();
        	    	return false;
            	}else{
            	    document.getElementById('TrainingCenterPermanentLine2').style.borderColor = "#ccc";
            	    document.getElementById("TrainingCenterPermanentLine2Error").style.display = 'none';
            	    }
	    
        	   
        	    if(document.getElementById("TrainingCenterPermanentState").selectedIndex == 0) {
            		////alert("IN Fname");
            		document.getElementById('TrainingCenterPermanentState').style.borderColor = "red";
        	    	document.getElementById("TrainingCenterPermanentStateError").style.display = 'block';
        	    	document.getElementById("TrainingCenterPermanentState").focus();
        	    	return false;
            	}
            	 else{
             	    document.getElementById('TrainingCenterPermanentState').style.borderColor = "#ccc";
             	    document.getElementById("TrainingCenterPermanentStateError").style.display = 'none';
             	    }

               	 if(document.getElementById("TrainingCenterPermanentDistrict").selectedIndex == 0) {
               		////alert("IN Fname");
               		document.getElementById('TrainingCenterPermanentDistrict').style.borderColor = "red";
           	    	document.getElementById("TrainingCenterPermanentDistrictError").style.display = 'block';
           	    	document.getElementById("TrainingCenterPermanentDistrict").focus();
           	    	return false;
               	}
               	 else{
                	    document.getElementById('TrainingCenterPermanentDistrict').style.borderColor = "#ccc";
                	    document.getElementById("TrainingCenterPermanentDistrictError").style.display = 'none';
                	    }
          
                	    if(document.getElementById("TrainingCenterPermanentCity").selectedIndex == 0) {
                       		////alert("IN Fname");
                       		document.getElementById('TrainingCenterPermanentCity').style.borderColor = "red";
                   	    	document.getElementById("TrainingCenterPermanentCityError").style.display = 'block';
                   	    	document.getElementById("TrainingCenterPermanentCity").focus();
                   	    	return false;
                       	}
                       	 else{
                        	    document.getElementById('TrainingCenterPermanentCity').style.borderColor = "#ccc";
                        	    document.getElementById("TrainingCenterPermanentCityError").style.display = 'none';
                        	    }
	    
                	    
                   	    
                	    var x=document.getElementById("TrainingCenterPermanentPincode").value;
                    	if(x =="" || x.length<6 ) 
                        	    {
                            		////alert("IN Fname");
                            		document.getElementById('TrainingCenterPermanentPincode').style.borderColor = "red";
                        	    	document.getElementById("TrainingCenterPermanentPincodeError").style.display = 'block';
                        	    	document.getElementById("TrainingCenterPermanentPincode").focus();
                        	    	return false;
                            	} 
                            	else{
                            	    document.getElementById('TrainingCenterPermanentPincode').style.borderColor = "#ccc";
                            	    document.getElementById("TrainingCenterPermanentPincodeError").style.display = 'none';
                            	    }
           	 
           	 					}
           	 
           	 if(document.getElementById("FoodSafetyExpBackground").selectedIndex == 0) {
         		////alert("IN Fname");
         		document.getElementById('FoodSafetyExpBackground').style.borderColor = "red";
     	    	document.getElementById("FoodSafetyExpBackgroundError").style.display = 'block';
     	    	document.getElementById("FoodSafetyExpBackground").focus();
     	    	return false;
         	}
         	 else{
          	    document.getElementById('FoodSafetyExpBackground').style.borderColor = "#ccc";
          	    document.getElementById("FoodSafetyExpBackgroundError").style.display = 'none';
          	    }
     	 
     	  if(document.getElementById("ExpInFoodSafefyTimeMonth").selectedIndex == 0) {
         		////alert("IN Fname");
         		document.getElementById('ExpInFoodSafefyTimeMonth').style.borderColor = "red";
     	    	document.getElementById("ExpInFoodSafefyTimeMonthError").style.display = 'block';
     	    	document.getElementById("ExpInFoodSafefyTimeMonth").focus();
     	    	return false;
         	}
         	 else{
          	    document.getElementById('ExpInFoodSafefyTimeMonth').style.borderColor = "#ccc";
          	    document.getElementById("ExpInFoodSafefyTimeMonthError").style.display = 'none';
          	    }
                        	 
	 if(document.getElementById("NoOfTrainingSessionConducted").value == "") {
		////alert("IN Fname");
		document.getElementById('NoOfTrainingSessionConducted').style.borderColor = "red";
    	document.getElementById("NoOfTrainingSessionConductedError").style.display = 'block';
   	document.getElementById("NoOfTrainingSessionConducted").focus();
    	return false;
    	}
   	 else{
   	    document.getElementById('NoOfTrainingSessionConducted').style.borderColor = "#ccc";
 	    document.getElementById("NoOfTrainingSessionConductedError").style.display = 'none';
   	    }
   
   	   if(document.getElementById("TrainingSessionWishToConduct").value == 0) {
   		////alert("IN Fname");
   		document.getElementById('TrainingSessionWishToConduct').style.borderColor = "red";
       	document.getElementById("TrainingSessionWishToConductError").style.display = 'block';
       	document.getElementById("TrainingSessionWishToConduct").focus();
	    	return false;
      	}
       	 else{
   	    document.getElementById('TrainingSessionWishToConduct').style.borderColor = "#ccc";
   	    document.getElementById("TrainingSessionWishToConductError").style.display = 'none';
   	    } 
           	 
           	 return true;
           	 
           	 
           	 
           	 
           	 
           	 
           	 
    
}
</script>
<script type = "text/javascript" >
       function preventBack(){window.history.forward();}
        setTimeout("preventBack()", 0	);
        window.onunload=function(){null};
        
    </script>

<script>
function getstateid(){
	//alert('ll');
	getstat2();
getstateid1();

}
window.onload=getstateid;
</script>
<script>
function getstateid1(){
	 /* var checkk = ${loginUr.checkAddress};
	if(checkk == true){

		document.getElementById("permanent1").style.display = 'none';
		document.getElementById("permanent2").style.display = 'none';
	}else{
		document.getElementById("permanent1").style.display = 'block';
		document.getElementById("permanent2").style.display = 'block';
	}  */
	var psid = ${stateid};
	var psname='${loginUr.permanentstate.stateName}';
	var pdid='${loginUr.permanentdistrict.districtId}';
	var pdname='${loginUr.permanentdistrict.districtName}';
	var pcid='${loginUr.permanentcity.cityId}';
	var pcname='${loginUr.permanentcity.cityName}';
	var title='${loginUr.title.titleName}';
	var tp = '${tp}';
	var safety=${loginUr.foodSafetyExpBackground};
	var month=${loginUr.expInFoodSafefyTimeMonth};
	//alert('safety is '+safety+" "+month); 
	$("#FoodSafetyExpBackground").prop('selectedIndex', safety);  
	$("#ExpInFoodSafefyTimeMonth").prop('selectedIndex', month);  
	//alert("In Permanent "+psid + ' '+ psname + ' '+ pdid + ' '+ pdname + ' '+ pcid + ' '+ pcname+' '+title + ' '+ tp);
	//$("#TrainingCenterPermanentState").prop('selectedIndex', psid);  
	//TrainingCenterPermanentState.options[0].text = psname;    
	 getStateUpdate(psid , pdid , pcid);
	  
	   // TrainingCenterPermanentState.options[0].text = psname;
	   
	   // TrainingCenterPermanentDistrict.options[0].text = pdname;
		//TrainingCenterPermanentCity.options[0].text = pcname;
		Title.options[0].text = title;
		associatedTrainingpartnerName.options[0].text = tp;
		alert("in permanent");
	}
	
function getStateUpdate(psid , pdid , pcid)
{
	$.ajax({
	      type: 'post',
	      url: 'getStateUpdate.jspp',
	      success: function (response) {      
	      var mainData2 = jQuery.parseJSON(response);
	      $('#TrainingCenterPermanentState option').remove();
	      $('#TrainingCenterPermanentState').append('<option value="0" label="Select Stateeeeee" />');
	  	  
	      $.each(mainData2 , function(i , obj)
	  		{	
	    	  if(psid == obj.stateId){
	    		  $('#TrainingCenterPermanentState').append('<option selected="true" value='+obj.stateId+'>'+obj.stateName+'</option>');	
	    	  }else{
	    		  $('#TrainingCenterPermanentState').append('<option value='+obj.stateId+'>'+obj.stateName+'</option>');	
	    	  }	
	  		});
	      }
	      });
	getDistrictUpdate(psid , pdid , pcid)
	
}

function getDistrictUpdate(ss , dd , cc)
{
	$.ajax({
	      type: 'post',
	      url: 'getDistrictUpdate.jspp?'+ ss,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      $('#TrainingCenterPermanentDistrict option').remove();
	      $('#TrainingCenterPermanentDistrict').append('<option value="0" label="Select District" />');
	  	  
	      $.each(mainData1 , function(i , obj)
	  		{
	    	  if(dd == obj.districtId){
	    		  $('#TrainingCenterPermanentDistrict').append('<option  selected="true" value='+obj.districtId+'>'+obj.districtName+'</option>');
	    	  }else{
	    		  $('#TrainingCenterPermanentDistrict').append('<option value='+obj.districtId+'>'+obj.districtName+'</option>');
	    	  }	
	  		});
	      }
	      }); 
	getCityUpdate(dd , cc);
}
function getCityUpdate(dd , cc)
{
	$.ajax({
	      type: 'post',
	      url: 'getCityUpdate.jspp?'+dd,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      $('#TrainingCenterPermanentCity option').remove();
	      $('#TrainingCenterPermanentCity').append('<option value="0" label="Select City" />');
	  	  
	      $.each(mainData1 , function(i ,obj)
	  		{
	    	  if(cc == obj.cityId){
	    		  $('#TrainingCenterPermanentCity').append('<option selected="true" value='+obj.cityId+'>'+obj.cityName+'</option>');
	    	  }else{
	    		  $('#TrainingCenterPermanentCity').append('<option value='+obj.cityId+'>'+obj.cityName+'</option>');
	    	  }	
	  		});
	      }
	      });     

}
	
	
	function getstat2()
	{
		var csid = '${loginUr.correspondencestate.stateId}';
		var csname = '${loginUr.correspondencestate.stateName}';
		var cdid='${loginUr.correspondencedistrict.districtId}';
		
		var cdname='${loginUr.correspondencedistrict.districtName}';
		var ccid='${loginUr.correspondencecity.cityId}';
		var ccname='${loginUr.correspondencecity.cityName}';
		//var trainingPartnerName='${loginUr.associatedTrainingpartnerName.trainingPartnerName}';
		alert('In Correspondance'+csid + ' '+ csname + ' '+ cdid + ' '+ cdname + ' '+ ccid + ' '+ ccname);
		//TrainingCenterCorrespondenceState.options[0].text = csname;
	   // TrainingCenterCorrespondenceDistrict.options[0].text = cdname;
		//TrainingCenterCorrespondenceCity.options[0].text = ccname;
		getCorrespondanceStateUpdate(csid,cdid,ccid,cdname);
		alert('hii');
		/* associatedTrainingpartnerName.options[0].text = trainingPartnerName; */
	}
	
	function getCorrespondanceStateUpdate(csid,cdid,ccid,cdname)
	{
		$.ajax({
		      type: 'post',
		      url: 'getStateUpdate.jspp',
		      success: function (response) {      
		      var mainData2 = jQuery.parseJSON(response);
		      $('#TrainingCenterCorrespondenceState option').remove();
		      $('#TrainingCenterCorrespondenceState').append('<option value="0" label="Select Stateeeeee" />');
		  	  
		      $.each(mainData2 , function(i , obj)
		  		{	
		    	  if(csid == obj.stateId){
		    		  $('#TrainingCenterCorrespondenceState').append('<option selected="true" value='+obj.stateId+'>'+obj.stateName+'</option>');	
		    	  }else{
		    		  $('#TrainingCenterCorrespondenceState').append('<option value='+obj.stateId+'>'+obj.stateName+'</option>');	
		    	  }	
		  		});
		      }
		      });
		alert('hhhhhhpk');
		CorrDistrictUpdate(csid,cdid,ccid,cdname);
		alert('hhhhhh');
	}

	function CorrDistrictUpdate(csid,cdid,ccid,cdname)
	{
		$.ajax({
		      type: 'post',
		      url: 'getDistrictUpdate.jspp?'+ csid,
		      success: function (response) {      
		      var mainData1 = jQuery.parseJSON(response);
		      $('#TrainingCenterCorrespondenceDistrict option').remove();
		      $('#TrainingCenterCorrespondenceDistrict').append('<option value="0" label="Select District" />');
		  	  
		      $.each(mainData1 , function(i , obj)
		  		{
		    	  
		    	  alert("cdname is "+cdname);
		    	 // $("#TrainingCenterCorrespondenceDistrict").prop('selectedIndex', cdid);
		    	  if(cdid == obj.districtId){
		    		  //TrainingCenterCorrespondenceDistrict.options[0].text = cdname;
		    		  $('#TrainingCenterCorrespondenceDistrict').append('<option selected="true" value='+obj.districtId+'>'+obj.districtName+'</option>');
		    		 alert("cd is "+cdid);
		    		  
		    	  }else{
		    		  $('#TrainingCenterCorrespondenceDistrict').append('<option value='+obj.districtId+'>'+obj.districtName+'</option>');
		    	  }	
		  		});
		      }
		      }); 
		getCorrCityUpdate(cdid , ccid);
	}
	function getCorrCityUpdate(cdid , ccid)
	{
		$.ajax({
		      type: 'post',
		      url: 'getCityUpdate.jspp?'+cdid,
		      success: function (response) {      
		      var mainData1 = jQuery.parseJSON(response);
		      $('#TrainingCenterCorrespondenceCity option').remove();
		      $('#TrainingCenterCorrespondenceCity').append('<option value="0" label="Select City" />');
		  	  
		      $.each(mainData1 , function(i ,obj)
		  		{
		    	  if(ccid == obj.cityId){
		    		  $('#TrainingCenterCorrespondenceCity').append('<option selected="true" value='+obj.cityId+'>'+obj.cityName+'</option>');
		    	  }else{
		    		  $('#TrainingCenterCorrespondenceCity').append('<option value='+obj.cityId+'>'+obj.cityName+'</option>');
		    	  }	
		  		});
		      }
		      });  
		alert("corresep city");
	}
	
	
	
</script>


<script>



 function getDistrict(val)
    {
    	//alert('jjh');
    	$.ajax({
    	      type: 'post',
    	      
    	      url: 'loadDistrict.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	    
    	      $('#TrainingCenterCorrespondenceDistrict option').remove();
    	      $('#TrainingCenterCorrespondenceDistrict').append('<option value="0" label="Select District" />');
    	      $('#TrainingCenterCorrespondenceCity option').remove();
    	      $('#TrainingCenterCorrespondenceCity').append('<option value="0" label="Select City" />');
    	  	 
    	      $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingCenterCorrespondenceDistrict').append('<option value='+obj.districtId+'>'+obj.districtName+'</option>');		
    	  		});
    	      }
    	      });     
    }
    
    function getDistrictList(val)
    {
    	//alert('city');
    	$.ajax({
    	      type: 'post',
    	      
    	      url: 'loadDistrict.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	    
    	      $('#TrainingCenterPermanentDistrict option').remove();
    	      $('#TrainingCenterPermanentDistrict').append('<option value="0" label="Select District" />');
    	      $('#TrainingCenterPermanentCity option').remove();
    	      $('#TrainingCenterPermanentCity').append('<option value="0" label="Select City" />');
    	  	 
    	      $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingCenterPermanentDistrict').append('<option value='+obj.districtId+'>'+obj.districtName+'</option>');		
    	  		});
    	      }
    	      });     
    }
    
    
    
    
    function getCity(val)
    {
    	$.ajax({
    	      type: 'post',
    	      url: 'loadCity.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	      $('#TrainingCenterCorrespondenceCity option').remove();
    	      $('#TrainingCenterCorrespondenceCity').append('<option value="0" label="Select City" />');
    	  	  $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingCenterCorrespondenceCity').append('<option value='+obj.cityId+'>'+obj.cityName+'</option>');		
    	  		});
    	      }
    	      });     
    }
    
    function getCityList(val)
    {
    	$.ajax({
    	      type: 'post',
    	      url: 'loadCity.jspp?'+ val,
    	      success: function (response) {      
    	      var mainData1 = jQuery.parseJSON(response);
    	      $('#TrainingCenterPermanentCity option').remove();
    	      $('#TrainingCenterPermanentCity').append('<option value="0" label="Select City" />');
    	  	  $.each(mainData1 , function(i , obj)
    	  		{
    	  		
    	  				$('#TrainingCenterPermanentCity').append('<option value='+obj.cityId+'>'+obj.cityName+'</option>');		
    	  		});
    	      }
    	      });     
    }
    
    function myCheckPermanent() {
    	var x = document.getElementById('checkPermanent').checked;
    	permanent1.style.display = checkPermanent.checked ? "none" : "block";
    	permanent2.style.display = checkPermanent.checked ? "none" : "block";
    	 if(x == true){
    	    	document.getElementById('TrainingCenterPermanentLine1').value= document.getElementById('TrainingCenterCorrespondenceLine1').value;
    	    	document.getElementById('TrainingCenterPermanentLine2').value= document.getElementById('TrainingCenterCorrespondenceLine2').value;
    	    	document.getElementById('TrainingCenterPermanentPincode').value= document.getElementById('TrainingCenterCorrespondencePincode').value;    	
    	    	document.getElementById('').value= document.getElementById('').value;
    	    	document.getElementById('').value= document.getElementById('').value;
    	    	document.getElementById('').value= document.getElementById('').value;
    	    	    	    }
    	    if(x == false){
    	    	/* document.getElementById('TrainingCenterCorrespondenceLine1').value= "";
    	    	document.getElementById('TrainingCenterCorrespondenceLine2').value= "";
    	    	document.getElementById('TrainingCenterCorrespondencePincode').value= ""; */
    	    	document.getElementById('TrainingCenterPermanentLine1').value= "";
    	    	document.getElementById('TrainingCenterPermanentLine2').value= "";
    	    	document.getElementById('TrainingCenterPermanentPincode').value= "";
    	    	document.getElementById('').value= document.getElementById('').value="";
    	    	document.getElementById('').value= document.getElementById('').value="";
    	    	document.getElementById('').value= document.getElementById('').value="";   	    	
    	    }
    } 
    
    </script>

    <!-- horizontal navigation -->
    <cf:form   action="updateTrainer11.fssai" name="myForm" method="POST" commandName="updateInformation" onsubmit="return validateFields();"> 
    <section>
        <div class="container-fluid">
            <nav class="navbar navbar-default navbar-fixed-top horizontal-nav-top horizontal-top-nav-border">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                            </div>
                            <div id="navbar" class="navbar-collapse collapse">
                                <ul class="nav navbar-nav">
                                    <li></li>
                                    <li class="hori"><a href="#">Home</a></li>
                                    <li class="hori"><a href="search-and-apply.fssai">Search & Apply Vacancy</a></li>
                                    <li class="hori active"><a href="update-profile.fssai">Update Profile</a></li>
                                    <li class="hori"><a href="contactTrainer.fssai">Contact Us</a></li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-cog fa-spin"></i> <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="changePasswordTrainer.fssai">Change Password</a></li>
                                            <li><a href="fostac.fssai">Logout</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <!--/.nav-collapse -->
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
                <!-- Sidebar -->
                <div id="sidebar-wrapper">
                    <ul class="sidebar-nav">
                        <!-- <li class="sidebar-brand">
                            </li> -->
                        <li class="dropdown active"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Course Enrollment <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="basicTrainer.fssai" class="clr">Basic Course</a></li>
                                <li><a href="advanceTrainer.fssai" class="clr">Advanced Course</a></li>
                                <li><a href="specialTrainer.fssai" class="clr">Special Course</a></li>
                            </ul>
                        </li>
                        <li> <a href="generate-admit-card.fssai">Generate Admit Card</a> </li>
                        <li> <a href="course-training.fssai">Training</a> </li>
                        <li> <a href="assessment-instructions.fssai">Assessment</a> </li>
                        <li> <a href="feedback-form.fssai">Feedback</a> </li>
                        <li> <a href="generate-certificate.fssai">Certification</a> </li>
                    </ul>
                </div>
                <!-- /#sidebar-wrapper -->
                <!-- Page Content -->
                <div id="page-content-wrapper">
                    <div class="container-fluid">
                        <!-- vertical button -->
                        <div class="row">
                            <div class="col-lg-12">
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome ${loginUr.loginDetails.loginId}</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-12">
                                    <form>
                                        <!-- personal info -->
                                        <div class="personel-info">
                                            <fieldset>
                                                <legend>
                                                    <h3>Personal Information</h3> </legend>
                                                <!-- left side -->
                                                <div class="col-md-6 col-xs-12">
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>User Id:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <input type="text" class="form-control" disabled="disabled"  value="${loginUr.loginDetails.loginId}" > 
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Aadhar:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <input type="text" class="form-control" placeholder="Aadhar Number"   disabled="disabled"  value="${loginUr.aadharNumber}"> 
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Date of Birth:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <input type="date" class="form-control" placeholder="Date"  disabled="disabled"  value="${loginUr.DOB}">
                                                    </div>
                                                    
                                                  
                                                    
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Upload Your Profile:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <input type="file" id="myFile">
                                                    </div>
                                                    
                                                    
                                                    
                                                    <div class="form-group">
                                                       <!--  <label>Gender</label>
                                                        <br />
                                                        <label class="radio-inline">
                                                            <input type="radio" name="optradio"> Yes </label>
                                                        <label class="radio-inline">
                                                            <input type="radio" name="optradio"> No </label> -->
                                                            <label class="radio-inline">
<cf:radiobutton path="gender" value="M" checked="true" />Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <cf:radiobutton path="gender" value="F" />Female
</label>
                                                    </div>
                                                    
                                                </div>
                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Title:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <cf:select path="Title" class="form-control" disabled="true">
<cf:option value="0" label="Select Title"  />
<cf:options items="${titleList}" itemValue="titleId" itemLabel="titleName" />
</cf:select>
                                                         </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>First Name:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <input type="text" class="form-control" placeholder="First Name" disabled="disabled"  value="${loginUr.firstName}"> </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Middle Name:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <input type="text" class="form-control" placeholder="Middle Name" disabled="disabled"  value="${loginUr.middleName}"> </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Last Name:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <input type="text" class="form-control" placeholder="Last Name"  disabled="disabled"  value="${loginUr.lastName}"> </div>
                                               
                                               <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Father Name:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <input type="text" class="form-control" placeholder="Father Name"  disabled="disabled"  value="${loginUr.fathername}"> </div>
                                               
                                                </div>
                                            </fieldset>
                                        </div>
                                        <div class="row" style="height: 20px;"> </div>
                                        <!-- contact details -->
                                        <div class="personel-info">
                                            <fieldset>
                                                <legend>
                                                    <h3>Contact Information</h3> </legend>
                                                <!-- permanent address -->
                                                <!--Left side-->
                                                <div class="col-md-6 col-xs-12">
                                                    <h4>Correspondence Address</h4>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Correspondence Address Line 1:</strong></li>
                                                                <li class="style-li error-red">
<label id="TrainingCenterCorrespondenceLine1Error" class="error visibility">* enter your TrainingCenterCorrespondence1</label>
<cf:errors path="TrainingCenterCorrespondenceLine1" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" maxlength="100" path="TrainingCenterCorrespondenceLine1" placeholder="Training Center Line 1"    value="${loginUr.trainingCenterCorrespondenceLine1}"/> </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Correspondence Address Line 2:</strong></li>
                                                                <li class="style-li error-red">
<label id="TrainingCenterCorrespondenceLine2Error" class="error visibility">* enter your TrainingCenterCorrespondence2</label>
<cf:errors path="TrainingCenterCorrespondenceLine2" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" maxlength="100" path="TrainingCenterCorrespondenceLine2" placeholder="Training Center Line 2" value="${loginUr.trainingCenterCorrespondenceLine2}" /> </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>State:</strong></li>
                                                                <li class="style-li error-red">
<label id="TrainingCenterCorrespondenceStateError" class="error visibility">* enter your TrainingCenterCorrespondenceState</label>
<cf:errors path="TrainingCenterCorrespondenceState" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                       <cf:select path="TrainingCenterCorrespondenceState" class="form-control" onchange="getDistrict(this.value);">
<cf:option value="0" label="Select State" />
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
</cf:select>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>District:</strong></li>
                                                                <li class="style-li error-red">
<label id="TrainingCenterCorrespondenceDistrictError" class="error visibility">* enter your TrainingCenterCorrespondenceDistrict</label>
<cf:errors path="TrainingCenterCorrespondenceDistrict" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                       <cf:select path="TrainingCenterCorrespondenceDistrict" class="form-control" onchange="getCity(this.value);">
<cf:option value="0" label="Select District" />
<%-- <cf:options items="${districtList}" itemValue="districtId" --%>itemLabel="districtName" /> 
</cf:select>
                                                    </div>
                                                </div>
                                                <!-- left side ends -->
                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                    <h5><br>
                          </h5>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Closest City:</strong></li>
                                                                 <li class="style-li error-red">
<label id="TrainingCenterCorrespondenceCityError" class="error visibility">* enter your TrainingCenterCorrespondenceCity</label>
<cf:errors path="TrainingCenterCorrespondenceCity" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                       <cf:select path="TrainingCenterCorrespondenceCity" class="form-control">
<cf:option value="0" label="Select City" />
<%-- <cf:options items="${cityList}" itemValue="cityId" --%> itemLabel="cityName" />
</cf:select>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>PIN Code:</strong></li>
                                                                 <li class="style-li error-red">
<label id="TrainingCenterCorrespondencePincodeError" class="error visibility">* enter your TrainingCenterCorrespondencePincode</label>
<cf:errors path="TrainingCenterCorrespondencePincode" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" maxlength="6" path="TrainingCenterCorrespondencePincode"  onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"  placeholder="Pincode" value="${loginUr.trainingCenterCorrespondencePincode}" /> </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Email:</strong></li>
                                                                 <li class="style-li error-red">
<label id="TrainingCenterPermanentEmailError" class="error visibility">* enter your Email</label>
<cf:errors path="TrainingCenterPermanentEmail" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" path="TrainingCenterPermanentEmail" placeholder="Email" value="${loginUr.trainingCenterPermanentEmail}" /> </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Mobile:</strong></li>
                                                                 <li class="style-li error-red">
<label id="TrainingCenterPermanentMobileError" class="error visibility">* enter your TrainingCenterPermanentMobile</label>
<cf:errors path="TrainingCenterPermanentMobile" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" maxlength="10" path="TrainingCenterPermanentMobile"  onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')"  placeholder="Mobile" value="${loginUr.trainingCenterPermanentMobile}" /> </div>
                                                </div>
                                                <!-- right side ends -->
                                                <!-- permanent address ends -->
                                                <!-- selection -->
                                                <%-- <div class="col-xs-12">
                                                    <div class="form-group">
                                                        <!-- <label>Is your correspondence address same as permanent address</label>
                                                        <br>
                                                        <label class="radio-inline">
                                                            <input type="radio" name="optradio"> Yes </label>
                                                        <label class="radio-inline">
  
                                                            <input type="radio" name="optradio"> No </label> -->
  <input type="checkbox" id="checkPermanent" onclick="myCheckPermanent(this)"> <label class = "error">Is your permanent address same as correspondence address.</label>                                                           
                                                    </div>
                                                </div>
                                                <!-- selection ends -->
                                                <!-- correspondance address -->
                                                <!--Left side-->
                                                <div class="col-md-6 col-xs-12">
                                                    <h4>Permanent Address</h4>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Permanent Adddress Line 1:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" path="TrainingCenterPermanentLine1" placeholder="Training Center Line 1" value="${loginUr.trainingCenterPermanentLine1}"/> </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Permanent Adddress Line 2:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" path="trainingCenterPermanentLine2" placeholder="Training Center Line 2" value="${loginUr.trainingCenterPermanentLine2}"/> </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>State:</strong></li>
                                                            </ul>
                                                        </div>
                                                       <cf:select path="TrainingCenterPermanentState" class="form-control" onchange="getDistrictList(this.value);">
<cf:option value="0" label="Select State" />
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
</cf:select>
                                                    </div>
                                                </div>
                                                <!-- left side ends -->
                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                    <h5><br>
                          </h5>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>District:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <cf:select path="TrainingCenterPermanentDistrict" class="form-control"  onchange="getCityList(this.value);">
<cf:option value="0" label="Select District" />
<cf:options items="${districtList}" itemValue="districtId" itemLabel="districtName" />
</cf:select>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Closest City:</strong></li>
                                                            </ul>
                                                        </div>
                                                       <cf:select path="TrainingCenterPermanentCity" class="form-control">
<cf:option value="0" label="Select City" />
<cf:options items="${cityList}" itemValue="cityId" itemLabel="cityName" />
</cf:select>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>PIN Code:</strong></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" path="TrainingCenterPermanentPincode" placeholder="Pincode" value="${loginUr.trainingCenterPermanentPincode}"/> </div>
                                                </div>
                                                <!-- right side ends -->
                                            </fieldset>
                       --%>     
                       
        
                       
                                    </div>
                                    
                                      <fieldset >
		<legend>Permanent Address</legend>
		
<div class="col-xs-12">
<div class="col-md-12 col-sm-12 col-x-sm-12">
<ct:choose>
<ct:when test="${loginUr.checkAddress == true }">
<input type="checkbox" id="checkPermanent" onclick="myCheckPermanent(this)" checked="checked"> <label class = "error">Is your permanent address same as correspondence address.</label> 
</ct:when>
<ct:otherwise>
<input type="checkbox" id="checkPermanent" onclick="myCheckPermanent(this)"> <label class = "error">Is your permanent address same as correspondence address.</label> 
</ct:otherwise>
</ct:choose>

</div>

</div>		
<!--Left side-->
<div class="col-md-6 col-xs-12" id="permanent1">

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainer.TrainingCenterPermanentLine1" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterPermanentLine1Error" class="error visibility">* enter your Permanent Training Center</label>
<cf:errors path="TrainingCenterPermanentLine1"  cssclass="error"/></li> 
</ul>
</div>
<cf:input path="TrainingCenterPermanentLine1" maxlength="100" placeholder="Address Line 1" class="form-control" value="${loginUr.trainingCenterPermanentLine1}" />
</div> 

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainer.TrainingCenterPermanentLine2" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterPermanentLine2Error" class="error visibility">* enter your Permanent Training Center</label>
<cf:errors path="TrainingCenterPermanentLine2"  cssclass="error"/></li> 
</ul>
</div>
<cf:input path="TrainingCenterPermanentLine2" maxlength="100" placeholder="Address Line 2" class="form-control" value="${loginUr.trainingCenterPermanentLine2}"/>
</div> 

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.State" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="TrainingCenterPermanentStateError">Please select state</label>
<cf:errors path="TrainingCenterPermanentState" cssclass="error" /></li>
</ul>
</div>
<cf:select path="TrainingCenterPermanentState" class="form-control" onchange="getDistrictList(this.value);">
<cf:option value="0" label="Select State" />
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName" />
</cf:select>
</div>


</div>
<!-- left side ends -->               
<!-- right side -->
<div class="col-md-6 col-xs-12" id="permanent2">
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.District" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="TrainingCenterPermanentDistrictError">Please select district</label>
<cf:errors path="TrainingCenterPermanentDistrict" cssclass="error" /></li>
</ul>
</div>
<cf:select path="TrainingCenterPermanentDistrict" class="form-control"  onchange="getCityList(this.value);">
<cf:option value="0" label="Select District" />
<%-- <cf:options items="${districtList}" itemValue="districtId" --%> itemLabel="districtName" />
</cf:select>
</div>

<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.City" /></strong></li>
<li class="style-li error-red">
<label class="error visibility" id="TrainingCenterPermanentCityError">Please select city</label>
<cf:errors path="TrainingCenterPermanentCity" cssclass="error" /></li>
</ul>
</div>
<cf:select path="TrainingCenterPermanentCity" class="form-control">
<cf:option value="0" label="Select City" />
<%-- <cf:options items="${cityList}" itemValue="cityId" --%> itemLabel="cityName" />
</cf:select>
</div>
              
<div class="form-group">
<div>
<ul class="lab-no">
<li class="style-li"><strong><cs:message code="lbl.Trainee.Pincode" /></strong></li>
<li class="style-li error-red">
<label id="TrainingCenterPermanentPincodeError" class="error visibility">* enter your pinNumber</label>
<cf:errors path="TrainingCenterPermanentPincode" cssclass="error" /></li>        
</ul>
</div>
<%-- <cf:input path="TrainingCenterPermanentPincode" name="TrainingCenterPermanentPincode" onkeyup="if (/\D/g.test(this.value)) this.value = this.value.replace(/\D/g,'')" placeholder="Pincode" class="form-control" type="text" value="" maxlength="6" value="${loginUr.trainingCenterPermanentPincode}"/> --%>
<cf:input type="text" class="form-control" maxlength="6" path="TrainingCenterPermanentPincode" placeholder="Pincode" value="${loginUr.trainingCenterPermanentPincode}"/>
</div>


</div>
<!-- right side ends -->
</fieldset>             
                                        <!-- contact details ends -->
                                        <div class="row" style="height: 20px;"> </div>
                                        <!-- Experience Detais -->
                                        <div class="personel-info">
                                            <fieldset>
                                                <legend>
                                                    <h3>Experience Details</h3> </legend>
                                                <!-- left side -->
                                                <div class="col-md-6 col-xs-12">
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Food Safety Experience Background:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                                <li class="style-li error-red">
<label id="FoodSafetyExpBackgroundError" class="error visibility">* enter your FoodSafetyExpBackground</label>
<cf:errors path="FoodSafetyExpBackground" cssclass="error" /></li> 
                                                            </ul>
                                                        </div>
                                                       <cf:select path="FoodSafetyExpBackground" class="form-control">
<cf:option value="0" label="Select background" />
<cf:option value="1" label="Industry" />
<cf:option value="2" label="Academics" />
<cf:option value="3" label="R & D" />
</cf:select>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>Experience in Food Safety Experience:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                                
                                                                <li class="style-li error-red">
<label id="ExpInFoodSafefyTimeYearError" class="error visibility">* enter your FoodSafetyExpBackground</label>
<cf:errors path="ExpInFoodSafefyTimeYear" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-xs-6">
                                                                <!-- <select class="form-control" required>
                                                                    <option>Select Year</option>
                                                                    <option>2001</option>
                                                                    <option>2002</option>
                                                                    <option>2003</option>
                                                                    <option>2004</option>
                                                                    <option>2005</option>
                                                                </select> -->
   <cf:input type="text" name="experienceyear" path="ExpInFoodSafefyTimeYear" value="${loginUr.expInFoodSafefyTimeYear}" style="height:40px;border-Color:red"/>                                                       
                                                            </div>
                                                            <div class="col-xs-6">
                                                           
                                                            <li class="style-li error-red">
<label id="ExpInFoodSafefyTimeMonthError" class="error visibility">* enter your ExpInFoodSafefyTimeMonth</label>
<cf:errors path="ExpInFoodSafefyTimeMonth" cssclass="error" /></li>
                                                                <cf:select path="ExpInFoodSafefyTimeMonth" class="form-control">
<cf:option value="0" label="Select Month" />
<cf:option value="1" label="1" />
<cf:option value="2" label="2" />
<cf:option value="3" label="3" />
<cf:option value="4" label="4" />
<cf:option value="5" label="5" />
<cf:option value="6" label="6" />
<cf:option value="7" label="7" />
<cf:option value="8" label="8" />
<cf:option value="9" label="9" />
<cf:option value="10" label="10" />
<cf:option value="11" label="11" />
</cf:select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>No. Of Training Sessions Conducted:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                                
                                                                <li class="style-li error-red">
<label id="NoOfTrainingSessionConductedError" class="error visibility">* enter your NoOfTrainingSessionConducted</label>
<cf:errors path="NoOfTrainingSessionConducted" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                        <cf:input type="text" class="form-control" path="NoOfTrainingSessionConducted" placeholder="Session Number" value="${loginUr.noOfTrainingSessionConducted}"/> </div>
                                                </div>
                                                <!-- left side ends -->
                                                <!-- right side -->
                                                <div class="col-md-6 col-xs-12">
                                                    <div class="form-group">
                                                        <label>How Many Trainings (4Hrs) Sessions Wish To Conduct in a Month ?</label>
                                                        <li class="style-li error-red">
<label id="TrainingSessionWishToConductError" class="error visibility">* enter your TrainingSessionWishToConduct</label>
<cf:errors path="TrainingSessionWishToConduct" cssclass="error" /></li>
                                                        <cf:input type="text" class="form-control" path="TrainingSessionWishToConduct" placeholder="Session Number" value="${loginUr.trainingSessionWishToConduct}" /> </div>
                                                    <div class="form-group">
                                                        <label>Associated with any Training Partner ?</label>
                                                        <br />
                                                       <!--  <label class="radio-inline">
                                                            <input type="radio" name="optradio"> Yes </label>
                                                        <label class="radio-inline">
                                                            <input type="radio" name="optradio"> No </label> -->
                                                            <label class="radio-inline">
<cf:radiobutton path="AssociatedWithAnyTrainingPartner" value="Y" checked="true" />Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<cf:radiobutton path="AssociatedWithAnyTrainingPartner" value="N" />No</td>
</label>
                                                    </div>
                                                    <div class="form-group">
                                                        <div>
                                                            <ul class="lab-no">
                                                                <li class="style-li"><strong>If Yes Training Partner Name:</strong></li>
                                                                <li class="style-li error-red"> </li>
                                                                <li class="style-li error-red"> -->
<label id="associatedTrainingpartnerNameError" class="error visibility">* enter your associatedTrainingpartnerName</label>
<cf:errors path="associatedTrainingpartnerName" cssclass="error" /></li>
                                                            </ul>
                                                        </div>
                                                   <%-- <cf:input type="text" class="form-control" path="associatedTrainingpartnerName" placeholder="Partner Name"  value="${loginUr.associatedTrainingpartnerName}"/> --%>
                                         <cf:select path="associatedTrainingpartnerName" class="form-control">
					<cf:options items="${trainingPartnerNameList}" itemValue="manageTrainingPartnerId" itemLabel="trainingPartnerName" />
					</cf:select> 
                                                       
                                                        </div>
                                                </div>
                                                <!-- right side ends -->
                                            </fieldset>
                                        </div>
                                        <div class="row" style="height: 20px;"> </div>
                                        <!-- Basic courses -->
                                        <div class="personel-info">
                                            <h4>Courses wish to conduct ?</h4>
                                            <fieldset>
                                                <legend>
                                                    <h3>Basic Courses</h3> </legend>
                                                <!-- left -->
                                                <div class="col-md-6 col-xs-12">
                                                   <%--  <div class="checkbox">
                                                     <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue.coursetypeid == 1}">
 <label> <input type="checkbox" value="${loginUr.basicCourse}"  value="${listValue.coursenameid }" name="BasicCourse"  id="${listValue.coursenameid }"  onclick=" return myBasic();">${listValue.coursename}  </label><br>
 </ct:if>
 </ct:forEach>

 <cf:hidden path="BasicCourse1" value=""/>
                                                    </div>
                                                </div>
                                                <!-- right -->
                                                <div class="col-md-6 col-xs-12"></div>
                                            </fieldset>
                                        </div>
                                        <!-- basic course -->
                                        <!-- Advanced courses -->
                                        <div class="personel-info">
                                            <fieldset>
                                                <legend>
                                                    <h3>Advanced Courses</h3> </legend>
                                                <!-- left -->
                                                <div class="col-md-6 col-xs-12">
                                                     <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue.coursetypeid == 2}">
 <label> <input type="checkbox" value="${listValue.coursenameid }" name="AdvanceCourse" id="${listValue.coursenameid }" onclick=" return myAdvance();">${listValue.coursename}</label><br>
 </ct:if>
 </ct:forEach>
 <cf:hidden path="AdvanceCourse1" value=""/>
                                                    </div>
                                                </div>
                                                <!-- right -->
                                                <div class="col-md-6 col-xs-12"></div>
                                            </fieldset>
                                        </div>
                                        <!-- advanced course -->
                                        <!-- special courses -->
                                        <div class="personel-info">
                                            <fieldset>
                                                <legend>
                                                    <h3>Special Courses</h3> </legend>
                                                <!-- left -->
                                                <div class="col-md-6 col-xs-12">
                                                    <div class="checkbox">
                                                       <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue.coursetypeid == 3}">
 <label> <input type="checkbox"  value="${listValue.coursenameid }" name="SpecialCourse"  id="${listValue.coursenameid }"  onclick=" return mySpecial();">${listValue.coursename}</label><br>
 </ct:if>
</ct:forEach>
<cf:hidden path="SpecialCourse1" value=""/>
                                                    </div>
                                                </div>
                                                <!-- right -->
                                                <div class="col-md-6 col-xs-12"> </div>
                                            </fieldset>
                                        </div> --%>
                                        <div class="checkbox">
<ct:if test="${not empty basicCourseList }">
 <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue[0] == 1}">
 <label> <input type="checkbox"  value="${listValue[2] }" name="BasicCourse"  id="${listValue[2] }"  onclick=" return myBasic();">${listValue[1]}</label><br>
 </ct:if>
 </ct:forEach>
</ct:if>
 <cf:hidden path="BasicCourse1" value=""/>
</div>
 </div>
<!-- right -->
<div class="col-md-6 col-xs-12"></div>
</fieldset>
</div>
<!-- basic course -->           
<!-- Advanced courses -->          
<div class="personel-info">
<fieldset>
<legend>Advanced Courses</legend>
<!-- left -->
<div class="col-md-6 col-xs-12" style="width:100%;">
<div class="checkbox">
<ct:if test="${not empty basicCourseList }">
 <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue[0] == 2}">
 <label> <input type="checkbox" value="${listValue[2] }" name="AdvanceCourse" id="${listValue[2] }" onclick=" return myAdvance();">${listValue[1]}</label><br>
 </ct:if>
 </ct:forEach>
 </ct:if>
 <cf:hidden path="AdvanceCourse1" value=""/>
</div>
<!-- right -->
<div class="col-md-6 col-xs-12"></div></div>
</fieldset>
</div>
<!-- advanced course --> 
          
<!-- special courses -->
<div class="personel-info">
<fieldset>
<legend>Special Courses</legend>
<!-- left -->
<div class="col-md-6 col-xs-12" style="width:100%;">
<div class="checkbox">
<ct:if test="${not empty basicCourseList }">
 <ct:forEach var="listValue" items="${basicCourseList}">
 <ct:if test="${listValue[0] == 3}">
 <label> <input type="checkbox"  value="${listValue[0] }" name="SpecialCourse"  id="${listValue[2] }"  onclick=" return mySpecial();">${listValue[1]}</label><br>
 </ct:if>
</ct:forEach>
</ct:if>
<cf:hidden path="SpecialCourse1" value=""/>
</div>
</div>              
<!-- right -->
<div class="col-md-6 col-xs-12"> </div>
</fieldset>
</div>
                                        <!-- special course -->
                                        <div class="row" style="height: 20px;"> </div>
                                        <div class="col-xs-12">
                                            <!-- <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> <a href="#" target="_blank" class="terms-font-size"> I have read and understood the Terms &amp; Conditions
                          and the Privacy Policy of FSSAI. </a> </label>
                                            </div> -->
                                        </div>
                                        <div class="col-md-4 hidden-xs"></div>
                                        <div class="col-md-4 col-xs-12">
                                            <div class="pull-right">
                                                <div class="form-group">
<input type="submit" class="form-control login-btn" value="Update" >
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4 hidden-xs"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    </cf:form>
    <!-- scripts -->
   
