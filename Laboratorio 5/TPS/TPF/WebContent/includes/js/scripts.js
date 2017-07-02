function isNullOrWhitespace(input){
	if(typeof input === 'undefined' || input == null) return true;
	
	return input.replace(/\s/g,'').length < 1;
}

function hayCampoVacio(nombreForm){
	var elements = document.forms[nombreForm].elements;
//	console.log(elements);
	for (var i = 0; i < elements.length; i++) {
		console.log(elements[i]);
		console.log(elements[i].value);
		
		if (isNullOrWhitespace(elements[i].value)){
			console.log("vacio!");
			return true;
		}
		console.log("tiene algo");
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
	console.log("en validar usuario");
	if (hayCampoVacio("agregarUsuarioForm")){
		console.log("encontré dato vacio");
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

function validarUsuarioModificar(){
	if (hayCampoVacio("usuarioModificarForm")){
		document.getElementById("error1").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
}

function validarCambiarContrasenia(){
	if (hayCampoVacio("cambiarContraseniaUsuarioForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
}

function validarBuscarUsuarioBorrar(){
	if (hayCampoVacio("buscarUsuarioBorrarForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
}

function validarUsuarioBorrar(){
	if (hayCampoVacio("usuarioBorrarForm")){
		document.getElementById("error1").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
}