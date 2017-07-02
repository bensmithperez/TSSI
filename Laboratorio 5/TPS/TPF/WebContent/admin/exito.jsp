<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>

<%@ include file="../../includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>
<h1>Admin</h1>
<h2>Exito</h2>

<p id="exito">
<%
try{
	if (request.getAttribute("exitoModificarCliente") != null){
		out.println("El registro fue modificado exitosamente!");
	}
	if (request.getAttribute("exitoContraseniaCliente") != null){
		out.println("La contraseña fue modificada exitosamente!");
	}
	if (request.getAttribute("exitoBorrarCuenta") != null){
		out.println("La cuenta fue borrada con exito!");
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