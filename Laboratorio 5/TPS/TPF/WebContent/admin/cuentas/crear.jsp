<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>

<%@ include file="../../includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>
<h1>Admin</h1>
<h2>Crear Cuenta</h2>

<form name="agregarCuentaForm" action="${pageContext.request.contextPath}/ServerletAgregarCuenta" method="post" onsubmit="return validarCuentaNueva()">

	<input type="number" name="numCuenta" placeholder="Numero de Cuenta"><br>
	<input type="number" name="monto" placeholder="Monto Inicial"><br>
	<input type="submit" name="ingresar" value="Crear">
</form>
<p id="error">
<%
try{
	if (request.getAttribute("errorC") != null){
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