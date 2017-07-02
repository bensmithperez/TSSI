<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>
<h1>Admin</h1>
<h2>Borrar Cliente</h2>
<%@ include file="/includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>
<p>Ingresar cliente a borrar:</p>
<form name="buscarUsuarioBorrarForm" action="${pageContext.request.contextPath}/ServerletBuscarUsuarioBorrar" method="post" onsubmit="return validarBuscarUsuarioBorrar()">
	<input type="text" name="dni" placeholder="12345678">
	<input type="submit" name="ingresar" value="Ingresar">
</form>
<p id="error">
<%
try{
	if (session.getAttribute("usuarioNoExiste") != null){
		out.println("Usuario no existe.");
	}
}
catch(Exception e){
	out.println("error");
}
%>
</p>

<form name="usuarioBorrarForm" action="${pageContext.request.contextPath}/ServerletBorrarUsuario" method="post" onsubmit="return validarUsuarioBorrar()">

	<input type="text" name="nombre" placeholder="Nombre" value="${nombre}"><br>
	<input type="text" name="apellido" placeholder="Apellido" value="${apellido}"><br>
	<input type="text" name="fechaNac" placeholder="dd/mm/aaaa" value="${fechaNac}"><br>
	<br>
    <input type="text" name="id" placeholder="00" value="${id}" readonly="readonly"><br>
	<input type="text" name="usuario" placeholder="usuario" value="${usuario}" readonly="readonly"><br>

	<input type="submit" name="borrar" value="Borrar">
</form>

<p id="error1">
<%
try{
	if (session.getAttribute("errorBorrarUsuario") != null){
		out.println("Hubo un error al borrar el usuario.");
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