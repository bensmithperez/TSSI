<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/cliente/head.jsp" %>
<body>
<%@ include file="../includes/cliente/autenticacion.jsp" %>
<%@ include file="../includes/cliente/menu.jsp" %>
<h1>Cliente</h1>
<h2>Pagar Servicios</h2>
<form name="formPagarServicio" action="ServerletPagarServicio" method="post" onsubmit="return validarPagarServicio()">
	Cuenta de origen: <select name="cuentasOrigen">
	</select><br>
	Servicio :<select name="servicio">
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
	if (request.getAttribute("servicioPago") != null){
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