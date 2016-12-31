<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="cs" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="ct" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function OnStart(){
	onLoadRegion();
}
window.onload = OnStart;
</script>
<script type='text/javascript'>
function onLoadRegion(){
	$('#newTable').show();
	$('#newTable tr').remove();
	$.ajax({
		type: 'post',
		url: 'onLoadRegion.jspp',
		async: false, 
		success: function (data){
		$('#newTable').show();
		var mainData1 = jQuery.parseJSON(data);
		////alert(mainData1);
		var j=1;
		$('#newTable tr').remove();
		$('#newTable').append('<tr  class="background-open-vacancies" style="background-color:#000077;"><th>S.No.</th><th>Region Name</th><th>District Name</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[0]+'</td><td>'+obj[1]+'</td></tr>');	
		});
		}
		}); 
	return result;
}
</script>
<script type="text/javascript">

function getDistrict(val)
{
	//alert('jjh');
	$.ajax({
	      type: 'post',
	      
	      url: 'loadDistrict.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	    
	      $('#districtId option').remove();
	      $('#districtId').append('<option value="0" label="Select District" />');
	      $('#cityId option').remove();
	      $('#cityId').append('<option value="0" label="Select City" />');
	  	 
	      $.each(mainData1 , function(i , obj)
	  		{
	  		
	  				$('#districtId').append('<option value='+obj.districtId+'>'+obj.districtName+'</option>');		
	  		});
	      }
	      });     
}correspondenceCity


function getCity(val)
{
	$.ajax({
	      type: 'post',
	      url: 'loadCity.jspp?'+ val,
	      success: function (response) {      
	      var mainData1 = jQuery.parseJSON(response);
	      $('#cityId option').remove();
	      $('#cityId').append('<option value="0" label="Select City" />');
	  	  $.each(mainData1 , function(i , obj)
	  		{
	  		
	  				$('#cityId').append('<option value='+obj.cityId+'>'+obj.cityName+'</option>');		
	  		});
	      }
	      });     
}


function validateFields() {
	$('.displayNone').css('display', 'block');
	if(document.getElementById("regionName").value=="") {
	document.getElementById("regionName").style.borderColor = "red";
	document.getElementById("regionNameError").style.display = 'block';
	document.getElementById("regionName").focus();
	return false;
	}else{
	    document.getElementById('regionName').style.borderColor = "#ccc";
	    document.getElementById("regionNameError").style.display = 'none';
	    }
	if(document.getElementById("districtId").value=="0") {
		document.getElementById("districtId").style.borderColor = "red";
		document.getElementById("regionNameError").style.display = 'block';
		document.getElementById("districtId").focus();
		return false;
		}else{
		    document.getElementById('districtId').style.borderColor = "#ccc";
		    document.getElementById("districtIdError").style.display = 'none';
		    }
	return( true );
}

function searchRegion(){
	var regionName =  $("#regionName").val();
	//var districtId =  $("#districtId").val();
	 {
		var result="";
		var total = regionName ; //"regionName="+regionName+"&districtId="+districtId;
		$.ajax({
		type: 'post',
		url: 'searchRegion.jspp?'+ total,
		async: false, 
		success: function (data){
		$('#newTable').show();
		var mainData1 = jQuery.parseJSON(data);
		//alert(mainData1);
		var j=1;
		$('#newTable tr').remove();
		$('#newTable').append('<tr  class="background-open-vacancies" style="background-color:#000077;"><th>S.No.</th><th>State</th><th>District</th><th>City</th><th>Region Name</th></tr>')
		$.each(mainData1 , function(i , obj)
		{
			$('#newTable').append('<tr id="tableRow"><td>'+j++ +'</td><td>'+obj[1]+'</td><td>'+obj[2]+'</td><td>'+obj[3]+'</td><td>'+obj[4]+'</td></tr>');	
		});
		}
		});
	return result;
	}

}
</script>
<cf:form action="regionMasterSave.fssai" name="myForm" method="POST" commandName="regionMappingMaster" onsubmit="return validateFields();"> 

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
                                <a href="#menu-toggle" class="vertical-menu-position-btn" id="menu-toggle"> <i class="fa fa-bars"></i> <span class="orange-font">Welcome Admin</span> </a>
                            </div>
                        </div>
                        <!-- add the content here for main body -->
                        <!-- timeline  -->
                        <div class="row">

                                <div class="col-xs-12">
                                    <h1>Region Mapping</h1>
                                    <div class="row">
                                        <div class="col-xs-12">

                                            <!-- left side -->
                                            <div class="col-xs-6">
                                            
                                              <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>State Name:
                                                            <span style="color:red;">*</span>
                                                            </strong></li>
                                                            <li class="style-li error-red">
                                                            <label id="created" class="error">${created }</label>
                                                            <label class="error visibility" id="stateIdError"> error</label>
                                                                  </li>
                                                        </ul>
                                                    </div>
