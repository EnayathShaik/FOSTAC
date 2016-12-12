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
