function allLetter(id, inputtxt) {
	var letters = /^[A-Za-z]+$/;
	if (inputtxt.match(letters)) {
		return true;
	} else {
		document.getElementById(id).value = "";
		alert('Please input alphabet characters only');
		return false;
	}
}

function allnumeric(id, inputtxt) {
	var numbers = /^[0-9]+$/;
	if (inputtxt.match(numbers)) {
		return true;
	} else {
		document.getElementById(id).value = "";
		alert('Please input numeric characters only');
		return false;
	}
}