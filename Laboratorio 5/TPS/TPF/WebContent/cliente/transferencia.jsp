<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="controlador.sgb.benjismithperez.com.ControladorCuenta"%>
<%@page import="modelo.sgb.benjismithperez.com.ModeloCuenta"%>
<%@ page import="java.util.*" %>
<%@ include file="../includes/cliente/head.jsp" %>
<body>
<%@ include file="../includes/cliente/autenticacion.jsp" %>
<%@ include file="../includes/cliente/menu.jsp" %>
<h1>Cliente</h1>
<h2>Transferencias</h2>
<%
	List<ModeloCuenta> listaCuentas =  (List<ModeloCuenta>) request.getAttribute("listaCuentas");
%>
<form name="formRealizarTransferencia" action="ServerletRealizarTransferencia" method="post" onsubmit="return validarRealizarTransferencia()">
	Cuenta de origen: <select name="cuentasOrigen">
		<% for(ModeloCuenta m : listaCuentas) { %>
		<option value="<%= m.getNumCuenta() %>"><%= m.getNumCuenta() + " (Saldo: " + m.getMonto() + ")"%></option>
		<%} %>
	</select><br>
	<input type="number" name="cuentaDestino" placeholder="Cuenta de destino"><br>
	<input type="number" name="monto" placeholder="monto"><br>
	<input type="submit" name="transferir" value="Transferir">
</form>
<p id="error">
<%
try{
	if (request.getAttribute("error") != null){
		out.println("Se produjo un error.");
	}
	if (request.getAttribute("errorSaldo") != null){
		out.println("Saldo Insuficiente.");
	}
	if (request.getAttribute("exitoTransferencia") != null){
		out.println("Transferencia exitosa!");
	}
}
catch(Exception e){
	out.println("error");
}
%>
</p>
<%@ include file="../includes/cliente/footer.jsp" %>
</body>
</html>