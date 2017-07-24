<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="controlador.sgb.benjismithperez.com.ControladorTransaccion"%>
<%@page import="modelo.sgb.benjismithperez.com.ModeloTransaccion"%>
<%@ page import="java.util.*" %>

<%@ include file="../includes/cliente/head.jsp" %>
<body>
<%@ include file="../includes/cliente/autenticacion.jsp" %>
<%@ include file="../includes/cliente/menu.jsp" %>
<h1>Cliente</h1>
<h2>Movimientos</h2>

<%
	List<ModeloTransaccion> listaTransacciones =  (List<ModeloTransaccion>) request.getAttribute("listaTransacciones");
%>
<table>
	<tr><th>Id Transaccion</th><th>Cuenta</th><th>Tipo de movimiento</th><th>Fecha</th></tr>
	<% for(ModeloTransaccion m : listaTransacciones) { %>
	<tr>
	<td> <%= m.getId() %> </td>
	<td> <%= m.getNumCuenta() %> </td>
	<td> <%= m.getIdTipo() == 0 ? "Transferencia" : "Pago de Servicio" %> </td>
	<td> <%= m.getFecha() %> </td>
	</tr>
	<%} %>
</table>

<%@ include file="../includes/cliente/footer.jsp" %>
</body>
</html>