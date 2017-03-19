function getDistrict(val , idName)
{
 	var name1=JSON.stringify({
		courseType:0,
		courseName:0
  })
	$.ajax({
	      type: 'post',
	      url: 'loadDistrict.fssai?data='+ val,
	      contentType : "application/json",
		  data:name1,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	    
	      $('#'+idName+' option').remove();
	      $('#'+idName).append('<option value="0" label="Select District" />');
	      $('#'+idName+' option').remove();
	      $('#'+idName).append('<option value="0" label="Select City" />');
	  	 
	      $.each(mainData1 , function(i , obj)
	  		{
  				$('#'+idName).append('<option value='+obj.districtId+' >'+obj.districtName+'</option>');	
	  		});
	      }
	      });     
}


function getCity(val , idName)
{
	 var name1=JSON.stringify({
			courseType:0,
			courseName:0
	  })
	$.ajax({
	      type: 'post',
	      url: 'loadCity.fssai?data='+ val,
	      contentType : "application/json",
		  data:name1,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      $('#'+idName+' option').remove();
	      $('#'+idName).append('<option value="0" label="Select City" />');
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  		$('#'+idName).append('<option value='+obj.cityId+' >'+obj.cityName+'</option>');	
	  		});
	      }
	      });     
}


function ck_aadhar(tableName ) {
	var name=document.getElementById( "AadharNumber" ).value;
    if(name)
        {
    	
    	var name1=JSON.stringify({
			courseType:0,
			courseName:0
	  })
    	 //var  input = name+"-"+"personalinformationtrainer";
	  
	  var  input = name+"-"+tableName;
    		$.ajax({
    		      type: 'post',
    		      url: 'checkAadhar.fssai?data='+input,
    		      contentType : "application/json",
    		      data:name1,
    		      success: function (response) {   
    		    	$('#aadhar_status').html(response);
    		    	if (response.trim() == 'Already') {
    					document.getElementById('AadharNumber').value = "";
    					document.getElementById("register").style.display = 'none';
    					return false;

    				} else {
    					var aa = $('#aadhar_status').html("");
    					document.getElementById("register").style.display = 'block';
    					return true;
    				}
    		    	
    		      } 
    		      });
     }else{
   	  $( '#aadhar_status' ).html("");
         document.getElementById("register").style.display = 'none';
         return false;
     }
}


function getAssessorName(val) {
 	var name=JSON.stringify({
		courseType:0,
		courseName:0
  })
	$.ajax({
		type : 'post',
		url : 'getAssessorName.fssai?data=' + val,
		contentType : "application/json",
	    data:name,
		success : function(response) {
			var mainData1 = jQuery.parseJSON(response);
			
			$('#assessorName option').remove();
		 	$('#assessorName').append(
					'<option selected value="0" label="Select Assessor Name" />'); 
			$.each(mainData1, function(i, obj) {
				$('#assessorName')
				.append(
						'<option value='+obj[0]+' >' + obj[1]
								+ '</option>');	
			});
		}
	});
}

function getCourseName(val , idName) {
	$('#'+idName+' option').remove();
 	var name=JSON.stringify({
		courseType:0,
		courseName:0
  })
	$.ajax({
		type : 'post',
		url : 'getCourseName.fssai?data='+ val,
		contentType : "application/json",
	    data:name,
		success : function(response) {
			var mainData1 = jQuery.parseJSON(response);
			$('#'+idName+' option').remove();
			$('#'+idName).append(
					'<option value="0" label="--Select Course Name--" />');
			$.each(mainData1, function(i, obj) {
				$('#'+idName)
						.append(
								'<option value='+obj[0]+' >' + obj[1]
										+ '</option>');
			});
		}
	});
}


function getCourseTrainingType(){
	
	var data =  $("#courseName").val();
	var name1=JSON.stringify({
		courseType:0,
		courseName:0
  })
	$.ajax({
		type: 'post',
	    url: 'getCourseTrainingMode.fssai?data='+data,
	    contentType : "application/json",
		  data:name1,
	    success: function (response) {      
	    	console.log("Success respose" + response);
	    if(response == "Online"){
	    	$("#modeOfTraining").val("Online");
	    }else{
	    	$("#modeOfTraining").val("Classroom");
	    }
	   
		},
		failure: function (response){
			console.log("Failure response:" + response);
		}
	});
}



function getBatch(val , idName){

 	var name=JSON.stringify({
		courseType:0
  })
	$.ajax({
	      type: 'post',
	      url: 'getBatchCode.fssai?data='+val,
	      contentType : "application/json",
		  data:name,
	      success: function (response) {   

	      var mainData1 = jQuery.parseJSON(response);
 	        $('#'+idName+' option').remove();
	      $('#'+idName).append('<option value="" label="Select Batch Code" />');
	        $.each(mainData1 , function(i , obj)
	  		{
	  				$('#'+idName).append('<option value='+obj+' >'+obj+'</option>');		
	  		});  
	      }
	      });
}

