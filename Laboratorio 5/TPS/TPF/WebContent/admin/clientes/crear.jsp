<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>
<h1>Admin</h1>
<%@ include file="../../includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>

<form name="agregarUsuarioForm" action="ServerletAgregarUsuario" method="post" onsubmit="">
	<fieldset>
	    <legend>Datos Personales:</legend>
		<input type="text" name="nombre" placeholder="Nombre"><br>
		<input type="text" name="apellido" placeholder="Apellido"><br>
		<input type="text" name="dni" placeholder="12345678"><br>
		<input type="date" name="fechaNac" placeholder="dd/mm/aaaa"><br>
	</fieldset>
	<fieldset>
	    <legend>Datos Usuario:</legend>
		<input type="text" name="usuario" placeholder="nuevo usuario"><br>
		<input type="password" name="pass" placeholder="nueva contraseña"><br>
	</fieldset>
	<input type="submit" name="ingresar" value="Crear">
</form>

<%@ include file="../../includes/admin/footer.jsp" %>
</body>
</html>