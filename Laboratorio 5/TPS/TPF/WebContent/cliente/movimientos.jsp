<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/cliente/head.jsp" %>
<body>
<%@ include file="../includes/cliente/autenticacion.jsp" %>
<%@ include file="../includes/cliente/menu.jsp" %>
<h1>Cliente</h1>
<h2>Movimientos</h2>

<table>
	<tr><th>Cuenta</th><th>Tipo de movimiento</th><th>Fecha</th></tr>
	<%@ include file="../cliente/tablaMov.jsp" %>
</table>
<%@ include file="../includes/cliente/footer.jsp" %>
</body>
</html>