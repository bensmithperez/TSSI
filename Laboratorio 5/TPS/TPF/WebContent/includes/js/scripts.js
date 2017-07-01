function isNullOrWhitespace(input){
	if(typeof input === 'undefined' || input == null) return true;
	
	return input.replace(/\s/g,'').length < 1;
}

function hayCampoVacio(nombreForm){
	var elements = document.forms[nombreForm].elements;

	for (var i = 0, element; element = elements[i++];) {
		if (isNullOrWhitespace(element.value))
			return true;
	}
	return false;
}

function validarLogin(){
	if (hayCampoVacio("loginForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
}

function validarUsuarioNuevo(){
	if (hayCampoVacio("agregarUsuarioForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
}

function validarBuscarUsuarioModificar(){
	if (hayCampoVacio("buscarUsuarioModificarForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
}