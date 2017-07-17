<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>

<%@ include file="/includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>

<h1>Admin</h1>
<h2>Modificar Cuenta</h2>

<p>Ingresar numero de cuenta a modificar:</p>
<form name="buscarCuentaModificarForm" action="${pageContext.request.contextPath}/ServerletBuscarCuentaModificar" method="post" onsubmit="return validarBuscarCuentaModificar()">
	<input type="text" name="numCuenta" placeholder="12345678">
	<input type="submit" name="ingresar" value="Ingresar">
</form>
<p id="error">
<%
try{
	if (request.getAttribute("cuentaNoExiste") != null){
		out.println("La cuenta no existe.");
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