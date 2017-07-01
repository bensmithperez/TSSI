function isNullOrWhitespace(input){
	if(typeof input === 'undefined' || input == null) return true;
	
	return input.replace(/\s/g,'').length < 1;
}

function validarLogin(){
	var usuario = document.forms["loginForm"]["usuario"].value;
	var pass = document.forms["loginForm"]["pass"].value;
	if (isNullOrWhitespace(usuario) || isNullOrWhitespace(pass)){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
}