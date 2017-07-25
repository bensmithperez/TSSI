<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="controlador.sgb.benjismithperez.com.ControladorCuenta"%>
<%@page import="modelo.sgb.benjismithperez.com.ModeloCuenta"%>
<%@page import="modelo.sgb.benjismithperez.com.ModeloServicio"%>
<%@ page import="java.util.*" %>
<%@ include file="../includes/cliente/head.jsp" %>
<body>
<%@ include file="../includes/cliente/autenticacion.jsp" %>
<%@ include file="../includes/cliente/menu.jsp" %>
<h1>Cliente</h1>
<h2>Pagar Servicios</h2>
<%
	List<ModeloCuenta> listaCuentas =  (List<ModeloCuenta>) request.getAttribute("listaCuentas");	
	List<ModeloServicio> listaServicios =  (List<ModeloServicio>) request.getAttribute("listaServicios");
%>
<form name="formPagarServicio" action="ServerletPagarServicio" method="post" onsubmit="return validarPagarServicio()">
	Cuenta de origen: <select name="cuentasOrigen">
	<% for(ModeloCuenta m : listaCuentas) { %>
		<option value="<%= m.getNumCuenta() %>"><%= m.getNumCuenta() + " (Saldo: " + m.getMonto() + ")"%></option>
		<%} %>
	</select><br>
	Servicio :<select name="servicio">
	<% for(ModeloServicio ms : listaServicios) { %>
		<option value="<%= ms.getId() %>"><%= ms.getDescripcion()%></option>
		<%} %>
	</select><br>
	<input type="number" name="monto" placeholder="monto"><br>
	<input type="submit" name="pagar" value="Pagar">
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
	if (request.getAttribute("exitoPago") != null){
		out.println("Servicio pagado!");
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