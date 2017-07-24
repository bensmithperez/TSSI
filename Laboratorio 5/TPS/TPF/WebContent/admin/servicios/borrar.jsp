<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>

<%@ include file="/includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>

<h1>Admin</h1>
<h2>Borrar Servicio</h2>
<form name="borrarServicioForm" action="${pageContext.request.contextPath}/ServerletBorrarServicio" method="post" onsubmit="return validarBorrarServicio()">
	<input type="text" name="descripcion" placeholder="descripcion"><br>
	<input type="submit" name="borrar" value="Borrar">
</form>
<p id="error">
<%
try{
	if (request.getAttribute("errorB") != null){
		out.println("Se produjo un error.");
	}
	if (request.getAttribute("servicioBorrado") != null){
		out.println("Servicio borrado!");
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