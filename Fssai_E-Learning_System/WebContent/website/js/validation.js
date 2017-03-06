function allLetter(id, inputtxt) {
	// var letters = /^[A-Za-z]+$/; //With out Space
	var letters = /^[a-zA-Z\s]+$/; // With Space only
	
	if (inputtxt.length > 0) {
		if (inputtxt.match(letters)) {
			return true;
		} else {
			document.getElementById(id).value = "";
			alert('Please input alphabet characters only');
			return false;
		}
	}
}

function allnumeric(id, inputtxt) {
	var numbers = /^[0-9]+$/;
	if (inputtxt.length > 0) {
		if (inputtxt.match(numbers)) {
			return true;
		} else {
			document.getElementById(id).value = "";
			alert('Please input numeric characters only');
			return false;
		}
	}
}

function pan_validate(id, pan) {
	var regpan = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
	if (regpan.test(pan) == false) {
		document.getElementById(id).value = "";
		alert('INVALID PAN');
	}
	
}

/*$("#btnExport").click(function (e) {
	alert('sdf');
    window.open('data:application/vnd.ms-excel,' + $('#dvData').html());
    e.preventDefault();
});*/


$(document).ready(function() {
	/*var table = $(document).ready(function () {
        $("#stateMasterData").DataTable({
            "bAutoWidth": false
            , "bProcessing": true
            , "iDisplayLength": 5
            , "bPaginate": true
            , "sPaginationType": "full_numbers"
            , "bJQueryUI": true
            , "dom": 'Bfrtip'
            , "buttons": [
                'csv',

            ],
			"colReorder" : true,
        });
    });*/
	
    $("#btnExport").click(function(e) {
        //getting values of current time for generating the file name
        var dt = new Date();
        var day = dt.getDate();
        var month = dt.getMonth() + 1;
        var year = dt.getFullYear();
        var hour = dt.getHours();
        var mins = dt.getMinutes();
        var postfix = day + "." + month + "." + year + "_" + hour + "." + mins;
        //creating a temporary HTML link element (they support setting file names)
        var a = document.createElement('a');
        //getting data from our div that contains the HTML table
        var data_type = 'data:application/vnd.ms-excel';
        var table_div = document.getElementById('dvData');
        var table_html = table_div.outerHTML.replace(/ /g, '%20');
        a.href = data_type + ', ' + table_html;
        //setting the file name
        a.download = 'exported_table_' + postfix + '.xls';
        //triggering the function
        a.click();
        //just in case, prevent default behaviour
        e.preventDefault();
    });
});

function displayPreview(files) {

    var reader = new FileReader();
    var img = new Image();


    reader.onload = function (e) {
        img.src = e.target.result;
        fileSize = Math.round(files.size / 1024);
        alert("File size is " + fileSize + " kb");

        img.onload = function () {
            alert("width=" + this.width + " height=" + this.height);
            $('#preview').append('<img src="' + e.target.result + '"/>');
        };




    };
    reader.readAsDataURL(files);

}


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







