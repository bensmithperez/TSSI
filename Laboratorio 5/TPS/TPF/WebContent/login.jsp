<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SGB</title>
<script>
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
</script>
</head>
<body>
<h1>Login</h1>
<form name="loginForm" action="ServerletLogin" method="post" onsubmit="return validarLogin()">
	<input type="text" name="usuario" placeholder="usuario">
	<input type="password" name="pass" placeholder="contraseña">
	<input type="submit" name="ingresar" value="Ingresar">
</form>
<p id="error">
<%
try{
	if (request.getAttribute("error") != null){
		out.println("Usuario o contraseña incorrecto.");
	}
}
catch(Exception e){
	out.println("error");
}
%>
</p>
</body>
</html>