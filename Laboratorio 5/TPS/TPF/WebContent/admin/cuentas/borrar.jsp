<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>
<h1>Admin</h1>
<h2>Borrar Cuenta</h2>
<%@ include file="../../includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>

<form name="borrarCuentaForm" action="${pageContext.request.contextPath}/ServerletBorrarCuenta" method="post" onsubmit="return validarBorrarCuenta()">
	<input type="number" name="numCuenta" placeholder="Numero de Cuenta"><br>
	<input type="submit" name="ingresar" value="Borrar">
</form>
<p id="error">
<%
try{
	if (request.getAttribute("errorBorrarCliente") != null){
		out.println("Se produjo un error.");
	}
	if (request.getAttribute("cuentaCreada") != null){
		out.println("Cuenta creada!");
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