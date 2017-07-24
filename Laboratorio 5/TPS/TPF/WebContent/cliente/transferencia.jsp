<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/cliente/head.jsp" %>
<body>
<%@ include file="../includes/cliente/autenticacion.jsp" %>
<%@ include file="../includes/cliente/menu.jsp" %>
<h1>Cliente</h1>
<h2>Transferencias</h2>
<form name="formRealizarTransferencia" action="ServerletRealizarTransferencia" method="post" onsubmit="return validarRealizarTransferencia()">
	<select name="cuentasOrigen" placeholder="Cuenta de origen">
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