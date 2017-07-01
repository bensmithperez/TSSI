<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>
<h1>Admin</h1>
<h2>Crear Cliente</h2>
<%@ include file="../../includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>

<form name="agregarUsuarioForm" action="${pageContext.request.contextPath}/ServerletAgregarUsuario" method="post" onsubmit="return validarUsuarioNuevo()">

	<input type="text" name="nombre" placeholder="Nombre"><br>
	<input type="text" name="apellido" placeholder="Apellido"><br>
	<input type="text" name="dni" placeholder="12345678"><br>
	<input type="text" name="fechaNac" placeholder="dd/mm/aaaa"><br>
	<br>
	<input type="text" name="usuario" placeholder="nuevo usuario"><br>
	<input type="password" name="pass" placeholder="nueva contraseña"><br>

	<input type="submit" name="ingresar" value="Crear">
</form>
<p id="error">
<%
try{
	if (session.getAttribute("errorCU") != null){
		out.println("Se produjo un error.");
	}
	if (session.getAttribute("usuarioCreado") != null){
		out.println("Usuario creado!");
	}
}
catch(Exception e){
	out.println("error");
}
%>
</p>
<%@ include file="../../includes/admin/footer.jsp" %>
</body>
</html>