<cf:select path="stateId" class="form-control" onchange="getDistrict(this.value);">
<cf:option value="0" label="Select State" />
<cf:options items="${stateList}" itemValue="stateId" itemLabel="stateName"/>
</cf:select>
                                                </div>
    <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>State Name:
                                                            <span style="color:red;">*</span>
                                                            </strong></li>
                                                            <li class="style-li error-red">
                                                            <label id="created" class="error"></label>
                                                            <label class="error visibility" id="stateIdError"> error</label>
                                                                  </li>
                                                        </ul>
                                                    </div>
<cf:select path="cityId" class="form-control">
<cf:option value="0"  label="Select City"/>
</cf:select>
                                                </div>
                                                                                              
                                                
                                                
                                            </div> <!-- left side ends -->

                                            <!-- right side -->
                                            <div class="col-xs-6">
                                                
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>District:</strong></li>
                                                            <li class="style-li error-red"></li>
                                                        </ul>
                                                    </div>
<cf:select path="districtId" class="form-control" onchange="getCity(this.value);">
<cf:option value="0" label="Select District" />
</cf:select>
                                                </div>
                                                <div class="form-group">
                                                    <div>
                                                        <ul class="lab-no">
                                                            <li class="style-li"><strong>Region Name:</strong></li>
                                                            <li class="style-li error-red"><label class="error visibility" id="regionNameError">* error</label></li>
                                                        </ul>
                                                    </div>
    <cf:input path="regionName"   placeholder="Region Name" class="form-control"   />
        
</div>
                                                <div class="form-group">
                                                    <button id="btnCreate" class="btn login-btn">Create</button>
                                                    
                                                       <a href="#testt" onclick="searchRegion();" class="pull-right">Search</a>
                                                </div>
                                            </div> <!-- rigth side ends -->
                                            
                                            <!-- button -->
                                            
                                          
                                        </div>

                                       
                                    </div>
                                </div>

                                <!-- search Results -->
                                <div class="col-xs-12 displayNone" id="show-result" aria-expanded="false" style="height: 0px;">
                                    
                                    <!-- table -->
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <fieldset>
                                                <legend>Search Result</legend>
                                                
                                                <table id="newTable" class="table table-bordered table-responsive">
                                                <thead>
                                                    <tr class="background-open-vacancies">
                                                        <th> </th>
                                                        <th>S.No.</th>                                                        
                                                        <th>Region Name</th>
                                                        <th>District</th>
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    
                                                </tbody>
                                            </table>
                                                
                                                <!-- + - buttons -->
                                               <!--  <div class="row">
                                                    <div class="col-md-6 col-xs-12">
                                                        <div style="width: 95px;">
                                                            <ul class="pager">
                                                                <li class="previous"><a href="#"><i class="fa fa-plus"></i></a></li>
                                                                <li class="next"><a href="#"><i class="fa fa-minus"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    
                                                    <div class="col-md-6 col-xs-12">
                                                        <button class="btn login-btn pull-right" style="margin-top: 20px;">Save</button>
                                                    </div>
                                                </div> -->
                                                
                                               
                                                
                                            </fieldset>
                                            
                                        </div>
                                    </div>
                                </div> <!-- search div ends -->

                            </div> <!-- row ends -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    </cf:form>