<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>

<%@ include file="/includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>
<h1>Admin</h1>
<h2>Asociar Cuenta</h2>

<p>Ingresar dni de cliente y numero de cuenta a asociarle:</p>
<form name="asociarCuentaForm" action="${pageContext.request.contextPath}/ServerletAsociarCuenta" method="post" onsubmit="return validarAsociarCuenta()">
	<input type="number" name="dni" placeholder="dni"><br>
	<input type="number" name="numCuenta" placeholder="número de cuenta"><br>
	<input type="submit" name="asociar" value="Asociar cuenta">
</form>
<p id="error">
<%
try{
	if (request.getAttribute("error") != null){
		out.println(request.getAttribute("error"));
	}
	if (request.getAttribute("exito") != null){
		out.println("Cuenta asociada correctamente!");
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