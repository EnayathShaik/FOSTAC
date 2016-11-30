<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  <link rel="stylesheet" type="text/css" href="./stylesheet/pmsstyle.css">-->
<style type="text/css">
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 10px 25px;
    text-align: center;
    text-decoration: none;
    font-size: 14px;
}
</style>
<title>Login Form</title>
<script language="javascript" type="text/javascript">
function validateFields() {
if(document.getElementById("user_id").value=="") {
alert("Please enter user id.");
document.getElementById("user_id").focus();
return false;
}
if(document.getElementById("otp").value=="") {
alert("Please enter otp.");
document.getElementById("otp").focus();
return false;
}
if(document.getElementById("txtcaptcha").value=="") {
alert("Please enter captcha code.");
document.getElementById("txtcaptcha").focus();
return false;
}
return true;
}
/*
function callServlet() {
	var user_id = document.getElementById("user_id").value;
	if(user_id=="") {
	alert("Please enter user id.");
	document.getElementById("user_id").focus();
	return false;
	}else
	document.location.href="loginProcess?user_id="+user_id+"&requestForm="+"forgotPassword";
}

/*
  * creates a new XMLHttpRequest object which is the backbone of AJAX,
  * or returns false if the browser doesn't support it
  */
 function getXMLHttpRequest() {
 	var xmlHttpReq = false;
 	// to create XMLHttpRequest object in non-Microsoft browsers
 	if (window.XMLHttpRequest) {
 		xmlHttpReq = new XMLHttpRequest();
 	} else if (window.ActiveXObject) {
 		try {
 			// to create XMLHttpRequest object in later versions
 			// of Internet Explorer
 			xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
 		} catch (exp1) {
 			try {
 				// to create XMLHttpRequest object in older versions
 				// of Internet Explorer
 				xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
 			} catch (exp2) {
 				xmlHttpReq = false;
 			}
 		}
 	}
 	return xmlHttpReq;
 } 
function onCheck() {
if(document.getElementById("user_id").value=="") {
alert("Please enter user id.");
document.getElementById("myCheck").checked = false;
document.getElementById("user_id").focus();
return false;
}
var x = document.getElementById('myCheck');
    if(x.checked ) {
        var xmlHttpRequest = getXMLHttpRequest();
    	var url= "./otp";  
    	url += "?user_id=" +document.getElementById("user_id").value+"&str="+"loginotp";  	
    	xmlHttpRequest.open("POST", url, false);
 		xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 		xmlHttpRequest.send(null);
 		if(xmlHttpRequest.responseText=="invalid") {
 		alert("Invalid User");
 		document.getElementById("myCheck").checked = false;
 		document.getElementById("user_id").value="";
 		document.getElementById("user_id").focus();
 		}else{			
        document.getElementById('otp1').style.display='table-row';
        document.getElementById('myCheck').disabled='true';
        }
    } else {
        document.getElementById('otp1').style.display='none';
    }
    return true;
}
</script>
<style type="text/css">
html, 
body {
height: 100%;
}

body {
background-image: url(img/rlyparcel.jpg);
background-repeat: no-repeat;
background-size: 100% 100%;
height: 100%;
}
</style>
</head>
<body>
    <form name="myForm" action="loginProcess" method="post" onsubmit="return validateFields()">
    <br><br><br><br> 
    <TABLE WIDTH=500 cellSpacing=1 cellPadding=3 align=center border=0 style="border-collapse: collapse; border: 1px solid black;">
	<tr bgcolor=#04B8C6>
		<td width="10%" align="left"><img src="img/rly-logo1.jpg" style="width:50px; height:50px; align : left;"></td>
    	<td align="center"><font color="white" size="+2"><b>User Login Form</b></font></td>
    	<td width="10%" align="right"><img src="img/indianrail_logo1.jpg" style="width:50px; height:50px; align : left;"></td>
    </tr>
    <tr  bgcolor=#d1a020>
    <td colspan="2">
    <input type="button" name="submit" id="submit" onclick="window.location.href='./parcelhome.jsp'" value="Back to Parcel Website" class="button"/>
    <input type="button" name="submit" id="submit" onclick="window.location.href='./register.jsp'" value="New Registration" class="button"/>
    </td>
    <td></td>
    </tr>
	<!-- Start of Input form -->
	<tr>
	  <td colspan="3">
	    <table border=0 width="100%" style="border-collapse: collapse;">
	        <tr bgcolor=#efefef> 
 		       <td align="right">User Id:</td>
 		       <td><input type="text" name="user_id" id="user_id" value='' maxlength="10" /></td>
 		       <td><input type="checkbox" id="myCheck" onclick="onCheck();"/>Generate OTP</td>
	       </tr>	

           <tr id="otp1" style="display: none;" bgcolor=#efefef>   
  		       <td align="right">Enter OTP&nbsp;:</td>
  		       <td><input type="password" name="otp" id="otp" maxlength="6"/></td>
  		       <td></td>
	       </tr>
	  
           <tr bgcolor=#efefef>
				<td></td>
				<td align="left"><img src="./Captcha.jpg" name="imgcaptcha"></img></td>
				<td></td>
		   </tr>

		   <tr bgcolor=#efefef>
				<td align="right">
				<input type="button" value="Refresh Captcha" onclick="window.document.myForm.imgcaptcha.src='';window.document.myForm.imgcaptcha.src='./Captcha.jpg?random='+new Date().getTime();"></td>
				<td><input type="text" name="txtcaptcha" id="txtcaptcha" value='' maxlength="10" /></td>
				<td></td>
		   </tr>

		</table>
		</td>
	</tr>
<!-- End of Input form -->
    <tr bgcolor=#04B8C6>
    	<td colspan="3" align="center">
    	
    	&nbsp;<input type="submit" name="submit" id="submit" value="Login" class="button"/>	
	</td>
	</tr>
<!--  
<tr>
<td align="right" colspan="3"><a href="#" onclick="callServlet();"><b>Forgot password?</b></a>&nbsp;<a href="./changePassword.jsp"><b>Change Password</b></a></td>
</tr>
-->	
</TABLE>
<input type="hidden" name="requestForm" id="requestForm" value="login" />
</form>
</body>
</html>