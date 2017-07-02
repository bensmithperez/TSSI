<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>

<%@ include file="/includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>
<h1>Admin</h1>
<h2>Modificar Cliente</h2>
<p>Ingresar cliente a modificar:</p>
<form name="buscarUsuarioModificarForm" action="${pageContext.request.contextPath}/ServerletBuscarUsuarioModificar" method="post" onsubmit="return validarBuscarUsuarioModificar()">
	<input type="text" name="dni" placeholder="12345678">
	<input type="submit" name="ingresar" value="Ingresar">
</form>
<p id="error">
<%
try{
	if (request.getAttribute("usuarioNoExiste") != null){
		out.println("Usuario no existe.");
	}
}
catch(Exception e){
	out.println("error");
}
%>
</p>

<form name="usuarioModificarForm" action="${pageContext.request.contextPath}/ServerletModificarUsuario" method="post" onsubmit="return validarUsuarioModificar()">

	<input type="text" name="nombre" placeholder="Nombre" value="${nombre}"><br>
	<input type="text" name="apellido" placeholder="Apellido" value="${apellido}"><br>
	<input type="text" name="fechaNac" placeholder="dd/mm/aaaa" value="${fechaNac}"><br>
	<br>
    <input type="text" name="id" placeholder="00" value="${id}" readonly="readonly"><br>
	<input type="text" name="usuario" placeholder="usuario" value="${usuario}" readonly="readonly"><br>

	<input type="submit" name="modificar" value="Modificar">
</form>

<p id="error1">
<%
try{
	if (session.getAttribute("errorModificarUsuario") != null){
		out.println("Hubo un error al modificar el usuario.");
	}
}
catch(Exception e){
	out.println("error");
}
%>
</p>

<a href="${cambiarContrasenia}">${cambiarContraseniaTexto}</a>
<%@ include file="../../includes/admin/footer.jsp" %>
</body>
</html>