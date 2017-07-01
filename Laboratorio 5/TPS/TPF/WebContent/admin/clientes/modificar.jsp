<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>
<h1>Admin</h1>
<h2>Modificar Cliente</h2>
<%@ include file="/includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>

<form name="buscarUsuarioModificarForm" action="ServerletBuscarUsuarioModificar" method="post" onsubmit="return validarLogin("")">
	<input type="text" name="usuario" placeholder="usuario">
	<input type="password" name="pass" placeholder="contraseña">
	<input type="submit" name="ingresar" value="Ingresar">
</form>

<%@ include file="../../includes/admin/footer.jsp" %>
</body>
</html>