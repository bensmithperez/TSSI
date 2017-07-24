function isNullOrWhitespace(input){
	if(typeof input === 'undefined' || input == null) return true;
	
	return input.replace(/\s/g,'').length < 1;
}

function esFechaValida(fecha){
	var fechaValida = "\d{2}\/\d{2}\/\d{4}";
	if (fechaValida.test(fecha)){
		return true;
	} else {
		return false;
	}
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
	var dni = document.forms["agregarUsuarioForm"]["dni"].value;
	if (numCuenta.length<8){
		document.getElementById("error").innerHTML = "dni invalido.";
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

function validarCuentaNueva(){
	if (hayCampoVacio("agregarCuentaForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
	var numCuenta = document.forms["agregarCuentaForm"]["numCuenta"].value;
	var monto = document.forms["agregarCuentaForm"]["monto"].value;
	if (numCuenta.length<13){
		document.getElementById("error").innerHTML = "Numero de cuenta invalido.";
		return false;
	}
	if (monto<0){
		document.getElementById("error").innerHTML = "Monto invalido.";
		return false;
	}
}

function validarBorrarCuenta(){
	if (hayCampoVacio("borrarCuentaForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
	var numCuenta = document.forms["borrarCuentaForm"]["numCuenta"].value;
	if (numCuenta.length<13){
		document.getElementById("error").innerHTML = "Numero de cuenta invalido.";
		return false;
	}

}

function validarBuscarCuentaModificar(){
	if(hayCampoVacio("buscarCuentaModificarForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
	var numCuenta = document.forms["buscarCuentaModificarForm"]["numCuenta"].value;
	if (numCuenta.length<13){
		document.getElementById("error").innerHTML = "Numero de cuenta invalido.";
		return false;
	}
}

function validarBuscarCuentaModificar(){
	if(hayCampoVacio("buscarCuentaModificarForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
	var numCuenta = document.forms["buscarCuentaModificarForm"]["numCuenta"].value;
	if (numCuenta.length<13){
		document.getElementById("error").innerHTML = "Numero de cuenta invalido.";
		return false;
	}
}

function validarAsociarCuenta(){
	if(hayCampoVacio("asociarCuentaForm")){
		document.getElementById("error").innerHTML = "Ingresar todos los datos.";
		return false;
	}
	var numCuenta = document.forms["asociarCuentaForm"]["numCuenta"].value;
	if (numCuenta.length<13){
		document.getElementById("error").innerHTML = "Numero de cuenta invalido.";
		return false;
	}
}

function validarServicioNuevo(){
	if (hayCampoVacio("agregarServicioForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
}

function validarBorrarServicio(){
	if (hayCampoVacio("borrarServicioForm")){
		document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
		return false;
	}
}