<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SGB</title>
<script src="includes/js/scripts.js"></script>
</head>
<body>
<h1>Login</h1>
<form name="loginForm" action="ServerletLogin" method="post" onsubmit="return validarLogin()">
	<input type="text" name="usuario" placeholder="usuario">
	<input type="password" name="pass" placeholder="contraseņa">
	<input type="submit" name="ingresar" value="Ingresar">
</form>
<p id="error">
<%
try{
	if (session.getAttribute("usuarioIncorrecto") != null){
		out.println("Usuario o contraseņa incorrecto.");
	}
}
catch(Exception e){
	out.println("error");
}
%>
</p>

</body>
</html>