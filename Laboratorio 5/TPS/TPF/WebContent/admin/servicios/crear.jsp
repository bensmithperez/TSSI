<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>

<%@ include file="/includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>
<h1>Admin</h1>
<h2>Crear Servicio</h2>
<form name="agregarServicioForm" action="${pageContext.request.contextPath}/ServerletAgregarServicio" method="post" onsubmit="return validarServicioNuevo()">
	<input type="text" name="descripcion" placeholder="descripcion"><br>
	<input type="submit" name="crear" value="Crear">
</form>
<p id="error">
<%
try{
	if (request.getAttribute("errorS") != null){
		out.println("Se produjo un error.");
	}
	if (request.getAttribute("servicioCreado") != null){
		out.println("Servicio creado!");
	}
}
catch(Exception e){
	out.println("error");
}
%>
</p>
</body>
</html>