<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>
<h1>Admin</h1>
<h2>Modificar Cliente</h2>

<%@ include file="/includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>

<p>Cambiar contrase�a:</p>

<form name="cambiarContraseniaUsuarioForm" action="${pageContext.request.contextPath}/ServerletCambiarContrase�a" method="post" onsubmit="return validarCambiarContrasenia()">
	<input type="text" name="id" placeholder="${param.usuario}" disabled>
	<input type="password" name="pass" placeholder="nueva contrase�a">
	<input type="submit" name="cambiar" value="Cambiar">
</form>
<p id="error"></p>

<%@ include file="../../includes/admin/footer.jsp" %>
</body>
</html>