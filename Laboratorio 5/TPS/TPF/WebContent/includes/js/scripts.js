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

function validarUsuarioNuevo(){
	var nombre = document.forms["agregarUsuarioForm"]["nombre"].value;
	var apellido = document.forms["agregarUsuarioForm"]["apellido"].value;
	var dni = document.forms["agregarUsuarioForm"]["dni"].value;
	var fechaNac = document.forms["agregarUsuarioForm"]["fechaNac"].value;
	var usuario = document.forms["agregarUsuarioForm"]["usuario"].value;
	var pass = document.forms["agregarUsuarioForm"]["pass"].value;
	if (isNullOrWhitespace(nombre) || 
		isNullOrWhitespace(apellido) ||
		isNullOrWhitespace(dni) ||
		isNullOrWhitespace(fechaNac) ||
		isNullOrWhitespace(usuario) ||
		isNullOrWhitespace(pass)){
			document.getElementById("error").innerHTML = "Es necesario completar todos los campos.";
			return false;
	}
}